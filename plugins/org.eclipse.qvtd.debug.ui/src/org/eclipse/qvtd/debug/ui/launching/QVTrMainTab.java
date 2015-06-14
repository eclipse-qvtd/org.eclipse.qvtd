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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.debug.evaluator.BasicQVTrExecutor;
import org.eclipse.qvtd.debug.ui.QVTdDebugUIPlugin;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.swt.graphics.Image;

public class QVTrMainTab extends DirectionalMainTab
{
	@Override
	public Image getImage() {
		return QVTdDebugUIPlugin.getDefault().createImage("icons/QVTrModelFile.gif");
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
	protected void updateGroups(@NonNull Transformation transformation, @NonNull Map<String, String> inputMap, @NonNull Map<String, String> outputMap) {
		Set<TypedModel> checkables = new HashSet<TypedModel>();
		Set<TypedModel> enforceables = new HashSet<TypedModel>();
		for (Rule rule : transformation.getRule()) {
			if (rule instanceof Relation) {
				Relation relation = (Relation)rule;
				for (Domain domain : relation.getDomain()) {
					if (domain instanceof RelationDomain) {
						RelationDomain relationDomain = (RelationDomain)domain;
						TypedModel typedModel = relationDomain.getTypedModel();
						if (domain.isIsCheckable()) {
							checkables.add(typedModel);
						}
						if (domain.isIsEnforceable()) {
							enforceables.add(typedModel);
						}
					}
				}
			}
		}
		Set<TypedModel> inputs = new HashSet<TypedModel>();
		Set<TypedModel> outputs = new HashSet<TypedModel>();
		String directionName = directionCombo.getText();
		List<TypedModel> outputModels = new ArrayList<TypedModel>();
		for (TypedModel typedModel : transformation.getModelParameter()) {
			if ((typedModel != null) && ClassUtil.safeEquals(typedModel.getName(), directionName)) {
				gatherOutputModels(outputModels, typedModel);
			}
		}
		for (TypedModel outputModel : outputModels) {
			if (outputs.add(outputModel)) {
				String name = outputModel.getName();
				outputMap.put(name, null); //getDefaultPath(outputsGroup, name));
			}
		}
		checkables.addAll(enforceables);
		checkables.removeAll(outputModels);
		for (TypedModel inputModel : checkables) {
			if (inputs.add(inputModel)) {
				String name = inputModel.getName();
				inputMap.put(name, null); //getDefaultPath(inputsGroup, name));
			}
		}
	}

	protected @NonNull Transformation updateTransformation(@NonNull URI txURI) throws IOException {
		QVTiEnvironmentFactory envFactory = getEnvironmentFactory();
		BasicQVTrExecutor xtextEvaluator = new BasicQVTrExecutor(envFactory, txURI);
		return xtextEvaluator.getTransformation();
	}
}
