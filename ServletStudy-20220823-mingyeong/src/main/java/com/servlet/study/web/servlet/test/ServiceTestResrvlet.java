package com.servlet.study.web.servlet.test;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import javax.servlet.HttpConstraintElement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

@WebServlet("/service/test")
public class ServiceTestResrvlet extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		System.out.println("요청이 들어와서 서비스 실행");
		System.out.println("요청 메소드 : " + req.getMethod());
		getServletContext().setAttribute("servletApplicationData", "우리가 저장한 데이터");
		doget(req, resp);
	}
	
	@Override
	protected void doget(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		System.out.println("get 요청");
		System.out.println(getServletContext().getAttribute("servletApplicationData"));
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("서블릿 소멸");
	}
}



