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

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.debug.ui.QVTdDebugUIPlugin;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.swt.graphics.Image;

public class QVTrMainTab extends DirectionalMainTab
{
	private static final @NonNull String @NonNull [] intermediateKeys = new @NonNull String[] {
		CompilerChain.QVTR_STEP,
		CompilerChain.QVTC_STEP,
		CompilerChain.QVTU_STEP,
		CompilerChain.QVTM_STEP,
		CompilerChain.QVTP_STEP,
		CompilerChain.QVTS_STEP,
		CompilerChain.QVTI_STEP,
		CompilerChain.JAVA_STEP,
		CompilerChain.CLASS_STEP
	};
	
	@Override
	public Image getImage() {
		return QVTdDebugUIPlugin.getDefault().createImage("icons/QVTrModelFile.gif");
	}

	@Override
	protected @NonNull String @NonNull [] getIntermediateKeysInternal() {
		return intermediateKeys;
	}

	@Override
	protected @NonNull Transformation updateTransformation(@NonNull URI txURI) throws IOException {
		QVTiEnvironmentFactory environmentFactory = getEnvironmentFactory();
    	return QVTrelationUtil.loadTransformation(environmentFactory, txURI, environmentFactory.keepDebug());
	}
}
