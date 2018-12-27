package com.bit.member.service;

import java.util.List;
import java.util.Map;

import com.bit.member.model.MemberDto;

public interface MemberService {
	
	List<MemberDto> getMemberList(Map<String, String> param);
	void joinMember(MemberDto board_MemberDto);
	void modifyMember(MemberDto board_MemberDto);
	void deleteMember(int mid);
	MemberDto login(MemberDto memberDto);

}
