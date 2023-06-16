package com.min.edu.service;

import com.min.edu.model.DeptImpl;
import com.min.edu.model.IDept;

public class DeptServiceImpl {

	private IDept dao;
	
	public DeptServiceImpl() {
		dao = new DeptImpl();
	} 
	
	public void updateDept(String employeeId, String jobId) {
		dao.updateDept(employeeId, jobId);
		
		
	}
	
}
