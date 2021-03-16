package com.adj.logger.dao.imp;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.adj.logger.dao.GetConnection;
import com.adj.logger.dao.LoggerDao;
import com.adj.logger.modal.Logger;
import com.adj.logger.utility.Utility;

public class LoggerDaoImp implements LoggerDao{

	private static LoggerDaoImp warehouseDao;

	private LoggerDaoImp() {
	}

	public static LoggerDaoImp getWarehaouseInstance() {

		if (warehouseDao == null)
			warehouseDao = new LoggerDaoImp();
		return warehouseDao;
	}
    @Override
	public void createTableAndInsertData(Logger obj)
			throws SQLException, InstantiationException, IllegalAccessException {

		String className = Utility.getClassName(obj);
		className = className.toUpperCase();
		Connection connection = null;
		Statement statement = null;
		List<ArrayList<String>> list = null;
		try {
			list = Utility.getAttributeAndType(obj);
			connection = GetConnection.connection();
			statement = connection.createStatement();

			String stmt = "create table " + className + " (" + list.get(0).get(0) + " " + list.get(0).get(1)
					+ " primary key";

			for (int i = 1; i < list.size(); i++) {

				if (list.get(i).get(1).equalsIgnoreCase("java.lang.String")) {
					stmt += "," + list.get(i).get(0) + " " + "varchar(255)";

				} else if (list.get(i).get(1).equalsIgnoreCase("short")) {
					stmt += "," + list.get(i).get(0) + " " + "varchar(255)";

				}

				else {
					stmt += "," + list.get(i).get(0) + " " + list.get(i).get(1);
				}

			}
			stmt += ")";
			statement.execute(stmt);
			insertData(obj, list);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			insertData(obj, list);
		} finally {
			connection.close();
		}

	}
    @Override
	public void insertData(Logger obj, List<ArrayList<String>> list) throws SQLException {
		String className = Utility.getClassName(obj);
		Connection connection = null;
		String columnName = "";
		String columnValue = "";

		try {
			connection = GetConnection.connection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		columnName = list.get(0).get(0);
		columnValue = "?";

		for (int i = 1; i < list.size(); i++) {

			columnName += "," + list.get(i).get(0);
			columnValue += ",?";
		}

		String insertQuery = "insert into " + className + " (" + columnName + ")  values(" + columnValue + ")";
		PreparedStatement pinsert = connection.prepareStatement(insertQuery);

		for (int i = 0; i < list.size(); i++) {
			Object o = getAttribute(obj, list.get(i).get(0));

			if (list.get(i).get(1).equals("int") || list.get(i).get(1).equals("Integer")
					|| list.get(i).get(1).equalsIgnoreCase("Short") || list.get(i).get(1).equalsIgnoreCase("Byte")) {
				int k = (int) o;
				pinsert.setInt(i + 1, k);

			} else if (list.get(i).get(1).equals("float")) {
				float k = (float) o;
				pinsert.setFloat(i + 1, k);
			} else if (list.get(i).get(1).equalsIgnoreCase("Double") || list.get(i).get(1).equalsIgnoreCase("Long")) {
				Double k = (Double) o;
				pinsert.setDouble(i + 1, k);
			} else if (list.get(i).get(1).equalsIgnoreCase("boolean")) {
				boolean k = (boolean) o;
				pinsert.setBoolean(i + 1, k);
			} else if (list.get(i).get(1).equalsIgnoreCase("Date")) {
				Date k = (Date) o;
				pinsert.setDate(i + 1, k);
			} else if (list.get(i).get(1).equalsIgnoreCase("java.lang.String")) {
				String k = (String) o;
				pinsert.setString(i + 1, k);
			}
		}
		pinsert.executeUpdate();
	}

	public Object getAttribute(Object obj, String variableName) {
		Object f = null;
		try {
			PropertyDescriptor pd = new PropertyDescriptor(variableName, obj.getClass());
			Method getter = pd.getReadMethod();
			f = getter.invoke(obj);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
