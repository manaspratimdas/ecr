package splus.ecr.one.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import splus.ecr.one.model.Region;

@Repository
public interface EcrRegionRepository  extends JpaRepository<Region, Long>{

	Region save(Region region);
}
