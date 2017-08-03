package splus.ecr.one.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import splus.ecr.one.model.Port;
import splus.ecr.one.service.EcrPortService;

@RestController
public class EcrPortController {
	
	@Autowired
	EcrPortService ecrPortService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/ports", method = RequestMethod.GET)
	public ResponseEntity getPorts() {

		System.out.println("in Ports");

		List<Port> ports = ecrPortService.getPorts();
		if (ports == null) {
			return new ResponseEntity("No ports found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(ports, HttpStatus.OK);

	}

}
