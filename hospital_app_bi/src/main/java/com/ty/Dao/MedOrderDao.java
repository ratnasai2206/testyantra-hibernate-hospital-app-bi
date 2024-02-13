package com.ty.Dao;


import java.util.List;
import com.ty.hospital_app.entityFactoryHelper.EntityFactoryHelp;
import com.ty.hospital_entity.Encounter;
import com.ty.hospital_entity.Item;
import com.ty.hospital_entity.MedOrders;

public class MedOrderDao {

	// save MedOrder in the MedOrder database
	public MedOrders saveMedOrders(MedOrders medOrders, int encounter_id) {
		if(medOrders!=null&&encounter_id>0) {
			Encounter encounter=EntityFactoryHelp.entityManager.find(Encounter.class, encounter_id);
			if(encounter!=null) {
				List<MedOrders> medOrder=encounter.getMedOrders();
				medOrder.add(medOrders);
				encounter.setMedOrders(medOrder);
				ItemDao itemDao=new ItemDao();
				List<Item> items=medOrders.getItems();
				Item it=null;
				for (Item item : items) {
					if(EntityFactoryHelp.entityManager.find(Item.class, item.getItem_Id())==null) {
						it=itemDao.saveItem(item);
						items.add(it);
					}
				}
				medOrders.setEncounter(encounter);
				medOrders.setItems(items);
				EntityFactoryHelp.entityTransaction.begin();
				EntityFactoryHelp.entityManager.merge(encounter);
//				EntityFactoryHelp.entityManager.persist(medOrders);
				EntityFactoryHelp.entityTransaction.commit();
				System.out.println("registered successfully");
			}
		}
		return medOrders;
		
	}
	
	//update MedOrder in the data
	public MedOrders updateEncounter(int medOrder_id,MedOrders medOrders) {
		if (medOrder_id== medOrders.getMedOrder_Id() && medOrders!= null) {
			EntityFactoryHelp.entityTransaction.begin();
			EntityFactoryHelp.entityManager.merge(medOrders);
			EntityFactoryHelp.entityTransaction.commit();
		}
		return medOrders;
		
	}
	
	//search medOrder from the database
	public MedOrders findOrder(int MedOrder_id) {
		return EntityFactoryHelp.entityManager.find(MedOrders.class, MedOrder_id);
	}
	//remove MedOrder from the database
	public boolean removeMedOrder(int MedOrder_id) {
		
		if(MedOrder_id>0) {
			MedOrders medOrders=findOrder(MedOrder_id);
			if(medOrders!=null) {
				EntityFactoryHelp.entityTransaction.begin();
				EntityFactoryHelp.entityManager.remove(medOrders);
				EntityFactoryHelp.entityTransaction.commit();
				return true;
			}
		}
		return false;	
	}
}
