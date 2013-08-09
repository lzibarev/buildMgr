package ru.buildmgr.web.dataModel.clientmodel;

import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface CMConstractionObjectAddressProperties extends PropertyAccess<CMConstractionObjectAddress> {
	
	@Path("id")
	ModelKeyProvider<CMConstractionObjectAddress> key();

	@Path("name")
	LabelProvider<CMConstractionObjectAddress> nameLabel();

	ValueProvider<CMConstractionObjectAddress, String> name();
}
