package com.example.sb.exercise;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/ex")
public class BasicController {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@GetMapping("/hello")		// localhost:8090/sb/ex/hello
	public String hello() {
		return "exercise/hello";		// hello.html
	}
	
	@ResponseBody		// html 파일을 찾지않고, 데이터를 직접 전송하여 화면에 출력
	@GetMapping("/noHtml")
	public String noHtml() {
		return "<h1> Hello Spring Boot!!" ;
	}
	
	@GetMapping("/redirect")
	public String redirect() {
		return "redirect:/ex/hello";
	}
	
	@GetMapping("/params")
	public String params(Model model) {
		model.addAttribute("name", "제임스");
		return "exercise/params";
	}
	
	@GetMapping("/params2")		// Get 으로 가져오는게 아닌 불러오는 방법으로 url에다가 params?name="String" 적으면 된다.
	public String params2(Model model, HttpServletRequest req) {		// 
		String name = req.getParameter("name");
		model.addAttribute("name", name);
		return "exercise/params";
	}
	
	@GetMapping("/params3")	// Get 으로 가져오는게 아닌 불러오는 방법으로 url에다가 params?name="String"&count="int" 를 적으면 된
	public String params3(Model model, String name, int count) {		 
		model.addAttribute("name", name+count);
		return "exercise/params";
	}
	
	
	@GetMapping("/memberForm") 
	public String memberForm() {
		return "exercise/memberForm";
	}
	
	@PostMapping("/memberProc")
	public String memberProc(Member member, Model model) {
		log.info(member.toString());		// 나중에 추가한것 syso랑 같은 의미 입니다./회사에서 syso 쓰면 대가리 깨짐 console에 info로 찍힘 debug는 너무 많아서 찾기 힘듦
		model.addAttribute("name", member.getName());
		return "exercise/params";
	}
	
}