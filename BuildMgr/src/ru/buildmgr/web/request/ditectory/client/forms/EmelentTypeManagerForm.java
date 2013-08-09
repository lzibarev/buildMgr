package ru.buildmgr.web.request.ditectory.client.forms;

import java.util.List;

import ru.buildmgr.web.common.client.forms.CommonForm;
import ru.buildmgr.web.dataModel.clientmodel.CMConstractionElementType;
import ru.buildmgr.web.request.ditectory.client.RequestDirectory;
import ru.buildmgr.web.request.ditectory.client.grids.ElemetsTypesGrid;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.sencha.gxt.widget.core.client.info.Info;

public class EmelentTypeManagerForm extends CommonForm {

	private final ElemetsTypesGrid grid;

	public EmelentTypeManagerForm() {
		super();
		grid = new ElemetsTypesGrid();
		updateData();
	}
	
	public void updateData(){
		RequestDirectory.getServices().getAllCMConstractionElementTypes(new AsyncCallback<List<CMConstractionElementType>>() {

			@Override
			public void onSuccess(List<CMConstractionElementType> result) {
				grid.setElemetsTypes(result);
				add(grid);
			}

			@Override
			public void onFailure(Throwable caught) {
				Info.display("Ошибка","Ошибка при обновлении данных <br/>"+caught.getMessage());
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
				ElementTypeWindowForm window = new ElementTypeWindowForm(EmelentTypeManagerForm.this);
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