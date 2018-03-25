package com.wmang.logis.core.dao.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.wmang.logis.mode.entity.user.ShippingDocuments;

 /**
 * Title: 货运单据
 * Description: 货运单据ExtMapper类
 * @Author: wmang
 * @CreateDate: 2018-02
 * @version 1.0 初稿
 */
@Component("shippingDocumentsExtMapper")
public interface ShippingDocumentsExtMapper {

	List<ShippingDocuments> checkNo(@Param("billNo")Integer billNo);

	List<ShippingDocuments> checkNo_(@Param("billNo")Integer billNo, @Param("rowId")Integer rowId);

	List<ShippingDocuments> listByMap(@Param("map")Map<String, Object> map);

	int listByMapCount(@Param("map")Map<String, Object> map);

	Integer getMaxBillNo();
	
}
