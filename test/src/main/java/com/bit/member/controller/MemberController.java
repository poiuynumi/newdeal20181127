package com.bit.member.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.member.model.MemberDto;
import com.bit.member.service.MemberService;

@RequestMapping("/member")
@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping(value="join", method=RequestMethod.GET)
	public String viewJoin() {
		
		
		return  "member/join";
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String joinMember(MemberDto memberDto) {
		
		memberService.joinMember(memberDto);
		return "member/join";
		
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	
	public String viewLogin() {
		return  "member/login";
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String viewList(@RequestParam Map<String, String> param, Model model) {
		
//		List<MemberDto> list = memberService.getMemberList(param);
//		model.addAttribute(list);
		return "member/list";
	}

	
}
