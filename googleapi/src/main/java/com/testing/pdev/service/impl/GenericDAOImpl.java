package com.testing.pdev.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAOImpl {

	protected EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("googleapi");
	protected EntityManager entityManager = entityManagerFactory.createEntityManager();
}
