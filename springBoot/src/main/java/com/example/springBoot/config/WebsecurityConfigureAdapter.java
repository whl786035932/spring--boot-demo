package com.example.springBoot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * 在生产环境中使用HTTPS
 * @author whl
 *
 */
@EnableWebSecurity
public class WebsecurityConfigureAdapter  extends  WebSecurityConfigurerAdapter {


	protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	}
}
