package com.he20o.mapper;


import com.he20o.spring.dto.TestDto;

public interface TestMapper {
	public TestDto getData1();
	public TestDto getData2();
	public TestDto getData3();
	public TestDto getData4();
	
	/*문제 1*/
	public void updateVisitantCount();
	
	/* 문제 2 */
	public void insertDoodle();
	
	/* 문제 3 */
	public void delTest();
}
