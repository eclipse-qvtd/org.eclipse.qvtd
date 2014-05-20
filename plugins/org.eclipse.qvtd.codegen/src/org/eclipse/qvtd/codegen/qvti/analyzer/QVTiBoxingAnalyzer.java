/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.analyzer;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.CGVariablePredicate;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;

public class QVTiBoxingAnalyzer extends BoxingAnalyzer implements QVTiCGModelVisitor<Object>
{
	
	public QVTiBoxingAnalyzer(@NonNull QVTiAnalyzer analyzer) {
		super(analyzer);
	}

	public Object visitCGEcorePropertyAssignment(@NonNull CGEcorePropertyAssignment cgEcorePropertyAssignment) {
		rewriteAsUnboxed(cgEcorePropertyAssignment.getSlotValue());
		rewriteAsUnboxed(cgEcorePropertyAssignment.getInitValue());
		return visitCGPropertyAssignment(cgEcorePropertyAssignment);
	}

	public Object visitCGEcoreRealizedVariable(@NonNull CGEcoreRealizedVariable cgEcoreRealizedVariable) {
		rewriteAsAssertNonNulled(cgEcoreRealizedVariable);
		return visitCGRealizedVariable(cgEcoreRealizedVariable);
	}

	public Object visitCGFunction(@NonNull CGFunction cgFunction) {
		visitCGOperation(cgFunction);
		rewriteAsUnboxed(cgFunction.getBody());
		return null;
	}

	public Object visitCGFunctionCallExp(@NonNull CGFunctionCallExp cgFunctionCallExp) {
		visitCGOperationCallExp(cgFunctionCallExp);
		for (CGValuedElement cgArgument : cgFunctionCallExp.getArguments()) {
			rewriteAsUnboxed(cgArgument);
		}
		return null;
	}

	public Object visitCGFunctionParameter(@NonNull CGFunctionParameter object) {
		return visitCGParameter(object);
	}

	public Object visitCGGuardVariable(@NonNull CGGuardVariable object) {
		return visitCGParameter(object);
	}

	public Object visitCGMapping(@NonNull CGMapping cgMapping) {
		return visitCGNamedElement(cgMapping);
	}

	public Object visitCGMappingCall(@NonNull CGMappingCall cgMappingCall) {
		return visitCGValuedElement(cgMappingCall);
	}

	public Object visitCGMappingCallBinding(@NonNull CGMappingCallBinding cgMappingCallBinding) {
		if (cgMappingCallBinding.isRequired()) {
			MappingCallBinding mappingCallBinding = (MappingCallBinding)cgMappingCallBinding.getAst();
			rewriteAsUnboxed(rewriteAsGuarded(cgMappingCallBinding.getValueOrValues(), "binding for '" + mappingCallBinding.getMappingCall().getReferredMapping().getName() + "::" + mappingCallBinding.getBoundVariable().getName() + "'"));	// FIXME referred mapping
		}
		else {
			rewriteAsUnboxed(cgMappingCallBinding.getValueOrValues());
		}
		return visitCGValuedElement(cgMappingCallBinding);
	}

	public Object visitCGMappingExp(@NonNull CGMappingExp object) {
		return visitCGValuedElement(object);
	}

	public Object visitCGMiddlePropertyAssignment(@NonNull CGMiddlePropertyAssignment cgMiddlePropertyAssignment) {
		rewriteAsUnboxed(cgMiddlePropertyAssignment.getSlotValue());
		rewriteAsUnboxed(cgMiddlePropertyAssignment.getInitValue());
		return visitCGPropertyAssignment(cgMiddlePropertyAssignment);
	}

	public Object visitCGMiddlePropertyCallExp(@NonNull CGMiddlePropertyCallExp object) {
		return visitCGOppositePropertyCallExp(object);
	}

	public Object visitCGPredicate(@NonNull CGPredicate cgPredicate) {
		return visitCGValuedElement(cgPredicate);
	}

	public Object visitCGPropertyAssignment(@NonNull CGPropertyAssignment cgPropertyAssignment) {
		return visitCGValuedElement(cgPropertyAssignment);
	}

	public Object visitCGRealizedVariable(@NonNull CGRealizedVariable cgRealizedVariable) {
		return visitCGVariable(cgRealizedVariable);
	}

	public Object visitCGTransformation(@NonNull CGTransformation cgTransformation) {
		return visitCGClass(cgTransformation);
	}

	public Object visitCGTypedModel(@NonNull CGTypedModel object) {
		return visitCGNamedElement(object);
	}

	public Object visitCGVariablePredicate(@NonNull CGVariablePredicate object) {
		return visitCGPredicate(object);
	}
}
