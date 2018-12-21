package com.bit.board.controller;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.board.model.ReboardDto;
import com.bit.board.service.ReboardService;
import com.bit.member.model.MemberDto;

@Controller
@RequestMapping("/reboard")
public class ReboardController {
	
	@Autowired
	private ReboardService ReboardService;
	
	@RequestMapping(value="/write.bit", method=RequestMethod.GET)
	public String write(@RequestParam Map<String,String> param) {
		return "reboard/write";
	}
	
	@RequestMapping(value="/write.bit", method=RequestMethod.POST)
	public String write(ReboardDto reboardDto, @RequestParam Map<String,String> param, Model model, HttpSession session) {
		
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			reboardDto.setId(memberDto.getId());
			reboardDto.setEmail(memberDto.getEmail());
			reboardDto.setName(memberDto.getName());
			
			int seq = ReboardService.writeArticle(reboardDto);
			
			if(seq != 0) {
				model.addAttribute("wseq", seq);
			} else {
				model.addAttribute("errorMsg", "서버 문제로 글작성이 실패했습니다");
			}
		} else {
			model.addAttribute("errorMsg", "회원전용 게시판입니다");
			
		}
		return "reboard/writeOk";
	}
	@RequestMapping("view.bit")
	public String view(@RequestParam int seq, HttpSession session, Model model) {
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			ReboardDto reboardDto = ReboardService.viewArticle(seq);
			model.addAttribute("article",reboardDto);
		}
		return "reboard/view";
	}
}
