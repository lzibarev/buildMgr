package ru.buildmgr.web.request.ditectory.client.forms;

import ru.buildmgr.web.common.client.forms.handlers.CancelSelectHandler;
import ru.buildmgr.web.dataModel.clientmodel.CMConstractionObjectAddress;
import ru.buildmgr.web.request.ditectory.client.RequestDirectory;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.Container;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.info.Info;

public class ObjectAddressWindowForm extends Window {

	private TextField elementTypeName;

	public ObjectAddressWindowForm() {
		add(getInfoContainer());

		setPixelSize(500, 100);
		setModal(true);
		setBlinkModal(true);
		setHeadingText("Адрес");
		TextButton cancelButton = new TextButton("Отмена");
		cancelButton.addSelectHandler(new CancelSelectHandler(this));
		TextButton saveButton = new TextButton("Сохранить");
		saveButton.addSelectHandler(new SaveSelectHandler(this));
		addButton(saveButton);
		addButton(cancelButton);
	}

	private Container getInfoContainer() {
		VerticalLayoutContainer p = new VerticalLayoutContainer();

		elementTypeName = new TextField();
		elementTypeName.setAllowBlank(false);
		elementTypeName.setEmptyText("Введите адрес...");
		p.add(new FieldLabel(elementTypeName, "Адрес"), new VerticalLayoutData(1, -1));

		return p;

	}

	private static class SaveSelectHandler extends CancelSelectHandler {

		public SaveSelectHandler(Window window) {
			super(window);
		}

		@Override
		public void onSelect(SelectEvent event) {
			ObjectAddressWindowForm form = (ObjectAddressWindowForm) window;
			CMConstractionObjectAddress elementType = new CMConstractionObjectAddress();
			elementType.setName(form.elementTypeName.getValue());

			RequestDirectory.getServices().createObjectAddress(elementType,
					new AsyncCallback<CMConstractionObjectAddress>() {

						@Override
						public void onSuccess(CMConstractionObjectAddress result) {
							Info.display("Создан адрес", result.getName());
						}

						@Override
						public void onFailure(Throwable caught) {
							Info.display("Ошибка","Ошибка при создании адреса<br/>"+caught.getMessage());
						}
					});
			super.onSelect(event);
		}
	}

}
