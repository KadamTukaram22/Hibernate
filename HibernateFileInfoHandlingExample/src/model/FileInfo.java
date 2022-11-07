package model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class FileInfo {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fid;
	
	private String fname;
	
	@Lob
	private byte[] fdata;
	
	private String fileUploadDate;
	
	private long fsize;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public byte[] getFdata() {
		return fdata;
	}

	public void setFdata(byte[] fdata) {
		this.fdata = fdata;
	}

	public String getFileUploadDate() {
		return fileUploadDate;
	}

	public void setFileUploadDate(String fileUploadDate) {
		this.fileUploadDate = fileUploadDate;
	}

	public long getFsize() {
		return fsize;
	}

	public void setFsize(long fsize) {
		this.fsize = fsize;
	}

	@Override
	public String toString() {
		return "FileInfo [fid=" + fid + ", fname=" + fname + ", fdata=" + Arrays.toString(fdata) + ", fileUploadDate="
				+ fileUploadDate + ", fsize=" + fsize + "]";
	}
	
	
}