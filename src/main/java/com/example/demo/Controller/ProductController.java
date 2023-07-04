package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class ProductController {
	

	@GetMapping("products")
	public String lister() {
		return "{name='ball',price= '25$' }" ;
	}
	@GetMapping("profile")
	public String profile() {
		return "{this page just for Admin }" ;
	}
	@GetMapping("profile/view")
	public String seq() {
		return "{Admins Profils }" ;
	}
	@GetMapping("manage")
	public String manage() {
		return "{this page just for manage }" ;
	}
	@GetMapping("info")
	public String info() {
		return "{if you need informations about website you need to sign in and became a User }" ;
	}
}

