/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

/**
 * The QVTiCompilerChain supports loading a QVTi Transformation as a degenerate comaptibility with QVTc and QVTr.
 */
public class QVTiCompilerChain extends AbstractCompilerChain
{
	public QVTiCompilerChain(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI prefixURI, @Nullable Map<@NonNull String, @NonNull Map<@NonNull Key<?>, @Nullable Object>> options) {
		super(environmentFactory, prefixURI, options);
	}

	@Override
	public @NonNull Transformation compile(@NonNull String unusedEnforcedOutputName) throws IOException {
		Transformation loadTransformation = QVTimperativeUtil.loadTransformation(environmentFactory, txURI, false);
		Resource iResource = ClassUtil.nonNullState(loadTransformation.eResource());
		compiled(QVTI_STEP, iResource);
		return loadTransformation;
	}
}
