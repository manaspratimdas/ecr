package splus.ecr.one.service;

import java.util.List;

import splus.ecr.one.model.Cart;

public interface EcrCartService {
	
	Cart getCart(Long id);

	
	Cart saveCart(Cart cart);

	
	List<Cart> getCartsByCompanyId(Long companyId);


	List<Cart> getAllCarts();

}
