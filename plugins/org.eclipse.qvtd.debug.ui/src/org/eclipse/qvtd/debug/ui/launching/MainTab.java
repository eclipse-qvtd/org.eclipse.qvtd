/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.ui.launching;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.ui.launching.LaunchingUtils;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.debug.launching.QVTiLaunchConstants;
import org.eclipse.qvtd.debug.ui.QVTdDebugUIPlugin;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public abstract class MainTab extends AbstractMainTab implements QVTiLaunchConstants
{
	protected class DirectionModifyListener implements ModifyListener
	{
		@Override
		public void modifyText(ModifyEvent e) {
			if (!directionModified) {
				directionModified = true;
				updateLaunchConfigurationDialog();
			}
		}

	}
	protected class TransformationModifyListener implements ModifyListener
	{
		@Override
		public void modifyText(ModifyEvent e) {
			if (!txModified) {
				txModified = true;
				updateLaunchConfigurationDialog();
			}
		}

	}

	protected Text txPath;
	protected Button txBrowseWS;
	protected Button txBrowseFile;
	protected Group inputsGroup;
	protected Group outputsGroup;
	private Composite directionGroup;
	protected Combo modeCombo;
	protected Combo directionCombo;
	protected Button partialCheckButton;
	private Group intermediatesGroup;
	
	/**
	 * Internal flag to suppress redundant recursive updates while initializing controls.
	 */
	protected boolean initializing = false;
	
	private boolean updating = false;
	private boolean txModified = false;
	private Transformation transformation = null;
	private boolean directionModified = false;
	private boolean groupsModified = false;

	protected void addListeners() {
		txPath.addModifyListener(new TransformationModifyListener());
	}

	@Override
	public boolean canSave() {
		assert !initializing;
		ResourceSet resourceSet = getEnvironmentFactory().getResourceSet();
		URIConverter uriConverter = resourceSet.getURIConverter();
		String txName = txPath.getText().trim();
		URI txURI = URI.createURI(txName, true);
		boolean txExists = uriConverter.exists(txURI, null);
		if (!txExists){
			setErrorMessage("Transformation '" + txName + "' does not exist");
			return false;
		}
		if (inputsGroup != null) {
			Control[] children = inputsGroup.getChildren();
			for (int i = 0; i < children.length; i++) {
				ParameterRow row = (ParameterRow)children[i];
				String name = row.name.getText();
				String path = row.path.getText();
				URI inURI = URI.createURI(path, true);
				boolean inExists = uriConverter.exists(inURI, null);
				if (!inExists){
					setErrorMessage("Input '" + name + "': '" + path + "' does not exist");
					return false;
				}
			}
		}
		if (outputsGroup != null) {
			Control[] children = outputsGroup.getChildren();
			for (int i = 0; i < children.length; i++) {
				ParameterRow row = (ParameterRow)children[i];
				String name = row.name.getText();
				String path = row.path.getText();
				URI outURI = URI.createURI(path, true);
				boolean outExists = uriConverter.exists(outURI.trimSegments(1), null);
				if (!outExists){
					setErrorMessage("Output '" + name + "': '" + path + "' uses non-existent parent folder");
					return false;
				}
			}
		}
		setErrorMessage(null);
		return true;			
	}

	@SuppressWarnings("null")
	public void createControl(Composite parent) {
		Composite control = createForm(parent);
		addListeners();
		LaunchingUtils.prepareBrowseWorkspaceButton(txBrowseWS, txPath, false);
		LaunchingUtils.prepareBrowseFileSystemButton(txBrowseFile, txPath, false);
		updateParametersGroup(inputsGroup, SWT.NONE, EMPTY_MAP);
		updateParametersGroup(outputsGroup, SWT.SAVE, EMPTY_MAP);
		control.setBounds(0, 0, 300, 300);
		control.layout();
		control.pack();
	}

	protected void createDirectionGroup(Group txGroup) {
		directionGroup = new Composite(txGroup, SWT.NONE);
		GridLayout gl_directionGroup = new GridLayout(5, false);
		gl_directionGroup.marginWidth = 0;
		gl_directionGroup.marginHeight = 0;
		directionGroup.setLayout(gl_directionGroup);
		directionGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		
		Label modeLabel = new Label(directionGroup, SWT.NONE);
		modeLabel.setSize(31, 15);
		modeLabel.setText("Mode");
		
		modeCombo = new Combo(directionGroup, SWT.NONE);
		modeCombo.setToolTipText("Whether the execution\n- checks that the output corresponds to the input\n- creates new output model elements\n- updates existing model elements where possible ");
		modeCombo.setItems(new String[] {"CHECK", "ENFORCE - CREATE", "ENFORCE - UPDATE"});
		modeCombo.select(0);
		
		Label directionLabel = new Label(directionGroup, SWT.NONE);
		directionLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		directionLabel.setText("Direction");
		
		directionCombo = new Combo(directionGroup, SWT.NONE);
		directionCombo.setToolTipText("The enforceable output domain defining the direction of a multi-directional trnsformation");
		directionCombo.setItems(new String[] {"NONE"});
		directionCombo.select(0);
		
		partialCheckButton = new Button(directionGroup, SWT.CHECK);
		partialCheckButton.setToolTipText("Whether the input may be part of a larger model, or must be the whole model.");
		partialCheckButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		partialCheckButton.setText("Partial Model");
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
		txGroup.setToolTipText("The transformation selection and its directional configuration ");
		txGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		txGroup.setText("Transformation");
		txGroup.setLayout(new GridLayout(3, false));

		txPath = new Text(txGroup, SWT.BORDER);
		txPath.setToolTipText("The transformation to execute");
		GridData gd_txPath = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txPath.minimumWidth = 100;
		txPath.setLayoutData(gd_txPath);
		txBrowseWS = new Button(txGroup, SWT.NONE);
		txBrowseWS.setText("Browse Workspace...");
		txBrowseFile = new Button(txGroup, SWT.NONE);
		txBrowseFile.setText("Browse File...");
		
		createDirectionGroup(txGroup);

		inputsGroup = new Group(control, SWT.NONE);
		inputsGroup.setToolTipText("The models bound to each input domain");
		inputsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		inputsGroup.setText("Inputs");
		inputsGroup.setLayout(new GridLayout(1, false));

		outputsGroup = new Group(control, SWT.NONE);
		outputsGroup.setToolTipText("The models bound to each output domain");
		outputsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		outputsGroup.setText("Outputs");
		outputsGroup.setLayout(new GridLayout(1, false));
		
		intermediatesGroup = new Group(control, SWT.NONE);
		intermediatesGroup.setToolTipText("The intermediate models nd files");
		intermediatesGroup.setLayout(new GridLayout(1, false));
		intermediatesGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		intermediatesGroup.setText("Intermediates");
		return control;
	}

	protected String getDefaultPath(@NonNull Group group, String name) {
		if (name != null) {
			for (Control child : group.getChildren()) {
				if (child instanceof ParameterRow) {
					ParameterRow row = (ParameterRow)child;
					if (name.equals(row.name.getText())) {
						return row.path.getText();
					}
				}
			}
		}
		return "";
	}
	
	protected @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
		OCLInternal ocl2 = ocl;
		if (ocl2 == null) {
			ocl = ocl2 = OCLInternal.newInstance(new QVTiEnvironmentFactory(BasicProjectManager.createDefaultProjectManager(), null));
		}
		return (QVTiEnvironmentFactory) ocl2.getEnvironmentFactory();
	}

	@Override
	public Image getImage() {
		return QVTdDebugUIPlugin.getDefault().createImage("icons/QVTiModelFile.gif");
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		assert !initializing;
		try {
			initializing = true;
			if (configuration != null) {
				initializeInternal(configuration);
			}
		} catch (CoreException e) {
			//Ignore
		} finally {
			initializing = false;
			txModified = true;
			updateLaunchConfigurationDialog();
		}
	}

	protected void initializeInternal(@NonNull ILaunchConfiguration configuration) throws CoreException {
		txPath.setText(configuration.getAttribute(TX_KEY, ""));
		Map<String, String> inMap = configuration.getAttribute(IN_KEY, EMPTY_MAP);
		Map<String, String> outMap = configuration.getAttribute(OUT_KEY, EMPTY_MAP);
		if (inMap != null) {
			updateParametersGroup(ClassUtil.nonNullState(inputsGroup), SWT.NONE, inMap);
//			refreshParametersGroup(ClassUtil.nonNullState(inputsGroup), SWT.NONE, inMap);
		}
		if (outMap != null) {
			updateParametersGroup(ClassUtil.nonNullState(outputsGroup), SWT.SAVE, outMap);
//			refreshParametersGroup(ClassUtil.nonNullState(outputsGroup), SWT.SAVE, outMap);
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

	protected void refreshParametersGroup(@NonNull Group group, int style, @NonNull Map<String, String> map) {
		List<String> keys = new ArrayList<String>(map.keySet());
		Collections.sort(keys);
		Control[] children = group.getChildren();
		for (int i = 0; i < children.length; i++) {
			ParameterRow row = (ParameterRow)children[i];
			String text = row.name.getText();
			String path = map.get(text);
			if (path != null) {
				row.path.setText(path);
			}
		}
		group.layout();
	}

	protected void setDefaults(@NonNull ILaunchConfigurationWorkingCopy configuration, @NonNull IFile iFile) {
		configuration.setAttribute(TX_KEY, iFile.getFullPath().toString());
		configuration.setAttribute(IN_KEY, EMPTY_MAP);
		configuration.setAttribute(OUT_KEY, EMPTY_MAP);
	}

	@Override
	public void updateLaunchConfigurationDialog() {
		if (!initializing &&!updating) {
			updating = true;
			try {
				if (txModified) {
					if (txPath.isDisposed()) {
						return;
					}
					String txName = txPath.getText().trim();
					@SuppressWarnings("null")@NonNull URI txURI = URI.createURI(txName, true);
					try {
						transformation = updateTransformation(txURI);
						directionModified = true;
					}
					catch (Throwable ex) {
						setErrorMessage("Failed to load '" + txName + "': " + ex.toString());
						return;
					}
					txModified = false;
				}
				Transformation transformation2 = transformation;
				if (transformation2 == null) {
					return;
				}
				if (directionModified) {
					updateDirection(transformation2);
					directionModified = false;
					groupsModified = true;
				}
				if (groupsModified) {
					if (txPath.isDisposed()) {
						return;
					}
					Map<String, String> inputMap = new HashMap<String, String>();
					Map<String, String> outputMap = new HashMap<String, String>();
					updateGroups(transformation2, inputMap, outputMap);
					@SuppressWarnings("null")@NonNull Group inputsGroup2 = inputsGroup;
					@SuppressWarnings("null")@NonNull Group outputsGroup2 = outputsGroup;
					for (String inputName : inputMap.keySet()) {
						inputMap.put(inputName, getDefaultPath(inputsGroup2, inputName));
					}
					for (String outputName : outputMap.keySet()) {
						outputMap.put(outputName, getDefaultPath(outputsGroup2, outputName));
					}
					updateParametersGroup(inputsGroup2, SWT.NONE, inputMap);
					updateParametersGroup(outputsGroup2, SWT.SAVE, outputMap);
					groupsModified = false;
				}
			}
			finally {
				super.updateLaunchConfigurationDialog();
				updating = false;
			}
		}
	}

	protected abstract void updateDirection(@NonNull Transformation tansformation);
	
	protected abstract void updateGroups(@NonNull Transformation tansformation, @NonNull Map<String, String> inputMap, @NonNull Map<String, String> outputMap);

	protected void updateParametersGroup(@NonNull Group group, int style, @NonNull Map<String, String> map) {
		List<String> keys = new ArrayList<String>(map.keySet());
		Collections.sort(keys);
		Control[] children = group.getChildren();
		int iMax = Math.min(children.length, keys.size());
		int i = 0;
		for (; i < iMax; i++) {
			ParameterRow row = (ParameterRow)children[i];
			String string = keys.get(i);
			row.name.setText(string);
			row.path.setText(map.get(string));
		}
		for (; i < keys.size(); i++) {
			String string = keys.get(i);
			String parameterPath = map.get(string);
			if ((string != null) && (parameterPath != null)) {
				new ParameterRow(this, group, style, string, parameterPath);
			}
		}
		for (; i < children.length; i++) {
			children[i].dispose();
		}
		group.layout();
	}
	
	protected abstract @NonNull Transformation updateTransformation(@NonNull URI txURI) throws IOException;

}
