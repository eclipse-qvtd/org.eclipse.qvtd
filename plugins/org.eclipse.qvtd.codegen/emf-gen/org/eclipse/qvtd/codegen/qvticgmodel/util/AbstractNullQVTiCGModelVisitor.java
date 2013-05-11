/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: model/qvticgmodel.genmodel
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvtd.codegen.qvticgmodel.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractNullQVTiCGModelVisitor provides a default implementation for each
 * visitXxx method that returns null.
 */
public abstract class AbstractNullQVTiCGModelVisitor<R, C>
	extends org.eclipse.ocl.examples.codegen.cgmodel.util.AbstractNullCGModelVisitor<R, C> implements QVTiCGModelVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNullQVTiCGModelVisitor(@NonNull C context) {
	    super(context);
	}	

	public @Nullable R visitCGEcorePropertyAssignment(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment object) {
		return null;
	}

	public @Nullable R visitCGEcoreRealizedVariable(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable object) {
		return null;
	}

	public @Nullable R visitCGFunction(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGFunction object) {
		return null;
	}

	public @Nullable R visitCGFunctionCallExp(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp object) {
		return null;
	}

	public @Nullable R visitCGFunctionParameter(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter object) {
		return null;
	}

	public @Nullable R visitCGGuardVariable(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable object) {
		return null;
	}

	public @Nullable R visitCGMapping(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMapping object) {
		return null;
	}

	public @Nullable R visitCGMappingCall(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall object) {
		return null;
	}

	public @Nullable R visitCGMappingCallBinding(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding object) {
		return null;
	}

	public @Nullable R visitCGPredicate(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate object) {
		return null;
	}

	public @Nullable R visitCGPropertyAssignment(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment object) {
		return null;
	}

	public @Nullable R visitCGRealizedVariable(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable object) {
		return null;
	}

	public @Nullable R visitCGTransformation(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation object) {
		return null;
	}

	public @Nullable R visitCGTypedModel(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel object) {
		return null;
	}
}
