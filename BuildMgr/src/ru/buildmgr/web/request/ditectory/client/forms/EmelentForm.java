package ru.buildmgr.web.request.ditectory.client.forms;

import ru.buildmgr.web.common.client.forms.CommonForm;

import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;

public class EmelentForm extends CommonForm {

	
	
	@Override
	protected void init() {
		super.init();
	}

	@Override
	protected String getTitleName() {
		return "Элемент";
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
