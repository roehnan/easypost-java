package com.easypost.model;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import com.easypost.exception.EasyPostException;
import com.easypost.net.EasyPostResource;

public class Address extends EasyPostResource {
	public String id;
	String name;
	String company;
	String street1;
	String street2;
	String zip;
	String city;
	String state;
	String country;
	String phone;
	String email;
	String message;
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
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
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	// create
	public static Address create(Map<String, Object> params) throws EasyPostException {
		return create(params, null);
	}
	public static Address create(Map<String, Object> params, String apiKey) throws EasyPostException {
		Map<String, Object> wrappedParams = new HashMap<String, Object>();
		wrappedParams.put("address", params);
		
		return request(RequestMethod.POST, classURL(Address.class), wrappedParams, Address.class, apiKey);
	}

	// retrieve
	public static Address retrieve(String id) throws EasyPostException {
		return retrieve(id, null);
	}
	public static Address retrieve(String id, String apiKey) throws EasyPostException {
		return request(RequestMethod.GET, instanceURL(Address.class, id), null, Address.class, apiKey);
	}

	// all
	public static AddressCollection all(Map<String, Object> params) throws EasyPostException {
		return all(params, null);
	}
	public static AddressCollection all(Map<String, Object> params, String apiKey) throws EasyPostException {
		return request(RequestMethod.GET, classURL(Address.class), params, AddressCollection.class, apiKey);
	}

	// verify
	public Address verify() throws EasyPostException {
		return this.verify(null);
	}
	public Address verify(String apiKey) throws EasyPostException {
		AddressVerifyResponse response;
		response = request(RequestMethod.GET, String.format("%s/verify", instanceURL(Address.class, this.getId())), null, AddressVerifyResponse.class, apiKey);
        
        if (response.message != null) {
        	response.address.message = response.message;
        }
        // System.out.println(response.address);	
        return response.address;
	}

}