
	package in.co.JDBCStatement;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.Statement;

	public class TestConnection {
		public static void main (String[]args) throws Exception  {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","root");
			Statement strt = conn.createStatement();
			int i = strt.executeUpdate("create table himanshi(id int primary key,name varchar(50))");
			
			System.out.println("table created:" +i);
			System.out.println("connection is succesfully");
		}

	}



