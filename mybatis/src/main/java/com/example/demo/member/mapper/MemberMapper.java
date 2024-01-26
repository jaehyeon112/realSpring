package com.example.demo.member.mapper;

import java.util.List;

import com.example.demo.member.MemberVO;

public interface MemberMapper {
	public List<MemberVO> getMemberList(MemberVO MemberVO);
	public MemberVO getMember(String mid);
}
