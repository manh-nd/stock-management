package dao;

import model.Account;

public interface AccountDao extends BasicCrudDao<Account, Integer> {

	Account findByUsernameAndPassword(String username, String password);

	boolean changePassword(Integer id, String password);

}
