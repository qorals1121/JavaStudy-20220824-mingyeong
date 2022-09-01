package com.servlet.study.web.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.servlet.study.web.domain.user.UserRespository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	
	@NonNull
	private final UserRespository userRespository;
	
	@Override
	public String getUserList() {
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.serializeNulls()
				.create();
		return gson.toJson(userRespository.getUserList());
	}
	


}
