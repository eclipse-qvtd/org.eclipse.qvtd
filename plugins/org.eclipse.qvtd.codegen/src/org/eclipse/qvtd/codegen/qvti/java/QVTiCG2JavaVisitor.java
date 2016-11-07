/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.java;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.cgmodel.CGAccumulator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCachedOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElementId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNavigationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGShadowExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGShadowPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGUnboxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaConstants;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.java.types.BoxedDescriptor;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.library.LibraryProperty;
import org.eclipse.ocl.pivot.library.oclany.OclElementOclContainerProperty;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAS2CGVisitor;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreContainerAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractComputation;
import org.eclipse.qvtd.runtime.evaluation.AbstractInvocation;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Connection;
import org.eclipse.qvtd.runtime.evaluation.InvocationConstructor;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractComputationConstructor;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractInvocationConstructor;

import com.google.common.collect.Iterables;

/**
 * A QVTiCG2JavaVisitor supports generation of Java code from an optimized QVTi CG transformation tree.
 */
public class QVTiCG2JavaVisitor extends CG2JavaVisitor<@NonNull QVTiCodeGenerator> implements QVTiCGModelVisitor<@NonNull Boolean>
{
	/**
	 * The run-time API version.
	 *
	 * @noreference this is solely for development usage.
	 */
	public static int RUN_TIME_EVALUATOR_API_VERSION = Transformer.RUN_TIME_EVALUATOR_API_VERSION_1_1_0_2;

	protected final @NonNull QVTiAnalyzer analyzer;
	protected final @NonNull CGPackage cgPackage;
	protected final @Nullable Iterable<@NonNull CGValuedElement> sortedGlobals;
	protected boolean isIncremental = false;
	protected boolean alwaysUseClasses = false;
	protected boolean useGot = true;
	protected QVTiTransformationAnalysis transformationAnalysis;

	public QVTiCG2JavaVisitor(@NonNull QVTiCodeGenerator codeGenerator, @NonNull CGPackage cgPackage,
			@Nullable Iterable<@NonNull CGValuedElement> sortedGlobals) {
		super(codeGenerator);
		this.analyzer = codeGenerator.getAnalyzer();
		this.cgPackage = cgPackage;
		this.sortedGlobals = sortedGlobals;
		this.isIncremental = codeGenerator.getOptions().isIncremental();
		this.alwaysUseClasses = isIncremental;
		this.useGot = isIncremental;
	}

	protected void appendConnectionBinding(@NonNull CGMappingCallBinding cgMappingCallBinding) {
		TypeDescriptor checkedType = needsTypeCheck(cgMappingCallBinding);
		if (checkedType != null) {
			js.append("(");
			js.appendClassReference(checkedType);
			js.append(")");
		}
		js.appendValueName(cgMappingCallBinding.getOwnedValue());
	}

	protected void appendEcoreSet(@NonNull CGValuedElement cgSlot, @NonNull EStructuralFeature eStructuralFeature, @NonNull CGValuedElement cgInit) {
		if (eStructuralFeature.isMany()) {
			String getAccessor = genModelHelper.getGetAccessor(eStructuralFeature);
			//
			js.appendValueName(cgSlot);
			js.append(".");
			js.append(getAccessor);
			js.append("().addAll(");
			js.appendAtomicReferenceTo(cgInit);
			js.append(");\n");
		}
		else {
			String setAccessor = genModelHelper.getSetAccessor(eStructuralFeature);
			//
			js.appendValueName(cgSlot);
			js.append(".");
			js.append(setAccessor);
			js.append("(");
			js.appendAtomicReferenceTo(cgInit);
			js.append(");\n");
		}
	}

	protected void appendModelIndex(@Nullable CGTypedModel cgTypedModel) {
		if (cgTypedModel == null) {
			js.append("-1/*null*/");
		}
		else {
			js.append(cgTypedModel.getModelIndex() + "/*" + cgTypedModel.getName() + "*/");
		}
	}

	protected void doAddRealization(@NonNull CGRealizedVariable cgRealizedVariable) {
		CGTypedModel cgTypedModel = cgRealizedVariable.getTypedModel();
		//
		js.append(QVTiGlobalContext.MODELS_NAME);
		js.append("[");
		appendModelIndex(cgTypedModel);
		js.append("].add(");
		js.appendValueName(cgRealizedVariable);
		js.append(");\n");
		//
		if (isIncremental) {
			js.append("objectManager.created(");
			js.appendThis(getThisName(cgRealizedVariable));
			js.append(", ");
			js.appendValueName(cgRealizedVariable);
			js.append(");\n");
		}
	}

	protected @NonNull String @Nullable [] doAllInstances(@NonNull QVTiTransformationAnalysis transformationAnalysis) {
		Set<org.eclipse.ocl.pivot.@NonNull Class> allInstancesClasses = transformationAnalysis.getAllInstancesClasses();
		if (allInstancesClasses.size() > 0) {
			NameManager nameManager = getGlobalContext().getNameManager();
			Map<org.eclipse.ocl.pivot.@NonNull Class, @Nullable List<org.eclipse.ocl.pivot.@NonNull Class>> instancesClassAnalysis = transformationAnalysis.getInstancesClassAnalysis(allInstancesClasses);
			//
			// Populate a mapping from instancesClass to linear index.
			//
			Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull Integer> instancesClass2index = new HashMap<org.eclipse.ocl.pivot.@NonNull Class, @NonNull Integer>(instancesClassAnalysis.size());
			List<org.eclipse.ocl.pivot.@NonNull Class> sortedList = new ArrayList<org.eclipse.ocl.pivot.@NonNull Class>(instancesClassAnalysis.keySet());
			Collections.sort(sortedList, NameUtil.NameableComparator.INSTANCE);
			for (int i = 0; i < sortedList.size(); i++) {
				instancesClass2index.put(sortedList.get(i), i);
			}
			//
			//	Emit the ClassId array
			//
			js.append("/*\n");
			js.append(" * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex.\n");
			js.append(" */\n");
			String classIndex2classIdName = nameManager.getGlobalSymbolName(null, "classIndex2classId");
			js.append("private static final ");
			js.appendIsRequired(true);
			js.append(" ");
			js.appendClassReference(ClassId.class);
			js.append(" ");
			js.appendIsRequired(true);
			js.append(" [] ");
			js.append(classIndex2classIdName);
			js.append(" = new ");
			js.appendIsRequired(true);
			js.append(" ");
			js.appendClassReference(ClassId.class);
			js.append("[]{\n");
			js.pushIndentation(null);
			for (int i = 0; i < sortedList.size(); i++) {
				org.eclipse.ocl.pivot.Class instancesClass = sortedList.get(i);
				CGTypeId cgTypeId = getCodeGenerator().getAnalyzer().getTypeId(instancesClass.getTypeId());
				int startLength = js.length();
				js.appendValueName(cgTypeId);
				if ((i+1) < sortedList.size()) {
					js.append(",");
				}
				for (int j = js.length() - startLength; j < 40; j++) {
					js.append(" ");
				}
				js.append("// " + i + " => " + instancesClass.getName() + "\n");
			}
			js.popIndentation();
			js.append("};\n");
			//
			//	Emit the classIndex2allClassIndexes array of arrays
			//
			String classIndex2allClassIndexes = nameManager.getGlobalSymbolName(null, "classIndex2allClassIndexes");
			js.append("\n");
			js.append("/*\n");
			js.append(" * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index\n");
			js.append(" * may contribute results to an allInstances() invocation.\n");
			js.append(" * Non trivial inner arrays arise when one ClassId is a derivation of another and so an\n");
			js.append(" * instance of the derived classId contributes to derived and inherited ClassIndexes.\n");
			js.append(" */\n");
			js.append("private final static ");
			js.appendClassReference(int.class);
			js.append(" ");
			js.appendIsRequired(true);
			js.append(" [] ");
			js.appendIsRequired(true);
			js.append(" [] ");
			js.append(classIndex2allClassIndexes);
			js.append(" = new ");
			js.appendClassReference(int.class);
			js.append(" ");
			js.appendIsRequired(true);
			js.append(" [] ");
			js.appendIsRequired(true);
			js.append(" [] {\n");
			js.pushIndentation(null);
			for (int i = 0; i < sortedList.size(); i++) {
				org.eclipse.ocl.pivot.Class instancesClass = sortedList.get(i);
				List<org.eclipse.ocl.pivot.@NonNull Class> superInstancesClasses = ClassUtil.nonNullState(instancesClassAnalysis.get(instancesClass));
				int startLength = js.length();
				js.append("{");
				boolean isFirst = true;
				for (org.eclipse.ocl.pivot.@NonNull Class superInstancesClass : superInstancesClasses) {
					if (!isFirst) {
						js.append(",");
					}
					js.append("" + instancesClass2index.get(superInstancesClass));
					isFirst = false;
				}
				js.append("}");
				if ((i+1) < sortedList.size()) {
					js.append(",");
				}
				for (int j = js.length() - startLength; j < 32; j++) {
					js.append(" ");
				}
				js.append("// " + i + " : ");
				js.append(instancesClass.getName());
				js.append(" -> {");
				isFirst = true;
				for (org.eclipse.ocl.pivot.@NonNull Class superInstancesClass : superInstancesClasses) {
					if (!isFirst) {
						js.append(",");
					}
					js.append(superInstancesClass.getName());
					isFirst = false;
				}
				js.append("}\n");
			}
			js.popIndentation();
			js.append("};\n");
			return new @NonNull String[]{ classIndex2classIdName, classIndex2allClassIndexes};
		}
		return null;
	}

	protected void doAssigned(@NonNull CGEcoreContainerAssignment cgPropertyAssignment) {
		EStructuralFeature eStructuralFeature = ClassUtil.nonNullModel(cgPropertyAssignment.getEStructuralFeature());
		CGValuedElement cgSlot = getExpression(cgPropertyAssignment.getOwnedSlotValue());
		CGValuedElement cgInit = getExpression(cgPropertyAssignment.getOwnedInitValue());
		EPackage ePackage = ClassUtil.nonNullModel(eStructuralFeature.getEContainingClass().getEPackage());
		if (isIncremental || ((SetStatement)cgPropertyAssignment.getAst()).isIsNotify()) {
			js.append("objectManager.assigned(");
			if (isIncremental) {
				js.appendThis(getThisName(cgPropertyAssignment));
				js.append(", ");
			}
			js.appendValueName(cgInit);
			js.append(", ");
			js.appendClassReference(genModelHelper.getQualifiedPackageInterfaceName(ePackage));
			js.append(".Literals.");
			js.append(genModelHelper.getEcoreLiteralName(eStructuralFeature));
			js.append(", ");
			js.appendValueName(cgSlot);
			js.append(", null);\n");
		}
	}

	protected void doAssigned(@NonNull CGEcorePropertyAssignment cgPropertyAssignment) {
		EStructuralFeature eStructuralFeature = ClassUtil.nonNullModel(cgPropertyAssignment.getEStructuralFeature());
		CGValuedElement cgSlot = getExpression(cgPropertyAssignment.getOwnedSlotValue());
		CGValuedElement cgInit = getExpression(cgPropertyAssignment.getOwnedInitValue());
		EPackage ePackage = ClassUtil.nonNullModel(eStructuralFeature.getEContainingClass().getEPackage());
		if (isIncremental || ((SetStatement)cgPropertyAssignment.getAst()).isIsNotify()) {
			js.append("objectManager.assigned(");
			if (isIncremental) {
				js.appendThis(getThisName(cgPropertyAssignment));
				js.append(", ");
			}
			js.appendValueName(cgSlot);
			js.append(", ");
			js.appendClassReference(genModelHelper.getQualifiedPackageInterfaceName(ePackage));
			js.append(".Literals.");
			js.append(genModelHelper.getEcoreLiteralName(eStructuralFeature));
			js.append(", ");
			js.appendValueName(cgInit);
			js.append(", null);\n");
		}
	}

	protected void doConstructor(@NonNull CGTransformation cgTransformation, @Nullable String oppositeName, @NonNull String @Nullable [] allInstancesNames) {
		//		String evaluatorName = ((QVTiGlobalContext)globalContext).getEvaluatorParameter().getName();
		String evaluatorName = JavaConstants.EXECUTOR_NAME;
		String className = cgTransformation.getName();
		//
		js.append("public " + className + "(final ");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(TransformationExecutor.class);
		js.append(" " + evaluatorName + ") {\n");
		js.pushIndentation(null);
		js.append("super(" + evaluatorName + ", new ");
		js.appendIsRequired(true);
		js.append(" String[] {");
		boolean isFirst = true;
		for (@NonNull CGTypedModel cgTypedModel : ClassUtil.nullFree(cgTransformation.getOwnedTypedModels())) {
			if (!isFirst) {
				js.append(", ");
			}
			String name = cgTypedModel.getName();
			js.appendString(name != null ? name : "");
			isFirst = false;
		}
		js.append("}");
		if (oppositeName != null) {
			js.append(", ");
			js.append(oppositeName);
		}
		else {
			js.append(", null");
		}
		if (allInstancesNames != null) {
			js.append(", ");
			js.append(allInstancesNames[0]);
			js.append(", ");
			js.append(allInstancesNames[1]);
		}
		else {
			js.append(", null, null");
		}
		js.append(");\n");
		//		doMappingConstructorInitializers(cgTransformation);
		//		doFunctionConstructorInitializers(cgTransformation);
		js.popIndentation();
		js.append("}\n");
	}

	/*	protected void doCreateIncrementalManagers() {
		js.append("@Override\n");
		js.append("protected ");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(InvocationManager.class);
		js.append(" createInvocationManager() {\n");
		js.pushIndentation(null);
		js.append("return new ");
		js.appendClassReference(IncrementalInvocationManager.class);
		js.append("(");
		js.append(JavaConstants.EXECUTOR_NAME);
		js.append(");\n");
		js.popIndentation();
		js.append("}\n");
		js.append("\n");
		js.append("@Override\n");
		js.append("protected ");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(ObjectManager.class);
		js.append(" createObjectManager() {\n");
		js.pushIndentation(null);
		js.append("return new ");
		js.appendClassReference(IncrementalObjectManager.class);
		js.append("((");
		js.appendClassReference(IncrementalInvocationManager.class);
		js.append(")invocationManager);\n");
		js.popIndentation();
		js.append("}\n");
	} */

	protected boolean doEcoreCreateClass(@NonNull CGValuedElement cgElement, @NonNull EClass eClass) {
		String createMethodName = "create" + eClass.getName();
		boolean doSetNonNull = false;
		EPackage ePackage = eClass.getEPackage();
		String javaClass;
		if (ePackage != null) {
			Class<?> factoryClass = genModelHelper.getEcoreFactoryClass(ePackage);
			if (factoryClass != null) {
				javaClass = factoryClass.getName();
				Method factoryMethod = context.getLeastDerivedMethod(factoryClass, createMethodName);
				if (factoryMethod != null) {
					if (context.getIsNonNull(factoryMethod) == Boolean.TRUE) {
						doSetNonNull = true;
					}
				}
			}
			else {
				javaClass = genModelHelper.getQualifiedFactoryInterfaceName(ePackage);
			}
		}
		else {
			javaClass = null;
		}
		//
		js.appendDeclaration(cgElement);
		js.append(" = ");
		js.appendClassReference(javaClass);
		js.append(".eINSTANCE.");
		js.append(createMethodName);
		js.append("();\n");
		//		js.append("assert ");
		//		js.appendValueName(cgElement);
		//		js.append(" != null;\n");
		//
		return doSetNonNull;
	}

	protected boolean doEcoreCreateDataType(@NonNull CGValuedElement cgElement, @NonNull EDataType eDataType, @NonNull CGValuedElement cgInit) {
		//
		//	Availability of a GenPackage is mandatory since we must have an EFactory.createFromString method to do the construction.
		//
		final Class<?> javaClass = eDataType.getInstanceClass();
		if (javaClass == null) {
			throw new IllegalStateException("No Java class for " + cgElement + " in CG2JavaVisitor.visitCGEcoreDataTypeShadowExp()");
		}
		final EPackage ePackage = eDataType.getEPackage();
		String nsURI = ePackage.getNsURI();
		if (nsURI == null) {
			throw new IllegalStateException("No EPackage NsURI for " + cgElement + " in CG2JavaVisitor.visitCGEcoreDataTypeShadowExp()");
		}
		GenPackage genPackage = environmentFactory.getMetamodelManager().getGenPackage(nsURI);
		if (genPackage == null) {
			throw new IllegalStateException("No GenPackage for " + cgElement + " in CG2JavaVisitor.visitCGEcoreDataTypeShadowExp()");
		}
		final String eFactoryName = genPackage.getQualifiedFactoryInterfaceName();
		final String ePackageName = genPackage.getQualifiedPackageInterfaceName();
		final String dataTypeName = CodeGenUtil.upperName(eDataType.getName());
		ClassLoader classLoader = eDataType.getClass().getClassLoader();
		Class<?> factoryClass;
		Class<?> packageClass;
		try {
			factoryClass = classLoader.loadClass(eFactoryName);
			packageClass = eDataType.getClass().getClassLoader().loadClass(ePackageName);
		}
		catch (ClassNotFoundException e) {
			throw new IllegalStateException("Load class failure for " + cgElement + " in CG2JavaVisitor.visitCGEcoreDataTypeShadowExp()", e);
		}
		//



		String createMethodName = "createFromString";
		boolean doSetNonNull = false;
		//		String javaClass2;
		//		Class<?> factoryClass2 = genModelHelper.getEcoreFactoryClass(ePackage);
		if (factoryClass != null) {
			//			javaClass2 = factoryClass.getName();
			Method factoryMethod = context.getLeastDerivedMethod(factoryClass, createMethodName);
			if (factoryMethod != null) {
				if (context.getIsNonNull(factoryMethod) == Boolean.TRUE) {
					doSetNonNull = true;
				}
			}
		}
		//		else {
		//			javaClass2 = genModelHelper.getQualifiedFactoryInterfaceName(ePackage);
		//		}
		//
		js.appendDeclaration(cgElement);
		js.append(" = ");
		js.append("(");
		js.appendClassReference(javaClass);
		js.append(")");
		js.appendClassReference(factoryClass);
		js.append(".eINSTANCE.");
		js.append(createMethodName);
		js.append("(");
		js.appendClassReference(packageClass);
		js.append(".Literals." + dataTypeName + ", ");
		js.appendValueName(cgInit);
		js.append(");\n");
		js.append("assert ");
		js.appendValueName(cgElement);
		js.append(" != null;\n");
		//
		return doSetNonNull;
	}

	protected boolean doFunctionBody(@NonNull CGFunction cgFunction) {
		CGValuedElement body = getExpression(cgFunction.getBody());
		ElementId elementId = cgFunction.getTypeId().getElementId();
		js.append(" {\n");
		js.pushIndentation(null);
		//					js.appendCastParameters(localContext2, cgParameters);
		//					JavaDependencyVisitor dependencyVisitor = new JavaDependencyVisitor(localContext2, null);
		//					dependencyVisitor.visit(body);
		//					dependencyVisitor.visitAll(localContext2.getLocalVariables());
		//					Iterable<CGValuedElement> sortedDependencies = dependencyVisitor.getSortedDependencies();
		//					for (CGValuedElement cgElement : sortedDependencies) {
		//						if (!cgElement.isInlined() && cgElement.isConstant() && !cgElement.isGlobal()) {
		//							cgElement.accept(this);
		//						}
		//					}
		// FIXME merge locals into AST as LetExps.
		if (cgFunction.getBody() != null) {
			if (!js.appendLocalStatements(body)) {
				return false;
			}
			js.append("return ");
			js.appendValueName(body);
			js.append(";\n");
		}
		else {
			TypeId asTypeId = cgFunction.getASTypeId();
			if (asTypeId == TypeId.STRING) {			// FIXME Fudge for body-less functions
				js.append("return \"\";\n");
			}
			else if (asTypeId == TypeId.REAL) {			// FIXME Fudge for body-less functions
				js.append("return 0;\n");
			}
			else if (asTypeId == TypeId.INTEGER) {			// FIXME Fudge for body-less functions
				js.append("return 0;\n");
			}
			else if (asTypeId instanceof CollectionTypeId) {			// FIXME Fudge for body-less functions
				if (js.isUseNullAnnotations()) {
					js.append("@SuppressWarnings(\"null\")");
					js.appendIsRequired(true);
					js.append(" ");
				}
				if (elementId != null) {
					TypeDescriptor javaTypeDescriptor = context.getUnboxedDescriptor(elementId);
					js.appendClassReference(javaTypeDescriptor);
				}
				js.append(" emptyList = ");
				js.appendClassReference(Collections.class);
				js.append(".emptyList();\n");
				js.append("return emptyList;\n");
			}
			else {			// FIXME Fudge for body-less functions
				js.append("return \"\";\n");
			}
		}
		js.popIndentation();
		js.append("}\n");
		return true;
	}

	protected boolean doFunctionBody(@NonNull CGFunction cgFunction, @NonNull String instanceName) {
		String functionName = getFunctionName(cgFunction);
		CGValuedElement body = getExpression(cgFunction.getBody());
		ElementId elementId = cgFunction.getTypeId().getElementId();
		// FIXME merge locals into AST as LetExps.
		if (cgFunction.getBody() != null) {
			if (!js.appendLocalStatements(body)) {
				return false;
			}
			js.appendThis(functionName);
			js.append("." + instanceName + " = ");
			js.appendValueName(body);
			js.append(";\n");
		}
		else {
			TypeId asTypeId = cgFunction.getASTypeId();
			if (asTypeId == TypeId.STRING) {			// FIXME Fudge for body-less functions
				js.appendThis(functionName);
				js.append("." + instanceName + " = \"\";\n");
			}
			else if (asTypeId == TypeId.REAL) {			// FIXME Fudge for body-less functions
				js.appendThis(functionName);
				js.append("." + instanceName + " = 0;\n");
			}
			else if (asTypeId == TypeId.INTEGER) {			// FIXME Fudge for body-less functions
				js.appendThis(functionName);
				js.append("." + instanceName + " = 0;\n");
			}
			else if (asTypeId instanceof CollectionTypeId) {			// FIXME Fudge for body-less functions
				if (js.isUseNullAnnotations()) {
					js.append("@SuppressWarnings(\"null\")");
					js.appendIsRequired(true);
					js.append(" ");
				}
				if (elementId != null) {
					TypeDescriptor javaTypeDescriptor = context.getUnboxedDescriptor(elementId);
					js.appendClassReference(javaTypeDescriptor);
				}
				js.append(" emptyList = ");
				js.appendClassReference(Collections.class);
				js.append(".emptyList();\n");
				js.appendThis(functionName);
				js.append("." + instanceName + " = emptyList;\n");
			}
			else {			// FIXME Fudge for body-less functions
				js.appendThis(functionName);
				js.append("." + instanceName + " = \"\";\n");
			}
		}
		return true;
	}

	protected boolean doFunctionBody2(@NonNull CGFunction cgFunction, @NonNull CGShadowExp cgShadowExp, @NonNull String instanceName) {
		String functionName = getFunctionName(cgFunction);
		js.append(" {\n");
		js.pushIndentation(null);
		EClassifier eClassifier = ClassUtil.nonNullState(cgShadowExp.getEcoreClassifier());
		if (eClassifier instanceof EDataType) {
			CGShadowPart cgShadowPart = ClassUtil.nullFree(cgShadowExp.getParts()).get(0);
			CGValuedElement cgInit = ClassUtil.nonNullState(cgShadowPart.getInit());
			if (!js.appendLocalStatements(cgInit)) {
				return false;
			}
			doEcoreCreateDataType(cgShadowExp, (EDataType)eClassifier, cgInit);
		}
		else if (eClassifier instanceof EClass) {
			doEcoreCreateClass(cgShadowExp, (EClass)eClassifier);
			int index = 0;
			for (@NonNull CGShadowPart cgShadowPart : ClassUtil.nullFree(cgShadowExp.getParts())) {
				Property asProperty = ClassUtil.nonNullState(((ShadowPart)cgShadowPart.getAst()).getReferredProperty());
				EStructuralFeature eStructuralFeature = ClassUtil.nonNullState(getESObject(asProperty));
				js.appendValueName(cgShadowExp);
				js.append(".");
				if (eStructuralFeature.isMany()) {
					String getAccessor = genModelHelper.getGetAccessor(eStructuralFeature);
					//
					js.append(getAccessor);
					js.append("().addAll");
				}
				else {
					String setAccessor = genModelHelper.getSetAccessor(eStructuralFeature);
					//
					js.append(setAccessor);
				}
				js.append("(");
				js.appendClassCast(cgShadowPart);
				js.append("boundValues[" + index++ + "]);\n");
			}
		}
		//
		js.appendThis(functionName);
		js.append(".");
		js.append(instanceName);
		js.append(" = ");
		js.appendValueName(cgShadowExp);
		js.append(";\n");
		//
		EPackage ePackage = eClassifier.getEPackage();
		ImperativeTypedModel bestOutputTypedModel = null;
		ImperativeTypedModel bestMiddleTypedModel = null;
		ImperativeTypedModel bestInputTypedModel = null;
		for (@NonNull ImperativeTypedModel typedModel : QVTimperativeUtil.getOwnedTypedModels(transformationAnalysis.getTransformation())) {
			ImperativeTypedModel imperativeTypedModel = null;
			for (org.eclipse.ocl.pivot.Package usedPackage : typedModel.getUsedPackage()) {
				if (usedPackage.getESObject() == ePackage) {
					imperativeTypedModel = typedModel;
				}
			}
			if (imperativeTypedModel != null) {
				if (imperativeTypedModel.isIsEnforced()) {
					bestOutputTypedModel = imperativeTypedModel;
				}
				else if (!imperativeTypedModel.isIsChecked()) {
					bestMiddleTypedModel = imperativeTypedModel;
				}
				else {
					bestInputTypedModel = imperativeTypedModel;
				}
			}
		}
		ImperativeTypedModel asTypedModel = null;
		if (bestOutputTypedModel != null) {
			asTypedModel = bestOutputTypedModel;
		}
		else if (bestMiddleTypedModel != null) {
			asTypedModel = bestMiddleTypedModel;
		}
		else if (bestInputTypedModel != null) {
			asTypedModel = bestInputTypedModel;
		}
		if ((eClassifier instanceof EClass) && (asTypedModel != null)) {			// FIXME Why are shadow objects put in a model at all -- testQVTrCompiler_SeqToStm_CG requires it
			CGTypedModel cgTypedModel = context.getAnalyzer().getTypedModel(asTypedModel);
			js.append(QVTiGlobalContext.MODELS_NAME);
			js.append("[");
			appendModelIndex(cgTypedModel);
			js.append("].add(");
			js.appendValueName(cgShadowExp);
			js.append(");\n");
		}
		//
		js.popIndentation();
		js.append("}\n");
		return true;
	}

	protected void doFunctionConstructor(@NonNull CGFunction cgFunction, @NonNull String instanceName) {
		String functionName = getFunctionName(cgFunction);
		CGClass cgClass = ClassUtil.nonNullState(CGUtil.getContainingClass(cgFunction));
		List<@NonNull CGParameter> cgParameters = ClassUtil.nullFree(cgFunction.getParameters());
		CGValuedElement cgBody = cgFunction.getBody();
		if (cgBody != null) {
			js.appendCommentWithOCL(null, cgBody.getAst());
		}
		//		if (js.isUseNullAnnotations()) {
		//			js.append("@SuppressWarnings(\"null\")\n");		// Accurate casts are too hard
		//		}
		js.append("public ");
		js.append(functionName);
		js.append("(/*Nullable*/ Object ");
		js.appendIsRequired(true);
		js.append(" [] boundValues) {\n");
		js.pushIndentation(null);
		js.appendThis(functionName);
		js.append(".self = (");
		js.appendClassReference(cgClass);
		js.append(")boundValues[0];\n");
		int i = 1;
		for (@NonNull CGParameter cgParameter : cgParameters) {
			String valueName = getValueName(cgParameter);
			js.appendThis(functionName);
			js.append(".");
			js.append(valueName);
			js.append(" = ");
			js.appendClassCast(cgParameter);
			js.append("boundValues[" + i++ + "];\n");
		}
		doFunctionBody(cgFunction, instanceName);
		js.popIndentation();
		js.append("}\n");
	}

	protected void doFunctionConstructor(@NonNull CGFunction cgFunction, @NonNull CGShadowExp cgShadowExp, @NonNull String instanceName) {
		//		List<@NonNull CGParameter> cgParameters = ClassUtil.nullFree(cgFunction.getParameters());
		if (js.isUseNullAnnotations()) {
			js.append("@SuppressWarnings(\"null\")\n");		// Accurate casts are too hard
		}
		js.append("public ");
		js.append(getFunctionName(cgFunction));
		js.append("(/*Nullable*/ Object ");
		js.appendIsRequired(true);
		js.append(" [] boundValues) ");
		/*		int i = 0;
		for (@NonNull CGParameter cgParameter : cgParameters) {
			String valueName = getValueName(cgParameter);
			js.append(valueName);
			js.append(" = ");
//							js.appendClassCast(cgFreeVariable);
			if (cgParameter instanceof CGConnectionVariable) {
				js.append("(");
				js.appendClassReference(null, cgParameter);
				js.append(".Accumulator)");						// FIXME Embed properly as a nested typeid
			}
			else{
				js.appendClassCast(cgParameter);
			}
			js.append("boundValues[" + i++);
			js.append("];\n");
		} */
		doFunctionBody2(cgFunction, cgShadowExp, instanceName);
	}

	protected void doFunctionConstructorConstants(/*@NonNull*/ List<@NonNull CGOperation> cgOperations) {
		for (@NonNull CGOperation cgOperation : cgOperations) {
			if (cgOperation instanceof CGFunction) {
				CGFunction cgFunction = (CGFunction)cgOperation;
				if (useClass(cgFunction) || useCache(cgFunction)) {
					String functionName = getFunctionName(cgFunction);
					js.append("protected final ");
					js.appendIsRequired(true);
					js.append(" ");
					js.appendClassReference(AbstractComputationConstructor.class);
					js.append(" " + getFunctionCtorName(cgFunction) + " = new ");
					js.appendClassReference(AbstractComputationConstructor.class);
					js.append("(idResolver)\n");
					js.append("{\n");
					js.pushIndentation(null);
					js.append("@Override\n");
					js.append("public ");
					js.appendIsRequired(true);
					js.append(" " + functionName + " newInstance(");
					js.appendIsRequired(false);
					js.append(" ");
					js.appendClassReference(Object.class);
					js.append(" ");
					js.appendIsRequired(true);
					js.append(" [] values) {\n");
					js.pushIndentation(null);
					js.append("return new " + functionName + "(values);\n");
					js.popIndentation();
					js.append("}\n");
					js.popIndentation();
					js.append("};\n\n");
				}
			}
		}
	}

	/*	protected void doFunctionConstructorInitializers(@NonNull CGTransformation cgTransformation) {
		String className = cgTransformation.getName();
		for (@NonNull CGOperation cgOperation : ClassUtil.nullFree(cgTransformation.getOperations())) {
			if (cgOperation instanceof CGFunction) {
				CGFunction cgFunction = (CGFunction) cgOperation;
				if ((useClass(cgFunction) != null) || useCache(cgFunction)) {
					js.append(getFunctionCtorName(cgFunction) + " = ");
					js.appendClassReference(ClassUtil.class);
					js.append(".nonNullState(" + getFunctionName(cgFunction) + ".class.getConstructor(" + className + ".class, " + "Object[].class));\n");
				}
			}
		}
	} */

	protected void doFunctionGetInstance(@NonNull CGFunction cgFunction, @NonNull String instanceName) {
		js.append("@Override\n");
		js.append("public ");
		js.appendIsRequired(false);
		js.append(" Object");
		//		js.appendTypeDeclaration(ClassUtil.nonNullState(cgFunction.getBody()));
		js.append(" getResult() {\n");
		js.pushIndentation(null);
		js.append("return " + instanceName + ";\n");
		js.popIndentation();
		js.append("}\n");
	}

	protected void doFunctionIsEqual(@NonNull CGFunction cgFunction, @NonNull String instanceName) {
		String functionName = getFunctionName(cgFunction);
		js.append("@Override\n");
		js.append("public boolean isEqual(");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(IdResolver.class);
		js.append(" idResolver, ");
		js.appendIsRequired(false);
		js.append(" Object ");
		js.appendIsRequired(true);
		js.append(" [] thoseValues) {\n");
		js.pushIndentation(null);
		js.append("return ");
		js.appendThis(functionName);
		js.append(".self == thoseValues[0]");
		int index = 1;
		for (@NonNull CGParameter cgParameter : ClassUtil.nullFree(cgFunction.getParameters())) {
			js.append("\n\t&& ");
			js.append("idResolver.oclEquals(");	// FIXME oclEquals / ==
			js.appendThis(functionName);
			js.append(".");
			js.appendValueName(cgParameter);
			js.append(", thoseValues[" + index++ + "])");
		}
		js.append(";\n");
		js.popIndentation();
		js.append("}\n");
	}

	protected void doFunctionIsEqual(@NonNull CGShadowExp cgShadowExp, @NonNull String instanceName) {
		js.append("@Override\n");
		js.append("public boolean isEqual(");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(IdResolver.class);
		js.append(" idResolver, ");
		js.appendIsRequired(false);
		js.append(" Object ");
		js.appendIsRequired(true);
		js.append(" [] thoseValues) {\n");
		js.pushIndentation(null);
		js.append("return ");
		int index = 0;
		for (@NonNull CGShadowPart cgShadowPart : ClassUtil.nullFree(cgShadowExp.getParts())) {
			if (index > 0) {
				js.append("\n\t&& ");
			}
			js.append("idResolver.oclEquals(");	// FIXME oclEquals / ==
			js.append(instanceName);
			js.append(".");
			Property asProperty = ClassUtil.nonNullState(((ShadowPart)cgShadowPart.getAst()).getReferredProperty());
			EStructuralFeature eStructuralFeature = ClassUtil.nonNullState(getESObject(asProperty));
			String getAccessor;
			if (eStructuralFeature == OCLstdlibPackage.Literals.OCL_ELEMENT__OCL_CONTAINER) {
				getAccessor = "eContainer";
			}
			else {
				getAccessor = genModelHelper.getGetAccessor(eStructuralFeature);
			}
			js.append(getAccessor);
			js.append("(), thoseValues[" + index++ + "])");
		}
		js.append(";\n");
		js.popIndentation();
		js.append("}\n");
	}

	protected void doGetting(@NonNull CGNavigationCallExp cgPropertyCallExp, @NonNull EStructuralFeature eStructuralFeature, boolean isOpposite) {
		Element asPropertyCallExp = cgPropertyCallExp.getAst();
		CGMapping cgMapping = QVTiCGUtil.basicGetContainingCGMapping(cgPropertyCallExp);
		Mapping asMapping = cgMapping != null ? (Mapping) cgMapping.getAst() : null;
		CGValuedElement source = getExpression(cgPropertyCallExp.getSource());
		boolean isHazardous = false;
		if ((asMapping != null) && (asPropertyCallExp instanceof NavigationCallExp)) {
			isHazardous = isHazardous2((NavigationCallExp) asPropertyCallExp);
		}
		if (isHazardous) {
			EPackage ePackage = ClassUtil.nonNullModel(eStructuralFeature.getEContainingClass().getEPackage());
			//
			js.append("objectManager.getting(");
			js.appendValueName(source);
			js.append(", ");
			js.appendClassReference(genModelHelper.getQualifiedPackageInterfaceName(ePackage));
			js.append(".Literals.");
			js.append(genModelHelper.getEcoreLiteralName(eStructuralFeature));
			js.append(", ");
			js.appendBooleanString(isOpposite);
			js.append(");\n");
		}
	}

	protected void doGot(@NonNull CGNavigationCallExp cgPropertyCallExp, @NonNull CGValuedElement source, @NonNull EStructuralFeature eStructuralFeature) {
		if (useGot) {
			EPackage ePackage = ClassUtil.nonNullModel(eStructuralFeature.getEContainingClass().getEPackage());
			//
			js.append("objectManager.got(");
			//			if (localPrefix != null) {
			//				js.append(localPrefix);
			//				js.append(".");
			//			}
			js.appendThis(getThisName(cgPropertyCallExp));
			js.append(", ");
			js.appendValueName(source);
			js.append(", ");
			js.appendClassReference(genModelHelper.getQualifiedPackageInterfaceName(ePackage));
			js.append(".Literals.");
			js.append(genModelHelper.getEcoreLiteralName(eStructuralFeature));
			js.append(", ");
			js.appendValueName(cgPropertyCallExp);
			js.append(");\n");
		}
	}

	protected void doIsEqual(@NonNull List<@NonNull ? extends CGParameter> cgFreeVariables) {
		js.append("@Override\n");
		js.append("public boolean isEqual(");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(IdResolver.class);
		js.append(" idResolver, ");
		js.appendIsRequired(true);
		js.append(" Object ");
		js.appendIsRequired(true);
		js.append(" [] thoseValues) {\n");
		js.pushIndentation(null);
		js.append("return ");
		if (cgFreeVariables.size() > 0) {
			int index = 0;
			for (@NonNull CGParameter cgFreeVariable : cgFreeVariables) {
				if (index > 0) {
					js.append("\n\t&& ");
				}
				js.append("idResolver.oclEquals(");
				js.append(cgFreeVariable.getValueName());
				js.append(", thoseValues[" + index++ + "])");
			}
		}
		else {
			js.append("true");
		}
		js.append(";\n");
		js.popIndentation();
		js.append("}\n");
	}

	protected void doMappingBody(@NonNull CGMapping cgMapping, boolean hasMappingClass) {
		CGValuedElement cgBody = cgMapping.getOwnedBody();
		js.append(" {\n");
		js.pushIndentation(null);
		if (cgBody.isInvalid()) {
			js.append("return handleExecutionFailure(\"" + getMappingName(cgMapping) + "\", ");
			js.appendValueName(cgBody);
			js.append(");\n");
		}
		else {
			js.append("try {\n");
			js.pushIndentation(null);
			if (!cgBody.isInlined()) {
				cgBody.accept(this);
			}
			js.append("return ");
			js.appendValueName(cgBody);
			js.append(";\n");
			js.popIndentation();
			js.append("} catch (Throwable e) {\n");
			js.pushIndentation(null);
			js.append("return handleExecutionFailure(\"" + getMappingName(cgMapping) + "\", e);\n");
			js.popIndentation();
			js.append("}\n");
		}
		js.popIndentation();
		js.append("}\n");
	}

	public @NonNull Boolean doMappingCall_Class(@NonNull CGMappingCall cgMappingCall) {
		js.append("invocationManager.flush();\n");
		MappingCall pMappingCall = (MappingCall) cgMappingCall.getAst();
		Mapping pReferredMapping = pMappingCall.getReferredMapping();
		assert pReferredMapping != null;
		CGMapping cgReferredMapping = analyzer.getMapping(pReferredMapping);
		assert cgReferredMapping != null;
		Iterable<@NonNull CGMappingCallBinding> cgMappingCallBindings = QVTiCGUtil.getOwnedMappingCallBindings(cgMappingCall);
		//
		//	Set loopVariable non-null if it needs to be type-checked and cast to a narrower type.
		//
		for (@NonNull CGMappingCallBinding cgMappingCallBinding : cgMappingCallBindings) {
			TypeDescriptor checkedType = needsTypeCheck(cgMappingCallBinding);
			if (checkedType != null) {
				js.append("if (");
				js.appendValueName(cgMappingCallBinding.getOwnedValue());
				js.append(" instanceof ");
				js.appendClassReference(checkedType);
				js.append(") {\n");
				js.pushIndentation(null);
			}
			else if (!cgMappingCallBinding.isNonNull()) {
				Element asMappingParameterBinding = cgMappingCallBinding.getAst();
				if (!(asMappingParameterBinding instanceof GuardParameterBinding)) {		// FIXME this should be part of isNonNull
					js.append("if (");
					js.appendValueName(cgMappingCallBinding.getOwnedValue());
					js.append(" != null) {\n");
					js.pushIndentation(null);
				}
			}
		}
		//
		//	Emit the mapping call.
		//
		Iterable<@NonNull CGMappingCallBinding> iterateBindings = getIterateBindings(cgMappingCallBindings);
		String mappingCtorName = getMappingCtorName(cgReferredMapping);
		if (iterateBindings == null) {
			for (CGMappingCallBinding cgMappingCallBinding : cgMappingCallBindings) {
				Element ast = cgMappingCallBinding.getAst();
				js.append(mappingCtorName);
				js.append(".");
				js.append(ast instanceof AppendParameterBinding ? "addAppendedConnection" : "addConsumedConnection");
				js.append("(");
				appendConnectionBinding(cgMappingCallBinding);
				js.append(");\n");
			}
		}
		else {
			js.append(mappingCtorName);
			js.append(".invoke(");
			boolean isFirst = true;
			for (@NonNull CGMappingCallBinding cgMappingCallBinding : cgMappingCallBindings) {
				if (!isFirst) {
					js.append(", ");
				}
				TypeDescriptor checkedType = needsTypeCheck(cgMappingCallBinding);
				if (checkedType != null) {
					js.append("(");
					js.appendClassReference(checkedType);
					js.append(")");
				}
				js.appendValueName(cgMappingCallBinding.getOwnedValue());
				isFirst = false;
			}
			js.append(");\n");
		}
		//
		//	End the type check.
		//
		for (@NonNull CGMappingCallBinding cgMappingCallBinding : cgMappingCallBindings) {
			TypeDescriptor checkedType = needsTypeCheck(cgMappingCallBinding);
			if (checkedType != null) {
				js.popIndentation();
				js.append("}\n");
			}
			else if (!cgMappingCallBinding.isNonNull()) {
				Element asMappingParameterBinding = cgMappingCallBinding.getAst();
				if (!(asMappingParameterBinding instanceof GuardParameterBinding)) {		// FIXME this should be part of isNonNull
					js.popIndentation();
					js.append("}\n");
				}
			}
		}
		js.append("invocationManager.flush();\n");
		return true;
	}

	public @NonNull Boolean doMappingCall_Function(@NonNull CGMappingCall cgMappingCall) {
		MappingCall pMappingCall = (MappingCall) cgMappingCall.getAst();
		Mapping pReferredMapping = pMappingCall.getReferredMapping();
		assert pReferredMapping != null;
		CGMapping cgReferredMapping = analyzer.getMapping(pReferredMapping);
		assert cgReferredMapping != null;
		List<CGMappingCallBinding> cgMappingCallBindings = cgMappingCall.getOwnedMappingCallBindings();
		//
		//	Set loopVariable non-null if it needs to be type-checked and cast to a narrower type.
		//
		for (@SuppressWarnings("null")@NonNull CGMappingCallBinding cgMappingCallBinding : cgMappingCallBindings) {
			MappingParameterBinding asMappingParameterBinding = (MappingParameterBinding)cgMappingCallBinding.getAst();
			if (asMappingParameterBinding instanceof AppendParameterBinding) {
			}
			else if (asMappingParameterBinding instanceof GuardParameterBinding) {
				js.append("for (");
				js.appendClassReference(Boolean.TRUE, cgMappingCallBinding);
				js.append(" ");
				js.appendValueName(cgMappingCallBinding);
				js.append(" : ");
				js.appendValueName(cgMappingCallBinding.getOwnedValue());
				js.append(".typedIterable(");
				js.appendClassReference(null, cgMappingCallBinding);
				js.append(".class)");
				js.append(") {\n");
				js.pushIndentation(null);
				// FIXME typeCheck
			}
			else {
				TypeDescriptor checkedType = needsTypeCheck(cgMappingCallBinding);
				if (checkedType != null) {
					js.append("if (");
					js.appendValueName(cgMappingCallBinding.getOwnedValue());
					js.append(" instanceof ");
					js.appendClassReference(checkedType);
					js.append(") {\n");
					js.pushIndentation(null);
				}
				else if (!cgMappingCallBinding.isNonNull()) {
					js.append("if (");
					js.appendValueName(cgMappingCallBinding.getOwnedValue());
					js.append(" != null) {\n");
					js.pushIndentation(null);
				}
			}
		}
		//
		//	Emit the mapping call.
		//
		js.append(getMappingName(cgReferredMapping) + "(");
		boolean isFirst = true;
		for (@SuppressWarnings("null")@NonNull CGMappingCallBinding cgMappingCallBinding : cgMappingCallBindings) {
			if (!isFirst) {
				js.append(", ");
			}
			TypeDescriptor checkedType = needsTypeCheck(cgMappingCallBinding);
			if (checkedType != null) {
				js.append("(");
				js.appendClassReference(checkedType);
				js.append(")");
			}
			MappingParameterBinding asMappingParameterBinding = (MappingParameterBinding)cgMappingCallBinding.getAst();
			if (asMappingParameterBinding instanceof GuardParameterBinding) {
				js.appendValueName(cgMappingCallBinding);
			}
			else {
				js.appendValueName(cgMappingCallBinding.getOwnedValue());
			}
			isFirst = false;
		}
		js.append(");\n");
		//
		//	End the type check.
		//
		for (@SuppressWarnings("null")@NonNull CGMappingCallBinding cgMappingCallBinding : cgMappingCallBindings) {
			MappingParameterBinding asMappingParameterBinding = (MappingParameterBinding)cgMappingCallBinding.getAst();
			if (asMappingParameterBinding instanceof AppendParameterBinding) {
			}
			else if (asMappingParameterBinding instanceof GuardParameterBinding) {
				js.popIndentation();
				js.append("}\n");
			}
			else {TypeDescriptor checkedType = needsTypeCheck(cgMappingCallBinding);
			if (checkedType != null) {
				js.popIndentation();
				js.append("}\n");
			}
			else if (!cgMappingCallBinding.isNonNull()) {
				js.popIndentation();
				js.append("}\n");
			}
			}
		}
		return true;
	}

	protected void doMappingConnectionVariable(@NonNull CGGuardVariable cgFreeVariable) {
		if (cgFreeVariable instanceof CGConnectionVariable) {
			js.append("final ");
			js.appendClassReference(true, Connection.class);
			js.append(" ");
			js.append(getValueName(cgFreeVariable));
		}
		else{
			js.appendDeclaration(cgFreeVariable);
		}
	}

	protected void doMappingConstructor(@NonNull CGMapping cgMapping) {
		List<@NonNull CGGuardVariable> cgFreeVariables = ClassUtil.nullFree(cgMapping.getOwnedGuardVariables());
		//		if (js.isUseNullAnnotations()) {
		//			js.append("@SuppressWarnings(\"null\")\n");		// Accurate casts are too hard
		//		}
		js.append("public ");
		js.append(getMappingName(cgMapping));
		js.append("(");
		js.appendClassReference(true, isIncremental ? InvocationConstructor.Incremental.class : InvocationConstructor.class);
		js.append(" ");
		js.append(QVTiGlobalContext.CONSTRUCTOR_NAME);
		js.append(", ");
		js.appendIsRequired(true);
		js.append(" Object ");
		js.appendIsRequired(true);
		js.append(" [] boundValues) {\n");
		js.pushIndentation(null);
		//		if (isIncremental) {
		js.append("super(");
		js.append(QVTiGlobalContext.CONSTRUCTOR_NAME);
		js.append(");\n");
		//
		int i = 0;
		for (@NonNull CGGuardVariable cgFreeVariable : cgFreeVariables) {
			String valueName = getValueName(cgFreeVariable);
			js.append(valueName);
			js.append(" = ");
			//							js.appendClassCast(cgFreeVariable);
			if (cgFreeVariable instanceof CGConnectionVariable) {
				js.append("(");
				//				js.appendClassReference(null, cgFreeVariable);
				//				js.append(".Accumulator)");						// FIXME Embed properly as a nested typeid
				js.appendClassReference(null, Connection.class);
				js.append(")");						// FIXME Embed properly as a nested typeid
			}
			else{
				js.appendClassCast(cgFreeVariable);
			}
			js.append("boundValues[" + i++);
			js.append("];\n");
		}
		js.popIndentation();
		js.append("}\n");
	}

	protected void doMappingConstructorConstants(/*@NonNull*/ List<@NonNull CGMapping> cgMappings) {
		for (@NonNull CGMapping cgMapping : cgMappings) {
			if (useClass(cgMapping)) {// && (isIncremental || (cgMapping.getFreeVariables().size() > 0))) {
				Class<?> constructorClass = isIncremental ? AbstractInvocationConstructor.Incremental.class : AbstractInvocationConstructor.class;
				js.append("protected final ");
				js.appendClassReference(true, constructorClass);
				js.append(" " + getMappingCtorName(cgMapping) + " = new ");
				js.appendClassReference(constructorClass);
				js.append("(invocationManager, ");
				js.appendString(QVTiCGUtil.getName(cgMapping));
				js.append(", ");
				js.appendBooleanString(((Mapping)cgMapping.getAst()).isIsStrict());
				js.append(")\n");
				js.append("{\n");
				js.pushIndentation(null);
				js.append("@Override\n");
				js.append("public ");
				js.appendIsRequired(true);
				js.append(" " + getMappingName(cgMapping) + " newInstance(");
				js.appendIsRequired(true);
				js.append(" ");
				js.appendClassReference(Object.class);
				js.append(" ");
				js.appendIsRequired(true);
				js.append(" [] values) {\n");
				js.pushIndentation(null);
				js.append("return new " + getMappingName(cgMapping) + "(");
				//				if (isIncremental) {
				js.append("this, ");
				//				}
				js.append("values);\n");
				js.popIndentation();
				js.append("}\n");
				js.popIndentation();
				js.append("};\n\n");
			}
		}
	}

	/*	protected void doMappingConstructorInitializers(@NonNull CGTransformation cgTransformation) {
		String className = cgTransformation.getName();
		for (@NonNull CGMapping cgMapping : ClassUtil.nullFree(cgTransformation.getMappings())) {
			if (useClass(cgMapping) && (cgMapping.getFreeVariables().size() > 0)) {
				js.append(getMappingCtorName(cgMapping) + " = ");
				js.appendClassReference(ClassUtil.class);
				js.append(".nonNullState(" + getMappingName(cgMapping) + ".class.getConstructor(" + className + ".class, Object[].class));\n");
			}
		}
	} */

	protected void doOppositeCaches(@NonNull QVTiTransformationAnalysis transformationAnalysis) {
		Map<@NonNull Property, @NonNull Integer> opposites = transformationAnalysis.getCaches();
		if (opposites.size() <= 0) {
			return;
		}
		js.append("\n/*\n * Property-source to Property-target unnavigable navigation caches\n */\n");
		Map<@NonNull String, @NonNull Property> key2property = new HashMap<@NonNull String, @NonNull Property>();
		for (Map.Entry<@NonNull Property, @NonNull Integer> entry : opposites.entrySet()) {
			Property property = entry.getKey();
			String name = getGlobalContext().addOppositeProperty(property);

			key2property.put(name, property);
		}
		List<String> sortedKeys = new ArrayList<String>(key2property.keySet());
		Collections.sort(sortedKeys);
		for (String key : sortedKeys) {
			Property property = key2property.get(key);
			assert property != null;
			TypeDescriptor outerTypeDescriptor = context.getBoxedDescriptor(property.getOwningClass().getTypeId());
			TypeDescriptor middleTypeDescriptor = context.getBoxedDescriptor(property.getType().getTypeId());
			js.append("protected final ");
			js.appendIsRequired(true);
			js.append(" ");
			js.appendClassReference(null, Map.class, false, middleTypeDescriptor, outerTypeDescriptor);
			js.append(" ");
			js.append(key);
			js.append(" = new ");
			js.appendClassReference(null, HashMap.class, false, middleTypeDescriptor, outerTypeDescriptor);
			js.append("();\n");
		}
	}

	protected @Nullable String doOppositePropertyIds(@NonNull QVTiTransformationAnalysis transformationAnalysis) {
		// This code is no longer used, and since it is not used it generates undefined references
		// It appears to have 'worked' only because a duplicate incomplete TransformationAnalysis was in use.
		Map<@NonNull Property, @NonNull Integer> opposites = transformationAnalysis.getCaches();
		if (opposites.size() <= 0) {
			return null;
		}
		Property dummyProperty = opposites.keySet().iterator().next();
		NameManager nameManager = getGlobalContext().getNameManager();
		List<@NonNull Property> sortedList = new ArrayList<>();
		for (int i = 0; i < opposites.size();i++) {
			sortedList.add(dummyProperty);
		}
		for (Map.Entry<@NonNull Property, @NonNull Integer> entry : opposites.entrySet()) {
			sortedList.set(entry.getValue().intValue(), entry.getKey());
		}
		//
		//	Emit the ClassId array
		//
		js.append("/*\n");
		js.append(" * Array of the source PropertyIds of each Property for which unnavigable opposite property navigation may occur.\n");
		js.append(" */\n");
		String oppositeIndex2propertyIdName = nameManager.getGlobalSymbolName(null, "oppositeIndex2propertyId");
		js.append("private static final ");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(PropertyId.class);
		js.append(" ");
		js.appendIsRequired(true);
		js.append(" [] ");
		js.append(oppositeIndex2propertyIdName);
		js.append(" = new ");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(PropertyId.class);
		js.append("[]{\n");
		js.pushIndentation(null);
		for (int i = 0; i < sortedList.size(); i++) {
			Property property = sortedList.get(i);
			CGElementId cgPropertyId = analyzer.getElementId(property.getPropertyId());
			js.appendValueName(cgPropertyId);
			if ((i+1) < sortedList.size()) {
				js.append(",");
			}
			js.append("\t\t// " + i + " => " + property.getName() + "\n");
		}
		js.popIndentation();
		js.append("};\n");
		return oppositeIndex2propertyIdName;
	}

	protected void doRun(@NonNull CGTransformation cgTransformation) {
		CGMapping cgRootMapping = QVTiCGUtil.getRootMapping(cgTransformation);
		js.append("@Override\n");
		js.append("public boolean run() {\n");
		js.pushIndentation(null);
		if (isIncremental || useClass(cgRootMapping)) {
			js.append(getMappingCtorName(cgRootMapping) + ".invoke();\n");
			js.append("return invocationManager.flush();\n");
		}
		else {
			js.append("return ");
			js.append(getMappingName(cgRootMapping));
			js.append("()");
			js.append(" && invocationManager.flush();\n");
		}
		js.popIndentation();
		js.append("}\n");
	}

	protected @NonNull Class<? extends Transformer> getAbstractTransformationExecutorClass() {
		return isIncremental ? AbstractTransformer.Incremental.class : AbstractTransformer.class;
	}

	@Override
	public @NonNull Set<String> getAllImports() {
		Set<String> allImports = new HashSet<String>();
		for (String anImport : super.getAllImports()) {
			allImports.add(anImport);
			if (anImport.endsWith(".Model")) {
				allImports.add(org.eclipse.qvtd.runtime.evaluation.AbstractTransformer.class.getName() + ".Model");
			}
		}
		return allImports;
	}

	private EObject getContainer(EObject eObject) {
		EObject eContainer = eObject.eContainer();
		if (eContainer != null) {
			return eContainer;
		}
		for (Adapter eAdapter : eObject.eAdapters()) {
			if (eAdapter instanceof QVTiAS2CGVisitor.InlinedBodyAdapter) {
				return ((QVTiAS2CGVisitor.InlinedBodyAdapter)eAdapter).getOperationCallExp();
			}
		}
		return null;
	}

	@Override
	protected @Nullable EStructuralFeature getESObject(@NonNull Property asProperty) {
		EObject esObject = asProperty.getESObject();
		if (esObject instanceof EStructuralFeature) {
			return (EStructuralFeature)esObject;
		}
		Property oppositeProperty = asProperty.getOpposite();
		if (oppositeProperty == null) {
			return null;
		}
		if (!oppositeProperty.isIsComposite()) {
			PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
			LibraryProperty libraryProperty = metamodelManager.getImplementation(null, null, asProperty);
			if (!(libraryProperty instanceof OclElementOclContainerProperty)) {
				return null;
			}
		}
		return OCLstdlibPackage.Literals.OCL_ELEMENT__OCL_CONTAINER;
	}

	protected String getFunctionCtorName(@NonNull CGFunction cgFunction) {
		return JavaStream.convertToJavaIdentifier("FTOR_" + cgFunction.getName());
	}

	protected @NonNull String getFunctionName(@NonNull CGFunction cgFunction) {
		return JavaStream.convertToJavaIdentifier("FUN_" + cgFunction.getName());
	}

	protected @NonNull QVTiGlobalContext getGlobalContext() {
		return (QVTiGlobalContext) globalContext;
	}

	private @Nullable Iterable<@NonNull CGMappingCallBinding> getIterateBindings(@NonNull Iterable<@NonNull CGMappingCallBinding> cgMappingCallBindings) {
		List<@NonNull CGMappingCallBinding> bindings = null;
		for (@NonNull CGMappingCallBinding cgMappingCallBinding : cgMappingCallBindings) {
			Element ast = cgMappingCallBinding.getAst();
			if (ast instanceof LoopParameterBinding) {
				if (bindings == null) {
					bindings = new ArrayList<>();
				}
				bindings.add(cgMappingCallBinding);
			}
		}
		return bindings;
	}

	protected String getMappingCtorName(@NonNull CGMapping cgMapping) {
		return JavaStream.convertToJavaIdentifier("CTOR_" + cgMapping.getName());
	}

	protected @NonNull String getMappingName(@NonNull CGMapping cgMapping) {
		return JavaStream.convertToJavaIdentifier("MAP_" + cgMapping.getName());
	}

	@Override
	protected @NonNull String getThisName(@NonNull CGElement cgElement) {
		for (EObject eObject = cgElement; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof CGMapping) {
				return getMappingName((CGMapping)eObject);
			}
			if (eObject instanceof CGFunction) {
				return getFunctionName((CGFunction)eObject);
			}
			if (eObject instanceof CGClass) {
				return ClassUtil.nonNullState(((CGClass)eObject).getName());
			}
		}
		assert false;
		return "";
	}

	private boolean isConnection(CGValuedElement source) {
		return (source.getAst() instanceof VariableExp) && (((VariableExp)source.getAst()).getReferredVariable() instanceof  BufferStatement);
	}

	private boolean isHazardous2(@NonNull NavigationCallExp asNavigationCallExp) {
		for (EObject eObject = asNavigationCallExp; eObject != null; eObject = getContainer(eObject)) {
			if (eObject instanceof ObservableStatement) {
				List<Property> observedProperties = ((ObservableStatement)eObject).getObservedProperties();
				Property navigatedProperty = PivotUtil.getReferredProperty(asNavigationCallExp);
				return observedProperties.contains(navigatedProperty);
			}
		}
		return false;
	}

	protected @Nullable TypeDescriptor needsTypeCheck(@NonNull CGMappingCallBinding cgMappingCallBinding) {
		MappingParameterBinding mappingParameterBinding = (MappingParameterBinding)cgMappingCallBinding.getAst();
		VariableDeclaration boundVariable = mappingParameterBinding.getBoundVariable();
		assert boundVariable != null;
		if (boundVariable instanceof ConnectionVariable) {
			return null;
		}
		CGValuedElement value = cgMappingCallBinding.getOwnedValue();
		TypeDescriptor argumentTypeDescriptor = context.getTypeDescriptor(cgMappingCallBinding);
		TypeId pivotTypeId = value.getASTypeId();
		if (pivotTypeId instanceof CollectionTypeId) {
			pivotTypeId = ((CollectionTypeId)pivotTypeId).getElementTypeId();
		}
		TypeDescriptor iteratorTypeDescriptor = context.getBoxedDescriptor(ClassUtil.nonNullState(pivotTypeId));
		if (argumentTypeDescriptor.isAssignableFrom(iteratorTypeDescriptor)) {
			return null;
		}
		else {
			return argumentTypeDescriptor;
		}
	}

	protected boolean useCache(@NonNull CGFunction cgFunction) {
		Element ast = cgFunction.getAst();
		return !(ast instanceof Operation) || !((Operation)ast).isIsTransient();
	}

	protected @Nullable CGShadowExp useClassToCreateObject(@NonNull CGFunction cgFunction) {
		CGValuedElement cgBody = cgFunction.getBody();
		while (cgBody instanceof CGLetExp) {
			cgBody = ((CGLetExp)cgBody).getIn();
		}
		if (cgBody instanceof CGShadowExp) {			// QVTr Key
			if (!(((TypedElement)cgBody.getAst()).getType() instanceof DataType))
				return (CGShadowExp)cgBody;		// FIXME replace with clearer strategy
		}
		return null;
	}

	protected boolean useClass(@NonNull CGFunction cgFunction) {
		return true;
	}

	protected boolean useClass(@NonNull CGMapping cgMapping) {
		if (alwaysUseClasses) {
			return true;
		}
		if (isIncremental) {
			return true;
		}
		if (cgMapping.isUseClass()) {
			return true;
		}
		return false;
	}

	@Override
	public @NonNull Boolean visitCGConnectionAssignment(@NonNull CGConnectionAssignment cgConnectionAssignment) {
		CGValuedElement initValue = cgConnectionAssignment.getOwnedInitValue();
		assert initValue != null;
		if (!js.appendLocalStatements(initValue)) {
			return false;
		}
		final String iteratorName = getSymbolName(null, "iterator");
		TypeId concreteElementTypeId = cgConnectionAssignment.getConnectionVariable().getASTypeId();
		assert concreteElementTypeId != null;
		BoxedDescriptor concreteBoxedDescriptor = context.getBoxedDescriptor(concreteElementTypeId);
		BoxedDescriptor abstractBoxedDescriptor = concreteBoxedDescriptor;
		if (!(initValue.getASTypeId() instanceof CollectionTypeId)) {
			js.appendReferenceTo(cgConnectionAssignment.getConnectionVariable());
			js.append(".append(");
			js.appendValueName(initValue);
			js.append(");\n");
		}
		else {
			js.append("for (");
			js.appendClassReference(Boolean.TRUE, abstractBoxedDescriptor);
			js.append(" ");
			js.append(iteratorName);
			js.append(" : ");
			if (initValue.isBoxed()) {
				js.appendClassReference(ValueUtil.class);
				js.append(".typedIterable(");
				js.appendClassReference(abstractBoxedDescriptor);
				js.append(".class, ");
				js.appendValueName(initValue);
				js.append(")");
			}
			else {
				js.appendValueName(initValue);
			}
			js.append(") {\n");
			js.pushIndentation(null);
			if (concreteBoxedDescriptor != abstractBoxedDescriptor) {
				js.append("if (");
				js.append(iteratorName);
				js.append(" instanceof ");
				js.appendClassReference(concreteBoxedDescriptor);
				js.append(") {\n");
				js.pushIndentation(null);
			}
			js.appendReferenceTo(cgConnectionAssignment.getConnectionVariable());
			js.append(".add(");
			js.append(iteratorName);
			js.append(");\n");
			if (concreteBoxedDescriptor != abstractBoxedDescriptor) {
				js.popIndentation();
				js.append("}\n");
			}
			js.popIndentation();
			js.append("}\n");
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGConnectionVariable(@NonNull CGConnectionVariable object) {
		return visitCGGuardVariable(object);
	}

	@Override
	public @NonNull Boolean visitCGEcoreContainerAssignment(@NonNull CGEcoreContainerAssignment cgPropertyAssignment) {
		//		Property referredProperty = cgPropertyAssignment.getReferredProperty();
		//		Property pivotProperty = cgPropertyCallExp.getReferredProperty();
		//		CGTypeId cgTypeId = analyzer.getTypeId(pivotProperty.getOwningType().getTypeId());
		//		JavaTypeDescriptor requiredTypeDescriptor = context.getJavaTypeDescriptor(cgTypeId, false);
		EStructuralFeature eStructuralFeature = ClassUtil.nonNullModel(cgPropertyAssignment.getEStructuralFeature());
		CGValuedElement cgSlot = getExpression(cgPropertyAssignment.getOwnedSlotValue());
		CGValuedElement cgInit = getExpression(cgPropertyAssignment.getOwnedInitValue());
		//		Class<?> requiredJavaClass = requiredTypeDescriptor.getJavaClass();
		//		Method leastDerivedMethod = requiredJavaClass != null ? getLeastDerivedMethod(requiredJavaClass, getAccessor) : null;
		//		Class<?> unboxedSourceClass = leastDerivedMethod != null ? leastDerivedMethod.getDeclaringClass() : requiredJavaClass;
		//
		if (!js.appendLocalStatements(cgSlot)) {
			return false;
		}
		if (!js.appendLocalStatements(cgInit)) {
			return false;
		}
		if (eStructuralFeature.isMany()) {
			String getAccessor = genModelHelper.getGetAccessor(eStructuralFeature);
			//
			js.appendValueName(cgInit);
			js.append(".");
			js.append(getAccessor);
			js.append("().add(");
			js.appendValueName(cgSlot);
			js.append(");\n");
		}
		else {
			String setAccessor = genModelHelper.getSetAccessor(eStructuralFeature);
			//
			js.appendValueName(cgInit);
			js.append(".");
			js.append(setAccessor);
			js.append("(");
			js.appendValueName(cgSlot);
			js.append(");\n");
		}
		doAssigned(cgPropertyAssignment);
		return true;
	}

	@Override
	public @NonNull Boolean visitCGEcorePropertyAssignment(@NonNull CGEcorePropertyAssignment cgPropertyAssignment) {
		//		Property referredProperty = cgPropertyAssignment.getReferredProperty();
		//		Property pivotProperty = cgPropertyCallExp.getReferredProperty();
		//		CGTypeId cgTypeId = analyzer.getTypeId(pivotProperty.getOwningType().getTypeId());
		//		JavaTypeDescriptor requiredTypeDescriptor = context.getJavaTypeDescriptor(cgTypeId, false);
		EStructuralFeature eStructuralFeature = ClassUtil.nonNullModel(cgPropertyAssignment.getEStructuralFeature());
		CGValuedElement cgSlot = getExpression(cgPropertyAssignment.getOwnedSlotValue());
		CGValuedElement cgInit = getExpression(cgPropertyAssignment.getOwnedInitValue());
		//		Class<?> requiredJavaClass = requiredTypeDescriptor.getJavaClass();
		//		Method leastDerivedMethod = requiredJavaClass != null ? getLeastDerivedMethod(requiredJavaClass, getAccessor) : null;
		//		Class<?> unboxedSourceClass = leastDerivedMethod != null ? leastDerivedMethod.getDeclaringClass() : requiredJavaClass;
		//
		if (!js.appendLocalStatements(cgSlot)) {
			return false;
		}
		if (!js.appendLocalStatements(cgInit)) {
			return false;
		}
		appendEcoreSet(cgSlot, eStructuralFeature, cgInit);
		doAssigned(cgPropertyAssignment);
		return true;
	}

	@Override
	public @NonNull Boolean visitCGEcorePropertyCallExp(@NonNull CGEcorePropertyCallExp cgPropertyCallExp) {
		CGValuedElement source = getExpression(cgPropertyCallExp.getSource());
		//
		if (!js.appendLocalStatements(source)) {
			return false;
		}
		EStructuralFeature eStructuralFeature = ClassUtil.nonNullState(cgPropertyCallExp.getEStructuralFeature());
		doGetting(cgPropertyCallExp, eStructuralFeature, false);
		Boolean status = appendCGEcorePropertyCallExp(cgPropertyCallExp, source);
		if (status != ValueUtil.TRUE_VALUE) {
			return status;
		}
		doGot(cgPropertyCallExp, source, eStructuralFeature);
		return status;
	}

	@Override
	public @NonNull Boolean visitCGEcoreRealizedVariable(@NonNull CGEcoreRealizedVariable cgRealizedVariable) {
		EClassifier eClassifier = ClassUtil.nonNullState(cgRealizedVariable.getEClassifier());
		if (doEcoreCreateClass(cgRealizedVariable, (EClass)eClassifier)) {
			cgRealizedVariable.setNonNull();
		}
		//
		js.append("assert ");
		js.appendValueName(cgRealizedVariable);
		js.append(" != null;\n");
		//
		doAddRealization(cgRealizedVariable);
		return true;
	}

	@Override
	public @NonNull Boolean visitCGFunction(@NonNull CGFunction cgFunction) {
		JavaLocalContext<@NonNull ?> localContext2 = globalContext.getLocalContext(cgFunction);
		if (localContext2 != null) {
			localContext = localContext2;
			//			localContext.
			try {
				List<CGParameter> cgParameters = cgFunction.getParameters();
				//
				js.appendCommentWithOCL(null, cgFunction.getAst());
				CGShadowExp cgShadowExp = useClassToCreateObject(cgFunction);
				String functionName = getFunctionName(cgFunction);
				if (cgShadowExp != null) {
					JavaLocalContext<@NonNull ?> functionContext = ClassUtil.nonNullState(globalContext.getLocalContext(cgFunction));
					String instanceName = functionContext.getNameManagerContext().getSymbolName(cgFunction.getBody(), "instance");
					//					Type
					js.append("protected class ");
					js.append(functionName);
					js.append(" extends ");
					js.appendClassReference(isIncremental ? AbstractComputation.Incremental.class : AbstractComputation.class);
					js.pushClassBody(functionName);
					js.append("protected final ");
					js.appendTypeDeclaration(cgFunction);
					js.append(" " + instanceName + ";\n");
					js.append("\n");
					doFunctionConstructor(cgFunction, cgShadowExp, instanceName);
					js.append("\n");
					doFunctionGetInstance(cgFunction, instanceName);
					js.append("\n");
					doFunctionIsEqual(cgShadowExp, instanceName);
					js.popClassBody(false);
				}
				else if (useCache(cgFunction)) {
					JavaLocalContext<@NonNull ?> functionContext = ClassUtil.nonNullState(globalContext.getLocalContext(cgFunction));
					String instanceName = functionContext.getNameManagerContext().getSymbolName(cgFunction.getBody(), "instance");
					CGClass cgClass = ClassUtil.nonNullState(CGUtil.getContainingClass(cgFunction));
					js.append("protected class ");
					js.append(functionName);
					js.append(" extends ");
					js.appendClassReference(isIncremental ? AbstractComputation.Incremental.class : AbstractComputation.class);
					js.pushClassBody(functionName);
					js.append("protected final ");
					js.appendIsRequired(true);
					js.append(" ");
					js.appendClassReference(cgClass);
					js.append(" self;\n");
					for (@NonNull CGParameter cgParameter : ClassUtil.nullFree(cgFunction.getParameters())) {
						js.append("protected ");
						//						js.appendDeclaration(cgParameter);
						//						js.appendTypeDeclaration(cgParameter);
						boolean isPrimitive = js.isPrimitive(cgParameter);
						boolean isRequired = !isPrimitive && !cgParameter.isAssertedNonNull() && cgParameter.isNonNull() && !(cgParameter instanceof CGUnboxExp)/*|| cgElement.isRequired()*/;	// FIXME Ugh!
						js.appendIsCaught(cgParameter.isNonInvalid(), cgParameter.isCaught());
						js.append(" ");
						js.appendClassReference(isPrimitive ? null : isRequired ? true : null, cgParameter);
						js.append(" ");
						js.appendValueName(cgParameter);
						js.append(";\n");
					}
					//		CGValuedElement body = getExpression(cgFunction.getBody());
					//ElementId elementId = cgFunction.getTypeId().getElementId();

					js.append("protected final ");
					CGValuedElement cgBody = cgFunction.getBody();
					js.appendTypeDeclaration(cgBody != null ? cgBody : cgFunction);
					js.append(" " + instanceName + ";\n");
					js.append("\n");
					doFunctionConstructor(cgFunction, instanceName);
					js.append("\n");
					doFunctionGetInstance(cgFunction, instanceName);
					js.append("\n");
					doFunctionIsEqual(cgFunction, instanceName);
					js.popClassBody(false);
				}
				else {
					//
					js.append("protected ");
					js.appendIsRequired(cgFunction.isRequired());
					//		js.append(" ");
					//		js.appendIsCaught(!cgOperation.isInvalid(), cgOperation.isInvalid());
					js.append(" ");
					ElementId elementId = cgFunction.getTypeId().getElementId();
					if (elementId != null) {
						TypeDescriptor javaTypeDescriptor = context.getUnboxedDescriptor(elementId);
						js.appendClassReference(javaTypeDescriptor);
					}
					js.append(" ");
					js.append(cgFunction.getName());
					js.append("(");
					boolean isFirst = true;
					for (@SuppressWarnings("null")@NonNull CGParameter cgParameter : cgParameters) {
						if (!isFirst) {
							js.append(", ");
						}
						js.appendDeclaration(cgParameter);
						isFirst = false;
					}
					js.append(")");
					return doFunctionBody(cgFunction);
				}
			}
			finally {
				localContext = null;
			}
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGFunctionCallExp(@NonNull CGFunctionCallExp cgFunctionCallExp) {
		Operation pOperation = cgFunctionCallExp.getReferredOperation();
		CGFunction cgFunction = ClassUtil.nonNullState(cgFunctionCallExp.getFunction());
		boolean useClass = useClass(cgFunction);
		boolean useClassToCreateObject = useClassToCreateObject(cgFunction) != null;
		boolean useCache = useCache(cgFunction);
		boolean isIdentifiedInstance = useClass || useCache;
		List<CGValuedElement> cgArguments = cgFunctionCallExp.getArguments();
		List<Parameter> pParameters = pOperation.getOwnedParameters();
		//
		for (@SuppressWarnings("null")@NonNull CGValuedElement cgArgument : cgArguments) {
			CGValuedElement argument = getExpression(cgArgument);
			if (!js.appendLocalStatements(argument)) {
				return false;
			}
		}
		//
		js.appendDeclaration(cgFunctionCallExp);
		js.append(" = ");
		boolean needComma = false;
		if (isIdentifiedInstance) {
			js.append("((");
			js.append(getFunctionName(cgFunction));
			js.append(")");
			js.append(getFunctionCtorName(cgFunction));
			js.append(".getUniqueComputation(");
			if (useCache && !useClassToCreateObject) {
				CGClass cgClass = ClassUtil.nonNullState(cgFunction.getContainingClass());
				//				js.appendClassReference(cgClass);
				//				js.append(".this");
				js.appendThis(getThisName(cgClass));
				needComma = true;
			}
		}
		else {
			js.append(pOperation.getName());
			js.append("(");
		}
		int iMax = Math.min(pParameters.size(), cgArguments.size());
		for (int i = 0; i < iMax; i++) {
			if (needComma) {
				js.append(", ");
			}
			CGValuedElement cgArgument = cgArguments.get(i);
			CGValuedElement argument = getExpression(cgArgument);
			Parameter pParameter = pParameters.get(i);
			//			CGTypeId cgParameterTypeId = analyzer.getTypeId(pParameter.getTypeId());
			TypeDescriptor parameterTypeDescriptor = context.getUnboxedDescriptor(pParameter.getTypeId());
			js.appendReferenceTo(parameterTypeDescriptor, argument);
			needComma = true;
		}
		js.append(")");
		if (isIdentifiedInstance) {
			js.append(")");
			JavaLocalContext<@NonNull ?> functionContext = ClassUtil.nonNullState(globalContext.getLocalContext(cgFunction));
			String instanceName = functionContext.getNameManagerContext().getSymbolName(cgFunction.getBody(), "instance");
			//			js.append(".getInstance()");
			js.append(".");
			js.append(instanceName);
		}
		js.append(";\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGFunctionParameter(@NonNull CGFunctionParameter object) {
		return visitCGParameter(object);
	}

	@Override
	public @NonNull Boolean visitCGGuardVariable(@NonNull CGGuardVariable object) {
		return visitCGParameter(object);
	}

	@Override
	public @NonNull Boolean visitCGMapping(@NonNull CGMapping cgMapping) {
		JavaLocalContext<@NonNull ?> localContext2 = globalContext.getLocalContext(cgMapping);
		if (localContext2 != null) {
			localContext = localContext2;
			try {
				List<@NonNull CGGuardVariable> cgFreeVariables = ClassUtil.nullFree(cgMapping.getOwnedGuardVariables());
				//
				js.appendCommentWithOCL(null, cgMapping.getAst());
				String mappingName = getMappingName(cgMapping);
				if (useClass(cgMapping) /*&& (cgFreeVariables.size() > 0)*/) {
					js.append("protected class ");
					js.append(mappingName);
					js.append(" extends ");
					js.appendClassReference(isIncremental ? AbstractInvocation.Incremental.class : AbstractInvocation.class);
					js.pushClassBody(mappingName);
					boolean needsNewLine = false;
					for (@NonNull CGGuardVariable cgFreeVariable : cgFreeVariables) {
						js.append("protected ");
						doMappingConnectionVariable(cgFreeVariable);
						js.append(";\n");
						needsNewLine = true;
					}
					if (needsNewLine) {
						js.append("\n");
					}
					doMappingConstructor(cgMapping);
					js.append("\n");
					js.append("@Override\n");
					js.append("public boolean execute() ");
					doMappingBody(cgMapping, true);
					js.append("\n");
					doIsEqual(cgFreeVariables);
					js.popClassBody(false);
				}
				else {
					js.append("protected boolean " + mappingName + "(");
					boolean isFirst = true;
					for (@NonNull CGGuardVariable cgFreeVariable : cgFreeVariables) {
						if (!isFirst) {
							js.append(", ");
						}
						doMappingConnectionVariable(cgFreeVariable);
						isFirst = false;
					}
					js.append(") ");

					doMappingBody(cgMapping, false);

				}
			}
			finally {
				localContext = null;
			}
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGMappingCall(@NonNull CGMappingCall cgMappingCall) {
		MappingCall pMappingCall = (MappingCall) cgMappingCall.getAst();
		Mapping pReferredMapping = pMappingCall.getReferredMapping();
		if (pReferredMapping == null) {
			return true;
		}
		CGMapping cgReferredMapping = analyzer.getMapping(pReferredMapping);
		if (cgReferredMapping == null) {
			return true;
		}
		List<CGMappingCallBinding> cgMappingCallBindings = cgMappingCall.getOwnedMappingCallBindings();
		for (@SuppressWarnings("null")@NonNull CGMappingCallBinding cgMappingCallBinding : cgMappingCallBindings) {
			CGValuedElement value = cgMappingCallBinding.getOwnedValue();
			if (value != null) {
				if (!js.appendLocalStatements(value)) {
					return false;
				}
			}
		}
		if (useClass(cgReferredMapping)) {
			return doMappingCall_Class(cgMappingCall);
		}
		else {
			return doMappingCall_Function(cgMappingCall);
		}
	}

	@Override
	public @NonNull Boolean visitCGMappingCallBinding(@NonNull CGMappingCallBinding object) {
		return true;
	}

	@Override
	public @NonNull Boolean visitCGMappingExp(@NonNull CGMappingExp cgMappingExp) {
		//		assert cgMappingExp.getPredicates().isEmpty();		// Get rewritten during JavaPre pass
		CGMapping cgMapping = ClassUtil.nonNullState(QVTiCGUtil.getContainingCGMapping(cgMappingExp));
		List<@NonNull CGAccumulator> cgAccumulators = ClassUtil.nullFree(cgMappingExp.getOwnedAccumulators());
		if (cgAccumulators.size() > 0) {
			js.append("// connection variables\n");
			for (@NonNull CGAccumulator cgAccumulator : cgAccumulators) {
				Element ast = cgAccumulator.getAst();
				js.append("final ");
				js.appendClassReference(true, isIncremental ? Connection.Incremental.class : Connection.class);
				js.append(" ");
				js.appendValueName(cgAccumulator);
				js.append(isIncremental ? " = createIncrementalConnection(" : " = createConnection(");
				js.appendString(QVTiCGUtil.getName(cgAccumulator));
				js.append(", ");
				js.appendValueName(cgAccumulator.getTypeId());
				js.append(", ");
				js.appendBooleanString((ast instanceof BufferStatement) && ((BufferStatement)ast).isIsStrict());
				js.append(");\n");
				/*
				if ((ast instanceof ConnectionVariable) && (((ConnectionVariable)ast).getType() instanceof SetType)) {
					js.append("createUnenforcedSetAccumulatorValue(");
				}
				else {
					js.append("(");
					js.appendClassReference(null, cgAccumulator);
					js.append(".Accumulator)");
					js.appendClassReference(ValueUtil.class);
					js.append(".createCollectionAccumulatorValue(");
				}
				js.appendValueName(cgAccumulator.getTypeId());
				js.append(");\n"); */
				//
				CGValuedElement cgInit = cgAccumulator.getInit();
				if ((cgInit != null) && (!(cgInit instanceof CGCollectionExp) || !Iterables.isEmpty(((CGCollectionExp)cgInit).getParts()))) {
					if (!js.appendLocalStatements(cgInit)) {
						return false;
					}
					final String iteratorName = getSymbolName(null, "iterator");
					CollectionTypeId collectionTypeId = (CollectionTypeId)cgInit.getASTypeId();
					assert collectionTypeId != null;
					TypeId elementTypeId = collectionTypeId.getElementTypeId();
					BoxedDescriptor boxedDescriptor = context.getBoxedDescriptor(elementTypeId);
					js.append("for (");
					js.appendClassReference(Boolean.TRUE, boxedDescriptor);
					js.append(" ");
					js.append(iteratorName);
					js.append(" : ");
					js.appendClassReference(ValueUtil.class);
					js.append(".typedIterable(");
					js.appendClassReference(boxedDescriptor);
					js.append(".class, ");
					js.appendValueName(cgInit);
					js.append(")");
					//				js.appendReferenceTo(cgAccumulator.getInit());
					js.append(") {\n");
					js.pushIndentation(null);
					js.appendReferenceTo(cgAccumulator);
					js.append(".append(");
					js.append(iteratorName);
					js.append(");\n");
					js.popIndentation();
					js.append("}\n");
				}
			}
		}
		List<@NonNull CGRealizedVariable> cgRealizedVariables = ClassUtil.nullFree(cgMapping.getOwnedRealizedVariables());
		if (cgRealizedVariables.size() > 0) {
			js.append("// creations\n");
			for (@NonNull CGRealizedVariable cgRealizedVariable : cgRealizedVariables) {
				cgRealizedVariable.accept(this);
			}
		}
		List<@NonNull CGPropertyAssignment> cgPropertyAssignments = ClassUtil.nullFree(cgMapping.getOwnedAssignments());
		if (cgPropertyAssignments.size() > 0) {
			js.append("// property assignments\n");
			for (@NonNull CGPropertyAssignment cgAssignment : cgPropertyAssignments) {
				cgAssignment.accept(this);
			}
		}
		List<@NonNull CGConnectionAssignment> cgConnectionAssignments = ClassUtil.nullFree(cgMapping.getOwnedConnectionAssignments());
		if (cgConnectionAssignments.size() > 0) {
			js.append("// connection assignments\n");
			for (@NonNull CGConnectionAssignment cgConnectionAssignment : cgConnectionAssignments) {
				cgConnectionAssignment.accept(this);
			}
		}
		CGValuedElement body = cgMappingExp.getOwnedBody();
		if (body != null) {
			js.append("// mapping statements\n");
			body.accept(this);
		}
		js.appendDeclaration(cgMappingExp);
		js.append(" = ");
		js.appendClassReference(ValueUtil.class);
		js.append(".TRUE_VALUE;\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGMappingLoop(@NonNull CGMappingLoop cgMappingLoop) {
		CGValuedElement source = getExpression(cgMappingLoop.getSource());
		CGIterator iterator = cgMappingLoop.getIterators().get(0);
		CGValuedElement body = cgMappingLoop.getBody();
		if (!js.appendLocalStatements(source)) {
			return false;
		}
		js.append("for (");
		js.appendClassReference(Boolean.TRUE, iterator);
		js.append(" ");
		js.appendValueName(iterator);
		js.append(" : ");
		if (isConnection(source)) {
			js.appendValueName(source);
			js.append(".typedIterable(");
			js.appendClassReference(null, iterator);
			js.append(".class)");
		}
		else if (source.isBoxed()) {
			js.appendClassReference(ValueUtil.class);
			js.append(".typedIterable(");
			js.appendClassReference(null, iterator);
			js.append(".class, ");
			js.appendValueName(source);
			js.append(")");
		}
		else {
			js.appendValueName(source);
		}
		js.append(") {\n");
		js.pushIndentation(null);
		if (!iterator.isNonNull()) {
			js.append("if (");
			js.appendValueName(iterator);
			js.append(" != null) {\n");
			js.pushIndentation(null);
		}
		body.accept(this);
		if (!iterator.isNonNull()) {
			js.popIndentation();
			js.append("}\n");
		}
		js.popIndentation();
		js.append("}\n");
		boolean needsFlush = false;
		for (EObject eObject : new TreeIterable(body, false)) {
			if (eObject instanceof CGMappingCall) {
				CGMappingCall cgMappingCall = (CGMappingCall)eObject;
				MappingCall asMappingCall = (MappingCall) cgMappingCall.getAst();
				Mapping pReferredMapping = asMappingCall.getReferredMapping();
				if (pReferredMapping != null) {
					CGMapping cgReferredMapping = analyzer.getMapping(pReferredMapping);
					if ((cgReferredMapping != null) && useClass(cgReferredMapping)) {
						needsFlush = true;
						break;
					}
				}
			}
		}
		if (needsFlush) {
			js.append("invocationManager.flush();\n");
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGMiddlePropertyAssignment(@NonNull CGMiddlePropertyAssignment cgMiddlePropertyAssignment) {
		Property pReferredProperty = ClassUtil.nonNullModel(cgMiddlePropertyAssignment.getReferredProperty());
		assert !pReferredProperty.isIsImplicit();
		CGValuedElement slotValue = cgMiddlePropertyAssignment.getOwnedSlotValue();
		CGValuedElement initValue = cgMiddlePropertyAssignment.getOwnedInitValue();
		if ((slotValue != null) && (initValue != null)) {
			Map<@NonNull Property, @NonNull String> oppositeProperties = getGlobalContext().getOppositeProperties();
			if (oppositeProperties != null) {
				String cacheName = oppositeProperties.get(pReferredProperty);
				if (cacheName != null) {
					js.append(cacheName);
					js.append(".put(");
					js.appendValueName(initValue);
					js.append(", ");
					js.appendValueName(slotValue);
					js.append(");\n");
				}
			}
		}
		return visitCGEcorePropertyAssignment(cgMiddlePropertyAssignment);
	}

	@Override
	public @NonNull Boolean visitCGMiddlePropertyCallExp(@NonNull CGMiddlePropertyCallExp cgPropertyCallExp) {
		Property asOppositeProperty = ClassUtil.nonNullModel(cgPropertyCallExp.getReferredProperty());
		Property asProperty = ClassUtil.nonNullModel(asOppositeProperty.getOpposite());
		assert !asProperty.isIsImplicit();
		CGValuedElement source = getExpression(cgPropertyCallExp.getSource());
		//
		if (!js.appendLocalStatements(source)) {
			return false;
		}
		//
		EStructuralFeature eStructuralFeature = ClassUtil.nonNullState((EStructuralFeature) asProperty.getESObject());
		doGetting(cgPropertyCallExp, eStructuralFeature, true);
		js.appendDeclaration(cgPropertyCallExp);
		js.append(" = ");
		Map<Property, String> oppositeProperties = getGlobalContext().getOppositeProperties();
		if (oppositeProperties != null) {
			boolean isRequired = cgPropertyCallExp.isRequired();
			String cacheName = oppositeProperties.get(asProperty);
			if (cacheName != null) {
				if (isRequired) {
					js.appendClassReference(ClassUtil.class);
					js.append(".nonNullState (");
				}
				js.append(cacheName);
				js.append(".get(");
				js.appendValueName(source);
				js.append(")");
				if (isRequired) {
					js.append(")");
				}
			}
			js.append(";\n");
		}
		doGot(cgPropertyCallExp, source, eStructuralFeature);
		return true;
	}

	@Override
	public @NonNull Boolean visitCGPropertyAssignment(@NonNull CGPropertyAssignment cgPropertyAssignment) {
		CGExecutorProperty cgExecutorProperty = cgPropertyAssignment.getExecutorProperty();
		CGValuedElement slotValue = cgPropertyAssignment.getOwnedSlotValue();
		CGValuedElement initValue = cgPropertyAssignment.getOwnedInitValue();
		if ((slotValue != null) && (initValue != null)) {
			if (!js.appendLocalStatements(slotValue)) {
				return false;
			}
			if (!js.appendLocalStatements(initValue)) {
				return false;
			}
			js.appendReferenceTo(cgExecutorProperty);
			js.append(".initValue(");
			js.appendValueName(slotValue);
			js.append(", ");
			js.appendValueName(initValue);
			js.append(");\n");
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGRealizedVariable(@NonNull CGRealizedVariable cgRealizedVariable) {
		TypeId typeId = cgRealizedVariable.getASTypeId();
		if (typeId != null) {
			js.appendDeclaration(cgRealizedVariable);
			js.append(" = ");
			js.appendReferenceTo(cgRealizedVariable.getExecutorType());
			js.append(".createInstance();\n");
		}
		//
		doAddRealization(cgRealizedVariable);
		return true;
	}

	@Override
	public @NonNull Boolean visitCGSequence(@NonNull CGSequence cgSequence) {
		for (@NonNull CGValuedElement cgStatement : ClassUtil.nullFree(cgSequence.getOwnedStatements())) {
			cgStatement.accept(this);
		}
		return true;
	}

	/*	@Override
	public @NonNull Boolean visitCGShadowExp(@NonNull CGShadowExp cgShadowExp) {
		super.visitCGShadowExp(cgShadowExp);
		ShadowExp asShadowExp = (ShadowExp)ClassUtil.nonNullState(cgShadowExp.getAst());
		DomainUsage usage = transformationAnalysis.getDomainUsageAnalysis().getUsage(asShadowExp);
		TypedModel asTypedModel = ClassUtil.nonNullState(usage.getTypedModel(asShadowExp));
		CGTypedModel cgTypedModel = context.getAnalyzer().getTypedModel(asTypedModel);
		js.append(QVTiGlobalContext.MODELS_NAME);
		js.append("[");
		appendModelIndex(cgTypedModel);
		js.append("].add(");
		js.appendValueName(cgShadowExp);
		js.append(");\n");
		return true;
	} */

	@Override
	public @NonNull Boolean visitCGTransformation(@NonNull CGTransformation cgTransformation) {
		js.appendClassHeader(cgTransformation.getContainingPackage());
		ImperativeTransformation transformation = QVTiCGUtil.getAST(cgTransformation);
		QVTiTransformationAnalysis transformationAnalysis = context.getTransformationAnalysis(transformation);
		this.transformationAnalysis = transformationAnalysis;
		String className = cgTransformation.getName();
		assert className != null;
		js.append("/**\n");
		js.append(" * The " + className + " transformation:\n");
		js.append(" * <p>\n");
		js.append(" * Construct with an evaluator\n");
		js.append(" * <br>\n");
		js.append(" * Populate each input model with {@link addRootObjects(String,List)}\n");
		js.append(" * <br>\n");
		js.append(" * {@link run()}\n");
		js.append(" * <br>\n");
		js.append(" * Extract each output model with {@link getRootObjects(String)}\n");
		js.append(" */\n");
		js.append("@SuppressWarnings(\"nls\")\n");
		js.append("public class " + className + " extends ");
		js.appendClassReference(getAbstractTransformationExecutorClass());
		js.pushClassBody(className);
		if (sortedGlobals != null) {
			for (CGValuedElement cgElement : sortedGlobals) {
				assert cgElement.isGlobal();
				cgElement.accept(this);
			}
		}
		doOppositeCaches(transformationAnalysis);
		js.append("\n");
		String oppositeIndex2propertyIdName = doOppositePropertyIds(transformationAnalysis);
		if (oppositeIndex2propertyIdName != null) {
			js.append("\n");
		}
		@NonNull String @Nullable [] allInstancesNames = doAllInstances(transformationAnalysis);
		js.append("\n");
		List<@NonNull CGMapping> cgMappings = ClassUtil.nullFree(cgTransformation.getOwnedMappings());
		List<CGOperation> cgOperations = cgTransformation.getOperations();
		doMappingConstructorConstants(cgMappings);
		doFunctionConstructorConstants(ClassUtil.nullFree(cgOperations));
		js.append("\n");
		doConstructor(cgTransformation, oppositeIndex2propertyIdName, allInstancesNames);
		js.append("\n");
		/*		if (isIncremental) {
			doCreateIncrementalManagers();
			js.append("\n");
		} */
		doRun(cgTransformation);
		for (@NonNull CGOperation cgOperation : ClassUtil.nullFree(cgOperations)) {
			if (!(cgOperation instanceof CGCachedOperation)) {
				js.append("\n");
				cgOperation.accept(this);
			}
		}
		for (@NonNull CGOperation cgOperation : ClassUtil.nullFree(cgOperations)) {
			if ((cgOperation instanceof CGCachedOperation) && (((CGCachedOperation)cgOperation).getFinalOperations().size() <= 0)) {
				js.append("\n");
				cgOperation.accept(this);
			}
		}
		for (@NonNull CGOperation cgOperation : ClassUtil.nullFree(cgOperations)) {
			if ((cgOperation instanceof CGCachedOperation) && (((CGCachedOperation)cgOperation).getFinalOperations().size() > 0)) {
				js.append("\n");
				cgOperation.accept(this);
			}
		}
		for (@NonNull CGMapping cgMapping : ClassUtil.nullFree(cgTransformation.getOwnedMappings())) {
			js.append("\n");
			cgMapping.accept(this);
		}
		js.popClassBody(false);
		assert js.peekClassNameStack() == null;
		return true;
	}

	@Override
	public @NonNull Boolean visitCGTypedModel(@NonNull CGTypedModel object) {
		return true;
	}
}
