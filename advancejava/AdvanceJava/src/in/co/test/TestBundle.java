package in.co.test;

import java.util.ResourceBundle;

public class TestBundle {
public static void main(String[] args) {
	
	ResourceBundle rb  =	ResourceBundle.getBundle("in.co.bundle.system");
	System.out.println("Driver="+rb.getString("Driver"));
	System.out.println("url="+rb.getString("url"));
	System.out.println("username="+rb.getString("username"));
	System.out.println("password="+rb.getString("password"));
	System.out.println("intialpoolsize="+rb.getString("intialpoolsize"));
	System.out.println("Maxpoolsize="+rb.getString("Maxpoolsize"));
	System.out.println("acquireincrement="+rb.getString("acquireincrement"));
	
}
}
