package com.rickandmorty.rickandmorty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 
 * @author orhan
 *
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getIndex() {
		return "home";
	}

}
