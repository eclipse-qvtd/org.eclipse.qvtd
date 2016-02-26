/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.compiler;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.tx.Transformer;

public interface OCL2JavaTxCompiler<P extends OCL2JavaTxCompilerParams> {

	// FIXME fix exception handling
	
	public Class<? extends Transformer> compileTransformation(@Nullable ResourceSet rSet,
			@NonNull CS2ASJavaCompilerParameters params, @NonNull URI oclDocURI,
			URI... extendedOCLDocURIs) throws Exception; 
	
	public Class<? extends Transformer> compileTransformation(@Nullable ResourceSet rSet,
			@NonNull CS2ASJavaCompilerParameters params, @NonNull String tracePropertyName, @NonNull URI oclDocURI,
			URI... extendedOCLDocURIs) throws Exception;
}
