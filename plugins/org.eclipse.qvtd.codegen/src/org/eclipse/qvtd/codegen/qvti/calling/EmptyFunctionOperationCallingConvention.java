/*******************************************************************************
 * Copyright (c) 2022 Willink Transformation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.calling;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.calling.FunctionOperationCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.naming.ExecutableNameManager;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.library.LibraryOperation;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvti.naming.QVTiExecutableNameManager;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

/**
 *  EmptyFunctionOperationCallingConvention defines the support for the call of an unimplented QVTi function.
 *  <br>
 *  testQVTiCompiler_HSV2HLS_CG has declaration only
 */
public class EmptyFunctionOperationCallingConvention extends FunctionOperationCallingConvention // cg Cached/Constrained
{
	private static final @NonNull EmptyFunctionOperationCallingConvention INSTANCE = new EmptyFunctionOperationCallingConvention();

	public static @NonNull EmptyFunctionOperationCallingConvention getInstance(@NonNull Operation asOperation, boolean maybeVirtual) {
		INSTANCE.logInstance(asOperation, maybeVirtual);
		return INSTANCE;
	}

	@Override
	public void createCGBody(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgOperation) {
		CGFunction cgFunction = (CGFunction)cgOperation;
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		assert asFunction.getImplementationClass() == null;
		assert asFunction.getQueryExpression() == null;
	}

	@Override
	public @NonNull CGFunction createCGOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull Operation asOperation) {
		assert asOperation.getImplementationClass() == null;
		assert asOperation.getBodyExpression() == null;
		return QVTiCGModelFactory.eINSTANCE.createCGFunction();
	}

	@Override
	public @NonNull CGValuedElement createCGOperationCallExp(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgOperation, @NonNull LibraryOperation libraryOperation,
			@Nullable CGValuedElement cgSource, @NonNull OperationCallExp asOperationCallExp) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		Operation asOperation = CGUtil.getAST(cgOperation);
		boolean useClassToCreateObject = PivotUtil.basicGetShadowExp(asOperation) != null;
		CGOperationCallExp cgOperationCallExp = CGModelFactory.eINSTANCE.createCGLibraryOperationCallExp();
		initCallExp(qvtiAnalyzer, cgOperationCallExp, asOperationCallExp, cgOperation, asOperation.isIsRequired());
		assert !useClassToCreateObject;
		assert cgSource != null;
		cgOperationCallExp.getArguments().add(cgSource);
		initCallArguments(qvtiAnalyzer, cgOperationCallExp);
		return cgOperationCallExp;
	}

	@Override
	public void createCGParameters(@NonNull ExecutableNameManager operationNameManager, @Nullable ExpressionInOCL bodyExpression) {
		QVTiExecutableNameManager qvtiOperationNameManager = (QVTiExecutableNameManager)operationNameManager;
		QVTiAnalyzer qvtiAnalyzer = qvtiOperationNameManager.getAnalyzer();
		CGFunction cgFunction = (CGFunction)operationNameManager.getCGScope();
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		boolean useClassToCreateObject = QVTimperativeUtil.basicGetShadowExp(asFunction) != null;
		assert !useClassToCreateObject;
		List<CGParameter> cgParameters = cgFunction.getParameters();
		cgParameters.add(qvtiOperationNameManager.getThisTransformerParameter());
		for (Parameter asParameter : asFunction.getOwnedParameters()) {
			CGParameter cgParameter = qvtiAnalyzer.createCGElement(CGParameter.class, asParameter);
			cgParameters.add(cgParameter);
		}
	}
}
