package sourceit.webtester.dao;

import java.util.List;

import sourceit.webtester.entities.Answer;


public interface AnswerDao {
	void save(Answer a);
	
	void update(Answer a);
	
	void delete(Answer a);
	
	void remove(Answer a);
	
	void persist(Answer a);

	Answer findById(long id);
	
	List<Answer> findAll();
	
	void close();
}
