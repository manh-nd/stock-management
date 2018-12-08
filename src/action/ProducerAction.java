package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.validator.Valid;

import com.opensymphony.xwork2.ActionSupport;

import constant.Page;
import dao.ProducerDao;
import dao.impl.ProducerDaoImpl;
import model.Producer;
import util.WebUtil;

@ParentPackage("default")
@Namespace("/producer")
@ResultPath("/")
public class ProducerAction extends ActionSupport implements IAction {

	private static final long serialVersionUID = -5252328907327276691L;

	@Valid
	private Producer producerBean = new Producer();
	private ProducerDao producerDao = new ProducerDaoImpl();

	private Boolean existsGoods;

	@Action(value = "list", results = @Result(name = SUCCESS, location = Page.PRODUCER_LIST_PAGE))
	@Override
	public String list() {
		return SUCCESS;
	}
	
	@Action(value = "add", results = @Result(name = SUCCESS, location = Page.PRODUCER_FORM_PAGE))
	@Override
	public String add() {
		return SUCCESS;
	}

	@Action(value = "edit", results = { @Result(name = SUCCESS, location = Page.PRODUCER_FORM_PAGE), })
	@Override
	public String edit() {
		Integer id = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("id"));
		producerBean = producerDao.findById(id);
		System.out.println("EDIT" + producerBean);
		return SUCCESS;
	}

	@Action(value = "save", interceptorRefs = @InterceptorRef("defaultStackHibernateStrutsValidation"), results = {
			@Result(name = SUCCESS, location = "list", type = "redirect"),
			@Result(name = INPUT, location = Page.PRODUCER_FORM_PAGE) })
	@Override
	public String save() {
		// add
		Integer id = producerBean.getId();
		if (id == null) {
			if (producerDao.findByName(producerBean.getName()) != null) {
				addFieldError("producerBean.name", "Tên nhà sản xuất đã tồn tại. Vui lòng kiểm tra lại!");
				return INPUT;
			}
		} else { // update
			String formName = producerBean.getName();
			String currentName = producerDao.findNameById(id);
			if (!formName.equalsIgnoreCase(currentName)) { // Không trùng với tên hiện tại
				if(producerDao.isDuplicateAnotherName(formName, id)) {
					addFieldError("producerBean.name", "Tên nhà sản xuất đã tồn tại.");
					return INPUT;
				}
			}
		}
		producerDao.saveOrUpdate(producerBean);
		return SUCCESS;
	}

	@Action(value = "delete", results = { @Result(name = SUCCESS, location = "list", type = "redirect") })
	@Override
	public String delete() {
		System.err.println("delete");
		Integer id = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("id"));
		producerBean = producerDao.findById(id);
		producerDao.delete(producerBean);
		return SUCCESS;
	}

	@Action(value = "existsProducerCode", results = @Result(name = SUCCESS, type = "json"))
	public String existsGoodsCode() {
		String proCode = WebUtil.getHttpServletRequest().getParameter("producerCode");
		producerBean = producerDao.findByCode(proCode);
		return SUCCESS;
	}

	@Action(value = "existsProducerId", results = @Result(name = SUCCESS, type = "json"))
	public String existsGoodsId() {
		Integer producerId = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("producerId"));
		existsGoods = producerDao.existsGoods(producerId);
		return SUCCESS;
	}

	@JSON(serialize = false)
	public Boolean getDefaultActiveValue() {
		if (producerBean.getActive() == null) {
			producerBean.setActive(true);
		}
		return producerBean.getActive();
	}

	public Producer getProducerBean() {
		return producerBean;
	}

	public void setProducerBean(Producer producerBean) {
		this.producerBean = producerBean;
	}

	public List<Producer> getProducerList() {
		String find = WebUtil.getHttpServletRequest().getParameter("find");
		if (find != null) {
			return producerDao.findAll(find, true);
		} else {
			return producerDao.findAll(true);
		}
	}

	public Map<Boolean, String> getActives() {
		HashMap<Boolean, String> actives = new HashMap<>();
		actives.put(true, "Hoạt động");
		actives.put(false, "Tạm dừng");
		return actives;
	}

	public Boolean getExistsGoods() {
		return existsGoods;
	}

	public void setExistsGoods(Boolean existsGoods) {
		this.existsGoods = existsGoods;
	}

	@Override
	public void validate() {
		System.out.println("Validate Producer....");
	}
}
