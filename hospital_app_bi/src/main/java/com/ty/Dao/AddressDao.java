package com.ty.Dao;

import com.ty.hospital_app.entityFactoryHelper.EntityFactoryHelp;
import com.ty.hospital_entity.Address;

public class AddressDao {

	// save the address from the address database
	public Address saveAddress(Address address) {
		if (address != null) {
			EntityFactoryHelp.entityTransaction.begin();
			EntityFactoryHelp.entityManager.persist(address);
			EntityFactoryHelp.entityTransaction.commit();
			System.out.println("registered successfully");
		}
		return address;

	}

	// search Item into Item from Database
	public Address searchItem(int address_Id) {
		return EntityFactoryHelp.entityManager.find(Address.class, address_Id);
	}

	// update Item into Item from database
	public Address updateItem(int address_Id, Address address) {
		if (address_Id==address.getAddress_Id() && address != null) {
			EntityFactoryHelp.entityTransaction.begin();
			EntityFactoryHelp.entityManager.merge(address);
			EntityFactoryHelp.entityTransaction.commit();
		}
		return address;
	}

	// remove the item from the database
	public boolean removeAddress(int address_Id) {
		if (address_Id >0) {
			Address address = searchItem(address_Id);
			if(address!=null) {
				EntityFactoryHelp.entityTransaction.begin();
				EntityFactoryHelp.entityManager.remove(address);
				EntityFactoryHelp.entityTransaction.commit();
				return true;
			}
		}
		return false;

	}
}
