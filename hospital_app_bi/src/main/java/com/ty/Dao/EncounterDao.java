package com.ty.Dao;

import java.util.List;


import com.ty.hospital_app.entityFactoryHelper.EntityFactoryHelp;
import com.ty.hospital_entity.Branch;
import com.ty.hospital_entity.Encounter;
import com.ty.hospital_entity.Person;

public class EncounterDao {

	// save Encounter in the Encounter database
	public Encounter saveEncounter(Encounter encounter, int branch_id, int person_id) {
		if (encounter != null && branch_id > 0 && person_id >0) {
			Person person=EntityFactoryHelp.entityManager.find(Person.class, person_id);
			Branch branch=EntityFactoryHelp.entityManager.find(Branch.class, branch_id);
			if(person!=null && branch!=null) {
				List<Encounter> encounters=branch.getEncounters();
				encounters.add(encounter);
				branch.setEncounters(encounters);
				encounter.setBranch(branch);
				List<Encounter>encounters2=person.getEncounters();
				encounters2.add(encounter);
				encounter.setPerson(person);
				person.setEncounters(encounters2);
				EntityFactoryHelp.entityTransaction.begin();
				EntityFactoryHelp.entityManager.merge(branch);
//				EntityFactoryHelp.entityManager.persist(encounter);
				EntityFactoryHelp.entityTransaction.commit();
				System.out.println("registered successfully");
			}
		}
		return encounter;
	}
	
	
	// update encounter data
	public Encounter updateEncounter(int encounter_Id,Encounter encounter) {
		if (encounter_Id==encounter.getEncounter_Id() && encounter!= null) {
			EntityFactoryHelp.entityTransaction.begin();
			EntityFactoryHelp.entityManager.merge(encounter);
			EntityFactoryHelp.entityTransaction.commit();
		}
		return encounter;
		
	}
	// find encounter from database
	public Encounter findEncounter(int encounter_Id) {
		return EntityFactoryHelp.entityManager.find(Encounter.class, encounter_Id);
	}

	// remove encounter from the database
	public boolean removeEncounter(int encounter_id) {

		if (encounter_id>0) {
			Encounter encounter = findEncounter(encounter_id);
			if(encounter!=null) {
				EntityFactoryHelp.entityTransaction.begin();
				EntityFactoryHelp.entityManager.remove(encounter);
				EntityFactoryHelp.entityTransaction.commit();
				return true;
			}
		}
		return false;
	}

}
