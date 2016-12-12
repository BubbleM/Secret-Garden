package com.bubble.servlets;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bubble.classes.User;
import com.bubble.dao.CRUD;
import com.bubble.secret.md5.MD5Coder;
import com.bubble.secret.md5.MD5CoderTest;

public class RegisterCLServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterCLServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("POST请求成功........");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pwd1 = request.getParameter("pwd");
		
		MD5CoderTest test = new MD5CoderTest();
		String pwd = null;
		try {
			pwd = test.testEncodeMD5Hex(pwd1);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String pbk = request.getParameter("pbk");
		String digest = request.getParameter("digest");
		String encrypt = request.getParameter("encrypt");
		if(true){
			User user = new User();
			CRUD crud = new CRUD();
			user.setId(id);
			user.setName(name);
			user.setPwd(pwd);
			user.setPbk(pbk);
			user.setDigest(digest);
			user.setEnctypt(encrypt);
			try {
				CRUD.create(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("恭喜您,注册成功!");
			request.getRequestDispatcher("index.jsp").forward(request,response);
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
