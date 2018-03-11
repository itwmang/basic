package com.wmang.logis.core.biz.impl.user;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wmang.logis.core.biz.user.SysUserBiz;
import com.wmang.logis.core.service.user.SysUserService;
import com.wmang.logis.mode.dto.vo.user.SysUserVO;
import com.wmang.logis.mode.entity.user.SysUser;
import com.wmang.logis.mode.utils.base.AbstractBaseMgrBiz;
import com.wmang.logis.mode.utils.base.AbstractExchanger;
import com.wmang.logis.mode.utils.base.BasePageResponse;
import com.wmang.logis.mode.utils.base.BaseResponse;
import com.wmang.logis.mode.utils.base.BaseService;
import com.wmang.logis.mode.utils.base.CommonExample;
import com.wmang.logis.mode.utils.pagehelper.Page;
import com.wmang.logis.mode.utils.pagehelper.PageHelper;

/**
 * Title: 客户主数据
 * <p>
 * Description: 客户主数据BizImpl类
 * </p>
 * 
 * @Author: wmang
 * @CreateDate: 2018-01
 * @version 1.0 初稿
 */
@Service("sysUserBiz")
public class SysUserBizImpl extends AbstractBaseMgrBiz<SysUserVO, SysUser, Integer> implements SysUserBiz {

	protected static Logger logger = LoggerFactory.getLogger(SysUserBizImpl.class);


	@Autowired
	private SysUserService sysUserService;

	@Override
	public BaseService<SysUser, Integer> getBaseService() {
		return sysUserService;
	}


	@Override
	public BaseResponse<SysUserVO> update(SysUserVO vo, String userId) throws Exception {
		// TODO: vo.setOther...
		return super.update(vo, userId);
	}

	@Override
	public BaseResponse<SysUserVO> save(SysUserVO vo, String userId) throws Exception {
		// TODO: vo.setOther...
		return super.save(vo, userId);
	}

	@Override
	public BasePageResponse findAllUser(SysUserVO vo, int pageIndex, int pageSize) {
		BasePageResponse res = new BasePageResponse();
//		List<SysUserVO> listvo = new ArrayList<SysUserVO>();
		try {
			CommonExample example = new CommonExample();
			if (StringUtils.isNotBlank(vo.getAccount())) {
				example.andLike(SysUser.account_, vo.getAccount());
			}
			if (StringUtils.isNotBlank(vo.getName_())) {
				example.andLike(SysUser.name__, vo.getName_());
			}
			if (pageIndex > 0 && pageSize > 0) {
				PageHelper.startPage(pageIndex, pageSize);
			}
			List<SysUser> list = sysUserService.listByCondition(example);
			
			if (CollectionUtils.isNotEmpty(list)) {
				if(list instanceof Page) {
					
					Page<SysUser> page = (Page<SysUser>) list;
					res.setCount(page.getTotal());
					res.setData(page.getResult());
				}
//				SysUserExchanger ex = new SysUserExchanger();
//				for (SysUser sysUser : list) {
//					listvo.add(ex.dbToVo(sysUser));
//				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return res;
	}


	@Override
	public AbstractExchanger<SysUserVO, SysUser> getExchanger() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<String> getUpdateColumns() {
		// TODO Auto-generated method stub
		return null;
	}

}
