package com.amonicks.demo.daoImpl;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.amonicks.demo.dao.EmpDao;
import com.amonicks.demo.model.Emp;

@Repository
public class EmpDaoImpl implements EmpDao{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Emp> getAllEmp() {

		Session session = entityManager.unwrap(Session.class);
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Emp> criteriaQuery = builder.createQuery(Emp.class);
		Root<Emp> root = criteriaQuery.from(Emp.class);
		criteriaQuery.select(root);
		return session.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public Emp findById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Emp emp = session.get(Emp.class, id);
		return emp;
	}

	@Override
	public Emp addEmp(Emp emp) {
		Session session = entityManager.unwrap(Session.class);
		session.save(emp);
		session.close();
		return emp;
	}

	@Override
	public Emp updateEmp(Emp emp) {
		Session session = entityManager.unwrap(Session.class);
		session.update(emp);
		session.close();
		return emp;
	}

	@Override
	public Emp deleteById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Emp emp = session.get(Emp.class, id);
		if(emp!=null) {
			session.delete(emp);
		}
		session.close();
		return emp;
	}

	@Override
	public List<Emp> getSearchCriteriaOfEmp(Emp emp) {
		
		Session session = entityManager.unwrap(Session.class);
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Emp> criteriaQuery = cb.createQuery(Emp.class);
		Root<Emp> root = criteriaQuery.from(Emp.class);
		
		if(null!=emp) {
			int size = 0;
			
			String empName = emp.getEmpName();
			String companyName = emp.getCompanyName();
			String address = emp.getAddress();
			String city = emp.getCity();
			String country = emp.getCountry();
			
			if(null!=empName && !empName.isEmpty()) {
				++size;
			}
			if(null!=companyName && !companyName.isEmpty()) {
				++size;
			}
			if(null!=address && !address.isEmpty()) {
				++size;
			}
			if(null!=city && !city.isEmpty()) {
				++size;
			}
			if(null!=country && !country.isEmpty()) {
				++size;
			}
			Predicate[] predicates = new Predicate[size];
			
			if(null!=empName && (!empName.isEmpty())) {
				predicates[--size] = cb.like(root.get("empName"), empName+"%");
			}
			if(null!=companyName && (!companyName.isEmpty())) {
				predicates[--size] = cb.equal(root.get("companyName"),companyName);
			}
			if(null!=address && (!address.isEmpty())) {
				predicates[--size] = cb.equal(root.get("address"),address);
			}
			if(null!=city && (!city.isEmpty())) {
				predicates[--size] = cb.equal(root.get("city"), city);
			}
			if(null!=country && (!country.isEmpty())) {
				predicates[--size] = cb.equal(root.get("country"), country);
			}
			criteriaQuery.select(root).where(predicates).orderBy(cb.asc(root.get("empName")));
		}
		
		return session.createQuery(criteriaQuery).getResultList();
	}

}
