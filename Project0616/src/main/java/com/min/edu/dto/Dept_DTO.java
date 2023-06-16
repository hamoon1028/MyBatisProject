package com.min.edu.dto;

public class Dept_DTO {

	private int department_id;
	private String department_name;
	private int manager_id;
	private int location_id;
	private int employee_id;
	public Dept_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dept_DTO(int department_id, String department_name, int manager_id, int location_id, int employee_id) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
		this.manager_id = manager_id;
		this.location_id = location_id;
		this.employee_id = employee_id;
	}
	@Override
	public String toString() {
		return "Dept_DTO [department_id=" + department_id + ", department_name=" + department_name + ", manager_id="
				+ manager_id + ", location_id=" + location_id + ", employee_id=" + employee_id + "]";
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	
	
	
}
