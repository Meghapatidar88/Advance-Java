package in.co.JDBCStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CRUDOpreation {
public static void main(String[] args) throws Exception {
	
	//add();
//	update();
//	delete();
//	search();
//	findbysalary();
//	findbyid();
	authenticate();
	
}
private static void authenticate() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	Statement stmt = conn.createStatement();
	ResultSet rs =stmt.executeQuery("select*from students where id = 4 and namel = 'himanshi'");
	 System.out.println("Done");
	 
	
	
}
private static void findbyid() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	Statement stmt = conn.createStatement();
	ResultSet rs =stmt.executeQuery("select*from students where id = 3");
	 System.out.println("Done");
}

private static void search() throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
	Statement stmt = conn.createStatement();
	ResultSet rs =stmt.executeQuery("select*from students");
	 while(rs.next()) {
		 System.out.println(rs.getInt(1));
		 System.out.println(rs.getInt(2));
	 }
		 
		 
	 }
	 private static void delete() throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			Statement stmt = conn.createStatement();
			int i = stmt.executeUpdate("delete from students where id = 2");
			 System.out.println("Done");
	 }
	 private static void update() throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			Statement stmt = conn.createStatement();
			int i = stmt.executeUpdate("Update student set name= 'raj'where id =6");
			 System.out.println("Done");
	 
	 
	 }
	 private static void add() throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			Statement stmt = conn.createStatement();
			int i = stmt.executeUpdate("insert into students value(02,'neha'");
			 System.out.println("Done");
	 
}}
