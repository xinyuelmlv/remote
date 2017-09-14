/**
 * MAPLE CONFIDENTIAL - Highly Restricted: Do not distribute without prior approval
 *
 * Project: MAPLE
 *
 * Copyright © 2017 MAPLE Corporation. All rights reserved.
 */
package com.maple.earnings.common.pojo;

import java.util.List;

/**
 * TODO - High level description about type's responsibility.
 *
 * @author Yayun
 */
public class EasyUIDataGridResult {

	private long total;

	private List<?> rows;

	/**
	 * Get the value of or reference to total.
	 *
	 * @return the total
	 */
	public long getTotal() {
		return this.total;
	}

	/**
	 * Assign the value of total to total.
	 *
	 * @param total the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}

	/**
	 * Get the value of or reference to rows.
	 *
	 * @return the rows
	 */
	public List<?> getRows() {
		return this.rows;
	}

	/**
	 * Assign the value of rows to rows.
	 *
	 * @param rows the rows to set
	 */
	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
