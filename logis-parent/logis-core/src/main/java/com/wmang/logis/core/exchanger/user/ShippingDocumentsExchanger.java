package com.wmang.logis.core.exchanger.user;

import java.util.Map;

import com.wmang.logis.mode.utils.DateUtil;
import com.wmang.logis.mode.utils.ValueUtil;
import com.wmang.logis.mode.utils.base.AbstractExchanger;
import com.wmang.logis.mode.dto.vo.user.ShippingDocumentsVO;
import com.wmang.logis.mode.entity.user.ShippingDocuments;


 /**
 * Title: 货运单据
 * Description: 货运单据Exchanger类 
 * @Author: wmang
 * @CreateDate: 2018-03
 * @version 1.0 初稿
 */
public class ShippingDocumentsExchanger extends AbstractExchanger<ShippingDocumentsVO,ShippingDocuments> {
	
	@Override
	public void dbFillVo(ShippingDocuments db,ShippingDocumentsVO vo) {
		vo.setRowId(db.getRowId());
		vo.setOrgCode(db.getOrgCode());
		vo.setBillNo(db.getBillNo());
		vo.setBillDate(db.getBillDate());
		vo.setBillDateStr(DateUtil.DateToString(db.getBillDate(), "yyyy-MM-dd HH:mm:ss"));
		vo.setReceiver(db.getReceiver());
		vo.setReceiverPhone(db.getReceiverPhone());
		vo.setShipper(db.getShipper());
		vo.setShipperPhone(db.getShipperPhone());
		vo.setQuantity(db.getQuantity());
		vo.setMoney(db.getMoney());
		vo.setFreight(db.getFreight());
		vo.setTotal(db.getTotal());
		vo.setFreightType(db.getFreightType());
		vo.setDriver(db.getDriver());
		vo.setRemarks(db.getRemarks());
		vo.setBillState(db.getBillState());
		vo.setReceivablesState(db.getReceivablesState());
		vo.setReceivablesType(db.getReceivablesType());
		vo.setReceivablesDate(db.getReceivablesDate());
		vo.setReceivablesDateStr(DateUtil.DateToString(db.getReceivablesDate(), "yyyy-MM-dd HH:mm:ss"));
		vo.setPaymentState(db.getPaymentState());
		vo.setPaymentType(db.getPaymentType());
		vo.setPaymentDate(db.getPaymentDate());
		vo.setPaymentDateStr(DateUtil.DateToString(db.getPaymentDate(), "yyyy-MM-dd HH:mm:ss"));
		vo.setPriceSpare1(db.getPriceSpare1());
		vo.setPriceSpare2(db.getPriceSpare2());
		vo.setPriceSpare3(db.getPriceSpare3());
		vo.setPriceSpare4(db.getPriceSpare4());
		vo.setPriceSpare5(db.getPriceSpare5());
		vo.setPriceSpare6(db.getPriceSpare6());
		vo.setPriceSpare7(db.getPriceSpare7());
		vo.setPriceSpare8(db.getPriceSpare8());
		vo.setPriceSpare9(db.getPriceSpare9());
		vo.setPriceSpare10(db.getPriceSpare10());
		vo.setPubCreatePerson(db.getPubCreatePerson());
		vo.setPubCreateDate(db.getPubCreateDate());
		vo.setPubCreateDateStr(DateUtil.DateToString(db.getPubCreateDate(), "yyyy-MM-dd HH:mm:ss"));
		vo.setPubModiPerson(db.getPubModiPerson());
		vo.setPubModiDate(db.getPubModiDate());
		vo.setPubModiDateStr(DateUtil.DateToString(db.getPubModiDate(), "yyyy-MM-dd HH:mm:ss"));
	}
	
	@Override
	public void voFillDb(ShippingDocumentsVO vo,ShippingDocuments db) {
		db.setRowId(vo.getRowId());
		db.setOrgCode(vo.getOrgCode());
		db.setBillNo(vo.getBillNo());
		if (vo.getBillDate()!=null) {
			db.setBillDate(vo.getBillDate());
		} else {
			db.setBillDate(ValueUtil.toDateNull(vo.getBillDateStr()));
		}
		db.setReceiver(vo.getReceiver());
		db.setReceiverPhone(vo.getReceiverPhone());
		db.setShipper(vo.getShipper());
		db.setShipperPhone(vo.getShipperPhone());
		db.setQuantity(vo.getQuantity());
		db.setMoney(vo.getMoney());
		db.setFreight(vo.getFreight());
		db.setTotal(vo.getTotal());
		db.setFreightType(vo.getFreightType());
		db.setDriver(vo.getDriver());
		db.setRemarks(vo.getRemarks());
		db.setBillState(vo.getBillState());
		db.setReceivablesState(vo.getReceivablesState());
		db.setReceivablesType(vo.getReceivablesType());
		if (vo.getReceivablesDate()!=null) {
			db.setReceivablesDate(vo.getReceivablesDate());
		} else {
			db.setReceivablesDate(ValueUtil.toDateNull(vo.getReceivablesDateStr()));
		}
		db.setPaymentState(vo.getPaymentState());
		db.setPaymentType(vo.getPaymentType());
		if (vo.getPaymentDate()!=null) {
			db.setPaymentDate(vo.getPaymentDate());
		} else {
			db.setPaymentDate(ValueUtil.toDateNull(vo.getPaymentDateStr()));
		}
		db.setPriceSpare1(vo.getPriceSpare1());
		db.setPriceSpare2(vo.getPriceSpare2());
		db.setPriceSpare3(vo.getPriceSpare3());
		db.setPriceSpare4(vo.getPriceSpare4());
		db.setPriceSpare5(vo.getPriceSpare5());
		db.setPriceSpare6(vo.getPriceSpare6());
		db.setPriceSpare7(vo.getPriceSpare7());
		db.setPriceSpare8(vo.getPriceSpare8());
		db.setPriceSpare9(vo.getPriceSpare9());
		db.setPriceSpare10(vo.getPriceSpare10());
		db.setPubCreatePerson(vo.getPubCreatePerson());
		if (vo.getPubCreateDate()!=null) {
			db.setPubCreateDate(vo.getPubCreateDate());
		} else {
			db.setPubCreateDate(ValueUtil.toDateNull(vo.getPubCreateDateStr()));
		}
		db.setPubModiPerson(vo.getPubModiPerson());
		if (vo.getPubModiDate()!=null) {
			db.setPubModiDate(vo.getPubModiDate());
		} else {
			db.setPubModiDate(ValueUtil.toDateNull(vo.getPubModiDateStr()));
		}
	}
	
	@Override
	public void mapFillVo(Map<String,?> map,ShippingDocumentsVO vo) {
		vo.setRowId(ValueUtil.toIntNull(map.get("rowId")));
		vo.setOrgCode(ValueUtil.toStr(map.get("orgCode")));
		vo.setBillNo(ValueUtil.toIntNull(map.get("billNo")));
		vo.setBillDate(ValueUtil.toDateNull(map.get("billDate")));
		vo.setBillDateStr(DateUtil.DateToString(vo.getBillDate(), "yyyy-MM-dd HH:mm:ss"));
		vo.setReceiver(ValueUtil.toStr(map.get("receiver")));
		vo.setReceiverPhone(ValueUtil.toStr(map.get("receiverPhone")));
		vo.setShipper(ValueUtil.toStr(map.get("shipper")));
		vo.setShipperPhone(ValueUtil.toStr(map.get("shipperPhone")));
		vo.setQuantity(ValueUtil.toStr(map.get("quantity")));
		vo.setMoney(ValueUtil.toBigDecimalNull(map.get("money")));
		vo.setFreight(ValueUtil.toBigDecimalNull(map.get("freight")));
		vo.setTotal(ValueUtil.toBigDecimalNull(map.get("total")));
		vo.setFreightType(ValueUtil.toStr(map.get("freightType")));
		vo.setDriver(ValueUtil.toStr(map.get("driver")));
		vo.setRemarks(ValueUtil.toStr(map.get("remarks")));
		vo.setBillState(ValueUtil.toStr(map.get("billState")));
		vo.setReceivablesState(ValueUtil.toStr(map.get("receivablesState")));
		vo.setReceivablesType(ValueUtil.toStr(map.get("receivablesType")));
		vo.setReceivablesDate(ValueUtil.toDateNull(map.get("receivablesDate")));
		vo.setReceivablesDateStr(DateUtil.DateToString(vo.getReceivablesDate(), "yyyy-MM-dd HH:mm:ss"));
		vo.setPaymentState(ValueUtil.toStr(map.get("paymentState")));
		vo.setPaymentType(ValueUtil.toStr(map.get("paymentType")));
		vo.setPaymentDate(ValueUtil.toDateNull(map.get("paymentDate")));
		vo.setPaymentDateStr(DateUtil.DateToString(vo.getPaymentDate(), "yyyy-MM-dd HH:mm:ss"));
		vo.setPriceSpare1(ValueUtil.toStr(map.get("priceSpare1")));
		vo.setPriceSpare2(ValueUtil.toStr(map.get("priceSpare2")));
		vo.setPriceSpare3(ValueUtil.toStr(map.get("priceSpare3")));
		vo.setPriceSpare4(ValueUtil.toStr(map.get("priceSpare4")));
		vo.setPriceSpare5(ValueUtil.toStr(map.get("priceSpare5")));
		vo.setPriceSpare6(ValueUtil.toStr(map.get("priceSpare6")));
		vo.setPriceSpare7(ValueUtil.toStr(map.get("priceSpare7")));
		vo.setPriceSpare8(ValueUtil.toStr(map.get("priceSpare8")));
		vo.setPriceSpare9(ValueUtil.toStr(map.get("priceSpare9")));
		vo.setPriceSpare10(ValueUtil.toStr(map.get("priceSpare10")));
		vo.setPubCreatePerson(ValueUtil.toStr(map.get("pubCreatePerson")));
		vo.setPubCreateDate(ValueUtil.toDateNull(map.get("pubCreateDate")));
		vo.setPubCreateDateStr(DateUtil.DateToString(vo.getPubCreateDate(), "yyyy-MM-dd HH:mm:ss"));
		vo.setPubModiPerson(ValueUtil.toStr(map.get("pubModiPerson")));
		vo.setPubModiDate(ValueUtil.toDateNull(map.get("pubModiDate")));
		vo.setPubModiDateStr(DateUtil.DateToString(vo.getPubModiDate(), "yyyy-MM-dd HH:mm:ss"));
	}

	@Override
	public ShippingDocumentsVO newInstanceV() {
		return new ShippingDocumentsVO();
	}

	@Override
	public ShippingDocuments newInstanceD() {
		return new ShippingDocuments();
	}
	
	@Override
	public void dbFillPkVo(ShippingDocuments db, ShippingDocumentsVO vo) {
		vo.setRowId(db.getRowId());
	}
}
