package splus.ecr.one.service;

import splus.ecr.one.model.User;

public interface EcrUserService {

	User findByName(String name);
	
	User saveUser(User ecrUser);
}
