package splus.ecr.one.service;

import java.util.List;
import java.util.Map;

import splus.ecr.one.model.Container;
import splus.ecr.one.model.User;

public interface EcrUserService {

	User findByName(String name);
	
	User saveUser(User ecrUser);

	List<User> getUsers();
	
	User getUser(Long id);
	
	User getUserById(Long id);

	List<User> getUsersByCompanyId(Long companyId);

	List<User> saveOrUpdateUsers(List<User> users);
	
	
	User findByUsername(String username);
	
	 User save(User user);

	Map<String, Object> login(String email, String password);
}
