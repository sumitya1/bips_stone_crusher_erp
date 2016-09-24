package com.bips.inventory.beans;

public class InventoryFetchBean {
	private String item_name= null;
	private String rent_rate= null;
	private String rent_type= null;
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getRent_rate() {
		return rent_rate;
	}
	public void setRent_rate(String rent_rate) {
		this.rent_rate = rent_rate;
	}
	public String getRent_type() {
		return rent_type;
	}
	public void setRent_type(String rent_type) {
		this.rent_type = rent_type;
	}
	

}