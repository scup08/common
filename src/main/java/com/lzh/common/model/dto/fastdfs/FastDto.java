package com.lzh.common.model.dto.fastdfs;

public class FastDto {

	private String name;
    private byte[] content;
    private String ext;
    private String md5;
    private String author;
    private Integer duration;  //音频总时长
    private Integer fileSize;  //文件大小
    
    public FastDto( ){
    }
    
    public FastDto(String name, byte[] content, String ext ){
    	this.name = name;
    	this.content = content;
    	this.ext = ext ;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}

	
}
