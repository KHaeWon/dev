package com.example.hr.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.hr.model.EmpVO;

@Repository
@Mapper
public interface IEmpRepository {
	int getEmpCount();
	int getEmpCount(int deptid);
//	List<EmpVO> getEmpList();
//	EmpVO getEmpInfo(int empid);
//	void updateEmp(EmpVO emp);
//	void insertEmp(EmpVO emp);
//	void deleteJobHistory(int empid);
	
	//이렇게 지정해주지 않으면 hashmap으로 가니까 arg1, arg2 또는 param1 param2로 들어가니까 뭐가 뭔지 모르잖음
	//mapper에서 where employee_id=#{param1} and email=#{param2}
	//지정해줬으니까 where employee_id=#{empid} and email=#{email}
	// 파라미터가 1개면 굳이 이렇게 안 해도 됨ㅎㅎ 그냥 가져다 쓸 수 있음
	//이거 가능! 책 p.239
	//int deleteEmp(@Param("empid") int empid, @Param("email") String email);
	
	//	List<Map<String, Object>> getAllDeptId();
//	List<Map<String, Object>> getAllJobId();
//	List<Map<String, Object>> getAllManagerId();
}