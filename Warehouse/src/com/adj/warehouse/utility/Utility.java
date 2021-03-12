package com.adj.warehouse.utility;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


import com.adj.warehouse.modal.Warehouse;

public class Utility {
	
	
	public static List<ArrayList<String>> getAttributeAndType(Warehouse obj) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		List<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
		String className=obj.getClass().getSimpleName();
		
		Class cla=Class.forName(obj.getClass().getName());
	    Field[] field= cla.getDeclaredFields();
	    
	    
	    	int i=0;
			for(Field f:field)
			{
				
				list.add(new ArrayList<String>());
				list.get(i).add(0,f.getName());
				list.get(i++).add(1,f.getType().getName());
				
			}
	    
	      return list;	
	}
	


	public static String getClassName(Warehouse obj) {
		
		return obj.getClass().getSimpleName();
	}
	
}
