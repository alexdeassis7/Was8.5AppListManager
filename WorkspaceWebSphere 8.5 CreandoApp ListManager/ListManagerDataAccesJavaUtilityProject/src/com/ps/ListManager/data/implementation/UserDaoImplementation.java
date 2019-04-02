package com.ps.ListManager.data.implementation;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ps.ListManager.data.UserDao;
import com.ps.ListManager.data.util.DbConnector;
import com.ps.ListManager.data.util.JdbcCloses;
import com.ps.ListManager.service.model.User;

public class UserDaoImplementation implements UserDao {

	@Override
	public User getUser(String username) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn =  (Connection) DbConnector.getConnection();
			stmt = conn.prepareStatement("SELECT U.ID, U.USERNAME, U.DISPLAY_NAME" + "FROM APP_USER U" + "WHERE LOWER(U.USERNAME) = ?");
				stmt.setString(1 , username.toLowerCase());
				rs =stmt.executeQuery();
				
			} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JdbcCloses.closeignoreError(rs);
			JdbcCloses.closeignoreError(stmt);
			JdbcCloses.closeignoreError(conn);
		}
		return null;

	}
}
