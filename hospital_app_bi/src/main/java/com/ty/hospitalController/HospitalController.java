package com.ty.hospitalController;


import com.ty.hospital_app.entityFactoryHelper.BranchHelper;
import com.ty.hospital_app.entityFactoryHelper.EncounterHelper;
import com.ty.hospital_app.entityFactoryHelper.HospitalAppFactory;
import com.ty.hospital_app.entityFactoryHelper.HospitalHelper;
import com.ty.hospital_app.entityFactoryHelper.MedOrdersHelper;
import com.ty.hospital_app.entityFactoryHelper.PersonHelper;
import com.ty.hospital_entity.Branch;
import com.ty.hospital_entity.Encounter;
import com.ty.hospital_entity.Hospital;
import com.ty.hospital_entity.MedOrders;
import com.ty.hospital_entity.Person;

public class HospitalController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Hospital application.......:)");
		while (true) {
			int key = HospitalControllerHelper.getChoice();
			switch (key) {
			case 1: {
				System.out.println("welcome to save opertion");
				while(true) {
					int choice=HospitalControllerHelper.getSaveChoice();
					switch (choice) {
					case 1:{
						HospitalAppFactory.getHospitalDao().saveHospital(HospitalHelper.getHospital());
						break;
					}
					case 2:{
						HospitalAppFactory.getBranchDao().saveBranch(BranchHelper.getBranch(),HospitalControllerHelper.getId("Hospital") );
						break;
					}
					case 3:{
						HospitalAppFactory.getPersonDao().savePerson(PersonHelper.getPerson());
						break;
					}
					case 4:{
						HospitalAppFactory.getEncounterDao().saveEncounter(EncounterHelper.getEncounter(),HospitalControllerHelper.getId("Branch") , HospitalControllerHelper.getId("Person"));
						break;
					}
					case 5:{
						HospitalAppFactory.getMedOrderDao().saveMedOrders(MedOrdersHelper.getMedOrder(), HospitalControllerHelper.getId("Encounter"));
						break;
					}
					case 6:{
						break;
					}
					default:{
						System.out.println("enter the correct input/choices");
					}
					}
					if(choice==6) {
						break;
					}
				}
				break;
			}
			case 2: {
				System.out.println("welcome to find opertion");
				while(true) {
					int choice=HospitalControllerHelper.getFindChoice();
					switch (choice) {
					case 1:{
						Hospital hospital=HospitalAppFactory.getHospitalDao().searchHospital(HospitalControllerHelper.getId("Hospital"));
						HospitalControllerHelper.printObject(hospital);
						break;
					}
					case 2:{
						Branch branch=HospitalAppFactory.getBranchDao().searchBranch(HospitalControllerHelper.getId("Branch"));
						HospitalControllerHelper.printObject(branch);
						break;
					}
					case 3:{
						Person person=HospitalAppFactory.getPersonDao().searchPerson(HospitalControllerHelper.getId("Person"));
						HospitalControllerHelper.printPerson(person);
						break;
					}
					case 4:{
						Encounter encounter =HospitalAppFactory.getEncounterDao().findEncounter(HospitalControllerHelper.getId("Encounter"));
						HospitalControllerHelper.printEncounter(encounter);
						break;
					}
					case 5:{
						MedOrders medOrders=HospitalAppFactory.getMedOrderDao().findOrder(HospitalControllerHelper.getId("MedOrder"));
						HospitalControllerHelper.printMedOrders(medOrders);
						break;
					}
					case 6:{
						break;
					}
					default:{
						System.out.println("enter the correct input/choices");
					}
					}
					if(choice==6) {
						break;
					}
				}
				break;
			}
			case 3: {
				System.out.println("welcome to update opertion");
				while(true) {
					int choice=HospitalControllerHelper.getUpdateChoice();
					switch (choice) {
					case 1:{
						Hospital hospital=HospitalHelper.updateHospital(HospitalControllerHelper.getId("Hospital"));
						HospitalControllerHelper.printObject(hospital);
						break;
					}
					case 2:{
						Branch branch=BranchHelper.updateBranch(HospitalControllerHelper.getId("Branch"),HospitalControllerHelper.getId("Hospital"));
						HospitalControllerHelper.printObject(branch);
						break;
					}
					case 3:{
						Person person=PersonHelper.updatePerson(HospitalControllerHelper.getId("Person"), HospitalControllerHelper.getId("Encounter"));
						HospitalControllerHelper.printPerson(person);
						break;
					}
					case 4:{
						Encounter encounter =EncounterHelper.updateEncounter(HospitalControllerHelper.getId("Encounter"));
						HospitalControllerHelper.printEncounter(encounter);
						break;
					}
					case 5:{
						MedOrders medOrders=MedOrdersHelper.updateMedOrders(HospitalControllerHelper.getId("MedOrder"));
						HospitalControllerHelper.printMedOrders(medOrders);
						break;
					}
					case 6:{
						break;
					}
					default:{
						System.out.println("enter the correct input/choices");
					}
					}
					if(choice==6) {
						break;
					}
				}
				break;
			}
			case 4: {
				System.out.println("welcome to remove opertion");
				while(true) {
					int choice=HospitalControllerHelper.getRemoveChoice();
					switch (choice) {
					case 1:{
						boolean hospital=HospitalAppFactory.getHospitalDao().removeHospital(HospitalControllerHelper.getId("Hospital"));
						HospitalControllerHelper.printObjectBoolean(hospital);
						break;
					}
					case 2:{
						boolean branch=HospitalAppFactory.getBranchDao().removeBranch(HospitalControllerHelper.getId("Branch"));
						HospitalControllerHelper.printObjectBoolean(branch);
						break;
					}
					case 3:{
						boolean person=HospitalAppFactory.getPersonDao().removePerson(HospitalControllerHelper.getId("Person"));
						HospitalControllerHelper.printObjectBoolean(person);
						break;
					}
					case 4:{
						boolean encounter =HospitalAppFactory.getEncounterDao().removeEncounter(HospitalControllerHelper.getId("Encounter"));
						HospitalControllerHelper.printObjectBoolean(encounter);
						break;
					}
					case 5:{
						boolean medOrders=HospitalAppFactory.getMedOrderDao().removeMedOrder(HospitalControllerHelper.getId("MedOrder"));
						HospitalControllerHelper.printObjectBoolean(medOrders);
						break;
					}
					case 6:{
						boolean items=HospitalAppFactory.getItemDao().removeItem(HospitalControllerHelper.getId("Item"));
						HospitalControllerHelper.printObjectBoolean(items);
						break;
					}
					case 7:{
						break;
					}
					default:{
						System.out.println("enter the correct input/choices");
					}
					}
					if(choice==7) {
						break;
					}
				}
				break;
			}
			case 5: {
				System.out.println(" Thank you and vist again.....:)");
				return;
			}

			default:
				System.out.println("enter the correct input/choices");
			}
		}

	}

}
