package com.test.mybatis;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.min.edu.dto.Emp_DTO;
import com.min.edu.model.EmpImpl;
import com.min.edu.model.IEmp;
import com.min.edu.service.EmpServiceImpl;

public class Emp_JUnitTest {

	private IEmp dao = new EmpImpl();
	
//	@Test
	public void insertEmp() {
		EmpServiceImpl service = new EmpServiceImpl();
		Emp_DTO iDto = new Emp_DTO(0, "heeae", "moon", null, null, 0, 0, 0);
		Emp_DTO rDto = service.insertAfterSelect(iDto);
		System.out.println("입력된 객체 확인 : "+ rDto);
		assertNotNull(rDto);
	}

//	@Test
	public void getEmpIf() {
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("employee_id", 207);
		List<Emp_DTO> lists = dao.getEmpIf(map);
		assertNotNull(lists);
	}
	
//	@Test
	public void deleteEmp() {
		int employee_id = 207;
		Emp_DTO dto = new Emp_DTO();
		dto.setEmployee_id(employee_id);
		int result = dao.deleteEmp(dto);
		assertEquals(1, result);
	}
	
//	@Test
	public void updateEmp() {
		int sal = 5000;
		int employee_id = 206;
		Emp_DTO dto = new Emp_DTO();
		dto.setSalary(sal);
		dto.setEmployee_id(employee_id);
		int result = dao.updateEmp(dto);
		assertEquals(1, result);
	}
	
	@Test
	public void getDept_avgSal() {
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("employee_id", 103);
		List<Emp_DTO> lists = dao.getDept_avgSal(map);
		assertNotNull(lists);
	}
	
		

}
