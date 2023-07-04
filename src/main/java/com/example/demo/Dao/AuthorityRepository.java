package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Authorities;

@Repository
public interface AuthorityRepository extends JpaRepository<Authorities, Long> {

	public Authorities findByAuthoritieName(String authoritieName) ;
}
