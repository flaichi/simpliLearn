package com.fl.model;

public class Support {
	int sId;
	String sName;
	String sEmail;
	String sCountry;
	
	public Support() {}
	
	

	public Support(int sId, String sName, String sEmail, String sCountry) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sEmail = sEmail;
		this.sCountry = sCountry;
	}
	public Support(String sName, String sEmail, String sCountry) {
		super();
		this.sName = sName;
		this.sEmail = sEmail;
		this.sCountry = sCountry;
	}



	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public String getsCountry() {
		return sCountry;
	}
	public void setsCountry(String sCountry) {
		this.sCountry = sCountry;
	}
	@Override
	public String toString() {
		return "Support [sId=" + sId + ", sName=" + sName + ", sEmail=" + sEmail + ", sCountry=" + sCountry + "]";
	}
}
