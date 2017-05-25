package net.viralpatel.spring.model;




/**
 * The persistent class for the department_master database table.
 * 
 */
public class DepartmentMaster {
	


	private int departmentMasterId;

	private String departmentDesc;

	public DepartmentMaster() {
	}

	public int getDepartmentMasterId() {
		return this.departmentMasterId;
	}

	public void setDepartmentMasterId(int departmentMasterId) {
		this.departmentMasterId = departmentMasterId;
	}

	public String getDepartmentDesc() {
		return this.departmentDesc;
	}

	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}

}