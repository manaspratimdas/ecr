package splus.ecr.one.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import splus.ecr.one.model.Container;
import splus.ecr.one.service.EcrContainerService;

@RestController
@RequestMapping("/containers")
public class EcrContainerController {
	
	@Autowired
	EcrContainerService ecrContainerService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Container> getContainers() {
		
		System.out.println("in list container controller");
		return ecrContainerService.getContainers();
		
	}

}
