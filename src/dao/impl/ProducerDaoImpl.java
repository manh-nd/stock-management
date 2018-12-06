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
	public Producer findByName(String name) {
		try {
			Query query = session.createQuery("SELECT p FROM Producer p WHERE p.name = :name");
			query.setParameter("name", name);
			Producer object = (Producer) query.uniqueResult();
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean existsGoods(Integer producerId) {
		try {
			Long count = (Long) session.createQuery("SELECT count(g) FROM Goods g WHERE g.producer.id = :producerId")
					.setParameter("producerId", producerId).uniqueResult();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
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

	@Override
	public String findNameById(Integer id) {
		return (String) session.createQuery("SELECT p.name FROM Producer p WHERE p.id = :id").setParameter("id", id)
				.uniqueResult();
	}

	@Override
	public boolean isDuplicateAnotherName(String name, Integer id) {
		try {
			Long count = (Long) session.createQuery("SELECT count(p) FROM Producer p WHERE p.name = :name AND p.id <> :id")
					.setParameter("name", name).setParameter("id", id).uniqueResult();
			if (count > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
