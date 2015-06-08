package sourceit.webtester.dao;

import java.util.List;

import sourceit.webtester.entities.Question;

public interface QuestionDao {
	void save(Question a);
	
	void update(Question a);
	
	void delete(Question a);
	
	void remove(Question a);

	Question findById(long id);
	
	List<Question> findAll();
	
	void close();
}
