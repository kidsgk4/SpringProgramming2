package com.mycompany.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.web.dao.Ch09Dao5;

@Service
public class Ch09Service5 {

	@Autowired
	private Ch09Dao5 ch09Dao5;
	
	public void method5() {
		ch09Dao5.m();
		
	}
}
