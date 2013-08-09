package ru.buildmgr.web.request.ditectory.client.grids;

import java.util.ArrayList;
import java.util.List;

import ru.buildmgr.web.dataModel.clientmodel.CMConstractionObjectAddress;
import ru.buildmgr.web.dataModel.clientmodel.CMConstractionObjectAddressProperties;


import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

public class ObjectAddressesGrid implements IsWidget {

	private static final CMConstractionObjectAddressProperties props = GWT
			.create(CMConstractionObjectAddressProperties.class);

	private List<CMConstractionObjectAddress> elements;

	public ObjectAddressesGrid(List<CMConstractionObjectAddress> elements) {
		this.elements = elements;
	}

	@Override
	public Widget asWidget() {
		ColumnConfig<CMConstractionObjectAddress, String> nameCol = new ColumnConfig<CMConstractionObjectAddress, String>(
				props.name(), 400, "Строительная площадка");

		List<ColumnConfig<CMConstractionObjectAddress, ?>> l = new ArrayList<ColumnConfig<CMConstractionObjectAddress, ?>>();
		l.add(nameCol);
		ColumnModel<CMConstractionObjectAddress> cm = new ColumnModel<CMConstractionObjectAddress>(l);

		ListStore<CMConstractionObjectAddress> store = new ListStore<CMConstractionObjectAddress>(props.key());
		store.addAll(elements);

		final Grid<CMConstractionObjectAddress> grid = new Grid<CMConstractionObjectAddress>(store, cm);
		grid.getView().setAutoExpandColumn(nameCol);
		grid.getView().setStripeRows(true);
		grid.getView().setColumnLines(true);
		grid.setBorders(false);

		grid.setColumnReordering(true);
		grid.setStateful(true);
		grid.setStateId("ElemetsTypesGrid");

		return grid;
	}
}
