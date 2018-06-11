/*
 * TypeService.java
 * Author: Cole Vikupitz
 *
 */

package com.revature.service;

import java.util.List;

import com.revature.dao.TypeDao;
import com.revature.pojos.Type;

public class TypeService {

	public static List<Type> getAll() {

		return TypeDao.getAll();
	}
}
