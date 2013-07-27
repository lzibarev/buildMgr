package ru.buildmgr.web.request.ditectory.client.grids;

import java.util.ArrayList;
import java.util.List;

import ru.buildmgr.web.dataModel.clientmodel.CMConstractionElement;
import ru.buildmgr.web.dataModel.clientmodel.CMConstractionElementProperties;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

public class ElemetsGrid implements IsWidget {

	private static final CMConstractionElementProperties props = GWT.create(CMConstractionElementProperties.class);

	private List<CMConstractionElement> elements;

	public ElemetsGrid(List<CMConstractionElement> elements) {
		this.elements = elements;
	}

	@Override
	public Widget asWidget() {
		ColumnConfig<CMConstractionElement, String> nameCol = new ColumnConfig<CMConstractionElement, String>(
				props.name(), 200, "Название элемента");
		ColumnConfig<CMConstractionElement, String> typeCol = new ColumnConfig<CMConstractionElement, String>(
				props.typeName(), 200, "Тип элемента");
		ColumnConfig<CMConstractionElement, String> classCol = new ColumnConfig<CMConstractionElement, String>(
				props.className(), 200, "Класс");
		ColumnConfig<CMConstractionElement, String> addressCol = new ColumnConfig<CMConstractionElement, String>(
				props.objectAddressName(), 200, "Адрес строительного объекта");

		List<ColumnConfig<CMConstractionElement, ?>> l = new ArrayList<ColumnConfig<CMConstractionElement, ?>>();
		l.add(nameCol);
		l.add(typeCol);
		l.add(classCol);
		l.add(addressCol);
		ColumnModel<CMConstractionElement> cm = new ColumnModel<CMConstractionElement>(l);

		ListStore<CMConstractionElement> store = new ListStore<CMConstractionElement>(props.key());
		store.addAll(elements);

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
