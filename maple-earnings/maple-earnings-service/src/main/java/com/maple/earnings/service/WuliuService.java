package com.maple.earnings.service;

import java.util.List;

import com.maple.earnings.common.pojo.EasyUIDataGridResult;
import com.maple.earnings.pojo.Wuliu;

public interface WuliuService {
	public EasyUIDataGridResult listWuliu(String userId,int page,
			int rows);
	public void addWuliu(Wuliu wuliu);
	public List<Wuliu>wulius();
	public void update(Wuliu wuliu);
}
