package com.bips.inventory.beans;

public class InventorySetBean {
	private String item_name= null;
	private String item_type= null;
	private String owner_name= null;
	private String rent_type=null;
	private String rent_rate= null;
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_type() {
		return item_type;
	}
	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getRent_type() {
		return rent_type;
	}
	public void setRent_type(String rent_type) {
		this.rent_type = rent_type;
	}
	public String getRent_rate() {
		return rent_rate;
	}
	public void setRent_rate(String rent_rate) {
		this.rent_rate = rent_rate;
	}
	


	
}