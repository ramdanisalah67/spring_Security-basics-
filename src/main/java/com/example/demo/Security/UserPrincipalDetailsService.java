package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.UserRepository;
import com.example.demo.entities.User;
import com.example.demo.entities.UserPrincipal;

@Service
@SpringBootApplication(scanBasePackages = {"Controller","Dao","entities", "repository"})
public class UserPrincipalDetailsService implements UserDetailsService{

	private UserRepository userRepo ;
	
	@Autowired
	public UserPrincipalDetailsService(UserRepository u) {
		// TODO Auto-generated constructor stub
		this.userRepo = u ;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user = userRepo.findByUsername(username);
	UserPrincipal userPrincipal = new UserPrincipal(user);
	
		return userPrincipal;
	}

	
}
