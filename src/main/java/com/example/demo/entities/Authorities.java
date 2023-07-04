package com.example.demo.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
@Entity
@Data
public class Authorities {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id ;
	private String authoritieName ;
	@ManyToMany(mappedBy = "authorities")
	private List<User> users ;
	@Override
	public String toString() {
		return "Authorities [id=" + id + ", authoritieName=" + authoritieName + ", users=" + users + "]";
	}
	
}
