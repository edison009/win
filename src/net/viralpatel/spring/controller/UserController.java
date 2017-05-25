package net.viralpatel.spring.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.viralpatel.spring.DTO.User;
import net.viralpatel.spring.DAO.DepartmentDAO;
import net.viralpatel.spring.model.DepartmentMaster;

@Controller
public class UserController {
	
	@Autowired
	private DepartmentDAO deptDAO;
	
	@RequestMapping(value="/userAdd", method= RequestMethod.GET)
	public String addUser(Model model)
	{
		User user = new User();
		model.addAttribute("user",user);
		List<String> cityList = new ArrayList<String>();
		cityList.add("A");
		cityList.add("B");
		cityList.add("C");
		cityList.add("D");
		model.addAttribute("cityList",cityList);
		
		List<String> jobTypeList = new ArrayList<String>();
		jobTypeList.add("Full Time");
		jobTypeList.add("Part Time");
		model.addAttribute("jobTypeList",jobTypeList);
		
		List<String> deptList = new ArrayList<String>();
		deptList.add("CIVIL");
		deptList.add("MECHANIC");
		deptList.add("AUTOMOBILE");
		deptList.add("IT");
		model.addAttribute("deptList",deptList);
		
		Map<String,String> colorList = new LinkedHashMap<String,String>();
		colorList.put("R","RED");
		colorList.put("G","GREEN");
		colorList.put("B","BLUE");
		model.addAttribute("colorList",colorList);
		
		List<DepartmentMaster> dList = deptDAO.getDeptartmentList();
		model.addAttribute("dList",dList);
		
		return "userAdd";
		
	}
	@RequestMapping(value="/saveUser",method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user")User user, Model model)
	{
		System.out.println("name:"+user.getUsername());
		System.out.println("Password:"+user.getPasswords());
		System.out.println("Password:"+user.getCity());
		model.addAttribute("user",user);
		return "showUser";
		
		
	}

}
