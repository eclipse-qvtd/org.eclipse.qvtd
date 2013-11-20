/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.debug.ui.launching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.qvtd.debug.launching.LaunchConstants;
import org.eclipse.qvtd.debug.ui.QVTdDebugUIPlugin;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.xtext.qvtimperative.utilities.QVTiXtextEvaluator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

public class MainTab extends AbstractLaunchConfigurationTab implements ModifyListener, LaunchConstants
{
	private static final Logger logger = Logger.getLogger(AbstractLaunchConfigurationTab.class);

	protected Text txPath;
	protected Button txBrowseWS;
	protected Button txBrowseFile;
	protected Group inputsGroup;
	protected Group outputsGroup;
	protected @Nullable MetaModelManager metaModelManager;		// FIXME Add a dispose() when not visible for a long time

	@Override
	public boolean canSave() {
		ResourceSet resourceSet = getMetaModelManager().getExternalResourceSet();
		URIConverter uriConverter = resourceSet.getURIConverter();
		String txName = txPath.getText();
		URI txURI = URI.createURI(txName, true);
		boolean txExists = uriConverter.exists(txURI, null);
		if (!txExists){
			setErrorMessage("Selected file " + txName + " does not exist");
			return false;
		}
		else {
			setErrorMessage(null);
			return true;			
		}
	}

	@SuppressWarnings("null")
	public void createControl(Composite parent) {
		Composite control = createForm(parent);
		txPath.addModifyListener(this);
		LaunchingUtils.prepareBrowseWorkspaceButton(txBrowseWS, txPath, false);
		LaunchingUtils.prepareBrowseFileSystemButton(txBrowseFile, txPath, false);
		refreshParametersGroup(inputsGroup, SWT.NONE, EMPTY_MAP);
		refreshParametersGroup(outputsGroup, SWT.SAVE, EMPTY_MAP);
		control.setBounds(0, 0, 300, 300);
		control.layout();
		control.pack();
		canSave();
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public Composite createForm(Composite parent) {
		Composite control = new Composite(parent, SWT.NONE);
		setControl(control);
		control.setLayout(new GridLayout(1, false));
		control.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		Group txGroup = new Group(control, SWT.NONE);
		txGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		txGroup.setText("Transformation");
		txGroup.setLayout(new GridLayout(3, false));

		txPath = new Text(txGroup, SWT.BORDER);
		GridData gd_txPath = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txPath.minimumWidth = 100;
		txPath.setLayoutData(gd_txPath);
		txBrowseWS = new Button(txGroup, SWT.NONE);
		txBrowseWS.setText("Browse Workspace...");
		txBrowseFile = new Button(txGroup, SWT.NONE);
		txBrowseFile.setText("Browse File...");

		inputsGroup = new Group(control, SWT.NONE);
		inputsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		inputsGroup.setText("Inputs");
		inputsGroup.setLayout(new GridLayout(1, false));

		outputsGroup = new Group(control, SWT.NONE);
		outputsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		outputsGroup.setText("Outputs");
		outputsGroup.setLayout(new GridLayout(1, false));
		return control;
	}
	
	@Override
	public void dispose() {
		MetaModelManager metaModelManager2 = metaModelManager;
		if (metaModelManager2 != null) {
			metaModelManager2.dispose();
			metaModelManager = null;
		}
		super.dispose();
	}

	@Override
	public Image getImage() {
		return QVTdDebugUIPlugin.getDefault().createImage("icons/QVTiModelFile.gif");
	}

	protected @NonNull MetaModelManager getMetaModelManager() {
		MetaModelManager metaModelManager2 = metaModelManager;
		if (metaModelManager2 == null) {
			metaModelManager = metaModelManager2 = new MetaModelManager();
		}
		return metaModelManager2;
	}

	public String getName() {
		return "Main";
	}

	@SuppressWarnings("null")
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			txPath.setText(configuration.getAttribute(TX_KEY, ""));
			Map<String, String> inMap = configuration.getAttribute(IN_KEY, EMPTY_MAP);
			Map<String, String> outMap = configuration.getAttribute(OUT_KEY, EMPTY_MAP);
			refreshParametersGroup(inputsGroup, SWT.NONE, inMap);
			refreshParametersGroup(outputsGroup, SWT.SAVE, outMap);
			canSave();
			updateLaunchConfigurationDialog();
		} catch (CoreException e) {
			//Ignore
		}
	}

	private boolean launchConfigurationExists(@NonNull String name) {
		ILaunchConfiguration[] cs = new ILaunchConfiguration[]{};
		try {
			cs = getLaunchManager().getLaunchConfigurations();
		}
		catch (CoreException ex) {
			logger.error("Failed to access ILaunchConfiguration", ex);
		}
		for (int i = 0; i < cs.length; i++) {
			if (name.equals(cs[i].getName())){
				return true;
			}
		}
		return false;
	}

	public void modifyText(ModifyEvent e) {
		if (txPath.isDisposed()) {
			return;
		}
		String txName = txPath.getText();
		@SuppressWarnings("null")@NonNull URI txURI = URI.createURI(txName, true);
		try {
			QVTiXtextEvaluator xtextEvaluator = new QVTiXtextEvaluator(getMetaModelManager(), txURI);
			Transformation transformation = xtextEvaluator.getTransformation();
			Set<TypedModel> inputs = new HashSet<TypedModel>();
			Set<TypedModel> outputs = new HashSet<TypedModel>();
			Map<String, String> inputMap = new HashMap<String, String>();
			Map<String, String> outputMap = new HashMap<String, String>();
			for (Rule rule : transformation.getRule()) {
				if (rule instanceof Mapping) {
					Mapping mapping = (Mapping)rule;
					for (Domain domain : mapping.getDomain()) {
						if (domain instanceof CoreDomain) {
							CoreDomain coreDomain = (CoreDomain)domain;
							BottomPattern bottomPattern = coreDomain.getBottomPattern();
							TypedModel typedModel = coreDomain.getTypedModel();
							if (bottomPattern.getRealizedVariable().isEmpty()) {
								if (inputs.add(typedModel)) {
									inputMap.put(typedModel.getName(), "");
								}
							}
							else {
								if (outputs.add(typedModel)) {
									outputMap.put(typedModel.getName(), "");
								}
							}
						}
					}
				}
			}
			for (String key : outputMap.keySet()) {
				inputMap.remove(key);
			}
			@SuppressWarnings("null")@NonNull Group inputsGroup2 = inputsGroup;
			@SuppressWarnings("null")@NonNull Group outputsGroup2 = outputsGroup;
			refreshParametersGroup(inputsGroup2, SWT.NONE, inputMap);
			refreshParametersGroup(outputsGroup2, SWT.SAVE, outputMap);
		}
		catch (Exception ex) {
			setErrorMessage("Failed to load '" + txName + "': " + ex.toString());
		}
		canSave();
		updateLaunchConfigurationDialog();
	}

	// Return a new launch configuration name that does not
	// already exists
	protected String newLaunchConfigurationName(@NonNull String fileName) {
		if (!launchConfigurationExists(fileName)) {
			return fileName;
		}
		for (int i = 1; true; i++) {
			String configurationName = fileName + " (" + i + ")";
			if (!launchConfigurationExists(configurationName)) {
				return configurationName;
			}
		}
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(TX_KEY, txPath.getText());
		Map<String, String> inputMap = new HashMap<String, String>();
		for (Control child : inputsGroup.getChildren()) {
			if (child instanceof ParameterRow) {
				ParameterRow row = (ParameterRow)child;
				inputMap.put(row.name.getText(), row.path.getText());
			}
		}
		configuration.setAttribute(IN_KEY, inputMap);
		Map<String, String> outputMap = new HashMap<String, String>();
		for (Control child : outputsGroup.getChildren()) {
			if (child instanceof ParameterRow) {
				ParameterRow row = (ParameterRow)child;
				outputMap.put(row.name.getText(), row.path.getText());
			}
		}
		configuration.setAttribute(OUT_KEY, outputMap);
	}

	protected void refreshParametersGroup(@NonNull Group group, int style, Map<String, String> map) {
		List<String> keys = new ArrayList<String>(map.keySet());
		Collections.sort(keys);;
		Control[] children = group.getChildren();
		int iMax = Math.min(children.length, keys.size());
		int i = 0;
		for (; i < iMax; i++) {
			ParameterRow row = (ParameterRow)children[0];
			String string = keys.get(i);
			row.name.setText(string);
			row.path.setText(map.get(string));
		}
		for (; i < keys.size(); i++) {
			@SuppressWarnings("null")@NonNull String string = keys.get(i);
			@SuppressWarnings("null")@NonNull String parameterPath = map.get(string);
			new ParameterRow(this, group, style, string, parameterPath);
		}
		for (; i < children.length; i++) {
			children[i].dispose();
		}
		group.layout();
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench != null) {
			IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
			if (workbenchWindow != null) {
				IWorkbenchPage activePage = workbenchWindow.getActivePage();
				if (activePage != null) {
					IEditorPart activeEditor = activePage.getActiveEditor();
					if (activeEditor != null) {
						IEditorInput editorInput = activeEditor.getEditorInput();
						if (editorInput instanceof FileEditorInput) {
							IFile iFile = ((FileEditorInput)editorInput).getFile();
							String activeEditorName = iFile.getName();
							if (activeEditorName.length() > 0){
								configuration.rename(newLaunchConfigurationName(activeEditorName));
								configuration.setAttribute(TX_KEY, iFile.getFullPath().toString());
								configuration.setAttribute(IN_KEY, EMPTY_MAP);
								configuration.setAttribute(OUT_KEY, EMPTY_MAP);
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void updateLaunchConfigurationDialog() {
		super.updateLaunchConfigurationDialog();
	}
}
