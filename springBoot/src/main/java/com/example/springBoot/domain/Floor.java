package com.example.springBoot.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 楼层管理
 * @author whl
 *
 */
@Entity
public class Floor  implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	
	/**
	 * 发布用户的id
	 */
	@Column(name="user_id")
	private String userId;
	
	
	
	/**
	 *楼层名称 
	 */
	
	private String name;
	
	/**
	 * 楼层的模板路径
	 */
	
	
	private String templateUrl;
	
	/**
	 * 类型
	 * 1.管理段
	 * 2.供应商
	 */
	
	private Integer type;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTemplateUrl() {
		return templateUrl;
	}

	public void setTemplateUrl(String templateUrl) {
		this.templateUrl = templateUrl;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public List<FloorContent> getFloorContents() {
		return floorContents;
	}

	public void setFloorContents(List<FloorContent> floorContents) {
		this.floorContents = floorContents;
	}

	@OneToMany(fetch=FetchType.LAZY,mappedBy="floor")
	private List<FloorContent> floorContents;
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
