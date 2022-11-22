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
import org.eclipse.ocl.examples.codegen.calling.OperationCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.CacheClassCallingConvention.CachedFeatureAdapter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCachedOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.naming.ExecutableNameManager;
import org.eclipse.ocl.examples.codegen.naming.GlobalNameManager;
import org.eclipse.ocl.examples.codegen.naming.NameResolution;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Feature;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.library.LibraryOperation;
import org.eclipse.ocl.pivot.utilities.AbstractLanguageSupport;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvti.naming.QVTiExecutableNameManager;
import org.eclipse.qvtd.codegen.qvti.naming.QVTiGlobalNameManager;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;

/**
 *  ExternalFunctionOperationCallingConvention defines the support for the call of a Complete OCL operation implemented by a Java class.
 */
public class ExternalOperationOperationCallingConvention extends ExternalFunctionOperationCallingConvention
{
	public static final @NonNull ExternalOperationOperationCallingConvention INSTANCE = new ExternalOperationOperationCallingConvention();

	public static class ExternalConstructorEvaluateOperationCallingConvention extends ConstructorEvaluateOperationCallingConvention
	{
		public static final @NonNull OperationCallingConvention INSTANCE = new ExternalConstructorEvaluateOperationCallingConvention();

		@Override
		protected void generateJavaOperationBody(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperation cgOperation) {
			QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)cg2javaVisitor.getAnalyzer();
			QVTiGlobalNameManager globalNameManager = qvtiAnalyzer.getGlobalNameManager();
			Operation asOperation = CGUtil.getAST(cgOperation);
			org.eclipse.ocl.pivot.Class asConstructorClass = PivotUtil.getOwningClass(asOperation);
			org.eclipse.ocl.pivot.Class asCacheClass = qvtiAnalyzer.getCacheClass(asConstructorClass);
			CGClass cgCacheClass = qvtiAnalyzer.getCGClass(asCacheClass);
			js.append("return ((");
			js.appendClassReference(cgCacheClass);
			js.append(")getUniqueComputation(");
			//	js.append(QVTiCGUtil.getContainingCGTransformation(cgOperation).getName());
			//	js.append("transformation");		// XXX
			//	js.append(globalNameManager.getIdResolverName());
			boolean isFirst = true;
			for (@NonNull CGParameter cgParameter : CGUtil.getParameters(cgOperation)) {
				if (!isFirst) {
					js.append(", ");
				}
				js.appendValueName(cgParameter);
				isFirst = false;
			}
			js.append(")).");
			js.append(globalNameManager.getCachedResultNameResolution().getResolvedName());
			js.append(";\n");
		}
	}

	@Override
	public @NonNull CGOperation createCGOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull Operation asOperation) {
		assert asOperation.getImplementationClass() == null;
		CGCachedOperation cgOperation = CGModelFactory.eINSTANCE.createCGCachedOperation();
		CGClass cgRootClass = analyzer.getCGRootClass(asOperation);
		cgRootClass.getOperations().add(cgOperation);
		return cgOperation;
	}

	@Override
	public @NonNull CGValuedElement createCGOperationCallExp(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgOperation, @NonNull LibraryOperation libraryOperation,
			@Nullable CGValuedElement cgSource, @NonNull OperationCallExp asOperationCallExp) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		Operation asOperation = QVTiCGUtil.getAST(cgOperation);
		//	assert QVTimperativeUtil.basicGetShadowExp(asFunction) == null;
		CGOperationCallExp cgOperationCallExp = CGModelFactory.eINSTANCE.createCGCachedOperationCallExp();
		initCallExp(qvtiAnalyzer, cgOperationCallExp, asOperationCallExp, cgOperation, asOperation.isIsRequired());
		assert cgSource != null;
		cgOperationCallExp.getArguments().add(cgSource);
		initCallArguments(qvtiAnalyzer, cgOperationCallExp);
		return cgOperationCallExp;
	}

	@Override
	public void createCGParameters(@NonNull ExecutableNameManager operationNameManager, @Nullable ExpressionInOCL bodyExpression) {
		assert bodyExpression != null;
		QVTiExecutableNameManager qvtiOperationNameManager = (QVTiExecutableNameManager)operationNameManager;
		CGOperation cgOperation = (CGOperation)operationNameManager.getCGScope();
		List<CGParameter> cgParameters = cgOperation.getParameters();
		cgParameters.add(qvtiOperationNameManager.getThisTransformerParameter());
		//	Variable asContextVariable = bodyExpression.getOwnedContext();
		//	if (asContextVariable != null) {
		//		CGParameter cgParameter = qvtiAnalyzer.getSelfParameter(operationNameManager, asContextVariable);
		//		cgOperation.getParameters().add(cgParameter);
		//	}
		for (@NonNull Variable asParameterVariable : ClassUtil.nullFree(bodyExpression.getOwnedParameters())) {
			CGParameter cgParameter = createCGParameter(operationNameManager, asParameterVariable);
			cgParameters.add(cgParameter);
		}
		org.eclipse.ocl.pivot.Class asCacheClass = createCacheClass(qvtiOperationNameManager);
		org.eclipse.ocl.pivot.Class asConstructorClass = createConstructorClass(qvtiOperationNameManager, asCacheClass);
		/*Property asConstructorInstance =*/ createConstructorInstance(qvtiOperationNameManager, asConstructorClass, asCacheClass);
	}

	@Override
	protected void createCacheSelfProperty(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass) {
		//	super.createCacheSelfProperty(analyzer, cgCacheClass);
		CodeGenerator codeGenerator = analyzer.getCodeGenerator();
		org.eclipse.ocl.pivot.Class asCacheClass = CGUtil.getAST(cgCacheClass);
		Feature asFeature = CachedFeatureAdapter.getFeature(asCacheClass);
		org.eclipse.ocl.pivot.Class asClass = PivotUtil.getOwningClass(asFeature);
		GlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		NameResolution selfTransformerNameResolution = globalNameManager.getSelfNameResolution();
		createCacheProperty(analyzer, cgCacheClass, selfTransformerNameResolution, asClass);
	}

	@Override
	protected @Nullable Parameter createConstructorEvaluateOperationSelfParameter(@NonNull CodeGenAnalyzer analyzer, @NonNull Operation asOperation) {
		CodeGenerator codeGenerator = analyzer.getCodeGenerator();
		GlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		NameResolution selfNameResolution = globalNameManager.getSelfNameResolution();
		Parameter asEvaluateParameter = PivotUtil.createParameter(selfNameResolution.getResolvedName(), PivotUtil.getOwningClass(asOperation), true);
		return asEvaluateParameter;
	}

	@Override
	public boolean generateJavaCall(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperationCallExp cgOperationCallExp) {
		return generateJavaEvaluateCall(cg2javaVisitor, js, cgOperationCallExp);
	}

	@Override
	protected org.eclipse.ocl.pivot.@NonNull Package getCachePackage(@NonNull CodeGenAnalyzer analyzer, @NonNull Operation asOperation) {
		org.eclipse.ocl.pivot.Class asClass = PivotUtil.getOwningClass(asOperation);
		CGClass cgClass = analyzer.getCGRootClass(asClass);
		org.eclipse.ocl.pivot.Class asRootClass = CGUtil.getAST(cgClass);
		return AbstractLanguageSupport.getCachePackage(asRootClass);
	}

	@Override
	protected @NonNull OperationCallingConvention getConstructorEvaluateOperationCallingConvention() {
		return ExternalConstructorEvaluateOperationCallingConvention.INSTANCE;
	}
}
