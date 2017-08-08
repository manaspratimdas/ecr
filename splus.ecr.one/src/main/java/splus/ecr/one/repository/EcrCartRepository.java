package splus.ecr.one.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import splus.ecr.one.model.Cart;

public interface EcrCartRepository extends JpaRepository<Cart, Long>{

	
	List<Cart> findByCompanyId(Long companyId);	
	

}
