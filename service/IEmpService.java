package com.example.hr.service;

import java.util.List;
import java.util.Map;

import com.example.hr.model.EmpVO;

public interface IEmpService {
	int getEmpCount();
	int getEmpCount(int deptid);

	// 모든 사원 정보 조회
	List<EmpVO> getEmpList();
	// empid로 사원 정보 조회
	EmpVO getEmpInfo(int empid);
	
	// 사원 정보 수정
	void updateEmp(EmpVO emp);
	
	// 사원 정보 입력
	void insertEmp(EmpVO emp);

	// 사원 정보 삭제
	int deleteEmp(int empid, String email);
//	List<Map<String, Object>> getAllDeptId();
//	List<Map<String, Object>> getAllJobId();
//	List<Map<String, Object>> getAllManagerId();
}