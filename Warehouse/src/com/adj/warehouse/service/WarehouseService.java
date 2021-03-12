package com.adj.warehouse.service;

import java.sql.SQLException;

import com.adj.warehouse.dao.WarehouseDao;
import com.adj.warehouse.dao.imp.WarehouseDaoImp;
import com.adj.warehouse.modal.Warehouse;

public class WarehouseService {

	
	
	
	public void insertObject(Warehouse obj)
	{
		
		try {
		WarehouseDao warehouseDao=WarehouseDaoImp.getWarehaouseInstance();
		warehouseDao.createTableAndInsertData(obj);
		
		}catch(SQLException | InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
	}
}
