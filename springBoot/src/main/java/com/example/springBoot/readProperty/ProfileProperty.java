package com.example.springBoot.readProperty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Configuration
//@Profile("prod")
public class ProfileProperty {
	
	@Value("${name}")
	private String name;
	
	public String getName() {
		return name;
	}
	

}
