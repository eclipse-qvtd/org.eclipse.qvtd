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
package org.eclipse.qvtd.codegen.qvti.java;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTuplePartCallExpImpl;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.naming.ExecutableNameManager;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.library.LibraryOperation;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

/**
 *  InternalFunctionOperationCallingConvention defines the support for the call of a QVTi function implemented by an OCL expression.
 *
 *  The implementation uses a class whose instance caches a result to ensure unique shared execution.
 */
public class InternalFunctionOperationCallingConvention extends FunctionOperationCallingConvention // cg Cached/Constrained
{
	public static final @NonNull InternalFunctionOperationCallingConvention INSTANCE = new InternalFunctionOperationCallingConvention();

	protected static class CachePropertyCallExpImpl extends CGTuplePartCallExpImpl		// XXX move to CG model
	{
		@Override
		public boolean isInlined() {
			return true;
		}
	}

	@Override
	public void createCGBody(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgOperation) {
		CGFunction cgFunction = (CGFunction)cgOperation;
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		OCLExpression query = asFunction.getQueryExpression(); //getBodyExpression();
		assert asFunction.getImplementationClass() == null;
		assert query != null;
		super.createCGBody(analyzer, cgFunction);
	}

	@Override
	public @NonNull CGFunction createCGOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull Operation asOperation) {
		//	assert asOperation.getImplementation() == null;		-- maybe ConstrainedOperation
		assert asOperation.getImplementationClass() == null;
		return QVTiCGModelFactory.eINSTANCE.createCGFunction();
	}

	@Override
	public @NonNull CGValuedElement createCGOperationCallExp(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgOperation, @NonNull LibraryOperation libraryOperation,
			@Nullable CGValuedElement cgSource, @NonNull OperationCallExp asOperationCallExp) {
		assert cgSource != null;
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		CGFunction cgFunction = (CGFunction)cgOperation;
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		assert QVTimperativeUtil.basicGetShadowExp(asFunction) == null;
		CGFunctionCallExp cgFunctionCallExp = QVTiCGModelFactory.eINSTANCE.createCGFunctionCallExp();
		initCallExp(qvtiAnalyzer, cgFunctionCallExp, asOperationCallExp, cgOperation, asFunction.isIsRequired());
		cgFunctionCallExp.getArguments().add(cgSource);
		initCallArguments(qvtiAnalyzer, cgFunctionCallExp);
		return cgFunctionCallExp;
	}

	@Override
	public void createCGParameters(@NonNull ExecutableNameManager operationNameManager, @Nullable ExpressionInOCL bodyExpression) {
		super.createCGParameters(operationNameManager, bodyExpression);
		QVTiExecutableNameManager qvtiOperationNameManager = (QVTiExecutableNameManager)operationNameManager;
		org.eclipse.ocl.pivot.Class asCacheClass = createCacheClass(qvtiOperationNameManager);
		createConstructorClass(qvtiOperationNameManager, asCacheClass);
	}

	@Override
	public boolean generateJavaCall(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperationCallExp cgOperationCallExp) {
		return super.generateJavaCall(cg2javaVisitor, js, cgOperationCallExp);
	}

	@Override
	public boolean generateJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperation cgOperation) {
		return super.generateJavaDeclaration(cg2javaVisitor, js, cgOperation);
	}

	@Override
	public void rewriteWithBoxingAndGuards(@NonNull BoxingAnalyzer boxingAnalyzer, @NonNull CGOperation cgOperation) {
		super.rewriteWithBoxingAndGuards(boxingAnalyzer, cgOperation);
		//	CGValuedElement cgBody = CGUtil.getBody(cgOperation);
		//	boxingAnalyzer.rewriteAsBoxed(cgBody);
		CGValuedElement cgBody = cgOperation.getBody();
		if (cgBody != null) {				// XXX null while developing
			boxingAnalyzer.rewriteAsBoxed(cgBody);
		}
	}

	@Override
	public void rewriteWithBoxingAndGuards(@NonNull BoxingAnalyzer boxingAnalyzer,@NonNull CGOperationCallExp cgOperationCallExp) {
		for (@NonNull CGValuedElement cgArgument : CGUtil.getArguments(cgOperationCallExp)) {
			boxingAnalyzer.rewriteAsBoxed(cgArgument);
		}
	}
}
