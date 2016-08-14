package com.ge.tps.service;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.ge.tps.dao.RetrieveProfileDao;
import com.ge.tps.entities.RealTimeExperience;
import com.ge.tps.entities.TrainerProfile;
import com.ge.tps.entities.TrainingExperience;
import com.ge.tps.entities.User;
import com.ge.tps.entities.WorkExperience;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class RetrieveProfileService {
	RetrieveProfileDao retrieveProfileDao=new RetrieveProfileDao();
	
	public static void main(String[] args) {
		RetrieveProfileService ps=new RetrieveProfileService();
		System.out.println(ps.getUserProfileAsJson(1l));
	}
	
	public String getUserProfileAsJson(long user_id){
		
		TrainerProfile trainer=retrieveProfileDao.getUserProfile(user_id);
		Gson gson=new GsonBuilder().create();
		String trainerJson=gson.toJson(trainer);
		
		//Adding work Experience into json....(TESTING)
		JsonParser parser=new JsonParser();
		JsonElement jsonElement=parser.parse(trainerJson);
		JsonObject jsonObj=jsonElement.getAsJsonObject();
		jsonObj.remove("workExperiences");
		JsonArray jsonArr=new JsonArray();
		for (WorkExperience exp : trainer.getWorkExperiences()) {
			jsonArr.add(parser.parse(gson.toJson(exp)));
			
		}
		jsonObj.add("workExperiences",jsonArr);;
		String jsonString=jsonObj.toString();
		return jsonString;
	}
	
	
	
	
}
