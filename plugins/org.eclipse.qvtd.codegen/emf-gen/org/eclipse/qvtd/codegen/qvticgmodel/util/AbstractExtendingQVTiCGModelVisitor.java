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
 * from: org.eclipse.qvtd.codegen/model/qvticgmodel.genmodel
 *
 * Do not edit it.
 */
package	org.eclipse.qvtd.codegen.qvticgmodel.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractExtendingQVTiCGModelVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingQVTiCGModelVisitor<R, C>
	extends org.eclipse.ocl.examples.codegen.cgmodel.util.AbstractExtendingCGModelVisitor<R, C>
	implements QVTiCGModelVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingQVTiCGModelVisitor(@NonNull C context) {
		super(context);
	}	

	public @Nullable R visitCGEcorePropertyAssignment(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment object) {
		return visitCGPropertyAssignment(object);
	}

	public @Nullable R visitCGEcoreRealizedVariable(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable object) {
		return visitCGRealizedVariable(object);
	}

	public @Nullable R visitCGFunction(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGFunction object) {
		return visitCGOperation(object);
	}

	public @Nullable R visitCGFunctionCallExp(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp object) {
		return visitCGOperationCallExp(object);
	}

	public @Nullable R visitCGFunctionParameter(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter object) {
		return visitCGParameter(object);
	}

	public @Nullable R visitCGGuardVariable(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable object) {
		return visitCGParameter(object);
	}

	public @Nullable R visitCGMapping(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMapping object) {
		return visitCGNamedElement(object);
	}

	public @Nullable R visitCGMappingCall(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall object) {
		return visitCGValuedElement(object);
	}

	public @Nullable R visitCGMappingCallBinding(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding object) {
		return visitCGValuedElement(object);
	}

	public @Nullable R visitCGMappingExp(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp object) {
		return visitCGValuedElement(object);
	}

	public @Nullable R visitCGMiddlePropertyAssignment(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment object) {
		return visitCGEcorePropertyAssignment(object);
	}

	public @Nullable R visitCGMiddlePropertyCallExp(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyCallExp object) {
		return visitCGPropertyCallExp(object);
	}

	public @Nullable R visitCGPredicate(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate object) {
		return visitCGValuedElement(object);
	}

	public @Nullable R visitCGPropertyAssignment(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment object) {
		return visitCGValuedElement(object);
	}

	public @Nullable R visitCGRealizedVariable(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable object) {
		return visitCGVariable(object);
	}

	public @Nullable R visitCGTransformation(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation object) {
		return visitCGClass(object);
	}

	public @Nullable R visitCGTypedModel(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel object) {
		return visitCGNamedElement(object);
	}

	public @Nullable R visitCGVariablePredicate(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGVariablePredicate object) {
		return visitCGPredicate(object);
	}
}
