package dao.impl;

import dao.StockDao;
import model.Stock;

public class StockDaoImpl extends BasicCrudImplDao<Stock, Integer> implements StockDao {

	@Override
	public boolean delete(Stock object, boolean active) {
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
