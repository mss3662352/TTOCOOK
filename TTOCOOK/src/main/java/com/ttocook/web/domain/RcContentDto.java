package com.ttocook.web.domain;

import java.util.Objects;

public class RcContentDto {
	private Integer rcconno;
	private Integer rcno;
	private String rccon;
	private Integer rcimg;
	private Integer step;
	
	
	public RcContentDto(Integer rcconno, Integer rcno, String rccon, Integer rcimg, Integer step) {
		this.rcconno = rcconno;
		this.rcno = rcno;
		this.rccon = rccon;
		this.rcimg = rcimg;
		this.step = step;
	}
	public Integer getStep() {
		return step;
	}
	public void setStep(Integer step) {
		this.step = step;
	}
	public Integer getRcconno() {
		return rcconno;
	}
	public void setRcconno(Integer rcconno) {
		this.rcconno = rcconno;
	}
	public Integer getRcno() {
		return rcno;
	}
	public void setRcno(Integer rcno) {
		this.rcno = rcno;
	}
	public String getRccon() {
		return rccon;
	}
	public void setRccon(String rccon) {
		this.rccon = rccon;
	}
	public Integer getRcimg() {
		return rcimg;
	}
	public void setRcimg(Integer rcimg) {
		this.rcimg = rcimg;
	}
	@Override
	public int hashCode() {
		return Objects.hash(rccon, rcconno, rcimg, rcno, step);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RcContentDto other = (RcContentDto) obj;
		return Objects.equals(rccon, other.rccon) && Objects.equals(rcconno, other.rcconno)
				&& Objects.equals(rcimg, other.rcimg) && Objects.equals(rcno, other.rcno)
				&& Objects.equals(step, other.step);
	}
	
	
	
}
