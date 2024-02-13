package com.ty.hospital_app.entityFactoryHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.ty.hospital_entity.Encounter;
import com.ty.hospital_entity.Person;

public class PersonHelper {
	static Scanner sc = new Scanner(System.in);

	public static Person getPerson() {
		Person person = new Person();
		System.out.println("Enter Person Name:");
		String personName = sc.next();
		person.setPerson_Name(personName);
		System.out.println("Enter Person Age:");
		int personAge = sc.nextInt();
		person.setPerson_Age(personAge);
		System.out.println("Enter Person Blood Group:");
		String personBloodGroup = sc.next();
		person.setPerson_BloodGroup(personBloodGroup);
		System.out.println("Enter Person Email:");
		String personEmail = sc.next();
		person.setPerson_email(personEmail);
		System.out.println("Enter Person Phone Number:");
		long personPhoneNumber = sc.nextLong();
		person.setPerson_phoneNumber(personPhoneNumber);
		System.out.println("Enter Person Address:");
		String personAddress = sc.next();
		person.setPerson_Address(personAddress);
		List<Encounter> encounters = new ArrayList<Encounter>();
		person.setEncounters(encounters);
		return person;
	}

	public static Person updatePerson(int person_id, int encounter_Id) {
		Person person = null;
		if (person_id > 0) {
			person = EntityFactoryHelp.entityManager.find(Person.class, person_id);
			List<Encounter> encounters = person.getEncounters();
			for (Encounter encounter : encounters) {
				if (encounter.getEncounter_Id() == encounter_Id) {
					System.out.println("welcome to update method :) ");
					while (true) {
						System.out.println("enter 1 for update Person_Name ");
						System.out.println("enter 2 for update Person age ");
						System.out.println("enter 3 for update Blood group ");
						System.out.println("enter 4 for update email_id ");
						System.out.println("enter 5 for update phone number");
						System.out.println("enter 6 for update Address");
						System.out.println("enter 7 for exit ");
						System.out.println("enter the choices :");
						int key = sc.nextInt();
						switch (key) {
						case 1: {
							System.out.println("enter the person_Name to be update ");
							String name = sc.next();
							person.setPerson_Name(name);
							break;
						}
						case 2: {
							System.out.println("enter the person_ ageto be update ");
							int name = sc.nextInt();
							person.setPerson_Age(name);
							break;

						}
						case 3: {
							System.out.println("enter the person blood group to be update ");
							String name = sc.next();
							person.setPerson_BloodGroup(name);
							break;
						}
						case 4: {
							System.out.println("enter the email_id to be update ");
							String doctors = sc.next();
							person.setPerson_email(doctors);
							break;
						}
						case 5: {
							System.out.println("enter the phone number to be update ");
							long doctors = sc.nextLong();
							person.setPerson_phoneNumber(doctors);
							break;
						}
						case 6: {
							System.out.println("enter the Address to be update ");
							String doctors = sc.next();
							person.setPerson_email(doctors);
							break;
						}
						case 7:{
							break;
						}
						default: {
							System.out.println("entered choice is incorrect");
							break;
						}
						}
						if (key == 7) {
							break;
						}
					}
					HospitalAppFactory.getPersonDao().updatePerson(person_id, person);
				}
			}
		}

		return person;
	}
}
