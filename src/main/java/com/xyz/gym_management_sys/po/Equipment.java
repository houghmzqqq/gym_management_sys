package com.xyz.gym_management_sys.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="equipment")
public class Equipment implements Serializable {
	private int equId;
	private String equName;
//	private int equTypeId;
	private int equNormalCount;
	private int equReserveCount; 
	private int equBorrowCount; 
	private int equRepairCount; 
	private int equBrokenCount; 
	private int equDiscardCount;  
	private float equBorrowUnitvaluent;//单价
	private float equDeposit;
	private float equValue;
	private EquType equType;
	
	
	public Equipment() {
		super();
	}
	public Equipment(String equName, int equNormalCount, int equReserveCount, int equBorrowCount, int equRepairCount,
			int equBrokenCount, int equDiscardCount, float equBorrowUnitvaluent, float equDeposit, float equValue,
			EquType equType) {
		super();
		this.equName = equName;
		this.equNormalCount = equNormalCount;
		this.equReserveCount = equReserveCount;
		this.equBorrowCount = equBorrowCount;
		this.equRepairCount = equRepairCount;
		this.equBrokenCount = equBrokenCount;
		this.equDiscardCount = equDiscardCount;
		this.equBorrowUnitvaluent = equBorrowUnitvaluent;
		this.equDeposit = equDeposit;
		this.equValue = equValue;
		this.equType = equType;
	}
	@ManyToOne(targetEntity=EquType.class)
	@JoinColumn(name="equ_type_id",nullable=true)
	public EquType getEquType() {
		return equType;
	}
	public void setEquType(EquType equType) {
		this.equType = equType;
	}
	
	@Id @Column(name="equ_id")
	@GeneratedValue(generator="id")
	@GenericGenerator(name="id", strategy="increment")
	public int getEquId() {
		return equId;
	}
	public void setEquId(int equId) {
		this.equId = equId;
	}
	@Column(name="equ_name")
	public String getEquName() {
		return equName;
	}
	public void setEquName(String equName) {
		this.equName = equName;
	}
//	public int getEquTypeId() {
//		return equTypeId;
//	}
//	public void setEquTypeId(int equTypeId) {
//		this.equTypeId = equTypeId;
//	}
	@Column(name="equ_normal_count")
	public int getEquNormalCount() {
		return equNormalCount;
	}
	public void setEquNormalCount(int equNormalCount) {
		this.equNormalCount = equNormalCount;
	}
	@Column(name="equ_reserve_count")
	public int getEquReserveCount() {
		return equReserveCount;
	}
	public void setEquReserveCount(int equReserveCount) {
		this.equReserveCount = equReserveCount;
	}
	@Column(name="equ_borrow_count")
	public int getEquBorrowCount() {
		return equBorrowCount;
	}
	public void setEquBorrowCount(int equBorrowCount) {
		this.equBorrowCount = equBorrowCount;
	}
	@Column(name="equ_repair_count")
	public int getEquRepairCount() {
		return equRepairCount;
	}
	public void setEquRepairCount(int equRepairCount) {
		this.equRepairCount = equRepairCount;
	}
	@Column(name="equ_broken_count")
	public int getEquBrokenCount() {
		return equBrokenCount;
	}
	public void setEquBrokenCount(int equBrokenCount) {
		this.equBrokenCount = equBrokenCount;
	}
	@Column(name="equ_discard_count")
	public int getEquDiscardCount() {
		return equDiscardCount;
	}
	public void setEquDiscardCount(int equDiscardCount) {
		this.equDiscardCount = equDiscardCount;
	}
	@Column(name="equ_borrow_unitvaluent")
	public float getEquBorrowUnitvaluent() {
		return equBorrowUnitvaluent;
	}
	public void setEquBorrowUnitvaluent(float equBorrowUnitvaluent) {
		this.equBorrowUnitvaluent = equBorrowUnitvaluent;
	}
	@Column(name="equ_deposit")
	public float getEquDeposit() {
		return equDeposit;
	}
	public void setEquDeposit(float equDeposit) {
		this.equDeposit = equDeposit;
	}
	@Column(name="equ_value")
	public float getEquValue() {
		return equValue;
	}
	public void setEquValue(float equValue) {
		this.equValue = equValue;
	}
	@Override
	public String toString() {
		return "Equipment [equId=" + equId + ", equName=" + equName + ", equNormalCount=" + equNormalCount
				+ ", equReserveCount=" + equReserveCount + ", equBorrowCount=" + equBorrowCount + ", equRepairCount="
				+ equRepairCount + ", equBrokenCount=" + equBrokenCount + ", equDiscardCount=" + equDiscardCount
				+ ", equBorrowUnitvaluent=" + equBorrowUnitvaluent + ", equDeposit=" + equDeposit + ", equValue="
				+ equValue + ", equType=" + equType + "]";
	}
}
