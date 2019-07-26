package com.accenture.mservice.bean;


//@XmlRootElement
public class Customer {
	private String customerName;
	private Integer customerId;
	private double customerBill;
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String customerName, Integer customerId, double customerBill) {
		super();
		this.customerName = customerName;
		this.customerId = customerId;
		this.customerBill = customerBill;
		
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public double getCustomerBill() {
		return customerBill;
	}

	public void setCustomerBill(double customerBill) {
		this.customerBill = customerBill;
	}

	

	@Override
	public String toString() {
		return "customer [customerName=" + customerName + ", customerId="
				+ customerId + ", customerBill=" + customerBill + "]";
	}

}
