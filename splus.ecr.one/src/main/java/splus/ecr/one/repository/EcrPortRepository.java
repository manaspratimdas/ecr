package splus.ecr.one.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import splus.ecr.one.model.Container;
import splus.ecr.one.model.Port;
import splus.ecr.one.model.User;

public interface EcrPortRepository extends JpaRepository<Port, Long> {

	List<Port> findAll();
	
	List<Port> findByCountryId(Long countryId);

}
