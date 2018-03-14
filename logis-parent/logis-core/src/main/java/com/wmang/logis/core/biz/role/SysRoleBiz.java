package com.wmang.logis.core.biz.role;

import com.wmang.logis.mode.dto.vo.role.SysRoleVO;
import com.wmang.logis.mode.utils.base.BaseMgrBiz;
import com.wmang.logis.mode.utils.base.BasePageResponse;

 /**
 * Title: 系统角色
 * Description: 系统角色Biz类
 * @Author: wmang
 * @CreateDate: 2018-03
 * @version 1.0 初稿
 */
public interface SysRoleBiz extends BaseMgrBiz<SysRoleVO,Integer> {

	BasePageResponse findAllRole(SysRoleVO vo, int pageIndex, int pageSize);

}
