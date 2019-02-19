package com.example.springBoot;


import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.springBoot.controller.HelloWorldController;
import com.example.springBoot.domain.FloorContent;
import com.example.springBoot.domain.FloorContentRepos;
import com.example.springBoot.domain.User;
import com.example.springBoot.domain.UserRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	private MockMvc mvc;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired 
	private FloorContentRepos floorContentRepository;
	
//	@Before
	public void setUp(){
		mvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
	}
	@Test
	public void contextLoads() throws Exception {
		System.out.println("-----------------------------------");
		MvcResult andReturn = mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andDo(MockMvcResultHandlers.print())
        .andReturn();
		System.out.println("-------------------------");
		MockMvcResultHandlers.print();
		System.out.println("----------------------------------------------------");
	}
	
	@Test
	public void testUserRepository(){
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);        
		String formattedDate = dateFormat.format(date);
		
		userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456",formattedDate));
		userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456",formattedDate));
		userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456",formattedDate));
		
		System.out.println("begin---------------------------------------------------------");
		Assert.assertEquals(9, userRepository.findAll().size());
		Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "cc@126.com").getNickName());
		userRepository.delete(userRepository.findByUserName("aa1"));
		System.out.println("begin---------------------------------------------------------");
		
	}
	
	/**
	 * 自定义查询
	 * 自定义的简单查询就是根据方法名来自动生成SQL，主要的语法是findXXBy,readAXXBy,queryXXBy,countXXBy, getXXBy后面跟属性名称：
	 */
	@Test
	public void testJpaFunc(){
		User findByUserName = userRepository.findByUserName("aa1");
		System.out.println("findByUserName========="+findByUserName.toString());
		
		//也使用一些加一些关键字And、 Or
		userRepository.findByUserNameOrEmail("aa1", "aa.@qq.com");
		
//		//修改、删除、统计也是类似语法
//		userRepository.deleteById(11L);
//		
		userRepository.countByUserName("aa");
		
		//基本上SQL体系中的关键词都可以使用，例如：LIKE、 IgnoreCase、 OrderBy。
		
		userRepository.findByEmailLike("aa@qq.com");

		userRepository. findByUserNameIgnoreCase("bb2");
		    
		userRepository. findByUserNameOrderByEmailDesc("aa");
		
		//分页查询
		
		int page=1,size=10;
		Sort sort = new Sort(Direction.DESC,"id");
		Pageable  pageable = new PageRequest(page, size,sort);
		userRepository.findAll(pageable);
		Page<User> findByUserName2 = userRepository.findByUserName("aa", pageable);
		
		
	}
	
	@Test
	public void testGuanlianQuery(){
		Page<FloorContent> findByFloor_nameAndName = floorContentRepository.findByFloor_name("test",new PageRequest(0, 10));
		List<FloorContent> content = findByFloor_nameAndName.getContent();
		for (FloorContent floorContent : content) {
			System.out.println(floorContent.getName());
		}
		System.out.println(findByFloor_nameAndName.getSize());
	}
	

}
