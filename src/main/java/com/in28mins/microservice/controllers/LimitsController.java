/**
 * 
 */
package com.in28mins.microservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28mins.microservice.beans.Limits;
import com.in28mins.microservice.configurations.LimitConfiguration;

/**
 * @author Sameer
 *
 */
@RestController
public class LimitsController {
	
	@Autowired private LimitConfiguration limitConfiguration;
	
	@GetMapping("/limits")
	public Limits limits() {
		return new Limits(new Integer(1), new Integer(1000));
	}
	
	// Fetching data from application.properties file though LimitConfiguration
	@GetMapping("/config/limits")
	public Limits configLimits() {
		return new Limits(limitConfiguration.getMinimum(), limitConfiguration.getMaximum());
	}
}
