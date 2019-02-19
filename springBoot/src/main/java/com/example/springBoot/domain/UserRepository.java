package com.example.springBoot.domain;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
/**
 * dao只要继承JpaRepository类就可以，几乎可以不用写方法，还有一个特别有尿性的功能非常赞，就是可以根据方法名来自动的生产SQL，比如findByUserName 会自动生产一个以 userName 为参数的查询方法，比如 findAlll 自动会查询表里面的所有数据，比如自动分页等等。。
 * @author whl
 *其实Spring data 觉大部分的SQL都可以根据方法名定义的方式来实现，但是由于某些原因我们想使用自定义的SQL来查询，spring data也是完美支持的；在SQL的查询方法上面使用@Query注解，如涉及到删除和修改在需要加上@Modifying.也可以根据需要添加 @Transactional 对事物的支持，查询超时的设置等
 */
public interface UserRepository  extends JpaRepository<User, Long>{
	 User findByUserName(String userName);
	 
	 User findByUserNameOrEmail(String userName,String email);
//	 @Query(value = "SELECT * FROM USER WHERE user_name = ?1",
//			    countQuery = "SELECT count(*) FROM USER WHERE user_name = ?1",
//			    nativeQuery = true)
//			  Page<User> findByLastname(String lastname, Pageable pageable);

	void countByUserName(String string);

	void deleteById(long l);
	
	List<User> findByEmailLike(String email);

	User findByUserNameIgnoreCase(String userName);
	    
	List<User> findByUserNameOrderByEmailDesc(String userName);
	
	
	Page<User> findAll(Pageable pageable);
	Page<User> findByUserName(String userName,Pageable pageable);
	
//	User findFirstByOrderByLastnameAsc();

//	User findTopByOrderByAgeDesc();

//	Page<User> queryFirst10ByLastname(String lastname, Pageable pageable);
//
//	List<User> findFirst10ByLastname(String lastname, Sort sort);
//
//	List<User> findTop10ByLastname(String lastname, Pageable pageable);
	
	
	@Modifying
	@Query("update User u set u.userName = ?1 where u.id = ?2")
	int modifyByIdAndUserId(String  userName, Long id);
		
	@Transactional
	@Modifying
	@Query("delete from User where id = ?1")
	void deleteByUserId(Long id);
	  
//	@Transactional(timeout = 10)
//	@Query("select u from User u where u.emailAddress = ?1")
//	    User findByEmailAddress(String emailAddress);
}
