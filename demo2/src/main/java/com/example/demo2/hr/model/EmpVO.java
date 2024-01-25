package com.example.demo2.hr.model;

import java.sql.Date;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class EmpVO {
	
	@Min(value=300, message="사원번호는 300이상여야 합니다.")
	private int employeeId;
	
	@Pattern(regexp="[a-zA-Z가-힣]{2,}", message="이름을 입력하세요.")
	private String firstName;
	
	@Pattern(regexp="[a-zA-Z가-힣]{1,}", message="성을 입력하세요.")
	private String lastName;
	
	@Pattern(regexp="[A-Z0-9]{2,}", message="이메일 주소를 입력하세요.")
	private String email;
	
	@Pattern(regexp="[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}", message="전화번호 형식에 맞지 않습니다.")
	private String phoneNumber;
	
	@Past(message="오늘과 과거의 날짜만 지정 가능합니다.")
	private java.sql.Date hireDate;
	
	private String jobId;
	
	@Min(value=100, message="급여는 100보다 작을 수 없습니다.")
	private double salary;
	
	@DecimalMin(value="0.0", message="보너스율은 0보다 작을 수 없습니다.")
	@DecimalMax(value="0.99", message="보너스율은 0.99보다 클 수 없습니다.")
	private double commissionPct;
	
	private int managerId;
	
	private int departmentId;
	
	public EmpVO() {
		super();
	}
	public EmpVO(int employeeId, String firstName, String lastName, String email, String phoneNumber, Date hireDate,
			String jobId, double salary, double commissionPct, int managerId, int departmentId) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.managerId = managerId;
		this.departmentId = departmentId;
	}
	
}
