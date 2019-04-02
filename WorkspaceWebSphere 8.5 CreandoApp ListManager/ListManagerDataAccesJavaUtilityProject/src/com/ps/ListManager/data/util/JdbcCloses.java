package com.ps.ListManager.data.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcCloses {

	public static void closeignoreError(ResultSet rs) {

		try {
			if (rs != null && !rs.isClosed()) {

				rs.close();
			}

		} catch (SQLException se) {
			// ignored
		}

	}

	public static void closeignoreError(ResultSet rs) {

		try {
			if (rs != null && !rs.isClosed()) {

				rs.close();
			}

		} catch (SQLException se) {
			// ignored
		}

	}

}
