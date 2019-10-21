package com.mycompany.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mycompany.web.dao.Ch09Dao;

//웹어플리케이션컨텍스트=컨테이너가 생성함
@Service
public class Ch09Service {
	private static final Logger logger=LoggerFactory.getLogger(Ch09Service.class);
	//필드
	
	@Autowired
	private Ch09Dao ch09dao;

	//스프링 관리객체는 기본생성자를 이용하기때문에 생성자 정의 필요 x 
	
	public void method1() {
		logger.debug("실행");
		ch09dao.insert();
	}
}

