package com.adj.logger.service;

import java.sql.SQLException;

import com.adj.logger.dao.LoggerDao;
import com.adj.logger.dao.imp.LoggerDaoImp;
import com.adj.logger.modal.Logger;

public class LoggerService {

	
	
	
	public void insertObject(Logger obj)
	{
		
		try {
	
		LoggerDaoImp.getWarehaouseInstance().createTableAndInsertData(obj);
		
		}catch(SQLException | InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}
}
