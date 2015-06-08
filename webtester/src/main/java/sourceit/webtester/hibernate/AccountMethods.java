package sourceit.webtester.hibernate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import sourceit.webtester.dao.AccountDao;
import sourceit.webtester.dao.RoleDao;
import sourceit.webtester.dao.impl.hibernate.AccountDaoImpl;
import sourceit.webtester.dao.impl.hibernate.HibernateUtils;
import sourceit.webtester.dao.impl.hibernate.RoleDaoImpl;
import sourceit.webtester.entities.Account;
import sourceit.webtester.entities.AccountRole;
import sourceit.webtester.entities.Role;
import sourceit.webtester.utils.HibernateDebugUtils;



public class AccountMethods {
	public static void main(String [] args) {
		HibernateDebugUtils.turnOnShowSQL();		
		Role role = new Role();
		RoleDao roleDao = new RoleDaoImpl(); 
		role.setName("role1");
		roleDao.save(role);
		
		AccountDao accountDao = new AccountDaoImpl(); 
		Account account1 = new Account();
		account1.setLogin("login1");
		account1.setPassword("password1");
		account1.setEmail("email1@email.com");
		account1.setFirstName("firstName1");
		account1.setLastName("lastName1");
		account1.setMiddleName("middleName1");
		account1.setCreated(new Timestamp(1));
		account1.setActive(true);
		account1.setEmailVerified(false);
		List<AccountRole> listOfAccountRoles = new ArrayList<>();
		AccountRole ar1 = new AccountRole();
		ar1.setAccount(account1);
		ar1.setRole(role);		
		listOfAccountRoles.add(ar1);
		account1.setAccountRoles(listOfAccountRoles);
		
		//Display number of items on page
		Account account2 = new Account();
		account2.setFirstName("Name2");
		account2.setLastName("Lastname2");
		account2.setMiddleName("Middlename2");
		account2.setEmail("email@email.ru2");
		account2.setLogin("login2");
		account2.setPassword("password2");
		account2.setActive(true);
		account2.setCreated(new Timestamp(2));
		account2.setEmailVerified(false);
		AccountRole ar2 = new AccountRole();
		ar2.setAccount(account2);
		ar2.setRole(role);		
		listOfAccountRoles.add(ar2);
		account2.setAccountRoles(listOfAccountRoles);
		
		
		Account account3 = new Account();
		account3.setFirstName("Name3");
		account3.setLastName("Lastname3");
		account3.setMiddleName("Middlename3");
		account3.setEmail("email@email.ru3");
		account3.setLogin("login3");
		account3.setPassword("password3");
		account3.setActive(true);
		account3.setCreated(new Timestamp(2));
		account3.setEmailVerified(false);
		AccountRole ar3 = new AccountRole();
		ar3.setAccount(account2);
		ar3.setRole(role);		
		listOfAccountRoles.add(ar3);
		account3.setAccountRoles(listOfAccountRoles);	
		
		accountDao.save(account1);
		accountDao.save(account2);
		accountDao.save(account3);
		//List<Account> listOfAcc = accountDao.listAccounts(1, 2, "desk");
		//for(Account ac : listOfAcc ) {
		//	System.out.println(ac.getFirstName());
		//}		
		/*accountDao.delete(account1);
		accountDao.delete(account2);
		accountDao.delete(account3);*/		
		
		HibernateDebugUtils.turnOffShowSQL();
		HibernateUtils.close();
	}
}
