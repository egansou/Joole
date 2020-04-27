package com.itlize.joole.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="representative")
public class Representative {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rep_id")
	private int repId;
	
	@Column(name="rep_name")
	private String repName;
	
	@Column(name="rep_phone")
	private String repPhone;
	
	@Column(name="rep_email")
	private String repEmail;
	
	@Column(name="rep_web")
	private String repWeb;
	
	public Representative() {
		
	}
	
	public int getRepId() {
		return repId;
	}

	public void setRepId(int repId) {
		this.repId = repId;
	}

	public String getRepName() {
		return repName;
	}

	public void setRepName(String repName) {
		this.repName = repName;
	}

	public String getRepPhone() {
		return repPhone;
	}

	public void setRepPhone(String repPhone) {
		this.repPhone = repPhone;
	}

	public String getRepEmail() {
		return repEmail;
	}

	public void setRepEmail(String repEmail) {
		this.repEmail = repEmail;
	}
	
	public String getRepWeb() {
		return repWeb;
	}
	
	public void setRepWeb(String repWeb) {
		this.repWeb = repWeb;
	}	
	
	@Override
	public String toString() {
		return "Representative [id=" + repId + 
				", name=" + repName +
				", phone=" + repPhone +
				", email=" + repEmail +
				", Web=" + repWeb +
				 "]";
	}
	
}

