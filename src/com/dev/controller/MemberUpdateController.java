package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberUpdateController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 입력 받은 id, pwd, name 을 변수로 저장
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		
		// 멤버 모델에 값 저장
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		member.setName(name);
		
		// service 
		MemberService service = MemberService.getInstance();
		service.memberUpdate(member);
		
		req.setAttribute("id", id);
		HttpUtil.forward(req, resp, "/result/memberUpdateOutput.jsp");
	}
}
