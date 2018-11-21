package dao.impl;

import java.util.List;

import org.hibernate.Query;

import dao.GoodsDao;
import helper.CategoryGoodsReport;
import helper.GoodsHelper;
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
	public List<GoodsHelper> findByStockId(Integer stockId) {
		try {
			Query query = session.createQuery(
					"SELECT new helper.GoodsHelper(g.id, g.code, g.name, g.expiration, i.quantity) FROM Stock s INNER JOIN s.inventories i INNER JOIN i.goods g WHERE s.id = :stockId");
			query.setParameter("stockId", stockId);
			List<GoodsHelper> list = (List<GoodsHelper>) query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// chưa xong
	@Override
	public List<CategoryGoodsReport> getCategoryGoodsReport() {
		try {
			Query query = session.createQuery(
					"SELECT new helper.CategoryGoodsReport(g.category.name, sum(), ) FROM Goods g INNER JOIN g.inventories i");
			@SuppressWarnings("unchecked")
			List<CategoryGoodsReport> list = (List<CategoryGoodsReport>) query.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
