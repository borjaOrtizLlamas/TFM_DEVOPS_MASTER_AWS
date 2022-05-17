package com.tfm.dto;	


import java.io.Serializable;
import java.util.List;

//import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
//import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
//
//@DynamoDbBean
public class Client implements Serializable{
	
	String name; 
	String phone; 
	String surname;
	
//	@DynamoDbPartitionKey
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Override
	public String toString() {
		return "{\"name\":\"" + name + "\", \"phone\": \""+ phone+"\", \"surname\" : \""+surname+"\"}";
	}

	
	
}
