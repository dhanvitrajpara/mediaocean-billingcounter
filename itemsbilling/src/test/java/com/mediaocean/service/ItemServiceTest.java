package com.mediaocean.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mediaocean.bean.BillingOP;
import com.mediaocean.bean.Category;
import com.mediaocean.bean.Item;
import com.mediaocean.dao.ItemDao;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

	@Mock
	ItemDao itemDao;
	
	@InjectMocks
    ItemService itemService = new ItemService();
	
	@Test
	public void getAllItemsTest() {
		List<Item> mockedList = getItemsMockList();
		when(itemDao.getAllItems()).thenReturn(mockedList);
		
		List<Item> fetchedItems = itemService.getAllItems();
		
		assertNotNull(itemDao);
		assertNotNull(fetchedItems);
		assertEquals(3, fetchedItems.size());
		assertEquals(mockedList, fetchedItems);
	}
	
	@Test
	public void generateBill() {
		List<Integer> scannedItemIds = new ArrayList<>(Arrays.asList(1,2));
		List<Item> mockedList = getItemsMockList();
		when(itemDao.getItemsByIds(scannedItemIds)).thenReturn(mockedList);
		
		BillingOP billingDetails = itemService.generateBill(scannedItemIds);
		
		assertNotNull(itemDao);
		assertNotNull(billingDetails);
		assertEquals(3, billingDetails.getOrderedItems().size());
		assertEquals(Double.valueOf("50"), billingDetails.getTotalSalesTax());
		assertEquals(Double.valueOf("500"), billingDetails.getTotalCost());
	}
	
	private List<Item> getItemsMockList(){
		Category catA = new Category();
		catA.setCategoryId(1);
		catA.setCategoryName("Category A");
		catA.setSalesTax(10.0);
		Category catB = new Category();
		catB.setCategoryId(2);
		catB.setCategoryName("Category B");
		catB.setSalesTax(20.0);
		Category catC = new Category();
		catC.setCategoryId(2);
		catC.setCategoryName("Category C");
		catC.setSalesTax(null);
		
		List<Item> itemList = new ArrayList<>();
		Item item1 = new Item();
		item1.setItemId(1);
		item1.setItemName("CD");
		item1.setPrice(100.0);
		item1.setItemCategory(catA);
		Item item2 = new Item();
		item2.setItemId(2);
		item2.setItemName("DVD");
		item2.setPrice(200.0);
		item2.setItemCategory(catB);
		Item item3 = new Item();
		item3.setItemId(3);
		item3.setItemName("Mouse Pad");
		item3.setPrice(150.0);
		item3.setItemCategory(catC);
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		return itemList;
	}
}
