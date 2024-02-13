package com.ty.Dao;



import com.ty.hospital_app.entityFactoryHelper.EntityFactoryHelp;
import com.ty.hospital_entity.Branch;
import com.ty.hospital_entity.Hospital;


public class BranchDao {


	// save the Branch from the branch database
	public Branch saveBranch(Branch branch, int hospital_id) {
		HospitalDao hospitalDao = new HospitalDao();
		AddressDao addressDao = new AddressDao();
		Hospital hospital = hospitalDao.searchHospital(hospital_id);
		System.err.println(hospital+" = "+hospital_id);
		if (hospital != null) {
			branch.setAddress(addressDao.saveAddress(branch.getAddress()));
			branch.setHospital(hospital);
			EntityFactoryHelp.entityTransaction.begin();
			EntityFactoryHelp.entityManager.persist(branch);
			EntityFactoryHelp.entityTransaction.commit();
			hospital.getBranchs().add(branch);
			hospitalDao.updateHospital(hospital_id, hospital);
			System.out.println("registered successfully");
			return branch;
		}
		System.out.println("Hospital With the Give Id = " + hospital_id + " Not Found");
		return null;

	}

	// find the Branch from the branch database
	public Branch searchBranch(int branch_Id) {
		return EntityFactoryHelp.entityManager.find(Branch.class, branch_Id);
	}

	 //update Item into Item from database
	public Branch updateBranch(int branch_Id, Branch branch) {
		if (branch_Id==branch.getBranch_Id() && branch != null) {
			EntityFactoryHelp.entityTransaction.begin();
			EntityFactoryHelp.entityManager.merge(branch);
			EntityFactoryHelp.entityTransaction.commit();
		}
		return branch;
	}

	// remove the item from the database
	public boolean removeBranch(int branch_Id) {
		if (branch_Id >0) {
			Branch branch = searchBranch(branch_Id);
			if(branch!=null) {
				EntityFactoryHelp.entityTransaction.begin();
				EntityFactoryHelp.entityManager.remove(branch);
				EntityFactoryHelp.entityTransaction.commit();
				return true;
			}
		}
		return false;

	}

}
