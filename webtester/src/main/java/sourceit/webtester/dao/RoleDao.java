package sourceit.webtester.dao;

import java.util.List;

import sourceit.webtester.entities.Role;

public interface RoleDao {
	void save(Role e);
	
	void update(Role e);
	
	void delete(Role e);
	
	void remove(Role e);

	Role findById(long id);
	
	List<Role> findAll();
	
	void close();
}
