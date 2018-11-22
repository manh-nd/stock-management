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
import util.WebUtil;

@ParentPackage("report-package")
@Namespace("/report")
@ResultPath("/")
public class ReportAction extends ActionSupport {

	private static final long serialVersionUID = 9059811791190723026L;

	private GoodsDao goodsDao = new GoodsDaoImpl();

	@Action(value = "category-report", results = @Result(name = SUCCESS, location = Page.TEMPLATE_PAGE))
	public String reportQuantityAndTotalByCategory() {
		WebUtil.setTitleAndPage("Báo cáo phân loại", Page.CATEGORY_REPORT);
		return SUCCESS;
	}

	@Action(value = "supplier-report", results = @Result(name = SUCCESS, location = Page.TEMPLATE_PAGE))
	public String reportQuantityAndTotalBySupplier() {
		WebUtil.setTitleAndPage("Báo cáo nhà cung cấp", Page.SUPPLIER_REPORT);
		return SUCCESS;
	}

	@Action(value = "expiration-goods-report", results = @Result(name = SUCCESS, location = Page.TEMPLATE_PAGE))
	public String reportExpirationGoodsNext30Days() {
		WebUtil.setTitleAndPage("Liệt kê hàng hóa sẽ hết hạn trong 30 ngày tới", Page.EXPIRATION_GOODS_REPORT);
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

}
