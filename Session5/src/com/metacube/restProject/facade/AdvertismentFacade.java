package com.metacube.restProject.facade;

import java.util.List;

import com.metacube.restProject.enums.Status;
import com.metacube.restProject.models.Advertisment;
import com.metacube.restProject.service.AdvertismentServices;

public class AdvertismentFacade {
	private static AdvertismentFacade advertismentFacade = new AdvertismentFacade();
	private AdvertismentServices advertismentServices = AdvertismentServices.getInstance();
	
	public static AdvertismentFacade getInstance(){
		return advertismentFacade;
	}
	
	public List<Advertisment> getAll(){
		return advertismentServices.getAll();
	}
	
	public Status createAdvertisment(Advertisment advertisment){
		return advertismentServices.createAdvertisment(advertisment);
	}
	
	public Status deleteAdvertisment(int id){
		return advertismentServices.deleteAdvertisment(id);
	}
	
	public Status updateAdvertisment(Advertisment advertisment){
		return advertismentServices.updateAdvertisment(advertisment);
	}
	
	public List<Advertisment> getAdvertismentByCategory(int id){
		return advertismentServices.getAdvertismentByCategory(id);
	}

	
}
