package com.ttocook.web.domain;

import java.util.Date;

public class FileDto {
	private int file_no;
	private int ckbno;
	private String org_file_name;
	private String stored_file_name;
	private long file_size;
	private Date regdate;
	private String del_gb;
	
	FileDto(){}
	
	public int getFile_no() {
		return file_no;
	}
	public void setFile_no(int file_no) {
		this.file_no = file_no;
	}
	public int getCkbno() {
		return ckbno;
	}
	public void setCkbno(int ckbno) {
		this.ckbno = ckbno;
	}
	public String getOrg_file_name() {
		return org_file_name;
	}
	public void setOrg_file_name(String org_file_name) {
		this.org_file_name = org_file_name;
	}
	public String getStored_file_name() {
		return stored_file_name;
	}
	public void setStored_file_name(String stored_file_name) {
		this.stored_file_name = stored_file_name;
	}
	public long getFile_size() {
		return file_size;
	}
	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getDel_gb() {
		return del_gb;
	}
	public void setDel_gb(String del_gb) {
		this.del_gb = del_gb;
	}
	@Override
	public String toString() {
		return "FileDto [file_no=" + file_no + ", ckbno=" + ckbno + ", org_file_name=" + org_file_name
				+ ", stored_file_name=" + stored_file_name + ", file_size=" + file_size + ", regdate=" + regdate
				+ ", del_gb=" + del_gb + "]";
	}
	
	
}
