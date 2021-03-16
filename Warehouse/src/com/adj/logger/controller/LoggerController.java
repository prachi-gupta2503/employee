package com.adj.logger.controller;


import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adj.logger.modal.Logger;
import com.adj.logger.service.LoggerService;
import com.adj.logger.utility.Utility;

@WebServlet("/servlet/WarehouseController")
public class LoggerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String className=request.getParameter("className");
		 createInstance(className,request);
		
	}

	private void createInstance(String className,HttpServletRequest request) {
		Logger obj=null;
       
        try {
		Class<?> cla=Class.forName(className);
		obj=(Logger) cla.newInstance();
		List<ArrayList<String>>list=Utility.getAttributeAndType(obj);
		
		for(int i=0;i<list.size();i++)
		{
			String fieldName=list.get(i).get(0);
			String fieldType=list.get(i).get(1);
			String fieldValue=request.getParameter(list.get(i).get(0));
			if(fieldType.equals("int") || fieldType.equals("Integer"))
			{
				int f1=Integer.parseInt(fieldValue);
				setAttribute(obj, fieldName, f1);
			}
			else if(fieldType.equalsIgnoreCase("float"))
			{
				float f1=Float.parseFloat(fieldValue);
				setAttribute(obj, fieldName, f1);
			}
			else if(fieldType.equalsIgnoreCase("long")) {
				long f1=Long.parseLong(fieldValue);
				setAttribute(obj, fieldName, f1);	
			}
			else if(fieldType.equalsIgnoreCase("java.lang.String"))
			{
				
				setAttribute(obj, fieldName, fieldValue);
			}
			else if(fieldType.equalsIgnoreCase("short")) {
				short f1=Short.parseShort(fieldValue);
				setAttribute(obj, fieldName, f1);	
			}
			else if(fieldType.equalsIgnoreCase("boolean")) {
				boolean f1=Boolean.parseBoolean(fieldValue);
				setAttribute(obj, fieldName, f1);	
			}
			else if(fieldType.equalsIgnoreCase("byte")) {
				byte f1=Byte.parseByte(fieldValue);
				setAttribute(obj, fieldName, f1);	
			}
			else if(fieldType.equalsIgnoreCase("double")) {
				double f1=Double.parseDouble(fieldValue);
				setAttribute(obj, fieldName, f1);	
			}
			
			
		}
		
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException e)
        {
        	e.printStackTrace();
        }
       
		LoggerService warehouseService=new LoggerService();
		warehouseService.insertObject(obj);
	}
	private void setAttribute(Logger obj, String propertyName, Object variableValue) {
		PropertyDescriptor pd;
		try {
			pd = new PropertyDescriptor(propertyName, obj.getClass());
			Method setter = pd.getWriteMethod();
			
				setter.invoke(obj, variableValue);
			
		} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}
	
}//prav
