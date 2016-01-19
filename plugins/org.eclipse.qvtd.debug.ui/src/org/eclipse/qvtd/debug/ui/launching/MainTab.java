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
import java.util.Comparator;
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
import org.eclipse.jdt.annotation.Nullable;
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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
	protected class CompileButtonAdapter extends SelectionAdapter
	{
		@Override
		public void widgetSelected(SelectionEvent e) {
			compile();
		}
	}

	protected class TransformationModifyListener implements ModifyListener
	{
		@Override
		public void modifyText(ModifyEvent e) {
//			if (!txModified) {
//				txModified = true;
//				updateLaunchConfigurationDialog();
//			}
			if (txPath.isDisposed()) {
				return;
			}
			String txName = txPath.getText();
			URI txURI = URI.createURI(txName, true);
			URI elementsURI = txURI.trimFragment();
			try {
				updateTransformation(elementsURI);
//				Resource resource = getEnvironmentFactory().getResourceSet().getResource(elementsURI, true);
//		        if (resource == null) {
//		        	throw new IOException("There was an error loading the transformation file. ");
//		        }
//				List<String> elements = new ArrayList<String>();
//				for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
//					EObject eObject = tit.next();
//					String displayString = LabelUtil.getLabel(eObject);
//					URI uri = EcoreUtil.getURI(eObject);
//					elements.add(displayString);
//					element2uri.put(displayString, uri);
//				}
//				Collections.sort(elements);
//				elementCombo.setItems(elements.toArray(new String[elements.size()]));
			}
			catch (Exception ex) {
				setErrorMessage("Failed to load '" + elementsURI + "': " + ex.toString());
			}
			updateLaunchConfigurationDialog();
		}
	}

	protected Text txPath;
	protected Button txBrowseWS;
	protected Button txBrowseFile;
	protected Group oldInputsGroup;
	protected Group newInputsGroup;
	protected Group oldOutputsGroup;
	protected Group newOutputsGroup;
	private Composite directionGroup;
	protected Combo modeCombo;
	protected Combo directionCombo;
	protected Button viewCheckButton;
	private Group intermediatesGroup;
	private Group buildGroup;
	protected Button autoBuildCheckButton;
	protected Button compileButton;
	
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
		compileButton.addSelectionListener(new CompileButtonAdapter());
	}

	@Override
	public boolean canSave() {
		System.out.println("canSave");
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
		if (newInputsGroup != null) {
			Control[] children = newInputsGroup.getChildren();
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
		if (newOutputsGroup != null) {
			Control[] children = newOutputsGroup.getChildren();
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

	protected void compile() {}

	protected void createBuildGroup(Composite control) {
		buildGroup = new Group(control, SWT.NONE);
		buildGroup.setToolTipText("Running the transformation compilation tool chain");
		buildGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		buildGroup.setText("Build");
		buildGroup.setLayout(new GridLayout(2, false));

//		buildGroup = new Composite(txGroup, SWT.NONE);
//		GridLayout gl_directionGroup = new GridLayout(3, false);
//		gl_directionGroup.marginWidth = 0;
//		gl_directionGroup.marginHeight = 0;
//		buildGroup.setLayout(gl_directionGroup);
//		buildGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		
//		Label modeLabel = new Label(buildGroup, SWT.NONE);
//		modeLabel.setSize(31, 15);
//		modeLabel.setText("Build");
		
/*		modeCombo = new Combo(directionGroup, SWT.NONE);
		modeCombo.setToolTipText("Whether the execution\n- checks that the output corresponds to the input\n- creates new output model elements\n- updates existing model elements where possible ");
		modeCombo.setItems(new String[] {"CHECK", "ENFORCE - CREATE", "ENFORCE - UPDATE"});
		modeCombo.select(0);
		
		Label directionLabel = new Label(directionGroup, SWT.NONE);
		directionLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		directionLabel.setText("Direction");
		
		directionCombo = new Combo(directionGroup, SWT.NONE);
		directionCombo.setToolTipText("The enforceable output domain defining the direction of a multi-directional trnsformation");
		directionCombo.setItems(new String[] {"NONE"});
		directionCombo.select(0); */
		
		autoBuildCheckButton = new Button(buildGroup, SWT.CHECK);
		autoBuildCheckButton.setToolTipText("Whether the intermediates should be auto-built by the builder when relevant models change.");
		autoBuildCheckButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		autoBuildCheckButton.setText("Auto-Build");
		autoBuildCheckButton.setSelection(true);
		
		compileButton = new Button(buildGroup, SWT.PUSH);
		compileButton.setToolTipText("Run the Transformation chain to build all intermedites and final model.");
		compileButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		compileButton.setText("Compile");
	}

	@SuppressWarnings("null")
	public void createControl(Composite parent) {
		System.out.println("createControl-start");
		Composite control = createForm(parent);
		addListeners();
		LaunchingUtils.prepareBrowseWorkspaceButton(txBrowseWS, txPath, false);
		LaunchingUtils.prepareBrowseFileSystemButton(txBrowseFile, txPath, false);
		updateParametersGroup(oldInputsGroup, SWT.NONE, EMPTY_MAP, null);
		updateParametersGroup(oldOutputsGroup, SWT.SAVE, EMPTY_MAP, null);
		updateParametersGroup(newInputsGroup, SWT.NONE, EMPTY_MAP, null);
		updateParametersGroup(newOutputsGroup, SWT.SAVE, EMPTY_MAP, null);
		updateParametersGroup(intermediatesGroup, SWT.SAVE, EMPTY_MAP, getIntermediatesKeyComparator());
		control.setBounds(0, 0, 300, 300);
		control.layout();
		control.pack();
		System.out.println("createControl-end");
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
		modeCombo.setItems(new String[] {CHECK_MODE, ENFORCE_CREATE_MODE, ENFORCE_UPDATE_MODE});
		modeCombo.select(0);
		
		Label directionLabel = new Label(directionGroup, SWT.NONE);
		directionLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		directionLabel.setText("Direction");
		
		directionCombo = new Combo(directionGroup, SWT.NONE);
		directionCombo.setToolTipText("Select enforceable output domain to choose the direction of a multi-directional transformation");
		directionCombo.setItems(new String[] {"NONE"});
		directionCombo.select(0);
		
		viewCheckButton = new Button(directionGroup, SWT.CHECK);
		viewCheckButton.setToolTipText("Whether the output may be a view of a larger model, or must be the whole model.");
		viewCheckButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1));
		viewCheckButton.setText("Partial View");
		viewCheckButton.setEnabled(false);
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public Composite createForm(Composite parent) {
		Composite control = new Composite(parent, SWT.NONE);
		setControl(control);
		GridLayout controlLayout = new GridLayout(1, false);
		controlLayout.verticalSpacing = 0;
		control.setLayout(controlLayout);
		control.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

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

		GridLayout oldInputsLayout = controlLayout;
		oldInputsLayout.marginBottom = 0;
		oldInputsLayout.marginHeight = 0;
		oldInputsLayout.marginTop = 0;
		oldInputsLayout.verticalSpacing = 0;
		oldInputsGroup = new Group(control, SWT.NONE);
		oldInputsGroup.setToolTipText("The previous input models to be compared to the new input models bound to each input domain");
		GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
//		layoutData.
		oldInputsGroup.setLayoutData(layoutData);
		oldInputsGroup.setText("Old Inputs");
		oldInputsGroup.setLayout(oldInputsLayout);

		GridLayout newInputsLayout = controlLayout;
		newInputsLayout.marginBottom = 0;
		newInputsLayout.marginHeight = 0;
		newInputsLayout.marginTop = 0;
		newInputsLayout.verticalSpacing = 0;
		newInputsGroup = new Group(control, SWT.NONE);
		newInputsGroup.setToolTipText("The models bound to each input domain");
		newInputsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		newInputsGroup.setText("Inputs");
		newInputsGroup.setLayout(newInputsLayout);

		GridLayout oldOutputsLayout = controlLayout;
		oldOutputsLayout.marginBottom = 0;
		oldOutputsLayout.marginHeight = 0;
		oldOutputsLayout.marginTop = 0;
		oldOutputsLayout.verticalSpacing = 0;
		oldOutputsGroup = new Group(control, SWT.NONE);
		oldOutputsGroup.setToolTipText("The previous output models to be compared to the new output models bound to each output domain");
		oldOutputsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		oldOutputsGroup.setText("Old Outputs");
		oldOutputsGroup.setLayout(oldOutputsLayout);

		GridLayout newOutputsLayout = controlLayout;
		newOutputsLayout.marginBottom = 0;
		newOutputsLayout.marginHeight = 0;
		newOutputsLayout.marginTop = 0;
		newOutputsLayout.verticalSpacing = 0;
		newOutputsGroup = new Group(control, SWT.NONE);
		newOutputsGroup.setToolTipText("The models bound to each output domain");
		newOutputsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		newOutputsGroup.setText("New Outputs");
		newOutputsGroup.setLayout(newOutputsLayout);
		
		GridLayout intermediatesLayout = controlLayout;
		intermediatesLayout.marginBottom = 0;
		intermediatesLayout.marginHeight = 0;
		intermediatesLayout.marginTop = 0;
		intermediatesLayout.verticalSpacing = 0;
		intermediatesGroup = new Group(control, SWT.NONE);
		intermediatesGroup.setToolTipText("The intermediate models and build files");
		intermediatesGroup.setLayout(intermediatesLayout);
		intermediatesGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		intermediatesGroup.setText("Intermediates");

		createBuildGroup(control);

		return control;
	}

	protected @NonNull String getDefaultIntermediatePath(@NonNull Group group, @NonNull URI txURI, @NonNull String name) {
		return "";
	}

	protected @NonNull String getDefaultPath(@NonNull Group group, @NonNull URI txURI, @NonNull String name) {
		int segmentCount = txURI.segmentCount();
		if (segmentCount > 1) {
			return String.valueOf(txURI.trimSegments(1).appendSegment(name).appendFileExtension("xmi"));//.deresolve(txURI));
		}
/*		if (name != null) {
			for (Control child : group.getChildren()) {
				if (child instanceof ParameterRow) {
					ParameterRow row = (ParameterRow)child;
					if (name.equals(row.name.getText())) {
						String text = row.path.getText();
						return text != null ? text : "";
					}
				}
			}
		} */
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

	protected @Nullable Comparator<String> getIntermediatesKeyComparator() {
		return null;
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		System.out.println("initializeFrom");
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
		System.out.println("initializeInternal");
		String txAttribute = configuration.getAttribute(TX_KEY, "");
		URI uri = URI.createURI(txAttribute);
		if (uri.scheme() == null) {
			uri = URI.createPlatformResourceURI(txAttribute, true);
		}
		txPath.setText(uri.toString());
		Map<String, String> oldInputsMap = configuration.getAttribute(OLD_IN_KEY, EMPTY_MAP);
		Map<String, String> newInputsMap = configuration.getAttribute(NEW_IN_KEY, EMPTY_MAP);
		Map<String, String> oldOutputsMap = configuration.getAttribute(OLD_OUT_KEY, EMPTY_MAP);
		Map<String, String> newOutputsMap = configuration.getAttribute(NEW_OUT_KEY, EMPTY_MAP);
		Map<String, String> intermediatesMap = configuration.getAttribute(INTERMEDIATES_KEY, EMPTY_MAP);
		if (oldInputsMap != null) {
			updateParametersGroup(ClassUtil.nonNullState(oldInputsGroup), SWT.NONE, oldInputsMap, null);
		}
		if (newInputsMap != null) {
			updateParametersGroup(ClassUtil.nonNullState(newInputsGroup), SWT.NONE, newInputsMap, null);
		}
		if (oldOutputsMap != null) {
			updateParametersGroup(ClassUtil.nonNullState(oldOutputsGroup), SWT.NONE, oldOutputsMap, null);
		}
		if (newOutputsMap != null) {
			updateParametersGroup(ClassUtil.nonNullState(newOutputsGroup), SWT.SAVE, newOutputsMap, null);
		}
		if (intermediatesMap != null) {
			updateParametersGroup(ClassUtil.nonNullState(intermediatesGroup), SWT.SAVE, intermediatesMap, getIntermediatesKeyComparator());
		}
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		System.out.println("performApply");
		configuration.setAttribute(TX_KEY, txPath.getText());
		Map<String, String> oldInputsMap = new HashMap<String, String>();
		for (Control child : oldInputsGroup.getChildren()) {
			if (child instanceof ParameterRow) {
				ParameterRow row = (ParameterRow)child;
				oldInputsMap.put(row.name.getText(), row.path.getText());
			}
		}
		configuration.setAttribute(OLD_IN_KEY, oldInputsMap);
		Map<String, String> newInputsMap = new HashMap<String, String>();
		for (Control child : newInputsGroup.getChildren()) {
			if (child instanceof ParameterRow) {
				ParameterRow row = (ParameterRow)child;
				newInputsMap.put(row.name.getText(), row.path.getText());
			}
		}
		configuration.setAttribute(NEW_IN_KEY, newInputsMap);
		Map<String, String> oldOutputsMap = new HashMap<String, String>();
		for (Control child : oldOutputsGroup.getChildren()) {
			if (child instanceof ParameterRow) {
				ParameterRow row = (ParameterRow)child;
				oldOutputsMap.put(row.name.getText(), row.path.getText());
			}
		}
		configuration.setAttribute(OLD_OUT_KEY, oldOutputsMap);
		Map<String, String> newOutputsMap = new HashMap<String, String>();
		for (Control child : newOutputsGroup.getChildren()) {
			if (child instanceof ParameterRow) {
				ParameterRow row = (ParameterRow)child;
				newOutputsMap.put(row.name.getText(), row.path.getText());
			}
		}
		configuration.setAttribute(NEW_OUT_KEY, newOutputsMap);
	}

/*	protected void refreshParametersGroup(@NonNull Group group, int style, @NonNull Map<String, String> map, @Nullable Comparator<ParameterRow> keyComparator) {
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
	} */

	protected void setDefaults(@NonNull ILaunchConfigurationWorkingCopy configuration, @NonNull IFile iFile) {
		System.out.println("setDefaults");
		configuration.setAttribute(TX_KEY, iFile.getFullPath().toString());
		configuration.setAttribute(OLD_IN_KEY, EMPTY_MAP);
		configuration.setAttribute(NEW_IN_KEY, EMPTY_MAP);
		configuration.setAttribute(OLD_OUT_KEY, EMPTY_MAP);
		configuration.setAttribute(NEW_OUT_KEY, EMPTY_MAP);
	}

	/**
	 * Set that direction aspects of the transformation configuration have changed.
	 * Returns true if the direction aspects were previously unmodified. 
	 */
	protected boolean setDirectionModified() {
		System.out.println("setDirectionModified :" + directionModified);
		boolean wasDirectionModified = directionModified;
		directionModified = true;
		return !wasDirectionModified;
	}

	@Override
	protected void setErrorMessage(String errorMessage) {
		System.out.println("setErrorMessage: " + errorMessage);
		super.setErrorMessage(errorMessage);
	}

	@Override
	public void updateLaunchConfigurationDialog() {
		System.out.println("updateLaunchConfigurationDialog: " + initializing + "," + updating);
		if (!initializing && !updating) {
			updating = true;
			try {
				String txName = txPath.getText().trim();
				URI txURI = URI.createURI(txName, true);
				if (txModified) {
					if (txPath.isDisposed()) {
						return;
					}
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
					Map<@NonNull String, @Nullable String> oldInputsMap = new HashMap<@NonNull String, @Nullable String>();
					Map<@NonNull String, @Nullable String> newInputsMap = new HashMap<@NonNull String, @Nullable String>();
					Map<@NonNull String, @Nullable String> oldOutputsMap = new HashMap<@NonNull String, @Nullable String>();
					Map<@NonNull String, @Nullable String> newOutputsMap = new HashMap<@NonNull String, @Nullable String>();
					Map<@NonNull String, @Nullable String> intermediateMap = new HashMap<@NonNull String, @Nullable String>();
					updateGroups(transformation2, oldInputsMap, newInputsMap, oldOutputsMap, newOutputsMap, intermediateMap);
					@SuppressWarnings("null")@NonNull Group oldInputsGroup2 = oldInputsGroup;
					@SuppressWarnings("null")@NonNull Group newInputsGroup2 = newInputsGroup;
					@SuppressWarnings("null")@NonNull Group oldOutputsGroup2 = oldOutputsGroup;
					@SuppressWarnings("null")@NonNull Group newOutputsGroup2 = newOutputsGroup;
					@SuppressWarnings("null")@NonNull Group intermediatesGroup2 = intermediatesGroup;
					for (String oldInputName : oldInputsMap.keySet()) {
						oldInputsMap.put(oldInputName, getDefaultPath(oldInputsGroup2, txURI, oldInputName));
					}
					for (String newInputName : newInputsMap.keySet()) {
						newInputsMap.put(newInputName, getDefaultPath(newInputsGroup2, txURI, newInputName));
					}
					for (String oldOutputName : oldOutputsMap.keySet()) {
						oldOutputsMap.put(oldOutputName, getDefaultPath(oldOutputsGroup2, txURI,oldOutputName));
					}
					for (String newOutputName : newOutputsMap.keySet()) {
						newOutputsMap.put(newOutputName, getDefaultPath(newOutputsGroup2, txURI, newOutputName));
					}
					for (String intermediateName : intermediateMap.keySet()) {
						intermediateMap.put(intermediateName, getDefaultIntermediatePath(intermediatesGroup2, txURI, intermediateName));
					}
					updateParametersGroup(oldInputsGroup2, SWT.NONE, oldInputsMap, null);
					updateParametersGroup(newInputsGroup2, SWT.NONE, newInputsMap, null);
					updateParametersGroup(oldOutputsGroup2, SWT.SAVE, oldOutputsMap, null);
					updateParametersGroup(newOutputsGroup2, SWT.SAVE, newOutputsMap, null);
					updateParametersGroup(intermediatesGroup2, SWT.SAVE, intermediateMap, getIntermediatesKeyComparator());
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
	
	protected abstract void updateGroups(@NonNull Transformation transformation,
			@NonNull Map<@NonNull String, @Nullable String> oldInputsMap, @NonNull Map<@NonNull String, @Nullable String> newInputsMap,
			@NonNull Map<@NonNull String, @Nullable String> oldOutputsMap, @NonNull Map<@NonNull String, @Nullable String> newOutputsMap,
			@NonNull Map<@NonNull String, @Nullable String> intermediateMap);

	protected void updateParametersGroup(@NonNull Group group, int style, @NonNull Map<String, String> map, @Nullable Comparator<String> keyComparator) {
		System.out.println("updateParametersGroup");
		Control[] children = group.getChildren();
		int i = 0;
		if (map.isEmpty()) {
			((GridData)group.getLayoutData()).exclude = true;
			group.setVisible(false);
//			group.setEnabled(false);
//			group.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_YELLOW));
		}
		else {
			((GridData)group.getLayoutData()).exclude = false;
			group.setVisible(true);
//			group.setEnabled(true);
//			group.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_CYAN));
			List<String> keys = new ArrayList<String>(map.keySet());
			Collections.sort(keys, keyComparator);
			int iMax = Math.min(children.length, keys.size());
			for (; i < iMax; i++) {
				ParameterRow row = (ParameterRow)children[i];
				String key = keys.get(i);
				if (key != null) {
					row.name.setText(key);
					row.path.setText(map.get(key));
				}
			}
			for (; i < keys.size(); i++) {
				String key = keys.get(i);
				if (key != null) {
					String parameterPath = map.get(key);
					if (parameterPath != null) {
						new ParameterRow(this, group, style, key, parameterPath);
					}
				}
			}
		}
		for (; i < children.length; i++) {
			children[i].dispose();
		}
		group.requestLayout();
	}
	
	protected abstract @NonNull Transformation updateTransformation(@NonNull URI txURI) throws IOException;

}
