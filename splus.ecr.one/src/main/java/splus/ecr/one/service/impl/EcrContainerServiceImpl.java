package splus.ecr.one.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import splus.ecr.one.model.CommunicationObject;
import splus.ecr.one.model.Container;
import splus.ecr.one.repository.EcrContainerRepository;
import splus.ecr.one.service.EcrContainerService;
import splus.ecr.one.specification.ContainerSpecification;
import splus.ecr.one.specification.ContainerSpecificationBuilder;
import splus.ecr.one.specification.SearchCriteria;

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

	public Container getContainerById(Long id) {
		
		System.out.println("in service  getContainerById");
		return ecrContainerRepository.findOne(id);
	}

	public Container getContainer(Long id) {
		
		return ecrContainerRepository.findById(id);
	}

	public List<Container> getContainersByCompanyId(Long companyId) {
		
		
		return ecrContainerRepository.findByCompanyId(companyId);
	}

	public List<Container> saveOrUpdateContainers(List<Container> containers) {
		
	
		
		return ecrContainerRepository.save(containers);
	}

	public void delete(Container container) {
		
		ecrContainerRepository.delete(container);
		
	}

	public CommunicationObject getContainersByCountry(String id) {
	return  ecrContainerRepository.getContainersByCountry(id);
}

public List<Container>  getAvailableContainers(String type, String country, String port, String company) {
		
		System.out.println("containers in service "+type+",  "+country+" ,  "+port+", "+company);
		
		ContainerSpecificationBuilder builder=new ContainerSpecificationBuilder();
		builder.with("status", ":", "A");
		
		if(port!=null && !port.equals("null")){
			builder.with("port", ":",Long.parseLong(port));
		}
		
		// Repeat the above block for type and cmpany
		builder.with("containerType", ":",Long.parseLong(type));
		
		// For country
		//create a method to fetch all the ports for a country(this can be done in service/repository related to port)
		  
		//iterate through the list of ports  and for each port id
		// builder.with("port", ":",port_id);
		
		
		Specification<Container> spec = builder.build();
		
		List<Container> results =ecrContainerRepository.findAll(Specifications.where(spec));
		
		System.out.println("result "+results);
		return results;
		
	}

	
	
}
