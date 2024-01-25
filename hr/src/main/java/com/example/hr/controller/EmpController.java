package com.example.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hr.service.IEmpService;

@Controller
public class EmpController {

	@Autowired
	IEmpService empService;
	
	@GetMapping("/empcount")  // 요청 URI 지정
	public String empCount(@RequestParam(value="deptno", required=false, defaultValue="0") int deptno, Model model) {
		int result = 0;
		if(deptno != 0) {
			result = empService.getEmpCount(deptno); // biz() 실행
		}else {
			result = empService.getEmpCount();
		}
		model.addAttribute("count", result); // 결과를 모델에 저장
		System.out.println(result);
		return "count"; // 뷰(이름)를 반환
	}
}
