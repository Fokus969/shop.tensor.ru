package com.springjpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Null;

@Entity
@Table(name = "Category")
public class Category implements Serializable {

	private static final long serialVersionUID = -4598690967892708405L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "parent_id")
	private long parent_id;

	@Column(name = "name")
	private String name;

	
	@Column(name = "folder")
	private Boolean isFolder;
	
	public Category(String name,Integer parent_id){
		this.name = name;
		this.parent_id = parent_id;
	}
	protected Category() {
	}
	
	@Override
	public String toString() {
		return String.format("Category[Name='%s', parent_id='%d']", name, parent_id);
	}
	
	public long getId() {
		return id;
	}
	public long getParent_id() {
		return parent_id;
	}
	public Boolean isFolder() {
		return isFolder;
	}
	public String getName() {
		return name;
	}
	public void setFolder(Boolean isFolder){
		this.isFolder = isFolder;
	}
	public void setName(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public void setName(String name) {
		this.name = name;
	}



}