/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.debug.launching.QVTiLaunchConstants;
import org.eclipse.qvtd.debug.ui.QVTdDebugUIPlugin;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.xtext.qvtimperative.utilities.QVTiXtextEvaluator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Group;

public class QVTiMainTab extends MainTab implements QVTiLaunchConstants
{
	protected void createDirectionGroup(Group txGroup) {}
	
	@Override
	public Image getImage() {
		return QVTdDebugUIPlugin.getDefault().createImage("icons/QVTiModelFile.gif");
	}

	@Override
	protected void updateDirection(@NonNull Transformation tansformation) {}

	@Override
	protected void updateGroups(@NonNull Transformation transformation, @NonNull Map<String, String> inputMap, @NonNull Map<String, String> outputMap) {
		Set<TypedModel> inputs = new HashSet<TypedModel>();
		Set<TypedModel> outputs = new HashSet<TypedModel>();
		for (Rule rule : transformation.getRule()) {
			if (rule instanceof Mapping) {
				Mapping mapping = (Mapping)rule;
				for (Domain domain : mapping.getDomain()) {
					if (domain instanceof CoreDomain) {
						CoreDomain coreDomain = (CoreDomain)domain;
						BottomPattern bottomPattern = coreDomain.getBottomPattern();
						TypedModel typedModel = coreDomain.getTypedModel();
						String name = typedModel.getName();
						if (bottomPattern.getRealizedVariable().isEmpty()) {
							if (inputs.add(typedModel)) {
								inputMap.put(name, null); //getDefaultPath(inputsGroup, name));
							}
						}
						else {
							if (outputs.add(typedModel)) {
								outputMap.put(name, null); //getDefaultPath(outputsGroup, name));
							}
						}
					}
				}
			}
		}
		for (String key : outputMap.keySet()) {
			inputMap.remove(key);
		}
	}

	protected @NonNull Transformation updateTransformation(@NonNull URI txURI) throws IOException {
		QVTiEnvironmentFactory envFactory = getEnvironmentFactory();
		QVTiXtextEvaluator xtextEvaluator = new QVTiXtextEvaluator(envFactory, txURI);
		return xtextEvaluator.getTransformation();
	}
}
