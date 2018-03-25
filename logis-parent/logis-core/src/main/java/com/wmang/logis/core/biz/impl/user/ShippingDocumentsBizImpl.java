package com.wmang.logis.core.biz.impl.user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wmang.logis.core.biz.user.ShippingDocumentsBiz;
import com.wmang.logis.core.exchanger.user.ShippingDocumentsExchanger;
import com.wmang.logis.core.service.user.ShippingDocumentsService;
import com.wmang.logis.mode.dto.vo.user.ShippingDocumentsVO;
import com.wmang.logis.mode.entity.user.ShippingDocuments;
import com.wmang.logis.mode.exception.BaseException;
import com.wmang.logis.mode.utils.ValueUtil;
import com.wmang.logis.mode.utils.base.AbstractBaseMgrBiz;
import com.wmang.logis.mode.utils.base.AbstractExchanger;
import com.wmang.logis.mode.utils.base.BasePageResponse;
import com.wmang.logis.mode.utils.base.BaseResponse;
import com.wmang.logis.mode.utils.base.BaseService;
import com.wmang.logis.mode.utils.pagehelper.PageHelper;

/**
 * Title: 货运单据
 * <p>
 * Description: 货运单据BizImpl类
 * </p>
 * 
 * @Author: wmang
 * @CreateDate: 2018-02
 * @version 1.0 初稿
 */
@Service("shippingDocumentsBiz")
public class ShippingDocumentsBizImpl extends AbstractBaseMgrBiz<ShippingDocumentsVO, ShippingDocuments, Integer>
		implements ShippingDocumentsBiz {

	protected static Logger logger = LoggerFactory.getLogger(ShippingDocumentsBizImpl.class);

	protected static List<String> updateColumns = Arrays.asList(ShippingDocuments.orgCode_, ShippingDocuments.billNo_,
			ShippingDocuments.billDate_, ShippingDocuments.receiver_, ShippingDocuments.receiverPhone_,
			ShippingDocuments.shipper_, ShippingDocuments.shipperPhone_, ShippingDocuments.quantity_,
			ShippingDocuments.money_, ShippingDocuments.freight_, ShippingDocuments.total_,
			ShippingDocuments.freightType_, ShippingDocuments.driver_, ShippingDocuments.remarks_,
			ShippingDocuments.billState_, ShippingDocuments.receivablesState_, ShippingDocuments.receivablesType_,
			ShippingDocuments.receivablesDate_, ShippingDocuments.paymentState_, ShippingDocuments.paymentType_,
			ShippingDocuments.paymentDate_, ShippingDocuments.priceSpare1_, ShippingDocuments.priceSpare2_,
			ShippingDocuments.priceSpare3_, ShippingDocuments.priceSpare4_, ShippingDocuments.priceSpare5_,
			ShippingDocuments.priceSpare6_, ShippingDocuments.priceSpare7_, ShippingDocuments.priceSpare8_,
			ShippingDocuments.priceSpare9_, ShippingDocuments.priceSpare10_, ShippingDocuments.pubCreatePerson_,
			ShippingDocuments.pubCreateDate_, ShippingDocuments.pubModiPerson_, ShippingDocuments.pubModiDate_);

	@Autowired
	private ShippingDocumentsService shippingDocumentsService;

	@Override
	public BaseService<ShippingDocuments, Integer> getBaseService() {
		return shippingDocumentsService;
	}

	@Override
	public AbstractExchanger<ShippingDocumentsVO, ShippingDocuments> getExchanger() {
		return new ShippingDocumentsExchanger();
	}

	@Override
	public List<String> getUpdateColumns() {
		return updateColumns;
	}

	@Override
	public BaseResponse<ShippingDocumentsVO> update(ShippingDocumentsVO vo, String userId) throws Exception {
		// TODO: vo.setOther...
		return super.update(vo, userId);
	}

	@Override
	public BaseResponse<ShippingDocumentsVO> save(ShippingDocumentsVO vo, String userId) throws Exception {
		// TODO: vo.setOther...
		return super.save(vo, userId);
	}

	@Override
	public BasePageResponse findAllUser(ShippingDocumentsVO vo, int pageIndex, int pageSize) {
		// 默认时间
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String defaultBeginDate = "1970-01-01";
		String defaultEndDate = sdf.format(currentDate);

		BasePageResponse res = new BasePageResponse();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			if (StringUtils.isNotBlank(vo.getQueryCustomer())) {
				map.put(ShippingDocuments.receiver_, "%"+vo.getQueryCustomer()+"%");
				map.put(ShippingDocuments.shipper_, "%"+vo.getQueryCustomer()+"%");
			}
			if (vo.getBillNo() != null) {
				map.put(ShippingDocuments.billNo_, "%"+vo.getBillNo()+"%");
			}
			if (StringUtils.isNotBlank(vo.getFreightType())) {
				map.put(ShippingDocuments.freightType_, vo.getFreightType());
			}
			if (StringUtils.isNotBlank(vo.getReceivablesState())) {
				map.put(ShippingDocuments.receivablesState_, vo.getReceivablesState());
			}
			if (StringUtils.isNotBlank(vo.getReceivablesType())) {
				map.put(ShippingDocuments.receivablesType_, vo.getReceivablesType());
			}
			if (StringUtils.isNotBlank(vo.getPaymentState())) {
				map.put(ShippingDocuments.paymentState_, vo.getPaymentState());
			}
			if (StringUtils.isNotBlank(vo.getPaymentType())) {
				map.put(ShippingDocuments.paymentType_, vo.getPaymentType());
			}
			String billDateBeginStr = "".equals(vo.getBillDateBeginStr()) ? defaultBeginDate : vo.getBillDateBeginStr();
			String billDateEndStr = "".equals(vo.getBillDateEndStr()) ? defaultEndDate + " 23:59:59"
					: vo.getBillDateEndStr() + " 23:59:59";
			if (!ValueUtil.isEmpty(billDateBeginStr) && !ValueUtil.isEmpty(billDateEndStr)) {
				map.put("billDateBeginStr",billDateBeginStr);
				map.put("billDateEndStr", billDateEndStr);
			}
			if (pageIndex > 0 && pageSize > 0) {
				PageHelper.startPage(pageIndex, pageSize,false);
			}
			List<ShippingDocuments> list = shippingDocumentsService.listByMap(map);
			int count = shippingDocumentsService.listByMapCount(map);

			res.setCount(count);
			res.setData(list);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return res;
	}

	// 对单方法
	@Override
	public BaseResponse<ShippingDocumentsVO> doBillCheck(List<Integer> listId, String billState) throws Exception {
		BaseResponse<ShippingDocumentsVO> res = new BaseResponse<ShippingDocumentsVO>();
		List<String> bill = new ArrayList<String>();
		bill.add("billState");
		bill.add("pubModiPerson");
		bill.add("pubModiDate");
		for (Integer id : listId) {
			ShippingDocuments vo = new ShippingDocuments();
			vo.setRowId(id);
			vo.setBillState(billState);
			vo.setPubModiPerson("wx");
			vo.setPubModiDate(new Date());
			shippingDocumentsService.updateSelected(vo, bill);
		}
		return res;
	}

	// 收款方法
	@Override
	public BaseResponse<ShippingDocumentsVO> doReceivables(List<Integer> listId, String receivablesType,
			Date receivablesDate, String receivablesState) throws Exception {
		BaseResponse<ShippingDocumentsVO> res = new BaseResponse<ShippingDocumentsVO>();
		List<String> rec = new ArrayList<String>();
		rec.add("receivablesType");
		rec.add("receivablesState");
		rec.add("receivablesDate");
		rec.add("pubModiPerson");
		rec.add("pubModiDate");
		for (Integer id : listId) {
			ShippingDocuments vo = new ShippingDocuments();
			vo.setRowId(id);
			vo.setReceivablesState(receivablesState);
			vo.setReceivablesDate(receivablesDate);
			vo.setReceivablesType(receivablesType);
			vo.setPubModiPerson("wx");
			vo.setPubModiDate(new Date());
			shippingDocumentsService.updateSelected(vo, rec);
		}
		return res;
	}

	// 付款方法
	@Override
	public BaseResponse<ShippingDocumentsVO> doPayment(List<Integer> listId, String paymentType, Date paymentDate_,
			String paymentState) throws Exception {
		BaseResponse<ShippingDocumentsVO> res = new BaseResponse<ShippingDocumentsVO>();
		List<String> pay = new ArrayList<String>();
		pay.add("paymentType");
		pay.add("paymentDate");
		pay.add("paymentState");
		pay.add("pubModiPerson");
		pay.add("pubModiDate");
		for (Integer id : listId) {
			ShippingDocuments vo = new ShippingDocuments();
			vo.setRowId(id);
			vo.setPaymentDate(paymentDate_);
			vo.setPaymentState(paymentState);
			vo.setPaymentType(paymentType);
			vo.setPubModiPerson("wx");
			vo.setPubModiDate(new Date());
			shippingDocumentsService.updateSelected(vo, pay);
		}
		return res;
	}

	@Override
	public BaseResponse<ShippingDocumentsVO> saveOrUpdate(ShippingDocumentsVO vo) throws Exception {
		BaseResponse<ShippingDocumentsVO> res = new BaseResponse<ShippingDocumentsVO>();
		List<ShippingDocuments> repeat = new ArrayList<>();
		Integer rowId = vo.getRowId();
		Integer billNo = vo.getBillNo();

		try {
			if (vo.getRowId() != null) {
				repeat = shippingDocumentsService.checkNo(billNo);
			} else {
				repeat = shippingDocumentsService.checkNo_(billNo, rowId);
			}

			if (!CollectionUtils.isEmpty(repeat)) {
				throw new BaseException("报错信息", "单据号重复");
			}

			if (vo.getRowId() != null) {
				vo.setPubModiPerson("wx1");
				vo.setPubModiDate(new Date());
				res = super.update(vo, "");
			} else {
				vo.setOrgCode("1");
				vo.setPubCreatePerson("wx");
				vo.setPubCreateDate(new Date());
				vo.setPubModiPerson("wx");
				vo.setPubModiDate(new Date());
				res = super.save(vo, "");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return res;
	}

	@Override
	public Integer getBillNo() {
		Integer billNo = shippingDocumentsService.getMaxBillNo();
		if(null != billNo && billNo != 0 && billNo >= 1000000){
			billNo+=1;
		}else{
			billNo = 1000000;
		}
		return billNo;
	}
}
