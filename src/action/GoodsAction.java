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

import constant.Page;
import dao.CategoryDao;
import dao.GoodsDao;
import dao.ProducerDao;
import dao.StockDao;
import dao.SupplierDao;
import dao.impl.CategoryDaoImpl;
import dao.impl.GoodsDaoImpl;
import dao.impl.ProducerDaoImpl;
import dao.impl.StockDaoImpl;
import dao.impl.SupplierDaoImpl;
import model.Category;
import model.Goods;
import model.Producer;
import model.Stock;
import model.Supplier;
import util.WebUtil;

/**
 * Action Hàng hóa
 * 
 * @author Manh Nguyen
 *
 */

@ParentPackage("goods-package")
@Namespace("/goods")
@ResultPath("/")
public class GoodsAction extends ActionSupport implements IAction {

	private static final long serialVersionUID = -5799607767607577952L;

	private static GoodsDao goodsDao = new GoodsDaoImpl();
	private static StockDao stockDao = new StockDaoImpl();
	private static SupplierDao supplierDao = new SupplierDaoImpl();
	private static CategoryDao categoryDao = new CategoryDaoImpl();
	private static ProducerDao producerDao = new ProducerDaoImpl();

	@Valid
	private Goods goodsBean = new Goods();

	@Action(value = "list", results = { @Result(name = SUCCESS, location = Page.TEMPLATE_PAGE) })
	public String list() {
		System.out.println("goods list");
		WebUtil.setTitleAndPage("Danh sách hàng hóa", Page.GOODS_LIST_PAGE);
		return SUCCESS;
	}

	@Action(value = "add", results = { @Result(name = SUCCESS, location = Page.TEMPLATE_PAGE) })
	public String add() {
		WebUtil.setTitleAndPage("Thêm mới hàng hóa", Page.GOODS_FORM_PAGE);
		return SUCCESS;
	}

	@Action(value = "edit", results = { @Result(name = SUCCESS, location = Page.TEMPLATE_PAGE) })
	public String edit() {
		WebUtil.setTitleAndPage("Sửa hàng hóa", Page.GOODS_FORM_PAGE);
		Integer id = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("id"));
		goodsBean = goodsDao.findById(Goods.class, id);
		return SUCCESS;
	}

	@Action(value = "delete", results = { @Result(name = SUCCESS, location = "list", type = "redirect") })
	public String delete() {
		Integer id = Integer.parseInt(WebUtil.getHttpServletRequest().getParameter("id"));
		goodsBean = goodsDao.findById(Goods.class, id);
		goodsDao.delete(goodsBean);
		return SUCCESS;
	}

	@Action(value = "save", interceptorRefs = @InterceptorRef("defaultStackHibernateStrutsValidation"), results = {
			@Result(name = SUCCESS, location = "list", type = "redirect"),
			@Result(name = INPUT, location = Page.TEMPLATE_PAGE) })
	public String save() {
		try {
			System.out.println(goodsBean);
			goodsDao.saveOrUpdate(goodsBean);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			if (goodsBean.getId() == null)
				WebUtil.setTitleAndPage("Thêm hàng hóa", Page.GOODS_FORM_PAGE);
			else
				WebUtil.setTitleAndPage("Sửa hàng hóa", Page.GOODS_FORM_PAGE);
			return INPUT;
		}
	}

	public Goods getGoodsBean() {
		return goodsBean;
	}

	public void setGoodsBean(Goods goodsBean) {
		this.goodsBean = goodsBean;
	}

	public List<Goods> getGoodsList() {
		return goodsDao.findAll(Goods.class);
	}

	public List<Stock> getStockList() {
		return stockDao.findAll(Stock.class);
	}

	public List<Category> getCategoryList() {
		return categoryDao.findAll(Category.class);
	}

	public List<Supplier> getSupplierList() {
		return supplierDao.findAll(Supplier.class);
	}

	public List<Producer> getProducerList() {
		return producerDao.findAll(Producer.class);
	}

	@Override
	public void validate() {
		System.out.println("Validate....");
	}

}
