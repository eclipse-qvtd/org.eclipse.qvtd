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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.calling.AbstractCachedOperationCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTuplePartCallExpImpl;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.naming.ExecutableNameManager;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.library.LibraryOperation;
import org.eclipse.qvtd.codegen.qvti.calling.ShadowFunctionOperationCallingConvention.FunctionEvaluateOperationCallingConvention;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

/**
 *  InternalFunctionOperationCallingConvention defines the support for the call of a QVTi function implemented by an OCL expression.
 *
 *  The implementation uses a class whose instance caches a result to ensure unique shared execution.
 */
public class InternalFunctionOperationCallingConvention extends AbstractCachedOperationCallingConvention // cg Cached/Constrained
{
	private static final @NonNull InternalFunctionOperationCallingConvention INSTANCE = new InternalFunctionOperationCallingConvention();

	public static @NonNull InternalFunctionOperationCallingConvention getInstance(@NonNull Operation asOperation, boolean maybeVirtual) {
		INSTANCE.logInstance(asOperation, maybeVirtual);
		return INSTANCE;
	}

	protected static class CachePropertyCallExpImpl extends CGTuplePartCallExpImpl		// XXX move to CG model
	{
		@Override
		public boolean isInlined() {
			return true;
		}
	}

	@Override
	public void createCGBody(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgOperation) {
		// cached class has no 'body' may be should migrate some createCGParameters functionality here;
		/*	CGFunction cgFunction = (CGFunction)cgOperation;
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		OCLExpression query = asFunction.getQueryExpression(); //getBodyExpression();
		assert asFunction.getImplementationClass() == null;
		assert query != null;
		super.createCGBody(analyzer, cgFunction); */
	}

	@Override
	public @NonNull CGOperation createCGOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull Operation asOperation) {
		return QVTiCGModelFactory.eINSTANCE.createCGFunction();
	}

	@Override
	public @NonNull CGValuedElement createCGOperationCallExp(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgOperation, @NonNull LibraryOperation libraryOperation,
			@Nullable CGValuedElement cgSource, @NonNull OperationCallExp asOperationCallExp) {
		assert cgSource != null;
		Operation asOperation = CGUtil.getAST(cgOperation);
		assert QVTimperativeUtil.basicGetShadowExp(asOperation) == null;
		CGOperationCallExp cgOperationCallExp = CGModelFactory.eINSTANCE.createCGLibraryOperationCallExp();
		initCallExp(analyzer, cgOperationCallExp, asOperationCallExp, cgOperation, asOperation.isIsRequired());
		//	cgOperationCallExp.getArguments().add(cgSource);
		initCallArguments(analyzer, cgOperationCallExp);
		return cgOperationCallExp;
	}

	@Override
	public @NonNull CGOperation createOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull Operation asOperation, @Nullable ExpressionInOCL asExpressionInOCL) {
		assert asOperation.getImplementationClass() == null;
		//	assert asOperation.getImplementation() == null;		-- maybe ConstrainedOperation
		CGOperation cgOperation = createCGOperation(analyzer, asOperation);
		analyzer.initAst(cgOperation, asOperation, true);
		CGClass cgRootClass = analyzer.getCGRootClass(asOperation);
		cgRootClass.getOperations().add(cgOperation);
		createCachingClassesAndInstance(analyzer, cgOperation);
		cgOperation.setCallingConvention(this);
		ExecutableNameManager operationNameManager = analyzer.getOperationNameManager(cgOperation, asOperation, null);	// Needed to support downstream useOperationNameManager()
		@NonNull CGParameterStyle @NonNull [] cgParameterStyles = getCGParameterStyles(operationNameManager);
		operationNameManager.createCGOperationParameters(cgParameterStyles);
		return cgOperation;
	}

	@Override
	public boolean generateJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull CGOperation cgOperation) {
		return true;		 // functionality realized by finer-grained CG elements
	}

	@Override
	protected @NonNull CGParameterStyle @NonNull [] getCGParameterStyles(@NonNull ExecutableNameManager operationNameManager) {
		Operation asOperation = (Operation)operationNameManager.getASScope();
		assert !asOperation.isIsStatic();
		assert asOperation.getBodyExpression() != null;
		return CG_PARAMETER_STYLES_PARAMETERS;
	}

	@Override
	public void installEvaluateOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass, org.eclipse.ocl.pivot.@NonNull Class asEntryClass, @NonNull Operation asOperation) {
		org.eclipse.ocl.pivot.Class asCacheClass = CGUtil.getAST(cgCacheClass);
		FunctionEvaluateOperationCallingConvention callingConvention = FunctionEvaluateOperationCallingConvention.getInstance(asCacheClass);
		callingConvention.createOperation(analyzer, cgCacheClass, asOperation, asEntryClass);
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
