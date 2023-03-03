package com.he20o.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.he20o.domain.cat.vo.Cat;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/api/")
@AllArgsConstructor
@RestController		//json으로 내려줌
public class ApiCatController {
	@GetMapping("/catOne")
	public Cat getCatOne() {
		Cat cat = new Cat();
		cat.setName("야옹이");
		cat.setAge(5);
		return cat;
	}
	
	@GetMapping("/catTwo")
	public Cat getCatTwo() {
		Cat cat = new Cat();
		cat.setName("고양이");
		cat.setAge(10);
		return cat;
	}

}
