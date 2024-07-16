package com.webtoonsalad.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WagleCriteria {

	private int pageNum;
	private int amount;
	
	public WagleCriteria() {
		this(1, 10);
	}
	
	public WagleCriteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
