package com.mycompany.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.web.dao.Ch09Dao;
import com.mycompany.web.dao.Ch09Dao2;

//빈태그를 넣는다는건 객체를 생성하는것이고 스프링설정파일에 정의하므로 스프링에게 관리객체로 해라 라는뜻
@Component
public class Ch09Service2 {
	private static final Logger logger=LoggerFactory.getLogger(Ch09Service2.class);
	//필드

	
	@Autowired
	private Ch09Dao2 ch09Dao2;

	public void method2() {
		logger.debug("실행");
		ch09Dao2.insert();
	}
	
	
}
