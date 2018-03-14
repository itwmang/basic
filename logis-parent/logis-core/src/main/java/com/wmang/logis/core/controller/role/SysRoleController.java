package com.wmang.logis.core.controller.role;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wmang.logis.core.biz.role.SysRoleBiz;
import com.wmang.logis.core.controller.BaseController;
import com.wmang.logis.mode.dto.vo.role.SysRoleVO;
import com.wmang.logis.mode.utils.FastJSONHelper;
import com.wmang.logis.mode.utils.ListCarrier;
import com.wmang.logis.mode.utils.ValueUtil;
import com.wmang.logis.mode.utils.base.BasePageResponse;
import com.wmang.logis.mode.utils.base.BaseResponse;
import com.wmang.logis.mode.utils.base.BodyData;

 /**
 * Title: 系统角色
 * Description: 系统角色Controller类
 * @Author: wmang
 * @CreateDate: 2018-03
 * @version 1.0 初稿
 */
@Controller
public class SysRoleController extends BaseController{
	
	@Autowired
	private SysRoleBiz sysRoleBiz;
	
	/** 新增_打开界面 */
	@RequestMapping(value = "/role/sysRole/add", method = RequestMethod.GET)
	public String toadd() throws Exception {
		return "/role/sysRole/sysRole_add";
	}
	
	/** 新增 */
	@RequestMapping(value = "/role/sysRole/save", method = RequestMethod.POST)
	@ResponseBody
	public BodyData save(@RequestBody SysRoleVO vo) throws Exception {
		BaseResponse<SysRoleVO> response=sysRoleBiz.save(vo, "");
		return super.success(response);
	}
	
	/** 列表页请求数据 */
	@ResponseBody
	@RequestMapping(value = "/role/sysRole/listrole", method = RequestMethod.GET)
	public BasePageResponse listrole(@RequestParam String queryrole, int pageIndex, int pageSize) throws Exception {
		
		SysRoleVO vo = new SysRoleVO();
		if(StringUtils.isNotBlank(queryrole)){
			vo =  FastJSONHelper.deserialize(new String(queryrole.getBytes("iso-8859-1"),"utf-8"), SysRoleVO.class);
		}
		BasePageResponse res = sysRoleBiz.findAllRole(vo, pageIndex, pageSize);
		return res;
	}
	
	/** 更新_打开界面 */
	@RequestMapping(value = "/role/sysRole/edit/{id}", method = RequestMethod.GET)
	public String toupdate(@PathVariable("id") Integer id,Model model) throws Exception {
		BaseResponse<SysRoleVO> response=sysRoleBiz.findOne(id);
		model.addAttribute("modelFromServer", FastJSONHelper.serialize(response.getReturnObject()));
		return "/role/sysRole/sysRole_edit";
	}
	/** 查看_打开界面 */
	@RequestMapping(value = "/role/sysRole/view/{id}", method = RequestMethod.GET)
	public String toview(@PathVariable("id") Integer id,Model model) throws Exception {
		BaseResponse<SysRoleVO> response=sysRoleBiz.findOne(id);
		model.addAttribute("modelFromServer", FastJSONHelper.serialize(response.getReturnObject()));
		model.addAttribute("operate", "view");
		return "/role/sysRole/sysRole_edit";
	}
	
	/** 更新 */
	@RequestMapping(value = "/role/sysRole/update", method = RequestMethod.POST)
	@ResponseBody
	public BodyData update(@RequestBody SysRoleVO vo) throws Exception {
		BaseResponse<SysRoleVO> response=sysRoleBiz.update(vo, "");
		return super.success(response);
	}
	
	/** 删除 */
	@RequestMapping(value = "/role/sysRole/delete", method = RequestMethod.POST)
	@ResponseBody
	public BodyData delete(@RequestParam("ids")  String ids) throws Exception {
		List<Integer> listId=new ListCarrier<String, Integer>() {
			@Override
			public Integer carry(String source) throws Exception {
				return ValueUtil.toInt(source);
			}
		}.carryList(Arrays.asList(ids.split(",")));
		BaseResponse<List<Integer>> response=sysRoleBiz.delete(listId, "");
		return super.success(response);
	}
}
