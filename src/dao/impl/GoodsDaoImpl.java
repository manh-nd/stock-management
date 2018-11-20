package dao.impl;

import java.util.List;

import org.hibernate.Query;

import dao.GoodsDao;
import dto.GoodsDto;
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

}
