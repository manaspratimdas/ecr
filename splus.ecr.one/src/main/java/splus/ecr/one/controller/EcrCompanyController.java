package splus.ecr.one.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import splus.ecr.one.model.Address;
import splus.ecr.one.model.Company;
import splus.ecr.one.model.Country;
import splus.ecr.one.model.Region;
import splus.ecr.one.service.EcrCompanyService;

@RestController
@RequestMapping("/company")
public class EcrCompanyController {

	@Autowired
	EcrCompanyService ecrCompanyService;
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testEcrApp() {
		return "Company test succssfull- you can proceed";

	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public Company createCompany(InputStream companyJson) throws IOException{
		
		
		String strCompany = IOUtils.toString(companyJson);
	
		System.out.println("in srtCompany---> "+strCompany);
		Gson gson = new Gson();
		Company ecrCompany = gson.fromJson(strCompany, Company.class);
		
		ecrCompanyService.saveCompany(ecrCompany);
		
		System.out.println("ecrUser"+ecrCompany);
		
		return ecrCompany;
		
	}
	
	@RequestMapping(value = "/testsave", method = RequestMethod.GET)
	public Company testSave() {
		
		Company company=new Company();
		//company.setId(1L);
		company.setName("My Test Company");
		
		Address address=new Address();
		address.setAddressLineOne("house number 71");
		address.setCity("Pune");
		address.setId(11L);
		address.setStreetName("HandewadiRoad");
		address.setZip("411028");
		
		Country country=new Country();
		//country.setId(222L);
		country.setIsoCountryCode("IND");
		
		Region region =new Region();
		//region.setId(333L);
		region.setName("Asia");
		region.setRegionCode("AS");
		
		country.setRegion(region);
		
		address.setCountry(country);
		
		company.setAddress(address);
		
		
		ecrCompanyService.saveCompany(company);
		
		
		
		return company;

	}

}
