package com.metacube.restProject.factory;

import com.metacube.restProject.dao.BaseDao;
import com.metacube.restProject.dao.MySQLAdvertismentDao;
import com.metacube.restProject.dao.MySQLCategoryDao;
import com.metacube.restProject.enums.DBType;
import com.metacube.restProject.enums.EntityName;

public class DaoFactory {
	public static BaseDao getDaoForEntity(DBType dbName, EntityName entity) {
		BaseDao baseDao = null;

		switch (entity) {
		case ADVERTISMENT:
			switch (dbName) {
			case MY_SQL:
				baseDao = MySQLAdvertismentDao.getInstance();
				break;
			default:
				break;
			}
			break;
		case CATEGORY:
			switch (dbName) {
			case MY_SQL:
				baseDao = MySQLCategoryDao.getInstance();
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
		return baseDao;
	}
}
