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

import dao.StockDao;
import dao.impl.StockDaoImpl;
import model.Stock;
import util.WebUtil;

@ParentPackage("stock-package")
@Namespace("/stock")
@ResultPath("/")
public class StockAction extends ActionSupport {

	private static final long serialVersionUID = 8493665757717540594L;

	private StockDao stockDao = new StockDaoImpl();

	@Valid
	private Stock stockBean = new Stock();

	@Action(value = "list", results = @Result(name = SUCCESS, location = "/WEB-INF/pages/stock/stock_list.jsp"))
	public String list() {
		System.out.println("stock list");
		return SUCCESS;
	}

	@Action(value = "add", results = @Result(name = SUCCESS, location = "/WEB-INF/pages/stock/stock_form.jsp"))
	public String add() {
		return SUCCESS;
	}

	@Action(value = "edit", results = @Result(name = SUCCESS, location = "/WEB-INF/pages/stock/stock_form.jsp"))
	public String edit() {
		Integer id = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("id"));
		stockBean = stockDao.findById(Stock.class, id);
		return SUCCESS;
	}

	@Action(value = "delete", results = @Result(name = SUCCESS, location = "list", type = "redirect"))
	public String delete() {
		Integer id = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("id"));
		stockBean = stockDao.findById(Stock.class, id);
		stockDao.delete(stockBean);
		return SUCCESS;
	}

	@Action(value = "save", interceptorRefs = @InterceptorRef("defaultStackHibernateStrutsValidation"), results = {
			@Result(name = SUCCESS, location = "list", type = "redirect"),
			@Result(name = INPUT, location = "/WEB-INF/pages/stock/stock_form.jsp") })
	public String save() {
		System.out.println(stockBean);
		stockDao.saveOrUpdate(stockBean);
		return SUCCESS;
	}

	public Stock getStockBean() {
		return stockBean;
	}

	public void setStockBean(Stock stockBean) {
		this.stockBean = stockBean;
	}

	public List<Stock> getStockList() {
		return stockDao.findAll(Stock.class);
	}

}
