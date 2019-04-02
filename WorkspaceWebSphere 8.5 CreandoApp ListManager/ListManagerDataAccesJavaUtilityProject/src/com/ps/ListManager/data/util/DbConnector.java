package com.ps.ListManager.data.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbConnector {

	public static Connection getConnection() throws SQLException {
		DataSource ds = null;

		try {
			Context ctx = new InitialContext();
			// solicitamos el recurso java:comp.....
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/AppDb");
		} catch (NamingException e) {

			e.printStackTrace();
		}

		return ds.getConnection();
	}

}
