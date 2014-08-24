package com.jevoncode.cms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jevoncode.cms.dao.TestDao;
import com.jevoncode.cms.domain.Test;

@Controller
@RequestMapping("/")
public class IndexController {
	private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private TestDao testDao;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String test() {
		LOG.debug("test");
		Test test = new Test();
		test.setContent("test");
		testDao.add(test);
		return "test";
	}

}
