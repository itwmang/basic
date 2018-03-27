package com.wmang.logis.core.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.wmang.logis.mode.constant.Constants;
import com.wmang.logis.mode.exception.BaseException;
import com.wmang.logis.mode.utils.FastJSONHelper;
import com.wmang.logis.mode.utils.base.BodyData;

 /**
 * Title: 客户主数据
 * Description: 客户主数据Controller类
 * @Author: wmang
 * @CreateDate: 2018-01
 * @version 1.0 初稿
 */
@Controller
public class BaseController  {
	static final Logger _Logger = LoggerFactory.getLogger(BaseController.class);
	
	protected HttpServletRequest request_;
	protected HttpServletResponse response_;
	protected HttpSession session_;
	@ModelAttribute
	public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
		this.request_ = request;
		this.response_ = response;
		this.session_ = request.getSession();
	}
	
	
	protected String getAccount() {
		String account = (String) session_.getAttribute(Constants.user_account);
		if(StringUtils.isBlank(account)){
			throw new BaseException("999999","登录超时请重新登录");
		}
		return account;
	}

	@ExceptionHandler({ BaseException.class, Exception.class })
	public ModelAndView handleBaseException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
		_Logger.warn(request.getRequestURI(), ex);
		boolean isBaseException = false;
		BaseException baseException = null;

		if (ex instanceof BaseException) {
			isBaseException = true;
			baseException = (BaseException) ex;
		}
		
		BodyData bodyData = new BodyData();
		bodyData.setStatus(Boolean.valueOf(false));
		if (isBaseException) {
			bodyData.setError(baseException.getErrorCode(), baseException.getErrorMsg());
		}else{
			bodyData.setError("请求调用失败"+baseException.getErrorCode(),"");
		}

		try {
			response.setHeader("Content-type", "text/plain;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter e = response.getWriter();
			e.write(FastJSONHelper.serialize(bodyData));
			e.flush();
		} catch (IOException arg14) {
			arg14.printStackTrace();
		}
		return null;
	}
	
	
	
	public BodyData success(Object response) {
		// TODO Auto-generated method stub
		BodyData b = new BodyData();
		b.setStatus(true);
		b.setContent(response);
		return b;
	}
	
}
