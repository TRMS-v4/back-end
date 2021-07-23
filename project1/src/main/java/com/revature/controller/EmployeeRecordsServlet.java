package com.revature.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.beans.LoginBean;
import com.revature.beans.Person;
import com.revature.beans.Reimb;
import com.revature.service.EmployeeService;
import com.revature.service.LoginService;

public class EmployeeRecordsServlet extends HttpServlet{
	public Gson gson = new Gson();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		switch(uri) {
		case "/project1/employeerecords": {
			if("GET".equals(request.getMethod())) {
				System.out.println("get request");
				
				
				
			}else if("POST".equals(request.getMethod())) {
				System.out.println("post request");
				Person p = gson.fromJson(request.getReader(), Person.class);
				System.out.println("p_id: " + p.getP_id());
				List<Reimb> rbList = EmployeeService.pullRecords(p.getP_id());
				System.out.println(rbList);
				if(rbList != null) {
					HttpSession session = request.getSession();
					
					session.setAttribute("userRecords", gson.toJson(rbList));
					response.setHeader("Access-Control-Allow-Origin","*");
					response.getWriter().append(gson.toJson(rbList));
				}
				
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
