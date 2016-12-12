package com.bubble.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class JdbcUtil {
	private static String url = "jdbc:mysql://localhost:3306/e-commerce";
	private static String user = "root";
	private static String password = "123456";
	
	private JdbcUtil(){
		
	}
	
	//静态的类只会被执行一次 在代码装载到虚拟机时执行一次
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,user,password);
	}
	
	public static void free(ResultSet rs,Statement st,Connection conn){
		try{
			if(rs != null)
				rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				if(st != null)
					st.close();
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				if(conn != null){
					try{
						conn.close();
					}catch(SQLException e){
					e.printStackTrace();
					}
				}
			}
		}
	}
}

