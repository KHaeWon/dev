package com.example.hr.member.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@ToString
public class MemberVO {

	private String userid;
	private String name;
	private String password;
	private String password2;
	private String email;
	private String phone;
	
}
