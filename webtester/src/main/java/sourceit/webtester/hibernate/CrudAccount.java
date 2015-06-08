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

public class CrudAccount {
	public static void main(String[] args) {		
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
		accountDao.save(account1);
		System.out.println("Created");
		
		account1.setFirstName("NewName");
		accountDao.update(account1);
		System.out.println("Updated");
		
		accountDao.delete(account1);
		System.out.println("Deleted");		
		
		
		roleDao.delete(role);
		HibernateDebugUtils.turnOffShowSQL();
		HibernateUtils.close();
	}
}
