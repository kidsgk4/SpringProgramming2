package com.mycompany.web2.service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

//여기서 서비스어노테이션을 쓰면 웹2에서 관리가되므로 루트에서 관리하기위해 뺌
public class Ch09CommonService {
	private static final Logger logger = LoggerFactory.getLogger(Ch09CommonService.class);
	
	public void method1() {
		logger.debug("실행");
	}
}
