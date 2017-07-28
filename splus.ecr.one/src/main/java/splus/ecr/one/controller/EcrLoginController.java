package splus.ecr.one.controller;

import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class EcrLoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(String email){
	System.out.println("Successful login" ); 
		String loginValue = email;
		return "hello.."+loginValue;
	//	return loginValue;
		
	}
}
