/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
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
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

/**
 * The QVTiCompilerChain supports loading a QVTi Transformation as a degenerate comaptibility with QVTc and QVTr.
 */
public class QVTiCompilerChain extends AbstractCompilerChain
{
	protected static class Xtext2QVTiCompilerStep extends AbstractCompilerStep
	{
		public Xtext2QVTiCompilerStep(@NonNull CompilerChain compilerChain) {
			super(compilerChain, QVTI_STEP);
		}

		public @NonNull ImperativeTransformation execute(@NonNull URI txURI) throws IOException {
			ImperativeTransformation asTransformation = QVTimperativeUtil.loadTransformation(environmentFactory, txURI, false);
			Resource iResource = ClassUtil.nonNullState(asTransformation.eResource());
			checkForProxyURIs(iResource);
			compiled(iResource);
			return asTransformation;
		}
	}

	protected final @NonNull Xtext2QVTiCompilerStep xtext2qvtiCompilerStep;

	public QVTiCompilerChain(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI prefixURI, @Nullable Map<@NonNull String, @Nullable Map<@NonNull Key<Object>, @Nullable Object>> options) {
		super(environmentFactory, prefixURI, options);
		this.xtext2qvtiCompilerStep = createXtext2QVTiCompilerStep();
	}

	@Override
	public @NonNull ImperativeTransformation compile(@NonNull String unusedEnforcedOutputName) throws IOException {
		return xtext2qvtiCompilerStep.execute(txURI);
	}

	protected @NonNull Xtext2QVTiCompilerStep createXtext2QVTiCompilerStep() {
		return new Xtext2QVTiCompilerStep(this);
	}
}
