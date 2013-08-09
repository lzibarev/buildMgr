package ru.buildmgr.web.request.ditectory.client.forms;

import java.util.List;

import ru.buildmgr.web.common.client.forms.CommonForm;
import ru.buildmgr.web.dataModel.clientmodel.CMConstractionElement;
import ru.buildmgr.web.request.ditectory.client.RequestDirectory;
import ru.buildmgr.web.request.ditectory.client.grids.ElemetsGrid;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

public class EmelentManagerForm extends CommonForm {

	public EmelentManagerForm() {
		super();
		RequestDirectory.getServices().getAllCMConstractionElements(new AsyncCallback<List<CMConstractionElement>>() {

			@Override
			public void onSuccess(List<CMConstractionElement> result) {
				ElemetsGrid grid = new ElemetsGrid(result);
				add(grid);
			}

			@Override
			public void onFailure(Throwable caught) {
				setHeadingText("ERROR1");
			}
		});

	}

	@Override
	protected String getTitleName() {
		return "Упревление строительными изделиями";
	}

	@Override
	protected void setButtons() {
		addButton(getButton("Cоздать", new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				ElementWindowForm window = new ElementWindowForm();
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