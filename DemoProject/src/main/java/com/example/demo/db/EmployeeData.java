package com.example.demo.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.demo.module.Employee;

public interface EmployeeData extends JpaRepository<Employee, Integer> {

	List<Employee> findByeDesignation(String eDesignation);

	List<Employee> findByeidGreaterThan(int eid);

	List<Employee> findByeidLessThan(int eid);
	
	  @Query("from Employee where eDesignation=?1 order by eName") List<Employee>
	  findByDesignationSorted(String eDesignation);
	 

}
