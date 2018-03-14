package com.wmang.logis.mode.dto.vo.role;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

 /**
 * Title: 系统角色
 * Description: 系统角色VO类
 * @Author: wmang
 * @CreateDate: 2018-03
 * @version 1.0 初稿
 */
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@org.codehaus.jackson.annotate.JsonIgnoreProperties(ignoreUnknown = true)
public class SysRoleVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 主键 **/
	private Integer id;
	/** 角色名称 **/
	private String roleName;
	/** 父ID **/
	private String pid;
	/** 角色描述 **/
	private String desc;
	/** 账户是否有效 **/
	private String validly;
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
