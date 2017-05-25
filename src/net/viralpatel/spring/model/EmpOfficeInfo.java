package net.viralpatel.spring.model;




/**
 * The persistent class for the emp_office_info database table.
 * 
 */

public class EmpOfficeInfo {
	

	private int officeId;


	private int degreeId;


	private int deptId;


	private int designId;

	private String doj;


	private int personalId;

	private double salary;

	public EmpOfficeInfo() {
	}

	public int getOfficeId() {
		return this.officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public int getDegreeId() {
		return this.degreeId;
	}

	public void setDegreeId(int degreeId) {
		this.degreeId = degreeId;
	}

	public int getDeptId() {
		return this.deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public int getDesignId() {
		return this.designId;
	}

	public void setDesignId(int designId) {
		this.designId = designId;
	}

	public String getDoj() {
		return this.doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public int getPersonalId() {
		return this.personalId;
	}

	public void setPersonalId(int personalId) {
		this.personalId = personalId;
	}

	public double getSalary() {
		return this.salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}