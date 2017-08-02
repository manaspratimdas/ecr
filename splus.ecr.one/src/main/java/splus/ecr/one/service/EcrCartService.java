package splus.ecr.one.service;

import splus.ecr.one.model.Cart;


public interface EcrCartService {
	
	Cart getCart(Long id);

	Cart saveCart(Cart cart);

}
