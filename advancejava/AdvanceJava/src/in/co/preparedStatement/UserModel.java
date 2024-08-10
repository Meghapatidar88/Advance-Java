package in.co.preparedStatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
	public void add(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
		//PreparedStatement pstrmt = conn.prepareStatement("insert into newstudent values(?,?,?,?,?,?,?)");//ye add wale me kaam aayegi
		
		UserBean us = findByLoginId(bean.getLoginId());
		if(us !=null) {
			System.out.println("login id already exist please use diffrent id");
			
		}else {
			PreparedStatement pstrmt = conn.prepareStatement("insert into newstudent values(?,?,?,?,?,?,?)");
			
			pstrmt.setInt(1,bean.getId());
		//pstrmt.setInt(1,nextPK());
		pstrmt.setString(2,bean.getFistname());
		pstrmt.setString(3,bean.getLastname());
		pstrmt.setString(4,bean.getLoginId());
		pstrmt.setString(5,bean.getPassword());
		pstrmt.setDate(6,new java.sql.Date(bean.getDob().getTime()));
		pstrmt.setString(7,bean.getGender());
		 
		int i=pstrmt.executeUpdate();
		System.out.println("data insert successfully...");
		}
	}
	 public UserBean findByLoginId(String loginId) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
		PreparedStatement pstrmt = conn.prepareStatement("select* from newstudent where loginid=?");
		
		pstrmt.setString(1,loginId);
		
		ResultSet rs =pstrmt.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
		    bean =new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFistname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			bean.setGender(rs.getString(7));
			
			
		}
		return bean;
	}
	public void delete(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
		PreparedStatement pstrmt = conn.prepareStatement("delete from newstudent where id=?");
		pstrmt.setInt(1,bean.getId());
		int i=pstrmt.executeUpdate();
		System.out.println("delete successful....."+i);
		
	}
	public void update(UserBean bean) throws Exception {
     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
	
    PreparedStatement pstmrt = conn.prepareStatement("update newstudent set  firstName= ? where id=?");
    
   
	 pstmrt.setString(1,bean.getFistname());
	 pstmrt.setInt(2,bean.getId());
	 
	 int i = pstmrt.executeUpdate();
	 
	 System.out.println("update successfully.."+i);
	}
	public int nextPK() throws Exception {
		
		int pk =0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
		PreparedStatement pstrmt =conn.prepareStatement("select max(id)from newstudent");
		ResultSet rs = pstrmt.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
			
			System.out.println("max id"+pk);
			
			
		
		}
		
		return pk + 1;
		}
	
	}
