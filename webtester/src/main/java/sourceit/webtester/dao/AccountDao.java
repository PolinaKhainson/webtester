package sourceit.webtester.dao;

import java.util.List;

import sourceit.webtester.entities.Account;

public interface AccountDao {
	void save(Account a);
	
	void update(Account a);
	
	void delete(Account a);
	
	void remove(Account a);

	Account findById(long id);
	
	List<Account> findAll();
	
	void close();
}
