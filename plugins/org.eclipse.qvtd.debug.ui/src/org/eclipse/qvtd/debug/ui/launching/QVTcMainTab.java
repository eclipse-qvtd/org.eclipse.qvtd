/*******************************************************************************
 * Copyright (c) 2014, 2017 Willink Transformations and others.
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
import org.eclipse.qvtd.compiler.AbstractCompilerChain;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.QVTcCompilerChain;
import org.eclipse.qvtd.compiler.CompilerChain.Key;
import org.eclipse.qvtd.debug.ui.QVTdDebugUIPlugin;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.swt.graphics.Image;

public class QVTcMainTab extends QVTDirectionalMainTab<Transformation>
{
	private static final @NonNull String @NonNull [] intermediateKeys = new @NonNull String[] {
		CompilerChain.QVTC_STEP,
		CompilerChain.QVTU_STEP,
		CompilerChain.QVTM_STEP,
		CompilerChain.QVTS_STEP,
		CompilerChain.QVTI_STEP,
		CompilerChain.JAVA_STEP,
		CompilerChain.CLASS_STEP
	};

	@Override
	protected @NonNull QVTcCompilerChain createCompilerChain(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI txURI, @NonNull Map<@NonNull String, @Nullable Map<@NonNull Key<Object>, @Nullable Object>> options) {
		return new QVTcCompilerChain(environmentFactory, txURI, options);
	}

	@Override
	public Image getImage() {
		return QVTdDebugUIPlugin.getDefault().createImage("icons/QVTcModelFile.gif");
	}

	@Override
	protected @NonNull String @NonNull [] getIntermediateKeysInternal() {
		return intermediateKeys;
	}

	@Override
	protected void initializeOptions(@NonNull Map<@NonNull String, @Nullable Map<@NonNull Key<Object>, @Nullable Object>> options) {
		super.initializeOptions(options);
		AbstractCompilerChain.setOption(options, CompilerChain.QVTC_STEP, CompilerChain.URI_KEY, getResolvedCompilerStep(CompilerChain.QVTC_STEP));
		AbstractCompilerChain.setOption(options, CompilerChain.GENMODEL_STEP, CompilerChain.URI_KEY, getResolvedGenModel());
		Map<@NonNull String, @Nullable String> genModelOptions = new HashMap<@NonNull String, @Nullable String>();
		genModelOptions.put(CompilerChain.GENMODEL_BASE_PREFIX, getProjectName());
		AbstractCompilerChain.setOption(options, CompilerChain.GENMODEL_STEP, CompilerChain.GENMODEL_OPTIONS_KEY, genModelOptions);
	}

	@Override
	protected @NonNull Transformation updateTransformation(@NonNull URI txURI) throws IOException {
		//		System.out.println("QVTc::updateTransformation");
		QVTiEnvironmentFactory environmentFactory = getEnvironmentFactory();
		return QVTcoreUtil.loadTransformation(environmentFactory, txURI, environmentFactory.keepDebug());
	}
}
