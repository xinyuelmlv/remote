package com.maple.earnings.service;

import com.maple.earnings.common.pojo.EasyUIDataGridResult;
import com.maple.earnings.pojo.ManagerUser;

public interface ManagerUserService {
	EasyUIDataGridResult list(int page, int rows);
	public void Update(ManagerUser managerUser);//更新
	public void save(ManagerUser managerUser);
	public int login(String userName,String password,int role);
}
