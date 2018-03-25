package com.wmang.logis.core.service.impl.user;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wmang.logis.core.dao.user.ShippingDocumentsExtMapper;
import com.wmang.logis.core.dao.user.ShippingDocumentsMapper;
import com.wmang.logis.core.service.user.ShippingDocumentsService;
import com.wmang.logis.mode.entity.user.ShippingDocuments;
import com.wmang.logis.mode.utils.base.AbstractService;
import com.wmang.logis.mode.utils.base.BaseMapper;

 /**
 * Title: 货运单据
 * Description: 货运单据ServiceImpl类
 * @Author: wmang
 * @CreateDate: 2018-02
 * @version 1.0 初稿
 */
@Service("shippingDocumentsService")
public class ShippingDocumentsServiceImpl extends AbstractService<ShippingDocuments, Integer> implements ShippingDocumentsService {
	
	protected static Logger logger = LoggerFactory.getLogger(ShippingDocumentsServiceImpl.class);
	
	@Autowired
	private ShippingDocumentsMapper shippingDocumentsMapper;
	
	@Autowired
	private ShippingDocumentsExtMapper shippingDocumentsExtMapper;

	@Override
	public BaseMapper<ShippingDocuments, Integer> getBaseMapper() throws Exception {
		return shippingDocumentsMapper;
	}

	@Override
	public List<ShippingDocuments> checkNo(Integer billNo) {
		return shippingDocumentsExtMapper.checkNo(billNo);
	}

	@Override
	public List<ShippingDocuments> checkNo_(Integer billNo, Integer rowId) {
		return shippingDocumentsExtMapper.checkNo_(billNo,rowId);
	}

	@Override
	public List<ShippingDocuments> listByMap(Map<String, Object> map) {
		return shippingDocumentsExtMapper.listByMap(map);
	}

	@Override
	public int listByMapCount(Map<String, Object> map) {
		return shippingDocumentsExtMapper.listByMapCount(map);
	}

	@Override
	public Integer getMaxBillNo() {
		return shippingDocumentsExtMapper.getMaxBillNo();
	}

}
