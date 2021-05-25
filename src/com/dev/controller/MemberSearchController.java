package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberSearchController implements Controller {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String job = req.getParameter("job");
		String path = null;
		if(job.equals("search")) {
			path = "/result/memberSearchOutput.jsp";
		}
		else if(job.equals("update")) {
			path = "/memberUpdate.jsp";
		}
		else if(job.equals("delete")) {
			path = "/memberDelete.jsp";
		}
		// service MemberVO
		MemberService service = MemberService.getInstance();
		MemberVO member = service.memberSearch(id);
		
		if(member == null) req.setAttribute("result", "No ID");
		req.setAttribute("member", member);
		HttpUtil.forward(req, resp, path);
	}
}
