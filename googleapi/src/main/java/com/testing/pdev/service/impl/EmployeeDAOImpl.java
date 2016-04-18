package com.testing.pdev.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.testing.pdev.model.Employee;
import com.testing.pdev.service.EmployeeDAO;

public class EmployeeDAOImpl extends GenericDAOImpl implements EmployeeDAO {

	private static final Logger log = LoggerFactory.getLogger(EmployeeDAOImpl.class);
	
	public List<Employee> getEmployeeNameQuery(String param){
		return entityManager.createNamedQuery("findEmployeeByDiffParam", Employee.class).
				setParameter(1, param).getResultList();
	}
	
	public void persist(Employee transientInstance) {
		log.debug("persisting Employee instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Employee persistentInstance) {
		log.debug("removing Employee instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Employee merge(Employee detachedInstance) {
		log.debug("merging Employee instance");
		try {
			Employee result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Employee findById(int id) throws Exception {
		log.debug("getting Employee instance with id: " + id);
		System.out.println("getting Employee instance with id: " + id);
		try {
			Employee instance = entityManager.find(Employee.class, id);
			log.debug("get successful");
			System.out.println("get successful" + instance.toString());
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			System.out.println("get failed");
			re.printStackTrace();
			throw re;
		}
	}
}
