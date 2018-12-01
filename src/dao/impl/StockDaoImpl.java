package dao.impl;

import dao.StockDao;
import model.Stock;

public class StockDaoImpl extends BasicCrudImplDao<Stock, Integer> implements StockDao {

	@Override
	public boolean delete(Stock object) {
		try {
			int rowAffected = session.createQuery("UPDATE Stock s SET s.active = false WHERE s.id = :id")
					.setParameter("id", object.getId()).executeUpdate();
			if (rowAffected > 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			transaction.rollback();
			return false;
		}
	}

	@Override
	public Stock findByCode(String code) {
		return null;
	}

	@Override
	public Stock findByName(String name) {
		return null;
	}

}
