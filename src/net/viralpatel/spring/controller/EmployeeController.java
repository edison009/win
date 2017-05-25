package net.viralpatel.spring.controller;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.viralpatel.spring.DAO.*;
import net.viralpatel.spring.DTO.*;
import net.viralpatel.spring.model.*;
import net.viralpatel.spring.validator.*;

@Controller
public class EmployeeController {
	
	
	@Autowired
	private DepartmentDAO deptDAO;
	@Autowired
	private DesignationDAO designationDAO;
	@Autowired
	private DegreeDAO degreeDAO;
	@Autowired
	private GenderDAO genderDAO;
	@Autowired
	private StateDAO stateDAO;
	@Autowired
	private EmpOfficeInfoDAO empOfficeInfoDAO;
	@Autowired
	private EmpPersonalInfoDAO empPersonalInfoDAO;
	/*@Autowired
	EmployeeValidator employeeValidator;
	
	@InitBinder("empForm")
	protected void initBinder(WebDataBinder binder)
	{
		binder.setValidator(employeeValidator);
	}*/
	
	@RequestMapping(value="/empList",method = RequestMethod.GET)
	public ModelAndView employeeList(Model model)
	{
		
		ModelAndView mv = new ModelAndView();
		String url="";
		Map<Integer, EmpPersonalInfo> empPersonalMapList = empPersonalInfoDAO.getEmpPersonalInfoList();
		Map<Integer, EmpOfficeInfo> empOfficeMapList = empOfficeInfoDAO.getEmpOfficeInfoList();
		
		List<EmployeeDetail> employeeDetailList = new ArrayList<EmployeeDetail>();
		
		Iterator<Map.Entry<Integer, EmpPersonalInfo>> entries = empPersonalMapList.entrySet().iterator();
		while (entries.hasNext()) {
		  Map.Entry<Integer, EmpPersonalInfo> entry = entries.next();
		  int key = entry.getKey();
		  EmpPersonalInfo empPersonalInfo = entry.getValue();
		  EmpOfficeInfo empOfficeInfo = empOfficeMapList.get(key);
		  
		  EmployeeDetail employeeDetail = new EmployeeDetail();
	      
		  employeeDetail.setPersonalId(empPersonalInfo.getPersonalId());
		  employeeDetail.setPersonName(empPersonalInfo.getPersonName());
		  employeeDetail.setAge(empPersonalInfo.getAge());
		  employeeDetail.setGender(genderDAO.get(empPersonalInfo.getGenderId()).getGenderDesc());
		  employeeDetail.setStateName(stateDAO.get(empPersonalInfo.getStateId()).getStateMasterName());
		  employeeDetail.setAddress(empPersonalInfo.getAddress());
		  
		  employeeDetail.setOfficeId(empOfficeInfo.getOfficeId());
		  employeeDetail.setDepartment(deptDAO.get(empOfficeInfo.getDeptId()).getDepartmentDesc());
		  employeeDetail.setDegree(degreeDAO.get(empOfficeInfo.getDegreeId()).getDegreeMasterDesc());
		  employeeDetail.setDesignation(designationDAO.get(empOfficeInfo.getDesignId()).getDesignationMasterDesc());
		  employeeDetail.setSalary(empOfficeInfo.getSalary());
		  employeeDetail.setDoj(empOfficeInfo.getDoj());
		  
		  employeeDetailList.add(employeeDetail);
		  
		}
	
		mv.addObject("employeeDetailList",employeeDetailList);
		if(employeeDetailList.size()>0)mv.setViewName("empList");
		else mv.setViewName("redirect:/employeeFormPage");
		
		
		return mv;
	}
	
	@RequestMapping(value="/employeeFormPage",method = RequestMethod.GET)
	public ModelAndView employeeFormPage(Model model,@RequestParam(value="personalId",required=true,defaultValue="0")Integer personalId,@RequestParam(value="officeId",required=true,defaultValue="0")Integer officeId)
	{
		
		ModelAndView mv = new ModelAndView();
		EmpOfficeInfo empOfficeInfo =new EmpOfficeInfo();
		EmpPersonalInfo empPersonalInfo = new EmpPersonalInfo();
		if(personalId!=0)
		{
			empPersonalInfo = empPersonalInfoDAO.get(personalId);
			
		}
		if(officeId!=0)
		{
			empOfficeInfo = empOfficeInfoDAO.get(officeId);
		}
		EmployeeForm employeeForm = new EmployeeForm();
		employeeForm.setEmpOffice(empOfficeInfo);
		employeeForm.setEmpPersonal(empPersonalInfo);
		
		List<DepartmentMaster> departmentList = deptDAO.getDeptartmentList();
		List<DesignationMaster> designationList = designationDAO.getDesignationList();
		List<DegreeMaster> degreeList = degreeDAO.getDegreeList();
		List<GenderMaster> genderList = genderDAO.getGenderList();
		List<StateMaster> stateList = stateDAO.getStateList();
		System.out.println("genderList:"+genderList.size()+":"+genderList.toString());
		mv.addObject("departmentList",departmentList);
		mv.addObject("designationList",designationList);
		mv.addObject("degreeList",degreeList);
		mv.addObject("genderList",genderList);
		mv.addObject("stateList",stateList);
		mv.addObject("empForm", employeeForm);
	    mv.setViewName("employeeFormPage");
		return mv;
	}
	
	@RequestMapping(value="/saveEmployeeForm",method = RequestMethod.POST)
	public ModelAndView saveEmployeeForm(@ModelAttribute("empForm") EmployeeForm empForm)
	{
		ModelAndView mv = new ModelAndView();
		List<String> errors = new ArrayList<String>();
		EmpPersonalInfo empPersonalInfo = empForm.getEmpPersonal();
		EmpOfficeInfo   empOfficeInfo =  empForm.getEmpOffice();
		if(empPersonalInfo.getPersonName().isEmpty())
		{
			errors.add("Please enter Employee Name");
			
		}
		if(errors.size()>0)
		{
			mv.addObject("errorsList", errors);
			List<DepartmentMaster> departmentList = deptDAO.getDeptartmentList();
			List<DesignationMaster> designationList = designationDAO.getDesignationList();
			List<DegreeMaster> degreeList = degreeDAO.getDegreeList();
			List<GenderMaster> genderList = genderDAO.getGenderList();
			List<StateMaster> stateList = stateDAO.getStateList();
			System.out.println("genderList:"+genderList.size()+":"+genderList.toString());
			mv.addObject("departmentList",departmentList);
			mv.addObject("designationList",designationList);
			mv.addObject("degreeList",degreeList);
			mv.addObject("genderList",genderList);
			mv.addObject("stateList",stateList);
			mv.addObject("empForm", empForm);
			mv.setViewName("employeeFormPage");
		}
		else
		{
		//empPersonalInfo = empForm.getEmpPersonal();
		int personalId = empPersonalInfoDAO.saveOrUpdate(empPersonalInfo);
		//empOfficeInfo =  empForm.getEmpOffice();
		empOfficeInfo.setPersonalId(personalId);
		empOfficeInfoDAO.saveOrUpdate(empOfficeInfo);
		mv.setViewName("redirect:/empList");
		}
		
		return mv;
		
	}
	
	@RequestMapping(value="/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deletEmployee(@RequestParam(value="personalId",required=true,defaultValue="0")Integer personalId,@RequestParam(value="officeId",required=true,defaultValue="0")Integer officeId)
	{
		ModelAndView mv = new ModelAndView();
		if(personalId!=0)
		{
			empPersonalInfoDAO.delete(personalId);
			
		}
		if(officeId!=0)
		{
			empOfficeInfoDAO.delete(officeId);
		}
		mv.setViewName("redirect:/empList");
		return mv ;
	}
	
	

}
