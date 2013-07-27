package ru.buildmgr.web.dataModel.store;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ru.buildmgr.web.dataModel.storemodel.ConstractionElement;

public class SConstractionElementUtils {

	public static List<ConstractionElement> getTop10() {
		EntityManager em = null;
		List<ConstractionElement> beers = null;
		try {
			em = EMF.get().createEntityManager();
			Query q = em.createQuery("select ce from ConstractionElement ce LIMIT 10 ");
			beers = new ArrayList<ConstractionElement>(q.getResultList());
		} finally {
			if (em != null)
				em.close();
		}
		return beers;
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
