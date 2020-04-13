package com.amonicks.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amonicks.demo.dao.EmpDao;
import com.amonicks.demo.model.Emp;

@Service
public class EmpService{

	@Autowired
	EmpDao empDao;
	
	@Transactional
	public List<Emp> getAllEmp() {
		
		return empDao.getAllEmp();
	}

	@Transactional
	public Emp findById(int id) {
		// TODO Auto-generated method stub
		return empDao.findById(id);
	}

	@Transactional
	public Emp addEmp(Emp emp) {
		return empDao.addEmp(emp);
	}

	@Transactional
	public Emp updateEmp(Emp emp) {
		
		return empDao.updateEmp(emp);
	}

	@Transactional
	public Emp deleteById(int id) {
		// TODO Auto-generated method stub
		return empDao.deleteById(id);
	}
	@Transactional
	public List<Emp> getSearchCriteriaOfEmp(Emp emp) {
		// TODO Auto-generated method stub
		return empDao.getSearchCriteriaOfEmp(emp);
	}
	
}
