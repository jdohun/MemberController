package com.dev.service;

import java.util.ArrayList;

import com.dev.dao.MemberDAO;
import com.dev.vo.MemberVO;

// 생성한 VO 객체를 DAO를 통해 처리하기 위한 서비스 클래스
public class MemberService {
	// 다른 클래스에서 객체를 생성하지 않고 리턴 메소드를 사용하기 위해 자기자신 형태의 객체를 미리 생성 후
	// == 객체를 단 한개만 만들기 위해서
	private static MemberService service = new MemberService();
	
	private MemberService() {}	// 객체 생성을 막기 위한 default 생성자에 private 접근 제한 설정 
	
	public MemberDAO dao = MemberDAO.getInstance();	// 만들어진 dao 객체 반환 받음
	
	// 만들어 놓은 service 객체 반환
	public static MemberService getInstance() {
		return service;
	}
	
	public void memberInsert(MemberVO member) {
		dao.memberInsert(member);
	}
	
	public MemberVO memberSearch(String id) {
		MemberVO member = dao.memberSearch(id);
		
		return member;
	}
	
	public void memberUpdate(MemberVO member) {
		dao.memberUpdate(member);
	}
	
	public void memberDelete(String id) {
		dao.memberDelete(id);
	}
	
	public ArrayList<MemberVO> memberList() {
		ArrayList<MemberVO> List = dao.memberList();
		
		return List;
	}
}
