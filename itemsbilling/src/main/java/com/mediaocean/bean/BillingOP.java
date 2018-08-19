package com.mediaocean.bean;

import java.util.List;

/*
 * This is output model class and it holds generated billing details
 */
public class BillingOP {

	private List<Item> orderedItems;
	private Double totalSalesTax;
	private Double totalCost;
	
	public List<Item> getOrderedItems() {
		return orderedItems;
	}
	public void setOrderedItems(List<Item> orderedItems) {
		this.orderedItems = orderedItems;
	}
	public Double getTotalSalesTax() {
		return totalSalesTax;
	}
	public void setTotalSalesTax(Double totalSalesTax) {
		this.totalSalesTax = totalSalesTax;
	}
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	
}
