package com.example.hr.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.hr.model.EmpVO;

@Repository
@Mapper
public interface IEmpRepository {
	int getEmpCount();
	int getEmpCount(int deptid);
	
	List<EmpVO> getEmpList();
	EmpVO getEmpInfo(int empid);
	
	void updateEmp(EmpVO emp);
	void insertEmp(EmpVO emp);
	void deleteJobHistory(int empid);
	int deleteEmp(@Param("empid") int empid, @Param("email") String email);
//	List<Map<String, Object>> getAllDeptId();
//	List<Map<String, Object>> getAllJobId();
//	List<Map<String, Object>> getAllManagerId();
}