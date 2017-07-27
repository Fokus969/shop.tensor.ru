package com.springjpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;;

@Entity
@Table(name = "goods")
public class Goods implements Serializable {

	private static final long serialVersionUID = -5531649474693895542L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "notes")
	private String notes;

	@Column(name = "amount")
	private Integer amount;

	@Column(name = "price")
	private Float price;

	@Column(name = "rating")
	private Integer rating;

	@Column(name = "novelty")
	private Boolean novelty;
	
	@Column(name = "picture")
	private String picture;
	
/*	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "categoryId", nullable = false)
	private Category category;*/
	
	@Column(name = "category_id")
	private Long categoryId;

	
	protected Goods(){
	}
	
	public Goods(String name, String notes,Integer amount, Float price, Integer rating, Boolean novelty, String picture, Long categoryId){
		this.name = name;
		this.notes = notes;
		this.amount = amount;
		this.price = price;
		this.rating = rating;
		this.novelty = novelty;
		this.picture = picture;
		this.categoryId = categoryId;
	}
	
	@Override
	public String toString() {
		return String.format("Goods[id=%d, Name='%s', Amount='%s', Price='%s']", id, name, amount, price);
	}
	
	public long getId() {
		return id;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public String getName() {
		return name;
	}
	public String getNotes() {
		return notes;
	}
	
	public Float getPrice() {
		return price;
	}
	public Integer getAmount() {
		return amount;
	}
	public String getPicture(){
		return picture;
	}
	public Boolean getNovelty(){
		return novelty;
	}
	
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public void setPicture(String picture){
		this.picture = picture;
	}
	public void setNovelty(Boolean novelty){
		this.novelty=novelty;
	}
	
}
