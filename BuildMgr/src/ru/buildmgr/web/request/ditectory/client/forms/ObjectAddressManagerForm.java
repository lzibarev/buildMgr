package ru.buildmgr.web.request.ditectory.client.forms;

import java.util.List;

import ru.buildmgr.web.common.client.forms.CommonForm;
import ru.buildmgr.web.dataModel.clientmodel.CMConstractionObjectAddress;
import ru.buildmgr.web.request.ditectory.client.RequestDirectory;
import ru.buildmgr.web.request.ditectory.client.grids.ObjectAddressesGrid;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

public class ObjectAddressManagerForm extends CommonForm {


	public ObjectAddressManagerForm() {
		super();
		RequestDirectory.getServices().getAllCMConstractionObjectAddresses(new AsyncCallback<List<CMConstractionObjectAddress>>() {

			@Override
			public void onSuccess(List<CMConstractionObjectAddress> result) {
				ObjectAddressesGrid grid = new ObjectAddressesGrid(result);
				add(grid);
			}

			@Override
			public void onFailure(Throwable caught) {
				setHeadingText("ERROR3");
			}
		});

	}

	@Override
	protected String getTitleName() {
		return "Упревление адресами строительных площадок";
	}

	@Override
	protected void setButtons() {
		addButton(getButton("Cоздать", new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ObjectAddressWindowForm window = new ObjectAddressWindowForm();
				window.show();
			}
		}));

		addButton(getExitButton(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				// TODO Auto-generated method stub

			}
		}));
	}
}