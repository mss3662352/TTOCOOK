package com.ttocook.web.domain;

import java.util.Date;
import java.util.Objects;

public class FrBoardDto {
	private Integer frbno;
	private String frbwriter;
	private String frbtitle;
	private String frbcon;
	private Date frbdate;
	private Date frbupdate;
	private int frre_cnt;
	private int frgood_cnt;
	private int frview_cnt;

	
	
	public FrBoardDto() {}
	
	public FrBoardDto(String frbtitle, String frbcon, String frbwriter) {
		this.frbtitle = frbtitle;
		this.frbcon = frbcon;
		this.frbwriter = frbwriter;
	}

	public Integer getFrbno() {
		return frbno;
	}

	public void setFrbno(Integer frbno) {
		this.frbno = frbno;
	}

	public String getFrbwriter() {
		return frbwriter;
	}

	public void setFrbwriter(String frbwriter) {
		this.frbwriter = frbwriter;
	}

	public String getFrbtitle() {
		return frbtitle;
	}

	public void setFrbtitle(String frbtitle) {
		this.frbtitle = frbtitle;
	}

	public String getFrbcon() {
		return frbcon;
	}

	public void setFrbcon(String frbcon) {
		this.frbcon = frbcon;
	}

	public Date getFrbdate() {
		return frbdate;
	}

	public void setFrbdate(Date frbdate) {
		this.frbdate = frbdate;
	}

	public Date getFrbupdate() {
		return frbupdate;
	}

	public void setFrbupdate(Date frbupdate) {
		this.frbupdate = frbupdate;
	}

	public int getFrre_cnt() {
		return frre_cnt;
	}

	public void setFrre_cnt(int frre_cnt) {
		this.frre_cnt = frre_cnt;
	}

	public int getFrgood_cnt() {
		return frgood_cnt;
	}

	public void setFrgood_cnt(int frgood_cnt) {
		this.frgood_cnt = frgood_cnt;
	}

	public int getFrview_cnt() {
		return frview_cnt;
	}

	public void setFrview_cnt(int frview_cnt) {
		this.frview_cnt = frview_cnt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(frbcon, frbdate, frbno, frbtitle, frbupdate, frbwriter, frgood_cnt, frre_cnt, frview_cnt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FrBoardDto other = (FrBoardDto) obj;
		return Objects.equals(frbcon, other.frbcon) && Objects.equals(frbdate, other.frbdate)
				&& Objects.equals(frbno, other.frbno) && Objects.equals(frbtitle, other.frbtitle)
				&& Objects.equals(frbupdate, other.frbupdate) && Objects.equals(frbwriter, other.frbwriter)
				&& frgood_cnt == other.frgood_cnt && frre_cnt == other.frre_cnt && frview_cnt == other.frview_cnt;
	}

	

	
}
