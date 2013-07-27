package ru.buildmgr.web.request.ditectory.client.forms;

import java.util.List;

import ru.buildmgr.web.common.client.forms.CommonForm;
import ru.buildmgr.web.dataModel.clientmodel.CMConstractionElementType;
import ru.buildmgr.web.request.ditectory.client.RequestDirectory;
import ru.buildmgr.web.request.ditectory.client.grids.ElemetsTypesGrid;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

public class EmelentTypeManagerForm extends CommonForm {


	public EmelentTypeManagerForm() {
		super();
		RequestDirectory.getServices().getAllCMConstractionElementTypes(new AsyncCallback<List<CMConstractionElementType>>() {

			@Override
			public void onSuccess(List<CMConstractionElementType> result) {
				ElemetsTypesGrid grid = new ElemetsTypesGrid(result);
				add(grid);
			}

			@Override
			public void onFailure(Throwable caught) {
				setHeadingText("ERROR2");
			}
		});

	}

	@Override
	protected String getTitleName() {
		return "Упревление типами строительных изделий";
	}

	@Override
	protected void setButtons() {
		addButton(getButton("Cоздать", new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ElementTypeWindowForm window = new ElementTypeWindowForm();
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