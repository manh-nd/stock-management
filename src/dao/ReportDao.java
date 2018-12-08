package dao;

import java.util.List;

import dto.CategoryGoodsReport;
import dto.ExpirationGoodsReport;
import dto.SupplierGoodsReport;

public interface ReportDao {
	
	List<CategoryGoodsReport> getCategoryGoodsReport();

	List<SupplierGoodsReport> getSupplierGoodsReport();

	List<ExpirationGoodsReport> getExpirationGoodsReport();
	
}
