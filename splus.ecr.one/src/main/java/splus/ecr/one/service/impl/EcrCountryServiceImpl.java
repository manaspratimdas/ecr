package splus.ecr.one.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import splus.ecr.one.model.Country;
import splus.ecr.one.repository.EcrCountryRepository;
import splus.ecr.one.service.EcrCountryService;

@Service
public class EcrCountryServiceImpl implements EcrCountryService{

	@Autowired
	EcrCountryRepository ecrCountryRepository;
	
	public List<Country> getCountries() {
		
		return ecrCountryRepository.findAll();
	}

}
