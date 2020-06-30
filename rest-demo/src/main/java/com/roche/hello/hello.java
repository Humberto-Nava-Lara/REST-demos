package com.roche.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {

	@RequestMapping("/hello")
	public String sayHello() {
		return "hello";
	}
}
