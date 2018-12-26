package com.bit.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bit.board.model.MemoDto;
import com.bit.board.service.BoardService;
import com.bit.board.service.MemoService;
import com.bit.member.model.MemberDto;


@Controller //@RestController = (@Controller + @ResponseBody)
public class MemoController {
	
	@Autowired
	private MemoService memoService;
	
	@RequestMapping(value="memo", method=RequestMethod.POST, headers={"Content-type=application/json"})
	public @ResponseBody String write(@RequestBody MemoDto memoDto, HttpSession session) {
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			memberDto.setId(memberDto.getId());
			memberDto.setName(memberDto.getName());
			int cnt = memoService.writeMemo(memoDto);
			
		}
		String memolist = memoService.listMemo(memoDto.getSeq());
		return memolist;
	}

	@RequestMapping(value="memo/{seq}", method=RequestMethod.GET)
	public @ResponseBody String list(@PathVariable(value="seq") int seq) {
		String memolist = memoService.listMemo(seq);
		return memolist;
	}
}
