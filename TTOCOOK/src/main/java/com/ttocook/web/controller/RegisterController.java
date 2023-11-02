package com.ttocook.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ttocook.web.domain.MemberDto;
import com.ttocook.web.service.MemberService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	//신규 회원 가입

	@Autowired
	MemberService memberService;
	
	//아이디 중복체크
	@PostMapping("/idCheck")
	@ResponseBody
	public String idCheck(@RequestBody String id, Model m){
		try {
			int checkNum = memberService.idCheck(id);
			if(checkNum != 0) {
				return "N";
			}else {
				return "Y";
			}
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("msg", "REG_ERR");
			return "register";
		}
		
	}
	//닉네임 중복체크
	@PostMapping("/nickCheck")
	@ResponseBody
	public String nickCheck(@RequestBody String nickname, Model m){
		try {
			int checkNum = memberService.nickCheck(nickname);
			if(checkNum != 0) {
				return "N";
			}else {
				return "Y";
			}
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("msg", "REG_ERR");
			return "register";
		}
		
		
	}
	
	@GetMapping("/add")
	public String getRegister() {
		
		return "register"; 
	}
	
	@PostMapping("/add")
	public String register(Model m, MemberDto dto, RedirectAttributes rattr) {
		
		try {
			memberService.register(dto);
			return "redirect:/login/login";
		
		} catch (Exception e) {
			e.printStackTrace();
			
			m.addAttribute("msg", "REG_ERROR");
			return "redirect:/register/add";
		}
			
	}
	
	
	
}
