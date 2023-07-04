package com.example.demo.entities;

import org.hibernate.annotations.GeneratorType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

import 	javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private String username ;
	private String email ;
	private String password ;
	private int age ;
	private int active ;

	
	
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "user_authorities",
			joinColumns = {@JoinColumn(name="user_id")},
			inverseJoinColumns = {@JoinColumn(name="authoritie_id")}
			
			)
	
	private List<Authorities> authorities ;
	
}
