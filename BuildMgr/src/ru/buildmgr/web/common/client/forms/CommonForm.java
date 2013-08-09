package ru.buildmgr.web.common.client.forms;

import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

public abstract class CommonForm extends FramedPanel {

	public CommonForm() {
		super();
		init();
		setHeadingText(getTitleName());
		setButtons();
		setHeight(150);
	}

	protected void init() {

	}

	protected abstract String getTitleName();

	protected abstract void setButtons();

	protected TextButton getCloseButton(SelectHandler handler) {
		return getButton("Закрыть", handler);
	}

	protected TextButton getExitButton(SelectHandler handler) {
		return getButton("Отмена", handler);
	}

	protected TextButton getNextButton(SelectHandler handler) {
		return getButton("Далее", handler);
	}

	protected TextButton getButton(String name, SelectHandler handler) {
		TextButton button = new TextButton(name);
		button.addSelectHandler(handler);
		return button;
	}

}
