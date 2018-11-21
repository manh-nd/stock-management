package action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

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

	private Producer producerBean = new Producer();
	private ProducerDao producerDao = new ProducerDaoImpl();

	private List<Producer> producerList;

	@Action(value = "list", results = @Result(name = SUCCESS, location = Page.PRODUCER_LIST_PAGE))
	@Override
	public String list() {
		producerList = producerDao.findAll(Producer.class);
		return SUCCESS;
	}

	@Action(value = "add", results = @Result(name = SUCCESS, location = Page.PRODUCER_FORM_PAGE))
	@Override
	public String add() {
		return SUCCESS;
	}

	@Action(value = "save", interceptorRefs = @InterceptorRef("defaultStackHibernateStrutsValidation"), results = {
			@Result(name = SUCCESS, location = "list", type = "redirect"),
			@Result(name = INPUT, location = Page.PRODUCER_LIST_PAGE) })
	@Override
	public String save() {
		producerDao.saveOrUpdate(producerBean);
		return SUCCESS;
	}

	@Action(value = "editProducer", results = { @Result(name = SUCCESS, location = Page.PRODUCER_FORM_PAGE), })
	@Override
	public String edit() {
		Integer id = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("id"));
		producerBean = producerDao.findById(Producer.class, id);
		System.out.println("EDIT" + producerBean);
		return SUCCESS;
	}
	
	@Action(value = "deleteProducer", results = { @Result(name = SUCCESS, location = Page.PRODUCER_LIST_PAGE), })
	@Override
	public String delete() {
		Integer id = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("id"));
		producerBean = producerDao.findById(Producer.class, id);
		producerDao.delete(producerBean);
		producerList = producerDao.findAll(Producer.class);
		return SUCCESS;
	}

	public Producer getProducerBean() { // làm việc với producerBean bỏ "get" trong ProducerBean
		return producerBean;
	}

	public void setProducerBean(Producer producerBean) { // setMauLol => mauLol
		this.producerBean = producerBean;
	}

	public List<Producer> getProducerList() {
		return producerList;
	}

}
