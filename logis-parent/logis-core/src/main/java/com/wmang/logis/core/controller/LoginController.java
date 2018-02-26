package com.wmang.logis.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Title: 客户主数据 Description: 客户主数据Controller类
 * 
 * @Author: wmang
 * @CreateDate: 2018-01
 * @version 1.0 初稿
 */
@Controller
public class LoginController extends BaseController {


	/** 新增_打开界面 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam("account")String account,@RequestParam("passwd")String passwd) throws Exception {
		return "";
	}

}
