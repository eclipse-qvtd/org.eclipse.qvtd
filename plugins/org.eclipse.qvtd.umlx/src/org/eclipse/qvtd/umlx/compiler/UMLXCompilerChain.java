/*******************************************************************************
 * Copyright (c) 2017, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.umlx.compiler;

import java.io.IOException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.compiler.AbstractCompilerStep;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.QVTrCompilerChain;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfigurations;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.EnvironmentStrategy;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationEnvironmentStrategy;
import org.eclipse.qvtd.umlx.umlx2qvtr.UMLX2QVTr;

/**
 * The QVTcCompilerChain supports generation of a QVTi Transformation from a QVTc Transformation.
 */
public class UMLXCompilerChain extends QVTrCompilerChain
{
	public static final @NonNull String PLUGIN_ID = UMLXCompilerChain.class.getPackage().getName();

	protected static class UMLX2QVTrCompilerStep extends AbstractCompilerStep
	{
		public UMLX2QVTrCompilerStep(@NonNull CompilerChain compilerChain) {
			super(compilerChain, QVTR_STEP);
		}

		public @NonNull Resource execute(@NonNull QVTimperativeEnvironmentFactory environmentFactory, @NonNull URI umlxURI) throws IOException {
			EnvironmentStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTrelationEnvironmentStrategy.INSTANCE);
			try {
				Resource umlxResource = environmentFactory.getResourceSet().getResource(umlxURI, true);
				if (umlxResource == null) {
					throw new CompilerChainException("Failed to load " + umlxURI);
				}
				Resource qvtrResource = createResource(QVTrelationPackage.eCONTENT_TYPE);
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

	public UMLXCompilerChain(@NonNull ProjectManager projectManager, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull CompilerOptions options) {
		super(projectManager, txURI, intermediateFileNamePrefixURI, options);
		this.umlx2qvtrCompilerStep = createUMLX2QVTrCompilerStep();
	}

	@Override
	public @NonNull ImperativeTransformation compile4(@NonNull QVTimperativeEnvironmentFactory environmentFactory, @NonNull TypedModelsConfigurations typedModelsConfigurations) throws IOException {
		Resource qvtrResource = umlx2qvtrCompilerStep.execute(environmentFactory, txURI);
		return qvtr2qvti(environmentFactory, qvtrResource, typedModelsConfigurations);
	}

	protected @NonNull UMLX2QVTrCompilerStep createUMLX2QVTrCompilerStep() {
		return new UMLX2QVTrCompilerStep(this);
	}
}
