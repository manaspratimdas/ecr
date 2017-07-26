package splus.ecr.one.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import splus.ecr.one.model.Container;
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
	

	public List<User> getUsers() {
		
		System.out.println("in user service");
		List<User> lstUser=ecrUserRepository.findAll();
		
		for(int i=0;i<lstUser.size();i++){
			System.out.println("user  ->>>"+lstUser.get(i));
		}
		
		return lstUser;
	}

	public User getUserById(Long id) {
		
		System.out.println("in service  getUserById");
		return ecrUserRepository.findOne(id);
	}

	public User getUser(Long id) {
		
		return ecrUserRepository.findById(id);
	}

	public List<User> getUsersByCompanyId(Long companyId) {
		
		
		return ecrUserRepository.findByCompanyId(companyId);
	}

	public List<User> saveOrUpdateUsers(List<User> users) {

		return ecrUserRepository.save(users);
	}

}
