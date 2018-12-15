package dao.impl;


import java.util.List;

import org.hibernate.Query;

import dao.AccountDao;
import model.Account;
public class AccountDaoImpl extends BasicCrudImplDao<Account, Integer> implements AccountDao {

	@Override
	public Account findByUsernameAndPassword(String username, String password) {
		return (Account) session
				.createQuery("SELECT a FROM Account a WHERE a.username = :username AND a.password = :password")
				.setParameter("username", username).setParameter("password", password).uniqueResult();
	}

	@Override
	public Account changePassword(Integer id, String password) {
		try {
			int rowAffected = session.createQuery("UPDATE Account a SET a.password = :password WHERE a.id = :id")
					.setParameter("password", password).setParameter("id", id).executeUpdate();
			if (rowAffected > 0)
				return (Account) session.get(Account.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getlistRoles() {
		List<Account> list = null;
		try {
			list = session.createQuery("from Account").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unused")
	@Override
	public Account fillbyUsername(String username) {
		try {
			Query query = session.createQuery("SELECT p FROM Account p WHERE p.username = :username");
			query.setParameter("username", username);
			Account object = (Account) query.uniqueResult();
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		
	}
	}
}
