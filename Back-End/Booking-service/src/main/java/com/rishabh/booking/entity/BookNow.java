package com.rishabh.booking.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BookNow")
public class BookNow {
	
	
	   @Id
	    private String id;
	    private String username;
	    private String packageName;
		private String packageDesc;
		private int price;
		private String imageUrl;
		private String washerName;
		private String status;
		private boolean isCancelled;
		private List<String> isWasherCancelled;
		private String firstName;
	    private String lastName;
	    private String email;
	    private String  contactNo;
	    private String address1;
	    private String address2;
	    private String city;
	    private String state;
	    private String zip;
	    private String carNo;
	    private String date;
		private Binary image;
		private Binary washedCarImage;
		@Transient
		private String imageString;
		@Transient
		private String washedImageString;
		
		
		
		
		public String getWashedImageString() {
			return washedImageString;
		}
		public void setWashedImageString(String washedImageString) {
			this.washedImageString = washedImageString;
		}
		public Binary getWashedCarImage() {
			return washedCarImage;
		}
		public void setWashedCarImage(Binary washedCarImage) {
			this.washedCarImage = washedCarImage;
		}
		public String getImageString() {
			return imageString;
		}
		public void setImageString(String imageString) {
			this.imageString = imageString;
		}
		public List<String> getIsWasherCancelled() {
			return isWasherCancelled;
		}
		public void setIsWasherCancelled(List<String> isWasherCancelled) {
			this.isWasherCancelled = isWasherCancelled;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public boolean isCancelled() {
			return isCancelled;
		}
		public void setCancelled(boolean isCancelled) {
			this.isCancelled = isCancelled;
		}
		
		public String getImageUrl() {
			return imageUrl;
		}
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		public String getWasherName() {
			return washerName;
		}
		public void setWasherName(String washerName) {
			this.washerName = washerName;
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
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		
		public void setContactNo(String contactNo) {
			this.contactNo = contactNo;
		}
		public String getContactNo()
		{
			return contactNo;
		}
		
		
		 public void setDate(String date) {
				this.date = date;
			}
		public String getDate()
		{
			return date;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		/*
		 * public String getTitle() { return title; }
		 * 
		 * public void setTitle(String title) { this.title = title; }
		 */
		

		public Binary getImage() {
			return image;
		}

		public BookNow(String username,String firstName, String lastName, String email, String contactNo, String address1, String address2,
				String city, String state, String zip, String carNo, String date, String packageName, String packageDesc,int price,String imageUrl,String washerName,
				String status,boolean isCancelled, List<String> isWasherCancelled) {
			super();
			this.status=status;
			this.isCancelled=isCancelled;
			this.isWasherCancelled=isWasherCancelled;
			this.packageName=packageName;
			this.packageDesc=packageDesc;
			this.price=price;
			this.imageUrl=imageUrl;
			this.washerName=washerName;
			this.username=username;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.contactNo = contactNo;
			this.address1 = address1;
			this.address2 = address2;
			this.city = city;
			this.state = state;
			this.zip = zip;
			this.carNo = carNo;
			this.date = date;
		}
		
		

		public BookNow(String id, String username, String firstName, String lastName, String email, String contactNo,
				String address1, String address2, String city, String state, String zip, String carNo, String date,
				Binary image) {
			super();
			this.id = id;
			this.username = username;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.contactNo = contactNo;
			this.address1 = address1;
			this.address2 = address2;
			this.city = city;
			this.state = state;
			this.zip = zip;
			this.carNo = carNo;
			this.date = date;
			this.image = image;
		}
		public BookNow(String firstName, String lastName, String email, String contactNo, String address1, String address2,
				String city, String state, String zip, String carNo) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.contactNo = contactNo;
			this.address1 = address1;
			this.address2 = address2;
			this.city = city;
			this.state = state;
			this.zip = zip;
			this.carNo = carNo;
		}

		
		

		public BookNow(String id, String firstName, String lastName, String email, String contactNo, String address1,
				String address2, String city, String state, String zip, String carNo, String date, Binary image) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.contactNo = contactNo;
			this.address1 = address1;
			this.address2 = address2;
			this.city = city;
			this.state = state;
			this.zip = zip;
			this.carNo = carNo;
			this.date = date;
			this.image = image;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAddress1() {
			return address1;
		}

		public void setAddress1(String address1) {
			this.address1 = address1;
		}

		public String getAddress2() {
			return address2;
		}

		public void setAddress2(String address2) {
			this.address2 = address2;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getZip() {
			return zip;
		}

		public void setZip(String zip) {
			this.zip = zip;
		}

		public String getCarNo() {
			return carNo;
		}

		public void setCarNo(String carNo) {
			this.carNo = carNo;
		}

	

		public void setImage(Binary image) {
			this.image = image;
		}

		/*
		 * public BookNow(String id, String title, Binary image) { super(); this.id =
		 * id; this.title = title; this.image = image; }
		 */

		/*
		 * public BookNow(String title) { super(); this.title = title; }
		 */

		public BookNow() {
			super();
		}
	    
	    

}
