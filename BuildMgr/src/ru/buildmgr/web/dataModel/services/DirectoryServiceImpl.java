package ru.buildmgr.web.dataModel.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ru.buildmgr.web.dataModel.clientmodel.CMConstractionElement;
import ru.buildmgr.web.dataModel.clientservices.DirectoryService;
import ru.buildmgr.web.dataModel.demostore.DSConstractionElementUtils;
import ru.buildmgr.web.dataModel.store.SConstractionElementUtils;
import ru.buildmgr.web.dataModel.storemodel.ConstractionElement;

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
		if (TEST_MODE){
			return DSConstractionElementUtils.getConstractionElements();
		}
		List<CMConstractionElement> result = new ArrayList<CMConstractionElement>();
		List<ConstractionElement> list = SConstractionElementUtils.getTop10();
		for (ConstractionElement e : list) {
			result.add(e.asClient());
		}
		return result;
	}
/**
 * 
 * 		ConstractionElement element = new ConstractionElement();
		element.setName("Created element" + new Date().getTime());
		element.setElementClassName("className");
		element.setElementTypeName("element type name");
		ConstractionElement element2 = SConstractionElementUtils.create(element);
		System.out.println(element2.getKey());
*/
}