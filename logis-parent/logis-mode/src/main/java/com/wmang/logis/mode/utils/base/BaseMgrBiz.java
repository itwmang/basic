package com.wmang.logis.mode.utils.base;

import java.util.List;

import com.wmang.logis.mode.dto.vo.user.SysUserVO;


/**
 * @Description
 * @department 东软集团_流程IT_售后系统_电子商务产品
 * @author 陈志光
 * @date 2015年11月5日
 */
public interface BaseMgrBiz<V,P> {
	
	/**
	 * @Description 根据主键找实体类
	 */
	public BaseResponse<V> findOne(P id) throws Exception;
	
	/**
	 * @Description 新增
	 */
	public BaseResponse<V> save(V vo,String userId) throws Exception;
	/**
	 * @Description 插入数据,id使用序列
	 */
	public BaseResponse<V> insertWithSequence(V vo, String userId) throws Exception;

	/**
	 * @Description 更新
	 */
	public BaseResponse<V> update(V vo,String userId) throws Exception;
	
	/**
	 * @Description 删除
	 */
	public BaseResponse<List<P>> delete(List<P> ids,String userId) throws Exception;

	List<SysUserVO> findAllUser(SysUserVO vo, int pageIndex, int pageSize);

	
}
