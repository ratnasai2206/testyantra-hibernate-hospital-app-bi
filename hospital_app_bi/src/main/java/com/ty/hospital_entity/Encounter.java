package com.ty.hospital_entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Encounter {

	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "encounter_seq_gen")
	@SequenceGenerator(name="encounter_seq_gen",initialValue = 200,allocationSize = 1,sequenceName = "encounter_sequence")
	@Column(insertable=false)
	private int encounter_Id;
	private String encounter_Description;
	private String encounter_ChiefComplaint;
	private String encounter_consultDepartment;
	private boolean encounter_isSerious;
	
	@ManyToOne
	@JoinColumn
	private Branch branch;
	@ManyToOne
	@JoinColumn
	private Person person;
	@OneToMany(cascade = CascadeType.ALL)
	private List<MedOrders> medOrders;
	public int getEncounter_Id() {
		return encounter_Id;
	}
	public void setEncounter_Id(int encounter_Id) {
		this.encounter_Id = encounter_Id;
	}
	public String getEncounter_Description() {
		return encounter_Description;
	}
	public void setEncounter_Description(String encounter_Description) {
		this.encounter_Description = encounter_Description;
	}
	public String getEncounter_ChiefComplaint() {
		return encounter_ChiefComplaint;
	}
	public void setEncounter_ChiefComplaint(String encounter_ChiefComplaint) {
		this.encounter_ChiefComplaint = encounter_ChiefComplaint;
	}
	public String getEncounter_consultDepartment() {
		return encounter_consultDepartment;
	}
	public void setEncounter_consultDepartment(String encounter_consultDepartment) {
		this.encounter_consultDepartment = encounter_consultDepartment;
	}
	public boolean isEncounter_isSerious() {
		return encounter_isSerious;
	}
	public void setEncounter_isSerious(boolean encounter_isSerious) {
		this.encounter_isSerious = encounter_isSerious;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public List<MedOrders> getMedOrders() {
		return medOrders;
	}
	public void setMedOrders(List<MedOrders> medOrders) {
		this.medOrders = medOrders;
	}
	
	
}
