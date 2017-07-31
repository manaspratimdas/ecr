package splus.ecr.one.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import splus.ecr.one.service.EcrSecurityService;

@Service
public class EcrSecurityServiceImpl implements EcrSecurityService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	public String findLoggedInUsername() {
		 Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
	        if (userDetails instanceof UserDetails) {
	            return ((UserDetails)userDetails).getUsername();
	        }

	        return null;
	}

	public void autologin(String loginId, String password) {
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(loginId);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            System.out.println("Auto login %s successfully!  "+loginId);
            
            
        }

	}

}
