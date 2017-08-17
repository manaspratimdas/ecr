package splus.ecr.one.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.keygen.StringKeyGenerator;
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
	
	/*------------------------------------------------------------------------------------------------------------------------------Transaction----------------------------------------*/

	@SuppressWarnings("unused")
	@RequestMapping(value = "/cart/borrower/trans/{companyId}", method = RequestMethod.GET)
	public ResponseEntity getCartsforTransBorrower(@PathVariable("companyId") Long companyId) {

		System.out.println("in list cart controller");

		List<Cart> carts = ecrCartService.getCartsByCompanyId(companyId);
		
		
		List<Map<String,String>> transaction=new ArrayList<Map<String,String>>();
		for(Cart cart:carts){
			
					
			List<Container> containers=cart.getContainers();
			
			
			for(Container container:containers){
				
				Map<String,String> transactionRow=new HashMap<String,String>();
				
				transactionRow.put("code", String.valueOf(container.getId()));
				transactionRow.put("pickUpDate", String.valueOf(cart.getPickUpDate()));
				
				transactionRow.put("portSource", cart.getPortSource());
				transactionRow.put("portDestination", cart.getPortDestination());
				transactionRow.put("ETA", cart.getNote());
				transactionRow.put("containerCode", container.getCode());
				transactionRow.put("sizeType", container.getContainerType().getType()+container.getContainerType().getSize());
				transactionRow.put("companyName", container.getCompany().getName());
				
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
	
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/cart/lender/trans/{companyId}", method = RequestMethod.GET)
	public ResponseEntity getCartsforTransaction(@PathVariable("companyId") Long companyId) {

		System.out.println("in list cart controller");
		List<Container> containersofCompany= new ArrayList<Container>();
		Long check = companyId;
		List<Cart> carts = ecrCartService.getAllCarts();
		List<Map<String,String>> transaction=new ArrayList<Map<String,String>>();
		if (carts == null) {
			return new ResponseEntity("No carts found", HttpStatus.NOT_FOUND);
		}
		else{
				
				for(Cart cart: carts){
					System.out.println("all carts : "+cart.getId());
					List<Container> containers =  cart.getContainers();
					String companyName = cart.getCompany().getName();
					System.out.println("company name for cart : "+companyName);
					int count=1;
					for(Container container : containers){
						
						Long companyIdvalue = container.getCompany().getId();
						System.out.println("container id : "+container.getId() +" code : " +container.getCode());
						
						if(check.equals(companyIdvalue)){
							System.out.println("checked value of company : "+companyIdvalue);
							containersofCompany.add(container);
							
							Map<String,String> transactionRow=new HashMap<String,String>();

							transactionRow.put("code", String.valueOf(container.getId()));
							transactionRow.put("pickUpDate",  String.valueOf(cart.getPickUpDate()));
							transactionRow.put("portSource", cart.getPortSource());
							transactionRow.put("portDestination", cart.getPortDestination());
							transactionRow.put("ETA",  String.valueOf(cart.getReleaseDate()));
							transactionRow.put("companyName", companyName);
							transactionRow.put("containerCode", container.getCode());
							transactionRow.put("sizeType", container.getContainerType().getType()+container.getContainerType().getSize());
							transactionRow.put("SrNo", String.valueOf(count++));
							transaction.add(transactionRow);
							
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
	/*------------------------------------------------------------------------------------------------------------------------------MyAction----------------------------------------*/
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/cart/lender/action/{companyId}", method = RequestMethod.GET)
	public ResponseEntity getCartsforMyAction(@PathVariable("companyId") Long companyId) {

		System.out.println("in list cart controller");
		List<Container> containersofCompany= new ArrayList<Container>();
		Long check = companyId;
		List<Cart> carts = ecrCartService.getAllCarts();
		List<Map<String,String>> transaction=new ArrayList<Map<String,String>>();
		if (carts == null) {
			return new ResponseEntity("No carts found", HttpStatus.NOT_FOUND);
		}
		else{
				
				for(Cart cart: carts){
					System.out.println("all carts : "+cart.getId());
					List<Container> containers =  cart.getContainers();
					String companyName = cart.getCompany().getName();
					int count=1;
					for(Container container : containers){
						
						if("R".equals(container.getStatus())){
							Long companyIdvalue = container.getCompany().getId();
							System.out.println("container id : "+container.getId() +" code : " +container.getCode());
							
							if(check.equals(companyIdvalue)){
								System.out.println("checked value of company : "+companyIdvalue);
								containersofCompany.add(container);
								
								Map<String,String> transactionRow=new HashMap<String,String>();

								transactionRow.put("code", container.getId().toString());
								transactionRow.put("pickUpDate", cart.getPickUpDate().toString());
								transactionRow.put("portSource", cart.getPortSource());
								transactionRow.put("portDestination", cart.getPortDestination());
								transactionRow.put("ETA", cart.getReleaseDate().toString());
								transactionRow.put("companyName", companyName);
								transactionRow.put("containerCode", container.getCode());
								transactionRow.put("sizeType", container.getContainerType().getType()+container.getContainerType().getSize());
								transactionRow.put("SrNo", String.valueOf(count++));
								transaction.add(transactionRow);
								
							}else{

								System.out.println("Unmatched : "  +  container.getId());
							}
							
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
		
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/cart/borrower/action/{companyId}", method = RequestMethod.GET)
	public ResponseEntity getCartsforActionBorrower(@PathVariable("companyId") Long companyId) {

		System.out.println("in list cart controller");

		List<Cart> carts = ecrCartService.getCartsByCompanyId(companyId);
		
		
		List<Map<String,String>> transaction=new ArrayList<Map<String,String>>();
		for(Cart cart:carts){
			
					
			List<Container> containers=cart.getContainers();
			
			
			for(Container container:containers){
				
				Map<String,String> transactionRow=new HashMap<String,String>();
				
				if("B".equals(container.getStatus())) {
					
				transactionRow.put("code",  String.valueOf(container.getId()));
				transactionRow.put("pickUpDate",  String.valueOf(cart.getPickUpDate()));
				transactionRow.put("portSource", cart.getPortSource());
				transactionRow.put("portDestination", cart.getPortDestination());
				transactionRow.put("ETA", cart.getNote());
				transactionRow.put("containerCode", container.getCode());
				transactionRow.put("sizeType", container.getContainerType().getType()+container.getContainerType().getSize());
				transactionRow.put("companyName", container.getCompany().getName());
				
				transaction.add(transactionRow);
				}
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
