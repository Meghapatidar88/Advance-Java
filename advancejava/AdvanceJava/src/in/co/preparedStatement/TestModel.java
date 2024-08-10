package in.co.preparedStatement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TestModel {
public static void main(String[]args) throws Exception {
	
	//testAdd();
	//testupdate();
	testFindByLoginId();

}
private static void testFindByLoginId() throws Exception {
	
	UserBean bean = new UserBean();
	
	UserModel model = new UserModel();
	
	bean = model.findByLoginId("ram45@gmail.com");
	
	System.out.println(bean.getFistname());
	System.out.println(bean.getLastname());


}
private static void testAdd() throws Exception {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
	
	
	UserBean bean =new UserBean();
	bean.setId(8);
	bean.setFistname("nikhil");
	bean.setLastname("patil");
	bean.setLoginId("Nikhil56gmail.com");
	bean.setPassword("nikhil109");
	bean.setDob(sdf.parse("2007-02-08"));
	System.out.println("Done");
	
	UserModel model= new UserModel();
	model.add(bean);
	//model.delete(bean);
	
	
	
}
private static void testupdate() throws Exception {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
	
	
	UserBean bean =new UserBean();
	bean.setId(7);
	bean.setFistname("shilpa");
	bean.setLastname("shukla");
	bean.setLoginId("shilpi325@gmail.com");
	bean.setPassword("shilpi046");
	bean.setDob(sdf.parse("1998-12-30"));
	bean.setGender("female");
	System.out.println("Done");
	

	UserModel model= new UserModel();
     model.update(bean);
}
  
   }




