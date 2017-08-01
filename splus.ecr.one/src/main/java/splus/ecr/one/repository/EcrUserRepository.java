package splus.ecr.one.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import splus.ecr.one.model.Container;
import splus.ecr.one.model.User;

@Repository
public interface EcrUserRepository extends JpaRepository<User, Long> {

	
	User findByName(String name);
	
	User save(User ecrUser);
	
 
	List<User> findAll();
	
	User findById(Long id);
	
	User findOne(Long id);

	List<User> findByCompanyId(Long companyId);
	
	//User findUserByLoginId(String loginId);
	
	User findUserByUsername(String username);
}
