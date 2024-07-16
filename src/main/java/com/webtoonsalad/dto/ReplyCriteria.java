package com.webtoonsalad.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReplyCriteria {

	private int pageNum;
	private int amount;
	
	public ReplyCriteria() {
		this(1, 3);
	}
	
	public ReplyCriteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
}
