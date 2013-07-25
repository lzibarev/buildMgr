package ru.buildmgr.web.request.ditectory.client.forms;

import ru.buildmgr.web.common.client.forms.CommonForm;
import ru.buildmgr.web.request.ditectory.client.DirectoryService;
import ru.buildmgr.web.request.ditectory.client.DirectoryServiceAsync;
import ru.buildmgr.web.request.ditectory.client.grids.ElemetsGrid;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

public class EmelentManagerForm extends CommonForm {

	public EmelentManagerForm() {
		super();
		DirectoryServiceAsync service = GWT.create(DirectoryService.class);
		service.greetServer("test", new AsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				setHeadingText(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				setHeadingText("ERROR");
			}
		});

	}

	@Override
	protected void init() {
		super.init();
		ElemetsGrid grid = new ElemetsGrid();
		add(grid);
	}

	@Override
	protected String getTitleName() {
		return "Упревление строительными изделиями";
	}

	@Override
	protected void setButtons() {
		addButton(getExitButton(new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				// TODO Auto-generated method stub

			}
		}));
	}

}