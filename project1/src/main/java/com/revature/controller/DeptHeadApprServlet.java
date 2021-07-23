package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.beans.Reimb;
import com.revature.daos.ReimbDaoImp;
import com.revature.service.DeptHeadService;
import com.revature.service.ManagerService;

public class DeptHeadApprServlet extends HttpServlet{
	public Gson gson = new Gson();
	public ReimbDaoImp rbDao = new ReimbDaoImp();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);

		switch (uri) {
		case "/project1/deptheadappr": {
			if ("GET".equals(request.getMethod())) {
				System.out.println("get request");

			} else if ("POST".equals(request.getMethod())) {
				System.out.println("post request");
				Reimb[] rbList = gson.fromJson(request.getReader(), Reimb[].class);
				for(int i =0; i < rbList.length ; i++) {
					DeptHeadService.deptHeadAppr(rbList[i]);
				}
				
				
				response.setHeader("Access-Control-Allow-Origin","*");
				response.getWriter().write("update successful");
			}
			break;
		}
		default: {
			System.out.println("default");
		}
		}
	};

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request,response);
	};
}
