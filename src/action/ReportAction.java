package action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

import constant.Page;
import dao.GoodsDao;
import dao.impl.GoodsDaoImpl;
import dto.CategoryGoodsReport;
import dto.ExpirationGoodsReport;
import dto.SupplierGoodsReport;

@ParentPackage("report-package")
@Namespace("/report")
@ResultPath("/")
public class ReportAction extends ActionSupport {

	private static final long serialVersionUID = 9059811791190723026L;

	private GoodsDao goodsDao = new GoodsDaoImpl();

	private String title;
	private String page;

	@Action(value = "category-report", results = @Result(name = SUCCESS, location = Page.TEMPLATE_PAGE))
	public String reportQuantityAndTotalByCategory() {
		title = "Báo cáo phân loại";
		page = Page.CATEGORY_REPORT;
		return SUCCESS;
	}

	@Action(value = "supplier-report", results = @Result(name = SUCCESS, location = Page.TEMPLATE_PAGE))
	public String reportQuantityAndTotalBySupplier() {
		title = "Báo cáo nhà cung cấp";
		page = Page.SUPPLIER_REPORT;
		return SUCCESS;
	}

	@Action(value = "expiration-goods-report", results = @Result(name = SUCCESS, location = Page.TEMPLATE_PAGE))
	public String reportExpirationGoodsNext30Days() {
		title = "Liệt kê hàng hóa sẽ hết hạn trong 30 ngày tới";
		page = Page.EXPIRATION_GOODS_REPORT;
		return SUCCESS;
	}

	public List<CategoryGoodsReport> getCategoryGoodsReport() {
		return goodsDao.getCategoryGoodsReport();
	}

	public List<SupplierGoodsReport> getSupplierGoodsReport() {
		return goodsDao.getSupplierGoodsReport();
	}

	public List<ExpirationGoodsReport> getExpirationGoodsReport() {
		return goodsDao.getExpirationGoodsReport();
	}

	public String getTitle() {
		return title;
	}

	public String getPage() {
		return page;
	}

}
