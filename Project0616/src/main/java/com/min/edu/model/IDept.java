package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.Dept_DTO;

public interface IDept {
		
	public List<Dept_DTO> getDept(Map<String , Object> map);
	
	public int updateDept(Dept_DTO dto);
}
