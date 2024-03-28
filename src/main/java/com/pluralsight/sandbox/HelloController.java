package com.pluralsight.sandbox;

import java.util.Objects;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pluralsight.sandbox.datasource.Read;
import com.pluralsight.sandbox.model.Planet;
import com.pluralsight.sandbox.repositories.PlanetRepository;

@RestController
public class HelloController {
	
	@Autowired
	private PlanetRepository planetRepo;

    @GetMapping("/")
    public String index() {
        System.out.println("Request recieved to root");
        return "Greetings from Fran!";
    }
    
    @GetMapping("/test")
    public String test() {
    	System.out.printf("test api call", "test");
    	return "test successful";
    	
    }
    
    @GetMapping("/fetchStudent/{studentId}")
    public String fetchStudentById(@PathVariable("studentId") Integer studentId) {
    	System.out.printf("student api call " + studentId);
    	
    	String student = Read.readStudent(studentId);
    	
    	return "Student Requested: " + student;
    	
    }
    
    @GetMapping("/fetchPlanetByOrderFromSun/{orderFromSun}")
    public String fetchPlanetByOrderFromSun(@PathVariable("orderFromSun") Integer orderFromSun) {
    	System.out.printf("planet api call get order from sun" + orderFromSun);
    	
    	Planet planet = planetRepo.findByOrderFromSun(orderFromSun);
    	
    	if(Objects.isNull(planet)) {
    		return "no planet found at position " + orderFromSun;
    	} else {
    		return "Planet Requested: " + planet.name;
    	}
    	
    }
    
    

}
