package splus.ecr.one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import splus.ecr.one.model.Region;
import splus.ecr.one.service.EcrRegionService;

@RestController
@RequestMapping("/region")
public class EcrRegionController {

	@Autowired
	EcrRegionService ecrRegionService;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public Region createRegion(){
		
		Region region=new Region();
		region.setName("Asia");
		region.setRegionCode("AS");
		//region.set
		
		return ecrRegionService.create(region);
		
		
		
	}
}
