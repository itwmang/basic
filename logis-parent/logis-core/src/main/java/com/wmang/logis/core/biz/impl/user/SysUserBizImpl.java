package com.wmang.logis.core.biz.impl.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wmang.logis.core.biz.user.SysUserBiz;
import com.wmang.logis.core.exchanger.user.SysUserExchanger;
import com.wmang.logis.core.service.user.SysUserService;
import com.wmang.logis.mode.dto.vo.user.SysUserVO;
import com.wmang.logis.mode.entity.user.SysUser;
import com.wmang.logis.mode.utils.base.AbstractBaseMgrBiz;
import com.wmang.logis.mode.utils.base.AbstractExchanger;
import com.wmang.logis.mode.utils.base.BaseResponse;
import com.wmang.logis.mode.utils.base.BaseService;
import com.wmang.logis.mode.utils.base.CommonExample;
import com.wmang.logis.mode.utils.pagehelper.PageHelper;

/**
 * Title: 客户主数据
 * <p>
 * Description: 客户主数据BizImpl类
 * </p>
 * 
 * @Author: wmang
 * @CreateDate: 2018-01
 * @version 1.0 初稿
 */
@Service("sysUserBiz")
public class SysUserBizImpl extends AbstractBaseMgrBiz<SysUserVO, SysUser, Integer> implements SysUserBiz {

	protected static Logger logger = LoggerFactory.getLogger(SysUserBizImpl.class);

	protected static List<String> updateColumns = Arrays.asList(SysUser.account_, SysUser.name_, SysUser.passwd_,
			SysUser.email_, SysUser.userType_, SysUser.userStatus_, SysUser.phone_, SysUser.address_,
			SysUser.lastupdatePasswd_, SysUser.pubValidly_, SysUser.pubRemark_, SysUser.pubCreatePerson_,
			SysUser.pubCreateDate_, SysUser.pubModiPerson_, SysUser.pubModiDate_);

	@Autowired
	private SysUserService sysUserService;

	@Override
	public BaseService<SysUser, Integer> getBaseService() {
		return sysUserService;
	}

	@Override
	public AbstractExchanger<SysUserVO, SysUser> getExchanger() {
		return new SysUserExchanger();
	}

	@Override
	public List<String> getUpdateColumns() {
		return updateColumns;
	}

	@Override
	public BaseResponse<SysUserVO> update(SysUserVO vo, String userId) throws Exception {
		// TODO: vo.setOther...
		return super.update(vo, userId);
	}

	@Override
	public BaseResponse<SysUserVO> save(SysUserVO vo, String userId) throws Exception {
		// TODO: vo.setOther...
		return super.save(vo, userId);
	}

	@Override
	public List<SysUserVO> findAllUser(SysUserVO vo, int pageIndex, int pageSize) {
		List<SysUserVO> listvo = new ArrayList<SysUserVO>();
		try {
			CommonExample example = new CommonExample();
			if (StringUtils.isNotBlank(vo.getAccount())) {
				example.andEqStr(SysUser.account_, vo.getAccount());
			}
			if (StringUtils.isNotBlank(vo.getName())) {
				example.andEqStr(SysUser.name_, vo.getName());
			}
			if (pageIndex > 0 && pageSize > 0) {
				PageHelper.startPage(pageIndex, pageSize);
			}
			List<SysUser> list = sysUserService.listByCondition(example);
			if (CollectionUtils.isNotEmpty(list)) {
				SysUserExchanger ex = new SysUserExchanger();
				for (SysUser sysUser : list) {
					listvo.add(ex.dbToVo(sysUser));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return listvo;
	}

}
