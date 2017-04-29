package com.mcmcg.gbs.bluefin.service.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseService {
	public static final String jdbcClassName = "com.ibm.as400.access.AS400JDBCDriver";
	public static final String url = "jdbc:as400://iseries-qa.internal.mcmcg.com";
	public static final String user = "PRDWEBUSR";
	public static final String password = "PRDWEBUSR1";

	public static Connection create() {
		Connection dbConnection = null;
		try {
			//DriverManager.registerDriver(new com.ibm.as400.access.AS400JDBCDriver());

			// Load class into memory
			Class.forName(jdbcClassName);
			// Establish connection
			dbConnection = DriverManager.getConnection(url, user, password);
			dbConnection.setClientInfo("libraries", "*LIBL");
			dbConnection.setClientInfo("naming", "system");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dbConnection;
	}

	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
			}
		}
	}
}
