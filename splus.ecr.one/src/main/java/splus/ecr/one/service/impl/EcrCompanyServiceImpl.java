package splus.ecr.one.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import splus.ecr.one.model.Company;
import splus.ecr.one.repository.EcrCompanyRepository;
import splus.ecr.one.service.EcrCompanyService;

@Service("ecrCompanyService")
public class EcrCompanyServiceImpl implements EcrCompanyService {

	@Autowired
	EcrCompanyRepository ecrCompanyRepository;
	
	public Company saveCompany(Company company) {
		
		return ecrCompanyRepository.save(company);
	}

	public List<Company> getCompanies() {
		
		return ecrCompanyRepository.findAll();
	}

}
