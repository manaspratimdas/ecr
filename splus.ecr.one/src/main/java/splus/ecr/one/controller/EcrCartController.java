package splus.ecr.one.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import splus.ecr.one.model.Cart;
import splus.ecr.one.model.Company;
import splus.ecr.one.model.Container;
import splus.ecr.one.service.EcrCartService;

@RestController
@RequestMapping(value = "/cart")
public class EcrCartController {

	@Autowired
	EcrCartService ecrCartService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity getCartById(@PathVariable("id") Long id) {

		System.out.println("in cart controller");

		Cart cart = ecrCartService.getCart(id);

		if (cart == null) {
			return new ResponseEntity("No cart found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(cart, HttpStatus.OK);

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity saveCart(@RequestBody Cart cart) {

		System.out.println("cart >>"+cart);

		Cart newCart = ecrCartService.saveCart(cart);

		if (newCart == null) {
			return new ResponseEntity("No Cart found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(cart, HttpStatus.OK);

	}
	
	/**
	 * This will list carts of a company
	 * @return
	 */

	@RequestMapping(value = "/company/{companyId}", method = RequestMethod.GET)
	public ResponseEntity getCartsByCompany(@PathVariable("companyId") Long companyId) {

		System.out.println("in list cart controller");

		List<Cart> carts = ecrCartService.getCartsByCompanyId(companyId);
		if (carts == null) {
			return new ResponseEntity("No carts found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(carts, HttpStatus.OK);

	}
	

	/*@RequestMapping(value = "/lender/{companyId}", method = RequestMethod.GET)
	public ResponseEntity getCarts(@PathVariable("companyId") Long companyId) {

		System.out.println("in list cart controller");
		List<Container> containersofCompany= new ArrayList<Container>();
		Long check = companyId;
		List<Cart> carts = ecrCartService.getAllCarts();
		if (carts == null) {
			return new ResponseEntity("No carts found", HttpStatus.NOT_FOUND);
		}
		else{
				
				for(Cart cartlist: carts){
				
					List<Container> containersOfCart =  cartlist.getContainers();
					for(Container containerlist : containersOfCart){
						
						Long companyIdvalue = containerlist.getCompany().getId();
						if(check.equals(companyIdvalue)){
							containersofCompany.add(containerlist);
	
							
						}
						
					}

			} 
			
		}
		return new ResponseEntity(containersofCompany, HttpStatus.OK);

	}*/

}
