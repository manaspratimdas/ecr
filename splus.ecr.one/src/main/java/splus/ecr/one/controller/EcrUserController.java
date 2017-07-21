package splus.ecr.one.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import splus.ecr.one.model.User;
import splus.ecr.one.service.EcrUserService;

@RestController
@RequestMapping("/user")
public class EcrUserController {
	
	
	@Autowired
	EcrUserService ecrUserService;
	
	@RequestMapping(value = "/testuserapi", method = RequestMethod.GET)
	public String testEcrApp() {
		return "User test succssfull- you can proceed";

	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getUser() {
		
		
		return "User test succssfull- you can proceed";

	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
	public User createUser(InputStream userJson) throws IOException{
		
		
		String srtUsr = IOUtils.toString(userJson);
	
		System.out.println("in createUser---> "+srtUsr);
		Gson gson = new Gson();
		User ecrUser = gson.fromJson(srtUsr, User.class);
		
		ecrUserService.saveUser(ecrUser);
		
		System.out.println("ecrUser"+ecrUser);
		
		return ecrUser;
		
	}

}
