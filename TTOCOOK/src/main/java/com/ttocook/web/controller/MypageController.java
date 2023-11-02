package com.ttocook.web.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ttocook.web.domain.MemberDto;
import com.ttocook.web.service.MemberService;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	@Autowired
	MemberService memberService;
	
	@GetMapping("/update")
	public String mypageUpdate(Model m, HttpSession session, MemberDto memberDto){
		String user = (String) session.getAttribute("id");
		try {
			memberDto = memberService.read(user);
			
			m.addAttribute("memberDto", memberDto);
		} catch (Exception e) {
			// 
			e.printStackTrace();
		}
		return "myPageUpdate";
	}
	
	@PostMapping("/update")
	public String mypageUpdate(MemberDto memberDto, String id, RedirectAttributes rattr, Model m) {
		
		
		try {
			if(memberService.modify(memberDto) != 1) {
				throw new Exception("mypageModify failed");
			}
			rattr.addFlashAttribute("msg", "MYM_OK");
			return "redirect:/";
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("msg", "MYM_ERR");
			
		}
		return "myPageUpdate";
	}
	
	@GetMapping("/login")
	public String mypageLogin(HttpSession session, Model m) {
		String user =(String) session.getAttribute("id");
		m.addAttribute("user", user);
		return "myPage";
	}
	
	@PostMapping("/login")
	public String mypageLogin(String id, String pw, HttpSession session, Model m, RedirectAttributes rattr) {
		
		if(!myPageLoginCheck(id, pw)) {
			String msg = URLEncoder.encode("비밀번호가 일치하지 않습니다.");
			return "redirect:/mypage/login?msg="+ msg;
		}
		
			return "redirect:/mypage/update";
	}
	
	private boolean myPageLoginCheck(String id, String pw) {
		String userId = null;
		String userPw = null;
		
		try {
			MemberDto dto = memberService.read(id);
			MemberDto login = memberService.login(dto);
			userId = login.getId();
			userPw = login.getPw();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return userId.equals(id) && userPw.equals(pw);	
	}

}
