package in.co.marksheet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MarksheetModelTest {
	public static void main(String[] args) throws Exception {

		//testadd();
		// testupdate();
		// testdelete();
		// testsearch();
		//TestMeritList();
		testrollno();
	}

	private static void TestMeritList() throws Exception {
		MarksheetBean bean =new MarksheetBean();
		MarksheetModel model = new MarksheetModel();
	     
		List list =new ArrayList();
		list = model.MeritList(bean);
		
		Iterator it=list.iterator();
			 
		 while (it.hasNext()) {
			      bean=(MarksheetBean) it.next();
			 
				 System.out.println("RollNo:" +bean.getRollNo());
				 System.out.println("\t "+ "name: "+bean.getName());
				 System.out.println("\t "+"chemistry :"+bean.getChem());
				 System.out.println("\t "+"physics: "+bean.getPhy());
				 System.out.println("\t "+"maths: " +bean.getMaths());
				 //System.out.println("\t "+"Total "+total);
				 //System.out.println("\t "+"Perentage: "+p);
				 
			 }
			 
			 
			 }
		 private static void testrollno() throws Exception {
			 
			 MarksheetBean bean = new MarksheetBean();
			 
			 bean.setRollNo("109");
			 
			 MarksheetModel model = new MarksheetModel();
			 model.getrollno(bean);
			 
		 }
		
		
		
		
	

	private static void testadd() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(13);
		bean.setRollNo("113");
		bean.setName("nikhil");
		bean.setPhy(78);
		bean.setChem(55);
		bean.setMaths(67);

		MarksheetModel model = new MarksheetModel();

		model.add(bean);
		System.out.println("done");

	}

	private static void testupdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(13);
		bean.setRollNo("113");
		bean.setName("Nikhil");
		bean.setPhy(60);
		bean.setChem(89);
		bean.setMaths(33);

		MarksheetModel model = new MarksheetModel();
		model.Update(bean);
		System.out.println("done");

	}

	private static void testdelete() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		bean.setId(13);
		bean.setRollNo("113");
		bean.setName("Nikhil");
		bean.setPhy(60);
		bean.setChem(89);
		bean.setMaths(33);

		MarksheetModel model = new MarksheetModel();
		model.delete(bean);

		System.out.println("done");

	}

	private static void testsearch() throws Exception {
		
		MarksheetBean bean = new MarksheetBean();
		
		MarksheetModel model = new MarksheetModel();
		
		List list = new ArrayList();
		
		list = model.search(bean);
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			
			bean = (MarksheetBean)it.next();
			
			
			System.out.println(bean.getId());
			System.out.println("\t" +bean.getRollNo());
			System.out.println("\t" +bean.getName());
			System.out.println("\t" +bean.getPhy());
			System.out.println("\t" +bean.getChem());
			System.out.println("\t" +bean.getMaths());
			
			
			
			
		
		}
		
		
	}

}
