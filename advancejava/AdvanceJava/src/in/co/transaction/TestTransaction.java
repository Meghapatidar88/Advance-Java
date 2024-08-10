package in.co.transaction;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;

import in.co.util.JDBCDataSource;

public class TestTransaction {
	
	public static void main(String[]args) throws SQLException {
		Connection conn = null;
		
		try {
			
			conn = JDBCDataSource.getConnection();
			
			Statement stmt = conn.createStatement();
			
		 //step 1
			conn.setAutoCommit(false);
			
			int i = stmt.executeUpdate("insert into newstudent values(10,'niraj','chopra','niraj@908','pass@123','2003-12-08','Male')");
			
			i = stmt.executeUpdate("insert into newstudent values(10,'avinash','mishra','avinash@238','pass@89','2004-10-09','Male')");
			
			i =stmt.executeUpdate("insert into newstudent values(10,'arav','sharma','sharma@875','pass@876','2009-09-12','Male')");
		
		System.out.println("data inserted");
		
		//step 2
		conn.commit(); 
		
		}catch (Exception e) {
			//step 3
			conn.rollback();
			
			System.out.println("data not inserted");
			System.out.println(e.getMessage());
		}
		
		
	}

}
