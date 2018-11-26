package dao.impl;

import dao.SupplierDao;
import model.Supplier;

public class SupplierDaoImpl extends BasicCrudImplDao<Supplier, Integer> implements SupplierDao {

	@Override
	public boolean delete(Supplier object, boolean active) {
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
