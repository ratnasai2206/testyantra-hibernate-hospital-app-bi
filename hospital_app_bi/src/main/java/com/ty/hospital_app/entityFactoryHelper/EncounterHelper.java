package com.ty.hospital_app.entityFactoryHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.ty.hospital_entity.Encounter;
import com.ty.hospital_entity.MedOrders;


public class EncounterHelper {

	static Scanner sc = new Scanner(System.in);

	public static Encounter getEncounter() {
		Encounter encounter = new Encounter();
		System.out.println("Enter Encounter Description:");
		String encounterDescription = sc.next();
		encounter.setEncounter_Description(encounterDescription);
		System.out.println("Enter Encounter Chief Complaint:");
		String encounterChiefComplaint = sc.next();
		encounter.setEncounter_ChiefComplaint(encounterChiefComplaint);
		System.out.println("Enter Encounter Consult Department:");
		String encounterConsultDepartment = sc.next();
		encounter.setEncounter_consultDepartment(encounterConsultDepartment);
		System.out.println("Is Encounter Serious? (true/false):");
		boolean encounterIsSerious = sc.nextBoolean();
		encounter.setEncounter_isSerious(encounterIsSerious);
//		Person person = PersonHelper.getPerson();
//		encounter.setPerson(person);
		List<MedOrders> medOrders = new ArrayList<MedOrders>();
		encounter.setMedOrders(medOrders);
		return encounter;
	}
	
	public static Encounter updateEncounter(int encounter_id) {
		Encounter encounter = null;
		if (encounter_id > 0) {
			encounter = EntityFactoryHelp.entityManager.find(Encounter.class,encounter_id);
			if (encounter!=null) {
				System.out.println("welcome to update method :) ");
				while (true) {
					System.out.println("enter 1 for update Encounter Description ");
					System.out.println("enter 2 for update Encounter Chief Complaint ");
					System.out.println("enter 3 for update Encounter Consult Department ");
					System.out.println("enter 4 for update Encounter Serious? (true/false)");
					System.out.println("enter 5 for exit ");
					System.out.println("enter the choices :");
					int key = sc.nextInt();
					switch (key) {
					case 1: {
						System.out.println("enter the  Encounter Description to be update ");
						String name = sc.next();
						encounter.setEncounter_Description(name);
						break;
					}
					case 2: {
						System.out.println("enter the Encounter Chief Complaint to be update ");
						String name = sc.next();
						encounter.setEncounter_ChiefComplaint(name);
						break;
					}
					case 3: {
						System.out.println("enter the  Encounter Consult Department to be update ");
						String doctors=sc.next();
						encounter.setEncounter_consultDepartment(doctors);
						break;
					}
					case 4: {
						System.out.println("enter the  update Encounter Serious? (true/false) to be update ");
						boolean doctors=sc.nextBoolean();
						encounter.setEncounter_isSerious(doctors);
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
				HospitalAppFactory.getEncounterDao().updateEncounter(encounter_id, encounter);
			}
		}
		return encounter;
	}
}
