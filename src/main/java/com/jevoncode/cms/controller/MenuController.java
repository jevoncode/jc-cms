package com.jevoncode.cms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jevoncode.cms.dao.MenuDao;
import com.jevoncode.cms.domain.Menu;

@Controller
@RequestMapping("/menu")
public class MenuController {
	private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private MenuDao menuDao;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String test() {
		LOG.debug("add Menu");
		Menu menu = new Menu();
		menu.setName("首页");
		menu.setUrl("index");
		menuDao.insertOne(menu);
		return "success";
	}
}
