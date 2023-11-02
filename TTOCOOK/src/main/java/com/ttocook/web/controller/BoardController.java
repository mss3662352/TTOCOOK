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

import com.ttocook.web.domain.BoardDto;
import com.ttocook.web.domain.PageHandler;
import com.ttocook.web.domain.SearchCondition;
import com.ttocook.web.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/ckmodify")
	public String ckmodify(Integer ckbno, Integer page, Integer pageSize, Model m, HttpServletRequest request) {
		
		try {
			BoardDto boardDto = boardService.read(ckbno);
			m.addAttribute("boardDto", boardDto);
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/login/login?toURL="+request.getRequestURL();
		}
		return "ckboardmodify";
	}
	@PostMapping("/ckmodify")
	public String ckmodify(BoardDto boardDto, RedirectAttributes rattr,
						Model m, HttpSession session) {
		String ckbwriter = (String) session.getAttribute("id");
		
		boardDto.setCkbwriter(ckbwriter);
		
		try {
			if(boardService.modify(boardDto) != 1)
				throw new Exception("modify failed");
			
			rattr.addFlashAttribute("msg", "MOD_OK");
			return "redirect:/board/cook";
		} catch (Exception e) {
			e.printStackTrace();
			
			m.addAttribute("mode", "new");
			m.addAttribute("boardDto", boardDto);
			m.addAttribute("msg", "MOD_ERROR");
			
			return "ckboardmodify";
		}
	}
	
	@PostMapping("/ckwrite")
	public String ckwrite(Integer page, Integer pageSize, BoardDto boardDto, HttpSession session, Model m, RedirectAttributes rattr) {
		String ckbwriter = (String) session.getAttribute("nickname");
		
		boardDto.setCkbwriter(ckbwriter);
		
		try {
			if(boardService.write(boardDto) != 1)
				throw new Exception("Write failed");
			
			rattr.addFlashAttribute("msg", "WRT_OK");
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
			
			return "redirect:/board/cook";
		} catch (Exception e) {
			e.printStackTrace();
			
			
			m.addAttribute("mode", "new");
			m.addAttribute("boardDto", boardDto);
			m.addAttribute("msg", "WRT_ERROR");
			
			return "ckboardwrite";
		}
		
	}
	@GetMapping("/ckwrite")
	public String ckwrite( BoardDto boardDto, Model m, HttpSession session, HttpServletRequest request) {
		if(!loginCheck(request)) {
			return "redirect:/login/login?toURL="+request.getRequestURL();
		}
		String ckbwriter = (String) session.getAttribute("nickname");
		
		boardDto.setCkbwriter(ckbwriter);
		return "ckboardwrite";
	}
	
	@PostMapping("/ckremove")
	public String ckremove(Integer ckbno, Integer page, RedirectAttributes rattr, Integer pageSize, Model m, HttpSession session) {
		String ckbwriter = (String) session.getAttribute("nickname");
		try {
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
			
			int rowCnt = boardService.remove(ckbno, ckbwriter);
			if (rowCnt !=1)
				throw new Exception("board remove error");
				
				rattr.addFlashAttribute("msg", "DEL_OK");
				return "redirect:/board/cook";
			
		} catch (Exception e) {
			e.printStackTrace();
			
			rattr.addFlashAttribute("msg", "DEL_ERROR");
		}
		
		return "redirect:/board/cook";
	}
	
	@GetMapping("/ckread")
	public String ckread(Integer page, Integer pageSize, Integer ckbno, Model m) {
		try {
			BoardDto boardDto = boardService.read(ckbno);
			m.addAttribute("boardDto", boardDto);
			m.addAttribute("page", page);
			m.addAttribute("pageSize", pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
			return "ckboard";
	}
	
	@GetMapping("/cook")
	public String cook(SearchCondition sc, Model m, HttpServletRequest request) {
		//로그인 확인
		if(!loginCheck(request))
			//로그인을 안했으면 login페이지로 이동 (URL을 포함하여)
			return "redirect:/login/login?toURL="+request.getRequestURL();
		
		
		try {
			int totalCnt = boardService.getCount();
			PageHandler ph = new PageHandler(totalCnt, sc);
			
			
			List<BoardDto> list = boardService.getSelectSearchPage(sc);
			
			m.addAttribute("list", list);
			m.addAttribute("ph", ph);
			System.out.println(ph.getTotalCnt());
			Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
			m.addAttribute("startOfToday", startOfToday.toEpochMilli());
			
		}catch(Exception e) {
			e.printStackTrace();
			
			m.addAttribute("msg", "LIST_ERR");
			m.addAttribute("totalcnt", 0);
			
			
		}
		
		return "ckboardList";
	}
	
	private boolean loginCheck(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return session.getAttribute("id") != null;
		
	}
	
}
