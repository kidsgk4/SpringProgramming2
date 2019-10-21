package com.mycompany.web.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Ch09Dao5 {
	private static final Logger logger = LoggerFactory.getLogger(Ch09Dao5.class);
	
	public void m() {
		logger.debug("dao 메서드 실행");
		
	}
	
}
