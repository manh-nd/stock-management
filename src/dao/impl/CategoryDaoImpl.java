package dao.impl;

import dao.CategoryDao;
import model.Category;

public class CategoryDaoImpl extends BasicCrudImplDao<Category, Integer> implements CategoryDao {

	@Override
	public boolean delete(Category object, boolean active) {
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
