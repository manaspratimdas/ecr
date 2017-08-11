package splus.ecr.one.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import splus.ecr.one.model.Role;
import splus.ecr.one.model.User;
import splus.ecr.one.repository.EcrRoleRepository;
import splus.ecr.one.repository.EcrUserRepository;
import splus.ecr.one.service.EcrUserService;

@Service("ecrUserService")
public class EcrUserServiceImpl implements EcrUserService, UserDetailsService {

	@Autowired
	EcrUserRepository ecrUserRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
    private EcrRoleRepository roleRepository;

	public User findByName(String name) {

		return ecrUserRepository.findByName(name);

	}

	public User saveUser(User ecrUser) {

		return ecrUserRepository.save(ecrUser);
	}

	public List<User> getUsers() {

		System.out.println("in user service");
		List<User> lstUser = ecrUserRepository.findAll();

		for (int i = 0; i < lstUser.size(); i++) {
			System.out.println("user  ->>>" + lstUser.get(i));
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

	public User findByUsername(String username) {

		
		return ecrUserRepository.findUserByUsername(username);
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		String username1="manas";
		User user = ecrUserRepository.findUserByUsername(username1);
		
		System.out.println("MPD  user is >>>>>>>>>>>> "+user);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();

		for (Role role : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				grantedAuthorities);
	}

	public User save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<Role>(roleRepository.findAll()));
        return ecrUserRepository.save(user);
		
	}

	public Map<String, Object> login(String email, String password) {
		User user = new User();
		user.setUsername(email);
		user.setPassword(password);
		user = ecrUserRepository.login(user);
		
		Map<String, Object> result = new HashMap<String, Object>();
		if(user!=null){
			result.put("username", user.getUsername());
			result.put("companyId", String.valueOf(user.getCompany().getId()));
			result.put("companyName", String.valueOf(user.getCompany().getName()));
			result.put("userIP", "127.0.0.1");
			StringBuilder roles = new StringBuilder();
			for (Role role  : user.getRoles()) {
				roles.append(role.getId()).append("~~").append(role.getName()).append(",");
			}			
			result.put("roles", roles.substring(0,roles.length()>0?roles.length()-1:0));
			result.put("status", "1");
		}else{
			result.put("status", "0");
		}
		return result;
	}

}
