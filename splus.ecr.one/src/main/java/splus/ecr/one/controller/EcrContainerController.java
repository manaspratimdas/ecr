package splus.ecr.one.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import splus.ecr.one.model.Container;
import splus.ecr.one.model.Port;
import splus.ecr.one.service.EcrContainerService;
import splus.ecr.one.service.EcrPortService;
//@CrossOrigin
@RestController
public class EcrContainerController {

	@Autowired
	EcrContainerService ecrContainerService;
	
	
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "containers/test", method = RequestMethod.GET)
	public ResponseEntity testIntegration() {

		System.out.println("in list getAllContainers controller");

		
		return new ResponseEntity("OK", HttpStatus.OK);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/containers", method = RequestMethod.GET)
	public ResponseEntity getContainers() {

		System.out.println("in list getAllContainers controller");

		List<Container> containers = ecrContainerService.getContainers();
		if (containers == null) {
			return new ResponseEntity("No Containers found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(containers, HttpStatus.OK);

	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/containers/{id}", method = RequestMethod.GET)
	public ResponseEntity getContainersById(@PathVariable("id") Long id) {

		System.out.println("in list container controller");

		Container container = ecrContainerService.getContainer(id);
		if (container == null) {
			return new ResponseEntity("No Container found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(container, HttpStatus.OK);

	}

	/**
	 * This will list all the container for a company
	 * @return
	 */

	@RequestMapping(value = "/company/{companyId}/containers", method = RequestMethod.GET)
	public ResponseEntity getContainersByCompany(@PathVariable("companyId") Long companyId) {

		System.out.println("in list container controller");

		List<Container> containers = ecrContainerService.getContainersByCompanyId(companyId);
		if (containers == null) {
			return new ResponseEntity("No Containers found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(containers, HttpStatus.OK);

	}
	
	
	@RequestMapping(value = "/containers/update", method = RequestMethod.POST)
	public ResponseEntity saveOrUpdateContainers(@RequestBody List<Container> containers) {

		System.out.println("in list container controller"+containers);
		
		System.out.println("json "+containers);

		List<Container> updatedContainers = ecrContainerService.saveOrUpdateContainers(containers);
		if (updatedContainers == null) {
			return new ResponseEntity("No Containers found", HttpStatus.NOT_FOUND);
	}
		return new ResponseEntity(updatedContainers, HttpStatus.OK);

	}
	
	
	@RequestMapping(value = "/containers/delete", method = RequestMethod.POST)
	public ResponseEntity saveOrUpdateContainers(@RequestBody Container container) {

		System.out.println("in list container controller"+container);
		
		System.out.println("json "+container);

		 ecrContainerService.delete(container);
	
		return new ResponseEntity("Deleted", HttpStatus.OK);

	}
	
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity searchContainersByAvailability(
					@RequestParam(required = false) String type,
					@RequestParam(required = false) String country,
					@RequestParam(required = false) String port,
					@RequestParam(required = false) String company) {

		System.out.println("containers"+type+",  "+country+" ,  "+port+", "+company);
		
		List<Container> availableContainer=ecrContainerService.getAvailableContainers(type,country,port,company);
		
		if (availableContainer == null) {
			return new ResponseEntity("No Available Containers found", HttpStatus.NOT_FOUND);
	}
		return new ResponseEntity(availableContainer, HttpStatus.OK);
		
		
	}
	
	
}
