package splus.ecr.one.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import splus.ecr.one.model.Company;

@Repository
public interface EcrCompanyRepository extends JpaRepository<Company, Long> {

	Company save(Company company);
}
