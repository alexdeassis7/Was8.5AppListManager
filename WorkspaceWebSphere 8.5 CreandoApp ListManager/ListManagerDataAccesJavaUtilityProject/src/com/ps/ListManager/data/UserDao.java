package com.ps.ListManager.data;

import com.ps.ListManager.service.model.User;

public interface UserDao {
	
	User getUser(String username);

}
