package com.itlize.joole.entity;

import javax.persistence.Column; 

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="prodtype")
public class Type {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="type_id")
	private int typeId;
	
	@Column(name="type_name")
	private String typeName;
	
	@JoinColumn (name="category_id")
	@ManyToOne (fetch=FetchType.EAGER)
	private Category category;
	
	public Type() {
		
	}

	public int getTypeId() {
		return typeId;
	}
	
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	
	public String getTypeName() {
		return typeName;
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Product Category [id=" + typeId + 
				", name=" + typeName +
				", " + category.toString() + "]";
	}

}

