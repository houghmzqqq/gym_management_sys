package com.xyz.gym_management_sys.po;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.xyz.gym_management_sys.po.Equipment;
import com.xyz.gym_management_sys.po.Field;

@Component
public class DividePage implements Serializable 
{
	private int rowOfEachPage = 5;//每一页行数
	private int maxPage;//总页数
	private int pageCount;
	private int thisPage = 1;//当前页号
	private int prePage;
	private int nextPage;
	private int lastPage;//最后一页
	private List<Equipment> equipments;
	private List<Field> fields;
	private List<EquOrder> equOrders;
	private List<FieldOrder> fieldOrders;
	
	public int getRowOfEachPage() {
		return rowOfEachPage;
	}


	public void setRowOfEachPage(int rowOfEachPage) {
		this.rowOfEachPage = rowOfEachPage;
	}


	public int getMaxPage() {
		return maxPage;
	}


	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}


	public int getPageCount() {
		return pageCount;
	}


	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}


	public int getThisPage() {
		return thisPage;
	}


	public void setThisPage(int thisPage) {
		this.thisPage = thisPage;
	}


	public int getPrePage() {
		return prePage;
	}


	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}


	public int getNextPage() {
		return nextPage;
	}


	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}


	public int getLastPage() {
		return lastPage;
	}


	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}


	public List<Equipment> getEquipments() {
		return equipments;
	}


	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}


	public List<Field> getFields() {
		return fields;
	}


	public void setFields(List<Field> fields) {
		this.fields = fields;
	}


	public List<EquOrder> getEquOrders() {
		return equOrders;
	}


	public void setEquOrders(List<EquOrder> equOrders) {
		this.equOrders = equOrders;
	}


	public List<FieldOrder> getFieldOrders() {
		return fieldOrders;
	}


	public void setFieldOrders(List<FieldOrder> fieldOrders) {
		this.fieldOrders = fieldOrders;
	}


	@Override
	public String toString() {
		return "DividePage [rowOfEachPage=" + rowOfEachPage + ", maxPage=" + maxPage + ", pageCount=" + pageCount
				+ ", thisPage=" + thisPage + ", prePage=" + prePage + ", nextPage=" + nextPage + ", lastPage="
				+ lastPage + ", equipments=" + equipments + ", fields=" + fields + "]";
	}
	
}
