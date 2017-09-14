/**
 * BORGWARD CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: BORGWARD
 *
 * Copyright © 2016 BORGWARD Corporation. All rights reserved.
 */
package com.maple.earnings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maple.earnings.pojo.EUser;
import com.maple.earnings.service.UserService;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
@Controller
public class PageController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}

	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}

	@RequestMapping("/user/list")
	@ResponseBody
	public List<EUser> getItemList() {
		List<EUser> result = this.userService.list();
		return result;
	}

}
