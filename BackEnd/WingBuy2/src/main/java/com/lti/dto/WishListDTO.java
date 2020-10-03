package com.lti.dto;

public class WishListDTO {
	private int wId;
	private int pId;
	private int uId;
	
	public int getwId() {
		return wId;
	}
	public void setwId(int wId) {
		this.wId = wId;
	}
	
	public WishListDTO() {
		super();
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}

	public WishListDTO(int wId, int pId, int uId) {
		super();
		this.wId = wId;
		this.pId = pId;
		this.uId = uId;
	}
	@Override
	public String toString() {
		return "WishListDTO [wId=" + wId + ", pId=" + pId + ", uId=" + uId + "]";
	}
	

}
