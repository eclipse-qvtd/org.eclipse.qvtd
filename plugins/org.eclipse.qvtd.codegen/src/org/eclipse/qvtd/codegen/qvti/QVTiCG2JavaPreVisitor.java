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
 */
package org.eclipse.qvtd.codegen.qvti;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;

public class QVTiCG2JavaPreVisitor extends CG2JavaPreVisitor implements QVTiCGModelVisitor<Object>
{
	public QVTiCG2JavaPreVisitor(@NonNull QVTiGlobalContext javaContext) {
		super(javaContext);
	}

	@Override
	public Object visitCGEcorePropertyAssignment(@NonNull CGEcorePropertyAssignment object) {
		return visitCGPropertyAssignment(object);
	}

	@Override
	public Object visitCGEcoreRealizedVariable(@NonNull CGEcoreRealizedVariable object) {
		return visitCGRealizedVariable(object);
	}

	@Override
	public Object visitCGFunction(@NonNull CGFunction object) {
		return visitCGOperation(object);
	}

	@Override
	public Object visitCGFunctionCallExp(@NonNull CGFunctionCallExp object) {
		return visitCGOperationCallExp(object);
	}

	@Override
	public Object visitCGFunctionParameter(@NonNull CGFunctionParameter object) {
		return visitCGParameter(object);
	}

	@Override
	public @Nullable Object visitCGMapping(@NonNull CGMapping cgMapping) {
		localContext = context.getLocalContext(cgMapping);
		try {
			return visitCGTypedElement(cgMapping);
		}
		finally {
			localContext = null;
		}
	}

	@Override
	public Object visitCGGuardVariable(@NonNull CGGuardVariable object) {
		return visitCGParameter(object);
	}

	@Override
	public Object visitCGMappingCall(@NonNull CGMappingCall object) {
		return visitCGValuedElement(object);
	}

	@Override
	public Object visitCGMappingCallBinding(@NonNull CGMappingCallBinding object) {
		return visitCGValuedElement(object);
	}

	@Override
	public Object visitCGPredicate(@NonNull CGPredicate object) {
		return visitCGValuedElement(object);
	}

	@Override
	public Object visitCGPropertyAssignment(@NonNull CGPropertyAssignment cgPropertyAssignment) {
		Property pReferredProperty = cgPropertyAssignment.getReferredProperty();
		if (pReferredProperty != null) {
			localContext.getExecutorProperty(pReferredProperty);
		}
		return visitCGValuedElement(cgPropertyAssignment);
	}

	@Override
	public Object visitCGRealizedVariable(@NonNull CGRealizedVariable cgRealizedVariable) {
		Type pType = ((RealizedVariable)cgRealizedVariable.getPivot()).getType();
		if (pType != null) {
			localContext.getExecutorType(pType);
		}
		return visitCGVariable(cgRealizedVariable);
	}

	@Override
	public Object visitCGTransformation(@NonNull CGTransformation object) {
		return visitCGClass(object);
	}

	@Override
	public Object visitCGTypedModel(@NonNull CGTypedModel object) {
		return visitCGNamedElement(object);
	}
}
