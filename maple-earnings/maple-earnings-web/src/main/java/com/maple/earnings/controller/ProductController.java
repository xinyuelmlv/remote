/**
 * MAPLE CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: MAPLE
 *
 * Copyright © 2017 MAPLE Corporation. All rights reserved.
 */
package com.maple.earnings.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.maple.earnings.common.pojo.EasyUIDataGridResult;
import com.maple.earnings.pojo.DifferenceReportDTO;
import com.maple.earnings.pojo.EProduct;
import com.maple.earnings.pojo.EProductCost;
import com.maple.earnings.pojo.EProductCostExample;
import com.maple.earnings.pojo.EProductExample;
import com.maple.earnings.service.ProductCostService;
import com.maple.earnings.service.ProductService;
import com.maple.earnings.service.TradeService;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductCostService productCostService;

	@RequestMapping("/list")
	@ResponseBody
	public EasyUIDataGridResult getTradeList(String userId,String title, Integer page, Integer rows) {
		EasyUIDataGridResult result = this.productService.list(userId,title, page, rows);
		return result;
	}

	@RequestMapping("/sub")
	public String sub(HttpServletRequest request) throws IOException {
	    String excelPath = request.getParameter("excelPath");   
        //输入流   
        InputStream fis = new FileInputStream(excelPath);
        List<EProduct> infos = ProductController.importEmployeeByPoi(fis);
        for (EProduct eProduct : infos) {
        	//eProduct.setuId(666666l);
        	
    		productService.saveOrUpdate(eProduct);
		}
        return "product-list";
		
	}
	//批量导入商品
	  public static List<EProduct> importEmployeeByPoi(InputStream fis) {  
          
	        List<EProduct> products = new ArrayList<EProduct>();  
	        EProduct product = null;  
	          
	        try {  
	            //创建Excel工作薄  
	            HSSFWorkbook hwb = new HSSFWorkbook(fis);  
	            //得到第一个工作表  
	            HSSFSheet sheet = hwb.getSheetAt(0);  
	            HSSFRow row = null;  
	            //日期格式化  
	            DateFormat ft = new SimpleDateFormat("yyyy-MM-dd");  
	            //遍历该表格中所有的工作表，i表示工作表的数量 getNumberOfSheets表示工作表的总数   
	            for(int i = 0; i < hwb.getNumberOfSheets(); i++) {  
	                sheet = hwb.getSheetAt(i);  
	                //遍历该行所有的行,j表示行数 getPhysicalNumberOfRows行的总数  
	                for(int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {  
	                    row = sheet.getRow(j);  
	                    product = new EProduct();    
	                    //此方法调用getCellValue(HSSFCell cell)对解析出来的数据进行判断，并做相应的处理  
	                    if(ProductController.getCellValue(row.getCell(0)) != null && !"".equals(ProductController.getCellValue(row.getCell(0)))) {  
	                    //    product.setOrgId(Long.valueOf(ProductController.getCellValue(row.getCell(0))));  
	                    }  
	                    product.setNumIid(Long.parseLong(ProductController.getCellValue(row.getCell(0))));  
	                    product.setApprroveStatus(ProductController.getCellValue(row.getCell(1)));  
	                  //  product.setNum(Long.parseLong(ProductController.getCellValue(row.getCell(2))));  
	                    product.setPrice(Double.parseDouble(ProductController.getCellValue(row.getCell(3))));
	                    product.setTitle(ProductController.getCellValue(row.getCell(4)));  
	                    products.add(product);  
	                }  
	                  
	            }  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	        return products;  
	    }  
	    //判断从Excel文件中解析出来数据的格式  
	    private static String getCellValue(HSSFCell cell){  
	        String value = null;  
	        //简单的查检列类型  
	        switch(cell.getCellType())  
	        {  
	            case HSSFCell.CELL_TYPE_STRING://字符串  
	                value = cell.getRichStringCellValue().getString();  
	                break;  
	            case HSSFCell.CELL_TYPE_NUMERIC://数字  
	                long dd = (long)cell.getNumericCellValue();  
	                value = dd+"";  
	                break;  
	            case HSSFCell.CELL_TYPE_BLANK:  
	                value = "";  
	                break;     
	            case HSSFCell.CELL_TYPE_FORMULA:  
	                value = String.valueOf(cell.getCellFormula());  
	                break;  
	            case HSSFCell.CELL_TYPE_BOOLEAN://boolean型值  
	                value = String.valueOf(cell.getBooleanCellValue());  
	                break;  
	            case HSSFCell.CELL_TYPE_ERROR:  
	                value = String.valueOf(cell.getErrorCellValue());  
	                break;  
	            default:  
	                break;  
	        }  
	        return value;  
	    }  
	@RequestMapping("/add")
	@ResponseBody
	public int addProductCost(HttpServletRequest request) {
		int result = 0;
		long numIid = Long.parseLong(request.getParameter("numIid"));
		Double cost = Double.parseDouble(request.getParameter("cost"));
		EProductCost productCost = new EProductCost();
		EProductCostExample example=new EProductCostExample();
		productCost.setCost(cost);
		productCost.setNumIid(numIid);
		List<EProductCost> lEproductCost=productCostService.list(numIid);
		if(lEproductCost.size()==0){
		try {
			this.productCostService.add(numIid, productCost);
			result = 1;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		}
		else{
			this.productCostService.updateByNumid(productCost);
			result = 1;

		}
		return result;
	}
	@RequestMapping("/getProductExport")
	public void getProductExport(HttpServletRequest request, HttpServletResponse response) {
		try {
			byte[] fileNameByte = ("product.xls").getBytes("UTF-8");
			String filename = new String(fileNameByte, "UTF-8");

			byte[] bytes = this.productService.exportModle();
			// logger.info("------------------------"+bytes.length);
			response.setContentType("application/x-msdownload");
			// response.setContentType("application/x-excel");
			response.setContentLength(bytes.length);
			response.setHeader("Content-Disposition", "attachment;filename=" + filename);
			response.getOutputStream().write(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				response.getOutputStream().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
