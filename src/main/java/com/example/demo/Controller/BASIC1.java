package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("basic1/")
public class BASIC1 {
@GetMapping("hello")
	public String hello() {
		return "hello welcome from basic 1" ;
	}
}
