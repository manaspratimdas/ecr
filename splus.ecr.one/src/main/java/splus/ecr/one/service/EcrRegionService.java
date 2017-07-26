package splus.ecr.one.service;

import java.util.List;

import splus.ecr.one.model.Container;
import splus.ecr.one.model.Region;

public interface EcrRegionService {
	
	public Region create(Region region);

	List<Region> getRegions();
	
	Region getRegion(Long id);
	
	Region getRegionById(Long id);

	List<Region> getRegionsByCompanyId(Long companyId);

	List<Region> saveOrUpdateRegions(List<Region> regions);

}
