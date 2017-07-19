package splus.ecr.one.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import splus.ecr.one.model.Address;

@Repository
public interface EcrAddressRepository extends JpaRepository<Address, Long>{
	
	Address save(Address address);

}
