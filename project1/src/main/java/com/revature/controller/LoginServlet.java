package com.revature.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.beans.LoginBean;
import com.revature.beans.Person;
import com.revature.service.LoginService;

public class LoginServlet extends HttpServlet{
	public Gson gson = new Gson();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		switch(uri) {
		case "/project1/login": {
			if("GET".equals(request.getMethod())) {
				System.out.println("get request");
				break;
			}else if("POST".equals(request.getMethod())) {
				System.out.println("post request");				
				LoginBean lb = gson.fromJson(request.getReader(), LoginBean.class);
				System.out.println(lb);
				Person p = LoginService.accountLogin(lb);
//				System.out.println(p);
				if(p != null) {
					HttpSession session = request.getSession();
					System.out.println(session.getId());
					session.setAttribute("loggedInUser", gson.toJson(p));
					response.setHeader("Access-Control-Allow-Origin","*");
					response.getWriter().append(gson.toJson(p));
				}
				
				break;
			}
			break;
		}
		default:{
			System.out.println("default");
		}
		}
	};
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	};
}
