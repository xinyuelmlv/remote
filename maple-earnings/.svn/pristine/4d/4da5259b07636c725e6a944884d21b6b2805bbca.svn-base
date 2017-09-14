/**
 * MAPLE CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: MAPLE
 *
 * Copyright © 2017 MAPLE Corporation. All rights reserved.
 */
package com.maple.earnings.service;

import java.util.List;

import com.maple.earnings.common.pojo.EasyUIDataGridResult;
import com.maple.earnings.pojo.EProduct;
import com.maple.earnings.pojo.ETrade;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */

public interface ProductService {

	public void add(EProduct product);

	List<EProduct> list(String userId);
	EasyUIDataGridResult list(String userId, String title,int page, int rows);

	/**
	 * TODO
	 *
	 * @param numIid
	 * @return
	 */
	EProduct load(long numIid);
	public byte[] exportModle();//下载模板
	public void saveOrUpdate(EProduct product);//添加或更新
}
