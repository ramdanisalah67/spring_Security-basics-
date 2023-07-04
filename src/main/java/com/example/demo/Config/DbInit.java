package com.example.demo.Config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.AuthorityRepository;

import com.example.demo.Dao.UserRepository;
import com.example.demo.entities.Authorities;

import com.example.demo.entities.User;
@Service
public class DbInit implements CommandLineRunner {
	
		private UserRepository myUserRepo ;
		
		private AuthorityRepository myAuthorityRepo ;
		private PasswordEncoder passwordEncoder ;
		@Autowired
		public DbInit(UserRepository myUserRepo,AuthorityRepository myAuthorityRepo,PasswordEncoder ps) {
			
			this.myUserRepo = myUserRepo ;
		
			this.myAuthorityRepo = myAuthorityRepo ;
			this.passwordEncoder = ps ;
			
		}
	@Override
	public void run(String... args) throws Exception {
		
		myUserRepo.deleteAll();
		
		List<Authorities> authorities = myAuthorityRepo.findAll();
		
		
		// Add Admin
		List<Authorities> addAutho = new ArrayList<>() ;
		addAutho.add(myAuthorityRepo.findByAuthoritieName("ACCESS_ALL")) ;
		addAutho.add(myAuthorityRepo.findByAuthoritieName("ROLE_ADMIN")) ;
		User admin = new User(null,"salah","salah@gmail.com",passwordEncoder.encode("111"),25,1,addAutho);
		myUserRepo.save(admin);
		


	
		// Add Manager
	
	List<Authorities> addAutho2 = new ArrayList<>() ;
	addAutho2.add(myAuthorityRepo.findByAuthoritieName("ACCESS_BASIC")) ;
	addAutho2.add(myAuthorityRepo.findByAuthoritieName("ROLE_MANAGER")) ;
	User manager = new User(null,"Ahmed","Ahmed@gmail.com",passwordEncoder.encode("222"),24,1,addAutho2);
	myUserRepo.save(manager);
	
	//Add User
	List<Authorities> addAutho3 = new ArrayList<>() ;
	addAutho3.add(myAuthorityRepo.findByAuthoritieName("ACCESS_PRODUCTS")) ;
	addAutho3.add(myAuthorityRepo.findByAuthoritieName("ROLE_USER")) ;
	User user = new User(null,"yassin","yassin@gmail.com",passwordEncoder.encode("333"),28,1,addAutho3);
	myUserRepo.save(user);
			
	}

}
