package ru.buildmgr.web.dataModel.store;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ru.buildmgr.web.dataModel.storemodel.ConstractionElement;

public class SConstractionElementUtils {

	@SuppressWarnings("unchecked")
	public static List<ConstractionElement> getAll() {
		EntityManager em = null;
		List<ConstractionElement> list = null;
		try {
			em = EMF.get().createEntityManager();
			Query q = em.createQuery("select ce from ConstractionElement ce ");
			list = new ArrayList<ConstractionElement>(q.getResultList());
		} finally {
			em.close();
		}
		return list;
	}

	public static ConstractionElement create(ConstractionElement element) {
		EntityManager em = null;
		try {
			em = EMF.get().createEntityManager();
			em.persist(element);
		} finally {
			em.close();
		}
		return element;
	}
}
