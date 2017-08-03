package splus.ecr.one.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import splus.ecr.one.model.Country;
import splus.ecr.one.service.EcrCountryService;

@RestController
public class EcrCountryController {

	@Autowired
	EcrCountryService ecrCountryService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	public ResponseEntity getCompanies() {

		System.out.println("in companies");

		List<Country> countries = ecrCountryService.getCountries();
		if (countries == null) {
			return new ResponseEntity("No Containers found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(countries, HttpStatus.OK);

	}
}
