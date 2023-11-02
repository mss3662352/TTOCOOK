package com.ttocook.web.domain;

import java.util.Date;
import java.util.Objects;

public class RecipeDto {
	private Integer rcno;
	private String rcwriter;
	private String rctitle;
	private String rcintro;
	private String rcmain;
	private String rcsub1;
	private String rcsub2;
	private String rcsub3;
	private String rcsub4;
	private Date rcdate;
	
	public RecipeDto() {}

	public RecipeDto(String rcwriter, String rctitle, String rcintro, String rcmain, String rcsub1,
			String rcsub2, String rcsub3, String rcsub4) {
		this.rcwriter = rcwriter;
		this.rctitle = rctitle;
		this.rcintro = rcintro;
		this.rcmain = rcmain;
		this.rcsub1 = rcsub1;
		this.rcsub2 = rcsub2;
		this.rcsub3 = rcsub3;
		this.rcsub4 = rcsub4;
	}



	public Integer getRcno() {
		return rcno;
	}

	public void setRcno(Integer rcno) {
		this.rcno = rcno;
	}

	public String getRcwriter() {
		return rcwriter;
	}

	public void setRcwriter(String rcwriter) {
		this.rcwriter = rcwriter;
	}

	public String getRctitle() {
		return rctitle;
	}

	public void setRctitle(String rctitle) {
		this.rctitle = rctitle;
	}

	public String getRcintro() {
		return rcintro;
	}

	public void setRcintro(String rcintro) {
		this.rcintro = rcintro;
	}

	public String getRcmain() {
		return rcmain;
	}

	public void setRcmain(String rcmain) {
		this.rcmain = rcmain;
	}

	public String getRcsub1() {
		return rcsub1;
	}

	public void setRcsub1(String rcsub1) {
		this.rcsub1 = rcsub1;
	}

	public String getRcsub2() {
		return rcsub2;
	}

	public void setRcsub2(String rcsub2) {
		this.rcsub2 = rcsub2;
	}

	public String getRcsub3() {
		return rcsub3;
	}

	public void setRcsub3(String rcsub3) {
		this.rcsub3 = rcsub3;
	}

	public String getRcsub4() {
		return rcsub4;
	}

	public void setRcsub4(String rcsub4) {
		this.rcsub4 = rcsub4;
	}

	public Date getRcdate() {
		return rcdate;
	}

	public void setRcdate(Date rcdate) {
		this.rcdate = rcdate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rcdate, rcintro, rcmain, rcno, rcsub1, rcsub2, rcsub3, rcsub4, rctitle, rcwriter);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecipeDto other = (RecipeDto) obj;
		return Objects.equals(rcdate, other.rcdate) && Objects.equals(rcintro, other.rcintro)
				&& Objects.equals(rcmain, other.rcmain) && Objects.equals(rcno, other.rcno)
				&& Objects.equals(rcsub1, other.rcsub1) && Objects.equals(rcsub2, other.rcsub2)
				&& Objects.equals(rcsub3, other.rcsub3) && Objects.equals(rcsub4, other.rcsub4)
				&& Objects.equals(rctitle, other.rctitle) && Objects.equals(rcwriter, other.rcwriter);
	}

	@Override
	public String toString() {
		return "RecipeDto [rcno=" + rcno + ", rcwriter=" + rcwriter + ", rctitle=" + rctitle + ", rcintro=" + rcintro
				+ ", rcmain=" + rcmain + ", rcsub1=" + rcsub1 + ", rcsub2=" + rcsub2 + ", rcsub3=" + rcsub3
				+ ", rcsub4=" + rcsub4 + ", rcdate=" + rcdate + "]";
	}
	
	
	
}
