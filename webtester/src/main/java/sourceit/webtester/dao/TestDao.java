package sourceit.webtester.dao;

import java.util.List;

import sourceit.webtester.entities.Test;

public interface TestDao {
	void save(Test t);
	
	void update(Test t);
	
	void delete(Test t);
	
	void remove(Test t);
	
	void persist(Test t); 

	Test findById(long id);
	
	List<Test> findAll();
	
	void close();

}
