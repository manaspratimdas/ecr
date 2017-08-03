package splus.ecr.one.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import splus.ecr.one.model.ContainerType;
import splus.ecr.one.repository.EcrContainerTypeRepository;
import splus.ecr.one.service.EcrContainerTypeService;

@Service
public class EcrContainerTypeServiceImpl implements EcrContainerTypeService{

	@Autowired
	EcrContainerTypeRepository ecrContainerTypeRepository;
	
	public List<ContainerType> getContainerTypes() {
		
		return ecrContainerTypeRepository.findAll();
	}

}
