package com.rishabh.eureka.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Packages")
public class Packages {
	
	@Id
	 private String id;
	private String image;
	private String packageName;
	private String packageDesc;
	private int price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getPackageDesc() {
		return packageDesc;
	}
	public void setPackageDesc(String packageDesc) {
		this.packageDesc = packageDesc;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Packages(String id, String image, String packageName, String packageDesc, int price) {
		super();
		this.id = id;
		this.image = image;
		this.packageName = packageName;
		this.packageDesc = packageDesc;
		this.price = price;
	}
	
	
	

}
