package com.example.hr.member.service;

import java.util.List;

import com.example.hr.member.model.MemberVO;

public interface IMemberService {

	// 회원 수 조회
	int getMemberCount(String userid);
	
	// 모든 회원 정보 조회
	List<MemberVO> getMemberList();
	
	// userid로 회원 정보 조회
	MemberVO getMemberInfo(String userid);
	
	// password 가져오기
	String getPassword(String password);
	
	// 회원 정보 수정
	void updateMember(MemberVO member);
	
	// 회원 정보 입력
	void insertMember(MemberVO member);

	// 회원 정보 삭제
	int deleteMember(String userid, String password);
//	List<Map<String, Object>> getAllDeptId();
//	List<Map<String, Object>> getAllJobId();
//	List<Map<String, Object>> getAllManagerId();
}