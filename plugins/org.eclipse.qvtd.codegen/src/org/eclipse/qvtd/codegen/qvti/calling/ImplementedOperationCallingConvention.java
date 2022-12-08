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
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.calling.ConstructorOperationCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.EntryClassCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCachedOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.naming.ExecutableNameManager;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Operation;

/**
 *  ImplementedOperationCallingConvention defines the support for the call of an operation implemented by a Java class.
 */
public class ImplementedOperationCallingConvention extends ExternalOperationOperationCallingConvention
{
	public static final @NonNull ImplementedOperationCallingConvention INSTANCE = new ImplementedOperationCallingConvention();

	public static class ImplementedConstructorOperationCallingConvention extends ConstructorOperationCallingConvention
	{
		public static final @NonNull ImplementedConstructorOperationCallingConvention INSTANCE = new ImplementedConstructorOperationCallingConvention();

		@Override
		public void createCGBody(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgConstructor) {	// merge with super
			Operation asCacheOperation = CGUtil.getAST(cgConstructor);
			ExpressionInOCL asCacheExpressionInOCL = (ExpressionInOCL)asCacheOperation.getBodyExpression();
			assert (asCacheExpressionInOCL == null);





			//			asCacheOperation.setBodyExpression();
			super.createCGBody(analyzer, cgConstructor);
		}

		//	@Override
		//	public void rewriteWithBoxingAndGuards(@NonNull BoxingAnalyzer boxingAnalyzer, @NonNull CGOperationCallExp cgOperationCallExp) {
		// XXX Auto-generated method stub
		//	super.rewriteWithBoxingAndGuards(boxingAnalyzer, cgOperationCallExp);
		//	}
	}

	/**
	 *  ExternalEntryClassCallingConvention refines the standard EntryClassCallingConvention for the cache of a specific evaluation
	 *  to support a local class for an non-local facility.
	 */
	public static class ImplementedEntryClassCallingConvention extends ExternalEntryClassCallingConvention
	{
		public static final @NonNull ImplementedEntryClassCallingConvention INSTANCE = new ImplementedEntryClassCallingConvention();

		@Override
		protected @NonNull ConstructorOperationCallingConvention getConstructorOperationCallingConvention() {
			return ImplementedConstructorOperationCallingConvention.INSTANCE;
		}

		/*	@Override
		protected @NonNull Class getContextClass(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass) {
			org.eclipse.ocl.pivot.Class asCacheClass = CGUtil.getAST(cgCacheClass);
			Operation asOperation = analyzer.getCachedOperation(asCacheClass);
			return PivotUtil.getOwningClass(asOperation);
		}

		@Override
		protected @NonNull NameResolution getContextNameResolution(@NonNull GlobalNameManager globalNameManager) {
			return globalNameManager.getSelfNameResolution();
		}

		@Override
		protected org.eclipse.ocl.pivot.@NonNull Package getParentPackage(@NonNull CodeGenAnalyzer analyzer, @NonNull Operation asOperation) {
			org.eclipse.ocl.pivot.Class asClass = PivotUtil.getOwningClass(asOperation);
			CGClass cgClass = analyzer.getCGRootClass(asClass);
			org.eclipse.ocl.pivot.Class asRootClass = CGUtil.getAST(cgClass);
			return AbstractLanguageSupport.getCachePackage(asRootClass);
		} */
	}

	@Override
	public void createCGBody(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgOuterOperation) {
		// direct synthesis
	}

	@Override
	public @NonNull CGOperation createCGOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull Operation asOperation) {
		assert asOperation.getImplementationClass() != null;
		assert asOperation.getBodyExpression() == null;
		CGCachedOperation cgOperation = CGModelFactory.eINSTANCE.createCGCachedOperation();
		analyzer.initAst(cgOperation, asOperation, true);
		CGClass cgRootClass = analyzer.getCGRootClass(asOperation);
		cgRootClass.getOperations().add(cgOperation);
		ExecutableNameManager operationNameManager = analyzer.getOperationNameManager(cgOperation, asOperation);
		org.eclipse.ocl.pivot.Class asEntryClass = createEntryClass(operationNameManager);
		org.eclipse.ocl.pivot.Class asCacheClass = createCacheClass(operationNameManager, asEntryClass);
		createCacheInstance(operationNameManager, asCacheClass, asEntryClass);
		return cgOperation;
	}

	@Override
	public void createCGParameters(@NonNull ExecutableNameManager operationNameManager, @Nullable ExpressionInOCL bodyExpression) {
		assert bodyExpression == null;
		CGOperation cgOperation = (CGOperation)operationNameManager.getCGScope();
		List<CGParameter> cgParameters = cgOperation.getParameters();
		cgParameters.add(operationNameManager.getSelfParameter());
		//	for (@NonNull Variable asParameterVariable : ClassUtil.nullFree(bodyExpression.getOwnedParameters())) {
		//		CGParameter cgParameter = createCGParameter(operationNameManager, asParameterVariable);
		//		cgParameters.add(cgParameter);
		//	}
	}

	@Override
	protected @NonNull EntryClassCallingConvention getEntryClassCallingConvention() {
		return ImplementedEntryClassCallingConvention.INSTANCE;
	}

	@Override
	public void rewriteWithBoxingAndGuards(@NonNull BoxingAnalyzer boxingAnalyzer, @NonNull CGOperationCallExp cgOperationCallExp) {
		// XXX Auto-generated method stub
		//	super.rewriteWithBoxingAndGuards(boxingAnalyzer, cgOperationCallExp);
	}
}
