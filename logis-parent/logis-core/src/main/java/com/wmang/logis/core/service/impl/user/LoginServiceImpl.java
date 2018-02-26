package com.wmang.logis.core.service.impl.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wmang.logis.core.dao.user.SysUserExtMapper;
import com.wmang.logis.core.dao.user.SysUserMapper;
import com.wmang.logis.core.service.LoginService;
import com.wmang.logis.mode.entity.user.SysUser;
import com.wmang.logis.mode.utils.base.AbstractService;
import com.wmang.logis.mode.utils.base.BaseMapper;

 /**
 * Title: 客户主数据
 * Description: 客户主数据ServiceImpl类
 * @Author: wmang
 * @CreateDate: 2018-01
 * @version 1.0 初稿
 */
@Service("loginService")
public class LoginServiceImpl extends AbstractService<SysUser, Integer> implements LoginService {
	
	protected static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysUserExtMapper sysUserExtMapper;

	@Override
	public BaseMapper<SysUser, Integer> getBaseMapper() throws Exception {
		return sysUserMapper;
	}

}
