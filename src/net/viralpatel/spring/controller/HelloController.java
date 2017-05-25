package net.viralpatel.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String hello(Model model) {

		
		List<String> nlist = new ArrayList<String>();
		nlist.add("1");
		nlist.add("2");
		nlist.add("3");
		nlist.add("4");
		nlist.add("5");
		model.addAttribute("nlist",nlist);
		
		Map<String,String> mapList = new HashMap<String,String>();
		mapList.put("A","AAAAAAAAA");
		mapList.put("B","BBBBBBBBB");
		mapList.put("C","CCCCCCCCC");
		mapList.put("D","DDDDDDDDD");
		mapList.put("E","EEEEEEEEE");
		
		model.addAttribute("mapList",mapList);
		
		model.addAttribute("name", "John Doe");

		return "welcome";
	}
}
