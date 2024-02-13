package com.ty.hospital_entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "item_seq_gen")
	@SequenceGenerator(name="item_seq_gen",initialValue = 300,allocationSize = 1,sequenceName = "item_sequence")
	@Column(insertable=false)
	private int item_Id;
	private String item_Name;
	private double item_Price;
	private String item_Manufacturer;
	private String item_description;
	private int item_quantity;
	private boolean isAvailable;
	@ManyToMany(mappedBy = "items")
	List<MedOrders> medOrders;
	public int getItem_Id() {
		return item_Id;
	}
	public void setItem_Id(int item_Id) {
		this.item_Id = item_Id;
	}
	public String getItem_Name() {
		return item_Name;
	}
	public void setItem_Name(String item_Name) {
		this.item_Name = item_Name;
	}
	public double getItem_Price() {
		return item_Price;
	}
	public void setItem_Price(double item_Price) {
		this.item_Price = item_Price;
	}
	public String getItem_Manufacturer() {
		return item_Manufacturer;
	}
	public void setItem_Manufacturer(String item_Manufacturer) {
		this.item_Manufacturer = item_Manufacturer;
	}
	public String getItem_description() {
		return item_description;
	}
	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}
	public int getItem_quantity() {
		return item_quantity;
	}
	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public List<MedOrders> getMedOrders() {
		return medOrders;
	}
	public void setMedOrders(List<MedOrders> medOrders) {
		this.medOrders = medOrders;
	}
	
}
