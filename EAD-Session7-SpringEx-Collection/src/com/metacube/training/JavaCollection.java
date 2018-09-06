package com.metacube.training;

import java.util.*;

public class JavaCollection {
	
	@SuppressWarnings("rawtypes")
	List addressList;
	@SuppressWarnings("rawtypes")
	Set addressSet;
	@SuppressWarnings("rawtypes")
	Map addressMap;

	// a setter method to set List
	@SuppressWarnings("rawtypes")
	public void setAddressList(List addressList) {
		this.addressList = addressList;
	}

	// prints and returns all the elements of the list.
	@SuppressWarnings("rawtypes")
	public List getAddressList() {
		System.out.println("List Elements :" + addressList);
		return addressList;
	}

	// a setter method to set Set
	@SuppressWarnings("rawtypes")
	public void setAddressSet(Set addressSet) {
		this.addressSet = addressSet;
	}

	// prints and returns all the elements of the Set.
	@SuppressWarnings("rawtypes")
	public Set getAddressSet() {
		System.out.println("Set Elements :" + addressSet);
		return addressSet;
	}

	// a setter method to set Map
	@SuppressWarnings("rawtypes")
	public void setAddressMap(Map addressMap) {
		this.addressMap = addressMap;
	}

	// prints and returns all the elements of the Map.
	@SuppressWarnings("rawtypes")
	public Map getAddressMap() {
		System.out.println("Map Elements :" + addressMap);
		return addressMap;
	}
}