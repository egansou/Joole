package com.itlize.joole.entity;

import javax.persistence.Column;  

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="manufacturer")
public class Manufacturer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="manuf_id")
	private int manufId;
	
	@Column(name="manuf_name")
	private String manufName;
	
	@Column(name="manuf_phone")
	private String manufPhone;
	
	@Column(name="manuf_email")
	private String manufEmail;
	
	@Column(name="manuf_dep")
	private String manufDep;
	
	@Column(name="manuf_web")
	private String manufWeb;
	
	@JoinColumn (name="rep_id")
	@OneToOne (fetch=FetchType.EAGER)
	private Representative representative;
	
	public Manufacturer() {
		
	}

	public int getManufId() {
		return manufId;
	}

	public void setManufId(int manufId) {
		this.manufId = manufId;
	}
	
	public String getManufName() {
		return manufName;
	}



	public void setManufName(String manufName) {
		this.manufName = manufName;
	}
	
	public String getManufPhone() {
		return manufPhone;
	}

	public void setManufPhone(String manufPhone) {
		this.manufPhone = manufPhone;
	}

	public String getManufEmail() {
		return manufEmail;
	}

	public void setManufEmail(String manufEmail) {
		this.manufEmail = manufEmail;
	}

	public String getManufDep() {
		return manufDep;
	}
	
	public void setManufDep(String manufDep) {
		this.manufDep = manufDep;
	}

	public String getManufWeb() {
		return manufWeb;
	}

	public void setManufWeb(String manufWeb) {
		this.manufWeb = manufWeb;
	}

	public Representative getRepresentative() {
		return representative;
	}

	public void setRepresentative(Representative rep) {
		this.representative = rep;
	}
	
	@Override
	public String toString() {
		return "Manufacturer [id=" + manufId + 
				", name=" + manufName +
				", phone=" + manufPhone +
				", email=" + manufEmail +
				", dep=" + manufDep +
				", web=" + manufWeb +
				", " + representative.toString() + "]";
	}

}

