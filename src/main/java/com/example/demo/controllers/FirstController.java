package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {

    @RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String helloFirstAll() {
		return "<h1>Hello all!!</h1>";
	}

	@RequestMapping(value = "hello", method = RequestMethod.POST)
	@ResponseBody
	public String hello(@RequestParam("name") String name) {
		return "Hello, <a href=\"https://www.vk.com\">"+name+"</a>!";
	}
    
}
