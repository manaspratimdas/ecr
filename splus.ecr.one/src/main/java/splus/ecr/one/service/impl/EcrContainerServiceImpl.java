package splus.ecr.one.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
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
		
		List<Container> containers = ecrContainerRepository.findByCompanyId(companyId);
		
		for (Iterator<Container> iterator = containers.iterator(); iterator.hasNext();) {
			Container container = iterator.next();
		    if (!container.isRecordStatus()) {
		        iterator.remove();
		    }
		}
		
		return containers;
	}
	/*
	 * added by dbangar
	 * 
	 */
	public List<Container> getLenderContainersByCompanyId(Long companyId) {
		
		List<Container> containers = ecrContainerRepository.findByCompanyId(companyId);
		List<Container> lendercontainers = new ArrayList<Container>();
		
		for (Iterator<Container> iterator = containers.iterator(); iterator.hasNext();) {
			Container container = iterator.next();
			
		    if (!"".equals(container.getStatus())) {
		    	if("R".equals(container.getStatus())){
		    		
		    		lendercontainers.add(container);
		    		
		    	}
		        iterator.remove();
		    }
		}
		
		return lendercontainers;
	}
	/*
	 * added by dbangar
	 * 
	 */
	public List<Container> getBorrowerContainersByCompanyId(Long companyId) {
		
		List<Container> containers = ecrContainerRepository.findByCompanyId(companyId);
		List<Container> lendercontainers = new ArrayList<Container>();
		
		for (Iterator<Container> iterator = containers.iterator(); iterator.hasNext();) {
			
			Container container = iterator.next();
		    
			if (!"".equals(container.getStatus())) {
		    	
		    	if("B".equals(container.getStatus())){
		    		
		    		lendercontainers.add(container);
		    		
		    	}
		        iterator.remove();
		    }
		}
		
		return lendercontainers;
	}

	public List<Container> saveOrUpdateContainers(List<Container> containers) {
		containers.get(0).setRecordStatus(true);
		ecrContainerRepository.save(containers);
		
		
		return getContainersByCompanyId(containers.get(0).getCompany().getId());
	}
	/*
	 * added by tanya
	 */
	public Container saveOrUpdateContainer(Container container) {

		ecrContainerRepository.save(container);
		
		return container;
	}

	public List<Container> delete(Container container) {
		container = ecrContainerRepository.findById(container.getId());
		container.setRecordStatus(false);
		ecrContainerRepository.save(container);
		return getContainersByCompanyId(container.getCompany().getId());
	}

	public CommunicationObject getContainersByCountry(String id) {
	return  null;//ecrContainerRepository.getContainersByCountry(id);
}

public List<Container>  getAvailableContainers(String type, String country, String port, String company) {
		
		System.out.println("containers in service "+type+",  "+country+" ,  "+port+", "+company);
		
		ContainerSpecificationBuilder builder=new ContainerSpecificationBuilder();
		
		builder.with("status", ":", "A");
		
		builder.with("recordStatus", ":", true);
		
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
