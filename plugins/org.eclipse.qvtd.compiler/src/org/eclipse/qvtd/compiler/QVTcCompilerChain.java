/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
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
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.qvtd.compiler.internal.qvtc2qvtu.QVTuConfiguration;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;

/**
 * The QVTcCompilerChain supports generation of a QVTi Transformation from a QVTc Transformation.
 */
public class QVTcCompilerChain extends AbstractCompilerChain
{
	public static class Xtext2QVTcCompilerStep extends AbstractCompilerStep
	{
		public Xtext2QVTcCompilerStep(@NonNull CompilerChain compilerChain) {
			super(compilerChain, QVTC_STEP);
		}

		public @NonNull Resource execute(@NonNull URI txURI) throws IOException {
			Resource cResource = QVTcoreUtil.loadTransformations(environmentFactory, txURI, false);
			// FIXME Following code fixes up missing source. Should be fixed earlier.
			List<@NonNull OperationCallExp> missingOperationCallSources = QVTbaseUtil.rewriteMissingOperationCallSources(environmentFactory, cResource);
			if (missingOperationCallSources != null) {
				System.err.println("Missing OperationCallExp sources were fixed up for '" + txURI + "'");
			}
			compiled(cResource);
			return cResource;
		}
	}

	protected final @NonNull Xtext2QVTcCompilerStep xtext2qvtcCompilerStep;

	public QVTcCompilerChain(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI prefixURI, @Nullable Map<@NonNull String, @Nullable Map<@NonNull Key<Object>, @Nullable Object>> options) {
		super(environmentFactory, prefixURI, options);
		this.xtext2qvtcCompilerStep = createXtext2QVTcCompilerStep();
	}

	@Override
	public @NonNull ImperativeTransformation compile(@NonNull String enforcedOutputName) throws IOException {
		Resource cResource = xtext2qvtcCompilerStep.execute(txURI);
		QVTuConfiguration qvtuConfiguration = createQVTuConfiguration(cResource, QVTuConfiguration.Mode.ENFORCE, enforcedOutputName);
		//		setOption(QVTU_STEP, QVTU_CONFIGURATION_KEY, qvtuConfiguration);
		Resource pResource = qvtc2qvtm(cResource, qvtuConfiguration);
		return qvtm2qvti(pResource);
	}

	protected @NonNull Xtext2QVTcCompilerStep createXtext2QVTcCompilerStep() {
		return new Xtext2QVTcCompilerStep(this);
	}
}
