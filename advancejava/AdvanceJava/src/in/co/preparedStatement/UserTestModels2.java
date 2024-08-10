package in.co.preparedStatement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserTestModels2 {
	public static void main(String[] args) throws Exception {
		
		
		
testsearch();
      
	} 
      private static void testsearch() throws Exception {
    	  UserBean bean = new UserBean();
    	  UserModels2 model = new UserModels2();
    	  
    	  List list = new ArrayList();
    	  
    	 // bean.setFistname("shilpi");//yaha hum firstname lastname kisi se bhi search kr sakte h
          bean.setFistname("ram");
          //bean.setLastname("sharma");
    	  list= model.search(bean);
    	  
    	  Iterator it = list.iterator();
    	  
    	  while(it.hasNext()) {
    		  bean =(UserBean)it.next();
    		  
    		  System.out.println(bean.getId());
    		  System.out.println("\t"+bean.getFistname());
    		  System.out.println("\t"+bean.getLastname());
    		  System.out.println("\t"+bean.getLoginId());
    		  System.out.println("\t"+bean.getPassword());
    		  System.out.println("\t"+bean.getDob());
    		  System.out.println("\t"+bean.getGender());
    	  }
    	  
      }
}
