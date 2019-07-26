package com.connector.rally.model;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubscriptionBean {
	@Autowired
	@JsonProperty(value="Subscription")
	private Subscription subscription;

	public SubscriptionBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubscriptionBean(Subscription subscription) {
		super();
		this.subscription = subscription;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	

}
