package com.ty.hospital_app.entityFactoryHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ty.hospital_entity.Address;
import com.ty.hospital_entity.Branch;
import com.ty.hospital_entity.Encounter;


public class BranchHelper {
	static Scanner sc=new Scanner(System.in);
	public static Branch getBranch() { 
		Branch branch=new Branch();
		System.out.println("enter branch name");
		String name=sc.next();
		branch.setBranch_Name(name);
		System.out.println("enter branch no of beds");
		int capacity=sc.nextInt();
		branch.setBranch_No_Of_Beds(capacity);
		System.out.println("enter branch no of doctors");
		int no_of_doc=sc.nextInt();
		branch.setBranch_No_Of_Doctors(no_of_doc);
		System.out.println("enter branch speciality");
		String type=sc.next();
		branch.setBranch_Speciality(type);
		Address address=AddressHelper.getAddress();
		branch.setAddress(address);
		List<Encounter> encounter=new ArrayList<>();
		branch.setEncounters(encounter);
		return branch;
	}
	public static Branch updateBranch(int branch_id,int hospitals_Id) {
		Branch branch = null;
		if (branch_id > 0) {
			branch = EntityFactoryHelp.entityManager.find(Branch.class,branch_id);
			System.out.println(branch);
			int hospital_id=branch.getHospital().getHospital_Id();
			if (hospital_id==hospitals_Id) {
				System.out.println("welcome to update method :) ");
				while (true) {
					System.out.println("enter 1 for update branch_Name ");
					System.out.println("enter 2 for update hospital speciality ");
					System.out.println("enter 3 for update number of Doctors in hospital ");
					System.out.println("enter 4 for update number of beds in hospital ");
					System.out.println("enter 5 for updating address ");
					System.out.println("enter 6 for exit ");
					System.out.println("enter the choices :");
					int key = sc.nextInt();
					switch (key) {
					case 1: {
						System.out.println("enter the branch_Name to be update ");
						String name = sc.next();
						branch.setBranch_Name(name);
						break;
					}
					case 2: {
						System.out.println("enter the branch_speciality to be update ");
						String name = sc.next();
						branch.setBranch_Speciality(name);
						break;
					}
					case 3: {
						System.out.println("enter the  number of Doctors to be update ");
						int doctors=sc.nextInt();
						branch.setBranch_No_Of_Doctors(doctors);
						break;
					}
					case 4: {
						System.out.println("enter the  number of beds to be update ");
						int doctors=sc.nextInt();
						branch.setBranch_No_Of_Doctors(doctors);
						break;
					}
					case 5:{
						Address address=branch.getAddress();
						if(address!=null) {
							AddressHelper.updateAddress(address.getAddress_Id(), branch_id);
						}
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
				HospitalAppFactory.getBranchDao().updateBranch(branch_id, branch);
			}
		}
		return branch;
	}
}
