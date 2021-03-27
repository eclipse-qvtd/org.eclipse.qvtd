/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler;

import java.io.IOException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfigurations;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentFactory;
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

		public @NonNull ImperativeTransformation execute(@NonNull QVTimperativeEnvironmentFactory environmentFactory, @NonNull URI txURI) throws IOException {
			ImperativeTransformation asTransformation = QVTimperativeUtil.loadTransformation(environmentFactory, txURI, false);
			Resource iResource = ClassUtil.nonNullState(asTransformation.eResource());
			iResource.setURI(getURI());
			checkForProxyURIs(iResource);
			saveResource(iResource);
			return asTransformation;
		}
	}

	protected final @NonNull Xtext2QVTiCompilerStep xtext2qvtiCompilerStep;

	public QVTiCompilerChain(@NonNull ProjectManager projectManager, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull CompilerOptions options) {
		super(projectManager, txURI, intermediateFileNamePrefixURI, options);
		this.xtext2qvtiCompilerStep = createXtext2QVTiCompilerStep();
	}

	@Override
	public @NonNull ImperativeTransformation compile(@NonNull TypedModelsConfigurations typedModelsConfigurations) throws IOException {
		QVTimperativeEnvironmentFactory environmentFactory = xtext2qvtiCompilerStep.getEnvironmentFactory();
		return xtext2qvtiCompilerStep.execute(environmentFactory, txURI);
	}

	@Override
	protected @NonNull ImperativeTransformation compile4(@NonNull QVTimperativeEnvironmentFactory environmentFactory, @NonNull TypedModelsConfigurations typedModelsConfigurations) throws IOException {
		return xtext2qvtiCompilerStep.execute(environmentFactory, txURI);
	}

	protected @NonNull Xtext2QVTiCompilerStep createXtext2QVTiCompilerStep() {
		return new Xtext2QVTiCompilerStep(this);
	}
}
