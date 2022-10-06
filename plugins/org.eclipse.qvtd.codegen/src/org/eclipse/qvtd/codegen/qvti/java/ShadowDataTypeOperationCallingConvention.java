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
import org.eclipse.ocl.examples.codegen.calling.CacheClassCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.ImmutableCachePropertyCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.PropertyCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.naming.ExecutableNameManager;
import org.eclipse.ocl.examples.codegen.naming.NameResolution;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.AbstractProperty;
import org.eclipse.ocl.pivot.utilities.LanguageSupport;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.runtime.evaluation.AbstractComputation;

/**
 *  ShadowDataTypeOperationCallingConvention defines the support for the call of an operation returning an implemented DataType.
 */
public class ShadowDataTypeOperationCallingConvention extends ShadowFunctionOperationCallingConvention		// FIXME Promote to OCL
{
	public static final @NonNull ShadowDataTypeOperationCallingConvention INSTANCE = new ShadowDataTypeOperationCallingConvention();

	/**
	 * A CacheProperty instance supports evaluation of a property in a CGed cache. (It has no opposite).
	 */
	public static class CacheProperty extends AbstractProperty
	{
		private final @NonNull PropertyId propertyId;
		private final @Nullable OCLExpression initExpression;
		private final @Nullable Object defaultValue;

		private CacheProperty(@NonNull PropertyId propertyId, @Nullable OCLExpression initExpression, @Nullable Object defaultValue) {
			this.propertyId = propertyId;
			this.initExpression = initExpression;
			this.defaultValue = defaultValue;
		}

		/** @deprecated use Executor */
		@Deprecated
		@Override
		public @Nullable Object evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
			return evaluate(getExecutor(evaluator), returnTypeId, sourceValue);
		}

		/**
		 * @since 1.1
		 */
		@Override
		public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public void createCGParameters(@NonNull ExecutableNameManager operationNameManager, @Nullable ExpressionInOCL bodyExpression) {
		super.createCGParameters(operationNameManager, bodyExpression);
		//
		QVTiExecutableNameManager qvtiOperationNameManager = (QVTiExecutableNameManager)operationNameManager;
		QVTiAnalyzer qvtiAnalyzer = qvtiOperationNameManager.getAnalyzer();
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		CGFunction cgFunction = (CGFunction)operationNameManager.getCGScope();
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		//	assert QVTimperativeUtil.basicGetShadowExp(asFunction) == null;
		//
		LanguageSupport jLanguageSupport = codeGenerator.getLanguageSupport();
		assert jLanguageSupport != null;
		org.eclipse.ocl.pivot.Class asCacheClass = jLanguageSupport.getCacheClass(asFunction);
		org.eclipse.ocl.pivot.Class asSuperClass = jLanguageSupport.getNativeClass(AbstractComputation.class);
		asCacheClass.getSuperClasses().add(asSuperClass);
		//
		//
		CGClass cgCacheClass = qvtiAnalyzer.generateClassDeclaration(asCacheClass, CacheClassCallingConvention.INSTANCE);
		//		CGClass cgCacheClass = analyzer.createNestedCGClass(qvtiAnalyzer, asCacheClass, CacheClassCallingConvention.INSTANCE);
		createCacheProperties(qvtiAnalyzer, cgCacheClass, asFunction);
		//	createCacheOperations(qvtiAnalyzer, cgCacheClass, asFunction);
		CGClass cgSuperClass = qvtiAnalyzer.generateClassDeclaration(asSuperClass, getClassCallingConvention());
		cgCacheClass.getSuperTypes().add(cgSuperClass);
	}

	protected void createCacheProperties(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass, @NonNull Operation asOperation) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		org.eclipse.ocl.pivot.Class asCacheClass = CGUtil.getAST(cgCacheClass);
		List<@NonNull Property> asCacheProperties = PivotUtilInternal.getOwnedPropertiesList(asCacheClass);
		List<@NonNull CGProperty> cgCacheProperties = CGUtil.getPropertiesList(cgCacheClass);
		Property asCacheProperty = installCacheTransformerProperty(qvtiAnalyzer, asCacheProperties);
		//	installCGCacheProperty(qvtiAnalyzer, cgCacheProperties, asCacheProperty, ImmutableCachePropertyCallingConvention.INSTANCE);
		//	for (@NonNull Parameter asParameter : PivotUtil.getOwnedParameters(asOperation)) {
		//		asCacheProperty = installCacheParameterProperty(qvtiAnalyzer, asCacheProperties, asParameter);
		//		installCGCacheProperty(qvtiAnalyzer, cgCacheProperties, asCacheProperty, ImmutableCachePropertyCallingConvention.INSTANCE);
		//	}
		//	asCacheProperty = installCacheResultProperty(qvtiAnalyzer, asCacheProperties, asOperation);
		installCGCacheProperty(qvtiAnalyzer, cgCacheProperties, asCacheProperty, ImmutableCachePropertyCallingConvention.INSTANCE);
	}

	protected @NonNull CGProperty installCGCacheProperty(@NonNull CodeGenAnalyzer analyzer, @NonNull List<@NonNull CGProperty> cgCacheProperties,
			@NonNull Property asCacheProperty, @NonNull PropertyCallingConvention callingConvention) {
		//	CodeGenAnalyzer analyzer = as2cgVisitor.getAnalyzer();
		//
		asCacheProperty.setImplementation(new CacheProperty(asCacheProperty.getPropertyId(), null, null));
		//
		CGProperty cgCacheProperty = analyzer.generatePropertyDeclaration(asCacheProperty, callingConvention);
		cgCacheProperties.add(cgCacheProperty);
		return cgCacheProperty;
	}

	protected @NonNull Property installCacheTransformerProperty(@NonNull CodeGenAnalyzer analyzer, @NonNull List<@NonNull Property> asCacheProperties) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		NameResolution thisTransformerNameResolution = codeGenerator.getGlobalNameManager().getThisTransformerNameResolution();
		ImperativeTransformation asTransformation = codeGenerator.getTransformation();
		//
		Property asCacheProperty = PivotFactory.eINSTANCE.createProperty();
		asCacheProperty.setName(thisTransformerNameResolution.getResolvedName());
		asCacheProperty.setType(asTransformation);
		asCacheProperty.setIsRequired(true);
		asCacheProperties.add(asCacheProperty);
		return asCacheProperty;
	}
}
