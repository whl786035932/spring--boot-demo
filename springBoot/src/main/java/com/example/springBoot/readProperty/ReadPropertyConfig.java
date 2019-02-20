package com.example.springBoot.readProperty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReadPropertyConfig {
	
	@Value("${com.example.description}")
	private String projectDesc;
	
	
	public String getProjectDesc() {
		return this.projectDesc;
	}

}
