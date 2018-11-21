package action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.hibernate.validator.Valid;

import com.opensymphony.xwork2.ActionSupport;

import dao.SupplierDao;
import dao.impl.SupplierDaoImpl;
import model.Supplier;
import util.WebUtil;

@ParentPackage("supplier-package")
@Namespace("/supplier")
@ResultPath("/")
public class SupplierAction extends ActionSupport  implements IAction  {

	private static final long serialVersionUID = 8493665757717540594L;

	private SupplierDao supplierDao = new SupplierDaoImpl();

	@Valid
	private Supplier supplierBean = new Supplier();

	@Action(value = "list", results = @Result(name = SUCCESS, location = "/WEB-INF/pages/supplier/supplier_list.jsp"))
	public String list() {
		System.out.println("supplier list");
		return SUCCESS;
	}

	@Action(value = "add", results = @Result(name = SUCCESS, location = "/WEB-INF/pages/supplier/supplier_form.jsp"))
	public String add() {
		return SUCCESS;
	}

	@Action(value = "edit", results = @Result(name = SUCCESS, location = "/WEB-INF/pages/supplier/supplier_form.jsp"))
	public String edit() {
		Integer id = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("id"));
		supplierBean = supplierDao.findById(id);
		return SUCCESS;
	}

	@Action(value = "delete", results = @Result(name = SUCCESS, location = "list", type = "redirect"))
	public String delete() {
		Integer id = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("id"));
		supplierBean = supplierDao.findById(id);
		supplierDao.delete(supplierBean);
		return SUCCESS;
	}

	@Action(value = "save", interceptorRefs = @InterceptorRef("defaultStackHibernateStrutsValidation"), results = {
			@Result(name = SUCCESS, location = "list", type = "redirect"),
			@Result(name = INPUT, location = "/WEB-INF/pages/supplier/supplier_form.jsp") })
	public String save() {
		System.out.println(supplierBean);
		supplierDao.saveOrUpdate(supplierBean);
		return SUCCESS;
	}

	public Supplier getSupplierBean() {
		return supplierBean;
	}

	public void setSupplierBean(Supplier supplierBean) {
		this.supplierBean = supplierBean;
	}

	public List<Supplier> getSupplierList() {
		return supplierDao.findAll();
	}
	
	@Override
	public void validate() {
		System.err.println("Validate Supplier.....");
	}

}
