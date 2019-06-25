package com.forever.pojo;

public class Img {
	private String imgStr;

	public String getImgStr() {
		return imgStr;
	}

	public void setImgStr(String imgStr) {
		this.imgStr = imgStr;
	}

	@Override
	public String toString() {
		return "Img [imgStr=" + imgStr + "]";
	}

	public Img(String imgStr) {
		super();
		this.imgStr = imgStr;
	}

	public Img() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
