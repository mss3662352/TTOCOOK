package com.ttocook.web.controller;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ttocook.web.domain.MemberDto;
import com.ttocook.web.service.MemberService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	MemberService memberService;
	
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("/login")
	public String loginForm(){
		return "login";
	}
	@PostMapping("/login")
	public String loginForm(String nickname, String id, String pw, boolean rememberId ,String toURL, HttpServletResponse response, HttpServletRequest request) {
		
		if(!loginCheck(id, pw)) {
			String msg = URLEncoder.encode("id 또는 pw가 일치하지 않습니다.");
			return "redirect:/login/login?msg="+ msg;		
		}
		
		try {
			nickname = memberService.read(id).getNickname();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		session.setAttribute("nickname", nickname);
		
		if(rememberId) {
			Cookie cookie = new Cookie("id", id);
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
			toURL = (toURL == null || toURL.equals("")) ? "/" : toURL;
		
	
		return "redirect:" + toURL;
	}
			
			
	private boolean loginCheck(String id, String pw) {
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