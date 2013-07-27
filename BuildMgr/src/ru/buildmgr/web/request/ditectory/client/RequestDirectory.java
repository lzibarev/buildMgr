package ru.buildmgr.web.request.ditectory.client;

import ru.buildmgr.web.common.client.WebCommonEntryPoint;
import ru.buildmgr.web.dataModel.clientservices.DirectoryService;
import ru.buildmgr.web.dataModel.clientservices.DirectoryServiceAsync;
import ru.buildmgr.web.request.ditectory.client.forms.EmelentManagerForm;
import ru.buildmgr.web.request.ditectory.client.forms.EmelentTypeManagerForm;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

public class RequestDirectory extends WebCommonEntryPoint implements EntryPoint {

	private static String MAIN_CONTAINER = "mainContainer";

	private static DirectoryServiceAsync service;

	@Override
	public void onModuleLoad() {
		super.onModuleLoad();
	}

	@Override
	protected void showModule() {
		initService();
		EmelentManagerForm elementForm = new EmelentManagerForm();
		EmelentTypeManagerForm elementTypeform = new EmelentTypeManagerForm();
		getMainContainer().add(elementForm);
		getMainContainer().add(elementTypeform);
	}

	@Override
	protected RootPanel getRootPanel() {
		return getMainContainer();
	}

	private void initService() {
		service = GWT.create(DirectoryService.class);
	}

	public static RootPanel getMainContainer() {
		return RootPanel.get(MAIN_CONTAINER);
	}

	public static DirectoryServiceAsync getServices() {
		return service;
	}

}
