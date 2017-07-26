package splus.ecr.one.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import splus.ecr.one.model.Container;
import splus.ecr.one.model.Region;

@Repository
public interface EcrRegionRepository  extends JpaRepository<Region, Long>{

	Region save(Region region);
  
	List<Region> findAll();
	
	Region findById(Long id);
	
	Region findOne(Long id);

	List<Region> findByCompanyId(Long companyId);
}
