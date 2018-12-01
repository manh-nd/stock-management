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
import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import model.Category;
import util.WebUtil;

@ParentPackage("default")
@Namespace("/category")
@ResultPath("/")
public class CategoryAction extends ActionSupport implements IAction {

	private static final long serialVersionUID = 8493665757717540594L;

	private CategoryDao categoryDao = new CategoryDaoImpl();
	private Boolean existsGoods;

	@Valid
	private Category categoryBean = new Category();

	@Action(value = "list", results = @Result(name = SUCCESS, location = Page.CATEGORY_LIST_PAGE))
	public String list() {
		System.out.println("category list");
		return SUCCESS;
	}

	@Action(value = "add", results = @Result(name = SUCCESS, location = Page.CATEGORY_FORM_PAGE))
	public String add() {
		return SUCCESS;
	}

	@Action(value = "edit", results = @Result(name = SUCCESS, location = Page.CATEGORY_FORM_PAGE))
	public String edit() {
		Integer id = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("id"));
		categoryBean = categoryDao.findById(id);
		return SUCCESS;
	}

	@Action(value = "delete", results = @Result(name = SUCCESS, location = "list", type = "redirect"))
	public String delete() {
		Integer id = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("id"));
		categoryBean = categoryDao.findById(id);
		categoryDao.delete(categoryBean);
		return SUCCESS;
	}

	@Action(value = "save", interceptorRefs = @InterceptorRef("defaultStackHibernateStrutsValidation"), results = {
			@Result(name = SUCCESS, location = "list", type = "redirect"),
			@Result(name = INPUT, location = Page.CATEGORY_FORM_PAGE) })
	public String save() {
		if(categoryDao.findByName(categoryBean.getName()) != null) {
			addFieldError("categoryBean.name", "Tên chủng loại đã tồn tại. Vui lòng kiểm tra lại!");
			return INPUT;
		}
		categoryDao.saveOrUpdate(categoryBean);
		return SUCCESS;
	}

	@Action(value = "existsCategoryCode", results = @Result(name = SUCCESS, type = "json"))
	public String existsGoodsCode() {
		String categoryCode = WebUtil.getHttpServletRequest().getParameter("categoryCode");
		categoryBean = categoryDao.findByCode(categoryCode);
		return SUCCESS;
	}

	@Action(value = "existsCategoryId", results = @Result(name = SUCCESS, type = "json"))
	public String existsGoodsId() {
		Integer categoryId = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("categoryId"));
		existsGoods = categoryDao.existsGoods(categoryId);
		return SUCCESS;
	}
	
	@JSON(serialize = false)
	public Boolean getDefaultActiveValue() {
		if (categoryBean.getActive() == null) {
			categoryBean.setActive(true);
		}
		return categoryBean.getActive();
	}
	
	public Boolean getExistsGoods() {
		return existsGoods;
	}
	public Category getCategoryBean() {
		return categoryBean;
	}

	public void setCategoryBean(Category categoryBean) {
		this.categoryBean = categoryBean;
	}

	public List<Category> getCategoryList() {
		return categoryDao.findAll(true);
	}
	
	public Map<Boolean, String> getActives() {
		HashMap<Boolean, String> actives = new HashMap<>();
		actives.put(true, "Hoạt động");
		actives.put(false, "Tạm dừng");
		return actives;
	}

}
