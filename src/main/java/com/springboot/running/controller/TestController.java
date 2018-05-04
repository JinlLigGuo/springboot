package com.springboot.running.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
		/**
		 * @GetMapping @PostMapping 组合注解 @RequestMapping(method = RequestMethod.GET or RequestMethod.POST)的缩写
		 */
	
	    @GetMapping("/helloworld")
	    public String helloworld() {
	        return "helloworld";
	    }
	  
	    @RequestMapping(value = "/pis", produces = "text/plain;charset=UTF-8;")
	    @ResponseBody
	    public String helloworld2(String a) {
	        return "helloworld2";
	    }

}
