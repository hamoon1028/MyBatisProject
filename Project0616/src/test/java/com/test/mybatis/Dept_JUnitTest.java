package com.test.mybatis;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.min.edu.dto.Dept_DTO;
import com.min.edu.model.DeptImpl;
import com.min.edu.model.IDept;

public class Dept_JUnitTest {
	
	private IDept dao = new DeptImpl();

	@Test
	public void getDept() {
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("employee_id", 103);
		List<Dept_DTO> lists = dao.getDept(map);
		assertNotNull(lists);
	}
}
