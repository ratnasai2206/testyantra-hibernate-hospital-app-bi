package com.ty.hospital_app.entityFactoryHelper;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import com.ty.hospital_entity.Item;
import com.ty.hospital_entity.MedOrders;

public class MedOrdersHelper {
	
	static Scanner sc=new Scanner(System.in);
	public static MedOrders getMedOrder() {
		MedOrders medOrders=new MedOrders();
        System.out.println("Enter MedOrder Medication Type:");
        String medOrderMedicationType = sc.next();
        medOrders.setMedOrder_MedicationType(medOrderMedicationType);
        System.out.println("Enter MedOrder Dosage:");
        int medOrderDosage = sc.nextInt();
        medOrders.setMedOrder_Dosage(medOrderDosage);
        System.out.println("Enter MedOrder Prescribing Doctor:");
        String medOrderPrescribingDoctor = sc.next();
        medOrders.setMedOrder_PresecribingDoctor(medOrderPrescribingDoctor);
        System.out.println("Is MedOrder Completed? (true/false):");
        boolean medOrderIsCompleted = sc.nextBoolean();
        medOrders.setMedOrder_IsCompleted(medOrderIsCompleted);
        List<Item> items = new ArrayList<Item>();
        System.out.println("enter no of items: ");
        int itemsCount=sc.nextInt();
        for(int i=0;i<itemsCount;i++) {
        	Item item=ItemHelper.getItem();
        	items.add(item);
        }
        medOrders.setItems(items);
        return medOrders;
	}

	public static MedOrders updateMedOrders(int medorders_id) {
		MedOrders medOrders = null;
		if (medorders_id > 0) {
			medOrders = EntityFactoryHelp.entityManager.find(MedOrders.class,medorders_id);
			if (medOrders!=null) {
				System.out.println("welcome to update method :) ");
				while (true) {
					System.out.println("enter 1 for update MedOrder Medication Type ");
					System.out.println("enter 2 for update MedOrder Dosage ");
					System.out.println("enter 3 for update MedOrder Prescribing Doctor  ");
					System.out.println("enter 4 for update MedOrder Completed? (true/false)");
					System.out.println("enter 5 for exit ");
					System.out.println("enter the choices :");
					int key = sc.nextInt();
					switch (key) {
					case 1: {
						System.out.println("enter the  MedOrder Medication Type to be update ");
						String name = sc.next();
						medOrders.setMedOrder_MedicationType(name);
						break;
					}
					case 2: {
						System.out.println("enter the MedOrder Dosage to be update ");
						int name = sc.nextInt();
						medOrders.setMedOrder_Dosage(name);
						break;
					}
					case 3: {
						System.out.println("enter the  MedOrder Prescribing Doctor to be update ");
						String doctors=sc.next();
						medOrders.setMedOrder_PresecribingDoctor(doctors);
						break;
					}
					case 4: {
						System.out.println("enter the  update MedOrder Completed? (true/false) to be update ");
						boolean doctors=sc.nextBoolean();
						medOrders.setMedOrder_IsCompleted(doctors);
						break;
					}
					case 5:{
						break;
					}

					default: {
						System.out.println("entered choice is incorrect");
						break;
					}
					}
					if (key == 5) {
						break;
					}
				}
				HospitalAppFactory.getMedOrderDao().updateEncounter(medorders_id, medOrders);
			}
		}
		return medOrders;
	}
}
