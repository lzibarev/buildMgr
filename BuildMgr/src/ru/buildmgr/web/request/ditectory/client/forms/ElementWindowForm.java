package ru.buildmgr.web.request.ditectory.client.forms;

import ru.buildmgr.web.dataModel.clientmodel.CMConstractionElement;
import ru.buildmgr.web.request.ditectory.client.RequestDirectory;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;

public class ElementWindowForm extends Window {

	private TextField elementName;
	private TextField elementClassName;

	public ElementWindowForm() {
		VerticalLayoutContainer p = new VerticalLayoutContainer();

		elementName = new TextField();
		elementName.setAllowBlank(false);
		elementName.setEmptyText("Введите название элемента...");
		p.add(new FieldLabel(elementName, "Название"), new VerticalLayoutData(1, -1));
		add(p);

		elementClassName = new TextField();
		elementClassName.setAllowBlank(false);
		elementClassName.setEmptyText("Введите класс...");
		p.add(new FieldLabel(elementClassName, "Класс фильтра (этаж)"), new VerticalLayoutData(1, -1));
		add(p);

		setPixelSize(500, 300);
		setModal(true);
		setBlinkModal(true);
		setHeadingText("Создание элемента");
		TextButton cancelButton = new TextButton("Отмена");
		cancelButton.addSelectHandler(new CancelSelectHandler(this));
		TextButton saveButton = new TextButton("Сохранить");
		saveButton.addSelectHandler(new SaveSelectHandler(this));
		addButton(saveButton);
		addButton(cancelButton);
	}

	private static class SaveSelectHandler extends CancelSelectHandler {

		public SaveSelectHandler(Window window) {
			super(window);
		}

		@Override
		public void onSelect(SelectEvent event) {
			ElementWindowForm form = (ElementWindowForm) window;
			CMConstractionElement element = new CMConstractionElement();
			element.setName(form.elementName.getValue());
			element.setClassName(form.elementClassName.getValue());
			element.setTypeName("type name");

			RequestDirectory.getServices().createElement(element, new AsyncCallback<CMConstractionElement>() {

				@Override
				public void onSuccess(CMConstractionElement result) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub

				}
			});
			super.onSelect(event);
		}
	}

	private static class CancelSelectHandler implements SelectHandler {
		protected Window window;

		public CancelSelectHandler(Window window) {
			this.window = window;
		}

		@Override
		public void onSelect(SelectEvent event) {
			window.hide();
		}

	}

}
