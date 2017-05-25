package net.viralpatel.spring.DTO;

import net.viralpatel.spring.model.EmpOfficeInfo;
import net.viralpatel.spring.model.EmpPersonalInfo;


public class EmployeeForm {
	
	EmpOfficeInfo empOffice;
	EmpPersonalInfo empPersonal;
	public EmpOfficeInfo getEmpOffice() {
		return empOffice;
	}
	public void setEmpOffice(EmpOfficeInfo empOffice) {
		this.empOffice = empOffice;
	}
	public EmpPersonalInfo getEmpPersonal() {
		return empPersonal;
	}
	public void setEmpPersonal(EmpPersonalInfo empPersonal) {
		this.empPersonal = empPersonal;
	}
	
	

}
