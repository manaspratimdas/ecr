package splus.ecr.one.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import splus.ecr.one.model.ContainerType;
import splus.ecr.one.service.EcrContainerTypeService;

@RestController
public class EcrContainerTypeController {
	
	
	@Autowired
	EcrContainerTypeService  ecrContainerTypeService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/containertypes", method = RequestMethod.GET)
	public ResponseEntity getContainerTypes() {

		System.out.println("in containerTypes");

		List<ContainerType> containerTypes = ecrContainerTypeService.getContainerTypes();
		if (containerTypes == null) {
			return new ResponseEntity("No Containers types found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(containerTypes, HttpStatus.OK);

	}

}
