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

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.QVTiCompilerChain;
import org.eclipse.qvtd.debug.launching.QVTiLaunchConstants;
import org.eclipse.qvtd.debug.ui.QVTdDebugUIPlugin;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.BottomPattern;
import org.eclipse.qvtd.pivot.qvtimperative.CoreDomain;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Group;

public class QVTiMainTab extends MainTab implements QVTiLaunchConstants
{
	private static final @NonNull String @NonNull [] intermediateKeys = new @NonNull String[] {
		CompilerChain.QVTI_STEP,
		CompilerChain.JAVA_STEP,
		CompilerChain.CLASS_STEP
	};

	@Override
	protected @NonNull QVTiCompilerChain createCompilerChain(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI txURI) {
		return new QVTiCompilerChain(environmentFactory, txURI, null);
	}

	@Override
	protected void createDirectionGroup(Group txGroup) {}

	@Override
	public Image getImage() {
		return QVTdDebugUIPlugin.getDefault().createImage("icons/QVTiModelFile.gif");
	}

	@Override
	protected @NonNull String @NonNull [] getIntermediateKeysInternal() {
		return intermediateKeys;
	}

	@Override
	protected void updateDirection(@NonNull Transformation tansformation) {}

	@Override
	protected void updateGroups(@NonNull Transformation transformation,
			@NonNull Map<@NonNull String, @Nullable String> oldInputsMap, @NonNull Map<@NonNull String, @Nullable String> newInputsMap,
			@NonNull Map<@NonNull String, @Nullable String> oldOutputsMap, @NonNull Map<@NonNull String, @Nullable String> newOutputsMap,
			@NonNull Map<@NonNull String, @Nullable String> intermediateMap) {
		super.updateGroups(transformation, oldInputsMap, newInputsMap, oldOutputsMap, newOutputsMap, intermediateMap);
		Set<@NonNull TypedModel> inputs = new HashSet<@NonNull TypedModel>();
		Set<@NonNull TypedModel> outputs = new HashSet<@NonNull TypedModel>();
		for (Rule rule : transformation.getRule()) {
			if (rule instanceof Mapping) {
				Mapping mapping = (Mapping)rule;
				for (Domain domain : mapping.getDomain()) {
					if (domain instanceof CoreDomain) {
						CoreDomain coreDomain = (CoreDomain)domain;
						BottomPattern bottomPattern = coreDomain.getBottomPattern();
						assert bottomPattern != null;
						TypedModel typedModel = coreDomain.getTypedModel();
						assert typedModel != null;
						if ((bottomPattern != null) && (typedModel != null)) {
							String name = typedModel.getName();
							if (bottomPattern.getRealizedVariable().isEmpty()) {
								if (inputs.add(typedModel)) {
									assert name != null;
									if (name != null) {
										newInputsMap.put(name, null); //getDefaultPath(inputsGroup, name));
									}
								}
							}
							else {
								if (outputs.add(typedModel)) {
									assert name != null;
									if (name != null) {
										newOutputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
									}
								}
							}
						}
					}
				}
			}
		}
		for (String key : newOutputsMap.keySet()) {
			newInputsMap.remove(key);
		}
	}

	@Override
	protected @NonNull Transformation updateTransformation(@NonNull URI txURI) throws IOException {
		QVTiEnvironmentFactory environmentFactory = getEnvironmentFactory();
		return QVTimperativeUtil.loadTransformation(environmentFactory, txURI, environmentFactory.keepDebug());
	}
}
