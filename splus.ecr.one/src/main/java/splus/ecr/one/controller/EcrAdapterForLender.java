package splus.ecr.one.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import splus.ecr.one.model.Cart;
import splus.ecr.one.model.Container;
import splus.ecr.one.service.EcrCartService;
@RestController
@RequestMapping(value = "/adapter")
public class EcrAdapterForLender {
	
	@Autowired
	EcrCartService ecrCartService;
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/cart/lender/{companyId}", method = RequestMethod.GET)
	public ResponseEntity getCarts(@PathVariable("companyId") Long companyId) {

		System.out.println("in list cart controller");
		List<Container> containersofCompany= new ArrayList<Container>();
		Long check = companyId;
		List<Cart> carts = ecrCartService.getAllCarts(companyId);
		List<Map<String,String>> transaction=new ArrayList<Map<String,String>>();
		if (carts == null) {
			return new ResponseEntity("No carts found", HttpStatus.NOT_FOUND);
		}
		else{
				
				for(Cart cart: carts){
					System.out.println("all carts : "+cart.getId());
					List<Container> containers =  cart.getContainers();
					for(Container container : containers){
						
						Long companyIdvalue = container.getCompany().getId();
						System.out.println("container id : "+container.getId() +" code : " +container.getCode());
						
						if(check.equals(companyIdvalue)){
							System.out.println("checked value of company : "+companyIdvalue);
							containersofCompany.add(container);
							
							Map<String,String> transactionRow=new HashMap<String,String>();

							transactionRow.put("id", cart.getId().toString());
							System.out.println("cart id : "+ cart.getId().toString());
							transactionRow.put("pickUpDate", cart.getPickUpDate().toString());
							System.out.println("pickupDate : "+cart.getPickUpDate().toString());
							transactionRow.put("portSource", cart.getPortSource());
							System.out.println("portSource : "+cart.getPortSource());
							transactionRow.put("portDestination", cart.getPortDestination());
							System.out.println("portDestination : "+ cart.getPortDestination());
							transactionRow.put("ETA", cart.getNote());
							System.out.println("ETA : "+cart.getNote());
							transactionRow.put("containerCode", container.getCode());
							System.out.println("containerCode : "+container.getCode());
							transactionRow.put("sizeType", container.getContainerType().getType()+container.getContainerType().getSize());
							System.out.println("sizeType : "+container.getContainerType().getType()+container.getContainerType().getSize());
							
							transaction.add(transactionRow);
							
							System.out.println("transaction : "+transaction);
							System.out.println("Matched : "  +  container.getId());
						}else{
							System.out.println("Unmatched : "  +  container.getId());
						}
						
					}

			} 

				for(int i=0;i<transaction.size();i++){
					
					System.out.println("---------------------");
					Map<String,String> transactiontemp=transaction.get(i);
					System.out.println("transactiontemp : "+ transactiontemp);
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
}
