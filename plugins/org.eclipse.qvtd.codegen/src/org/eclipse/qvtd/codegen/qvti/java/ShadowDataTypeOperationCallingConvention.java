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

import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.calling.AbstractCachedOperationCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.CacheClassCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.ConstructorClassCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.OperationCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.ImportNameManager;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.naming.ExecutableNameManager;
import org.eclipse.ocl.examples.codegen.naming.NameResolution;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.LanguageSupport;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.runtime.evaluation.AbstractComputation;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractComputationConstructor;

/**
 *  ShadowDataTypeOperationCallingConvention defines the support for the call of an operation returning an implemented DataType.
 */
public class ShadowDataTypeOperationCallingConvention extends ShadowFunctionOperationCallingConvention		// FIXME Promote to OCL
{
	public static final @NonNull ShadowDataTypeOperationCallingConvention INSTANCE = new ShadowDataTypeOperationCallingConvention();

	public static class DefaultCachedOperationCallingConvention extends AbstractCachedOperationCallingConvention
	{
		public static final @NonNull OperationCallingConvention INSTANCE = new DefaultCachedOperationCallingConvention();
	}

	public static class CacheConstructorConstructorOperationCallingConvention extends DefaultCachedOperationCallingConvention
	{
		public static final @NonNull OperationCallingConvention INSTANCE = new CacheConstructorConstructorOperationCallingConvention();

		@Override
		public boolean generateJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperation cgOperation) {
			js.append("public ");
			js.appendValueName(cgOperation);
			js.append("() {\n");
			js.pushIndentation(null);
			js.append("super(");
			js.append(QVTiCGUtil.getContainingCGTransformation(cgOperation).getName());
			js.append(".this.");
			js.append(cg2javaVisitor.getGlobalNameManager().getIdResolverName());
			js.append(");\n");
			js.popIndentation();
			js.append("}\n");
			return true;
		}
	}

	public static class CacheConstructorNewInstanceOperationCallingConvention extends DefaultCachedOperationCallingConvention
	{
		public static final @NonNull OperationCallingConvention INSTANCE = new CacheConstructorNewInstanceOperationCallingConvention();

		@Override
		protected void generateJavaOperationBody(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperation cgOperation) {
			js.append("return new ");
			js.appendClassReference(null, cgOperation);
			js.append("(");
			boolean isFirst = true;
			for (@NonNull CGParameter cgParameter : CGUtil.getParameters(cgOperation)) {
				if (!isFirst) {
					js.append(", ");
				}
				js.appendValueName(cgParameter);
				isFirst = false;
			}
			js.append(");\n");
		}
	}

	@Override
	public void createCGParameters(@NonNull ExecutableNameManager operationNameManager, @Nullable ExpressionInOCL bodyExpression) {
		super.createCGParameters(operationNameManager, bodyExpression);
		//
		QVTiExecutableNameManager qvtiOperationNameManager = (QVTiExecutableNameManager)operationNameManager;
		QVTiAnalyzer qvtiAnalyzer = qvtiOperationNameManager.getAnalyzer();
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		ImperativeTransformation asTransformation = codeGenerator.getTransformation();
		QVTiGlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		ImportNameManager importNameManager = codeGenerator.getImportNameManager();
		CGFunction cgFunction = (CGFunction)operationNameManager.getCGScope();
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		//	assert QVTimperativeUtil.basicGetShadowExp(asFunction) == null;
		//
		LanguageSupport jLanguageSupport = codeGenerator.getLanguageSupport();
		assert jLanguageSupport != null;
		//
		org.eclipse.ocl.pivot.Class asCacheClass = jLanguageSupport.getCacheClass(asFunction);
		org.eclipse.ocl.pivot.Class asCacheSuperClass = jLanguageSupport.getNativeClass(AbstractComputation.class);
		asCacheClass.getSuperClasses().add(asCacheSuperClass);
		importNameManager.reserveLocalName(PivotUtil.getName(asCacheClass));
		//
		org.eclipse.ocl.pivot.Class asConstructorClass = jLanguageSupport.getConstructorClass(asFunction);
		org.eclipse.ocl.pivot.Class asConstructorSuperClass = jLanguageSupport.getNativeClass(AbstractComputationConstructor.class);
		asConstructorClass.getSuperClasses().add(asConstructorSuperClass);
		importNameManager.reserveLocalName(PivotUtil.getName(asConstructorClass));
		//
		CGClass cgCacheClass = qvtiAnalyzer.generateClassDeclaration(asCacheClass, CacheClassCallingConvention.INSTANCE);
		//	createCacheProperties(qvtiAnalyzer, cgCacheClass, asFunction);
		NameResolution cachedResultNameResolution = globalNameManager.getCachedResultNameResolution();
		NameResolution thisTransformerNameResolution = globalNameManager.getThisTransformerNameResolution();
		installCacheProperty(qvtiAnalyzer, cgCacheClass, thisTransformerNameResolution, asTransformation);
		for (@NonNull Parameter asParameter : PivotUtil.getOwnedParameters(asFunction)) {
			installCacheProperty(qvtiAnalyzer, cgCacheClass, null, asParameter);
			// XXX need to support a cached invalid
		}
		installCacheProperty(qvtiAnalyzer, cgCacheClass, cachedResultNameResolution, asFunction);
		//	createCacheOperations(qvtiAnalyzer, cgCacheClass, asFunction);
		installCacheConstructor(qvtiAnalyzer, cgCacheClass, asFunction);
		installCacheGetResultOperation(qvtiAnalyzer, cgCacheClass, asFunction);
		installCacheIsEqualOperation(qvtiAnalyzer, cgCacheClass, asFunction);
		CGClass cgSuperClass = qvtiAnalyzer.generateClassDeclaration(asCacheSuperClass, getClassCallingConvention());
		cgCacheClass.getSuperTypes().add(cgSuperClass);
		//
		CGClass cgConstructorClass = qvtiAnalyzer.generateClassDeclaration(asConstructorClass, ConstructorClassCallingConvention.INSTANCE);
		installCacheConstructorConstructorOperation(qvtiAnalyzer, cgConstructorClass);
		installCacheConstructorNewInstanceOperation(qvtiAnalyzer, cgConstructorClass, asCacheClass);
		CGClass cgConstructorSuperClass = qvtiAnalyzer.generateClassDeclaration(asConstructorSuperClass, getClassCallingConvention());
		cgConstructorClass.getSuperTypes().add(cgConstructorSuperClass);
	}

	@Override
	public boolean generateJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperation cgOperation) {
		// TODO Auto-generated method stub
		return true; //super.generateJavaDeclaration(cg2javaVisitor, js, cgOperation);
	}

	protected @NonNull CGOperation installCacheConstructorConstructorOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgConstructorClass) {
		//
		// AS Class - yyy2zzz
		// AS Properties -
		// AS Operation - yyy2zzz
		// AS Operation.ownedParameters -
		// AS Cache Operation - yyy2zzz
		// AS Cache Operation.parameters -
		// AS Cache ExpressionInOCL.ownedContext -
		// AS Cache ExpressionInOCL.ownedParameters -
		// CG Cache Operation - yyy2zzz
		// CG Cache Operation.lets -
		//
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		EnvironmentFactory environmentFactory = codeGenerator.getEnvironmentFactory();
		QVTiGlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		org.eclipse.ocl.pivot.@NonNull Class asConstructorClass = CGUtil.getAST(cgConstructorClass);
		//
		//	Create AS declaration for newInstance
		//
		String constructorName = PivotUtil.getName(asConstructorClass);
		Type asReturnType = environmentFactory.getStandardLibrary().getOclVoidType();
		Operation asConstructorOperation = PivotUtil.createOperation(constructorName, asReturnType, null, null);
		asConstructorOperation.setIsRequired(true);
		Parameter asBoundValuesParameter = createBoundValuesParameter(codeGenerator);
		asConstructorOperation.getOwnedParameters().add(asBoundValuesParameter);
		asConstructorClass.getOwnedOperations().add(asConstructorOperation);
		//
		//	Create AS body for newInstance
		//
		//	not implemented
		//
		//	Create CG declaration for newInstance
		//
		OperationCallingConvention callingConvention = CacheConstructorConstructorOperationCallingConvention.INSTANCE;
		CGOperation cgConstructorOperation = callingConvention.createCGOperation(qvtiAnalyzer, asConstructorOperation);
		analyzer.initAst(cgConstructorOperation, asConstructorOperation, true);
		cgConstructorOperation.setCallingConvention(callingConvention);
		//	newInstanceNameResolution.addCGElement(cgConstructorOperation);
		QVTiExecutableNameManager operationNameManager = qvtiAnalyzer.getOperationNameManager(cgConstructorOperation, asConstructorOperation);
		List<@NonNull CGParameter> cgCacheParameters = CGUtil.getParametersList(cgConstructorOperation);
		CGParameter cgConstructorBoundValuesParameter = operationNameManager.getCGParameter(asBoundValuesParameter, (String)null);
		globalNameManager.getBoundValuesNameResolution().addCGElement(cgConstructorBoundValuesParameter);
		cgCacheParameters.add(cgConstructorBoundValuesParameter);
		//
		//	Create CG body for newInstance
		//
		//	Implemented as direct synthesis in CacheConstructorConstructorOperationCallingConvention.
		//	Needs an ability to specify a super() invocation and no return type.
		//
		cgConstructorClass.getOperations().add(cgConstructorOperation);
		return cgConstructorOperation;
	}

	protected @NonNull CGOperation installCacheConstructorNewInstanceOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgConstructorClass, org.eclipse.ocl.pivot.@NonNull Class asCacheClass) {
		//
		// AS Class - yyy2zzz
		// AS Properties -
		// AS Operation - yyy2zzz
		// AS Operation.ownedParameters -
		// AS Cache Operation - newInstance
		// AS Cache Operation.parameters - boundValues
		// AS Cache ExpressionInOCL.ownedContext - this
		// AS Cache ExpressionInOCL.ownedParameters -
		// CG Cache Operation - newInstance
		// CG Cache Operation.lets -
		//
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		QVTiGlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		org.eclipse.ocl.pivot.@NonNull Class asConstructorClass = CGUtil.getAST(cgConstructorClass);
		//
		//	Create AS declaration for newInstance
		//
		NameResolution newInstanceNameResolution = globalNameManager.getNewInstanceResolution();
		String newInstanceName = newInstanceNameResolution.getResolvedName();
		Operation asConstructorOperation = PivotUtil.createOperation(newInstanceName, asCacheClass, null, null);
		asConstructorOperation.setIsRequired(true);
		Parameter asBoundValuesParameter = createBoundValuesParameter(codeGenerator);
		asConstructorOperation.getOwnedParameters().add(asBoundValuesParameter);
		asConstructorClass.getOwnedOperations().add(asConstructorOperation);
		//
		//	Create AS body for newInstance
		//
		//	not implemented
		//
		//	Create CG declaration for newInstance
		//
		OperationCallingConvention callingConvention = CacheConstructorNewInstanceOperationCallingConvention.INSTANCE;
		CGOperation cgConstructorOperation = callingConvention.createCGOperation(qvtiAnalyzer, asConstructorOperation);
		analyzer.initAst(cgConstructorOperation, asConstructorOperation, true);
		cgConstructorOperation.setCallingConvention(callingConvention);
		newInstanceNameResolution.addCGElement(cgConstructorOperation);
		QVTiExecutableNameManager operationNameManager = qvtiAnalyzer.getOperationNameManager(cgConstructorOperation, asConstructorOperation);
		List<@NonNull CGParameter> cgCacheParameters = CGUtil.getParametersList(cgConstructorOperation);
		CGParameter cgConstructorBoundValuesParameter = operationNameManager.getCGParameter(asBoundValuesParameter, (String)null);
		globalNameManager.getBoundValuesNameResolution().addCGElement(cgConstructorBoundValuesParameter);
		cgCacheParameters.add(cgConstructorBoundValuesParameter);
		//
		//	Create CG body for newInstance
		//
		//	Implemented as direct synthesis in CacheConstructorNewInstanceOperationCallingConvention.
		//	Needs an ability to specify a new T invocation.
		//
		cgConstructorClass.getOperations().add(cgConstructorOperation);
		return cgConstructorOperation;
	}
}
