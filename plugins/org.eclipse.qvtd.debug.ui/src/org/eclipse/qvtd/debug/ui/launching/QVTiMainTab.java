/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.ui.launching;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.XMIUtil;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.QVTiCompilerChain;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.debug.launching.QVTiLaunchConfigurationDelegate;
import org.eclipse.qvtd.debug.launching.QVTiLaunchConstants;
import org.eclipse.qvtd.debug.ui.QVTdDebugUIPlugin;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Group;

import com.google.common.collect.Lists;

public class QVTiMainTab extends MainTab<Transformation> implements QVTiLaunchConstants
{
	@Override
	protected @NonNull QVTiCompilerChain createCompilerChain(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI txURI, @NonNull CompilerOptions compilerOptions) {
		return new QVTiCompilerChain(environmentFactory, txURI, txURI, compilerOptions);
	}

	@Override
	protected void createDirectionGroup(Group txGroup) {}

	@Override
	public Image getImage() {
		return QVTdDebugUIPlugin.getDefault().createImage("icons/QVTiModelFile.gif");
	}

	@Override
	protected @NonNull List<@NonNull String> getIntermediateKeys() {
		List<@NonNull String> asList = Lists.newArrayList(QVTiLaunchConfigurationDelegate.compileStepKeys);
		if (!isInterpreted()) {
			for (@NonNull String stepKey : QVTiLaunchConfigurationDelegate.generateStepKeys) {
				asList.add(stepKey);
			}
		}
		return asList;
	}

	@Override
	protected void initializeOptions(@NonNull DefaultCompilerOptions compilerOptions) throws IOException {		// FIXME Exploit QVTc/QVTr evolution
		compilerOptions.setOption(CompilerChain.DEFAULT_STEP, CompilerChain.SAVE_OPTIONS_KEY, XMIUtil.createSaveOptions());
		if (isInterpreted()) {
			compilerOptions.setOption(CompilerChain.JAVA_STEP, CompilerChain.URI_KEY, null);
			compilerOptions.setOption(CompilerChain.CLASS_STEP, CompilerChain.URI_KEY, null);
		}
		else {
			initializeURIOption(compilerOptions, CompilerChain.JAVA_STEP);
			initializeURIOption(compilerOptions, CompilerChain.CLASS_STEP);
		}
		initializeURIOption(compilerOptions, CompilerChain.QVTI_STEP);
	}

	@Override
	protected void updateDirection(@NonNull Transformation tansformation) {}

	@Override
	protected void updateGroups(@NonNull Transformation transformation,
			@NonNull Map<@NonNull String, @Nullable String> oldInputsMap, @NonNull Map<@NonNull String, @Nullable String> newInputsMap,
			@NonNull Map<@NonNull String, @Nullable String> oldOutputsMap, @NonNull Map<@NonNull String, @Nullable String> newOutputsMap,
			@NonNull Map<@NonNull String, @Nullable String> intermediateMap) {
		super.updateGroups(transformation, oldInputsMap, newInputsMap, oldOutputsMap, newOutputsMap, intermediateMap);
		for (@NonNull TypedModel typedModel : QVTimperativeUtil.getModelParameters(transformation)) {
			if (QVTimperativeUtil.isInput(typedModel)) {
				String name = typedModel.getName();
				assert name != null;
				newInputsMap.put(name, null); //getDefaultPath(inputsGroup, name));
			}
			if (QVTimperativeUtil.isOutput(typedModel)) {
				String name = typedModel.getName();
				assert name != null;
				newOutputsMap.put(name, null); //getDefaultPath(inputsGroup, name));
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
