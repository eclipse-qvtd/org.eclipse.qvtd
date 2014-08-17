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
package org.eclipse.qvtd.codegen.qvti.java;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CGUtils;
import org.eclipse.ocl.examples.codegen.analyzer.DependencyVisitor;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
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
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.CGVariablePredicate;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;

public class QVTiCG2JavaPreVisitor extends CG2JavaPreVisitor implements QVTiCGModelVisitor<Object>
{
	public QVTiCG2JavaPreVisitor(@NonNull QVTiGlobalContext javaContext) {
		super(javaContext);
	}

	public Object visitCGEcorePropertyAssignment(@NonNull CGEcorePropertyAssignment object) {
		return visitCGPropertyAssignment(object);
	}

	public Object visitCGEcoreRealizedVariable(@NonNull CGEcoreRealizedVariable object) {
		return visitCGRealizedVariable(object);
	}

	public Object visitCGFunction(@NonNull CGFunction object) {
		return visitCGOperation(object);
	}

	public Object visitCGFunctionCallExp(@NonNull CGFunctionCallExp object) {
		return visitCGOperationCallExp(object);
	}

	public Object visitCGFunctionParameter(@NonNull CGFunctionParameter object) {
		return visitCGParameter(object);
	}

	public Object visitCGGuardVariable(@NonNull CGGuardVariable object) {
		return visitCGParameter(object);
	}

	public @Nullable Object visitCGMapping(@NonNull CGMapping cgMapping) {
		localContext = context.getLocalContext(cgMapping);
		try {
			return visitCGNamedElement(cgMapping);
		}
		finally {
			localContext = null;
		}
	}

	public Object visitCGMappingCall(@NonNull CGMappingCall object) {
		return visitCGValuedElement(object);
	}

	public Object visitCGMappingCallBinding(@NonNull CGMappingCallBinding object) {
		return visitCGValuedElement(object);
	}

	public Object visitCGMappingExp(@NonNull CGMappingExp cgMappingExp) {
		List<CGPredicate> cgPredicates = cgMappingExp.getPredicates();
		if (cgPredicates.size() > 0) {
			DependencyVisitor dependencyVisitor = codeGenerator.createDependencyVisitor();
			dependencyVisitor.visitAll(cgPredicates);
			List<CGValuedElement> sortedDependencies = dependencyVisitor.getSortedDependencies(false);
			CGPredicate cgFirstPredicate = null;
			CGPredicate cgLastPredicate = null;
			for (CGValuedElement sortedDependency : sortedDependencies) {
				if (sortedDependency instanceof CGPredicate) {
					CGPredicate cgPredicate = (CGPredicate) sortedDependency;
					if (cgFirstPredicate == null) {
						cgFirstPredicate = cgPredicate;
					}
					else {
						assert cgLastPredicate != null;
						PivotUtil.resetContainer(cgPredicate);
						cgLastPredicate.setThenExpression(cgPredicate);
					}
					cgLastPredicate = cgPredicate;
				}
			}
			assert cgFirstPredicate != null;
			assert cgLastPredicate != null;
			CGUtils.replace(cgMappingExp, cgFirstPredicate);
			cgLastPredicate.setThenExpression(cgMappingExp);
			return visitCGValuedElement(cgFirstPredicate);
		}
		else {
			return visitCGValuedElement(cgMappingExp);
		}
	}

	public Object visitCGMappingLoop(@NonNull CGMappingLoop object) {
		return visitCGIterationCallExp(object);
	}

	public Object visitCGMiddlePropertyAssignment(@NonNull CGMiddlePropertyAssignment object) {
		return visitCGPropertyAssignment(object);
	}

	public Object visitCGMiddlePropertyCallExp(@NonNull CGMiddlePropertyCallExp object) {
		return visitCGOppositePropertyCallExp(object);
	}

	public Object visitCGPredicate(@NonNull CGPredicate object) {
		return visitCGValuedElement(object);
	}

	public Object visitCGPropertyAssignment(@NonNull CGPropertyAssignment cgPropertyAssignment) {
//		Property pReferredProperty = cgPropertyAssignment.getReferredProperty();
//		if (pReferredProperty != null) {
//			localContext.getExecutorProperty(pReferredProperty);
//		}
		return visitCGValuedElement(cgPropertyAssignment);
	}

	public Object visitCGRealizedVariable(@NonNull CGRealizedVariable cgRealizedVariable) {
//		Type pType = ((RealizedVariable)cgRealizedVariable.getPivot()).getType();
//		if (pType != null) {
//			localContext.getExecutorType(pType);
//		}
		return visitCGVariable(cgRealizedVariable);
	}

	public Object visitCGSequence(@NonNull CGSequence object) {
		return visitCGValuedElement(object);
	}

	public Object visitCGTransformation(@NonNull CGTransformation object) {
		return visitCGClass(object);
	}

	public Object visitCGTypedModel(@NonNull CGTypedModel object) {
		return visitCGNamedElement(object);
	}

	public Object visitCGVariablePredicate(@NonNull CGVariablePredicate object) {
		return visitCGPredicate(object);
	}
}
