package ru.buildmgr.web.request.ditectory.client.forms;

import java.util.List;

import ru.buildmgr.web.common.client.forms.CommonForm;
import ru.buildmgr.web.dataModel.clientmodel.CMConstractionElement;
import ru.buildmgr.web.dataModel.clientservices.DirectoryService;
import ru.buildmgr.web.dataModel.clientservices.DirectoryServiceAsync;
import ru.buildmgr.web.request.ditectory.client.grids.ElemetsGrid;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

public class EmelentManagerForm extends CommonForm {

	private DirectoryServiceAsync service;

	public EmelentManagerForm() {
		super();
		service = GWT.create(DirectoryService.class);
		service.greetServer("test", new AsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				setHeadingText(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				setHeadingText("ERROR1");
			}
		});

		service.getAllCMConstractionElements(new AsyncCallback<List<CMConstractionElement>>() {

			@Override
			public void onSuccess(List<CMConstractionElement> result) {
				ElemetsGrid grid = new ElemetsGrid(result);
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
		return "Упревление строительными изделиями";
	}

	@Override
	protected void setButtons() {
		addButton(getButton("Cоздать", new SelectHandler() {

			@Override
			public void onSelect(SelectEvent event) {
				final Window window = new Window();
				window.setPixelSize(500, 300);
				window.setModal(true);
				window.setBlinkModal(true);
				window.setHeadingText("Создание элемента");
				TextButton cancelButton = new TextButton("Отмена");
				cancelButton.addSelectHandler(new SelectHandler() {

					@Override
					public void onSelect(SelectEvent event) {
						window.hide();
					}
				});
				TextButton saveButton = new TextButton("Сохранить");
				saveButton.addSelectHandler(new SelectHandler() {

					@Override
					public void onSelect(SelectEvent event) {
						CMConstractionElement element = new CMConstractionElement();
						element.setName("test1");
						element.setTypeName("type name");
						service.createElement(element, new AsyncCallback<CMConstractionElement>() {

							@Override
							public void onSuccess(CMConstractionElement result) {
								// TODO Auto-generated method stub

							}

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub

							}
						});
						window.hide();
					}
				});
				window.addButton(saveButton);
				window.addButton(cancelButton);
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