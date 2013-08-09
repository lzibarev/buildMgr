package ru.buildmgr.web.dataModel.store;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ru.buildmgr.web.dataModel.storemodel.ConstractionObjectAddress;

public class SConstractionObjectAddressUtils {

	@SuppressWarnings("unchecked")
	public static List<ConstractionObjectAddress> getAll() {
		EntityManager em = null;
		List<ConstractionObjectAddress> list = null;
		try {
			em = EMF.get().createEntityManager();
			Query q = em.createQuery("select coa from ConstractionObjectAddress coa ");
			list = new ArrayList<ConstractionObjectAddress>(q.getResultList());
		} finally {
			em.close();
		}
		return list;
	}

	public static ConstractionObjectAddress create(ConstractionObjectAddress elementType) {
		EntityManager em = null;
		try {
			em = EMF.get().createEntityManager();
			em.persist(elementType);
		} finally {
			em.close();
		}
		return elementType;
	}
}
