package com.ty.Dao;

import java.util.List;

import com.ty.hospital_app.entityFactoryHelper.EntityFactoryHelp;
import com.ty.hospital_entity.Item;
import com.ty.hospital_entity.MedOrders;

public class ItemDao {

	// save the item from the item database
	public Item saveItem(Item item) {
		if (item != null) {
			EntityFactoryHelp.entityTransaction.begin();
			EntityFactoryHelp.entityManager.persist(item);
			EntityFactoryHelp.entityTransaction.commit();
		}
		return item;

	}

	// search Item into Item from Database
	public Item searchItem(int item_Id) {
		return EntityFactoryHelp.entityManager.find(Item.class, item_Id);
	}

	// update Item into Item from database
	public Item updateItem(int item_Id, Item item) {
		if (item_Id == item.getItem_Id() && item != null) {
			EntityFactoryHelp.entityTransaction.begin();
			EntityFactoryHelp.entityManager.merge(item);
			EntityFactoryHelp.entityTransaction.commit();
			System.out.println("registered successfully");
		}
		return item;
	}

	// remove the item from the database
	public boolean removeItem(int item_Id) {
		if (item_Id > 0) {
			Item item = searchItem(item_Id);
			List<MedOrders> medOrders = item.getMedOrders();
			for (MedOrders medOrders2 : medOrders) {
				List<Item> items = medOrders2.getItems();
				for (int i = 0; i < items.size(); i++) {
					if(item_Id==items.get(i).getItem_Id()) {
						items.remove(i);
					}
				}
				medOrders2.setItems(items);
				EntityFactoryHelp.entityTransaction().begin();
				EntityFactoryHelp.entityManager().merge(medOrders2);
				EntityFactoryHelp.entityTransaction().commit();
			}
			
			if (item != null) {
				EntityFactoryHelp.entityTransaction().begin();
				EntityFactoryHelp.entityManager().remove(item);
				EntityFactoryHelp.entityTransaction().commit();
				return true;
			}
		}
		return false;

	}

}
