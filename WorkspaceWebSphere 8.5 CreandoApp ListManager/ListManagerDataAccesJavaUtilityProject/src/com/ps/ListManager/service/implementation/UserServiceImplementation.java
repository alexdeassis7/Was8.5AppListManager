package com.ps.ListManager.service.implementation;

import java.util.List;

import com.ps.ListManager.data.UserDao;
import com.ps.ListManager.service.ListItem;
import com.ps.ListManager.service.UserService;
import com.ps.ListManager.service.model.User;

public class UserServiceImplementation implements UserService {
	
	private final UserDao userDao;
	private final ListItemDao listItemDao;
	
	public UserServiceImplementation() {
		this.userDao = new 
		this.listItemDao = new LisItemDaoImplementation();
	}

	/*metodo para autenticar nombre de usuario */
	@Override
	public User authenticateUSer(String username) {
		User user = null;
		if ((username != null) && !"".equals(username.trim())){
			user = userDao.getUser(username);
		}
			
		return user;
	}

	@Override
	public List<ListItem> getListItems(Long userId) {
		return listItemDao.getListItemsByUserId(userId);
		return null;
	}

}
