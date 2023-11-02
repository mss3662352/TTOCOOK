package com.ttocook.web.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ttocook.web.domain.FrBoardDto;
import com.ttocook.web.domain.PageHandler;
import com.ttocook.web.domain.SearchCondition;
import com.ttocook.web.service.FrBoardService;

@Controller
@RequestMapping("/board")
public class FrBoardController {
	
	@Autowired
	FrBoardService frboardService;
	
	@GetMapping("/frmodify")
	public String frmodify(Integer frbno, Integer page, Integer pageSize, Model m, HttpServletRequest request) {
		
		try {
			FrBoardDto frboardDto = frboardService.read(frbno);
			m.addAttribute("frboardDto", frboardDto);
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/login/login?toURL="+request.getRequestURL();
		}
		return "frboardmodify";
	}
	@PostMapping("/frmodify")
	public String frmodify(FrBoardDto frboardDto, RedirectAttributes rattr,
						Model m, HttpSession session) {
		String frbwriter = (String) session.getAttribute("id");
		
		frboardDto.setFrbwriter(frbwriter);
		
		try {
			if(frboardService.modify(frboardDto) != 1)
				throw new Exception("modify failed");
			
			rattr.addFlashAttribute("msg", "MOD_OK");
			return "redirect:/board/cook";
		} catch (Exception e) {
			e.printStackTrace();
			
			m.addAttribute("mode", "new");
			m.addAttribute("frboardDto", frboardDto);
			m.addAttribute("msg", "MOD_ERROR");
			
			return "frboardmodify";
		}
	}
	
	@PostMapping("/frwrite")
	public String frwrite(Integer page, Integer pageSize, FrBoardDto frboardDto, HttpSession session, Model m, RedirectAttributes rattr) {
		String frbwriter = (String) session.getAttribute("id");
		
		frboardDto.setFrbwriter(frbwriter);
		m.addAttribute("page", page);
		m.addAttribute("pageSize", pageSize);
		try {
			if(frboardService.write(frboardDto) != 1)
				throw new Exception("Write failed");
			rattr.addFlashAttribute("msg", "WRT_OK");
			
			
			
			return "redirect:/board/cook";
		} catch (Exception e) {
			e.printStackTrace();
			
			
			m.addAttribute("mode", "new");
			m.addAttribute("frboardDto", frboardDto);
			m.addAttribute("msg", "WRT_ERROR");
			
			return "frboardwrite";
		}
		
	}
	@GetMapping("/frwrite")
	public String frwrite(FrBoardDto frboardDto, Model m, HttpSession session) {
		String frbwriter = (String) session.getAttribute("id");
		
		frboardDto.setFrbwriter(frbwriter);
		return "frboardwrite";
	}
	
	@PostMapping("/frremove")
	public String frremove(Integer frbno, Integer page, RedirectAttributes rattr, Integer pageSize, Model m, HttpSession session) {
		String frbwriter = (String) session.getAttribute("id");
		try {
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
			
			int rowCnt = frboardService.remove(frbno, frbwriter);
			if (rowCnt !=1)
				throw new Exception("board remove error");
				
				rattr.addFlashAttribute("msg", "DEL_OK");
				return "redirect:/board/free";
			
		} catch (Exception e) {
			e.printStackTrace();
			
			rattr.addFlashAttribute("msg", "DEL_ERROR");
		}
		
		return "redirect:/board/cook";
	}
	
	@GetMapping("/frread")
	public String frread(Integer page, Integer pageSize, Integer frbno, Model m) {
		try {
			FrBoardDto frboardDto = frboardService.read(frbno);
			m.addAttribute("frboardDto", frboardDto);
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			return "frboard";
	}
	
	@GetMapping("/free")
	public String free(SearchCondition sc, Model m, HttpServletRequest request) {
		//로그인 확인
		if(!loginCheck(request))
			//로그인을 안했으면 login페이지로 이동 (URL을 포함하여)
			return "redirect:/login/login?toURL="+request.getRequestURL();
		
		
		try {
			int totalCnt = frboardService.getCount();
			PageHandler ph = new PageHandler(totalCnt, sc);
			
			
			List<FrBoardDto> list = frboardService.getSelectSearchPage(sc);
			
			m.addAttribute("list", list);
			m.addAttribute("ph", ph);
			System.out.println(ph.getSc().getOption());
			Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
			m.addAttribute("startOfToday", startOfToday.toEpochMilli());
			
		}catch(Exception e) {
			e.printStackTrace();
			
			m.addAttribute("msg", "LIST_ERR");
			m.addAttribute("totalcnt", 0);
			
			
		}
		
		return "frboardList";
	}
	
	private boolean loginCheck(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return session.getAttribute("id") != null;
		
	}
	
}
