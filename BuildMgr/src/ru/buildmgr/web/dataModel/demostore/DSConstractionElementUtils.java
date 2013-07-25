package ru.buildmgr.web.dataModel.demostore;

import java.util.ArrayList;
import java.util.List;

import ru.buildmgr.web.dataModel.clientmodel.CMConstractionElement;

public class DSConstractionElementUtils {

	public static List<CMConstractionElement> getConstractionElements() {
		List<CMConstractionElement> list = new ArrayList<CMConstractionElement>();
		CMConstractionElement e = new CMConstractionElement();
		e.setId("id 1");
		e.setClassName("class name 1");
		e.setName("name 1");
		e.setObjectAddressName("object address 1");
		e.setTypeName("type name 1");
		list.add(e);
		return list;
	}
}
