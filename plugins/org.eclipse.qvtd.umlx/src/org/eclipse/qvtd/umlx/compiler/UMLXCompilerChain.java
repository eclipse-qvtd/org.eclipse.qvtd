/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.umlx.compiler;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.AbstractCompilerStep;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.QVTrCompilerChain;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory.CreateStrategy;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrEnvironmentFactory;
import org.eclipse.qvtd.umlx.umlx2qvtr.UMLX2QVTr;

/**
 * The QVTcCompilerChain supports generation of a QVTi Transformation from a QVTc Transformation.
 */
public class UMLXCompilerChain extends QVTrCompilerChain
{
	protected static class UMLX2QVTrCompilerStep extends AbstractCompilerStep
	{
		public UMLX2QVTrCompilerStep(@NonNull CompilerChain compilerChain) {
			super(compilerChain, QVTR_STEP);
		}

		public @NonNull Resource execute(@NonNull URI umlxURI) throws IOException {
			CreateStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTrEnvironmentFactory.CREATE_STRATEGY);
			try {
				Resource umlxResource = environmentFactory.getResourceSet().getResource(umlxURI, true);
				if (umlxResource == null) {
					throw new CompilerChainException("Failed to load " + umlxURI);
				}
				Resource qvtrResource = createResource();
				UMLX2QVTr umlx2qvtr = new UMLX2QVTr(environmentFactory, umlxResource, qvtrResource);
				umlx2qvtr.transform();
				saveResource(qvtrResource);
				return qvtrResource;
			}
			finally {
				environmentFactory.setCreateStrategy(savedStrategy);
			}
		}
	}

	protected final @NonNull UMLX2QVTrCompilerStep umlx2qvtrCompilerStep;

	public UMLXCompilerChain(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI txURI, @Nullable Map<@NonNull String, @Nullable Map<@NonNull Key<Object>, @Nullable Object>> options) {
		super(environmentFactory, txURI, options);
		this.umlx2qvtrCompilerStep = createUMLX2QVTrCompilerStep();
	}

	@Override
	public @NonNull ImperativeTransformation compile(@NonNull String enforcedOutputName) throws IOException {
		Resource rResource = umlx2qvtrCompilerStep.execute(txURI);
		return compileQVTrAS(rResource, enforcedOutputName);
	}

	protected @NonNull UMLX2QVTrCompilerStep createUMLX2QVTrCompilerStep() {
		return new UMLX2QVTrCompilerStep(this);
	}
}
