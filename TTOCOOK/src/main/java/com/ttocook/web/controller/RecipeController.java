package com.ttocook.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ttocook.web.domain.RcContentDto;
import com.ttocook.web.domain.RecipeDto;
import com.ttocook.web.service.RcContentService;
import com.ttocook.web.service.RecipeService;

@RequestMapping("/recipe")
@Controller
public class RecipeController {
	
	@Autowired
	RecipeService recipeService;
	RcContentService rccontentServcie;
	
	
	@PostMapping("/make")
	public String recipeMake(RcContentDto rccontentDto, Integer page, Integer pageSize, RecipeDto recipeDto, HttpServletRequest request, HttpSession session, Model m, RedirectAttributes rattr) {
		String rcwriter = (String) session.getAttribute("nickname");
		
		recipeDto.setRcwriter(rcwriter);
		try {
			if(recipeService.rcInsert(recipeDto) != 1) {
				throw new Exception("rc failed");
			}
			if(rccontentServcie.insert(rccontentDto) != 1) {
				throw new Exception("rccon failed");
			}
				rattr.addFlashAttribute("msg", "WRT_OK");
				m.addAttribute("page", page);
				m.addAttribute("pageSize", pageSize);
				
				return "redirect:/make/list";
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("recipeDto", recipeDto);
			m.addAttribute("msg", "WRT_ERROR");
			
			return "makeRc";
		}
		
		
	}
	
	@GetMapping("/make")
	public String recipeMake(RecipeDto recipeDto, HttpServletRequest request, HttpSession session) {
		
		String rcwriter = (String) session.getAttribute("nickname");
		recipeDto.setRcwriter(rcwriter);
		return "makeRc";
	}
	
	@GetMapping("/list")
	public String recipeView() {
		
		return "viewRc";
	}
	@GetMapping("/view")
	public String viewCon() {
		return "view";
	}
}
