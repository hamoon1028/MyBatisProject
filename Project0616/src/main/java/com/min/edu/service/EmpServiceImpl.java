package com.min.edu.service;

import com.min.edu.dto.Emp_DTO;
import com.min.edu.model.EmpImpl;
import com.min.edu.model.IDept;
import com.min.edu.model.IEmp;

public class EmpServiceImpl {

	private IEmp dao;
	
	public EmpServiceImpl() {
		dao = new EmpImpl();
	}
	
	public Emp_DTO insertAfterSelect(Emp_DTO dto) {
		Emp_DTO rDto = null;
		System.out.println("원본 DTO : " + dto);
		int n = dao.insertEmp(dto);
		System.out.println("Info Insert 결과 : " + n);
		System.out.println("입력 후 DTO : "+ dto);
		rDto = dao.selectOneEmp(dto);
		return rDto;
	}
	
}
