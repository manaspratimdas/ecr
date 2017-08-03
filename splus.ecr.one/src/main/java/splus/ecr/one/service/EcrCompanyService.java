package splus.ecr.one.service;

import java.util.List;

import splus.ecr.one.model.Company;


public interface EcrCompanyService {

	Company saveCompany(Company company);

	List<Company> getCompanies();
}
