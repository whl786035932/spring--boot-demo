package com.example.springBoot.config;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springBoot.filter.MyFilter;

/**
 * 我们常常在项目中会使用filters用于录调用日志、排除有XSS威胁的字符、执行权限验证等等。Spring
 * Boot自动添加了OrderedCharacterEncodingFilter和HiddenHttpMethodFilter
 * ，并且我们可以自定义Filter。
 * 
 * 两个步骤：
 * 
 * 实现Filter接口，实现Filter方法 添加@Configuration 注解，将自定义Filter加入过滤链
 * 
 * @author whl
 * 
 */
@Configuration
public class WebConfiguration {
	@Bean
	public RemoteIpFilter remoteIpFilter() {
		return new RemoteIpFilter();
	}

	@Bean
	public FilterRegistrationBean testFilterRegistration() {

		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new MyFilter());
		registration.addUrlPatterns("/*");
		registration.addInitParameter("paramName", "paramValue");
		registration.setName("MyFilter");
		registration.setOrder(1);
		return registration;
	}
}
