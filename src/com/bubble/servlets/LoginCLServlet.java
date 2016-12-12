package com.bubble.servlets;

import java.io.IOException;



import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bubble.classes.User;
import com.bubble.dao.CRUD;
import com.bubble.secret.md5.MD5CoderTest;

public class LoginCLServlet extends HttpServlet {

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
		String pwd = request.getParameter("pwd");
		
		User user = new User();
		user.setId(id);
		user.setPwd(pwd);
		CRUD crud = new CRUD();
//		String pbk = user.getPbk();
//		String name = user.getName();
//		String security = user.getSecurity();
//		String digest = user.getDigest();
//		String encrypt = user.getEnctypt();
//		System.out.println(pbk);
//		request.getSession().setAttribute("id1", id);
//		request.getSession().setAttribute("name1", name);
//		request.getSession().setAttribute("pwd1", pwd);
//		request.getSession().setAttribute("pbk1", pbk);
//		request.getSession().setAttribute("security1", security);
//		request.getSession().setAttribute("digest1", digest);
//		request.getSession().setAttribute("encrypt1", encrypt);
		if(crud.read(user)){
			System.out.println("登录成功！");
			try {
				User myUser = crud.read2(id);
				request.getSession().setAttribute("myUser", myUser);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			response.sendRedirect("index.jsp");
		}else{
			System.out.println("密码不正确，请重新输入！");
			request.getRequestDispatcher("err.jsp").forward(request, response);
		}
		
		//try {
			//crud.read2(user);
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
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
