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
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.debug.evaluator.BasicQVTrExecutor;
import org.eclipse.qvtd.debug.ui.QVTdDebugUIPlugin;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Group;

public class QVTrMainTab extends DirectionalMainTab
{
	private static final @NonNull Map<@NonNull String, @NonNull String> intermediateDefaultExtensions = new HashMap<@NonNull String, @NonNull String>();
	static {
//		intermediateDefaultExtensions.put("QVTr", "qvtr");
		intermediateDefaultExtensions.put("QVTc", "qvtcas");
		intermediateDefaultExtensions.put("QVTu", "qvtu.qvtcas");
		intermediateDefaultExtensions.put("QVTm", "qvpm.qvtcas");
		intermediateDefaultExtensions.put("QVTp", "qvtp.qvtcas");
		intermediateDefaultExtensions.put("QVTs", "qvts.xmi");
		intermediateDefaultExtensions.put("QVTi", "qvtias");
		intermediateDefaultExtensions.put("Java", "java");
	}

	protected @NonNull String getDefaultIntermediatePath(@NonNull Group group, @NonNull URI txURI, @NonNull String name) {
		return String.valueOf(txURI.trimFileExtension().appendFileExtension(intermediateDefaultExtensions.get(name)));
	}
	
	@Override
	public Image getImage() {
		return QVTdDebugUIPlugin.getDefault().createImage("icons/QVTrModelFile.gif");
	}

	@Override
	protected void updateGroups(@NonNull Transformation transformation,
			@NonNull Map<@NonNull String, @Nullable String> oldInputsMap, @NonNull Map<@NonNull String, @Nullable String> newInputsMap,
			@NonNull Map<@NonNull String, @Nullable String> oldOutputsMap, @NonNull Map<@NonNull String, @Nullable String> newOutputsMap,
			@NonNull Map<@NonNull String, @Nullable String> intermediateMap) {
		System.out.println("QVTc::updateGroups");
		super.updateGroups(transformation, oldInputsMap, newInputsMap, oldOutputsMap, newOutputsMap, intermediateMap);
		for (String key : intermediateDefaultExtensions.keySet()) {
			intermediateMap.put(key, intermediateDefaultExtensions.get(key));
		}
	}

	protected @NonNull Transformation updateTransformation(@NonNull URI txURI) throws IOException {
		QVTiEnvironmentFactory envFactory = getEnvironmentFactory();
		BasicQVTrExecutor xtextEvaluator = new BasicQVTrExecutor(envFactory, txURI);
		return xtextEvaluator.getTransformation();
	}
}
