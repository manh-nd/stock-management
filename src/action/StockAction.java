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
import dao.StockDao;
import dao.impl.StockDaoImpl;
import model.Stock;
import util.WebUtil;

@ParentPackage("default")
@Namespace("/stock")
@ResultPath("/")
public class StockAction extends ActionSupport implements IAction {

	private static final long serialVersionUID = 8493665757717540594L;

	private StockDao stockDao = new StockDaoImpl();

	@Valid
	private Stock stockBean = new Stock();

	@Action(value = "list", results = @Result(name = SUCCESS, location = Page.STOCK_LIST_PAGE))
	public String list() {
		System.out.println("stock list");
		return SUCCESS;
	}

	@Action(value = "add", results = @Result(name = SUCCESS, location = Page.STOCK_FORM_PAGE))
	public String add() {
		return SUCCESS;
	}

	@Action(value = "edit", results = @Result(name = SUCCESS, location = Page.STOCK_FORM_PAGE))
	public String edit() {
		Integer id = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("id"));
		stockBean = stockDao.findById(id);
		return SUCCESS;
	}

	@Action(value = "delete", results = @Result(name = SUCCESS, location = "list", type = "redirect"))
	public String delete() {
		Integer id = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("id"));
		stockBean = stockDao.findById(id);
		stockDao.delete(stockBean);
		return SUCCESS;
	}

	@Action(value = "save", interceptorRefs = @InterceptorRef("defaultStackHibernateStrutsValidation"), results = {
			@Result(name = SUCCESS, location = "list", type = "redirect"),
			@Result(name = INPUT, location = Page.STOCK_FORM_PAGE) })
	public String save() {
		// add
		Integer id = stockBean.getId();
		if (id == null) {
			if (stockDao.findByName(stockBean.getName()) != null) {
				addFieldError("stockBean.name", "Tên nhà sản xuất đã tồn tại. Vui lòng kiểm tra lại!");
				return INPUT;
			}
		} else { // update
			String formName = stockBean.getName();
			String currentName = stockDao.findNameById(id);
			if (!formName.equalsIgnoreCase(currentName)) { // Không trùng với tên hiện tại
				if (stockDao.isDuplicateAnotherName(formName, id)) {
					addFieldError("stockBean.name", "Tên nhà sản xuất đã tồn tại.");
					return INPUT;
				}
			}
		}
		stockDao.saveOrUpdate(stockBean);
		return SUCCESS;
	}

	
	@Action(value = "existsStockCode", results = @Result(name = SUCCESS, type = "json"))
	public String existsStockCode() {
		String stockCode = WebUtil.getHttpServletRequest().getParameter("stockCode");
		stockBean = stockDao.findByCode(stockCode);
		return SUCCESS;
	}
	
	public Stock getStockBean() {
		return stockBean;
	}

	public void setStockBean(Stock stockBean) {
		this.stockBean = stockBean;
	}

	public List<Stock> getStockList() {
		return stockDao.findAll(true);
	}

	@JSON(serialize = false)
	public Boolean getDefaultActiveValue() {
		if (stockBean.getActive() == null) {
			stockBean.setActive(true);
		}
		return stockBean.getActive();
	}
	
	public Map<Boolean, String> getActives() {
		HashMap<Boolean, String> actives = new HashMap<>();
		actives.put(true, "Hoạt động");
		actives.put(false, "Tạm dừng");
		return actives;
	}

	@Override
	public void validate() {
		System.out.println("Validate Stock...");
	}

}
