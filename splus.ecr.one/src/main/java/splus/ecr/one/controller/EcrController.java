package splus.ecr.one.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import splus.ecr.one.model.Company;
import splus.ecr.one.model.*;

@RestController
@RequestMapping("/test")
public class EcrController {

	@RequestMapping(value = "/testmyapp", method = RequestMethod.GET)
	public String testEcrApp() {
		
		Company company=new Company();
		company.setId(1L);
		company.setName("My Test Company");
		
		Address address=new Address();
		address.setAddressLineOne("house number 71");
		address.setCity("Pune");
		address.setId(11L);
		address.setStreetName("HandewadiRoad");
		address.setZip("411028");
		
		Country country=new Country();
		country.setId(222L);
		country.setIsoCountryCode("IND");
		
		Region region =new Region();
		region.setId(333L);
		region.setName("Asia");
		region.setRegionCode("AS");
		
		country.setRegion(region);
		
		address.setCountry(country);
		
		company.setAddress(address);
		
		
		
		
		
		
		return "test succssfull- you can proceed";

	}

}
