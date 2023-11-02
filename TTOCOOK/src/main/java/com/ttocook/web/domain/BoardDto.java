package com.ttocook.web.domain;

import java.util.Date;
import java.util.Objects;

public class BoardDto {
	private Integer ckbno;
	private String ckbwriter;
	private String ckbtitle;
	private String ckbcon;
	private Date ckbdate;
	private Date ckbupdate;
	private int ckre_cnt;
	private int ckgood_cnt;
	private int ckview_cnt;

	
	
	public BoardDto() {}
	
	public BoardDto(String ckbtitle, String ckbcon, String ckbwriter) {
		this.ckbtitle = ckbtitle;
		this.ckbcon = ckbcon;
		this.ckbwriter = ckbwriter;
	}

	public Integer getCkbno() {
		return ckbno;
	}

	public void setCkbno(Integer ckbno) {
		this.ckbno = ckbno;
	}

	public String getCkbwriter() {
		return ckbwriter;
	}

	public void setCkbwriter(String ckbwriter) {
		this.ckbwriter = ckbwriter;
	}

	public String getCkbtitle() {
		return ckbtitle;
	}

	public void setCkbtitle(String ckbtitle) {
		this.ckbtitle = ckbtitle;
	}

	public String getCkbcon() {
		return ckbcon;
	}

	public void setCkbcon(String ckbcon) {
		this.ckbcon = ckbcon;
	}

	public Date getCkbdate() {
		return ckbdate;
	}

	public void setCkbdate(Date ckbdate) {
		this.ckbdate = ckbdate;
	}

	public Date getCkbupdate() {
		return ckbupdate;
	}

	public void setCkbupdate(Date ckbupdate) {
		this.ckbupdate = ckbupdate;
	}

	public int getCkre_cnt() {
		return ckre_cnt;
	}

	public void setCkre_cnt(int ckre_cnt) {
		this.ckre_cnt = ckre_cnt;
	}

	public int getCkgood_cnt() {
		return ckgood_cnt;
	}

	public void setCkgood_cnt(int ckgood_cnt) {
		this.ckgood_cnt = ckgood_cnt;
	}

	public int getCkview_cnt() {
		return ckview_cnt;
	}

	public void setCkview_cnt(int ckview_cnt) {
		this.ckview_cnt = ckview_cnt;
	}

	@Override
	public String toString() {
		return "BoardDto [ckbno=" + ckbno + ", ckbwriter=" + ckbwriter + ", ckbtitle=" + ckbtitle + ", ckbcon=" + ckbcon
				+ ", ckbdate=" + ckbdate + ", ckbupdate=" + ckbupdate + ", ckre_cnt=" + ckre_cnt + ", ckgood_cnt="
				+ ckgood_cnt + ", ckview_cnt=" + ckview_cnt + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ckbcon, ckbno, ckbtitle, ckbwriter);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardDto other = (BoardDto) obj;
		return Objects.equals(ckbcon, other.ckbcon) && Objects.equals(ckbno, other.ckbno)
				&& Objects.equals(ckbtitle, other.ckbtitle) && Objects.equals(ckbwriter, other.ckbwriter);
	}

	
}
