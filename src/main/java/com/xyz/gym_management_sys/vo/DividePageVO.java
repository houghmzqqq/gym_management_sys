package com.xyz.gym_management_sys.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mysql.jdbc.Field;
import com.xyz.gym_management_sys.po.Equipment;

@Component
public class DividePageVO implements Serializable 
{
	private int rowOfEachPage = 5;//每一页行数
	private int maxPage;//总页数
	private int pageCount;
	private int thisPage = 1;//当前页号
	private int prePage;
	private int nextPage;
	private int lastPage;//最后一页
	private List<EquipmentVO> equipmentVOs = new ArrayList<EquipmentVO>();
	private List<FieldVO> fieldVOs = new ArrayList<FieldVO>();
	private List<EquOrderVO> equOrderVOs = new ArrayList<EquOrderVO>();
	private List<FieldOrderVO> fieldOrderVOs = new ArrayList<FieldOrderVO>();
	
	public List<EquOrderVO> getEquOrderVOs() {
		return equOrderVOs;
	}
	public void setEquOrderVOs(List<EquOrderVO> equOrderVOs) {
		this.equOrderVOs = equOrderVOs;
	}
	public List<FieldOrderVO> getFieldOrderVOs() {
		return fieldOrderVOs;
	}
	public void setFieldOrderVOs(List<FieldOrderVO> fieldOrderVOs) {
		this.fieldOrderVOs = fieldOrderVOs;
	}
	public List<EquipmentVO> getEquipmentVOs() {
		return equipmentVOs;
	}
	public void setEquipmentVOs(List<EquipmentVO> equipmentVOs) {
		this.equipmentVOs = equipmentVOs;
	}
	public List<FieldVO> getFieldVOs() {
		return fieldVOs;
	}
	public void setFieldVOs(List<FieldVO> fieldVOs) {
		this.fieldVOs = fieldVOs;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
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
	public int getThisPage() {
		return thisPage;
	}
	public void setThisPage(int thisPage) {
		this.thisPage = thisPage;
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
	@Override
	public String toString() {
		return "DividePageVO [rowOfEachPage=" + rowOfEachPage + ", maxPage=" + maxPage + ", pageCount=" + pageCount
				+ ", thisPage=" + thisPage + ", prePage=" + prePage + ", nextPage=" + nextPage + ", lastPage="
				+ lastPage + ", equipmentVOs=" + equipmentVOs + ", fieldVOs=" + fieldVOs + "]";
	}
	
}
