package service;

import java.util.List;

import helper.GoodsHelper;
import model.Category;
import model.Goods;
import model.Inventory;
import model.Producer;
import model.Stock;
import model.Supplier;

/**
 * Dịch vụ hàng hóa
 * 
 * @author Manh Nguyen
 *
 */
public interface GoodsService {

	void saveOrUpdate(Goods goods);

	void delete(Integer goodsId);

	Goods findById(Integer goodsId);

	Goods findByGoodsCode(String goodsCode);

	List<Goods> findAll();

	List<GoodsHelper> findGoodsByStockId(Integer stockId);

	List<Stock> getStocks();

	List<Supplier> getSuppliers();

	List<Category> getCategories();

	List<Producer> getProducers();

	Stock findByStockId(Integer id);

	Inventory findInventoryByStockIdAndGoodsId(Integer stockid, Integer goodsId);

}
