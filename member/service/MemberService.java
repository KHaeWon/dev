package com.example.hr.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hr.member.model.MemberVO;
import com.example.hr.member.repository.IMemberRepository;

@Service
public class MemberService implements IMemberService{

	@Autowired
	IMemberRepository memberRepository;
	
	@Override
	public int getMemberCount(String userid) {
		return memberRepository.getMemberCount(userid);
	}
	
	@Override
	public List<MemberVO> getMemberList() {
		return memberRepository.getMemberList();
	}

	@Override
	public MemberVO getMemberInfo(String userid) {
		return memberRepository.getMemberInfo(userid);
	}

	@Override
	public String getPassword(String password) {
		return memberRepository.getPassword(password);
	}
	
	@Override
	public void updateMember(MemberVO member) {
		memberRepository.updateMember(member);
	}

	@Override
	public void insertMember(MemberVO member) {
		
		
		System.out.println("sdfsdf");
		memberRepository.insertMember(member);
	}

	@Override
	public int deleteMember(String userid, String password) {
		return memberRepository.deleteMember(userid, password);
	}


}
