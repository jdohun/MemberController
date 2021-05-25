package com.dev.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberListController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<MemberVO> List = null;
		
		MemberService service = MemberService.getInstance();
		List = service.memberList();
		
		req.setAttribute("List", List);
		
		HttpUtil.forward(req, resp, "/result/memberListOutput.jsp");
	}
}
