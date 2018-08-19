package com.mediaocean.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mediaocean.bean.BillingOP;
import com.mediaocean.bean.Item;
import com.mediaocean.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@RequestMapping(value = "/getAllItems", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Item> getCountries() {
		List<Item> listOfItems = itemService.getAllItems();
		return listOfItems;
	}
	
	@RequestMapping(value = "/generateBill", method = RequestMethod.POST, consumes = "application/json")
	public BillingOP generateBill(@RequestBody List<Integer> itemIds) {
		BillingOP billingDetails = itemService.generateBill(itemIds);
		return billingDetails;
	}
}
