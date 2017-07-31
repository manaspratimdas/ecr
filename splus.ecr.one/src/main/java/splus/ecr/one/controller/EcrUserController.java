package splus.ecr.one.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import splus.ecr.one.model.User;
import splus.ecr.one.service.EcrSecurityService;
import splus.ecr.one.service.EcrUserService;

@RestController
@RequestMapping("/user")
public class EcrUserController {
	
	
	@Autowired
	EcrUserService ecrUserService;
	
	@Autowired
    private EcrUserService userService;

    @Autowired
    private EcrSecurityService securityService;

	
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/all_users", method = RequestMethod.GET)
	public ResponseEntity getUsers() {

		System.out.println("in list getAllUsers controller");

		List<User> users = ecrUserService.getUsers();
		if (users == null) {
			return new ResponseEntity("No User found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(users, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity getContainersById(@PathVariable("id") Long id) {

		System.out.println("in list users controller");

		User user = ecrUserService.getUser(id);
		if (user == null) {
			return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(user, HttpStatus.OK);

	}
	

	/**
	 * This will list all the user of a company
	 * @return
	 */

	@RequestMapping(value = "/company/{companyId}/users", method = RequestMethod.GET)
	public ResponseEntity getUsersByCompany(@PathVariable("companyId") Long companyId) {

		System.out.println("in list user controller");

		List<User> users = ecrUserService.getUsersByCompanyId(companyId);
		if (users == null) {
			return new ResponseEntity("No Users found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(users, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/users/update", method = RequestMethod.POST)
	public ResponseEntity saveOrUpdateUsers(@RequestBody List<User> users) {

		System.out.println("in list user controller");
		
		System.out.println("json "+users);

		List<User> updatedUsers = ecrUserService.saveOrUpdateUsers(users);
		if (updatedUsers == null) {
			return new ResponseEntity("No Users found", HttpStatus.NOT_FOUND);
	}
		return new ResponseEntity(updatedUsers, HttpStatus.OK);

	}

}
