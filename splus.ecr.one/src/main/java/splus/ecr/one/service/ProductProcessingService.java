package splus.ecr.one.service;

import java.util.List;

import splus.ecr.one.model.Product;



public interface ProductProcessingService {
	
	public Product getProductById(Long id);

	public Product save(Product product);

	public void delete(Long id);

	public List<Product> findAll();

}
