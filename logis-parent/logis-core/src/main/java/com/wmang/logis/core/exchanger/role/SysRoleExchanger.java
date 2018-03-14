package com.wmang.logis.core.exchanger.role;

import java.util.Map;

import com.wmang.logis.mode.dto.vo.role.SysRoleVO;
import com.wmang.logis.mode.entity.role.SysRole;
import com.wmang.logis.mode.utils.DateUtil;
import com.wmang.logis.mode.utils.ValueUtil;
import com.wmang.logis.mode.utils.base.AbstractExchanger;


 /**
 * Title: 系统角色
 * Description: 系统角色Exchanger类 
 * @Author: wmang
 * @CreateDate: 2018-03
 * @version 1.0 初稿
 */
public class SysRoleExchanger extends AbstractExchanger<SysRoleVO,SysRole> {
	
	@Override
	public void dbFillVo(SysRole db,SysRoleVO vo) {
		vo.setId(db.getId());
		vo.setRoleName(db.getRoleName());
		vo.setPid(db.getPid());
		vo.setDesc(db.getDesc());
		vo.setValidly(db.getValidly());
		vo.setCreater(db.getCreater());
		vo.setCreateTime(db.getCreateTime());
		vo.setCreateTimeStr(DateUtil.DateToString(db.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
		vo.setUpdater(db.getUpdater());
		vo.setUpdateTime(db.getUpdateTime());
		vo.setUpdateTimeStr(DateUtil.DateToString(db.getUpdateTime(), "yyyy-MM-dd HH:mm:ss"));
	}
	
	@Override
	public void voFillDb(SysRoleVO vo,SysRole db) {
		db.setId(vo.getId());
		db.setRoleName(vo.getRoleName());
		db.setPid(vo.getPid());
		db.setDesc(vo.getDesc());
		db.setValidly(vo.getValidly());
		db.setCreater(vo.getCreater());
		if (vo.getCreateTime()!=null) {
			db.setCreateTime(vo.getCreateTime());
		} else {
			db.setCreateTime(ValueUtil.toDateNull(vo.getCreateTimeStr()));
		}
		db.setUpdater(vo.getUpdater());
		if (vo.getUpdateTime()!=null) {
			db.setUpdateTime(vo.getUpdateTime());
		} else {
			db.setUpdateTime(ValueUtil.toDateNull(vo.getUpdateTimeStr()));
		}
	}
	
	@Override
	public void mapFillVo(Map<String,?> map,SysRoleVO vo) {
		vo.setId(ValueUtil.toIntNull(map.get("id")));
		vo.setRoleName(ValueUtil.toStr(map.get("roleName")));
		vo.setPid(ValueUtil.toStr(map.get("pid")));
		vo.setDesc(ValueUtil.toStr(map.get("desc")));
		vo.setValidly(ValueUtil.toStr(map.get("validly")));
		vo.setCreater(ValueUtil.toStr(map.get("creater")));
		vo.setCreateTime(ValueUtil.toDateNull(map.get("createTime")));
		vo.setCreateTimeStr(DateUtil.DateToString(vo.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
		vo.setUpdater(ValueUtil.toStr(map.get("updater")));
		vo.setUpdateTime(ValueUtil.toDateNull(map.get("updateTime")));
		vo.setUpdateTimeStr(DateUtil.DateToString(vo.getUpdateTime(), "yyyy-MM-dd HH:mm:ss"));
	}

	@Override
	public SysRoleVO newInstanceV() {
		return new SysRoleVO();
	}

	@Override
	public SysRole newInstanceD() {
		return new SysRole();
	}
	
	@Override
	public void dbFillPkVo(SysRole db, SysRoleVO vo) {
		vo.setId(db.getId());
	}
}
