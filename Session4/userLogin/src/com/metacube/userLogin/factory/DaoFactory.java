package com.metacube.userLogin.factory;

import com.metacube.userLogin.dao.BaseDao;
import com.metacube.userLogin.dao.MySQLUserDao;
import com.metacube.userLogin.enums.DBType;
import com.metacube.userLogin.enums.EntityName;

public class DaoFactory {

	public static BaseDao getDaoForEntity(DBType dbName, EntityName entity) {
		BaseDao baseDao = null;
		switch (entity) {
		case USER:
			switch (dbName) {
			case MY_SQL:
				baseDao = MySQLUserDao.getInstance();
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
