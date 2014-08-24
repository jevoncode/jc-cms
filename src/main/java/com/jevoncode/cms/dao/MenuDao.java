package com.jevoncode.cms.dao;

import java.util.List;

import com.jevoncode.cms.domain.Menu;

public interface MenuDao {
	public List<Menu> getThemAll();

	public void insertOne(Menu menu);
}
