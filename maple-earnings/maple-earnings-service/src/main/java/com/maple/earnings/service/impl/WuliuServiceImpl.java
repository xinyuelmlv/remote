package com.maple.earnings.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maple.earnings.common.pojo.EasyUIDataGridResult;
import com.maple.earnings.mapper.WuliuMapper;
import com.maple.earnings.pojo.Wuliu;
import com.maple.earnings.pojo.WuliuExample;
import com.maple.earnings.pojo.WuliuExample.Criteria;
import com.maple.earnings.service.WuliuService;

@Service
public class WuliuServiceImpl implements WuliuService {
	@Autowired
	private WuliuMapper wuliuMapper;
	@Override
	public EasyUIDataGridResult listWuliu(String userId, int page, int rows) {
		PageHelper.startPage(page, rows);
		List<Wuliu> wulius=new ArrayList<>();
		WuliuExample example=new WuliuExample();
		Criteria criteria = example.createCriteria();
		if(userId!=null&&!userId.equals("")){
			criteria.andUseridEqualTo(userId);
		}
		wulius=this.wuliuMapper.selectByExample(example);
		EasyUIDataGridResult results = new EasyUIDataGridResult();
		PageInfo<Wuliu> pageInfo=new PageInfo<>(wulius);
		results.setRows(wulius);
		results.setTotal(pageInfo.getTotal());
		return results;
	}
	@Override
	public void addWuliu(Wuliu wuliu) {
		this.wuliuMapper.insert(wuliu);
		
	}
	@Override
	public List<Wuliu> wulius() {
		WuliuExample example=new WuliuExample();
		return this.wuliuMapper.selectByExample(example);
	}
	@Override
	public void update(Wuliu wuliu) {
		// TODO Auto-generated method stub
		this.wuliuMapper.updateByPrimaryKeySelective(wuliu);
	}

}
