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
import org.eclipse.ocl.examples.codegen.calling.AbstractCachedOperationCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.naming.ExecutableNameManager;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.library.LibraryOperation;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;

/**
 *  InternalFunctionOperationCallingConvention defines the uncached support for the call of a transient QVTi function implemented by an OCL expression.
 */
public class TransientFunctionOperationCallingConvention extends AbstractCachedOperationCallingConvention // cg Cached/Constrained
{
	private static final @NonNull TransientFunctionOperationCallingConvention INSTANCE = new TransientFunctionOperationCallingConvention();

	public static @NonNull TransientFunctionOperationCallingConvention getInstance(@NonNull Operation asOperation, boolean maybeVirtual) {
		INSTANCE.logInstance(asOperation, maybeVirtual);
		return INSTANCE;
	}

	@Override
	public void createCGBody(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgOperation) {
		CGFunction cgFunction = (CGFunction)cgOperation;
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		OCLExpression query = asFunction.getQueryExpression(); //getBodyExpression();
		//	callingConvention.createCGParameters(this, cgFunction, null);
		assert asFunction.getImplementationClass() == null;
		assert query != null;
		//			try {
		//				ExpressionInOCL query = metamodelManager.parseSpecification(specification);
		//				Variable contextVariable = query.getOwnedContext();
		//				if (contextVariable != null) {
		//					getParameter(contextVariable);
		//				}
		//				for (@SuppressWarnings("null")@NonNull Variable parameterVariable : query.getOwnedParameters()) {
		//					getParameter(parameterVariable);
		//				}
		//	cgFunction.setBody(doVisit(CGValuedElement.class, query)); //.getOwnedBody()));
		super.createCGBody(analyzer, cgFunction);
		//			} catch (ParserException e) {
		// TODO Auto-generated catch block
		//				e.printStackTrace();
		//			}
		//	analyzer.addFunction(asFunction, cgFunction); */
	}

	@Override
	public @NonNull CGFunction createCGOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull Operation asOperation) {
		assert asOperation.getImplementationClass() == null;
		return QVTiCGModelFactory.eINSTANCE.createCGFunction();
	}

	@Override
	public @NonNull CGValuedElement createCGOperationCallExp(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgOperation, @NonNull LibraryOperation libraryOperation,
			@Nullable CGValuedElement cgSource, @NonNull OperationCallExp asOperationCallExp) {
		assert false;
		Operation asOperation = CGUtil.getAST(cgOperation);
		boolean useClassToCreateObject = PivotUtil.basicGetShadowExp(asOperation) != null;
		CGOperationCallExp cgOperationCallExp = CGModelFactory.eINSTANCE.createCGLibraryOperationCallExp();
		initCallExp(analyzer, cgOperationCallExp, asOperationCallExp, cgOperation, asOperation.isIsRequired());
		assert !useClassToCreateObject;
		assert cgSource != null;
		cgOperationCallExp.getArguments().add(cgSource);
		initCallArguments(analyzer, cgOperationCallExp);
		return cgOperationCallExp;
	}

	@Override
	public void createCGParameters(@NonNull ExecutableNameManager operationNameManager, @Nullable ExpressionInOCL bodyExpression) {
		CodeGenAnalyzer qvtiAnalyzer = operationNameManager.getAnalyzer();
		CGOperation cgOperation = (CGFunction)operationNameManager.getCGScope();
		Operation asOperation = QVTiCGUtil.getAST(cgOperation);
		boolean useClassToCreateObject = PivotUtil.basicGetShadowExp(asOperation) != null;
		assert !useClassToCreateObject;
		List<CGParameter> cgParameters = cgOperation.getParameters();
		cgParameters.add(operationNameManager.getContextObjectParameter());
		for (Parameter asParameter : asOperation.getOwnedParameters()) {
			CGParameter cgParameter = qvtiAnalyzer.createCGElement(CGParameter.class, asParameter);
			cgParameters.add(cgParameter);
		}
	}

	@Override
	public boolean generateJavaCall(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperationCallExp cgOperationCallExp) {
		return generateDeprecatedJavaCall(cg2javaVisitor, js, cgOperationCallExp);
	}
}
