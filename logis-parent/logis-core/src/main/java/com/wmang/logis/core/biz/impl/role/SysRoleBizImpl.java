package com.wmang.logis.core.biz.impl.role;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wmang.logis.core.biz.role.SysRoleBiz;
import com.wmang.logis.core.exchanger.role.SysRoleExchanger;
import com.wmang.logis.core.service.role.SysRoleService;
import com.wmang.logis.mode.dto.vo.role.SysRoleVO;
import com.wmang.logis.mode.entity.role.SysRole;
import com.wmang.logis.mode.utils.base.AbstractBaseMgrBiz;
import com.wmang.logis.mode.utils.base.AbstractExchanger;
import com.wmang.logis.mode.utils.base.BasePageResponse;
import com.wmang.logis.mode.utils.base.BaseResponse;
import com.wmang.logis.mode.utils.base.BaseService;
import com.wmang.logis.mode.utils.base.CommonExample;
import com.wmang.logis.mode.utils.pagehelper.Page;
import com.wmang.logis.mode.utils.pagehelper.PageHelper;

 /**
 * Title: 系统角色
 * <p>Description: 系统角色BizImpl类</p>
 * @Author: wmang
 * @CreateDate: 2018-03
 * @version 1.0 初稿
 */
@Service("sysRoleBiz")
public class SysRoleBizImpl extends AbstractBaseMgrBiz<SysRoleVO,SysRole,Integer> implements SysRoleBiz {
	
	protected static Logger logger = LoggerFactory.getLogger(SysRoleBizImpl.class);
	
	protected static List<String> updateColumns=Arrays.asList(SysRole.roleName_,SysRole.pid_,SysRole.desc_,SysRole.validly_,SysRole.creater_,SysRole.createTime_,SysRole.updater_,SysRole.updateTime_);
	
	@Autowired
	private SysRoleService sysRoleService;

	@Override
	public BaseService<SysRole, Integer> getBaseService() {
		return sysRoleService;
	}

	@Override
	public AbstractExchanger<SysRoleVO, SysRole> getExchanger() {
		return new SysRoleExchanger();
	}

	@Override
	public List<String> getUpdateColumns() {
		return updateColumns;
	}
	
	@Override
	public BaseResponse<SysRoleVO> update(SysRoleVO vo, String userId) throws Exception {
		// TODO: vo.setOther...
		return super.update(vo, userId);
	}
	
	@Override
	public BaseResponse<SysRoleVO> save(SysRoleVO vo, String userId) throws Exception {
		// TODO: vo.setOther...
		return super.save(vo, userId);
	}

	@Override
	public BasePageResponse findAllRole(SysRoleVO vo, int pageIndex, int pageSize) {
		BasePageResponse res = new BasePageResponse();
		try {
			CommonExample example = new CommonExample();
			if (StringUtils.isNotBlank(vo.getRoleName())) {
				example.andLike(SysRole.roleName_, vo.getRoleName());
			}
			if (pageIndex > 0 && pageSize > 0) {
				PageHelper.startPage(pageIndex, pageSize);
			}
			List<SysRole> list = sysRoleService.listByCondition(example);
			
			if (CollectionUtils.isNotEmpty(list)) {
				if(list instanceof Page) {
					
					Page<SysRole> page = (Page<SysRole>) list;
					res.setCount(page.getTotal());
					res.setData(page.getResult());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return res;
	}
}
