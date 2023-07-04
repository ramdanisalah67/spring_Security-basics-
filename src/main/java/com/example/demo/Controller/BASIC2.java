package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("basic2/")
public class BASIC2 {

	@GetMapping("hello")
	public String hello() {
		return "hello welcome from basic 2" ;
	}
}
