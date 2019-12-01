package com.evolent.resources;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evolent.beans.AuthenticationBean;



@RestController
@CrossOrigin(origins = "http://localhost:4200/", allowCredentials = "false", allowedHeaders = "*")
@RequestMapping("/api")
public class BasicAuthController {

	@GetMapping(path = "/basicauth")
	public AuthenticationBean helloWorldBean() {
		return new AuthenticationBean("You are authenticated");
	}
}
