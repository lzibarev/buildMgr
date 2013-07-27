package ru.buildmgr.web.dataModel.demostore;

import java.util.ArrayList;
import java.util.List;

import ru.buildmgr.web.dataModel.clientmodel.CMConstractionElement;

public class DSConstractionElementUtils {

	private static String[] NAMES = {"name1", "name2", "name3", "name4"};
	
	public static List<CMConstractionElement> getConstractionElements() {
		List<CMConstractionElement> list = new ArrayList<CMConstractionElement>();
		
		int index = 1;
		for (String name : NAMES) {
			CMConstractionElement e = new CMConstractionElement();
			e.setName(name);
			
			e.setId("id "+index);
			e.setClassName("class name "+index);
			e.setObjectAddressName("object address "+index);
			e.setTypeName("type name "+index);
			list.add(e);
			index ++;
		}
		return list;
	}
	
	
}
