package com.springboot.running.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("freemarker")
public class FreemarkerController {
	

	    @RequestMapping("/hello")
	    public String hello(Map<String,Object> map) {
	        
	        map.put("msg", "Hello Freemarker");
	        return "hello";
	    }


	    @RequestMapping("/websocket")
	    public String websocket(Map<String,Object> map) {
	        
	        return "websocket";
	    }
	    
}
