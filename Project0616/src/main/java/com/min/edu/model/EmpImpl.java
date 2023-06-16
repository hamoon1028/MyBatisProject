package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.Emp_DTO;
import com.min.edu.mybatis.SqlDaoSupport;

public class EmpImpl implements IEmp {

	private Logger logger = Logger.getLogger(EmpImpl.class);
	private final String NS = "com.min.edu.model.EmpImpl.";
	private SqlSessionFactory manager = SqlDaoSupport.getFactory();
	
	@Override
	public int insertEmp(Emp_DTO dto) {
		logger.info("insertEmp 전달받은 입력 값 getEmployee_id() : " + dto.getEmployee_id());
		SqlSession session = manager.openSession(true);
		int n = session.insert(NS+"insertEmp", dto);
		logger.info("insertEmp 전달받은 입력 값 getEmployee_id() : " + dto.getEmployee_id());
		return n;
	}
	
	@Override
	public Emp_DTO selectOneEmp(Emp_DTO dto) {
		logger.info("insertEmp 전달받은 입력 값 getEmployee_id() : " + dto.getEmployee_id());
		SqlSession session = manager.openSession();
		Emp_DTO resultDto = session.selectOne(NS+"selectOneEmp", dto);
		return resultDto;
	}
	
	@Override
	public List<Emp_DTO> getEmpIf(Map<String, Object> map) {
		SqlSession session = manager.openSession();
		List<Emp_DTO> lists = session.selectList(NS+"getEmpIf", map);
		return lists;
	}
	
	@Override
	public int deleteEmp(Emp_DTO dto) {
		SqlSession session = manager.openSession(true);
		int n = session.delete(NS+"deleteEmp", dto);
		return n;
	}
	
	@Override
	public int updateEmp(Emp_DTO dto) {
		SqlSession session = manager.openSession(true);
		int n = session.update(NS+"updateEmp", dto);
		return n;
	}
	
	@Override
	public List<Emp_DTO> getDept_avgSal(Map<String, Object> map) {
		SqlSession session = manager.openSession();
		List<Emp_DTO> lists = session.selectList(NS+"getDept_avgSal", map);
		return lists;
	}
}
