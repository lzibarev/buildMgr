package ru.buildmgr.web.request.ditectory.client.forms;

import ru.buildmgr.web.common.client.forms.handlers.CancelSelectHandler;
import ru.buildmgr.web.dataModel.clientmodel.CMConstractionElementType;
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

public class ElementTypeWindowForm extends Window {

	private TextField elementTypeName;
	private final EmelentTypeManagerForm formMgr;

	public ElementTypeWindowForm(EmelentTypeManagerForm formMgr) {
		super();
		
		this.formMgr = formMgr;
		
		add(getInfoContainer());

		setPixelSize(500, 300);
		setModal(true);
		setBlinkModal(true);
		setHeadingText("Тип элемента");
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
		elementTypeName.setEmptyText("Введите название типа элемента...");
		p.add(new FieldLabel(elementTypeName, "Название"), new VerticalLayoutData(1, -1));

		return p;

	}

	private class SaveSelectHandler extends CancelSelectHandler {

		public SaveSelectHandler(Window window) {
			super(window);
		}

		@Override
		public void onSelect(SelectEvent event) {
			ElementTypeWindowForm form = (ElementTypeWindowForm) window;
			CMConstractionElementType elementType = new CMConstractionElementType();
			elementType.setName(form.elementTypeName.getValue());

			RequestDirectory.getServices().createElementType(elementType,
					new AsyncCallback<CMConstractionElementType>() {

						@Override
						public void onSuccess(CMConstractionElementType result) {
							Info.display("Создан тип элемента", result.getName());
							formMgr.updateData();
						}

						@Override
						public void onFailure(Throwable caught) {
							Info.display("Ошибка","Ошибка при создании типа элемента<br/>"+caught.getMessage());
						}
					});
			super.onSelect(event);
		}
	}

}
