package splus.ecr.one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import splus.ecr.one.model.Cart;
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

}
