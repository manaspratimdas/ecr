package splus.ecr.one.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	
}
