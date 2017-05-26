package com.xyz.gym_management_sys.vo;

import com.xyz.gym_management_sys.po.EquType;

public class EquipmentVO 
{
	private int equId;
	private String equName;
	private int equTypeName;
	private int equNormalCount;//可用器材数
	private int equReserveCount; //被预定的器材数
	private int equBorrowCount; //已借出的器材数
	private int equRepairCount; //维修中的器材数
	private int equBrokenCount; //损坏的器材数
	private int equDiscardCount;  //报废的器材数
	private int equTotalCount;//器材总数
	private float equBorrowUnitvaluent;//租借单价
	private float equDeposit;//租借押金
	private float equValue;//器材购价

	
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
	public int getEquTypeName() {
		return equTypeName;
	}
	public void setEquTypeName(int equTypeName) {
		this.equTypeName = equTypeName;
	}
	public int getEquNormalCount() {
		return equNormalCount;
	}
	public void setEquNormalCount(int equNormalCount) {
		this.equNormalCount = equNormalCount;
	}
	public int getEquReserveCount() {
		return equReserveCount;
	}
	public void setEquReserveCount(int equReserveCount) {
		this.equReserveCount = equReserveCount;
	}
	public int getEquBorrowCount() {
		return equBorrowCount;
	}
	public void setEquBorrowCount(int equBorrowCount) {
		this.equBorrowCount = equBorrowCount;
	}
	public int getEquRepairCount() {
		return equRepairCount;
	}
	public void setEquRepairCount(int equRepairCount) {
		this.equRepairCount = equRepairCount;
	}
	public int getEquBrokenCount() {
		return equBrokenCount;
	}
	public void setEquBrokenCount(int equBrokenCount) {
		this.equBrokenCount = equBrokenCount;
	}
	public int getEquDiscardCount() {
		return equDiscardCount;
	}
	public void setEquDiscardCount(int equDiscardCount) {
		this.equDiscardCount = equDiscardCount;
	}
	public int getEquTotalCount() {
		return equTotalCount;
	}
	public void setEquTotalCount(int equTotalCount) {
		this.equTotalCount = equTotalCount;
	}
	public float getEquBorrowUnitvaluent() {
		return equBorrowUnitvaluent;
	}
	public void setEquBorrowUnitvaluent(float equBorrowUnitvaluent) {
		this.equBorrowUnitvaluent = equBorrowUnitvaluent;
	}
	public float getEquDeposit() {
		return equDeposit;
	}
	public void setEquDeposit(float equDeposit) {
		this.equDeposit = equDeposit;
	}
	public float getEquValue() {
		return equValue;
	}
	public void setEquValue(float equValue) {
		this.equValue = equValue;
	}
	
	
}
