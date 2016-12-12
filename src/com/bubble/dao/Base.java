package com.bubble.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Base {
	public static void main(String[] args) throws Exception{
		template();
	}
	
	static void template() throws Exception{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null; 
		try {
			//建立连接
			conn = JdbcUtil.getConnection();
			//创建语句
			st = conn.createStatement();
			//执行语句
			rs = st.executeQuery("select * from class1401");
			//处理结果
			while(rs.next()){
				System.out.println(rs.getObject(1)+"\t"+rs.getObject(2)+"\t"+rs.getObject(3));
			}			
		} finally{
			JdbcUtil.free(rs, st, conn);
		}
	}
	
	static  void test() throws SQLException{
		//1.注册驱动
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		   //注册驱动的另外一钟方式
		//System.setProperty("jdbc.drivers","com.mysql.jdbc.Driver");
		  //注册驱动的另外一钟方式    把类装载到虚拟机 不一定有实例
		//Class.forName("com.mysql.jdbc.Driver");//推荐方式
		//2.建立连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/e-commerce","root","123456");
		//3.创建语句
		Statement st = conn.createStatement();
		//4.执行语句
		ResultSet rs = st.executeQuery("select * from class1401");
		//5.处理结果
		while(rs.next()){//next()按行遍历
			System.out.println(rs.getObject(1)+"\t"+rs.getObject(2)+"\t"+rs.getObject(3));
		}
		//6.释放资源
		rs.close();
		st.close();
		conn.close();
	}
}
