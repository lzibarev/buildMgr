package ru.buildmgr.web.request.ditectory.client.grids;

import java.util.ArrayList;
import java.util.List;

import ru.buildmgr.web.dataModel.clientmodel.CMConstractionElement;
import ru.buildmgr.web.dataModel.clientmodel.CMConstractionElementProperties;
import ru.buildmgr.web.dataModel.demostore.DSConstractionElementUtils;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

public class ElemetsGrid implements IsWidget {

	private static final CMConstractionElementProperties props = GWT.create(CMConstractionElementProperties.class);

	@Override
	public Widget asWidget() {		
		ColumnConfig<CMConstractionElement, String> nameCol = new ColumnConfig<CMConstractionElement, String>(
				props.name(), 50, "Name");
		ColumnConfig<CMConstractionElement, String> typeCol = new ColumnConfig<CMConstractionElement, String>(
				props.typeName(), 100, "Element Type");
		ColumnConfig<CMConstractionElement, String> classCol = new ColumnConfig<CMConstractionElement, String>(
				props.className(), 100, "ClassFilter");
		ColumnConfig<CMConstractionElement, String> addressCol = new ColumnConfig<CMConstractionElement, String>(
				props.objectAddressName(), 100, "Object Address");

		List<ColumnConfig<CMConstractionElement, ?>> l = new ArrayList<ColumnConfig<CMConstractionElement, ?>>();
		l.add(nameCol);
		l.add(typeCol);
		l.add(classCol);
		l.add(addressCol);
		ColumnModel<CMConstractionElement> cm = new ColumnModel<CMConstractionElement>(l);

		ListStore<CMConstractionElement> store = new ListStore<CMConstractionElement>(props.key());
		store.addAll(DSConstractionElementUtils.getConstractionElements());

		final Grid<CMConstractionElement> grid = new Grid<CMConstractionElement>(store, cm);
		grid.getView().setAutoExpandColumn(nameCol);
		grid.getView().setStripeRows(true);
		grid.getView().setColumnLines(true);
		grid.setBorders(false);

		grid.setColumnReordering(true);
		grid.setStateful(true);
		grid.setStateId("gridExample");

		return grid;
	}
}
