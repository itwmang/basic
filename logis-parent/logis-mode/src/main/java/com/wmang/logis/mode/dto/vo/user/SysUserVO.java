package com.wmang.logis.mode.dto.vo.user;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

 /**
 * Title: 客户主数据
 * Description: 客户主数据VO类
 * @Author: wmang
 * @CreateDate: 2018-02
 * @version 1.0 初稿
 */
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@org.codehaus.jackson.annotate.JsonIgnoreProperties(ignoreUnknown = true)
public class SysUserVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 主键 **/
	private Integer id;
	/** 账号 **/
	private String account;
	/** 名称 **/
	private String name_;
	/** 密码 **/
	private String passwd;
	/** 邮箱 **/
	private String email;
	/** 用户类型 **/
	private String userType;
	/** 用户状态 **/
	private String userStatus;
	/** 电话号码 **/
	private String phone;
	/** 家庭地址 **/
	private String address;
	/** 密码最后修改时间 **/
	private Date lastupdatePasswd;
	/** 密码最后修改时间字符 **/
	private String lastupdatePasswdStr;
	/** 密码最后修改时间开始 **/
	private String lastupdatePasswdBeginStr;
	/** 密码最后修改时间结束 **/
	private String lastupdatePasswdEndStr;
	/** 账户是否有效 **/
	private String validly;
	/** 备注 **/
	private String remark;
	/** 创建人 **/
	private String creater;
	/** 创建时间 **/
	private Date createTime;
	/** 创建时间字符 **/
	private String createTimeStr;
	/** 创建时间开始 **/
	private String createTimeBeginStr;
	/** 创建时间结束 **/
	private String createTimeEndStr;
	/** 修改人 **/
	private String updater;
	/** 修改时间 **/
	private Date updateTime;
	/** 修改时间字符 **/
	private String updateTimeStr;
	/** 修改时间开始 **/
	private String updateTimeBeginStr;
	/** 修改时间结束 **/
	private String updateTimeEndStr;
	
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
	
	public String getName_() {
		return name_;
	}
	public void setName_(String name_) {
		this.name_ = name_;
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
	/** 密码最后修改时间字符 **/
	public String getLastupdatePasswdStr() {
		return lastupdatePasswdStr;
	}
	/** 密码最后修改时间字符 **/
	public void setLastupdatePasswdStr(String lastupdatePasswdStr) {
		this.lastupdatePasswdStr=lastupdatePasswdStr;
	}
	/** 密码最后修改时间开始 **/
	public String getLastupdatePasswdBeginStr() {
		return lastupdatePasswdBeginStr;
	}
	/** 密码最后修改时间开始 **/
	public void setLastupdatePasswdBeginStr(String lastupdatePasswdBeginStr) {
		this.lastupdatePasswdBeginStr=lastupdatePasswdBeginStr;
	}
	/** 密码最后修改时间结束 **/
	public String getLastupdatePasswdEndStr() {
		return lastupdatePasswdEndStr;
	}
	/** 密码最后修改时间结束 **/
	public void setLastupdatePasswdEndStr(String lastupdatePasswdEndStr) {
		this.lastupdatePasswdEndStr=lastupdatePasswdEndStr;
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
	/** 创建时间字符 **/
	public String getCreateTimeStr() {
		return createTimeStr;
	}
	/** 创建时间字符 **/
	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr=createTimeStr;
	}
	/** 创建时间开始 **/
	public String getCreateTimeBeginStr() {
		return createTimeBeginStr;
	}
	/** 创建时间开始 **/
	public void setCreateTimeBeginStr(String createTimeBeginStr) {
		this.createTimeBeginStr=createTimeBeginStr;
	}
	/** 创建时间结束 **/
	public String getCreateTimeEndStr() {
		return createTimeEndStr;
	}
	/** 创建时间结束 **/
	public void setCreateTimeEndStr(String createTimeEndStr) {
		this.createTimeEndStr=createTimeEndStr;
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
	/** 修改时间字符 **/
	public String getUpdateTimeStr() {
		return updateTimeStr;
	}
	/** 修改时间字符 **/
	public void setUpdateTimeStr(String updateTimeStr) {
		this.updateTimeStr=updateTimeStr;
	}
	/** 修改时间开始 **/
	public String getUpdateTimeBeginStr() {
		return updateTimeBeginStr;
	}
	/** 修改时间开始 **/
	public void setUpdateTimeBeginStr(String updateTimeBeginStr) {
		this.updateTimeBeginStr=updateTimeBeginStr;
	}
	/** 修改时间结束 **/
	public String getUpdateTimeEndStr() {
		return updateTimeEndStr;
	}
	/** 修改时间结束 **/
	public void setUpdateTimeEndStr(String updateTimeEndStr) {
		this.updateTimeEndStr=updateTimeEndStr;
	}
}
