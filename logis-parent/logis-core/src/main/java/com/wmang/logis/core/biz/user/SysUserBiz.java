package com.wmang.logis.core.biz.user;

import java.util.List;

import com.wmang.logis.mode.dto.vo.user.SysUserVO;
import com.wmang.logis.mode.utils.base.BaseMgrBiz;

 /**
 * Title: 客户主数据
 * Description: 客户主数据Biz类
 * @Author: wmang
 * @CreateDate: 2018-01
 * @version 1.0 初稿
 */
public interface SysUserBiz extends BaseMgrBiz<SysUserVO,Integer> {

	
	/**
	 * 根据条件查询数据
	 * @param vo
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	List<SysUserVO> findAllUser(SysUserVO vo, int pageIndex, int pageSize);

}
