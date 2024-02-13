package com.ty.hospital_entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable=false)
	private int hospital_Id;
	private String hospital_Name;
	private String hospital_Speciality;
	private String hospital_Location;
	@OneToMany(mappedBy = "hospital",cascade = CascadeType.ALL)
	List<Branch> branchs;
	public int getHospital_Id() {
		return hospital_Id;
	}
	public void setHospital_Id(int hospital_Id) {
		this.hospital_Id = hospital_Id;
	}
	public String getHospital_Name() {
		return hospital_Name;
	}
	public void setHospital_Name(String hospital_Name) {
		this.hospital_Name = hospital_Name;
	}
	public String getHospital_Speciality() {
		return hospital_Speciality;
	}
	public void setHospital_Speciality(String hospital_Speciality) {
		this.hospital_Speciality = hospital_Speciality;
	}
	public String getHospital_Location() {
		return hospital_Location;
	}
	public void setHospital_Location(String hospital_Location) {
		this.hospital_Location = hospital_Location;
	}
	public List<Branch> getBranchs() {
		return branchs;
	}
	public void setBranchs(List<Branch> branchs) {
		this.branchs = branchs;
	}
	
}
