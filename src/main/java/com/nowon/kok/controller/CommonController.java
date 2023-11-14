package com.nowon.kok.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

	@GetMapping ("/signin")
	public String signin() {
		return "sign/signin";
	}

	@GetMapping ("/signup")
	public String signup() {
		return "sign/signup";
	}
}
