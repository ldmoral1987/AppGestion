package com.empresa.appinventario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String loadRoot(Model model)
	{	
		return "index";
	}
	
	@GetMapping("/index")
	public String loadIndex(Model model)
	{	
		return "index";
	}
}
