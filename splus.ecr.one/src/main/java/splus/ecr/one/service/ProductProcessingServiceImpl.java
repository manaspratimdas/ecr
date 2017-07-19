package splus.ecr.one.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import splus.ecr.one.model.Product;
import splus.ecr.one.repository.ProductRepository;



@Service("productProcessingService")
public class ProductProcessingServiceImpl implements ProductProcessingService {
	
	@Autowired
	ProductRepository repository;
	
	public Product getProductById(Long id){
		
		return repository.findById(id);
		
	}

	public Product save(Product product) {
		
		return repository.save(product);
		
	}

	public void delete(Long id) {
		
		repository.delete(id);
		
	}

	public List<Product> findAll() {
		
		return repository.findAll();
	}
}
