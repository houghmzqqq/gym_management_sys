package com.xyz.gym_management_sys.vo;

import org.springframework.stereotype.Component;

@Component
public class EquCartDetailVO 
{
	private String cartRecordId;
	private int equId;
	private int equCount;
	
	public String getCartRecordId() {
		return cartRecordId;
	}
	public void setCartRecordId(String cartRecordId) {
		this.cartRecordId = cartRecordId;
	}
	public int getEquId() {
		return equId;
	}
	public void setEquId(int equId) {
		this.equId = equId;
	}
	public int getEquCount() {
		return equCount;
	}
	public void setEquCount(int equCount) {
		this.equCount = equCount;
	}
	@Override
	public String toString() {
		return "EquCartDetailVO [cartRecordId=" + cartRecordId + ", equId=" + equId + ", equCount=" + equCount + "]";
	}
	
	
}
