package com.example.hr.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.hr.member.model.MemberVO;
import com.example.hr.member.service.IMemberService;

@Controller
public class MemberController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IMemberService memberService;

	
	//에러페이지
	@GetMapping("/error/runtime")
	public String errorPage() {
		return "error/runtime";
	}
	
	// 회원가입 get
	@GetMapping("/member/insert")
	public String insertMember(Model model) {
		model.addAttribute("member", new MemberVO());
		System.out.println(">>>>get<<<<<");
		return "member/form";
	}

	// 회원가입 post
	@PostMapping("/member/insert")
	public String insertMember(MemberVO member, Model model) {
		logger.info("Info Log Test");//error, warn, info, debug, trace
		System.out.println(">>>>post1<<<<<");
		System.out.println(member);
		model.addAttribute("member", member);
		System.out.println(">>>>post2<<<<<");
		memberService.insertMember(member);
		System.out.println(">>>>post3<<<<<");
		return "redirect:/member/login";
	}

	// 로그인 get
	@GetMapping("/member/login")
	public String loginMember(Model model) {
		model.addAttribute("member", new MemberVO());
		return "member/login";
	}

	// 로그인 post
//	@PostMapping("/member/login")
//	public String loginMember(String userid, String password, Model model) {
//		model.addAttribute("userid",userid);
//		model.addAttribute("password",password);
//		return "redirect:/";
//	}

	// 회원정보수정 get
	@GetMapping("/member/update")
	public String updateMember(String userid, Model model) {
		MemberVO member = memberService.getMemberInfo(userid);
		model.addAttribute("member", member);
		return "member/update";
	}

	// 회원정보수정 post
	@PostMapping("/member/update")
	public String updateMember(MemberVO member, Model model) {
		model.addAttribute("member", member);
		memberService.updateMember(member);
		return "redirect:/";
	}

	// 회원 정보 삭제 get
	@GetMapping("/member/delete")
	public String deleteMember(String password, Model model) {
		model.addAttribute("password", password);
		return "member/delete";
	}

	// 회원 정보 삭제 post
	@PostMapping("/member/delete")
	public String deleteMember(@RequestParam String userid, @RequestParam String password, RedirectAttributes redirectAttributes) {

        if (password != null && !password.isEmpty()) {
            int deleteResult = memberService.deleteMember(userid, password);

            if (deleteResult > 0) {
                // 삭제 성공
                redirectAttributes.addFlashAttribute("userid", userid);
                return "redirect:/";
            } else {
                // 삭제 실패 (비밀번호가 일치하지 않는 경우)
                redirectAttributes.addFlashAttribute("message", "Incorrect password");
                return "redirect:/error/runtime"; // 에러 메시지를 표시하는 뷰로 리다이렉트
            }
        } else {
            // 비밀번호가 제공되지 않음을 처리
            redirectAttributes.addFlashAttribute("message", "Password is required");
            return "redirect:/error/runtime"; // 에러 메시지를 표시하는 뷰로 리다이렉트
        }
		
//		if (userid != null) {
//			// 회원 정보 o
//			System.out.println("회원 정보 삭제, userid=" + userid);
//			model.addAttribute("userid", userid);
//			model.addAttribute("password", password);
//			memberService.deleteMember(userid, password);
//			return "redirect:/";
//		} else {
//			// 회원 정보 x
//			System.out.println("회원 정보 삭제 불가 >> result=" + result);
//			System.out.println("userid >> " + userid);
//			System.out.println("password >> " + password);
//			return "redirect:/member/delete";
//		}

	}
}
