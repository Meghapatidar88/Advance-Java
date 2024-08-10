package in.co.JDBCStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
		Statement stmt=conn.createStatement();
		int i=stmt.executeUpdate("insert into students values(2,'Swati'),(3,'raman'),(4,'himanshi')");
		System.out.println("insert data..."+i);
		System.out.println("Done");
	}

}
