package splus.ecr.one.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import splus.ecr.one.model.Cart;

public interface EcrCartRepository extends JpaRepository<Cart, Long>{

}
