package com.example.springBoot.readProperty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 测试加载配置文件的顺序
 * 
 * @author whl
 *
 */
@Configuration
public class LoadPropertyOrder {
	
	@Value("${name}")
	private String name;
	
	public String getName() {
		return   "读取的配置的name="+name;
	}

}
