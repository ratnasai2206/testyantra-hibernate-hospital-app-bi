package com.ty.Dao;


import com.ty.hospital_app.entityFactoryHelper.EntityFactoryHelp;
import com.ty.hospital_entity.Hospital;

public class HospitalDao {

	// save hospital in the database
		public Hospital saveHospital(Hospital hospital) {
			if (hospital != null) {
				EntityFactoryHelp.entityTransaction.begin();
				EntityFactoryHelp.entityManager.persist(hospital);
				EntityFactoryHelp.entityTransaction.commit();
				System.out.println("registered successfully");
			}
			return hospital;
		}

		// search Hospital in the database
		public Hospital searchHospital(int hospital_Id) {

			return EntityFactoryHelp.entityManager.find(Hospital.class, hospital_Id);

		}
		// update hospital from the database
		public Hospital updateHospital(int hospital_Id, Hospital hospital) {
			if (hospital_Id ==hospital.getHospital_Id() && hospital != null) {
				EntityFactoryHelp.entityTransaction.begin();
				EntityFactoryHelp.entityManager.merge(hospital);
				EntityFactoryHelp.entityTransaction.commit();
			}
			return hospital;
		}
		// remove hospital from the database
		public boolean removeHospital(int hospital_Id) {
			if (hospital_Id>0) {
				Hospital hospital = searchHospital(hospital_Id);
				if(hospital!=null) {
					EntityFactoryHelp.entityTransaction.begin();
					EntityFactoryHelp.entityManager.remove(hospital);
					EntityFactoryHelp.entityTransaction.commit();
					return true;
				}
			}
			return false;
		}
}
