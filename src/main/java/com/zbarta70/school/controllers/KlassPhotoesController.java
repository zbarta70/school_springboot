package com.zbarta70.school.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KlassPhotoesController {
	
	@GetMapping("/klassPhotoes")
	public String goKlassPhotoes() {
		return "klassPhotoes";
	}
}
