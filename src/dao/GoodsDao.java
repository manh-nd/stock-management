package dao;

import java.util.List;

import helper.CategoryGoodsReport;
import helper.GoodsHelper;
import model.Goods;

public interface GoodsDao extends BasicCrudDao<Goods, Integer>{

	Goods findByGoodsCode(String goodsCode);
	
	List<GoodsHelper> findByStockId(Integer stockId);
	
	List<CategoryGoodsReport> getCategoryGoodsReport();

}
