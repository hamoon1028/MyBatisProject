package com.min.edu.model;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.Job2_DTO;
import com.min.edu.mybatis.SqlDaoSupport;

public class JobImpl implements IJob {

	private Logger logger = Logger.getLogger(JobImpl.class);
	private final String NS = "com.min.edu.model.JobImpl.";
	private SqlSessionFactory manager = SqlDaoSupport.getFactory();
	
	@Override
	public boolean updateJobId(Map<String, Object> map) {
		SqlSession session = manager.openSession(true);
		int n = session.update(NS+"updateJobId", map);
		return (n>0)? true:false;
	}
	
	
}
