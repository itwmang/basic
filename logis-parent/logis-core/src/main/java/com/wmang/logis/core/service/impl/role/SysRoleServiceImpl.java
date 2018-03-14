package com.wmang.logis.core.service.impl.role;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wmang.logis.core.dao.role.SysRoleExtMapper;
import com.wmang.logis.core.dao.role.SysRoleMapper;
import com.wmang.logis.core.service.role.SysRoleService;
import com.wmang.logis.mode.entity.role.SysRole;
import com.wmang.logis.mode.utils.base.AbstractService;
import com.wmang.logis.mode.utils.base.BaseMapper;

 /**
 * Title: 系统角色
 * Description: 系统角色ServiceImpl类
 * @Author: wmang
 * @CreateDate: 2018-03
 * @version 1.0 初稿
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends AbstractService<SysRole, Integer> implements SysRoleService {
	
	protected static Logger logger = LoggerFactory.getLogger(SysRoleServiceImpl.class);
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Autowired
	private SysRoleExtMapper sysRoleExtMapper;

	@Override
	public BaseMapper<SysRole, Integer> getBaseMapper() throws Exception {
		return sysRoleMapper;
	}

}
