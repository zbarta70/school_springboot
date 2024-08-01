package com.zbarta70.school.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
	
	@GetMapping("/about")
	public String goAbout() {
		return "about";
	}
}
