package com.example.springBoot.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 楼层的内容
 * @author whl
 *
 */
@Entity
public class FloorContent  implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	/**
	 * 发布用户id
	 */
	
	private String user_id;
	
	private String name;
	
	private String contentImageUrl;
	
	private Integer type;
	
	@ManyToOne
	@JoinColumn(name="floor_id",foreignKey = @ForeignKey(name = "fk_floor_fc"))
	private Floor floor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContentImageUrl() {
		return contentImageUrl;
	}

	public void setContentImageUrl(String contentImageUrl) {
		this.contentImageUrl = contentImageUrl;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}
	
	
	
}
