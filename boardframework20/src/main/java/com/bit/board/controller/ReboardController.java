package com.bit.board.controller;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.board.model.ReboardDto;
import com.bit.board.service.ReboardService;
import com.bit.member.model.MemberDto;

@Controller
@RequestMapping("/reboard")
public class ReboardController {
	
	@Autowired
	private ReboardService ReboardService;
	
	@RequestMapping("list.bit")
	public ModelAndView list(@RequestParam Map<String,String> param) {
		ModelAndView mav = new ModelAndView();
		List<ReboardDto> list = ReboardService.listArticle(param);
		
		mav.setView("reboard/list");
		return "";
	}
	
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
				model.addAttribute("errorMsg", "�꽌踰� 臾몄젣濡� 湲��옉�꽦�씠 �떎�뙣�뻽�뒿�땲�떎");
			}
		} else {
			model.addAttribute("errorMsg", "�쉶�썝�쟾�슜 寃뚯떆�뙋�엯�땲�떎");
			
		}
		return "reboard/writeOk";
	}
	
	@RequestMapping
	public String view(@RequestParam int seq, HttpSession session, Model model) {
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto !=null) {
			ReboardDto reboardDto = ReboardService.viewArticle(seq);
			model.addAttribute("areicle",reboardDto);
		}
		
		return "reboard/view";
	}
}
