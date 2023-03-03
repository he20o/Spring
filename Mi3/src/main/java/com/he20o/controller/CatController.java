package com.he20o.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/cat/*")
public class CatController {

	@GetMapping("/main")
	public void main() {
		
	}
	
	@GetMapping("/index")
	public void index() {
		
	}
}
