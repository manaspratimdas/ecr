package splus.ecr.one.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import splus.ecr.one.model.Container;
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/regions", method = RequestMethod.GET)
	public ResponseEntity getRegions() {

		System.out.println("in list getAllRegions controller");

		List<Region> regions = ecrRegionService.getRegions();
		if (regions == null) {
			return new ResponseEntity("No Regions found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(regions, HttpStatus.OK);

	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/regions/{id}", method = RequestMethod.GET)
	public ResponseEntity getRegionsById(@PathVariable("id") Long id) {

		System.out.println("in list region controller");

		Region region = ecrRegionService.getRegion(id);
		if (region == null) {
			return new ResponseEntity("No Region found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(region, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/company/{companyId}", method = RequestMethod.GET)
	public ResponseEntity getContainersByCompany(@PathVariable("companyId") Long companyId) {

		System.out.println("in list region controller");

		List<Region> regions = ecrRegionService.getRegionsByCompanyId(companyId);
		if (regions == null) {
			return new ResponseEntity("No Regions found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(regions, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/regions/update", method = RequestMethod.POST)
	public ResponseEntity saveOrUpdateRegions(@RequestBody List<Region> regions) {

		System.out.println("in list region controller");
		
		System.out.println("json "+regions);

		List<Region> updatedRegions = ecrRegionService.saveOrUpdateRegions(regions);
		if (updatedRegions == null) {
			return new ResponseEntity("No Regions found", HttpStatus.NOT_FOUND);
	}
		return new ResponseEntity(updatedRegions, HttpStatus.OK);

	}
}

