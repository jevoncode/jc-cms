package com.jevoncode.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView test() {
		ModelAndView model = new ModelAndView("admin");
		return model;
	}
}
