package splus.ecr.one.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import splus.ecr.one.model.Container;

@Repository
public interface EcrContainerRepository extends JpaRepository<Container, Long>{
	
	List<Container> findAll();
	
	Container findById(Long id);
	
	Container findOne(Long id);

	List<Container> findByCompanyId(Long companyId);
}
