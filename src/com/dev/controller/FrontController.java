package com.dev.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	HashMap<String, Controller> list = null;
	
	@Override	// FrontController 최초 요청 시 초기화 메소드
	public void init(ServletConfig config) throws ServletException {
		list = new HashMap<String, Controller>();	// (key)String 값을 받으면 (value)Controller를 반환
		list.put("/memberInsert.do", new MemberInsertController());
		list.put("/memberSearch.do", new MemberSearchController());
		list.put("/memberUpdate.do", new MemberUpdateController());
		list.put("/memberDelete.do", new MemberDeleteController());
		list.put("/memberList.do", new MemberListController());
	}
	
	@Override	// doPost에서 해도 되는 작업이지만 init() 실행 후 곧 바로 service() 실행되기에 오버라이딩하여 작업
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		String contextP = req.getContextPath();		// /edu0518
		String url = req.getRequestURI();		//	/edu0518/*.do
		String path = url.substring(contextP.length()); // /edu0518 없애기 ->/*.do 만 남게 됨
		*/
		String path2 = req.getServletPath();	// *.do
		Controller subController = list.get(path2); // path에 해당하는 Controller 반환
		subController.execute(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
