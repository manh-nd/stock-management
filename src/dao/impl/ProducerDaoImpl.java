package dao.impl;

import org.hibernate.Query;

import dao.ProducerDao;
import model.Producer;

public class ProducerDaoImpl extends BasicCrudImplDao<Producer, Integer> implements ProducerDao {

	@Override
	public Producer findByCode(String code) {
		try {
			Query query = session.createQuery("SELECT p FROM Producer p WHERE p.code = :code");
			query.setParameter("code", code);
			Producer object = (Producer) query.uniqueResult();
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(Producer object) {
		try {
			int rowAffected = session.createQuery("UPDATE Producer p SET p.active = false WHERE p.id = :id")
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
	
}
