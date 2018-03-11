package com.wmang.logis.core.exchanger.user;

import java.util.Map;

import com.wmang.logis.mode.dto.vo.user.SysUserVO;
import com.wmang.logis.mode.entity.user.SysUser;
import com.wmang.logis.mode.utils.DateUtil;
import com.wmang.logis.mode.utils.ValueUtil;
import com.wmang.logis.mode.utils.base.AbstractExchanger;


 /**
 * Title: 客户主数据
 * Description: 客户主数据Exchanger类 
 * @Author: wmang
 * @CreateDate: 2018-02
 * @version 1.0 初稿
 */
public class SysUserExchanger extends AbstractExchanger<SysUserVO,SysUser> {
	
	@Override
	public void dbFillVo(SysUser db,SysUserVO vo) {
		vo.setId(db.getId());
		vo.setAccount(db.getAccount());
		vo.setName_(db.getName_());
		vo.setPasswd(db.getPasswd());
		vo.setEmail(db.getEmail());
		vo.setUserType(db.getUserType());
		vo.setUserStatus(db.getUserStatus());
		vo.setPhone(db.getPhone());
		vo.setAddress(db.getAddress());
		vo.setLastupdatePasswd(db.getLastupdatePasswd());
		vo.setLastupdatePasswdStr(DateUtil.DateToString(db.getLastupdatePasswd(), "yyyy-MM-dd HH:mm:ss"));
		vo.setValidly(db.getValidly());
		vo.setRemark(db.getRemark());
		vo.setCreater(db.getCreater());
		vo.setCreateTime(db.getCreateTime());
		vo.setUpdater(db.getUpdater());
		vo.setUpdateTime(db.getUpdateTime());
		vo.setUpdateTimeStr(DateUtil.DateToString(db.getUpdateTime(), "yyyy-MM-dd HH:mm:ss"));
	}
	
	@Override
	public void voFillDb(SysUserVO vo,SysUser db) {
		db.setId(vo.getId());
		db.setAccount(vo.getAccount());
		db.setName_(vo.getName_());
		db.setPasswd(vo.getPasswd());
		db.setEmail(vo.getEmail());
		db.setUserType(vo.getUserType());
		db.setUserStatus(vo.getUserStatus());
		db.setPhone(vo.getPhone());
		db.setAddress(vo.getAddress());
		if (vo.getLastupdatePasswd()!=null) {
			db.setLastupdatePasswd(vo.getLastupdatePasswd());
		} else {
			db.setLastupdatePasswd(ValueUtil.toDateNull(vo.getLastupdatePasswdStr()));
		}
		db.setValidly(vo.getValidly());
		db.setRemark(vo.getRemark());
		db.setCreater(vo.getCreater());
		db.setCreateTime(vo.getCreateTime());
		db.setUpdater(vo.getUpdater());
		if (vo.getUpdateTime()!=null) {
			db.setUpdateTime(vo.getUpdateTime());
		} else {
			db.setUpdateTime(ValueUtil.toDateNull(vo.getUpdateTimeStr()));
		}
	}
	
	@Override
	public void mapFillVo(Map<String,?> map,SysUserVO vo) {
		vo.setId(ValueUtil.toIntNull(map.get("id")));
		vo.setAccount(ValueUtil.toStr(map.get("account")));
		vo.setName_(ValueUtil.toStr(map.get("name_")));
		vo.setPasswd(ValueUtil.toStr(map.get("passwd")));
		vo.setEmail(ValueUtil.toStr(map.get("email")));
		vo.setUserType(ValueUtil.toStr(map.get("userType")));
		vo.setUserStatus(ValueUtil.toStr(map.get("userStatus")));
		vo.setPhone(ValueUtil.toStr(map.get("phone")));
		vo.setAddress(ValueUtil.toStr(map.get("address")));
		vo.setLastupdatePasswd(ValueUtil.toDateNull(map.get("lastupdatePasswd")));
		vo.setLastupdatePasswdStr(DateUtil.DateToString(vo.getLastupdatePasswd(), "yyyy-MM-dd HH:mm:ss"));
		vo.setValidly(ValueUtil.toStr(map.get("validly")));
		vo.setRemark(ValueUtil.toStr(map.get("remark")));
		vo.setCreater(ValueUtil.toStr(map.get("creater")));
		vo.setCreateTime(ValueUtil.toDateNull(map.get("createTime")));
		vo.setUpdater(ValueUtil.toStr(map.get("updater")));
		vo.setUpdateTime(ValueUtil.toDateNull(map.get("updateTime")));
		vo.setUpdateTimeStr(DateUtil.DateToString(vo.getUpdateTime(), "yyyy-MM-dd HH:mm:ss"));
	}

	@Override
	public SysUserVO newInstanceV() {
		return new SysUserVO();
	}

	@Override
	public SysUser newInstanceD() {
		return new SysUser();
	}
	
	@Override
	public void dbFillPkVo(SysUser db, SysUserVO vo) {
		vo.setId(db.getId());
	}
}
