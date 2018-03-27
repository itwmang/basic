package com.wmang.logis.core.controller.user;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wmang.logis.core.biz.user.ShippingDocumentsBiz;
import com.wmang.logis.core.controller.BaseController;
import com.wmang.logis.mode.dto.vo.user.ShippingDocumentsVO;
import com.wmang.logis.mode.utils.FastJSONHelper;
import com.wmang.logis.mode.utils.ListCarrier;
import com.wmang.logis.mode.utils.ValueUtil;
import com.wmang.logis.mode.utils.base.BasePageResponse;
import com.wmang.logis.mode.utils.base.BaseResponse;
import com.wmang.logis.mode.utils.base.BodyData;

/**
 * Title: 货运单据 Description: 货运单据Controller类
 * 
 * @Author: wmang
 * @CreateDate: 2018-02
 * @version 1.0 初稿
 */
@Controller
public class ShippingDocumentsController extends BaseController {

	@Autowired
	private ShippingDocumentsBiz shippingDocumentsBiz;

	/** 新增_打开界面 */
	@RequestMapping(value = "/user/shippingDocuments/add", method = RequestMethod.GET)
	public String toadd() throws Exception {
		return "/user/shippingDocuments/shippingDocuments_add";
	}

	/** 列表页请求数据 */
	@ResponseBody
	@RequestMapping(value = "/user/shippingDocuments/listdocument", method = RequestMethod.GET)
	public BasePageResponse listuser(@RequestParam String querydocument, int pageIndex, int pageSize) throws Exception {
		String querydocument_ = URLDecoder.decode(querydocument,"utf-8");
		ShippingDocumentsVO vo = FastJSONHelper.deserialize(querydocument_, ShippingDocumentsVO.class);
		BasePageResponse res = shippingDocumentsBiz.findAllUser(vo, pageIndex, pageSize);
		return res;
	}

	/** 新增 */
	@RequestMapping(value = "/user/shippingDocuments/save", method = RequestMethod.POST)
	@ResponseBody
	public BodyData save(@RequestBody ShippingDocumentsVO vo) throws Exception {
		BaseResponse<ShippingDocumentsVO> response = shippingDocumentsBiz.saveOrUpdate(vo,getAccount());
		return super.success(response);
	}

	/** 更新_获取数据 */
	@RequestMapping(value = "/user/shippingDocuments/edit/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BodyData toupdate(@PathVariable("id") Integer id) throws Exception {
		getAccount();
		BaseResponse<ShippingDocumentsVO> response = shippingDocumentsBiz.findOne(id);
		return super.success(response);
	}

	/** 查看_打开界面 */
	@RequestMapping(value = "/user/shippingDocuments/view/{id}", method = RequestMethod.GET)
	public String toview(@PathVariable("id") Integer id, Model model) throws Exception {
		getAccount();
		BaseResponse<ShippingDocumentsVO> response = shippingDocumentsBiz.findOne(id);
		model.addAttribute("modelFromServer", FastJSONHelper.serialize(response.getReturnObject()));
		model.addAttribute("operate", "view");
		return "/user/shippingDocuments/shippingDocuments_edit";
	}

	/** 更新 */
	@RequestMapping(value = "/user/shippingDocuments/update", method = RequestMethod.POST)
	@ResponseBody
	public BodyData update(@RequestBody ShippingDocumentsVO vo) throws Exception {
		BaseResponse<ShippingDocumentsVO> response = shippingDocumentsBiz.update(vo,getAccount());
		return super.success(response);
	}

	/** 删除 */
	@RequestMapping(value = "/user/shippingDocuments/delete", method = RequestMethod.POST)
	@ResponseBody
	public BodyData delete(@RequestParam("ids") String ids) throws Exception {
		List<Integer> listId = new ListCarrier<String, Integer>() {
			@Override
			public Integer carry(String source) throws Exception {
				return ValueUtil.toInt(source);
			}
		}.carryList(Arrays.asList(ids.split(",")));
		BaseResponse<List<Integer>> response = shippingDocumentsBiz.delete(listId,getAccount());
		return super.success(response);
	}

	/** 对单 */
	@RequestMapping(value = "/user/shippingDocuments/doBillCheck", method = RequestMethod.POST)
	@ResponseBody
	public BodyData doBillCheck(@RequestParam("ids") String ids, @RequestParam("billState") String billState)
			throws Exception {
		List<Integer> listId = new ListCarrier<String, Integer>() {
			@Override
			public Integer carry(String source) throws Exception {
				return ValueUtil.toInt(source);
			}
		}.carryList(Arrays.asList(ids.split(",")));
		BaseResponse<ShippingDocumentsVO> response = shippingDocumentsBiz.doBillCheck(listId, billState,getAccount());
		return super.success(response);
	}

	/** 收款 */
	@RequestMapping(value = "/user/shippingDocuments/doReceivables", method = RequestMethod.POST)
	@ResponseBody
	public BodyData doReceivables(@RequestParam("ids") String ids,
			@RequestParam("receivablesType") String receivablesType,
			@RequestParam("receivablesDate") String receivablesDate,
			@RequestParam("receivablesState") String receivablesState) throws Exception {
		List<Integer> listId = new ListCarrier<String, Integer>() {
			@Override
			public Integer carry(String source) throws Exception {
				return ValueUtil.toInt(source);
			}
		}.carryList(Arrays.asList(ids.split(",")));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date receivablesDate_ = sdf.parse(receivablesDate);

		BaseResponse<ShippingDocumentsVO> response = shippingDocumentsBiz.doReceivables(listId, receivablesType,
				receivablesDate_, receivablesState,getAccount());
		return super.success(response);
	}
	
	/** 付款 */
	@RequestMapping(value = "/user/shippingDocuments/doPayment", method = RequestMethod.POST)
	@ResponseBody
	public BodyData doPayment(@RequestParam("ids") String ids,
			@RequestParam("paymentType") String paymentType,
			@RequestParam("paymentDate") String paymentDate,
			@RequestParam("paymentState") String paymentState) throws Exception {
		List<Integer> listId = new ListCarrier<String, Integer>() {
			@Override
			public Integer carry(String source) throws Exception {
				return ValueUtil.toInt(source);
			}
		}.carryList(Arrays.asList(ids.split(",")));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date paymentDate_ = sdf.parse(paymentDate);
//		paymentType = new String(paymentType.getBytes("iso-8859-1"),"utf-8");
		BaseResponse<ShippingDocumentsVO> response = shippingDocumentsBiz.doPayment(listId, paymentType,
				paymentDate_, paymentState,getAccount());
		return super.success(response);
	}
	/** 获取最新单据编码 */
	@RequestMapping(value = "/user/shippingDocuments/getBillNo", method = RequestMethod.GET)
	@ResponseBody
	public BodyData getBillNo() throws Exception {
		getAccount();
		Integer billNo = shippingDocumentsBiz.getBillNo();
		return super.success(billNo);
	}
	
}
