package dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

import dao.BasicCrudDao;

/**
 * Lớp thực thi giao diện BasicCrud.
 *
 * @param <T> Kiểu dữ liệu
 * @param <ID> Kiểu dữ liệu ID của kiểu dữ liệu <code>&ltT&gt</code>
 * 
 * @author Manh Nguyen
 */
public class BasicCrudImplDao<T, ID extends Serializable> implements BasicCrudDao<T, ID> { // Lưu ý, không sửa hay thêm
																							// gì vào đây

	private final Class<T> clazz;

	@SuppressWarnings("unchecked")
	public BasicCrudImplDao() {
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@SessionTarget
	protected Session session;

	@TransactionTarget
	protected Transaction transaction;

	@Override
	public T save(T object) {
		try {
			session.save(object);
			session.refresh(object);
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		}
	}

	@Override
	public T update(T object) {
		try {
			session.update(object);
			session.refresh(object);
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		}
	}

	@Override
	public void saveOrUpdate(T object) {
		try {
			session.saveOrUpdate(object);
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		}
	}

	@Override
	public boolean delete(T object) {
		try {
			session.delete(object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			throw e;
		}
	}

	@Override
	public T findById(ID id) {
		try {
			@SuppressWarnings("unchecked")
			T t = (T) session.get(clazz, id);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<T> findAll() {
		try {
			Query query = session.createQuery(String.format("FROM %s", clazz.getName()));
			@SuppressWarnings("unchecked")
			List<T> result = query.list();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(boolean active) {
		try {
			Query query = session.createQuery(String.format("FROM %s o WHERE o.active = :active", clazz.getName()));
			query.setParameter("active", active);
			List<T> result = query.list();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(String key, boolean active) {
		try {
			Query query = session.createQuery(
					String.format("FROM %s o WHERE (o.code like :code OR o.name like :name) AND o.active = :active",
							clazz.getName()));
			query.setParameter("code", key + "%");
			query.setParameter("name", key + "%");
			query.setParameter("active", active);
			List<T> result = query.list();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
