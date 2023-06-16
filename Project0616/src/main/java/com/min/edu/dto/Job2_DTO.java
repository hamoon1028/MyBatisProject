package com.min.edu.dto;

public class Job2_DTO {

	private String job_id;
	private String job_title;
	private int min_salary;
	private int max_salary;
	private int employee_id;
	public Job2_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Job2_DTO(int employee_id, String job_id) {
		super();
		this.job_id = job_id;
		this.employee_id = employee_id;
	}



	public Job2_DTO(String job_id, String job_title, int min_salary, int max_salary, int employee_id) {
		super();
		this.job_id = job_id;
		this.job_title = job_title;
		this.min_salary = min_salary;
		this.max_salary = max_salary;
		this.employee_id = employee_id;
	}
	@Override
	public String toString() {
		return "Job2_DTO [job_id=" + job_id + ", job_title=" + job_title + ", min_salary=" + min_salary
				+ ", max_salary=" + max_salary + ", employee_id=" + employee_id + "]";
	}
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public int getMin_salary() {
		return min_salary;
	}
	public void setMin_salary(int min_salary) {
		this.min_salary = min_salary;
	}
	public int getMax_salary() {
		return max_salary;
	}
	public void setMax_salary(int max_salary) {
		this.max_salary = max_salary;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	
	
	
}
