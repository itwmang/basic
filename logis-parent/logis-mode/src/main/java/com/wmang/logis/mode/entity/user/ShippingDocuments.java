package com.wmang.logis.mode.entity.user;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

 /**
 * Title: 货运单据
 * Description: 货运单据Entity类,工具生成，请勿修改  
 * @Author: wmang
 * @CreateDate: 2018-03
 * @version 1.0 初稿
 */
public class ShippingDocuments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 单据ID */
	public final static String rowId_="row_id";
	/** 主体编码 */
	public final static String orgCode_="org_code";
	/** 单据号 */
	public final static String billNo_="bill_no";
	/** 单据日期 */
	public final static String billDate_="bill_date";
	/** 收货人 */
	public final static String receiver_="receiver";
	/** 收货人电话 */
	public final static String receiverPhone_="receiver_phone";
	/** 发货人 */
	public final static String shipper_="shipper";
	/** 发货人电话 */
	public final static String shipperPhone_="shipper_phone";
	/** 数量 */
	public final static String quantity_="quantity";
	/** 单位 */
	public final static String unit_="unit";
	/** 货款 */
	public final static String money_="money";
	/** 运费 */
	public final static String freight_="freight";
	/** 合计 */
	public final static String total_="total";
	/** 货运方式 */
	public final static String freightType_="freight_type";
	/** 司机 */
	public final static String driver_="driver";
	/** 备注 */
	public final static String remarks_="remarks";
	/** 单据状态 */
	public final static String billState_="bill_state";
	/** 收款状态 */
	public final static String receivablesState_="receivables_state";
	/** 收款方式 */
	public final static String receivablesType_="receivables_type";
	/** 收款日期 */
	public final static String receivablesDate_="receivables_date";
	/** 付款状态 */
	public final static String paymentState_="payment_state";
	/** 付款方式 */
	public final static String paymentType_="payment_type";
	/** 付款日期 */
	public final static String paymentDate_="payment_date";
	/** 预留1 */
	public final static String priceSpare1_="price_spare_1";
	/** 预留2 */
	public final static String priceSpare2_="price_spare_2";
	/** 预留3 */
	public final static String priceSpare3_="price_spare_3";
	/** 预留4 */
	public final static String priceSpare4_="price_spare_4";
	/** 预留5 */
	public final static String priceSpare5_="price_spare_5";
	/** 预留6 */
	public final static String priceSpare6_="price_spare_6";
	/** 预留7 */
	public final static String priceSpare7_="price_spare_7";
	/** 预留8 */
	public final static String priceSpare8_="price_spare_8";
	/** 预留9 */
	public final static String priceSpare9_="price_spare_9";
	/** 预留10 */
	public final static String priceSpare10_="price_spare_10";
	/** 创建人 */
	public final static String pubCreatePerson_="pub_create_person";
	/** 创建时间 */
	public final static String pubCreateDate_="pub_create_date";
	/** 最后修改人 */
	public final static String pubModiPerson_="pub_modi_person";
	/** 最后修改时间 */
	public final static String pubModiDate_="pub_modi_date";

	/** 单据ID */
	private Integer rowId;
	/** 主体编码 */
	private String orgCode;
	/** 单据号 */
	private Integer billNo;
	/** 单据日期 */
	private Date billDate;
	/** 收货人 */
	private String receiver;
	/** 收货人电话 */
	private String receiverPhone;
	/** 发货人 */
	private String shipper;
	/** 发货人电话 */
	private String shipperPhone;
	/** 数量 */
	private String quantity;
	/** 单位 */
	private String unit;
	/** 货款 */
	private BigDecimal money;
	/** 运费 */
	private BigDecimal freight;
	/** 合计 */
	private BigDecimal total;
	/** 货运方式 */
	private String freightType;
	/** 司机 */
	private String driver;
	/** 备注 */
	private String remarks;
	/** 单据状态 */
	private String billState;
	/** 收款状态 */
	private String receivablesState;
	/** 收款方式 */
	private String receivablesType;
	/** 收款日期 */
	private Date receivablesDate;
	/** 付款状态 */
	private String paymentState;
	/** 付款方式 */
	private String paymentType;
	/** 付款日期 */
	private Date paymentDate;
	/** 预留1 */
	private String priceSpare1;
	/** 预留2 */
	private String priceSpare2;
	/** 预留3 */
	private String priceSpare3;
	/** 预留4 */
	private String priceSpare4;
	/** 预留5 */
	private String priceSpare5;
	/** 预留6 */
	private String priceSpare6;
	/** 预留7 */
	private String priceSpare7;
	/** 预留8 */
	private String priceSpare8;
	/** 预留9 */
	private String priceSpare9;
	/** 预留10 */
	private String priceSpare10;
	/** 创建人 */
	private String pubCreatePerson;
	/** 创建时间 */
	private Date pubCreateDate;
	/** 最后修改人 */
	private String pubModiPerson;
	/** 最后修改时间 */
	private Date pubModiDate;
	
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
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	
}
