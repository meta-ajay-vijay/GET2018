package com.metacube.restProject.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.metacube.restProject.facade.AdvertismentFacade;
import com.metacube.restProject.models.Advertisment;

@Path("/AdvertismentResources")
public class AdvertismentResource {
	AdvertismentFacade advertismentFacade = AdvertismentFacade.getInstance();
	
	@GET
	@Path("/getAllAdvertisment")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Advertisment> getAllAdvertisment(){
		List<Advertisment> listOfAdvertisment = advertismentFacade.getAll();
		if(listOfAdvertisment.size()==0){
			return null;
			//Response.status(Response.Status.NOT_FOUND).entity("no advertisment found").build();
		}else{
			/**
			Gson gson = new Gson();
			String jsonList = gson.toJson(listOfAdvertisment);
			return Response.ok(jsonList, MediaType.APPLICATION_JSON).build();
			*/
			return listOfAdvertisment;
		}
	}
	
	@POST
	@Path("/insertAdvertisment")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertAdvertisment(Advertisment advertisment){
		if(advertisment.getAdvertismentDescription()=="" || advertisment.getId()==0 ){
			return Response.serverError().entity("id is zero").build();
		}else{
			Gson gson = new Gson();
			String message = gson.toJson(advertismentFacade.createAdvertisment(advertisment).toString());
			return Response.ok(message, MediaType.APPLICATION_JSON).build();
			
		}
	}
	
	@PUT
	@Path("/updateAdvertisment")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateAdvertisment(Advertisment advertisment){
		System.out.println(advertismentFacade.updateAdvertisment(advertisment).toString());
		
		if(isAdvertismentExist(advertisment.getId())){
			Gson gson = new Gson();
			String message = gson.toJson(advertismentFacade.updateAdvertisment(advertisment).toString());
			return Response.ok(message, MediaType.APPLICATION_JSON).build();
		}else{
			return Response.status(Response.Status.NOT_FOUND).entity("no advertisment found").build();
		}
	}
	
	private boolean isAdvertismentExist(int id){
		boolean isExistFalg = false;
		List<Advertisment> listOfAdvertisment = advertismentFacade.getAll();
		for(Advertisment advertisment:listOfAdvertisment){
			if(advertisment.getId()==id){
				isExistFalg = true;
			}
		}
		return isExistFalg;
	}
	
	
	@GET
	@Path("/getAdvertismentByCategory/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAdvertismentByCategory(@PathParam("id") String id){
		int catId = 0;
		try{
		catId  = Integer.parseInt(id.trim());
		}catch(Exception e){
			return Response.serverError().entity("id is need to be integer").build();
		}
		List<Advertisment> listOfAdvertisment = advertismentFacade.getAdvertismentByCategory(catId);
		if(listOfAdvertisment==null){
			return Response.serverError().entity("id is need to be integer").build();
			
		}
		if(listOfAdvertisment.size()==0){
			return Response.status(Response.Status.NOT_FOUND).entity("no advertisment found").build();
		}else{
			Gson gson = new Gson();
			String jsonList = gson.toJson(listOfAdvertisment);
			return Response.ok(jsonList, MediaType.APPLICATION_JSON).build();
		}
	}
	
	@DELETE
	@Path("/deleteAdvertisment/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAdvertisment(@HeaderParam("Authorization") String authorizationString,@PathParam("id") String id){
		
		if(!"GET-2018".equals(authorizationString)){
			return Response.serverError().entity("you re not authorized user").build();
		}
		
		
		int advertismentId = 0;
		try{
		advertismentId  = Integer.parseInt(id.trim());
		}catch(Exception e){
			return Response.serverError().entity("id is need to be integer").build();
		}
		
			Gson gson = new Gson();
			String message = gson.toJson(advertismentFacade.deleteAdvertisment(advertismentId).toString());
			return Response.ok(message, MediaType.APPLICATION_JSON).build();
		}

}
