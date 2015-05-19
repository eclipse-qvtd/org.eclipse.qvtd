/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
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
 * from: org.eclipse.qvtd.codegen/model/qvticgmodel.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
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

	@Override
	public @Nullable R visitCGEcorePropertyAssignment(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment object) {
		return null;
	}

	@Override
	public @Nullable R visitCGEcoreRealizedVariable(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable object) {
		return null;
	}

	@Override
	public @Nullable R visitCGFunction(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGFunction object) {
		return null;
	}

	@Override
	public @Nullable R visitCGFunctionCallExp(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp object) {
		return null;
	}

	@Override
	public @Nullable R visitCGFunctionParameter(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter object) {
		return null;
	}

	@Override
	public @Nullable R visitCGGuardVariable(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable object) {
		return null;
	}

	@Override
	public @Nullable R visitCGMapping(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMapping object) {
		return null;
	}

	@Override
	public @Nullable R visitCGMappingCall(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall object) {
		return null;
	}

	@Override
	public @Nullable R visitCGMappingCallBinding(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding object) {
		return null;
	}

	@Override
	public @Nullable R visitCGMappingExp(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp object) {
		return null;
	}

	@Override
	public @Nullable R visitCGMappingLoop(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop object) {
		return null;
	}

	@Override
	public @Nullable R visitCGMiddlePropertyAssignment(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment object) {
		return null;
	}

	@Override
	public @Nullable R visitCGMiddlePropertyCallExp(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyCallExp object) {
		return null;
	}

	@Override
	public @Nullable R visitCGPredicate(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate object) {
		return null;
	}

	@Override
	public @Nullable R visitCGPropertyAssignment(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment object) {
		return null;
	}

	@Override
	public @Nullable R visitCGRealizedVariable(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable object) {
		return null;
	}

	@Override
	public @Nullable R visitCGSequence(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGSequence object) {
		return null;
	}

	@Override
	public @Nullable R visitCGTransformation(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation object) {
		return null;
	}

	@Override
	public @Nullable R visitCGTypedModel(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel object) {
		return null;
	}

	@Override
	public @Nullable R visitCGVariablePredicate(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGVariablePredicate object) {
		return null;
	}
}
