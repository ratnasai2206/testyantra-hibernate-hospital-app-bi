package com.ty.hospital_app.entityFactoryHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ty.Dao.ItemDao;
import com.ty.hospital_entity.Item;
import com.ty.hospital_entity.MedOrders;

public class ItemHelper {

	static Scanner sc = new Scanner(System.in);

	public static Item getItem() {
		
		Item item=new Item();
		System.out.println("Enter Item Name:");
		String itemName = sc.next();
		item.setItem_Name(itemName);
		System.out.println("Enter Item Price:");
		double itemPrice = sc.nextDouble();
		item.setItem_Price(itemPrice);
		System.out.println("Enter Item Manufacturer:");
		String itemManufacturer = sc.next();
		item.setItem_Manufacturer(itemManufacturer);
		System.out.println("Enter Item Description:");
		String itemDescription = sc.next();
		item.setItem_description(itemDescription);
		System.out.println("Enter Item Quantity:");
		int itemQuantity = sc.nextInt();
		item.setItem_quantity(itemQuantity);
		System.out.println("Is the Item Available? (true/false):");
		boolean isAvailable = sc.nextBoolean();
		item.setAvailable(isAvailable);
		List<MedOrders> medOrders=new ArrayList<MedOrders>();
		item.setMedOrders(medOrders);
		new ItemDao().saveItem(item);
		return item;
	}

	public static Item updateItems(int item_Id) {
		Item item= null;
		if (item_Id > 0) {
			item = EntityFactoryHelp.entityManager.find(Item.class,item_Id);
			if (item!=null) {
				System.out.println("welcome to update method :) ");
				while (true) {
					System.out.println("enter 1 for update item_Name ");
					System.out.println("enter 2 for update item_Price ");
					System.out.println("enter 3 for update item_Manufacturer ");
					System.out.println("enter 4 for update item_description ");
					System.out.println("enter 5 for update item_quantity");
					System.out.println("enter 6 for update isAvailable");
					System.out.println("enter 7 for exit ");
					System.out.println("enter the choices :");
					int key = sc.nextInt();
					switch (key) {
					case 1: {
						System.out.println("enter the item_Name to be update ");
						String name = sc.next();
						item.setItem_Name(name);
						break;
					}
					case 2: {
						System.out.println("enter the item_price to be update ");
						double name = sc.nextDouble();
						item.setItem_Price(name);
						break;
					}
					case 3: {
						System.out.println("enter the  item_Manufacturer to be update ");
						String man=sc.next();
						item.setItem_Manufacturer(man);
						break;
					}
					case 4: {
						System.out.println("enter the  item_description to be update ");
						String des=sc.next();
						item.setItem_description(des);
						break;
					}
					case 5:{
						System.out.println("enter the item_quantity to be update ");
						int quantity=sc.nextInt();
						item.setItem_quantity(quantity);
						break;
					}
					case 6:{
						System.out.println("enter the isAvailable to be update(true/false) ");
						boolean quantity=sc.nextBoolean();
						item.setAvailable(quantity);
						break;
					}
					case 7:{
						break;
					}

					default: {
						System.out.println("entered choice is incorrect");
						break;
					}
					}
					if (key == 7) {
						break;
					}
				}
				HospitalAppFactory.getItemDao().updateItem(item_Id, item);
			}
		}
		return item;
	}
}
