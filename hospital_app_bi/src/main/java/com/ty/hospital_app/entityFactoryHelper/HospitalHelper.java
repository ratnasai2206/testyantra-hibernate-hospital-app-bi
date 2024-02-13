package com.ty.hospital_app.entityFactoryHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ty.hospital_entity.Branch;
import com.ty.hospital_entity.Hospital;

public class HospitalHelper {
	static Scanner sc = new Scanner(System.in);

	public static Hospital getHospital() {
		System.out.println("register the hospital");
		Hospital hospital = new Hospital();
		System.out.println("enter hospital name");
		String name = sc.next();
		hospital.setHospital_Name(name);
		System.out.println("enter hospital speciality type");
		String type = sc.next();
		hospital.setHospital_Speciality(type);
		System.out.println("enter hospital location");
		String loc = sc.next();
		hospital.setHospital_Location(loc);
		List<Branch> branchs = new ArrayList<Branch>();
		hospital.setBranchs(branchs);
		return hospital;
	}

	public static Hospital updateHospital(int id) {
		Hospital hospital = null;
		if (id > 0) {
			hospital = EntityFactoryHelp.entityManager.find(Hospital.class, id);
			if (hospital != null) {
				System.out.println("welcome to update method :) ");
				while (true) {
					System.out.println("enter 1 for update hospital name ");
					System.out.println("enter 2 for update hospital speciality ");
					System.out.println("enter 3 for update hospital location ");
					System.out.println("enter 4 for exit ");
					System.out.println("enter the choices :");
					int key = sc.nextInt();
					switch (key) {
					case 1: {
						System.out.println("enter the hospital name to be update ");
						String name = sc.next();
						hospital.setHospital_Name(name);
						break;
					}
					case 2: {
						System.out.println("enter the hospital speciality to be update ");
						String name = sc.next();
						hospital.setHospital_Speciality(name);
						break;
					}
					case 3: {
						System.out.println("enter the hospital location to be update ");
						String name = sc.next();
						hospital.setHospital_Location(name);
						break;
					}
					case 4: {
						break;
					}

					default: {
						System.out.println("entered choice is incorrect");
						break;
					}
					}
					if (key == 4) {
						break;
					}
				}
				HospitalAppFactory.getHospitalDao().updateHospital(id, hospital);
			}
		}
		return hospital;
	}
}
