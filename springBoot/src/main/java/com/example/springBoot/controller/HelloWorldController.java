package com.example.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBoot.readProperty.InfoConfig;
import com.example.springBoot.readProperty.PropertySouceValue;
import com.example.springBoot.readProperty.PropertySourceConfigurationProperties;
import com.example.springBoot.readProperty.ReadPropertyConfig;

/**
 * @RestController的意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了！
 * @author whl
 *
 */
@RestController
public class HelloWorldController {
	
	@Autowired
	private ExampleProperties exampleProperties;
	
	@Autowired
	private ReadPropertyConfig readPropertyConfig;
	
	@Autowired
	private InfoConfig infoConfig;
	
	@Autowired
	private PropertySouceValue  propertySourceValue;
	
	@Autowired
	private PropertySourceConfigurationProperties configProperties;
	
	
	@Autowired
	
	private Environment env;
	
	
	@RequestMapping("/hello")
	public String index(){
		System.out.println(exampleProperties.getTitle());
		return "Hello world";
		
	}
	
	
	@RequestMapping("readProperty")
	public String testReadProperty() {
		return readPropertyConfig.getProjectDesc();
	}
	
	@RequestMapping("configurationProperties")
	public String configurationProperties() {
		return infoConfig.getAddress()+"--"+infoConfig.getCompany()+"--"+infoConfig.getDegree();
	}
	
	
	@RequestMapping("propertySource")
	public String propertySource() {
		return propertySourceValue.getUsername()+";"+propertySourceValue.getPassword();
	}
	
	@RequestMapping("configProperties")
	public String  configProperties() {
		return configProperties.getUsername()+";---"+configProperties.getPassword();
	} 
	
	@RequestMapping("useEnvReadProperty")
	public String useEnvReadProperty() {
		return  env.getProperty("db.username");
	}
}
