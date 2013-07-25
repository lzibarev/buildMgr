package ru.buildmgr.web.dataModel.clientmodel;

import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface CMConstractionElementProperties extends PropertyAccess<CMConstractionElement> {
	@Path("id")
	ModelKeyProvider<CMConstractionElement> key();

	@Path("name")
	LabelProvider<CMConstractionElement> nameLabel();

	ValueProvider<CMConstractionElement, String> name();

	ValueProvider<CMConstractionElement, String> className();

	ValueProvider<CMConstractionElement, String> typeName();

	ValueProvider<CMConstractionElement, String> objectAddressName();

}
