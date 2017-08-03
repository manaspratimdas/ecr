package splus.ecr.one.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import splus.ecr.one.model.CommunicationObject;
import splus.ecr.one.model.Container;
import splus.ecr.one.model.Port;
import splus.ecr.one.repository.EcrContainerRepository;
import splus.ecr.one.repository.EcrPortRepository;
import splus.ecr.one.service.EcrContainerService;
import splus.ecr.one.service.EcrPortService;
import splus.ecr.one.specification.ContainerSpecificationBuilder;

@Service
public class EcrContainerServiceImpl implements EcrContainerService{

	@Autowired
	EcrContainerRepository ecrContainerRepository;
	
	
	@Autowired
	EcrPortRepository ecrPortRepository;
	
	@Autowired
	EcrPortService ecrPortService;
	
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
	return  null;//ecrContainerRepository.getContainersByCountry(id);
}

public List<Container>  getAvailableContainers(String type, String country, String port, String company) {
		
		System.out.println("containers in service "+type+",  "+country+" ,  "+port+", "+company);
		
		ContainerSpecificationBuilder builder=new ContainerSpecificationBuilder();
		
		builder.with("status", ":", "A");
		
		if(port!=null && !port.equals("null")){
			builder.with("port", ":",Long.parseLong(port));
		}
		if(type!=null &&! type.equals("null")){
			builder.with("containerType", ":",Long.parseLong(type));
			}
		if(company!=null &&! company.equals("null")){
			builder.with("company", ":",Long.parseLong(company));
			}
		
		
		
		Specification<Container> spec = builder.build();
		
		List<Container> results =ecrContainerRepository.findAll(Specifications.where(spec));
		
		/*builder=new ContainerSpecificationBuilder();
		
		if(country!=null &&! country.equals("null")){
			List<Port> portsByCountry=ecrPortRepository.findByCountryId(Long.parseLong(country));
			System.out.println(portsByCountry);
		
				for(Port p : portsByCountry){
					//builder.with("port", ":",p.getId());
					
					System.out.println("Port >>>>> "+port);
						builder.with("port", ":",p.getId());
					
				}
				Specification<Container> spec1 = builder.buildOr();
				List<Container> results1 =ecrContainerRepository.findAll(Specifications.where(spec1));
				results.addAll(results1);
			}
		
		*/
		
		
		
		
		
		System.out.println("result "+results);
		
		return results;
		
	}
	
	public List<Port> getAllPorts(long countryid){
		List<Port> availablePort=null;
		if(!"".equals(countryid)){
		System.out.println("in port service");
		 availablePort=ecrPortService.getAvailablePorts(countryid);
	     return availablePort;
		}else{
			System.out.println("no ports available with country id:"+countryid);
		}
		 return availablePort;
	}
	
}
