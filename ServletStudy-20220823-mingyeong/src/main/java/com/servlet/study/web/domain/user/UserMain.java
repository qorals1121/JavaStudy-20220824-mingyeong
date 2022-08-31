package com.servlet.study.web.domain.user;

public class UserMain {

	public static void main(String[] args) {
		UserRespository respository = new UserRespository();
		
		respository.getUserList();
	}

}
