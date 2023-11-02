package com.ttocook.web.domain;

import java.util.Date;
import java.util.Objects;

public class MemberDto {
	
	private String id;
	private String pw;
	private String tel;
	private String email;
	private String nickname;
	private Date reg_date;
	
	public MemberDto() {}

	public MemberDto(String id, String pw, String tel, String email, String nickname, Date reg_date) {
		this.id = id;
		this.pw = pw;
		this.tel = tel;
		this.email = email;
		this.nickname = nickname;
		this.reg_date = reg_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, nickname, pw, reg_date, tel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberDto other = (MemberDto) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(nickname, other.nickname) && Objects.equals(pw, other.pw)
				&& Objects.equals(reg_date, other.reg_date) && Objects.equals(tel, other.tel);
	};
	
	
	
	
}
