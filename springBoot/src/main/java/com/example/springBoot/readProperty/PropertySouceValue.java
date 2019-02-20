package com.example.springBoot.readProperty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
/**
 * 读取指定路径下的配置文件,只支持properties文件，不支持yml文件
 * @author whl
 *
 */
@Component
@PropertySource(value="config/db-config.properties")
public class PropertySouceValue {
	
	@Value("${db.username}")
	private  String username;
	
	@Value("${db.password}")
	private  String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
