package ru.buildmgr.web.request.ditectory.client.grids;

import java.util.ArrayList;
import java.util.List;

import ru.buildmgr.web.dataModel.clientmodel.CMConstractionElementType;
import ru.buildmgr.web.dataModel.clientmodel.CMConstractionElementTypeProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

public class ElemetsTypesGrid implements IsWidget {

	private static final CMConstractionElementTypeProperties props = GWT
			.create(CMConstractionElementTypeProperties.class);

	private List<CMConstractionElementType> elements;

	public ElemetsTypesGrid(List<CMConstractionElementType> elements) {
		this.elements = elements;
	}

	@Override
	public Widget asWidget() {
		ColumnConfig<CMConstractionElementType, String> nameCol = new ColumnConfig<CMConstractionElementType, String>(
				props.name(), 400, "Название типа изделия");

		List<ColumnConfig<CMConstractionElementType, ?>> l = new ArrayList<ColumnConfig<CMConstractionElementType, ?>>();
		l.add(nameCol);
		ColumnModel<CMConstractionElementType> cm = new ColumnModel<CMConstractionElementType>(l);

		ListStore<CMConstractionElementType> store = new ListStore<CMConstractionElementType>(props.key());
		store.addAll(elements);

		final Grid<CMConstractionElementType> grid = new Grid<CMConstractionElementType>(store, cm);
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
