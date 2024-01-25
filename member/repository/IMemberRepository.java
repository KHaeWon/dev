package com.example.hr.member.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.hr.member.model.MemberVO;

@Repository
@Mapper
public interface IMemberRepository {
	
	int getMemberCount(String userid);
	List<MemberVO> getMemberList();
	MemberVO getMemberInfo(String userid);
	String getPassword(String password);
	void updateMember(MemberVO member);
	void insertMember(MemberVO member);
	int deleteMember(@Param("userid") String userid, @Param("password") String password);
	//	List<Map<String, Object>> getAllDeptId();
//	List<Map<String, Object>> getAllJobId();
//	List<Map<String, Object>> getAllManagerId();
}
