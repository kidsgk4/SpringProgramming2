package com.mycompany.web.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch09")
public class Ch09Controller {
	
	@RequestMapping("/content")
	public String content(String fname) {
		return "ch09/content";
	}
	
	@RequestMapping("/download")
	public String download() {
		return "ch09/download";
	}
	
	@RequestMapping("/fileUp")
	public void fileUp(String fname,HttpServletRequest request, HttpServletResponse response)throws Exception {
		ServletContext sc=request.getServletContext();
		String path=request.getServletContext().getRealPath("/resources/image/"+fname);
		String mimeType=sc.getMimeType(fname);
		response.setHeader("Content-Type", mimeType);
		
		String downloadName=URLEncoder.encode("ㅎㅇ.jpg","UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=\""+downloadName+"\"");
		System.out.println(downloadName);
		
		OutputStream os=response.getOutputStream();
		
		InputStream is=new FileInputStream(path); 
		byte[] b=new byte[1024];
		while(true) {
			int read=is.read(b);
			if(read==-1) break;
			os.write(b,0,read);
		}
		os.flush();
		os.close();
		
	}
}
