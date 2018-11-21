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
	public void delete(Integer goodsId) {
		goodsDao.delete(goodsDao.findById(Goods.class, goodsId));
	}

	@Override
	public Goods findById(Integer goodsId) {
		return goodsDao.findById(Goods.class, goodsId);
	}

	@Override
	public Goods findByGoodsCode(String goodsCode) {
		return goodsDao.findByGoodsCode(goodsCode);
	}

	@Override
	public List<Goods> findAll() {
		return goodsDao.findAll(Goods.class);
	}

	@Override
	public List<GoodsDto> findGoodsByStockId(Integer stockId) {
		return goodsDao.findByStockId(stockId);
	}

	@Override
	public List<Stock> getStocks() {
		return stockDao.findAll(Stock.class);
	}

	@Override
	public List<Supplier> getSuppliers() {
		return supplierDao.findAll(Supplier.class);
	}

	@Override
	public List<Category> getCategories() {
		return categoryDao.findAll(Category.class);
	}

	@Override
	public List<Producer> getProducers() {
		return producerDao.findAll(Producer.class);
	}

	@Override
	public Stock findByStockId(Integer id) {
		return stockDao.findById(Stock.class, id);
	}

	@Override
	public Inventory findInventoryByStockIdAndGoodsId(Integer stockId, Integer goodsId) {
		return inventoryDao.findInventoryByStockIdAndGoodsId(stockId, goodsId);
	}

}