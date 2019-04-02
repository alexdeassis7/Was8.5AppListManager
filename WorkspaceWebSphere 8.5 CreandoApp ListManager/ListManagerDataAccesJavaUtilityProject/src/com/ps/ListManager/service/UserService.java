package com.ps.ListManager.service;

import java.util.List;

import com.ps.ListManager.service.model.User;

public interface UserService {
	
	User authenticateUSer(String username);

	List<ListItem> getListItems(Long userId);

}
