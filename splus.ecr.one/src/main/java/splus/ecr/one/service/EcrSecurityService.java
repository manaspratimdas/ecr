package splus.ecr.one.service;

public interface EcrSecurityService {

	String findLoggedInUsername();

    void autologin(String username, String password);
}
