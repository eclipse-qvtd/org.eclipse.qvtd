/*******************************************************************************
 * Copyright (c) 2013, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvticgmodel.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.naming.GlobalNameManager;
import org.eclipse.ocl.examples.codegen.naming.NestedNameManager;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.util.AbstractQVTiCGModelAnalysisVisitor;
import org.eclipse.qvtd.pivot.qvtbase.Function;

public class QVTiCGModelAnalysisVisitor extends AbstractQVTiCGModelAnalysisVisitor
{
	public QVTiCGModelAnalysisVisitor(@NonNull QVTiAnalyzer analyzer) {
		super(analyzer);
	}

	protected @NonNull QVTiAnalyzer getAnalyzer() {
		return (QVTiAnalyzer) context;
	}

	@Override
	public Object visitCGFunctionCallExp(@NonNull CGFunctionCallExp cgFunctionCallExp) {
		Function asFunction = (Function) ((OperationCallExp)cgFunctionCallExp.getAst()).getReferredOperation();
		if (asFunction != null) {
			CGFunction cgFunction = getAnalyzer().getCGFunction(asFunction);
			cgFunctionCallExp.setFunction(cgFunction);
		}
		return visitCGOperationCallExp(cgFunctionCallExp);
	}

	@Override
	public Object visitCGMappingCallBinding(@NonNull CGMappingCallBinding cgMappingCallBinding) {
		visitCGValuedElement(cgMappingCallBinding);
		GlobalNameManager globalNameManager = context.getGlobalNameManager();
		//	NameManager nameManager = globalNameManager.findNestedNameManager(cgMappingCallBinding);
		//	nameManager.queueValueName(cgMappingCallBinding, null, cgMappingCallBinding.getName());
		//	nameManager.declareStandardName(cgMappingCallBinding);
		return null;
	}

	@Override
	public Object visitCGRealizedVariable(@NonNull CGRealizedVariable cgRealizedVariable) {
		visitCGVariable(cgRealizedVariable);
		GlobalNameManager globalNameManager = context.getGlobalNameManager();
		NestedNameManager localNameManager = globalNameManager.findNestedNameManager(cgRealizedVariable);
		String nameHint = cgRealizedVariable.getName();
		if (nameHint == null) {
			nameHint = localNameManager.getNameHint(cgRealizedVariable);
		}
		return null;
	}
}
