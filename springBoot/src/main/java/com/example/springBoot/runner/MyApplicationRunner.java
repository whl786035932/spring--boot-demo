package com.example.springBoot.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationRunner implements ApplicationRunner, Ordered{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("#########################my application runner#############################");
		
	}

	@Override
	public int getOrder() {
		return 0;
	}
	

}
