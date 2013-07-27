package ru.buildmgr.web.dataModel.store;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ru.buildmgr.web.dataModel.storemodel.ConstractionElementType;

public class SConstractionElementTypeUtils {

	@SuppressWarnings("unchecked")
	public static List<ConstractionElementType> getAll() {
		EntityManager em = null;
		List<ConstractionElementType> beers = null;
		try {
			em = EMF.get().createEntityManager();
			Query q = em.createQuery("select cet from ConstractionElementType cet ");
			beers = new ArrayList<ConstractionElementType>(q.getResultList());
		} finally {
			em.close();
		}
		return beers;
	}

	public static ConstractionElementType create(ConstractionElementType elementType) {
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
