package com.servlet.study.web.service;

import com.servlet.study.web.domain.user.User;

public interface UserService {
	public String getUserList();
	public String checkUserId(String userId);
	public String addUser(User user);

}
