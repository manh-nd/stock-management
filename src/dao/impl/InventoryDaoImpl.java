package dao.impl;

import org.hibernate.Query;

import dao.InventoryDao;
import model.Inventory;

public class InventoryDaoImpl extends BasicCrudImplDao<Inventory, Integer> implements InventoryDao {

	@Override
	public Inventory findInventoryByStockIdAndGoodsId(Integer stockId, Integer goodsId) {
		try {
			Query query = session.createQuery(
					"SELECT i FROM Stock s INNER JOIN s.inventories i INNER JOIN i.goods g WHERE s.id = :stockId AND g.id = :goodsId AND g.active = true");
			query.setParameter("stockId", stockId);
			query.setParameter("goodsId", goodsId);
			Inventory inventory = (Inventory) query.uniqueResult();
			return inventory;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Inventory findInventoryByStockIdAndGoodsCode(Integer stockId, String goodsCode) {
		try {
			Query query = session.createQuery(
					"SELECT i FROM Stock s INNER JOIN s.inventories i INNER JOIN i.goods g WHERE s.id = :stockId AND g.code = :goodsCode")
					.setParameter("stockId", stockId).setParameter("goodsCode", goodsCode);
			Inventory inventory = (Inventory) query.uniqueResult();
			return inventory;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
