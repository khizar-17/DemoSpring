package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.demo.db.EmployeeData;
import com.example.demo.module.Employee;

@RestController
public class EmpController 
{
	@Autowired
	EmployeeData empObj;
	
	@RequestMapping("/")
	public String Home()
	{
		return "home.jsp";
	}
	
	
	@RequestMapping("/addEmployee")
	public String addEmployeeMetod(Employee employee)
	{
		empObj.save(employee);
		return "home.jsp";
	}
	
	
	
	@RequestMapping("/getEmployee")
	public ModelAndView getAlienMetod(@RequestParam int eid)
	{
		ModelAndView mv=new ModelAndView("ShowEmployee.jsp");
	//	Optional<Employee> employee=empObj.findById(eid);
		Employee employee=empObj.findById(eid).orElse(new Employee()) ;
		System.out.println("Lead");
	System.out.println(empObj.findByeDesignation("lead").toString());
	System.out.println("> 102");
	System.out.println(empObj.findByeidGreaterThan(102));
	System.out.println("<103");
	System.out.println(empObj.findByeidLessThan(103));
	
	System.out.println("Sorted");
	System.out.println(empObj.findByDesignationSorted("engineer"));
		mv.addObject(employee);
		return mv;
	}
	
	@GetMapping(path="/employees" ,produces= {"application/json"})
	@ResponseBody
	public List<Employee> employees()
	{
		return empObj.findAll();
	}
	
	@RequestMapping("/employee/{eid}")
	@ResponseBody
	public Optional<Employee> getemployees(@PathVariable("eid") int pathid)
	{
		return empObj.findById(pathid);
	}
	
	
	@PostMapping("/employees")
	public Employee postEmployeeMetod(@RequestBody Employee employee)
	{
		empObj.save(employee);
		return employee;
	}
	
	@DeleteMapping("/employee/{eid}")
	@ResponseBody
	public String deleteemployees(@PathVariable("eid") int pathid)
	{
		Employee e=empObj.getOne(pathid);
		empObj.delete(e);
		return "deleted";
	}
	
	@PutMapping("/employees")
	public Employee updateEmployeeMetod(@RequestBody Employee employee)
	{
		empObj.save(employee);
		return employee;
	}
	
}
