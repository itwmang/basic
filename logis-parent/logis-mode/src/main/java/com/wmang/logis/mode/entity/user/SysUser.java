package com.wmang.logis.mode.entity.user;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

 /**
 * Title: 客户主数据
 * Description: 客户主数据Entity类,工具生成，请勿修改  
 * @Author: wmang
 * @CreateDate: 2018-02
 * @version 1.0 初稿
 */
public class SysUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 主键 */
	public final static String id_="id";
	/** 账号 */
	public final static String account_="account";
	/** 名称 */
	public final static String name_="name_";
	/** 密码 */
	public final static String passwd_="passwd";
	/** 邮箱 */
	public final static String email_="email";
	/** 用户类型 */
	public final static String userType_="user_type";
	/** 用户状态 */
	public final static String userStatus_="user_status";
	/** 电话号码 */
	public final static String phone_="phone";
	/** 家庭地址 */
	public final static String address_="address";
	/** 密码最后修改时间 */
	public final static String lastupdatePasswd_="lastupdate_passwd";
	/** 账户是否有效 */
	public final static String validly_="validly";
	/** 备注 */
	public final static String remark_="remark";
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
	/** 账号 */
	private String account;
	/** 名称 */
	private String name;
	/** 密码 */
	private String passwd;
	/** 邮箱 */
	private String email;
	/** 用户类型 */
	private String userType;
	/** 用户状态 */
	private String userStatus;
	/** 电话号码 */
	private String phone;
	/** 家庭地址 */
	private String address;
	/** 密码最后修改时间 */
	private Date lastupdatePasswd;
	/** 账户是否有效 */
	private String validly;
	/** 备注 */
	private String remark;
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
	/** 账号 */
	public String getAccount() {
		return account;
	}
	/** 账号 */
	public void setAccount(String account) {
		this.account=account;
	}
	/** 名称 */
	public String getName() {
		return name;
	}
	/** 名称 */
	public void setName(String name) {
		this.name=name;
	}
	/** 密码 */
	public String getPasswd() {
		return passwd;
	}
	/** 密码 */
	public void setPasswd(String passwd) {
		this.passwd=passwd;
	}
	/** 邮箱 */
	public String getEmail() {
		return email;
	}
	/** 邮箱 */
	public void setEmail(String email) {
		this.email=email;
	}
	/** 用户类型 */
	public String getUserType() {
		return userType;
	}
	/** 用户类型 */
	public void setUserType(String userType) {
		this.userType=userType;
	}
	/** 用户状态 */
	public String getUserStatus() {
		return userStatus;
	}
	/** 用户状态 */
	public void setUserStatus(String userStatus) {
		this.userStatus=userStatus;
	}
	/** 电话号码 */
	public String getPhone() {
		return phone;
	}
	/** 电话号码 */
	public void setPhone(String phone) {
		this.phone=phone;
	}
	/** 家庭地址 */
	public String getAddress() {
		return address;
	}
	/** 家庭地址 */
	public void setAddress(String address) {
		this.address=address;
	}
	/** 密码最后修改时间 */
	public Date getLastupdatePasswd() {
		return lastupdatePasswd;
	}
	/** 密码最后修改时间 */
	public void setLastupdatePasswd(Date lastupdatePasswd) {
		this.lastupdatePasswd=lastupdatePasswd;
	}
	/** 账户是否有效 */
	public String getValidly() {
		return validly;
	}
	/** 账户是否有效 */
	public void setValidly(String validly) {
		this.validly=validly;
	}
	/** 备注 */
	public String getRemark() {
		return remark;
	}
	/** 备注 */
	public void setRemark(String remark) {
		this.remark=remark;
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
