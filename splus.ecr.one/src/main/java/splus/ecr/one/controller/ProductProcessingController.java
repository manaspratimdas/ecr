package splus.ecr.one.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import splus.ecr.one.model.Product;
import splus.ecr.one.service.ProductProcessingService;


@RestController
@RequestMapping("/product")
public class ProductProcessingController {

	@Autowired
	ProductProcessingService productProcessingService;

	@RequestMapping(value = "/display/{id}", method = RequestMethod.GET)
	public Product displayProduct(@PathVariable Long id) {

		return productProcessingService.getProductById(id);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Product create(@RequestBody Product product) {

		return productProcessingService.save(product);

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public void delete(@PathVariable Long id) {

		productProcessingService.delete(id);

	}

	@RequestMapping(value = "/displayall", method = RequestMethod.GET)
	public List<Product> displayAllProduct() {

		return productProcessingService.findAll();
	}

}
