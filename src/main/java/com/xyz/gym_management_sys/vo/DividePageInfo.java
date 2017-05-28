package com.xyz.gym_management_sys.vo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class DividePageInfo implements Serializable 
{
	private int rowOfEachPage;//每一页行数
	private int rowCount;//总行数
	private int maxPage;//总页数
	private int thisPage = 1;//当前页号
	private int nextPage;
	private int lastPage;
	
	public int getRowOfEachPage() {
		return rowOfEachPage;
	}
	public void setRowOfEachPage(int rowOfEachPage) {
		this.rowOfEachPage = rowOfEachPage;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
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
}
