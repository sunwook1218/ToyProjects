package com.sun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.dao.MemberDao;
import com.sun.model.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao md;

	@Override
	public int join(Member member) {
		return md.join(member);
	}

	@Override
	public Member getMember(Member tempM) {
		return md.getMember(tempM);
	}

	@Override
	public Member getMemberById(String id) {
		return md.getMemberById(id);
	}

}
