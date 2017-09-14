/**
 * MAPLE CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: MAPLE
 *
 * Copyright © 2017 MAPLE Corporation. All rights reserved.
 */
package com.maple.earnings.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maple.earnings.common.pojo.EasyUIDataGridResult;
import com.maple.earnings.mapper.EProductMapper;
import com.maple.earnings.pojo.EProduct;
import com.maple.earnings.pojo.EProductExample;
import com.maple.earnings.pojo.ETrade;
import com.maple.earnings.pojo.ETradeExample;
import com.maple.earnings.pojo.EProductExample.Criteria;
import com.maple.earnings.service.ProductService;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private EProductMapper productMapper;

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public void add(EProduct product) {
		this.productMapper.insert(product);
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public EProduct load(long numIid) {
		return this.productMapper.selectByPrimaryKey(numIid);
	}

	/**
	 * {@inheritDoc}
	 *
	 * TODO - Add javadoc for the sub-type.
	 */
	@Override
	public List<EProduct> list(String userId) {
		List<EProduct> products = new ArrayList<>();
		EProductExample example = new EProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andUIdEqualTo(userId);
		products = this.productMapper.selectByExample(example);
		return products;
	}

	@Override
	public EasyUIDataGridResult list(String userId,String title, int page, int rows) {
		PageHelper.startPage(page, rows);
		List<EProduct> products = new ArrayList<>();
		EProductExample example = new EProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andUIdEqualTo(userId);
		criteria.andTitleLike(title);
		products = this.productMapper.selectProAndCostByExample(example);
		EasyUIDataGridResult results = new EasyUIDataGridResult();
		PageInfo<EProduct> pageInfo = new PageInfo<>(products);
		results.setRows(products);
		results.setTotal(pageInfo.getTotal());
		return results;
	}

	@Override
	public byte[] exportModle() {
		// TODO Auto-generated method stub
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("差异报表");
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		HSSFRow row = sheet.createRow(0);
		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		// 设置表头
		List<String> excelHead = this.getExcelHead();

		HSSFCell cell = null;
		// excel头
		for (int i = 0; i < excelHead.size(); i++) {
			cell = row.createCell(i);
			cell.setCellValue(excelHead.get(i));
			cell.setCellStyle(style);
		}

		try {
			wb.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out.toByteArray();
	}
	/**
	 * 获取excel表头
	 *
	 * @return
	 */
	private List<String> getExcelHead() {
		List<String> result = new ArrayList<String>(17);
		result.add("商品编号");
		result.add("状态");
		result.add("数量");
		result.add("商品价格");
		result.add("商品名称");

		return result;
	}

	@Override
	public void saveOrUpdate(EProduct product) {
		// TODO Auto-generated method stub
		if (this.load(product.getNumIid()) == null) {
			this.productMapper.insert(product);
		} else {
			this.productMapper.updateByPrimaryKey(product);
		}
	//	this.addOrderReport(product);
		
	}

	// ------- Constants (static final) ----------------------------------------

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------

	// ------- Constructors ----------------------------------------------------

	// ------- Instance Methods (public) ---------------------------------------

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------

	// ------- Static Methods --------------------------------------------------

	// ------- Optional Inner Class ------------------------------------------

}
