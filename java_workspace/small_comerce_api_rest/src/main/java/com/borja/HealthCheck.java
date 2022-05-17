package com.borja;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
public class HealthCheck {
	
	@RequestMapping(value = "/healtcheck", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String deleteCliend() throws Exception {
		return "ok";
	}

}
