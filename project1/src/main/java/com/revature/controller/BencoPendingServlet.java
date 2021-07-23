package com.revature.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.beans.Reimb;
import com.revature.daos.ReimbDaoImp;
import com.revature.service.BenCoService;

public class BencoPendingServlet extends HttpServlet{
	public Gson gson = new Gson();
	public ReimbDaoImp rbDao = new ReimbDaoImp();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);

		switch (uri) {
		case "/project1/bencopending": {
			if ("GET".equals(request.getMethod())) {
				System.out.println("get request");
				List<Reimb> rbList = BenCoService.getByBencoAprr();
				System.out.println(rbList);
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.getWriter().append(gson.toJson(rbList));

			} else if ("POST".equals(request.getMethod())) {
				System.out.println("post request");
				List<Reimb> rbList = BenCoService.getByBencoAprr();
				System.out.println(rbList);
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.getWriter().append(gson.toJson(rbList));

			}
			break;
		}
		default: {
			System.out.println("default");
		}
		}
	};

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	};
}
