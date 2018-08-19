package com.mediaocean.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mediaocean.bean.BillingOP;
import com.mediaocean.bean.Item;
import com.mediaocean.dao.ItemDao;

@Service("itemService")
public class ItemService {

	@Autowired
	ItemDao itemDao;
	
	@Transactional
	public List<Item> getAllItems() {
		return itemDao.getAllItems();
	}
	
	@Transactional
	public BillingOP generateBill(List<Integer> itemIds) {
		BillingOP billingDetails = new BillingOP();
		if(null != itemIds && itemIds.size() > 0) {
			Double salesTax = 0.0;
			Double totalSalesTax = 0.0;
			Double totalCost = 0.0;
			List<Item> scannedItems = itemDao.getItemsByIds(itemIds);
			if(null != scannedItems && scannedItems.size() > 0) {
				for(Item item : scannedItems) {
					salesTax = 0.0;
					if(null != item.getPrice()) {
						totalCost += (item.getPrice());
						if(null != item.getItemCategory().getSalesTax()) {
							salesTax = (item.getPrice() * item.getItemCategory().getSalesTax()/100);
							totalCost += salesTax;
							totalSalesTax += salesTax;
						}
					}
				}
				billingDetails.setOrderedItems(scannedItems);
				billingDetails.setTotalCost(totalCost);
				billingDetails.setTotalSalesTax(totalSalesTax);
			}
		}
		return billingDetails;
	}

}
