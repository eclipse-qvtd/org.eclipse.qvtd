/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
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
import org.eclipse.ocl.examples.codegen.analyzer.AnalysisVisitor;
import org.eclipse.ocl.examples.codegen.generator.GlobalContext;
import org.eclipse.ocl.examples.codegen.generator.LocalContext;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionVariable;
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
import org.eclipse.qvtd.pivot.qvtbase.Function;

public class QVTiAnalysisVisitor extends AnalysisVisitor implements QVTiCGModelVisitor<Object>
{
	public QVTiAnalysisVisitor(@NonNull QVTiAnalyzer analyzer) {
		super(analyzer);
	}

	@Override
	public Object visitCGConnectionAssignment(@NonNull CGConnectionAssignment object) {
		return visitCGValuedElement(object);
	}

	@Override
	public Object visitCGConnectionVariable(@NonNull CGConnectionVariable object) {
		return visitCGGuardVariable(object);
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
	public Object visitCGFunctionCallExp(@NonNull CGFunctionCallExp cgFunctionCallExp) {
		Function pFunction = (Function) ((OperationCallExp)cgFunctionCallExp.getAst()).getReferredOperation();
		if (pFunction != null) {
			CGFunction cgFunction = ((QVTiAnalyzer)context).getFunction(pFunction);
			cgFunctionCallExp.setFunction(cgFunction);
		}
		return visitCGOperationCallExp(cgFunctionCallExp);
	}

	@Override
	public Object visitCGFunctionParameter(@NonNull CGFunctionParameter object) {
		return visitCGParameter(object);
	}

	@Override
	public Object visitCGGuardVariable(@NonNull CGGuardVariable object) {
		return visitCGParameter(object);
	}

	@Override
	public Object visitCGMapping(@NonNull CGMapping object) {
		return visitCGNamedElement(object);
	}

	@Override
	public Object visitCGMappingCall(@NonNull CGMappingCall object) {
		return visitCGValuedElement(object);
	}

	@Override
	public Object visitCGMappingCallBinding(@NonNull CGMappingCallBinding cgMappingCallBinding) {
		visitCGValuedElement(cgMappingCallBinding);
		GlobalContext globalContext = context.getCodeGenerator().getGlobalContext();
		LocalContext localContext = globalContext.getLocalContext(cgMappingCallBinding);
		if (localContext != null) {
			cgMappingCallBinding.setValueName(localContext.getNameManagerContext().getSymbolName(cgMappingCallBinding, cgMappingCallBinding.getName()));
		}
		return null;
	}

	@Override
	public Object visitCGMappingExp(@NonNull CGMappingExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public Object visitCGMappingLoop(@NonNull CGMappingLoop object) {
		return visitCGIterationCallExp(object);
	}

	@Override
	public Object visitCGMiddlePropertyAssignment(@NonNull CGMiddlePropertyAssignment object) {
		return visitCGPropertyAssignment(object);
	}

	@Override
	public Object visitCGMiddlePropertyCallExp(@NonNull CGMiddlePropertyCallExp object) {
		return visitCGOppositePropertyCallExp(object);
	}

	@Override
	public Object visitCGPredicate(@NonNull CGPredicate object) {
		return visitCGValuedElement(object);
	}

	@Override
	public Object visitCGPropertyAssignment(@NonNull CGPropertyAssignment object) {
		return visitCGValuedElement(object);
	}

	@Override
	public Object visitCGRealizedVariable(@NonNull CGRealizedVariable cgRealizedVariable) {
		visitCGVariable(cgRealizedVariable);
		GlobalContext globalContext = context.getCodeGenerator().getGlobalContext();
		LocalContext localContext = globalContext.getLocalContext(cgRealizedVariable);
		if (localContext != null) {
			localContext.setNames(cgRealizedVariable, cgRealizedVariable);
		}
		return null;
	}

	@Override
	public Object visitCGSequence(@NonNull CGSequence object) {
		return visitCGValuedElement(object);
	}

	@Override
	public Object visitCGTransformation(@NonNull CGTransformation object) {
		return visitCGClass(object);
	}

	@Override
	public Object visitCGTypedModel(@NonNull CGTypedModel object) {
		return visitCGNamedElement(object);
	}

	@Override
	public Object visitCGVariablePredicate(@NonNull CGVariablePredicate object) {
		return visitCGPredicate(object);
	}
}
