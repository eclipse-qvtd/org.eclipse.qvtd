/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.compiler;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.runtime.evaluation.Transformer;

public interface OCL2JavaTxCompiler<P extends OCL2JavaTxCompilerParams> {

	// FIXME fix exception handling

	public Class<? extends Transformer> compileTransformation(@Nullable ResourceSet rSet,
			@NonNull CS2ASJavaCompilerParameters params, @NonNull URI oclDocURI,
			@NonNull URI... extendedOCLDocURIs) throws Exception;

	public Class<? extends Transformer> compileTransformation(@Nullable ResourceSet rSet,
			@NonNull CS2ASJavaCompilerParameters params, @NonNull String tracePropertyName, @NonNull URI oclDocURI,
			@NonNull URI... extendedOCLDocURIs) throws Exception;
}
