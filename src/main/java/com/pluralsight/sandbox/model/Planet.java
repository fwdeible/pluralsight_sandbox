package com.pluralsight.sandbox.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Accessors
@Document("planets")
public class Planet {

	@Id
	public String id;
	
	public String name;
	public int orderFromSun;
	public boolean hasRings;
	public List<String> mainAtmosphere; 
	public HashMap<String, String> surfaceTemp;
}
