package com.xyz.gym_management_sys.vo;

import java.io.Serializable;


public class EquOrderItemVO implements Serializable
{
	private int equOrderItemId;
	private int equOrderId;
	private int equId;
	private String equName;
	private int equBreakCount;
	private int equCount;
	private float equCompensation;
	
	public int getEquOrderItemId() {
		return equOrderItemId;
	}
	public void setEquOrderItemId(int equOrderItemId) {
		this.equOrderItemId = equOrderItemId;
	}
	public int getEquOrderId() {
		return equOrderId;
	}
	public void setEquOrderId(int equOrderId) {
		this.equOrderId = equOrderId;
	}
	public int getEquId() {
		return equId;
	}
	public void setEquId(int equId) {
		this.equId = equId;
	}
	public String getEquName() {
		return equName;
	}
	public void setEquName(String equName) {
		this.equName = equName;
	}
	public int getEquBreakCount() {
		return equBreakCount;
	}
	public void setEquBreakCount(int equBreakCount) {
		this.equBreakCount = equBreakCount;
	}
	public int getEquCount() {
		return equCount;
	}
	public void setEquCount(int equCount) {
		this.equCount = equCount;
	}
	public float getEquCompensation() {
		return equCompensation;
	}
	public void setEquCompensation(float equCompensation) {
		this.equCompensation = equCompensation;
	}
	
}
