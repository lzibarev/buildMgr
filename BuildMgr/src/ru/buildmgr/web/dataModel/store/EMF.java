package ru.buildmgr.web.dataModel.store;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	// private static final EntityManagerFactory emfInstance = ;

	private EMF() {
	}

	public static EntityManagerFactory get() {
		// return emfInstance;
		return Persistence.createEntityManagerFactory("transactions-optional");
	}
}