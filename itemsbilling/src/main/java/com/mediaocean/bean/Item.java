package com.mediaocean.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to Item table in database
 */
@Entity
@Table(name="ITEM_MASTER")
public class Item {
	
	@Id
	@Column(name="ITEM_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int itemId;
 
	@Column(name="ITEM_NAME")
	private String itemName;
	
	@OneToOne
	@JoinColumn(name="CATEGORY_ID")
	private Category itemCategory;

	@Column(name="CREATED_DATE")
	private String createdDate;
	
	@Column(name="PRICE")
	private Double price;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Category getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(Category itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemCategory=" + itemCategory + ", createdDate="
				+ createdDate + ", price=" + price + "]";
	}
}
