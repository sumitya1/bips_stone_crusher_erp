package com.bips.inventory.beans;

public class PersonBeanModel {
 private String name= null;
 private String email= null;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
 
 public void doSomething(){
	 setName("["+getName()+"]");
	 setEmail("["+getEmail()+"]");
 }
}
