package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.*;
@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter{
	private UserPrincipalDetailsService userPrincipalDetailsService ;
	
	
	public SecurityConfig(UserPrincipalDetailsService userPrincipalDetailsService ) {
		// TODO Auto-generated constructor stub
		this.userPrincipalDetailsService = userPrincipalDetailsService ;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
/*		auth
		.inMemoryAuthentication()
		.withUser("salah").password(cryptme().encode("123")).authorities("ACCESS_ALL","ROLE_ADMIN")//roles("ADMIN")
		.and()
		.withUser("ahmed").password(cryptme().encode("111")).roles("MANAGER").authorities("ACCESS_BASIC")
		.and()
		.withUser("omar").password(cryptme().encode("000")).roles("User").authorities("ACCESS_PRODUCTS")
		.and()
		.withUser("Test").password(cryptme().encode("222")).roles("GUEST").authorities("ACCESS_HOME");

	*/
		auth.authenticationProvider(authenticationProvider());
	}
	
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http
	.authorizeRequests()
	.antMatchers("/home").permitAll()
	.antMatchers("/api/products").hasAnyAuthority("ACCESS_PRODUCTS")
	.antMatchers("/api/manage").hasAnyRole("MANAGER","ADMIN") 
	.antMatchers("/basic1/**","/basic2/**").hasAuthority("ACCESS_BASIC")
	.antMatchers("/api/profile").authenticated()
	.antMatchers("/api/info").hasAuthority("ACCESS_HOME")
	.antMatchers("/api/welcome").authenticated()
	//.antMatchers("/api/profile/**").hasRole("ADMIN")
	
	.and().formLogin().loginProcessingUrl("/signin")
	.loginPage("/api/login")
	.usernameParameter("myuser").passwordParameter("mypassword")
	.and()
	.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/api/login") ;
	 
	
	}
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(cryptme());
		daoAuthenticationProvider.setUserDetailsService(userPrincipalDetailsService);
		return daoAuthenticationProvider ;
	}
	
	@Bean
PasswordEncoder cryptme() {
	return new BCryptPasswordEncoder();
}
}
