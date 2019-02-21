package com.example.springBoot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试spring  boot 加载配置的顺序
 * @author whl
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(value= { "name=javastack-单元测试上指定的参数","sex=1"})   //单元测试上@SpingBootTest 指定的参数
@ActiveProfiles("dev")
public class SpringBootLoadPropertiesOrderTest {
	
	@Value("${name}")
	private String name;
	
	
	@Test
	public void test() {
		System.out.println("name is "+name);
	}
	

}
