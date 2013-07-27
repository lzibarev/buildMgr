package ru.buildmgr.web.dataModel.clientmodel;

import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface CMConstractionElementTypeProperties extends PropertyAccess<CMConstractionElementType> {
	@Path("id")
	ModelKeyProvider<CMConstractionElementType> key();

	@Path("name")
	LabelProvider<CMConstractionElementType> nameLabel();

	ValueProvider<CMConstractionElementType, String> name();
}
