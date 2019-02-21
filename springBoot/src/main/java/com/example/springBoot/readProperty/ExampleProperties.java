package com.example.springBoot.readProperty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration

public class ExampleProperties {
	
	@Value("${com.example.title}")
	private String title;
	
	
	@Value("${com.example.description}")
	private String description;
	
	
	


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
}
