package com.ty.hospital_entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "address_seq_gen")
	@SequenceGenerator(name="address_seq_gen",initialValue = 1000,allocationSize = 1,sequenceName = "address_sequence")
	@Column(insertable=false)
	private int Address_Id;
	private String Address_StreetName;
	private String Address_CityName;
	private String Address_DistrictName;
	private String Address_StateName;
	private int Address_PinCode;
	@OneToOne(mappedBy = "address")
	private Branch branch;
	public int getAddress_Id() {
		return Address_Id;
	}
	public void setAddress_Id(int address_Id) {
		Address_Id = address_Id;
	}
	public String getAddress_StreetName() {
		return Address_StreetName;
	}
	public void setAddress_StreetName(String address_StreetName) {
		Address_StreetName = address_StreetName;
	}
	public String getAddress_CityName() {
		return Address_CityName;
	}
	public void setAddress_CityName(String address_CityName) {
		Address_CityName = address_CityName;
	}
	public String getAddress_DistrictName() {
		return Address_DistrictName;
	}
	public void setAddress_DistrictName(String address_DistrictName) {
		Address_DistrictName = address_DistrictName;
	}
	public String getAddress_StateName() {
		return Address_StateName;
	}
	public void setAddress_StateName(String address_StateName) {
		Address_StateName = address_StateName;
	}
	public int getAddress_PinCode() {
		return Address_PinCode;
	}
	public void setAddress_PinCode(int address_PinCode) {
		Address_PinCode = address_PinCode;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	
}
