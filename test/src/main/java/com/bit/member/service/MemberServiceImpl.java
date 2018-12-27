package com.bit.member.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.member.dao.MemberDao;
import com.bit.member.model.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<MemberDto> getMemberList(Map<String, String> param) {
	
		return sqlSession.getMapper(MemberDao.class).getMemberList(param);
	}

	@Override
	public void joinMember(MemberDto memberDto) {
		sqlSession.getMapper(MemberDao.class).joinMember(memberDto);

	}

	@Override
	public void modifyMember(MemberDto memberDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMember(int mid) {
		// TODO Auto-generated method stub

	}

	@Override
	public MemberDto login(MemberDto memberDto) {
		
		return sqlSession.getMapper(MemberDao.class).login(memberDto);
	}
	
	

}
