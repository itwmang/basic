package com.wmang.logis.core.biz.impl.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wmang.logis.core.biz.user.LoginBiz;
import com.wmang.logis.core.service.LoginService;
import com.wmang.logis.mode.entity.user.SysUser;
import com.wmang.logis.mode.utils.Md5Util;
import com.wmang.logis.mode.utils.base.CommonExample;

/**
 * Title: 登录
 * Description: 登录
 * @Author: wmang
 * @CreateDate: 2018-01
 * @version 1.0 初稿
 */
@Service("loginBiz")
public class LoginBizImpl implements LoginBiz{

	protected static Logger logger = LoggerFactory.getLogger(LoginBizImpl.class);


	@Autowired
	private LoginService loginService;


	@Override
	public boolean validateLogin(String account, String passwd) {
		String pass_ = passwd.concat(account);
		passwd = Md5Util.md5(pass_);
		int count = loginService.validateLogin(account,passwd);
		return count > 0 ? true : false;
	}


	@Override
	public SysUser findUserByAccount(String account) throws Exception {
		CommonExample example = new CommonExample();
		example.andEqStr(SysUser.account_, account);
		List<SysUser> list = new ArrayList<>();
		try {
			list = loginService.listByCondition(example);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CollectionUtils.isEmpty(list)?new SysUser():list.get(0);
	}



}
