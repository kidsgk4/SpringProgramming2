package com.mycompany.web.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// 컴포넌트 어노테이션이 붙으면 스프링이 무조건 관리객체로 생각함

@Component("ch09Dao3")
public class Ch09Dao3 {
	private static final Logger logger=LoggerFactory.getLogger(Ch09Dao3.class);
	
	public Ch09Dao3() {
		logger.debug("실행");
	}
	
	public void insert() {
		logger.debug("실행");
	}
}
