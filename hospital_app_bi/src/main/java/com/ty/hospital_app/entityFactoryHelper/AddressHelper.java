package com.ty.hospital_app.entityFactoryHelper;

import java.util.Scanner;

import com.ty.hospital_entity.Address;
import com.ty.hospital_entity.Branch;



public class AddressHelper {

	
	static Scanner sc=new Scanner(System.in);
	public static Address getAddress() {
		Address address=new Address();
		System.out.println("enter the Address_StreetName ");
		String street=sc.next();
		address.setAddress_StreetName(street);
		System.out.println("enter the Address_CityName");
		String city=sc.next();
		address.setAddress_CityName(city);
		System.out.println("enter the Address_DistrictName");
		String district=sc.next();
		address.setAddress_DistrictName(district);
		System.out.println("enter the Address_StateName");
		String stateName=sc.next();
		address.setAddress_StateName(stateName);
		System.out.println("enter the Address_PinCode");
		int pinCode=sc.nextInt();
		address.setAddress_PinCode(pinCode);
		return address;
	}
	
	public static Address updateAddress(int address_Id,int branch_id) {
		Address address= null;
		if (address_Id > 0) {
			address = EntityFactoryHelp.entityManager.find(Address.class,address_Id);
			Branch branch=address.getBranch();
			
			if (branch_id==branch.getBranch_Id()) {
				System.out.println("welcome to update method :) ");
				while (true) {
					System.out.println("enter 1 for update Address_StreetName ");
					System.out.println("enter 2 for update Address_CityName ");
					System.out.println("enter 3 for update Address_DistrictName ");
					System.out.println("enter 4 for update Address_StateName ");
					System.out.println("enter 5 for update Address_PinCode");
					System.out.println("enter 6 for exit ");
					System.out.println("enter the choices :");
					int key = sc.nextInt();
					switch (key) {
					case 1: {
						System.out.println("enter the  Address_StreetName to be update ");
						String name = sc.next();
						address.setAddress_StreetName(name);
						break;
					}
					case 2: {
						System.out.println("enter the  Address_CityName to be update ");
						String name = sc.next();
						address.setAddress_CityName(name);
						break;
					}
					case 3: {
						System.out.println("enter the  Address_DistrictName to be update ");
						String name = sc.next();
						address.setAddress_DistrictName(name);
						break;
					}
					case 4: {
						System.out.println("enter the  Address_StateName to be update ");
						String name = sc.next();
						address.setAddress_StateName(name);
						break;
					}
					case 5:{
						System.out.println("enter the pincode to be update ");
						int quantity=sc.nextInt();
						address.setAddress_PinCode(quantity);
						break;
					}
					case 6:{
						break;
					}
					

					default: {
						System.out.println("entered choice is incorrect");
						break;
					}
					}
					if (key == 6) {
						break;
					}
				}
				HospitalAppFactory.getAddressDao().updateItem(address_Id, address);
			}
		}
		return address;
	}
}
