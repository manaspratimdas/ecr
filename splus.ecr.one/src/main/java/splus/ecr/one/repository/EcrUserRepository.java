package splus.ecr.one.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import splus.ecr.one.model.User;

@Repository
public interface EcrUserRepository extends JpaRepository<User, Long> {

	
	User findByName(String name);
	
	User save(User ecrUser);
}
