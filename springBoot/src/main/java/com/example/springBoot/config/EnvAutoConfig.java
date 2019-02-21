package com.example.springBoot.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertyResolver;

@Configuration
@ConditionalOnClass(PropertyResolver.class)
public class EnvAutoConfig {

	
	@Bean
	public EnvConfig envConfig() {
		return new EnvConfig();
	}
	
	
	/**
	 * 在主应用程序中添加java 系统参数
	 * @return
	 */
	@Bean
	public CommandLineRunner commandLineRunner() {
			return new CommandLineRunner() {
				
				@Override
				public void run(String... args) throws Exception {
					System.setProperty("name", "name命令行参数");
				}
			};
	}
	
	
}
