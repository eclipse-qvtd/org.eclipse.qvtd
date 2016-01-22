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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.debug.launching.QVTcLaunchConstants;
import org.eclipse.qvtd.debug.launching.QVTiLaunchConstants;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Control;

public abstract class DirectionalMainTab extends MainTab implements QVTcLaunchConstants
{
	protected static final class IntermediateKeyComparator implements Comparator<String>
	{
		public static final @NonNull IntermediateKeyComparator INSTANCE = new IntermediateKeyComparator();
		
		@Override
		public int compare(String o1, String o2) {
			String s1 = intermediateSortKeys.get(o1);
			String s2 = intermediateSortKeys.get(o2);
			return ClassUtil.safeCompareTo(s1, s2);
		}
	}

	protected class TransformationModeListener implements ModifyListener
	{
		@Override
		public void modifyText(ModifyEvent e) {
			if (setDirectionModified()) {
				updateLaunchConfigurationDialog();
			}
		}

	}

	private static final @NonNull Map<@NonNull String, @NonNull String> intermediateSortKeys = new HashMap<@NonNull String, @NonNull String>();
	static {
		intermediateSortKeys.put("QVTr", "0");
		intermediateSortKeys.put("QVTc", "1");
		intermediateSortKeys.put("QVTu", "2");
		intermediateSortKeys.put("QVTm", "3");
		intermediateSortKeys.put("QVTp", "3");
		intermediateSortKeys.put("QVTs", "5");
		intermediateSortKeys.put("QVTi", "6");
		intermediateSortKeys.put("Java", "7");
	}

	@Override
	protected void addListeners() {
		super.addListeners();
		TransformationModeListener listener = new TransformationModeListener();
		directionCombo.addModifyListener(listener);
		modeCombo.addModifyListener(listener);
//FIXME		partialCheckButton.addSelectionListener(listener);
	}

	private void gatherOutputModels(@NonNull List<TypedModel> outputModels, @NonNull TypedModel typedModel) {
		if (!outputModels.contains(typedModel)) {
			outputModels.add(typedModel);
			for (TypedModel anotherTypedModel : typedModel.getDependsOn()) {
				if (anotherTypedModel != null) {
					gatherOutputModels(outputModels, anotherTypedModel);
				}
			}
		}
	}

	@Override
	protected @Nullable Comparator<String> getIntermediatesKeyComparator() {
		return IntermediateKeyComparator.INSTANCE;
	}

	@Override
	protected void initializeInternal(@NonNull ILaunchConfiguration configuration) throws CoreException {
		super.initializeInternal(configuration);
		List<String> directions = new ArrayList<String>();
		if (newOutputsGroup != null) {
			for (Control child : newOutputsGroup.getChildren()) {
				if (child instanceof ParameterRow) {
					directions.add(((ParameterRow)child).name.getText());
				}
			}
		}
		Collections.sort(directions);
		directionCombo.setItems(directions.toArray(new String[directions.size()]));
		directionCombo.setText(configuration.getAttribute(DIRECTION_KEY, "NONE"));
		modeCombo.setText(configuration.getAttribute(MODE_KEY, "CHECK"));
		viewCheckButton.setSelection(configuration.getAttribute(VIEW_KEY, false));
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		super.performApply(configuration);
		configuration.setAttribute(DIRECTION_KEY, directionCombo.getText());
		configuration.setAttribute(MODE_KEY, modeCombo.getText());
		configuration.setAttribute(VIEW_KEY, viewCheckButton.getSelection());
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		super.setDefaults(configuration);
		configuration.setAttribute(DIRECTION_KEY, "NONE");
		configuration.setAttribute(MODE_KEY, "CHECK");
		configuration.setAttribute(VIEW_KEY, false);
	}

	protected void setDirections(@NonNull Set<TypedModel> enforceables) {
		System.out.println("setDirections");
		if (directionCombo.isDisposed()) {
			return;
		}
		String oldText = directionCombo.getText();
		String[] directionItems = new String[enforceables.size()];
		int newIndex = -1;
		int i = 0;
		for (TypedModel typedModel : enforceables) {
			String name = typedModel.getName();
			if (ClassUtil.safeEquals(name, oldText)) {
				newIndex = i;
			}
			directionItems[i++] = name;
		}
		Arrays.sort(directionItems);
		directionCombo.setItems(directionItems);
		directionCombo.select(newIndex >= 0 ? newIndex : 0);
	}

	@Override
	protected void updateDirection(@NonNull Transformation transformation) {
		System.out.println("updateDirection");
//		Set<@NonNull TypedModel> checkables = new HashSet<@NonNull TypedModel>();
		Set<@NonNull TypedModel> enforceables = new HashSet<@NonNull TypedModel>();
		for (Rule rule : transformation.getRule()) {
			for (Domain domain : rule.getDomain()) {
				TypedModel typedModel = domain.getTypedModel();
				if (typedModel != null) {
//					if (domain.isIsCheckable()) {
//						checkables.add(typedModel);
//					}
					if (domain.isIsEnforceable()) {
						enforceables.add(typedModel);
					}
				}
			}
		}
//		enforceables.removeAll(checkables);			// FIXME Diagnose conflicts
		setDirections(enforceables);
	}

	@Override
	protected void updateGroups(@NonNull Transformation transformation,
			@NonNull Map<@NonNull String, @Nullable String> oldInputsMap, @NonNull Map<@NonNull String, @Nullable String> newInputsMap,
			@NonNull Map<@NonNull String, @Nullable String> oldOutputsMap, @NonNull Map<@NonNull String, @Nullable String> newOutputsMap,
			@NonNull Map<@NonNull String, @Nullable String> intermediateMap) {
		System.out.println("updateGroups");
		Set<@NonNull TypedModel> checkables = new HashSet<@NonNull TypedModel>();
		Set<@NonNull TypedModel> enforceables = new HashSet<@NonNull TypedModel>();
		for (Rule rule : transformation.getRule()) {
			for (Domain domain : rule.getDomain()) {
				TypedModel typedModel = domain.getTypedModel();
				assert typedModel != null;
				if (typedModel != null) {
					if (domain.isIsCheckable()) {
						checkables.add(typedModel);
					}
					if (domain.isIsEnforceable()) {
						enforceables.add(typedModel);
					}
				}
			}
		}
		Set<@NonNull TypedModel> inputs = new HashSet<@NonNull TypedModel>();
		Set<@NonNull TypedModel> outputs = new HashSet<@NonNull TypedModel>();
		String directionName = directionCombo.getText();
		List<@NonNull TypedModel> inputModels = new ArrayList<@NonNull TypedModel>();
		List<@NonNull TypedModel> outputModels = new ArrayList<@NonNull TypedModel>();
		for (TypedModel typedModel : ClassUtil.nullFree(transformation.getModelParameter())) {
			if (ClassUtil.safeEquals(typedModel.getName(), directionName)) {
				gatherOutputModels(outputModels, typedModel);
			}
		}
		for (TypedModel inputModel : ClassUtil.nullFree(transformation.getModelParameter())) {
			if (inputModel.getName() != null) {
				inputModels.add(inputModel);
			}
		}
		inputModels.removeAll(outputModels);
		String modeName = modeCombo.getText();
		if (QVTiLaunchConstants.CHECK_MODE.equals(modeName)) {
			for (TypedModel inputModel : inputModels) {
				if (inputs.add(inputModel)) {
					String name = inputModel.getName();
					assert name != null;
					if (name != null) {
						newInputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
					}
				}
			}
			for (TypedModel outputModel : outputModels) {
				if (outputs.add(outputModel)) {
					String name = outputModel.getName();
					assert name != null;
					if (name != null) {
						oldOutputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
					}
				}
			}
		}
		else if (QVTiLaunchConstants.ENFORCE_CREATE_MODE.equals(modeName)) {
			for (TypedModel inputModel : inputModels) {
				if (inputs.add(inputModel)) {
					String name = inputModel.getName();
					assert name != null;
					if (name != null) {
						newInputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
					}
				}
			}
			for (TypedModel outputModel : outputModels) {
				if (outputs.add(outputModel)) {
					String name = outputModel.getName();
					assert name != null;
					if (name != null) {
						newOutputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
					}
				}
			}
		}
		if (QVTiLaunchConstants.ENFORCE_UPDATE_MODE.equals(modeName)) {
			for (TypedModel inputModel : inputModels) {
				if (inputs.add(inputModel)) {
					String name = inputModel.getName();
					assert name != null;
					if (name != null) {
						oldInputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
						newInputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
					}
				}
			}
			for (TypedModel outputModel : outputModels) {
				if (outputs.add(outputModel)) {
					String name = outputModel.getName();
					assert name != null;
					if (name != null) {
						oldOutputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
						newOutputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
					}
				}
			}
		}
/*		for (TypedModel outputModel : outputModels) {
			if (outputs.add(outputModel)) {
				String name = outputModel.getName();
				assert name != null;
				if (name != null) {
					newOutputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
				}
			}
		}
		checkables.addAll(enforceables);
		checkables.removeAll(outputModels);
		for (TypedModel inputModel : checkables) {
			if (inputs.add(inputModel)) {
				String name = inputModel.getName();
				assert name != null;
				if (name != null) {
					newInputsMap.put(name, null); //getDefaultPath(inputsGroup, name));
				}
			}
		} */
	}
}
