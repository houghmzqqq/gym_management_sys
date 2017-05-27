package com.xyz.gym_management_sys.vo;

import com.xyz.gym_management_sys.po.EquType;

public class EquipmentVO 
{
	private int equId;
	private String equName;
	private int equTypeId;
	private String equTypeName;
	private int equNormalCount;//可用器材数
	private int equReserveCount;
	private int equBorrowCount;
	private int equRepairCount;
	private int equBrokenCount;
	private int equDiscardCount;
	private int equTotalCount;//器材总数
	private float equBorrowUnitvaluent;
	private float equDeposit;
	private float equValue;

	public EquipmentVO() {
		super();
	}
	public EquipmentVO(String equName, int equTypeId, String equTypeName, int equNormalCount, int equReserveCount,
			int equBorrowCount, int equRepairCount, int equBrokenCount, int equDiscardCount, int equTotalCount,
			float equBorrowUnitvaluent, float equDeposit, float equValue) {
		super();
		this.equName = equName;
		this.equTypeId = equTypeId;
		this.equTypeName = equTypeName;
		this.equNormalCount = equNormalCount;
		this.equReserveCount = equReserveCount;
		this.equBorrowCount = equBorrowCount;
		this.equRepairCount = equRepairCount;
		this.equBrokenCount = equBrokenCount;
		this.equDiscardCount = equDiscardCount;
		this.equTotalCount = equTotalCount;
		this.equBorrowUnitvaluent = equBorrowUnitvaluent;
		this.equDeposit = equDeposit;
		this.equValue = equValue;
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
	public int getEquTypeId() {
		return equTypeId;
	}
	public void setEquTypeId(int equTypeId) {
		this.equTypeId = equTypeId;
	}
	public String getEquTypeName() {
		return equTypeName;
	}
	public void setEquTypeName(String equTypeName) {
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
	
	@Override
	public String toString() {
		return "EquipmentVO [equId=" + equId + ", equName=" + equName + ", equTypeId=" + equTypeId + ", equTypeName="
				+ equTypeName + ", equNormalCount=" + equNormalCount + ", equReserveCount=" + equReserveCount
				+ ", equBorrowCount=" + equBorrowCount + ", equRepairCount=" + equRepairCount + ", equBrokenCount="
				+ equBrokenCount + ", equDiscardCount=" + equDiscardCount + ", equTotalCount=" + equTotalCount
				+ ", equBorrowUnitvaluent=" + equBorrowUnitvaluent + ", equDeposit=" + equDeposit + ", equValue="
				+ equValue + "]";
	}
}
