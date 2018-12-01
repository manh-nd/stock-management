package dao.impl;

import org.hibernate.Query;

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
	
	@Override
	public Category findByCode(String code) {
		try {
			Query query = session.createQuery("SELECT p FROM Category p WHERE p.code = :code");
			query.setParameter("code", code);
			Category object = (Category) query.uniqueResult();
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Category findByName(String name) {
		try {
			Query query = session.createQuery("SELECT p FROM Category p WHERE p.name = :name");
			query.setParameter("name", name);
			Category object = (Category) query.uniqueResult();
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean existsGoods(Integer categoryId) {
		try {
			Long count = (Long) session.createQuery("SELECT count(g) FROM Goods g WHERE g.category.id = :categoryId")
					.setParameter("categoryId", categoryId).uniqueResult();
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	

}
