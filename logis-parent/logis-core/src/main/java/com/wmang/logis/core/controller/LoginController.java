package com.wmang.logis.core.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wmang.logis.core.biz.user.LoginBiz;
import com.wmang.logis.mode.constant.Constants;
import com.wmang.logis.mode.entity.user.SysUser;
import com.wmang.logis.mode.utils.base.BodyData;

/**
 * Title: 客户主数据 Description: 客户主数据Controller类
 * 
 * @Author: wmang
 * @CreateDate: 2018-01
 * @version 1.0 初稿
 */
@Controller
public class LoginController extends BaseController {

	private static final String UTF_8 = "utf-8";
	@Autowired
	private LoginBiz loginBiz;

	/** 登录 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public BodyData login(@RequestParam("account") String account, @RequestParam("passwd") String passwd,
			HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println(account.concat("  ").concat(passwd));
		account = this.base2Utf(account);
		passwd =  this.base2Utf(passwd);
		boolean b = loginBiz.validateLogin(account, passwd);
		if (b) {
			// 加入session
			SysUser user = loginBiz.findUserByAccount(account);
			session.setAttribute(Constants.user_account, user.getAccount());
			session.setAttribute(Constants.user_name, user.getName_());
			session.setAttribute(Constants.login_user, user);
		}
		return super.success(b);

	}

	/** 退出系统 */
	@ResponseBody
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public BodyData logout(HttpServletRequest request, HttpSession session) throws Exception {
		// 删除session
		session.removeAttribute(Constants.user_account);
		session.removeAttribute(Constants.user_name);
		session.removeAttribute(Constants.login_user);
		return super.success(true);

	}
	
	private String base2Utf(String value) throws Exception{
		return new String(Base64.decodeBase64(value.getBytes(UTF_8)), UTF_8);
	}
	
}
