package com.adj.logger.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.adj.logger.modal.Logger;

public interface LoggerDao {
 
	void createTableAndInsertData(Logger obj) throws SQLException, InstantiationException, IllegalAccessException;
	void insertData(Logger obj, List<ArrayList<String>> list) throws SQLException ;
}
