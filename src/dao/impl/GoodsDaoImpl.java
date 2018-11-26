package dao.impl;

import java.util.List;

import org.hibernate.Query;

import dao.GoodsDao;
import dto.CategoryGoodsReport;
import dto.ExpirationGoodsReport;
import dto.GoodsDto;
import dto.SupplierGoodsReport;
import model.Goods;

/**
 * Cài đặt cho GoodsDao
 * 
 * @author Manh Nguyen
 *
 */
public class GoodsDaoImpl extends BasicCrudImplDao<Goods, Integer> implements GoodsDao {

	@Override
	public Goods findByGoodsCode(String goodsCode) {
		try {
			Query query = session.createQuery("SELECT g FROM Goods g WHERE g.code = :code");
			query.setParameter("code", goodsCode);
			Goods goods = (Goods) query.uniqueResult();
			return goods;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GoodsDto> findByStockId(Integer stockId) {
		try {
			Query query = session.createQuery(
					"SELECT new dto.GoodsDto(g.id, g.code, g.name, g.expiration, i.quantity) FROM Stock s INNER JOIN s.inventories i INNER JOIN i.goods g WHERE s.id = :stockId");
			query.setParameter("stockId", stockId);
			List<GoodsDto> list = (List<GoodsDto>) query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryGoodsReport> getCategoryGoodsReport() {
		try {
			Query query = session.createQuery(
					"SELECT new dto.CategoryGoodsReport(c.name, sum(i.quantity), sum(g.exportPrice * i.quantity)) "
							+ "FROM Category c LEFT JOIN c.goods g LEFT JOIN g.inventories i " + "GROUP BY c.name");
			List<CategoryGoodsReport> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SupplierGoodsReport> getSupplierGoodsReport() {
		try {
			Query query = session.createQuery(
					"SELECT new dto.SupplierGoodsReport(s.name, sum(i.quantity), sum(g.exportPrice * i.quantity)) "
							+ "FROM Supplier s LEFT JOIN s.goods g LEFT JOIN g.inventories i GROUP BY s.name");
			List<SupplierGoodsReport> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExpirationGoodsReport> getExpirationGoodsReport() {
		try {
			Query query = session.createQuery(
					"SELECT new dto.ExpirationGoodsReport(g.code, g.name, g.category.name, g.supplier.name, s.name, g.expiration, i.quantity) "
							+ "FROM Goods g JOIN g.inventories i JOIN i.stock s "
							+ "WHERE datediff(g.expiration, current_date()) BETWEEN 1 AND 30");
			List<ExpirationGoodsReport> list = query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(Goods object, boolean active) {
		try {
			object.setActive(active);
			session.update(object);
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return false;
		}
	}

}
