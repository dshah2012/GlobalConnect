package com.ge.tps.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ge.tps.dao.SearchDao;
import com.ge.tps.dto.TrainerProfileDTOMain;
import com.ge.tps.entities.TrainerProfile;
import com.ge.tps.util.MySql_DB_Connect;


/**
 * @author Uday
 * @description 
 * @since 03-Mar-2016
 * @version 
 */

public class SearchDaoImpl implements SearchDao {

	/* (non-Javadoc)
	 * @see com.ge.tps.dao.SearchDao#search(java.lang.String)
	 */

	Connection connection;
	TrainerProfile trainerProfile = new TrainerProfile();

	@Override
	public Map<String, List<TrainerProfileDTOMain>> retrieve() {
		// TODO Auto-generated method stub
		Map<String, List<TrainerProfileDTOMain>> searchMap = new HashMap<>();
		List<TrainerProfileDTOMain> trainerProfileDtos = new ArrayList<>();
		TrainerProfileDTOMain trainerProfileDtoMain= null;
		int mapKey = 0;


		String sql = "SELECT DISTINCT tp.trainerProfileId, pi.firstName, pi.lastName, "
				+ "s.skillName, wes.skillDurationInMonths, c.primaryMobileNo, pi.Gender, "
				+ "a.propertyNo, a.streetName, a.areaName, a.landmark, a.city, a.state, "
				+ "a.country, a.pincode, u.primaryMailId, tp.readyToRelocate, je.organizationName "
				+ "FROM TrainerProfile tp, User u, Contact c, Address a, PersonalInfo pi, "
				+ "Skill s, WorkExperienceSkill wes, SkillSet ss, WorkExperience we, JobEmployment je "
				+ "WHERE wes.skillId=s.skillId and tp.personalInfoId=pi.personalInfoId and "
				+ "tp.trainerProfileId=ss.trainerProfileId and we.trainerProfileId=tp.trainerProfileId and "
				+ "wes.workExperienceId=we.workExperienceId and ss.skillId=s.skillId and tp.trainerProfileId=je.trainerProfileId "
				+ "GROUP BY tp.trainerProfileId, s.skillName;"; 
		try{
			connection = MySql_DB_Connect.getConnection();
			java.sql.PreparedStatement pstmt = connection.prepareStatement(sql);
			Set<String> skills = null;
			List<Integer> skillDurationInMonths = null;
			ResultSet rs = pstmt.executeQuery();
			long tempTpId = 0L;
			int row = 1;
			long tpId = 0L;

			while(rs.next()){
				tempTpId = rs.getLong("tp.trainerProfileId");

				skills=new HashSet<>();
				skillDurationInMonths=new ArrayList<>();
				trainerProfileDtoMain=new TrainerProfileDTOMain();
				while(tempTpId == rs.getLong("tp.trainerProfileId")){
					tpId = rs.getLong("tp.trainerProfileId");
					skills.add(rs.getString("skillName"));
					skillDurationInMonths.add(rs.getInt("skillDurationInMonths"));

					if(rs.isLast()){
						row++;
						break;
					}
					rs.next();
					row++;
				}
				int r=row-1;
				rs.absolute(r);
				trainerProfileDtoMain.setSkillName(skills);
				trainerProfileDtoMain.setSkillDurationInMonths(skillDurationInMonths);

				trainerProfileDtoMain.setTrainerProfileId(tpId);
				trainerProfileDtoMain.setFirstName(rs.getString("firstName"));
				trainerProfileDtoMain.setLastName(rs.getString("lastName"));
				trainerProfileDtoMain.setPrimaryMobileNo(rs.getLong("primaryMobileNo"));
				trainerProfileDtoMain.setGender(rs.getString("Gender"));

				trainerProfileDtoMain.setPropertyNo(rs.getString("propertyNo"));
				trainerProfileDtoMain.setStreetName(rs.getString("streetName"));
				trainerProfileDtoMain.setAreaName(rs.getString("areaName"));
				trainerProfileDtoMain.setLandmark(rs.getString("landmark"));
				trainerProfileDtoMain.setCity(rs.getString("city"));
				trainerProfileDtoMain.setState(rs.getString("state"));
				trainerProfileDtoMain.setCountry(rs.getString("country"));
				trainerProfileDtoMain.setPincode(rs.getInt("pincode"));
				trainerProfileDtoMain.setReadyToRelocate(rs.getBoolean("readyToRelocate"));
				trainerProfileDtoMain.setPrimaryEmailId(rs.getString("primaryMailId"));
				trainerProfileDtoMain.setOrganizationName(rs.getString("organizationName"));
				
				//				System.out.println(trainerProfileDtoMain);
				skills = null;
				skillDurationInMonths = null;
				trainerProfileDtos.add(trainerProfileDtoMain);
				if(rs.isLast()){

					break;
				}




			}
		}catch(ClassNotFoundException e){
			System.out.println(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searchMap.put("", trainerProfileDtos);

		return searchMap;
	}
}


