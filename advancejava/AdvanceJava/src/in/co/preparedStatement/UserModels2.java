package in.co.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserModels2 {
	public List search(UserBean bean ) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute","root","root");
		StringBuffer sql = new StringBuffer("select*from newstudent where 1=1");
		
		if(bean !=null) {
			if(bean.getLastname() !=null && bean.getLastname().length()>0) {
				sql.append("and lastname like ' "+ bean.getLastname() + "'");
				
			}
			
		}
		System.out.println("sql query ====>" + sql.toString());
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs= pstmt.executeQuery();
		List list = new ArrayList();
		
		while(rs.next()) {
		
		bean = new UserBean();
		
		bean.setId(rs.getInt(1));
		bean.setFistname(rs.getString(2));
		bean.setLastname(rs.getString(3));
		bean.setLoginId(rs.getString(4));
		bean.setPassword(rs.getString(5));
		bean.setDob(rs.getDate(6));
		bean.setGender(rs.getString(7));
		
		list.add(bean);
		}
		return list;
		
		
		
		
	}

}
