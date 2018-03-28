package com.wmang.logis.mode.dto.vo.user;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

 /**
 * Title: 货运单据
 * Description: 货运单据VO类
 * @Author: wmang
 * @CreateDate: 2018-03
 * @version 1.0 初稿
 */
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@org.codehaus.jackson.annotate.JsonIgnoreProperties(ignoreUnknown = true)
public class ShippingDocumentsVO implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 单据ID **/
	private Integer rowId;
	/** 主体编码 **/
	private String orgCode;
	/** 单据号 **/
	private Integer billNo;
	/** 单据日期 **/
	private Date billDate;
	/** 单据日期字符 **/
	private String billDateStr;
	/** 单据日期开始 **/
	private String billDateBeginStr;
	/** 单据日期结束 **/
	private String billDateEndStr;
	/** 收货人 **/
	private String receiver;
	/** 收货人电话 **/
	private String receiverPhone;
	/** 发货人 **/
	private String shipper;
	/** 发货人电话 **/
	private String shipperPhone;
	/** 数量 **/
	private String quantity;
	/** 单位 */
	private String unit;
	/** 货款 **/
	private BigDecimal money;
	/** 运费 **/
	private BigDecimal freight;
	/** 合计 **/
	private BigDecimal total;
	/** 货运方式 **/
	private String freightType;
	/** 司机 **/
	private String driver;
	/** 备注 **/
	private String remarks;
	/** 单据状态 **/
	private String billState;
	/** 收款状态 **/
	private String receivablesState;
	/** 收款方式 **/
	private String receivablesType;
	/** 收款日期 **/
	private Date receivablesDate;
	/** 收款日期字符 **/
	private String receivablesDateStr;
	/** 收款日期开始 **/
	private String receivablesDateBeginStr;
	/** 收款日期结束 **/
	private String receivablesDateEndStr;
	/** 付款状态 **/
	private String paymentState;
	/** 付款方式 **/
	private String paymentType;
	/** 付款日期 **/
	private Date paymentDate;
	/** 付款日期字符 **/
	private String paymentDateStr;
	/** 付款日期开始 **/
	private String paymentDateBeginStr;
	/** 付款日期结束 **/
	private String paymentDateEndStr;
	/** 预留1 **/
	private String priceSpare1;
	/** 预留2 **/
	private String priceSpare2;
	/** 预留3 **/
	private String priceSpare3;
	/** 预留4 **/
	private String priceSpare4;
	/** 预留5 **/
	private String priceSpare5;
	/** 预留6 **/
	private String priceSpare6;
	/** 预留7 **/
	private String priceSpare7;
	/** 预留8 **/
	private String priceSpare8;
	/** 预留9 **/
	private String priceSpare9;
	/** 预留10 **/
	private String priceSpare10;
	/** 创建人 **/
	private String pubCreatePerson;
	/** 创建时间 **/
	private Date pubCreateDate;
	/** 创建时间字符 **/
	private String pubCreateDateStr;
	/** 创建时间开始 **/
	private String pubCreateDateBeginStr;
	/** 创建时间结束 **/
	private String pubCreateDateEndStr;
	/** 最后修改人 **/
	private String pubModiPerson;
	/** 最后修改时间 **/
	private Date pubModiDate;
	/** 最后修改时间字符 **/
	private String pubModiDateStr;
	/** 最后修改时间开始 **/
	private String pubModiDateBeginStr;
	/** 最后修改时间结束 **/
	private String pubModiDateEndStr;
	
	private String queryCustomer;
	
	
	public String getQueryCustomer() {
		return queryCustomer;
	}
	public void setQueryCustomer(String queryCustomer) {
		this.queryCustomer = queryCustomer;
	}
	/** 单据ID */
	public Integer getRowId() {
		return rowId;
	}
	/** 单据ID */
	public void setRowId(Integer rowId) {
		this.rowId=rowId;
	}
	/** 主体编码 */
	public String getOrgCode() {
		return orgCode;
	}
	/** 主体编码 */
	public void setOrgCode(String orgCode) {
		this.orgCode=orgCode;
	}
	/** 单据号 */
	public Integer getBillNo() {
		return billNo;
	}
	/** 单据号 */
	public void setBillNo(Integer billNo) {
		this.billNo=billNo;
	}
	/** 单据日期 */
	public Date getBillDate() {
		return billDate;
	}
	/** 单据日期 */
	public void setBillDate(Date billDate) {
		this.billDate=billDate;
	}
	/** 单据日期字符 **/
	public String getBillDateStr() {
		return billDateStr;
	}
	/** 单据日期字符 **/
	public void setBillDateStr(String billDateStr) {
		this.billDateStr=billDateStr;
	}
	/** 单据日期开始 **/
	public String getBillDateBeginStr() {
		return billDateBeginStr;
	}
	/** 单据日期开始 **/
	public void setBillDateBeginStr(String billDateBeginStr) {
		this.billDateBeginStr=billDateBeginStr;
	}
	/** 单据日期结束 **/
	public String getBillDateEndStr() {
		return billDateEndStr;
	}
	/** 单据日期结束 **/
	public void setBillDateEndStr(String billDateEndStr) {
		this.billDateEndStr=billDateEndStr;
	}
	/** 收货人 */
	public String getReceiver() {
		return receiver;
	}
	/** 收货人 */
	public void setReceiver(String receiver) {
		this.receiver=receiver;
	}
	/** 收货人电话 */
	public String getReceiverPhone() {
		return receiverPhone;
	}
	/** 收货人电话 */
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone=receiverPhone;
	}
	/** 发货人 */
	public String getShipper() {
		return shipper;
	}
	/** 发货人 */
	public void setShipper(String shipper) {
		this.shipper=shipper;
	}
	/** 发货人电话 */
	public String getShipperPhone() {
		return shipperPhone;
	}
	/** 发货人电话 */
	public void setShipperPhone(String shipperPhone) {
		this.shipperPhone=shipperPhone;
	}
	/** 数量单位 */
	public String getQuantity() {
		return quantity;
	}
	/** 数量单位 */
	public void setQuantity(String quantity) {
		this.quantity=quantity;
	}
	/** 货款 */
	public BigDecimal getMoney() {
		return money;
	}
	/** 货款 */
	public void setMoney(BigDecimal money) {
		this.money=money;
	}
	/** 运费 */
	public BigDecimal getFreight() {
		return freight;
	}
	/** 运费 */
	public void setFreight(BigDecimal freight) {
		this.freight=freight;
	}
	/** 合计 */
	public BigDecimal getTotal() {
		return total;
	}
	/** 合计 */
	public void setTotal(BigDecimal total) {
		this.total=total;
	}
	/** 货运方式 */
	public String getFreightType() {
		return freightType;
	}
	/** 货运方式 */
	public void setFreightType(String freightType) {
		this.freightType=freightType;
	}
	/** 司机 */
	public String getDriver() {
		return driver;
	}
	/** 司机 */
	public void setDriver(String driver) {
		this.driver=driver;
	}
	/** 备注 */
	public String getRemarks() {
		return remarks;
	}
	/** 备注 */
	public void setRemarks(String remarks) {
		this.remarks=remarks;
	}
	/** 单据状态 */
	public String getBillState() {
		return billState;
	}
	/** 单据状态 */
	public void setBillState(String billState) {
		this.billState=billState;
	}
	/** 收款状态 */
	public String getReceivablesState() {
		return receivablesState;
	}
	/** 收款状态 */
	public void setReceivablesState(String receivablesState) {
		this.receivablesState=receivablesState;
	}
	/** 收款方式 */
	public String getReceivablesType() {
		return receivablesType;
	}
	/** 收款方式 */
	public void setReceivablesType(String receivablesType) {
		this.receivablesType=receivablesType;
	}
	/** 收款日期 */
	public Date getReceivablesDate() {
		return receivablesDate;
	}
	/** 收款日期 */
	public void setReceivablesDate(Date receivablesDate) {
		this.receivablesDate=receivablesDate;
	}
	/** 收款日期字符 **/
	public String getReceivablesDateStr() {
		return receivablesDateStr;
	}
	/** 收款日期字符 **/
	public void setReceivablesDateStr(String receivablesDateStr) {
		this.receivablesDateStr=receivablesDateStr;
	}
	/** 收款日期开始 **/
	public String getReceivablesDateBeginStr() {
		return receivablesDateBeginStr;
	}
	/** 收款日期开始 **/
	public void setReceivablesDateBeginStr(String receivablesDateBeginStr) {
		this.receivablesDateBeginStr=receivablesDateBeginStr;
	}
	/** 收款日期结束 **/
	public String getReceivablesDateEndStr() {
		return receivablesDateEndStr;
	}
	/** 收款日期结束 **/
	public void setReceivablesDateEndStr(String receivablesDateEndStr) {
		this.receivablesDateEndStr=receivablesDateEndStr;
	}
	/** 付款状态 */
	public String getPaymentState() {
		return paymentState;
	}
	/** 付款状态 */
	public void setPaymentState(String paymentState) {
		this.paymentState=paymentState;
	}
	/** 付款方式 */
	public String getPaymentType() {
		return paymentType;
	}
	/** 付款方式 */
	public void setPaymentType(String paymentType) {
		this.paymentType=paymentType;
	}
	/** 付款日期 */
	public Date getPaymentDate() {
		return paymentDate;
	}
	/** 付款日期 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate=paymentDate;
	}
	/** 付款日期字符 **/
	public String getPaymentDateStr() {
		return paymentDateStr;
	}
	/** 付款日期字符 **/
	public void setPaymentDateStr(String paymentDateStr) {
		this.paymentDateStr=paymentDateStr;
	}
	/** 付款日期开始 **/
	public String getPaymentDateBeginStr() {
		return paymentDateBeginStr;
	}
	/** 付款日期开始 **/
	public void setPaymentDateBeginStr(String paymentDateBeginStr) {
		this.paymentDateBeginStr=paymentDateBeginStr;
	}
	/** 付款日期结束 **/
	public String getPaymentDateEndStr() {
		return paymentDateEndStr;
	}
	/** 付款日期结束 **/
	public void setPaymentDateEndStr(String paymentDateEndStr) {
		this.paymentDateEndStr=paymentDateEndStr;
	}
	/** 预留1 */
	public String getPriceSpare1() {
		return priceSpare1;
	}
	/** 预留1 */
	public void setPriceSpare1(String priceSpare1) {
		this.priceSpare1=priceSpare1;
	}
	/** 预留2 */
	public String getPriceSpare2() {
		return priceSpare2;
	}
	/** 预留2 */
	public void setPriceSpare2(String priceSpare2) {
		this.priceSpare2=priceSpare2;
	}
	/** 预留3 */
	public String getPriceSpare3() {
		return priceSpare3;
	}
	/** 预留3 */
	public void setPriceSpare3(String priceSpare3) {
		this.priceSpare3=priceSpare3;
	}
	/** 预留4 */
	public String getPriceSpare4() {
		return priceSpare4;
	}
	/** 预留4 */
	public void setPriceSpare4(String priceSpare4) {
		this.priceSpare4=priceSpare4;
	}
	/** 预留5 */
	public String getPriceSpare5() {
		return priceSpare5;
	}
	/** 预留5 */
	public void setPriceSpare5(String priceSpare5) {
		this.priceSpare5=priceSpare5;
	}
	/** 预留6 */
	public String getPriceSpare6() {
		return priceSpare6;
	}
	/** 预留6 */
	public void setPriceSpare6(String priceSpare6) {
		this.priceSpare6=priceSpare6;
	}
	/** 预留7 */
	public String getPriceSpare7() {
		return priceSpare7;
	}
	/** 预留7 */
	public void setPriceSpare7(String priceSpare7) {
		this.priceSpare7=priceSpare7;
	}
	/** 预留8 */
	public String getPriceSpare8() {
		return priceSpare8;
	}
	/** 预留8 */
	public void setPriceSpare8(String priceSpare8) {
		this.priceSpare8=priceSpare8;
	}
	/** 预留9 */
	public String getPriceSpare9() {
		return priceSpare9;
	}
	/** 预留9 */
	public void setPriceSpare9(String priceSpare9) {
		this.priceSpare9=priceSpare9;
	}
	/** 预留10 */
	public String getPriceSpare10() {
		return priceSpare10;
	}
	/** 预留10 */
	public void setPriceSpare10(String priceSpare10) {
		this.priceSpare10=priceSpare10;
	}
	/** 创建人 */
	public String getPubCreatePerson() {
		return pubCreatePerson;
	}
	/** 创建人 */
	public void setPubCreatePerson(String pubCreatePerson) {
		this.pubCreatePerson=pubCreatePerson;
	}
	/** 创建时间 */
	public Date getPubCreateDate() {
		return pubCreateDate;
	}
	/** 创建时间 */
	public void setPubCreateDate(Date pubCreateDate) {
		this.pubCreateDate=pubCreateDate;
	}
	/** 创建时间字符 **/
	public String getPubCreateDateStr() {
		return pubCreateDateStr;
	}
	/** 创建时间字符 **/
	public void setPubCreateDateStr(String pubCreateDateStr) {
		this.pubCreateDateStr=pubCreateDateStr;
	}
	/** 创建时间开始 **/
	public String getPubCreateDateBeginStr() {
		return pubCreateDateBeginStr;
	}
	/** 创建时间开始 **/
	public void setPubCreateDateBeginStr(String pubCreateDateBeginStr) {
		this.pubCreateDateBeginStr=pubCreateDateBeginStr;
	}
	/** 创建时间结束 **/
	public String getPubCreateDateEndStr() {
		return pubCreateDateEndStr;
	}
	/** 创建时间结束 **/
	public void setPubCreateDateEndStr(String pubCreateDateEndStr) {
		this.pubCreateDateEndStr=pubCreateDateEndStr;
	}
	/** 最后修改人 */
	public String getPubModiPerson() {
		return pubModiPerson;
	}
	/** 最后修改人 */
	public void setPubModiPerson(String pubModiPerson) {
		this.pubModiPerson=pubModiPerson;
	}
	/** 最后修改时间 */
	public Date getPubModiDate() {
		return pubModiDate;
	}
	/** 最后修改时间 */
	public void setPubModiDate(Date pubModiDate) {
		this.pubModiDate=pubModiDate;
	}
	/** 最后修改时间字符 **/
	public String getPubModiDateStr() {
		return pubModiDateStr;
	}
	/** 最后修改时间字符 **/
	public void setPubModiDateStr(String pubModiDateStr) {
		this.pubModiDateStr=pubModiDateStr;
	}
	/** 最后修改时间开始 **/
	public String getPubModiDateBeginStr() {
		return pubModiDateBeginStr;
	}
	/** 最后修改时间开始 **/
	public void setPubModiDateBeginStr(String pubModiDateBeginStr) {
		this.pubModiDateBeginStr=pubModiDateBeginStr;
	}
	/** 最后修改时间结束 **/
	public String getPubModiDateEndStr() {
		return pubModiDateEndStr;
	}
	/** 最后修改时间结束 **/
	public void setPubModiDateEndStr(String pubModiDateEndStr) {
		this.pubModiDateEndStr=pubModiDateEndStr;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
}
