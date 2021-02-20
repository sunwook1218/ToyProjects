package member.model;

import java.util.Date;

public class Member {

	private String memberid;
	private String name;
	private String password;
	private Date regDate;
	
	public Member(String id, String name, String password, Date regDate) {
		super();
		this.memberid = id;
		this.name = name;
		this.password = password;
		this.regDate = regDate;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regdate) {
		this.regDate = regdate;
	}
	
	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}
	
	public void changePassword(String newPwd) {
		this.password = newPwd;
	}

}
