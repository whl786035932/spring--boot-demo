package com.example.springBoot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 在生产环境中使用HTTPS
 * @author whl
 *
 */
@Configuration
public class WebsecurityConfigureAdapter  extends  WebSecurityConfigurerAdapter {


	protected void configure(HttpSecurity http) throws Exception {
		
	}
}
