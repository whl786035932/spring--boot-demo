package com.example.springBoot.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class EnvConfig implements EnvironmentAware {
	private Environment env;

	@Override
	public void setEnvironment(Environment environment) {
		this.env = environment;
	}

	public String getStringValue(String key) {
		return env.getProperty(key);
	}

	public Long getLongValue(String key) {
		String value = getStringValue(key);
		try {
			return Long.parseLong(value);
		} catch (Exception e) {
		}
		return 0L;
	}

	public int getIntValue(String key) {
		return getLongValue(key).intValue();

	}

}
