package com.bubble.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bubble.classes.User;
import com.bubble.secret.md5.MD5CoderTest;

public class CRUD {
	public static void main(String[] args) throws SQLException{
		//delete();
		//update();
		//create();
		//read();
	}
	
	public static void update(User user) throws SQLException{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null; 
		String id =  user.getId();
		String security = user.getSecurity();
		try {
			//��������
			conn = JdbcUtil.getConnection();
			//�������
			st = conn.createStatement();
			String sql = "update class1401 set security='"+security+"' where id='"+id+"'";
			//ִ�����
			int i = st.executeUpdate(sql);//û��insertֻ��updata ����   ����ֵ��һ�����͸����ж�������¼������
			
			System.out.println("i="+i);
		} finally{
			JdbcUtil.free(rs, st, conn);
		}
	}
	
	public static void create(User user) throws SQLException{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null; 
		String id =  user.getId();
		String name = user.getName();
		String pwd = user.getPwd();
		String pbk = user.getPbk();
		String digest = user.getDigest();
		String encrypt = user.getEnctypt();
		try {
			//��������
			conn = JdbcUtil.getConnection();
			//�������
			st = conn.createStatement();
			String sql = "insert into class1401(id,name,pwd,pbk,digest,encrypt) values ('"+id+"','"+name+"','"+pwd+"','"+pbk+"','"+digest+"','"+encrypt+"')";
			int i = st.executeUpdate(sql);//û��insertֻ��updata ����   ����ֵ��һ�����͸����ж�������¼������
			System.out.println(sql);
			System.out.println("i="+i);
		} finally{
			JdbcUtil.free(rs, st, conn);
		}
	}
	
	public boolean read(User user){
		boolean flag = false;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null; 
		String id = user.getId();
		String pwd = user.getPwd();
		MD5CoderTest test = new MD5CoderTest();
		String pwd1 = null;
		try {
			pwd = test.testEncodeMD5Hex(pwd);
			System.out.println(pwd);
			//��������
			conn = JdbcUtil.getConnection();
			//�������
			st = conn.createStatement();
			//ִ�����
			String sql = "select pwd from class1401 where id='"+id+"'";
			rs = st.executeQuery(sql);//���水������ȡ���ݣ��ô���select�����˳��Ϳ��������
			System.out.println(sql);
			while(rs.next()){
				System.out.println(rs.getString("pwd"));
				pwd1 = rs.getString("pwd");
			}
			if(pwd1.equalsIgnoreCase(pwd)){
				flag = true;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.free(rs, st, conn);
		}
		return flag;
	}
	
	//ͨ��ID��ѯ��Կ
	public void read1(User user) throws SQLException{  
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null; 
		String id = user.getId();
		String sr = null;
		try {
			//��������
			conn = JdbcUtil.getConnection();
			//�������
			st = conn.createStatement();
			//ִ�����
			String sql = "select pbk from class1401 where id='"+id+"'";
			rs = st.executeQuery(sql);//���水s������ȡ���ݣ��ô���select�����˳��Ϳ��������
			System.out.println(sql);
			//������
			while(rs.next()){
				System.out.println(rs.getString("pbk"));
				user.setPbk(rs.getString("pbk"));
			}			
		} finally{
			JdbcUtil.free(rs, st, conn);
		}
		return;
	}
	
//	public void read2(User user) throws SQLException{
//		Connection conn = null;
//		Statement st = null;
//		ResultSet rs = null; 
//		String id = user.getId();
//		try {
//			//��������
//			conn = JdbcUtil.getConnection();
//			//�������
//			st = conn.createStatement();
//			//ִ�����
//			rs = st.executeQuery("select * from class1401 where id='"+id+"'");//���水������ȡ���ݣ��ô���select�����˳��Ϳ��������
//			//������
//			while(rs.next()){
//				System.out.println(rs.getObject("id")+"\t"
//			+rs.getObject("name"));
//				user.setName(rs.getString("name"));
//				user.setPwd(rs.getString("pwd"));
//				user.setPbk(rs.getString("pbk"));
//				user.setSecurity(rs.getString("security"));
//				user.setDigest(rs.getString("digest"));
//				user.setEnctypt(rs.getString("encrypt"));
//			}			
//		} finally{
//			JdbcUtil.free(rs, st, conn);
//		}
//	}
	public User read2(String id) throws SQLException{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null; 
		User user = new User(); 
		try {
			//��������
			conn = JdbcUtil.getConnection();
			//�������
			st = conn.createStatement();
			//ִ�����
			rs = st.executeQuery("select * from class1401 where id="+id);//���水������ȡ���ݣ��ô���select�����˳��Ϳ��������
			//������
			while(rs.next()){
				System.out.println(rs.getObject("id")+"\t"
			+rs.getObject("name"));
				user.setName(rs.getString("name"));
				user.setPwd(rs.getString("pwd"));
				user.setPbk(rs.getString("pbk"));
				user.setSecurity(rs.getString("security"));
				user.setDigest(rs.getString("digest"));
				user.setEnctypt(rs.getString("encrypt"));
			}
			user.setId(id);
			return user;
		} finally{
			JdbcUtil.free(rs, st, conn);
		}
	}
}
