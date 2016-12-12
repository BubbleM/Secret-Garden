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
			//建立连接
			conn = JdbcUtil.getConnection();
			//创建语句
			st = conn.createStatement();
			String sql = "update class1401 set security='"+security+"' where id='"+id+"'";
			//执行语句
			int i = st.executeUpdate(sql);//没有insert只有updata 更新   返回值是一个整型告诉有多少条记录更新了
			
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
			//建立连接
			conn = JdbcUtil.getConnection();
			//创建语句
			st = conn.createStatement();
			String sql = "insert into class1401(id,name,pwd,pbk,digest,encrypt) values ('"+id+"','"+name+"','"+pwd+"','"+pbk+"','"+digest+"','"+encrypt+"')";
			int i = st.executeUpdate(sql);//没有insert只有updata 更新   返回值是一个整型告诉有多少条记录更新了
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
			//建立连接
			conn = JdbcUtil.getConnection();
			//创建语句
			st = conn.createStatement();
			//执行语句
			String sql = "select pwd from class1401 where id='"+id+"'";
			rs = st.executeQuery(sql);//下面按照列名取数据，好处是select后面的顺序就可以随便了
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
	
	//通过ID查询公钥
	public void read1(User user) throws SQLException{  
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null; 
		String id = user.getId();
		String sr = null;
		try {
			//建立连接
			conn = JdbcUtil.getConnection();
			//创建语句
			st = conn.createStatement();
			//执行语句
			String sql = "select pbk from class1401 where id='"+id+"'";
			rs = st.executeQuery(sql);//下面按s照列名取数据，好处是select后面的顺序就可以随便了
			System.out.println(sql);
			//处理结果
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
//			//建立连接
//			conn = JdbcUtil.getConnection();
//			//创建语句
//			st = conn.createStatement();
//			//执行语句
//			rs = st.executeQuery("select * from class1401 where id='"+id+"'");//下面按照列名取数据，好处是select后面的顺序就可以随便了
//			//处理结果
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
			//建立连接
			conn = JdbcUtil.getConnection();
			//创建语句
			st = conn.createStatement();
			//执行语句
			rs = st.executeQuery("select * from class1401 where id="+id);//下面按照列名取数据，好处是select后面的顺序就可以随便了
			//处理结果
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
