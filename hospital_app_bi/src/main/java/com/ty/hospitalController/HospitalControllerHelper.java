package com.ty.hospitalController;

import java.util.List;
import java.util.Scanner;

import com.ty.hospital_entity.Address;
import com.ty.hospital_entity.Branch;
import com.ty.hospital_entity.Encounter;
import com.ty.hospital_entity.Hospital;
import com.ty.hospital_entity.Item;
import com.ty.hospital_entity.MedOrders;
import com.ty.hospital_entity.Person;

public class HospitalControllerHelper {

	static Scanner sc=new Scanner(System.in);
	public static int getChoice() {
		System.out.println("1. Save");
		System.out.println("2. Find");
		System.out.println("3. Update");
		System.out.println("4. Remove");
		System.out.println("5. Exit");
		System.out.print("Enter your choice : ");
		return sc.nextInt();
	}
	
	public static int getSaveChoice() {
		System.out.println("1. Save Hospital");
		System.out.println("2. Save Branch");
		System.out.println("3. Save Person");
		System.out.println("4. Save Encounter");
		System.out.println("5. Save MedOrders");
		System.out.println("6. Exit");
		System.out.print("Enter your choice : ");
		return sc.nextInt();
	}
	public static int getFindChoice() {
		System.out.println("1. Find Hospital");
		System.out.println("2. Find Branch");
		System.out.println("3. Find Person");
		System.out.println("4. Find Encounter");
		System.out.println("5. Find MedOrders");
		System.out.println("6. Exit");
		System.out.print("Enter your choice : ");
		return sc.nextInt();
	}
	public static int getUpdateChoice() {
		System.out.println("1. Update Hospital");
		System.out.println("2. Update Branch");
		System.out.println("3. Update Person");
		System.out.println("4. Update Encounter");
		System.out.println("5. Update MedOrders");
		System.out.println("6. Exit");
		System.out.print("Enter your choice : ");
		return sc.nextInt();
	}
	public static int getRemoveChoice() {
		System.out.println("1. Remove Hospital");
		System.out.println("2. Remove Branch");
		System.out.println("3. Remove Person");
		System.out.println("4. Remove Encounter");
		System.out.println("5. Remove MedOrders");
		System.out.println("6. Remove items");
		System.out.println("7. Exit");
		System.out.print("Enter your choice : ");
		return sc.nextInt();
	}
	public static int getId( String str) {
		System.out.print("Enter the "+str+"_ID :");
		return sc.nextInt();
	}

	public static void printObject(Hospital hospital) {
		Hospital str=hospital;
		System.out.println("Hospital id is : "+str.getHospital_Id());
		System.out.println("Hospital name is : "+str.getHospital_Name());
		System.out.println("Hospital Location is : "+str.getHospital_Location());
		System.out.println("Hospital speciality type  is : "+str.getHospital_Speciality());
		List<Branch> branchs=hospital.getBranchs();
		for (Branch branch : branchs) {
			printObject(branch);
		}
		
	}

	public static void printObject(Branch branchs) {
		Branch branch=branchs;
		System.out.println("branch id is :"+branch.getBranch_Id());
		System.out.println("branch name is :"+branch.getBranch_Name());
		System.out.println("branch number of Beds is :"+branch.getBranch_No_Of_Beds());
		System.out.println("branch number of Doctors is :"+branch.getBranch_No_Of_Doctors());
		System.out.println("branch speciality type is :"+branch.getBranch_Speciality());
		Address address=branch.getAddress();
		System.out.println("Address Id : "+address.getAddress_Id());
		System.out.println("Street : "+address.getAddress_StreetName());
		System.out.println("City : "+address.getAddress_CityName());
		System.out.println("District : "+address.getAddress_DistrictName());
		System.out.println("State : "+address.getAddress_StateName());
		System.out.println("Postal code : "+address.getAddress_PinCode());
	}
	public static void printPerson(Person person) {
		System.out.println("Person id : "+person.getPerson_Id());
		System.out.println("Person name : "+person.getPerson_Name());
		System.out.println("Person email : "+person.getPerson_email());
		System.out.println("Person phone number : "+person.getPerson_phoneNumber());
		System.out.println("Person age : "+person.getPerson_Age());
		System.out.println("Person address : "+person.getPerson_Address());
		System.out.println("Person blood group : "+person.getPerson_BloodGroup());
	}
	public static void printEncounter(Encounter encounter) {
		System.out.println("Encounter id : "+encounter.getEncounter_Id());
		System.out.println("Description : "+encounter.getEncounter_Description());
		System.out.println("Chief complaint : "+encounter.getEncounter_ChiefComplaint());
		System.out.println("Consult departpent name : "+encounter.getEncounter_consultDepartment());
		List<MedOrders> orders=encounter.getMedOrders();
		for (MedOrders medOrders : orders) {
			printMedOrders(medOrders);
		}
	}
	public static void printMedOrders(MedOrders order) {
		System.out.println("Order id : "+order.getMedOrder_Id());
		System.out.println("Prescribed doctor : "+order.getMedOrder_PresecribingDoctor());
		System.out.println("Order dosage : "+order.getMedOrder_Dosage());
		System.out.println("Order medication type : "+order.getMedOrder_MedicationType());
		if(order.isMedOrder_IsCompleted()) {
			System.out.println("Order completed");
		} else {
			System.out.println("Order pending");
		}
		List<Item> items = order.getItems();
		for (int i = 0; i < items.size(); i++) {
			System.out.println("Item : "+(i+1));
			Item item = items.get(i);
			System.out.println("Item name : "+item.getItem_Name());
			System.out.println("Item Manufacturer : "+item.getItem_Manufacturer());
			System.out.println("Item name : "+item.getItem_Name());
			System.out.println("Item cost : "+item.getItem_Price());
			System.out.println("Number of items : "+item.getItem_quantity());
		}
	}

	public static void printObjectBoolean(boolean hospital) {
		// TODO Auto-generated method stub
		if(hospital) {
			System.out.println("removed successfully");
		}else {
			System.out.println("not removed");
		}
	}
}
