package splus.ecr.one.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import splus.ecr.one.model.Country;

public interface EcrCountryRepository extends JpaRepository<Country, Long>{

}
