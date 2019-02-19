package com.example.springBoot.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FloorContentRepos extends JpaRepository<FloorContent, Long>{
	public Page<FloorContent>  findByFloor_name(String floorName,Pageable pageable);
}
