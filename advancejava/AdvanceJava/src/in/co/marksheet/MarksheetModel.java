package in.co.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MarksheetModel {
	ResourceBundle rb = ResourceBundle.getBundle("in.co.bundle.system");

	public void add(MarksheetBean bean) throws Exception {

		Class.forName(rb.getString("Driver"));

		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
				rb.getString("password"));

		PreparedStatement pstmt = conn.prepareStatement("insert into  marksheet values(?,?,?,?,?,?)");

		pstmt.setInt(1, bean.getId());
		pstmt.setString(2, bean.getRollNo());
		pstmt.setString(3, bean.getName());
		pstmt.setInt(4, bean.getPhy());
		pstmt.setInt(5, bean.getChem());
		pstmt.setInt(6, bean.getMaths());

		int i = pstmt.executeUpdate();
		System.out.println("Created successfully.....");

	}

	public void Update(MarksheetBean bean) throws Exception {
		Class.forName(rb.getString("Driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
				rb.getString("password"));
		PreparedStatement pstmt = conn.prepareStatement("Update Marksheet set name =? where id =?");

		pstmt.setString(1, bean.getName());
		pstmt.setInt(2, bean.getId());

		int i = pstmt.executeUpdate();
		System.out.println("Update Successfully.." + i);

	}

	public void delete(MarksheetBean bean) throws Exception {
		Class.forName(rb.getString("Driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
				rb.getString("password"));
		PreparedStatement pstmt = conn.prepareStatement("Delete from Marksheet where id =?");
		pstmt.setInt(1, bean.getId());

		int a = pstmt.executeUpdate();

		System.out.println("Data Deleted successfully..." + a);

	}

	public List search(MarksheetBean bean) throws Exception {
		Class.forName(rb.getString("Driver"));

		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
				rb.getString("password"));

		StringBuffer Sql = new StringBuffer("select*from marksheet where 1=1");

		if (bean != null) {

			if (bean.getName() != null && bean.getName().length() > 0) {

				Sql.append("and name like' " + bean.getName() + "'");

			}
		}

		System.out.println("Sql query ====>" + Sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(Sql.toString());

		ResultSet rs = pstmt.executeQuery();
		List list = new ArrayList();

		while (rs.next()) {
			bean = new MarksheetBean();

			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getString(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setChem(rs.getInt(5));
			bean.setMaths(rs.getInt(6));

			list.add(bean);

		}
		return list;

	}

	public List MeritList(MarksheetBean bean) throws Exception {
		Class.forName(rb.getString("Driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
				rb.getString("password"));
		PreparedStatement pstmt = conn
				.prepareStatement("select *,(phy+chem+maths) as total from marksheet order by total desc limit 0,3");

		ResultSet rs = pstmt.executeQuery();

		System.out.println("toppers are " + rs);

		List list = new ArrayList();

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollNo(rs.getString(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setChem(rs.getInt(5));
			bean.setMaths(rs.getInt(6));

			list.add(bean);

		}
		return list;

	}

	public void getrollno(MarksheetBean bean) throws Exception {
		Class.forName(rb.getString("Driver"));
		Connection conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"),
				rb.getString("password"));
		PreparedStatement pstmt = conn.prepareStatement("select *from marksheet where rollno =?");

		pstmt.setString(1, bean.getRollNo());
		ResultSet rs = pstmt.executeQuery();
		System.out.println("finding successfully....wow");

	}

}
