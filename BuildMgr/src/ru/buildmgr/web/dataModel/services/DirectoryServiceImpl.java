package ru.buildmgr.web.dataModel.services;

import java.util.ArrayList;
import java.util.List;

import ru.buildmgr.web.dataModel.clientmodel.CMConstractionElement;
import ru.buildmgr.web.dataModel.clientmodel.CMConstractionElementType;
import ru.buildmgr.web.dataModel.clientservices.DirectoryService;
import ru.buildmgr.web.dataModel.demostore.DSConstractionElementUtils;
import ru.buildmgr.web.dataModel.store.SConstractionElementTypeUtils;
import ru.buildmgr.web.dataModel.store.SConstractionElementUtils;
import ru.buildmgr.web.dataModel.storemodel.ConstractionElement;
import ru.buildmgr.web.dataModel.storemodel.ConstractionElementType;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class DirectoryServiceImpl extends RemoteServiceServlet implements DirectoryService {

	private static final boolean TEST_MODE = false;

	@Override
	public String greetServer(String name) throws IllegalArgumentException {
		return "Hi " + name + " it is DirectoryService";
	}

	@Override
	public List<CMConstractionElement> getAllCMConstractionElements() {
		if (TEST_MODE) {
			return DSConstractionElementUtils.getConstractionElements();
		}
		List<CMConstractionElement> result = new ArrayList<CMConstractionElement>();
		List<ConstractionElement> list = SConstractionElementUtils.getAll();
		for (ConstractionElement e : list) {
			result.add(e.asClient());
		}
		return result;
	}

	@Override
	public CMConstractionElement createElement(CMConstractionElement source) throws IllegalArgumentException {
		if (TEST_MODE) {
			return DSConstractionElementUtils.create(source);
		}
		ConstractionElement element = new ConstractionElement(source);
		element = SConstractionElementUtils.create(element);
		return element.asClient();
	}

	@Override
	public CMConstractionElementType createElementType(CMConstractionElementType source)
			throws IllegalArgumentException {
		ConstractionElementType element = new ConstractionElementType(source);
		element = SConstractionElementTypeUtils.create(element);
		return element.asClient();
	}

	@Override
	public List<CMConstractionElementType> getAllCMConstractionElementTypes() {
		List<CMConstractionElementType> result = new ArrayList<CMConstractionElementType>();
		List<ConstractionElementType> list = SConstractionElementTypeUtils.getAll();
		for (ConstractionElementType e : list) {
			result.add(e.asClient());
		}
		return result;
	}

}
