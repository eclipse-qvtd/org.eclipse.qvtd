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
package org.eclipse.qvtd.debug.launching;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.debug.core.QVTiDebugCore;
import org.eclipse.qvtd.debug.evaluator.BasicQVTrExecutor;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiExecutor;

public class QVTrLaunchConfigurationDelegate extends QVTiLaunchConfigurationDelegate
{ 
	protected @NonNull QVTiExecutor createExecutor(@NonNull QVTiEnvironmentFactory envFactory, @NonNull Transformation transformation) {
		return new BasicQVTrExecutor(envFactory, transformation);
	}

	protected @NonNull QVTiDebugCore getDebugCore() {
		return QVTiDebugCore.INSTANCE;				// FIXME QVTrDebugCore with back-traceability
	}

	protected @NonNull URI getTransformationURI(final ILaunchConfiguration configuration) throws CoreException {
		Map<String, String> intermediatesMap = configuration.getAttribute(INTERMEDIATES_KEY, EMPTY_MAP);
		String qvtiName = intermediatesMap.get(CompilerChain.QVTI_STEP);
		return URI.createURI(qvtiName, true);
	}
}

