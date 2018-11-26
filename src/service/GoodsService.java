package service;

import java.util.List;

import dto.GoodsDto;
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

	boolean delete(Goods goods, boolean active);

	Goods findById(Integer goodsId);

	Goods findByGoodsCode(String goodsCode);

	List<Goods> findAll();

	List<GoodsDto> findGoodsByStockId(Integer stockId);

	List<Stock> getStocks();

	List<Supplier> getSuppliers();

	List<Category> getCategories();

	List<Producer> getProducers();

	Stock findByStockId(Integer id);

	Inventory findInventoryByStockIdAndGoodsId(Integer stockid, Integer goodsId);

}
