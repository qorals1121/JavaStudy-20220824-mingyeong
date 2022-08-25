package com.servlet.study.web.servlet.auth.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;


@WebServlet("/api/v1/auth/singup")
public class SignupApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SignupApi() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		
		System.out.println(userId);
		System.out.println(userPassword);
		System.out.println(userName);
		System.out.println(userEmail);
		
		Gson jsonUser = new GsonBuilder().setPrettyPrinting().create();
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", userId);
		jsonObject.addProperty("pw", userPassword);
		jsonObject.addProperty("name", userName);
		jsonObject.addProperty("email", userEmail);
		
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jsonUser.toJson(jsonObject));
	}

}
