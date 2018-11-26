package dao;

import java.util.List;

import dto.CategoryGoodsReport;
import dto.ExpirationGoodsReport;
import dto.GoodsDto;
import dto.SupplierGoodsReport;
import model.Goods;

public interface GoodsDao extends BasicCrudDao<Goods, Integer>, LogicDao<Goods> {

	Goods findByGoodsCode(String goodsCode);

	List<GoodsDto> findByStockId(Integer stockId);

	List<CategoryGoodsReport> getCategoryGoodsReport();

	List<SupplierGoodsReport> getSupplierGoodsReport();

	List<ExpirationGoodsReport> getExpirationGoodsReport();

}
