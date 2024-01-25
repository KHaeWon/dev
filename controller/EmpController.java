package com.example.hr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hr.model.EmpVO;
import com.example.hr.service.IEmpService;

@Controller
public class EmpController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IEmpService empService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/empcount")  // 요청 URI 지정
	public String empCount(@RequestParam(value="deptno", required=false, defaultValue="0") int deptno, Model model) {
		logger.info("Info Log Test");//error, warn, info, debug, trace
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
	//회원가입 form
//	@GetMapping("/member/insert")
//	public String empInfo(Model model) {
//		model.addAttribute("member", new EmpVO());
//		return "member/form";
//	}
//	@PostMapping("/member/insert")
//	public String empForm(@ModelAttribute("member") EmpVO member, BindingResult result) {
//		return "redirect:/";
//	}
	//@RequestParam 입력양식의 입력값을 파라미터로 받겠다
	//@RequestBody 주로 @RestController에서 사용 >> json 데이터로 주고받을 떄 >> 입력 양식이 아니라 json 데이터가 필요!
	@PostMapping("/hr/insert")
	public String insertEmp(@RequestParam EmpVO emp) {
		//service 메서드 호출했다고 가정
		return "redirect:/hr/list";
	}
	
	
}
