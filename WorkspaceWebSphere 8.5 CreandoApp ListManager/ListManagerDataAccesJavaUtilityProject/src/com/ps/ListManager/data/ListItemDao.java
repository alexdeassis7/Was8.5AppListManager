package com.ps.ListManager.data;

import java.util.List;

import com.ps.ListManager.service.model.ListItem;

public interface ListItemDao {

	List<ListItem> getListItemByUserId (LongUserId) ;
	
}
