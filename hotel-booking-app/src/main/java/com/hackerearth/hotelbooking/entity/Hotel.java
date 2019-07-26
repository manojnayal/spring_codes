package com.hackerearth.hotelbooking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel {
	
	@Id
	private long hotel_id;
	private String address;
	private String categories;
	private String city;
	private String country;
	private String latitude;
	private String longitude;
	private String name;
	/*@Column(name="postalCode")
	private String postalCode;*/
	private String province;
	@Column(name="reviews_rating")
	private String reviews_rating;
	@Column(name="reviews_text")
	private String reviews_text;
	@Column(name="reviews_title")
	private String reviews_title;
	@Column(name="reviews_username")
	private String reviews_username;
	
	public long getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(long hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}*/

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getReviews_rating() {
		return reviews_rating;
	}

	public void setReviews_rating(String reviews_rating) {
		this.reviews_rating = reviews_rating;
	}

	public String getReviews_text() {
		return reviews_text;
	}

	public void setReviews_text(String reviews_text) {
		this.reviews_text = reviews_text;
	}

	public String getReviews_title() {
		return reviews_title;
	}

	public void setReviews_title(String reviews_title) {
		this.reviews_title = reviews_title;
	}

	public String getReviews_username() {
		return reviews_username;
	}

	public void setReviews_username(String reviews_username) {
		this.reviews_username = reviews_username;
	}

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hotel(long hotel_id, String address, String categories, String city, String country, String latitude,
			String longitude, String name, String province, String reviews_rating, String reviews_text,
			String reviews_title, String reviews_username) {
		super();
		this.hotel_id = hotel_id;
		this.address = address;
		this.categories = categories;
		this.city = city;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
		//this.postalCode = postalCode;
		this.province = province;
		this.reviews_rating = reviews_rating;
		this.reviews_text = reviews_text;
		this.reviews_title = reviews_title;
		this.reviews_username = reviews_username;
	}
}

