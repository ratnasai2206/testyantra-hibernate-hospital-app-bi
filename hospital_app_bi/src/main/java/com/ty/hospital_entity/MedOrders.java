package com.ty.hospital_entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class MedOrders {

	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE,generator = "medorders_seq_gen")
	@SequenceGenerator(name="medorders_seq_gen",initialValue = 400,allocationSize = 1,sequenceName = "medorders_sequence")
	@Column(insertable=false)
	private int medOrder_Id;
	private String medOrder_MedicationType;
	private int medOrder_Dosage;
	private String medOrder_PresecribingDoctor;
	private boolean medOrder_IsCompleted;
	@ManyToOne
	@JoinColumn
	private Encounter encounter;
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn,inverseJoinColumns = @JoinColumn)
	private List<Item> items;
	public int getMedOrder_Id() {
		return medOrder_Id;
	}
	public void setMedOrder_Id(int medOrder_Id) {
		this.medOrder_Id = medOrder_Id;
	}
	public String getMedOrder_MedicationType() {
		return medOrder_MedicationType;
	}
	public void setMedOrder_MedicationType(String medOrder_MedicationType) {
		this.medOrder_MedicationType = medOrder_MedicationType;
	}
	public int getMedOrder_Dosage() {
		return medOrder_Dosage;
	}
	public void setMedOrder_Dosage(int medOrder_Dosage) {
		this.medOrder_Dosage = medOrder_Dosage;
	}
	public String getMedOrder_PresecribingDoctor() {
		return medOrder_PresecribingDoctor;
	}
	public void setMedOrder_PresecribingDoctor(String medOrder_PresecribingDoctor) {
		this.medOrder_PresecribingDoctor = medOrder_PresecribingDoctor;
	}
	public boolean isMedOrder_IsCompleted() {
		return medOrder_IsCompleted;
	}
	public void setMedOrder_IsCompleted(boolean medOrder_IsCompleted) {
		this.medOrder_IsCompleted = medOrder_IsCompleted;
	}
	public Encounter getEncounter() {
		return encounter;
	}
	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	
}
