/*******************************************************************************
 * Copyright (c) 2014, 2016 Willink Transformations and others.
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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.debug.launching.QVTiLaunchConstants;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;

public abstract class QVTDirectionalMainTab<TX extends Transformation> extends DirectionalMainTab<TX>
{
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
	protected void updateDirection(@NonNull TX transformation) {
		//		System.out.println("updateDirection");
		Set<@NonNull String> enforceableDirectionNames = new HashSet<>();
		for (@NonNull TypedModel typedModel : QVTbaseUtil.getEnforceableTypedModels(transformation)) {
			String name = typedModel.getName();
			if (name != null) {
				enforceableDirectionNames.add(name);
			}
		}
		setDirections(enforceableDirectionNames);
	}

	@Override
	protected void updateGroups(@NonNull TX transformation,
			@NonNull Map<@NonNull String, @Nullable String> oldInputsMap, @NonNull Map<@NonNull String, @Nullable String> newInputsMap,
			@NonNull Map<@NonNull String, @Nullable String> oldOutputsMap, @NonNull Map<@NonNull String, @Nullable String> newOutputsMap,
			@NonNull Map<@NonNull String, @Nullable String> intermediateMap) {
		super.updateGroups(transformation, oldInputsMap, newInputsMap, oldOutputsMap, newOutputsMap, intermediateMap);
		Set<@NonNull TypedModel> inputs = new HashSet<>();
		Set<@NonNull TypedModel> outputs = new HashSet<>();
		String directionName = directionCombo.getText();
		List<@NonNull TypedModel> inputModels = new ArrayList<>();
		List<@NonNull TypedModel> outputModels = new ArrayList<>();
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
					if (name != null) {
						newInputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
					}
				}
			}
			for (TypedModel outputModel : outputModels) {
				if (outputs.add(outputModel)) {
					String name = outputModel.getName();
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
					if (name != null) {
						newInputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
					}
				}
			}
			for (TypedModel outputModel : outputModels) {
				if (outputs.add(outputModel)) {
					String name = outputModel.getName();
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
					if (name != null) {
						oldInputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
						newInputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
					}
				}
			}
			for (TypedModel outputModel : outputModels) {
				if (outputs.add(outputModel)) {
					String name = outputModel.getName();
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
