package com.example.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController的意思就是controller里面的方法都以json格式输出，不用再写什么jackjson配置的了！
 * @author whl
 *
 */
@RestController
public class HelloWorldController {
	
	@Autowired
	private ExampleProperties exampleProperties;
	
	@RequestMapping("/hello")
	public String index(){
		System.out.println(exampleProperties.getTitle());
		return "Hello world";
		
	}
}
