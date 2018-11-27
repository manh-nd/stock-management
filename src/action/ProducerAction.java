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
import org.hibernate.validator.Valid;

import com.opensymphony.xwork2.ActionSupport;

import constant.Page;
import dao.ProducerDao;
import dao.impl.ProducerDaoImpl;
import model.Producer;
import util.WebUtil;

@ParentPackage("producer-package")
@Namespace("/producer")
@ResultPath("/")
public class ProducerAction extends ActionSupport implements IAction {

	private static final long serialVersionUID = -5252328907327276691L;

	@Valid
	private Producer producerBean = new Producer();
	private ProducerDao producerDao = new ProducerDaoImpl();

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

	@Action(value = "save", interceptorRefs = @InterceptorRef("defaultStackHibernateStrutsValidation"), results = {
			@Result(name = SUCCESS, location = "list", type = "redirect"),
			@Result(name = INPUT, location = Page.PRODUCER_FORM_PAGE) })
	@Override
	public String save() {
		System.out.println("Producer Bean: " + producerBean);
		producerDao.saveOrUpdate(producerBean);
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

	@Action(value = "delete", results = { @Result(name = SUCCESS, location = "list", type = "redirect") })
	@Override
	public String delete() {
		Integer id = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("id"));
		producerBean = producerDao.findById(id);
		producerDao.delete(producerBean);
		return SUCCESS;
	}

	public Producer getProducerBean() { 
		return producerBean;
	}

	public void setProducerBean(Producer producerBean) {
		this.producerBean = producerBean;
	}

	public List<Producer> getProducerList() {
		return producerDao.findAll(true);
	}
	
	public Map<Boolean, String> getActives() {
		HashMap<Boolean, String> actives = new HashMap<>();
		actives.put(true, "Hoạt động");
		actives.put(false, "Tạm dừng");
		return actives;
	}

	@Override
	public void validate() {
		System.out.println("Validate Producer....");
	}
}
