package com.sun.dao;

import com.sun.model.Member;

public interface MemberDao {

	int join(Member member);

	Member getMember(Member tempM);

	Member getMemberById(String id);

}
