package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/")
public class SimpleController {

	@GetMapping("home")
	public String index() {
		return "index" ;
	}
	@GetMapping("login")
	public String login() {
		return "login" ;
	}
	@GetMapping("welcome")
	public String weclome() {
		return "welcome" ;
	}
}
