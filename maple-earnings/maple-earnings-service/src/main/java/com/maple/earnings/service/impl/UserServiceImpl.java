/**
 * MAPLE CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: MAPLE
 *
 * Copyright © 2017 MAPLE Corporation. All rights reserved.
 */
package com.maple.earnings.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maple.earnings.common.pojo.EasyUIDataGridResult;
import com.maple.earnings.mapper.EUserMapper;
import com.maple.earnings.pojo.EOrder;
import com.maple.earnings.pojo.EOrderExample;
import com.maple.earnings.pojo.EUser;
import com.maple.earnings.pojo.EUserExample;
import com.maple.earnings.pojo.EOrderExample.Criteria;
import com.maple.earnings.service.UserService;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
@Service
public class UserServiceImpl implements UserService {

	// ------- Constants (static final) ----------------------------------------

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------
	@Autowired
	private EUserMapper userMapper;
	// ------- Constructors ----------------------------------------------------

	// ------- Instance Methods (public) ---------------------------------------
	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public List<EUser> list() {
		List<EUser> users = new ArrayList<>();
		EUserExample example = new EUserExample();
		users = this.userMapper.selectByExample(example);
		return users;
	}
	public EasyUIDataGridResult list(int page, int rows) {
		PageHelper.startPage(page, rows);
		List<EUser> users = new ArrayList<>();
		EUserExample example = new EUserExample();
		users = this.userMapper.selectByExample(example);
		EasyUIDataGridResult results = new EasyUIDataGridResult();
		PageInfo<EUser> pageInfo = new PageInfo<>(users);
		results.setRows(users);
		results.setTotal(pageInfo.getTotal());
		return results;
	}
	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public EUser load(String taobao_user_id) {
		return this.userMapper.selectByPrimaryKey(taobao_user_id);
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public void register(EUser user) {
		this.userMapper.insert(user);
	}
	@Override
	public int updateExpreTime(long times) {
		int result=0;
		try{
        this.userMapper.updateExpreTime(times);	
        result=1;
		}catch (Exception ex){
		  System.out.println(ex);
		}
		return result;
	}
	@Override
	public int updateByPrimaryKeySelective(EUser user) {
		this.userMapper.updateByPrimaryKeySelective(user);
		return 1;
	}
	@Override
	public void createOrder(String userId) {
		this.userMapper.createOrder(userId);
	}
	@Override
	public void createTrade(String userId) {
		this.userMapper.createTrade(userId);
		
	}
	@Override
	public void createOrderReport(String userId) {
		this.userMapper.createOrderReport(userId);		
	}
	@Override
	public void createTradeHistory(String userId) {
		this.userMapper.createTradeHistory(userId);
		
	}
	@Override
	public int updateByPrimaryKey(EUser user) {
		// TODO Auto-generated method stub
		this.userMapper.updateByPrimaryKey(user);
		return 0;
	}
	@Override
	public EUser getUserByUserName(String taobao_user_nick) {
		// TODO Auto-generated method stub
		return this.userMapper.selectByUserName(taobao_user_nick);
	}
	@Override
	public void updateUserInfo(EUser user) {
		// TODO Auto-generated method stub
		this.userMapper.updateUserInfo(user);
	}
}
