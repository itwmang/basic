package com.wmang.logis.mode.entity.role;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

 /**
 * Title: 系统角色
 * Description: 系统角色Entity类,工具生成，请勿修改  
 * @Author: wmang
 * @CreateDate: 2018-03
 * @version 1.0 初稿
 */
public class SysRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 主键 */
	public final static String id_="id";
	/** 角色名称 */
	public final static String roleName_="role_name";
	/** 父ID */
	public final static String pid_="pid";
	/** 角色描述 */
	public final static String desc_="desc_";
	/** 账户是否有效 */
	public final static String validly_="validly";
	/** 创建人 */
	public final static String creater_="creater";
	/** 创建时间 */
	public final static String createTime_="create_time";
	/** 修改人 */
	public final static String updater_="updater";
	/** 修改时间 */
	public final static String updateTime_="update_time";

	/** 主键 */
	private Integer id;
	/** 角色名称 */
	private String roleName;
	/** 父ID */
	private String pid;
	/** 角色描述 */
	private String desc;
	/** 账户是否有效 */
	private String validly;
	/** 创建人 */
	private String creater;
	/** 创建时间 */
	private Date createTime;
	/** 修改人 */
	private String updater;
	/** 修改时间 */
	private Date updateTime;
	
	/** 主键 */
	public Integer getId() {
		return id;
	}
	/** 主键 */
	public void setId(Integer id) {
		this.id=id;
	}
	/** 角色名称 */
	public String getRoleName() {
		return roleName;
	}
	/** 角色名称 */
	public void setRoleName(String roleName) {
		this.roleName=roleName;
	}
	/** 父ID */
	public String getPid() {
		return pid;
	}
	/** 父ID */
	public void setPid(String pid) {
		this.pid=pid;
	}
	/** 角色描述 */
	public String getDesc() {
		return desc;
	}
	/** 角色描述 */
	public void setDesc(String desc) {
		this.desc=desc;
	}
	/** 账户是否有效 */
	public String getValidly() {
		return validly;
	}
	/** 账户是否有效 */
	public void setValidly(String validly) {
		this.validly=validly;
	}
	/** 创建人 */
	public String getCreater() {
		return creater;
	}
	/** 创建人 */
	public void setCreater(String creater) {
		this.creater=creater;
	}
	/** 创建时间 */
	public Date getCreateTime() {
		return createTime;
	}
	/** 创建时间 */
	public void setCreateTime(Date createTime) {
		this.createTime=createTime;
	}
	/** 修改人 */
	public String getUpdater() {
		return updater;
	}
	/** 修改人 */
	public void setUpdater(String updater) {
		this.updater=updater;
	}
	/** 修改时间 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/** 修改时间 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
	}
}
