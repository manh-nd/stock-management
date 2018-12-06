package dao.impl;

import org.hibernate.Query;

import dao.SupplierDao;
import model.Supplier;

public class SupplierDaoImpl extends BasicCrudImplDao<Supplier, Integer> implements SupplierDao {

	@Override
	public boolean delete(Supplier object) {
		try {
			int rowAffected = session.createQuery("UPDATE Supplier p SET p.active = false WHERE p.id = :id")
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
	public Supplier findByCode(String code) {
		try {
			Query query = session.createQuery("SELECT p FROM Supplier p WHERE p.code = :code");
			query.setParameter("code", code);
			Supplier object = (Supplier) query.uniqueResult();
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Supplier findByName(String name) {
		try {
			Query query = session.createQuery("SELECT p FROM Supplier p WHERE p.name = :name");
			query.setParameter("name", name);
			Supplier object = (Supplier) query.uniqueResult();
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean existsGoods(Integer supplierId) {
		try {
			Long count = (Long) session.createQuery("SELECT count(g) FROM Goods g WHERE g.supplier.id = :supplierId")
					.setParameter("supplierId", supplierId).uniqueResult();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String findNameById(Integer id) {
		return (String) session.createQuery("SELECT s.name FROM Supplier s WHERE s.id = :id").setParameter("id", id)
				.uniqueResult();
	}

	@Override
	public boolean isDuplicateAnotherName(String name, Integer id) {
		try {
			Long count = (Long) session.createQuery("SELECT count(s) FROM Supplier s WHERE s.name = :name AND s.id <> :id")
					.setParameter("name", name).setParameter("id", id).uniqueResult();
			if (count > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
