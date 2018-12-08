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
		return (Stock) session.createQuery("SELECT s FROM Stock s WHERE s.code = :code").setParameter("code", code)
				.uniqueResult();
	}

	@Override
	public Stock findByName(String name) {
		return (Stock) session.createQuery("SELECT s FROM Stock s WHERE s.name = :name").setParameter("name", name)
				.uniqueResult();
	}

	@Override
	public String findNameById(Integer id) {
		return (String) session.createQuery("SELECT s.name FROM Stock s WHERE s.id = :id").setParameter("id", id)
				.uniqueResult();
	}

	@Override
	public boolean isDuplicateAnotherName(String name, Integer id) {
		try {
			Long count = (Long) session.createQuery("SELECT count(s) FROM Stock s WHERE s.name = :name AND s.id <> :id")
					.setParameter("name", name).setParameter("id", id).uniqueResult();
			if (count > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
