package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.Emp_DTO;

public interface IEmp {

	public int insertEmp(Emp_DTO dto);
	
	public Emp_DTO selectOneEmp(Emp_DTO dto);
	
	public List<Emp_DTO> getEmpIf(Map<String , Object> map);
	
	public int deleteEmp(Emp_DTO dto);
	
	public int updateEmp(Emp_DTO dto);
	
	public List<Emp_DTO> getDept_avgSal(Map<String , Object> map);
	
}
