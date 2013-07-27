package ru.buildmgr.web.dataModel.demostore;

import java.util.ArrayList;
import java.util.List;

import ru.buildmgr.web.dataModel.clientmodel.CMConstractionElement;

public class DSConstractionElementUtils {

	private static String[] NAMES = { "name1", "name2", "name3", "name4" };
	private static List<CMConstractionElement> list;
	static {
		list = new ArrayList<CMConstractionElement>();

		int index = 1;
		for (String name : NAMES) {
			CMConstractionElement e = new CMConstractionElement();
			e.setName(name);

			e.setId("id " + index);
			e.setClassName("class name " + index);
			e.setObjectAddressName("object address " + index);
			e.setTypeName("type name " + index);
			list.add(e);
			index++;
		}
	}

	public static List<CMConstractionElement> getConstractionElements() {
		return list;
	}

	public static CMConstractionElement create(CMConstractionElement element) {
		list.add(element);
		return element;
	}

}
