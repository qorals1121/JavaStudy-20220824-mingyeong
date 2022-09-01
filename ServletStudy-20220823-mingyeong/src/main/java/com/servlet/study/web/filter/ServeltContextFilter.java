package com.servlet.study.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import com.servlet.study.web.domain.user.UserRespository;
import com.servlet.study.web.service.UserService;
import com.servlet.study.web.service.UserServiceImpl;

@WebFilter("/*")
public class ServeltContextFilter extends HttpFilter implements Filter {
       

    public ServeltContextFilter() {
        super();

    }


	public void destroy() {

	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		ServletContext context = fConfig.getServletContext();
		context.setAttribute("userRespository", new UserRespository());
		context.setAttribute("userService", new UserServiceImpl((UserRespository)context.getAttribute("userRespository")));
	}

}
