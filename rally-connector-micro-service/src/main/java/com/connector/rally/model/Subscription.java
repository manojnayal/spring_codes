package com.connector.rally.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Subscription_Details")
public class Subscription {
	@JsonProperty(value="ObjectID")
	@Column(name="ObjectID")
	private String objectId;
	@JsonProperty(value="ObjectUUID")
	@Id
	@Column(name="ObjectUUID")
	private String objectUUId;
	@JsonProperty(value="ObjectUUID")
	@Column(name="Name")
	 private String name ;
	@JsonProperty(value="VersionId")
	@Column(name="VersionId")
	 private String versionId ;
	@JsonProperty(value="Modules")
	@Column(name="Modules")
	 private String modules ;
	@JsonProperty(value="StoryHierarchyEnabled")
	@Column(name="StoryHierarchyEnabled")
	 private String storyHierarchyEnabled ;
	@JsonProperty(value="StoryHierarchyType")
	@Column(name="StoryHierarchyType")
	 private String storyHierarchyType ;
	@JsonProperty(value="SubscriptionID")
	@Column(name="SubscriptionID")
	 private String subscriptionID ;
	@JsonProperty(value="SubscriptionType")
	@Column(name="SubscriptionType")
	 private String subscriptionType ;
	@JsonProperty(value="WebhooksEnabled")
	@Column(name="WebhooksEnabled")
	 private String webhooksEnabled ;
	@JsonProperty(value="ZuulID")
	@Column(name="ZuulID")
	 private String zuulID ;
	@JsonProperty(value="ApiKeysEnabled")
	@Column(name="ApiKeysEnabled")
	 private String apiKeysEnabled ;
	@JsonProperty(value="CORSEnabled")
	@Column(name="CORSEnabled")
	 private String corsEnabled ;
	@JsonProperty(value="EmailEnabled")
	@Column(name="EmailEnabled")
	 private String emailEnabled ;
	@JsonProperty(value="ExpirationDate")
	@Column(name="ExpirationDate")
	 private String expirationDate ;
	@JsonProperty(value="JSONPEnabled")
	@Column(name="JSONPEnabled")
	 private String jsonpEnabled ;
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public String getObjectUUId() {
		return objectUUId;
	}
	public void setObjectUUId(String objectUUId) {
		this.objectUUId = objectUUId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersionId() {
		return versionId;
	}
	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}
	public String getModules() {
		return modules;
	}
	public void setModules(String modules) {
		this.modules = modules;
	}
	public String getStoryHierarchyEnabled() {
		return storyHierarchyEnabled;
	}
	public void setStoryHierarchyEnabled(String storyHierarchyEnabled) {
		this.storyHierarchyEnabled = storyHierarchyEnabled;
	}
	public String getStoryHierarchyType() {
		return storyHierarchyType;
	}
	public void setStoryHierarchyType(String storyHierarchyType) {
		this.storyHierarchyType = storyHierarchyType;
	}
	public String getSubscriptionID() {
		return subscriptionID;
	}
	public void setSubscriptionID(String subscriptionID) {
		this.subscriptionID = subscriptionID;
	}
	public String getSubscriptionType() {
		return subscriptionType;
	}
	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}
	public String getWebhooksEnabled() {
		return webhooksEnabled;
	}
	public void setWebhooksEnabled(String webhooksEnabled) {
		this.webhooksEnabled = webhooksEnabled;
	}
	public String getZuulID() {
		return zuulID;
	}
	public void setZuulID(String zuulID) {
		this.zuulID = zuulID;
	}
	public String getApiKeysEnabled() {
		return apiKeysEnabled;
	}
	public void setApiKeysEnabled(String apiKeysEnabled) {
		this.apiKeysEnabled = apiKeysEnabled;
	}
	public String getCorsEnabled() {
		return corsEnabled;
	}
	public void setCorsEnabled(String corsEnabled) {
		this.corsEnabled = corsEnabled;
	}
	public String getEmailEnabled() {
		return emailEnabled;
	}
	public void setEmailEnabled(String emailEnabled) {
		this.emailEnabled = emailEnabled;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getJsonpEnabled() {
		return jsonpEnabled;
	}
	public void setJsonpEnabled(String jsonpEnabled) {
		this.jsonpEnabled = jsonpEnabled;
	}
	public Subscription() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subscription(String objectId, String objectUUId, String name, String versionId, String modules,
			String storyHierarchyEnabled, String storyHierarchyType, String subscriptionID, String subscriptionType,
			String webhooksEnabled, String zuulID, String apiKeysEnabled, String corsEnabled, String emailEnabled,
			String expirationDate, String jsonpEnabled) {
		super();
		this.objectId = objectId;
		this.objectUUId = objectUUId;
		this.name = name;
		this.versionId = versionId;
		this.modules = modules;
		this.storyHierarchyEnabled = storyHierarchyEnabled;
		this.storyHierarchyType = storyHierarchyType;
		this.subscriptionID = subscriptionID;
		this.subscriptionType = subscriptionType;
		this.webhooksEnabled = webhooksEnabled;
		this.zuulID = zuulID;
		this.apiKeysEnabled = apiKeysEnabled;
		this.corsEnabled = corsEnabled;
		this.emailEnabled = emailEnabled;
		this.expirationDate = expirationDate;
		this.jsonpEnabled = jsonpEnabled;
	}
}
