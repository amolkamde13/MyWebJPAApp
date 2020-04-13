package com.amonicks.demo.dao;

import java.util.List;

import com.amonicks.demo.model.Emp;

public interface EmpDao {
	
	public List<Emp> getAllEmp();
	public Emp findById(int id);
	public Emp addEmp(Emp emp);
	public Emp updateEmp(Emp emp);
	public Emp deleteById(int id);
	public List<Emp> getSearchCriteriaOfEmp(Emp emp);
}
