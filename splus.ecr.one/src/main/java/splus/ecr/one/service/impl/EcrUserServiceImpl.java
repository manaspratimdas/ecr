package splus.ecr.one.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import splus.ecr.one.model.User;
import splus.ecr.one.repository.EcrUserRepository;
import splus.ecr.one.service.EcrUserService;

@Service("ecrUserService")
public class EcrUserServiceImpl implements EcrUserService {

	@Autowired
	EcrUserRepository ecrUserRepository;

	public User findByName(String name) {

		return ecrUserRepository.findByName(name);

	}

	public User saveUser(User ecrUser) {
		
		
		return ecrUserRepository.save(ecrUser);
	}

}
