package splus.ecr.one.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import splus.ecr.one.model.Container;
import splus.ecr.one.model.Country;
import splus.ecr.one.model.Port;
import splus.ecr.one.repository.EcrContainerRepository;
import splus.ecr.one.repository.EcrPortRepository;
import splus.ecr.one.service.EcrContainerService;
import splus.ecr.one.service.EcrPortService;

@Service
public class EcrPortServiceImpl implements EcrPortService{
	@Autowired
	 EcrPortRepository ecrPortRepository;


	 public List<Port> getAvailablePorts(long countryid){
		 
		 System.out.println("in port service");
		
		 List<Port> port = ecrPortRepository.findAll();    
		
		 //List<Country> cid=new ArrayList<Country>();
		  
			List<Port> filteredPort=new ArrayList<Port>();
				for(Port p:port){
					if(p.getCountry().getId()==countryid){
						filteredPort.add(p);
						}
					}	
				return (filteredPort);
		  }

}
