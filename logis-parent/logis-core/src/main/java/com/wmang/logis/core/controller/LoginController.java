package com.wmang.logis.core.controller;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	@Autowired
	private LoginBiz loginBiz;

	/** 新增_打开界面 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public BodyData login(@RequestParam("account") String account, @RequestParam("passwd") String passwd,
			HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println(account.concat("  ").concat(passwd));
		account = Base64.getDecoder().decode(new String(account.getBytes(),"UTF-8")).toString();
		passwd = Base64.getDecoder().decode(new String(passwd.getBytes(),"UTF-8")).toString();
		boolean b = loginBiz.validateLogin(account, passwd);
		if (b) {
			// 加入session
			SysUser user = loginBiz.findUserByAccount(account);
			session.setAttribute(Constants.user_account, user.getAccount());
			session.setAttribute(Constants.user_name, user.getName_());
			session.setAttribute(Constants.login_user, user);
			return super.success(true);
		} else {
			return super.success(false);
		}

	}
}
