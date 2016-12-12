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
			//��������
			conn = JdbcUtil.getConnection();
			//�������
			st = conn.createStatement();
			//ִ�����
			rs = st.executeQuery("select * from class1401");
			//������
			while(rs.next()){
				System.out.println(rs.getObject(1)+"\t"+rs.getObject(2)+"\t"+rs.getObject(3));
			}			
		} finally{
			JdbcUtil.free(rs, st, conn);
		}
	}
	
	static  void test() throws SQLException{
		//1.ע������
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		   //ע������������һ�ӷ�ʽ
		//System.setProperty("jdbc.drivers","com.mysql.jdbc.Driver");
		  //ע������������һ�ӷ�ʽ    ����װ�ص������ ��һ����ʵ��
		//Class.forName("com.mysql.jdbc.Driver");//�Ƽ���ʽ
		//2.��������
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/e-commerce","root","123456");
		//3.�������
		Statement st = conn.createStatement();
		//4.ִ�����
		ResultSet rs = st.executeQuery("select * from class1401");
		//5.������
		while(rs.next()){//next()���б���
			System.out.println(rs.getObject(1)+"\t"+rs.getObject(2)+"\t"+rs.getObject(3));
		}
		//6.�ͷ���Դ
		rs.close();
		st.close();
		conn.close();
	}
}
