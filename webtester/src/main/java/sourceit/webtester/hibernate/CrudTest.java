package sourceit.webtester.hibernate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import sourceit.webtester.dao.TestDao;
import sourceit.webtester.dao.impl.hibernate.TestDaoImpl;
import sourceit.webtester.entities.Account;
import sourceit.webtester.entities.AccountRole;
import sourceit.webtester.entities.Answer;
import sourceit.webtester.entities.Question;
import sourceit.webtester.entities.Role;
import sourceit.webtester.entities.Test;
import sourceit.webtester.utils.HibernateDebugUtils;

public class CrudTest {
	public static void main(String []args) {
		HibernateDebugUtils.turnOnShowSQL();		
		TestDao testDao = new TestDaoImpl();	
		Answer answer = new Answer();	
		Question question = new Question();		
		Test test = new Test();
		Account account = new Account();
		Role role = new Role();
		
		role.setName("role1");
		
		account.setLogin("login1");
		account.setPassword("password1");
		account.setEmail("email1@email.com");
		account.setFirstName("firstName1");
		account.setLastName("lastName1");
		account.setMiddleName("middleName1");
		account.setCreated(new Timestamp(1));
		account.setActive(true);
		account.setEmailVerified(false);
		List<AccountRole> listOfAccountRoles = new ArrayList<>();
		AccountRole ar1 = new AccountRole();
		ar1.setAccount(account);
		ar1.setRole(role);		
		listOfAccountRoles.add(ar1);
		account.setAccountRoles(listOfAccountRoles);
		
		test.setTitle("title1");
		test.setCreated(new Timestamp(1));
		test.setActive(true);
		test.setPeriodPerQuestion(1000);
		test.setAccount(account);
		

		testDao.persist(test);
	}
}
