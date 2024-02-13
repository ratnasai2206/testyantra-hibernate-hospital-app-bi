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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class Branch {
	
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "branch_seq_gen")
	@SequenceGenerator(name="branch_seq_gen",initialValue = 100,allocationSize = 1,sequenceName = "branch_sequence")
	@Column(insertable=false)
	private int branch_Id;
	private String branch_Name;
	private int branch_No_Of_Beds;
	private int branch_No_Of_Doctors;
	private String branch_Speciality;
	@ManyToOne
	@JoinColumn
	Hospital hospital;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Address address;
	@OneToMany(mappedBy = "branch",cascade = CascadeType.ALL)
	List<Encounter> encounters;
	public int getBranch_Id() {
		return branch_Id;
	}
	public void setBranch_Id(int branch_Id) {
		this.branch_Id = branch_Id;
	}
	public String getBranch_Name() {
		return branch_Name;
	}
	public void setBranch_Name(String branch_Name) {
		this.branch_Name = branch_Name;
	}
	public int getBranch_No_Of_Beds() {
		return branch_No_Of_Beds;
	}
	public void setBranch_No_Of_Beds(int branch_No_Of_Beds) {
		this.branch_No_Of_Beds = branch_No_Of_Beds;
	}
	public int getBranch_No_Of_Doctors() {
		return branch_No_Of_Doctors;
	}
	public void setBranch_No_Of_Doctors(int branch_No_Of_Doctors) {
		this.branch_No_Of_Doctors = branch_No_Of_Doctors;
	}
	public String getBranch_Speciality() {
		return branch_Speciality;
	}
	public void setBranch_Speciality(String branch_Speciality) {
		this.branch_Speciality = branch_Speciality;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Encounter> getEncounters() {
		return encounters;
	}
	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}
	
	
}
