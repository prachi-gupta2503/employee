package com.adj.warehouse.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.adj.warehouse.modal.Warehouse;

public interface WarehouseDao {
 
	void createTableAndInsertData(Warehouse obj) throws SQLException, InstantiationException, IllegalAccessException;
	void insertData(Warehouse obj, List<ArrayList<String>> list) throws SQLException ;
}
