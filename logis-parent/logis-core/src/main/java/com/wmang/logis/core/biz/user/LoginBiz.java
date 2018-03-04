package com.wmang.logis.core.biz.user;

import com.wmang.logis.mode.entity.user.SysUser;

/**
 * Title: 登录
 * Description: 登录Biz类
 * @Author: wmang
 * @CreateDate: 2018-01
 * @version 1.0 初稿
 */
public interface LoginBiz  {

	boolean validateLogin(String account, String passwd);

	SysUser findUserByAccount(String account) throws Exception;

}
