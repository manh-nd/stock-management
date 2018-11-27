package dao.impl;

import dao.CategoryDao;
import model.Category;

public class CategoryDaoImpl extends BasicCrudImplDao<Category, Integer> implements CategoryDao {

	@Override
	public boolean delete(Category object) {
		try {
			int rowAffected = session.createQuery("UPDATE Category c SET c.active = false WHERE c.id = :id")
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
