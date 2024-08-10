package in.co.JDBCStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {
	public static void main(String[] args) throws Exception {
		
		Class.forName ("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		Statement stmt =conn.createStatement();
		int i =stmt.executeUpdate("update students set namel ='rupali' where id =2");
		System.out.println("Done");
		
	}

}
