package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 각각의 Controller 를 공통으로 작업하기 위한 interface
// execute 메소드를 강제 오버라이딩 시키기 위해 interface 구조로 생성
public interface Controller {
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
