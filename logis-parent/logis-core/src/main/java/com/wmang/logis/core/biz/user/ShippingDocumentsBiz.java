package com.wmang.logis.core.biz.user;

import java.util.Date;
import java.util.List;

import com.wmang.logis.mode.dto.vo.user.ShippingDocumentsVO;
import com.wmang.logis.mode.utils.base.BaseMgrBiz;
import com.wmang.logis.mode.utils.base.BasePageResponse;
import com.wmang.logis.mode.utils.base.BaseResponse;

 /**
 * Title: 货运单据
 * Description: 货运单据Biz类
 * @Author: wmang
 * @CreateDate: 2018-02
 * @version 1.0 初稿
 */
public interface ShippingDocumentsBiz extends BaseMgrBiz<ShippingDocumentsVO,Integer> {

	BasePageResponse findAllUser(ShippingDocumentsVO vo, int pageIndex, int pageSize);

	BaseResponse<ShippingDocumentsVO> doBillCheck(List<Integer> listId, String billState) throws Exception;

	BaseResponse<ShippingDocumentsVO> doReceivables(List<Integer> listId, String receivablesType, Date receivablesDate,
			String receivablesState) throws Exception;

	BaseResponse<ShippingDocumentsVO> doPayment(List<Integer> listId, String paymentType, Date paymentDate_,
			String paymentState) throws Exception;

}
