package com.ty.hospital_app.entityFactoryHelper;

import com.ty.Dao.AddressDao;
import com.ty.Dao.BranchDao;
import com.ty.Dao.EncounterDao;
import com.ty.Dao.HospitalDao;
import com.ty.Dao.ItemDao;
import com.ty.Dao.MedOrderDao;
import com.ty.Dao.PersonDao;


public class HospitalAppFactory {
	
	public static HospitalDao getHospitalDao() {
		return new HospitalDao();
	}
	public static BranchDao getBranchDao() {
		return new BranchDao();
	}
	public static EncounterDao getEncounterDao() {
		return new EncounterDao();
	}
	public static AddressDao getAddressDao() {
		return new AddressDao();
	}
	public static ItemDao getItemDao() {
		return new ItemDao();
	}
	public static MedOrderDao getMedOrderDao() {
		return new MedOrderDao();
	}
	public static PersonDao getPersonDao() {
		return new PersonDao();
	}

}
