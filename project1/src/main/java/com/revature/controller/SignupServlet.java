package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.beans.Person;
import com.revature.beans.PersonBean;
import com.revature.daos.PersonDaoImp;

public class SignupServlet extends HttpServlet {
	public Gson gson = new Gson();
	public PersonDaoImp pDao = new PersonDaoImp();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);

		switch (uri) {
		case "/project1/signup": {
			if ("GET".equals(request.getMethod())) {
				System.out.println("get request");
				break;
			} else if ("POST".equals(request.getMethod())) {
				System.out.println("post request");
				HttpSession session = request.getSession();
				response.setHeader("Access-Control-Allow-Origin", "*");
				Person p = new Person();
				PersonBean pb = gson.fromJson(request.getReader(), PersonBean.class);
				p.setFirstname(pb.getFirstname());
				p.setLastname(pb.getLastname());
				p.setUsername(pb.getUsername());
				p.setPass(pb.getPassword());
				p.setPos_id(1);
				p.setReimb_limit(1000d);
				pDao.createPerson(p);
				System.out.println(p);
				response.getWriter().write("signup successful");

				break;
			}
		}
		default: {
			System.out.println("default");
		}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request,response);
	}
}
