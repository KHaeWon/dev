package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@GetMapping("/")
	public @ResponseBody String idnex() {
		return "Hello Boot";
	}
	
	// http://localhost:8082/hello?name=JK
	@GetMapping("/hello")
	public String hello(@RequestParam(required=false) String name, Model model) {
		String greetings = "Hello~~" + name;
		model.addAttribute("greetings", greetings);
		return "hello"; // WEB-INF/views/hello.jsp
	}
}
