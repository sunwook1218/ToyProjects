package com.sun.service;

import com.sun.model.Member;

public interface MemberService {
	
	int join(Member member);

	Member getMember(Member tempM);

	Member getMemberById(String id);

}
