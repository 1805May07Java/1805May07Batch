/*
 * StatusService.java
 * Author: Cole Vikupitz
 *
 */

package com.revature.service;

import java.util.List;

import com.revature.dao.StatusDao;
import com.revature.pojos.Status;

public class StatusService {

	public static List<Status> getAll() {

		return StatusDao.getAll();
	}
}
