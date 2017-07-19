package splus.ecr.one.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import splus.ecr.one.model.Container;
import splus.ecr.one.repository.EcrContainerRepository;
import splus.ecr.one.service.EcrContainerService;

@Service
public class EcrContainerServiceImpl implements EcrContainerService{

	@Autowired
	EcrContainerRepository ecrContainerRepository;
	
	public List<Container> getContainers() {
		
		System.out.println("in container service");
		List<Container> lstContainer=ecrContainerRepository.findAll();
		
		for(int i=0;i<lstContainer.size();i++){
			System.out.println("container  ->>>"+lstContainer.get(i));
		}
		
		return lstContainer;
	}

}
