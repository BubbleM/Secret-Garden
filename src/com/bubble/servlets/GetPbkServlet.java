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

public class GetPbkServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetPbkServlet() {
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
	 * @return 
	 * @return 
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Post请求成功......");
		String id = request.getParameter("id");
		
		CRUD crud = new CRUD();
		User user = new User();
		user.setId(id);
		try {
			crud.read1(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pbk = user.getPbk();
		String name = user.getName();
		String pwd = user.getPwd();
		String security = user.getSecurity();
		String digest = user.getDigest();
		String encrypt = user.getEnctypt();
		System.out.println(pbk);
		request.getSession().setAttribute("id1", id);
		//request.getSession().setAttribute("name1", name);
		//request.getSession().setAttribute("pwd1", pwd);
		request.getSession().setAttribute("pbk1", pbk);
		//request.getSession().setAttribute("security1", security);
		//request.getSession().setAttribute("digest1", digest);
		//request.getSession().setAttribute("encrypt1", encrypt);
//		PrintWriter out = response.getWriter();  //获得一个给浏览器输出的对象 类型是PrintWriter
//		response.setContentType("text/html;charset=utf-8");
//		out.println(pbk);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
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
