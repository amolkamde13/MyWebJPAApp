package com.amonicks.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.amonicks.demo.dao.EmpDao;
//import com.amonicks.demo.dao.EmpRepo;
import com.amonicks.demo.model.Emp;
import com.amonicks.demo.service.EmpService;

@RestController
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	@GetMapping("/")
	public ModelAndView home() {
		return new ModelAndView("home");
	}
	@PostMapping("emp")
	@ResponseBody
	public Emp addEmp(@RequestBody Emp emp) {
		//repo.save(emp);
		empService.addEmp(emp);
		return emp;
	}
	
	@GetMapping("emp/{empId}")
	@ResponseBody
	public Emp getEmp(@PathVariable("empId") int empId) {
		Emp emp = empService.findById(empId);
		return emp;
	}
	
	@GetMapping("emp")
	@ResponseBody
	public List<Emp> getAllEmp() {
		List<Emp> list = empService.getAllEmp();
		return list;
	}
	
	@PutMapping("emp")
	public Emp updateEmp(@RequestBody Emp emp) {
		Emp emp1 = empService.updateEmp(emp);
		return emp1;
	}
	
	@DeleteMapping("emp/{empId}")
	@ResponseBody
	public Emp deleteEmp(@PathVariable("empId") int empId) {
		return empService.deleteById(empId);
	}
	
	@PostMapping("search")
	@ResponseBody
	public List<Emp> getSearchCriteriaOfEmp(Emp emp){
		List<Emp> list = empService.getSearchCriteriaOfEmp(emp);
		return list;
	}
}
