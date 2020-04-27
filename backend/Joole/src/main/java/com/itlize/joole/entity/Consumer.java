package com.itlize.joole.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="consumer")
public class Consumer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="consumer_id")
	private int consumerId;
	
	@Column(name="consumer_email")
	private String consumerEmail;
	
	@Column(name="consumer_username")
	private String consumerUsername;
	
	@Column(name="consumer_first")
	private String consumerFirstName;
	
	@Column(name="consumer_last")
	private String consumerLastName;
	
	@Column(name="consumer_image")
	private String consumerImage;
	
	@Column(name="consumer_password")
	private String consumerPassword;
	
	public String getConsumerImage() {
		return consumerImage;
	}

	public void setConsumerImage(String consumerImage) {
		this.consumerImage = consumerImage;
	}
	
	public Consumer() {
		
	}
    
	public int getConsumerId() {
		return consumerId;
	}

	
	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}

	public String getConsumerEmail() {
		return consumerEmail;
	}



	public void setConsumerEmail(String consumerEmail) {
		this.consumerEmail = consumerEmail;
	}



	public String getConsumerUsername() {
		return consumerUsername;
	}



	public void setConsumerUsername(String consumerUsername) {
		this.consumerUsername = consumerUsername;
	}



	public String getConsumerFirstName() {
		return consumerFirstName;
	}



	public void setConsumerFirstName(String consumerFirstName) {
		this.consumerFirstName = consumerFirstName;
	}



	public String getConsumerLastName() {
		return consumerLastName;
	}



	public void setConsumerLastName(String consumerLastName) {
		this.consumerLastName = consumerLastName;
	}



	public String getConsumerPassword() {
		return consumerPassword;
	}



	public void setConsumerPassword(String consumerPassword) {
		this.consumerPassword = consumerPassword;
	}
	
	@Override
	public String toString() {
		return "Consumer [id=" + consumerId + 
				", username=" + consumerUsername +
				", email=" + consumerEmail + 
				", firstName=" + consumerFirstName +
				", lastName=" + consumerLastName + "]";
	}

}

