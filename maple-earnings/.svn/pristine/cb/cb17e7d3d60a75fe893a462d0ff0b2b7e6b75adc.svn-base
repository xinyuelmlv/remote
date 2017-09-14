package com.maple.earnings.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maple.earnings.common.pojo.EasyUIDataGridResult;
import com.maple.earnings.mapper.EUserMapper;
import com.maple.earnings.mapper.ManagerUserMapper;
import com.maple.earnings.pojo.EUser;
import com.maple.earnings.pojo.EUserExample;
import com.maple.earnings.pojo.ManagerUser;
import com.maple.earnings.pojo.ManagerUserExample;
import com.maple.earnings.pojo.ManagerUserExample.Criteria;
import com.maple.earnings.service.ManagerUserService;

@Service
public class ManagerUserImpl implements ManagerUserService {
	@Autowired
	private ManagerUserMapper ManagerUserMapper;

	@Override
	public EasyUIDataGridResult list(int page, int rows) {
		PageHelper.startPage(page, rows);
		List<ManagerUser> managerUsers = new ArrayList<>();
		ManagerUserExample example = new ManagerUserExample();
		managerUsers = this.ManagerUserMapper.selectByExample(example);
		EasyUIDataGridResult results = new EasyUIDataGridResult();
		PageInfo<ManagerUser> pageInfo = new PageInfo<>(managerUsers);
		results.setRows(managerUsers);
		results.setTotal(pageInfo.getTotal());
		return results;
	}

	@Override
	public void Update(ManagerUser managerUser) {
		try {
			this.ManagerUserMapper.updateByPrimaryKeySelective(managerUser);
		} catch (Exception ex) {
			System.out.println(ex);
		}


	}
	@Override
	public void save(ManagerUser managerUser) {
		try {
			this.ManagerUserMapper.insert(managerUser);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}

	@Override
	public int login(String userName,String password,int role) {
		int result=0;
		List<ManagerUser> lManagerUser=new ArrayList<>();
		ManagerUserExample example=new ManagerUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(userName);
		criteria.andPasswordEqualTo(password);
		criteria.andRoleEqualTo(role);
		try {
			lManagerUser=this.ManagerUserMapper.selectByExample(example);
			if(lManagerUser.size()>0){
				int status=lManagerUser.get(0).getStatus();
				int roles=lManagerUser.get(0).getRole();
				if(status==2){
					result=2;
				}
				else{
					if(roles==1){
						result=3;
					}else{
						result=1;
					}
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return result;
	}

}
