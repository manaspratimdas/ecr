package splus.ecr.one.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import splus.ecr.one.model.Cart;
import splus.ecr.one.model.Container;
import splus.ecr.one.service.EcrCartService;

@RestController
@RequestMapping(value = "/adapter")
public class EcrOneAdapter {

	@Autowired
	EcrCartService ecrCartService;
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/cart/company/{companyId}", method = RequestMethod.GET)
	public ResponseEntity getCartsByCompany(@PathVariable("companyId") Long companyId) {

		System.out.println("in list cart controller");

		List<Cart> carts = ecrCartService.getCartsByCompanyId(companyId);
		
		
		List<Map<String,String>> transaction=new ArrayList<Map<String,String>>();
		for(Cart cart:carts){
			
					
			List<Container> containers=cart.getContainers();
			
			
			for(Container container:containers){
				
				Map<String,String> transactionRow=new HashMap<String,String>();
				
				transactionRow.put("SOURCE", cart.getPortSource());
				transactionRow.put("CONTAINER_CODE", container.getCode());
				transactionRow.put("CONTAINER_TYPE", container.getContainerType().getType()+container.getContainerType().getSize());
				transaction.add(transactionRow);
				
				
			}
		}
		
		
		for(int i=0;i<transaction.size();i++){
			
			System.out.println("---------------------");
			Map<String,String> transactiontemp=transaction.get(i);
			for (Map.Entry<String, String> entry : transactiontemp.entrySet()) {
				System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
			}
			
			System.out.println("------------------------");
			
		}
		
		if (transaction == null) {
			return new ResponseEntity("No transaction found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(transaction, HttpStatus.OK);

	}
}
