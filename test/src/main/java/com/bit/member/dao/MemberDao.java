package com.bit.member.dao;

import java.util.List;
import java.util.Map;

import com.bit.member.model.MemberDto;

public interface MemberDao {
	
	List<MemberDto> getMemberList(Map<String, String> param);
	
	void joinMember(MemberDto memberDto);
	void modifyMember(MemberDto memberDto);
	void deleteMember(int mid);
	MemberDto login(MemberDto memberDto);
	
}
