package com.ty.Dao;

import com.ty.hospital_app.entityFactoryHelper.EntityFactoryHelp;
import com.ty.hospital_entity.Person;

public class PersonDao {

	
	//save person in the database
	public Person savePerson(Person person) {
		if(person!=null) {
			EntityFactoryHelp.entityTransaction.begin();
			EntityFactoryHelp.entityManager.persist(person);
			EntityFactoryHelp.entityTransaction.commit();
			System.out.println("registered successfully");
		}
		return person;
	}
	
	//search person in the database
	public Person searchPerson(int person_Id) {
	
		return EntityFactoryHelp.entityManager.find(Person.class, person_Id);
		
	}
	
	//update person from the database
	public Person updatePerson(int person_Id,Person person) {
		if(person_Id==person.getPerson_Id()&& person!=null) {
			EntityFactoryHelp.entityTransaction.begin();
			EntityFactoryHelp.entityManager.merge(person);
			EntityFactoryHelp.entityTransaction.commit();
		}
		return person;
	}
	
	// remove the person from the database
	public boolean removePerson(int person_Id) {
		if(person_Id >0) {
			Person person=searchPerson(person_Id);
			if(person!=null) {
				EntityFactoryHelp.entityTransaction().begin();
				EntityFactoryHelp.entityManager().remove(person);
				EntityFactoryHelp.entityTransaction().commit();
				return true;
			}
		}
		return false;
		
	}
	
	
}
