package com.mycompany.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.web.dto.Ch10Board;
import com.mycompany.web.service.Ch10Service;

@Controller
@RequestMapping("/ch10")
public class Ch10Controller {
	private static final Logger logger=LoggerFactory.getLogger(Ch10Controller.class);
	
	@Autowired
	private DataSource dataSource;
	
	@RequestMapping("/content")
	public String content() {
		return "ch10/content";
	}
	@RequestMapping("/connTest")
	public void connTest(HttpServletResponse response){
		boolean result=false;
		
		//커넥션 풀에서 연결된 커넥션 대여
		try {
		Connection conn=dataSource.getConnection();
		if(conn !=null) result=true;
		
		//커넥션 풀로 커넥션을 반납
		conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter pw=response.getWriter();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("result", true);
			pw.print(jsonObject.toString());
			pw.flush();
			pw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
			
		} 
		
	@Autowired
	private Ch10Service service;
	
	@RequestMapping("/boardList")
	public String boardList(Model model,@RequestParam(defaultValue="1") int pageNo) {
		//페이지 당 행 수
		int rowsPerPage=10;
		//이전, 다음을 클릭했을 때 나오는 페이지 수
		int pagesPerGroup=5;
		//전체 게시물 수
		int totalRowNum=service.getTotalRowNo();
		//전체 페이지 수
		int totalPageNum=totalRowNum/rowsPerPage;
		if(totalRowNum % rowsPerPage !=0) totalPageNum++;
		
		//전체 그룹 수
		int totalGroupNum=totalPageNum/pagesPerGroup;
		if(totalPageNum % pagesPerGroup !=0) totalGroupNum ++;
		
		//현재 페이지의 그룹 번호
		int groupNo=(pageNo-1)/pagesPerGroup+1;
		//현재 그룹의 시작 페이지 번호
		int startPageNo=(groupNo-1)*pagesPerGroup+1;
		
		
		//현재 그룹의 마지막 페이지 번호
		int endPageNo=startPageNo+pagesPerGroup-1;
		if(groupNo==totalGroupNum) endPageNo = totalPageNum;
		
		//현재 페이지의 시작 행번호
		int startRowNo = (pageNo-1)*rowsPerPage +1;
		//현재 페이지의 끝 행번호
		int endRowNo= pageNo*rowsPerPage;
		if(groupNo==totalGroupNum) endRowNo = totalRowNum;
		
		//현재 페이지의 게시물 가져오기
		List<Ch10Board> boardList=service.getBoardList(startRowNo, endRowNo);
		
		//JSP로 페이지 정보 넘기기
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalPageNum", totalPageNum);
		model.addAttribute("totalGroupNum", totalGroupNum);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("boardList", boardList);
		return "ch10/boardList";
	}
	
	@RequestMapping("/writeBoardForm")
	public String writeBoardForm() {
		return "ch10/writeBoardForm";
	}
	
	@RequestMapping("/writeBoard")
	public String writeBoard(Ch10Board board) {
		logger.debug("dao 실행 전:"+board.getBno());
		service.writeBoard(board);
		logger.debug("dao 실행 후:"+board.getBno());
		return "redirect:/ch10/boardList";
	}
	
	
	
	
}





