package com.mediaocean.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mediaocean.bean.Item;

@Repository
public class ItemDao{

	@Autowired
	private SessionFactory sessionFactory;
 
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public List<Item> getAllItems() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Item> itemList = session.createQuery("from Item").list();
		return itemList;
	}
	
	public List<Item> getItemsByIds(List<Integer> itemIds) {
		Session session = this.sessionFactory.getCurrentSession();
		Query itemQuery = session.createQuery("from Item where itemId IN (:itemIds)");
		itemQuery.setParameterList("itemIds", itemIds);
		List<Item> itemList = itemQuery.list();
		return itemList;
	}

}
