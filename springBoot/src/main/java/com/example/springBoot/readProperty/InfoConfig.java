package com.example.springBoot.readProperty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取了application.properties 里的配置，前缀是info.*
 * @author whl
 *
 */
@Component
@ConfigurationProperties(prefix = "info")

public class InfoConfig {
	
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	private String company;
	private String degree;
	

}
