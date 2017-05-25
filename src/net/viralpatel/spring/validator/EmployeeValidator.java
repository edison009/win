package net.viralpatel.spring.validator;

import net.viralpatel.spring.DTO.EmployeeForm;
import net.viralpatel.spring.model.EmpPersonalInfo;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return EmployeeForm.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		EmployeeForm empForm = (EmployeeForm)target;
		
		//EmpOfficeInfo 
		
		EmpPersonalInfo empPersonal = empForm.getEmpPersonal();
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "empPersonal.personName", "Please enter employee name");
		ValidationUtils.rejectIfEmpty(errors, "empPersonal.personName", "Please enter employee name","Please enter employee name");
		
	}

}
