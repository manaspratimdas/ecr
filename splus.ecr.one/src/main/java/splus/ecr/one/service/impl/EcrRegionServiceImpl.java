package splus.ecr.one.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import splus.ecr.one.model.Container;
import splus.ecr.one.model.Region;
import splus.ecr.one.repository.EcrRegionRepository;
import splus.ecr.one.service.EcrRegionService;

@Service
public class EcrRegionServiceImpl implements EcrRegionService{

	@Autowired
	EcrRegionRepository ecrRegionRepository;
	
	public Region create(Region region) {
		
		return ecrRegionRepository.save(region);
	}
public List<Region> getRegions() {
		
		System.out.println("in region service");
		List<Region> lstRegion=ecrRegionRepository.findAll();
		
		for(int i=0;i<lstRegion.size();i++){
			System.out.println("region  ->>>"+lstRegion.get(i));
		}
		
		return lstRegion;
	}

public Region getRegionById(Long id) {
	
	System.out.println("in service  getRegionById");
	return ecrRegionRepository.findOne(id);
}

public Region getRegion(Long id) {
	
	return ecrRegionRepository.findById(id);
}	

public List<Region> getRegionsByCompanyId(Long companyId) {
	
	return ecrRegionRepository.findByCompanyId(companyId);
}

public List<Region> saveOrUpdateRegions(List<Region> regions) {

	return ecrRegionRepository.save(regions);
}

}
