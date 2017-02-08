package org.pbccrc.api.core.service.impl;

import java.util.List;
import java.util.Map;

import org.pbccrc.api.base.bean.Pagination;
import org.pbccrc.api.base.bean.SystemLog;
import org.pbccrc.api.core.dao.SystemLogDao;
import org.pbccrc.api.base.service.SystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemLogServiceImpl implements SystemLogService{

	@Autowired
	private SystemLogDao systemLogDao;
	
	public List<SystemLog> queryLog(SystemLog systemLog) {
		return systemLogDao.queryLog(systemLog);
	}

	public void addLog(SystemLog systemLog) {
		systemLogDao.addLog(systemLog);
	}

	public Pagination sumLog(Map<String, String> queryMap, Pagination pagination) {
		return systemLogDao.sumLog(queryMap, pagination);
	}
	
	public Pagination sumApiLog(Map<String, String> queryMap, Pagination pagination) {
		return systemLogDao.sumApiLog(queryMap, pagination);
	}
	
	public Pagination queryLogDetail(Map<String, String> queryMap, Pagination pagination) {
		return systemLogDao.queryLogDetail(queryMap, pagination);
	}

}
