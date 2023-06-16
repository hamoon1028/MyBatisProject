package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.Dept_DTO;
import com.min.edu.mybatis.SqlDaoSupport;

public class DeptImpl implements IDept {

	private Logger logger = Logger.getLogger(DeptImpl.class);
	private final String NS = "com.min.edu.model.DeptImpl.";
	private SqlSessionFactory manager = SqlDaoSupport.getFactory();
	
	@Override
	public List<Dept_DTO> getDept(Map<String, Object> map) {
		SqlSession session = manager.openSession();
		List<Dept_DTO> lists = session.selectList(NS+"getDept", map);
		return lists;
	}
	
	@Override
	public int updateDept(Dept_DTO dto) {
		SqlSession session = manager.openSession(true);
		int n = session.update(NS+"updateDept", dto);
		return n;
	}
}
