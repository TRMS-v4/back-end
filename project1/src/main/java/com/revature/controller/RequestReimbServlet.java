package com.revature.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.beans.CEBean;
import com.revature.beans.CourseEvent;
import com.revature.beans.LoginBean;
import com.revature.beans.Person;
import com.revature.beans.Reimb;
import com.revature.service.EmployeeService;
import com.revature.service.LoginService;

public class RequestReimbServlet extends HttpServlet {
	Gson gson = new Gson();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);

		switch (uri) {
		case "/project1/requestreimb": {
			if ("GET".equals(request.getMethod())) {
				System.out.println("get request");
				break;
			} else if ("POST".equals(request.getMethod())) {
				System.out.println("post request");
				System.out.println(request.getReader());

				CEBean ceb = gson.fromJson(request.getReader(), CEBean.class);
				System.out.println(ceb);
				CourseEvent ce = EmployeeService.createCE(ceb);
				Reimb rb = EmployeeService.createReimb(ceb, ce);
				
				

				if(rb != null) {
					System.out.println(rb);
					HttpSession session = request.getSession();
					System.out.println(session.getId());
					session.setAttribute("courseEvent", gson.toJson(ceb));
					session.setAttribute("reimb", gson.toJson(rb));
					response.setHeader("Access-Control-Allow-Origin","*");
					response.getWriter().append(gson.toJson(rb));
				}
				
				break;
			}
			break;
		}
		default: {
			System.out.println("default");
		}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);

	}

}
