package com.wmang.logis.core.service.user;

import java.util.List;
import java.util.Map;

import com.wmang.logis.mode.entity.user.ShippingDocuments;
import com.wmang.logis.mode.utils.base.BaseService;

 /**
 * Title: 货运单据
 * Description: 货运单据Service类
 * @Author: wmang
 * @CreateDate: 2018-02
 * @version 1.0 初稿
 */
public interface ShippingDocumentsService extends BaseService<ShippingDocuments,Integer> {

	List<ShippingDocuments> checkNo(Integer billNo);

	List<ShippingDocuments> checkNo_(Integer billNo, Integer rowId);

	List<ShippingDocuments> listByMap(Map<String,Object> map);

	int listByMapCount(Map<String, Object> map);

	Integer getMaxBillNo();


}