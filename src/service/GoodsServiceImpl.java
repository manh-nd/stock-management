package service;

import java.util.List;

import dao.CategoryDao;
import dao.GoodsDao;
import dao.InventoryDao;
import dao.ProducerDao;
import dao.StockDao;
import dao.SupplierDao;
import dao.impl.CategoryDaoImpl;
import dao.impl.GoodsDaoImpl;
import dao.impl.InventoryDaoImpl;
import dao.impl.ProducerDaoImpl;
import dao.impl.StockDaoImpl;
import dao.impl.SupplierDaoImpl;
import dto.GoodsDto;
import model.Category;
import model.Goods;
import model.Inventory;
import model.Producer;
import model.Stock;
import model.Supplier;

/**
 * Cài đặt cho dịch vụ hàng hóa
 * 
 * @author Manh Nguyen
 *
 */
public class GoodsServiceImpl implements GoodsService {

	private GoodsDao goodsDao = new GoodsDaoImpl();
	private StockDao stockDao = new StockDaoImpl();
	private SupplierDao supplierDao = new SupplierDaoImpl();
	private CategoryDao categoryDao = new CategoryDaoImpl();
	private ProducerDao producerDao = new ProducerDaoImpl();
	private InventoryDao inventoryDao = new InventoryDaoImpl();

	@Override
	public void saveOrUpdate(Goods goods) {
		goodsDao.saveOrUpdate(goods);
	}

	@Override
	public boolean delete(Goods goods) {
		return goodsDao.delete(goods);
	}

	@Override
	public Goods findById(Integer goodsId) {
		return goodsDao.findById(goodsId);
	}

	@Override
	public Goods findByGoodsCode(String goodsCode) {
		return goodsDao.findByGoodsCode(goodsCode);
	}

	@Override
	public List<Goods> findAll() {
		return goodsDao.findAll();
	}

	@Override
	public List<GoodsDto> findGoodsByStockId(Integer stockId) {
		return goodsDao.findByStockId(stockId);
	}
	
	@Override
	public List<GoodsDto> findGoodsByStockId(Integer stockId, String key) {
		return goodsDao.findByStockId(stockId, key);
	}

	@Override
	public List<Stock> getStocks() {
		return stockDao.findAll(true);
	}

	@Override
	public List<Supplier> getSuppliers() {
		return supplierDao.findAll(true);
	}

	@Override
	public List<Category> getCategories() {
		return categoryDao.findAll(true);
	}

	@Override
	public List<Producer> getProducers() {
		return producerDao.findAll(true);
	}

	@Override
	public Stock findByStockId(Integer id) {
		return stockDao.findById(id);
	}

	@Override
	public Inventory findInventoryByStockIdAndGoodsId(Integer stockId, Integer goodsId) {
		return inventoryDao.findInventoryByStockIdAndGoodsId(stockId, goodsId);
	}

	@Override
	public Inventory findInventoryByStockIdAndGoodsCode(Integer stockId, String goodsCode) {
		return inventoryDao.findInventoryByStockIdAndGoodsCode(stockId, goodsCode);
	}

	@Override
	public List<Goods> findAll(String find, boolean active) {
		return goodsDao.findAll(find, active);
	}
	

}
