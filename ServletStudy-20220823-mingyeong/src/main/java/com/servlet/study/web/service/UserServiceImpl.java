package com.servlet.study.web.service;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.servlet.study.web.domain.user.User;
import com.servlet.study.web.domain.user.UserRespository;
import com.servlet.study.web.servlet.dto.PrincipalUser;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	@NonNull
	private final UserRespository userRespository;
	
	@Override
	public String getUserList() {
		return getGson().toJson(userRespository.getUserList());
	}

	@Override
	public String checkUserId(String userId) {
		int result = userRespository.checkUserId(userId);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("checkFlag", result > 0 ? false : true);
		
		return getGson().toJson(resultMap);
	}
	
	@Override
	public String addUser(User user) {
		int result = userRespository.save(user);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", result > 0);
		
		return getGson().toJson(resultMap);
	}
	
	@Override
	public String updateUser(User user) {
		int result = userRespository.update(user);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", result > 0);
		
		return getGson().toJson(resultMap);
	}
	
	@Override
	public String deleteUser(int userCode) {
		int result = userRespository.delete(userCode);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", result > 0);
		
		return getGson().toJson(resultMap);
	}
	
	@Override
	public PrincipalUser signin(String userId, String password) {
		User user = userRespository.findUserByUserId(userId);
		if(user == null) {
			return null;
		}
		if(user.getUser_password().equals(password)) {
			
			return user.toPrincipal();
			
		}else {
			return null;
		}
		
	}
	
	private Gson getGson() {
		return new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
	}




	

}

