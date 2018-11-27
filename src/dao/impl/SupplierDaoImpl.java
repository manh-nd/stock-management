package dao.impl;

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

}
