package splus.ecr.one.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import splus.ecr.one.model.Cart;
import splus.ecr.one.model.Container;
import splus.ecr.one.model.Port;
import splus.ecr.one.repository.EcrCartRepository;
import splus.ecr.one.repository.EcrContainerRepository;
import splus.ecr.one.service.EcrCartService;

@Service("ecrCartService")
public class EcrCartServiceImpl implements EcrCartService {

	@Autowired
	EcrCartRepository ecrCartRepository;
	
	@Autowired
	EcrContainerRepository ecrContainerRepository;

	public Cart getCart(Long id) {

		return ecrCartRepository.findOne(id);
	}

	/*public Cart saveCart(Cart cart) {

		Port destinationPort = cart.getDestinationPort();

		List<Container> containers = cart.getContainers();
		
		for (Container container : containers) {
			
			container.setPort(destinationPort);
			container.setLastUpdateDate(cart.getRequestDate());
			container.setStatus("B");
			
		}
		
		return ecrCartRepository.save(cart);
	}
*/

	public List<Cart> getCartsByCompanyId(Long companyId) {
		
		List<Cart> carts = ecrCartRepository.findByCompanyId(companyId);
		
		for (Iterator<Cart> iterator = carts.iterator(); iterator.hasNext();) {
			
			Cart cart = iterator.next();
		
		   
		}
		
		return carts;
	}

	public List<Cart> getAllCarts() {
		List<Cart> carts = ecrCartRepository.findAll();
		return carts;
	}

	public Cart saveCart(Cart cart) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
