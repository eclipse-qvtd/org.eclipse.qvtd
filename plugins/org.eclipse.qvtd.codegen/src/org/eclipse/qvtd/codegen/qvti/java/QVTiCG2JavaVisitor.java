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
package org.eclipse.qvtd.codegen.qvti.java;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
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
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGGuardExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGLetExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNavigationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOppositePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGShadowExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGShadowPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGUnboxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaConstants;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.java.JavaStream.SubStream;
import org.eclipse.ocl.examples.codegen.java.types.BoxedDescriptor;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.complete.CompleteModelInternal;
import org.eclipse.ocl.pivot.internal.library.executor.AbstractEvaluationOperation;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.library.LibraryProperty;
import org.eclipse.ocl.pivot.library.oclany.OclElementOclContainerProperty;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
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
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculateExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculatePart;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.EntryPoint;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatementPart;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiModelsManager;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EntryPointAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EntryPointsAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.TypedModelAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractComputation;
import org.eclipse.qvtd.runtime.evaluation.AbstractInvocation;
import org.eclipse.qvtd.runtime.evaluation.AbstractSimpleInvocation;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Connection;
import org.eclipse.qvtd.runtime.evaluation.Interval;
import org.eclipse.qvtd.runtime.evaluation.InvalidEvaluationException;
import org.eclipse.qvtd.runtime.evaluation.InvocationConstructor;
import org.eclipse.qvtd.runtime.evaluation.InvocationFailedException;
import org.eclipse.qvtd.runtime.evaluation.ModeFactory;
import org.eclipse.qvtd.runtime.evaluation.SlotState;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractComputationConstructor;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractInvocationConstructor;
import org.eclipse.qvtd.runtime.internal.evaluation.RuntimeModelsManager;

import com.google.common.collect.Iterables;

/**
 * A QVTiCG2JavaVisitor supports generation of Java code from an optimized QVTi CG transformation tree.
 */
public class QVTiCG2JavaVisitor extends CG2JavaVisitor<@NonNull QVTiCodeGenerator> implements QVTiCGModelVisitor<@NonNull Boolean>
{
	protected /*static*/ class AllInstancesAnalysis extends TypedModelAnalysis
	{
		private @NonNull String @Nullable [] names = null;
		private @Nullable String extentOppositesName = null;

		public AllInstancesAnalysis(@NonNull EntryPointsAnalysis entryPointsAnalysis, @NonNull TypedModel typedModel, @NonNull Set<@NonNull CompleteClass> allInstancesCompleteClasses) {
			super(entryPointsAnalysis, typedModel, allInstancesCompleteClasses);
			ClassId extentClassId = QVTiModelsManager.EXTENT_CLASSID;
			Map<@NonNull Property, @NonNull Integer> opposites = entryPointsAnalysis.getCaches();
			for (@NonNull Property property : opposites.keySet()) {
				org.eclipse.ocl.pivot.Class owningClass = PivotUtil.getOwningClass(property);
				TypeId typeId = owningClass.getTypeId();
				if (typeId == extentClassId) {
					Integer index = opposites.get(property);
					assert index != null;
					Map<@NonNull Property, @NonNull String> oppositeProperties = getGlobalContext().getOppositeProperties();
					assert oppositeProperties != null;
					extentOppositesName = oppositeProperties.get(property);
					//	extentOppositesName = "xyzzy";
				}
			}
		}

		public @Nullable String getExtentOppositesName() {
			return extentOppositesName;
		}

		protected @NonNull Map<@NonNull CompleteClass, @NonNull Integer> getInstancesCompleteClass2index() {
			return instancesCompleteClass2index;
		}

		protected @NonNull Map<@NonNull CompleteClass, @Nullable List<@NonNull CompleteClass>> getInstancesCompleteClassAnalysis() {
			return instancesCompleteClassAnalysis;
		}

		protected @NonNull String @NonNull [] getNames() {
			return ClassUtil.nonNullState(names);
		}

		protected @NonNull List<@NonNull CompleteClass> getSortedCompleteClasses() {
			return sortedCompleteClasses;
		}

		public void setNames(@NonNull String[] names) {
			this.names = names;
		}
	}

	/**
	 * A CachedInstance identifies the characteristics of a shared mapping invocation.
	 */
	private class CachedInstance
	{
		private org.eclipse.ocl.pivot.@NonNull Class asClass;
		private @NonNull CGExecutorType cgExecutorType;
		private @NonNull List<@NonNull CGExecutorProperty> cgProperties;
		private int modelIndex;

		protected CachedInstance(org.eclipse.ocl.pivot.@NonNull Class asClass, @NonNull CGExecutorType cgExecutorType,
				@NonNull List<@NonNull CGExecutorProperty> cgProperties, int modelIndex) {
			this.asClass = asClass;
			this.cgExecutorType = cgExecutorType;
			this.cgProperties = cgProperties;
			this.modelIndex = modelIndex;
		}

		public @NonNull Boolean doCachedInstance() {
			String instanceClassName = getNativeInstanceClassName(cgExecutorType);
			js.append("public class ");
			js.append(instanceClassName);
			js.append(" extends ");
			js.appendClassReference(null, AbstractEvaluationOperation.class);
			js.pushClassBody(instanceClassName);
			doCachedInstanceBasicEvaluate();
			js.append("\n");
			doCachedInstanceEvaluate();
			js.popClassBody(false);
			//
			js.append("\n");
			doCachedInstanceClassInstance();
			return true;
		}

		protected void doCachedInstanceBasicEvaluate() {
			js.append("@Override\n");
			js.append("public ");
			js.appendClassReference(false, Object.class);
			js.append(" basicEvaluate(");
			js.appendClassReference(true, Executor.class);
			js.append(" ");
			js.append(globalContext.getExecutorName());
			js.append(", ");
			js.appendClassReference(true, TypedElement.class);
			js.append(" ");
			js.append("caller");
			js.append(", ");
			js.appendClassReference(false, Object.class);
			js.append(" ");
			js.appendIsRequired(true);
			js.append(" [] ");
			js.append(JavaConstants.SOURCE_AND_ARGUMENT_VALUES_NAME);
			js.append(") {\n");
			js.pushIndentation(null);

			EClass eClass = (EClass)asClass.getESObject();
			assert eClass != null;
			String createMethodName = "create" + eClass.getName();
			boolean canSetNonNull = false;
			EPackage ePackage = eClass.getEPackage();
			String javaClass;
			if (ePackage != null) {
				Class<?> factoryClass = genModelHelper.getEcoreFactoryClass(ePackage);
				if (factoryClass != null) {
					javaClass = factoryClass.getName();
					Method factoryMethod = context.getLeastDerivedMethod(factoryClass, createMethodName);
					if (factoryMethod != null) {
						if (context.getIsNonNull(factoryMethod) == Boolean.TRUE) {
							canSetNonNull = true;
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
			String instanceName = "instance";
			js.appendTypeDeclaration(cgExecutorType);
			js.append(" " + instanceName + " = ");
			js.appendClassReference(null, javaClass);
			js.append(".eINSTANCE.");
			js.append(createMethodName);
			js.append("();\n");



			Map<@NonNull Property, @NonNull String> oppositeProperties = getGlobalContext().getOppositeProperties();
			int i = 0;
			for (@NonNull CGExecutorProperty cgProperty : cgProperties) {
				Property asProperty = QVTiCGUtil.getAST(cgProperty);
				String setAccessor = genModelHelper.getSetAccessor((EStructuralFeature)asProperty.getESObject());
				if (cgProperty.getASTypeId() instanceof CollectionTypeId) {
					js.append("@SuppressWarnings(\"unchecked\") ");
				}
				else if (cgProperty.isRequired()) {
					if (js.appendSuppressWarningsNull(false)) {
						js.append(" ");
					}
				}
				js.appendTypeDeclaration(cgProperty);
				js.append(" value" + i + " = (");
				js.appendTypeDeclaration(cgProperty);
				js.append(")");
				js.append(JavaConstants.SOURCE_AND_ARGUMENT_VALUES_NAME);
				js.append("[" + i + "];\n");

				js.append(instanceName + "." + setAccessor + "(value" + i);
				js.append(");\n");

				if (oppositeProperties != null) {
					Property iProperty = QVTiCGUtil.getAST(cgProperty);
					String cacheName = oppositeProperties.get(iProperty);
					if (cacheName != null) {
						js.append(cacheName);
						js.append(".put(value" + i);
						js.append(", ");
						//						js.appendReferenceTo(outerTypeDescriptor, slotValue);
						js.append(instanceName);
						js.append(");\n");
					}
				}


				i++;


			}


			js.append(QVTiGlobalContext.MODELS_NAME);
			js.append("[" + modelIndex + "].add(");
			js.append(instanceName);
			js.append(", false);\n");



			js.append("return " + instanceName + ";\n");
			js.popIndentation();
			js.append("}\n");
		}

		protected void doCachedInstanceEvaluate() {
			js.append("public ");
			js.appendClassReference(true, cgExecutorType);
			js.append(" evaluate(");
			boolean isFirst = true;
			for (@NonNull CGExecutorProperty cgProperty : cgProperties) {
				if (!isFirst) {
					js.append(", ");
				}
				js.appendDeclaration(cgProperty);
				isFirst = false;
			}
			js.append(") {\n");
			js.pushIndentation(null);
			js.append("return (");
			js.appendClassReference(true, cgExecutorType);
			js.append(")");
			js.append(JavaConstants.EVALUATION_CACHE_NAME);
			js.append(".getCachedEvaluationResult(this, caller, new ");
			js.appendClassReference(false, Object.class);
			js.append("[]{");
			isFirst = true;
			for (@NonNull CGExecutorProperty cgProperty : cgProperties) {
				if (!isFirst) {
					js.append(", ");
				}
				js.appendValueName(cgProperty);
				isFirst = false;
			}
			js.append("});\n");
			js.popIndentation();
			js.append("}\n");
		}

		protected void doCachedInstanceClassInstance() {
			String instanceClassName = getNativeInstanceClassName(cgExecutorType);
			js.append("protected final ");
			js.appendIsRequired(true);
			js.append(" ");
			js.append(instanceClassName);
			js.append(" ");
			js.append(getNativeInstanceInstanceName(cgExecutorType));
			js.append(" = new ");
			js.append(instanceClassName);
			js.append("();\n");
		}

		public void check(@NonNull List<@NonNull CGExecutorProperty> cgProperties, int modelIndex) {
			// TODO Auto-generated method stub
			//		List<@NonNull CGExecutorProperty> oldProperties = cachedInstances.put(cgType, cgProperties);
			//		if (oldProperties != null) {
			//			assert oldProperties.equals(cgProperties);
			//		}

		}
	}

	/**
	 * The run-time API version.
	 *
	 * @noreference this is solely for development usage.
	 */
	public static int RUN_TIME_EVALUATOR_API_VERSION = Transformer.RUN_TIME_EVALUATOR_API_VERSION_1_1_0_2;

	protected final @NonNull QVTiAnalyzer analyzer;
	protected final @NonNull CGPackage cgPackage;
	protected final @Nullable Iterable<@NonNull CGValuedElement> sortedGlobals;
	protected boolean isGeneratedDebug = false;
	protected boolean isIncremental = false;
	protected boolean alwaysUseClasses = false;
	protected boolean useGot = true;

	/* Non-null while wrapping a function-implemented mapping in a SimpleInvocation */
	private @Nullable Mapping invocationWrapper = null;

	public QVTiCG2JavaVisitor(@NonNull QVTiCodeGenerator codeGenerator, @NonNull CGPackage cgPackage,
			@Nullable Iterable<@NonNull CGValuedElement> sortedGlobals) {
		super(codeGenerator);
		this.analyzer = codeGenerator.getAnalyzer();
		this.cgPackage = cgPackage;
		this.sortedGlobals = sortedGlobals;
		this.isGeneratedDebug = codeGenerator.getOptions().isGeneratedDebug();
		this.isIncremental = codeGenerator.getOptions().isIncremental();
		this.alwaysUseClasses = isIncremental;
		this.useGot = isIncremental;
	}

	protected void appendConnectionBinding(@NonNull CGMappingCallBinding cgMappingCallBinding) {
		TypeDescriptor checkedType = needsTypeCheck(cgMappingCallBinding);
		if (checkedType != null) {
			needsTypeCheck(cgMappingCallBinding);
			js.append("(");
			js.appendClassReference(null, checkedType);
			js.append(")");
		}
		js.appendValueName(cgMappingCallBinding.getOwnedValue());
	}

	protected void appendEcoreSet(@NonNull CGValuedElement cgSlot, @NonNull EStructuralFeature eStructuralFeature, @NonNull CGValuedElement cgInit, boolean isPartial) {
		EClassifier eType = eStructuralFeature.getEType();
		String instanceClassName = eType.getInstanceClassName();
		if (eStructuralFeature.isMany()) {
			String getAccessor = genModelHelper.getGetAccessor(eStructuralFeature);
			//
			js.appendValueName(cgSlot);
			js.append(".");
			js.append(getAccessor);
			js.append("().");
			if (isPartial) {
				js.append("add(");
				if (instanceClassName != null) {
					js.appendEcoreValue(instanceClassName, cgInit);
				}
				else {
					js.appendAtomicReferenceTo(cgInit);
				}
			}
			else {
				js.append( "addAll(");		// FIXME may need to loop addAll manually
				js.appendAtomicReferenceTo(cgInit);
			}
			js.append(");\n");
		}
		else {
			String setAccessor = genModelHelper.getSetAccessor(eStructuralFeature);
			//
			js.appendValueName(cgSlot);
			js.append(".");
			js.append(setAccessor);
			js.append("(");
			if (instanceClassName != null) {
				js.appendEcoreValue(instanceClassName, cgInit);
			}
			else {
				js.appendAtomicReferenceTo(cgInit);
			}
			js.append(");\n");
		}
	}

	@Override		// FIXME promote to OCL
	protected void appendGuardFailure(@NonNull CGGuardExp cgGuardExp) {
		js.append("throw new ");
		js.appendClassReference(null, InvalidEvaluationException.class);
		js.append("(");
		js.appendString("Null " + cgGuardExp.getMessage());
		js.append(");\n");
	}

	protected void appendModelIndex(@Nullable CGTypedModel cgTypedModel) {
		if (cgTypedModel == null) {
			js.append("-1/*null*/");
		}
		else {
			js.append(cgTypedModel.getModelIndex() + "/*" + cgTypedModel.getName() + "*/");
		}
	}

	protected void appendQualifiedLiteralName(@NonNull EStructuralFeature eStructuralFeature) {
		EClass eContainingClass = ClassUtil.nonNullState(eStructuralFeature.getEContainingClass());
		EPackage ePackage = ClassUtil.nonNullState(eContainingClass.getEPackage());
		js.appendClassReference(null, genModelHelper.getQualifiedPackageInterfaceName(ePackage));
		js.append(".Literals.");
		js.append(genModelHelper.getEcoreLiteralName(eStructuralFeature));
	}

	protected void appendThis(@NonNull CGElement cgElement) {
		for (EObject eObject = cgElement; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof CGMapping) {
				js.appendThis(getMappingName((CGMapping)eObject));		// + ".this"
				return;
			}
			if (eObject instanceof CGFunction) {
				js.appendThis(getFunctionName((CGFunction)eObject));		// + ".this"
				return;
			}
			if (eObject instanceof CGClass) {
				js.appendThis(ClassUtil.nonNullState(((CGClass)eObject).getName()));		// + ".this"
				return;
			}
		}
		assert false;
		js.appendThis("");		// "this"
		return;
	}

	protected void doAddRealization(@NonNull CGRealizedVariable cgRealizedVariable) {
		boolean isShared = cgRealizedVariable.getOwnedParts().size() > 0;
		CGTypedModel cgTypedModel = cgRealizedVariable.getTypedModel();
		NewStatement asNewStatement = QVTiCGUtil.getAST(cgRealizedVariable);
		//
		if (!isShared) {
			js.append(QVTiGlobalContext.MODELS_NAME);
			js.append("[");
			appendModelIndex(cgTypedModel);
			js.append("].add(");
			js.appendValueName(cgRealizedVariable);
			js.append(", ");
			js.appendBooleanString(asNewStatement.isIsContained());
			js.append(");\n");
		}
		//
		if (isGeneratedDebug) {
			js.append("if (debugCreations) {\n");
			js.pushIndentation(null);
			js.appendClassReference(null, AbstractTransformer.class);
			js.append(".CREATIONS.println(\"created \"");
			js.append(" + toDebugString(");
			js.append(getValueName(cgRealizedVariable));
			js.append(")");
			js.append(");\n");
			js.popIndentation();
			js.append("}\n");
		}
		//
		if (isIncremental) {
			js.append(QVTiGlobalContext.OBJECT_MANAGER_NAME);
			js.append(".created(");
			appendThis(cgRealizedVariable);
			js.append(", ");
			js.appendValueName(cgRealizedVariable);
			js.append(");\n");
		}
	}

	protected @Nullable List<@Nullable AllInstancesAnalysis> doAllInstances(@NonNull EntryPointsAnalysis entryPointsAnalysis) {
		CompleteModelInternal completeModel = environmentFactory.getCompleteModel();
		Set<@NonNull CompleteClass> allInstancesCompleteClasses = new HashSet<>();
		for (@NonNull CompleteClass allInstancesCompleteClass : entryPointsAnalysis.getAllInstancesCompleteClasses()) {
			allInstancesCompleteClasses.add(allInstancesCompleteClass);
		}
		if (allInstancesCompleteClasses.size() <= 0) {
			return null;
		}
		List<@Nullable AllInstancesAnalysis> allInstancesAnalyses = new ArrayList<>();
		int typedModelNumber = 0;
		for (@NonNull TypedModel typedModel : QVTimperativeUtil.getModelParameters(entryPointsAnalysis.getTransformation())) {
			Set<@NonNull CompleteClass> allInstancesCompleteClasses2 = new HashSet<>();
			for (org.eclipse.ocl.pivot.@NonNull Class usedClass : QVTimperativeUtil.getUsedClasses(typedModel)) {
				allInstancesCompleteClasses2.add(completeModel.getCompleteClass(usedClass));
			}
			allInstancesCompleteClasses2.retainAll(allInstancesCompleteClasses);
			if (!allInstancesCompleteClasses2.isEmpty()) {
				AllInstancesAnalysis allInstancesAnalysis = new AllInstancesAnalysis(entryPointsAnalysis, typedModel, allInstancesCompleteClasses2);
				Map<@NonNull CompleteClass, @NonNull Integer> instancesClass2index = allInstancesAnalysis.getInstancesCompleteClass2index();
				List<@NonNull CompleteClass> sortedCompleteClasses = allInstancesAnalysis.getSortedCompleteClasses();
				Map<@NonNull CompleteClass, @Nullable List<@NonNull CompleteClass>> instancesClassAnalysis = allInstancesAnalysis.getInstancesCompleteClassAnalysis();
				NameManager nameManager = getGlobalContext().getNameManager();
				//
				//	Emit the ClassId array
				//
				js.append("/*\n");
				js.append(" * Array of the ClassIds of each class for which allInstances() may be invoked. Array index is the ClassIndex for TypedModel " + typedModelNumber + ".\n");
				js.append(" */\n");
				String classIndex2classIdName = getGlobalContext().getClassIndex2classId(typedModelNumber);
				js.append("private static final ");
				js.appendClassReference(true, ClassId.class);
				js.append(" ");
				js.appendIsRequired(true);
				js.append(" [] ");
				js.append(classIndex2classIdName);
				js.append(" = new ");
				js.appendClassReference(true, ClassId.class);
				js.append("[]{\n");
				js.pushIndentation(null);
				for (int i = 0; i < sortedCompleteClasses.size(); i++) {
					CompleteClass instancesClass = sortedCompleteClasses.get(i);
					CGTypeId cgTypeId = getCodeGenerator().getAnalyzer().getTypeId(instancesClass.getPrimaryClass().getTypeId());
					int startLength = js.length();
					js.appendValueName(cgTypeId);
					if ((i+1) < sortedCompleteClasses.size()) {
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
				String classIndex2allClassIndexes = getGlobalContext().getClassIndex2allClassIndexes(typedModelNumber);
				js.append("\n");
				js.append("/*\n");
				js.append(" * Mapping from each TypedModel " + typedModelNumber + " ClassIndex to all the ClassIndexes\n");
				js.append(" * to which an object of the outer index may contribute results to an allInstances() invocation.\n");
				js.append(" * Non trivial inner arrays arise when one ClassId is a derivation of another and so an\n");
				js.append(" * instance of the derived classId contributes to derived and inherited ClassIndexes.\n");
				js.append(" */\n");
				js.append("private final static int ");
				js.appendIsRequired(true);
				js.append(" [] ");
				js.appendIsRequired(true);
				js.append(" [] ");
				js.append(classIndex2allClassIndexes);
				js.append(" = new int ");
				js.appendIsRequired(true);
				js.append(" [] ");
				js.appendIsRequired(true);
				js.append(" [] {\n");
				js.pushIndentation(null);
				for (int i = 0; i < sortedCompleteClasses.size(); i++) {
					CompleteClass instancesClass = sortedCompleteClasses.get(i);
					List<@NonNull CompleteClass> superInstancesClasses = ClassUtil.nonNullState(instancesClassAnalysis.get(instancesClass));
					int startLength = js.length();
					js.append("{");
					boolean isFirst = true;
					for (@NonNull CompleteClass superInstancesClass : superInstancesClasses) {
						if (!isFirst) {
							js.append(",");
						}
						js.append("" + instancesClass2index.get(superInstancesClass));
						isFirst = false;
					}
					js.append("}");
					if ((i+1) < sortedCompleteClasses.size()) {
						js.append(",");
					}
					for (int j = js.length() - startLength; j < 32; j++) {
						js.append(" ");
					}
					js.append("// " + i + " : ");
					js.append(instancesClass.getName());
					js.append(" -> {");
					isFirst = true;
					for (@NonNull CompleteClass superInstancesClass : superInstancesClasses) {
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
				allInstancesAnalysis.setNames(new @NonNull String[]{ classIndex2classIdName, classIndex2allClassIndexes});
				allInstancesAnalyses.add(allInstancesAnalysis);
			}
			else {
				allInstancesAnalyses.add(null);
			}
			typedModelNumber++;
		}
		return allInstancesAnalyses;
	}

	protected void doAssigned(@NonNull CGEcoreContainerAssignment cgPropertyAssignment) {
		EStructuralFeature eStructuralFeature = QVTiCGUtil.getEStructuralFeature(cgPropertyAssignment);
		CGValuedElement cgSlot = getExpression(QVTiCGUtil.getOwnedSlotValue(cgPropertyAssignment));
		CGValuedElement cgInit = getExpression(QVTiCGUtil.getOwnedInitValue(cgPropertyAssignment));
		if (isIncremental || ((SetStatement)cgPropertyAssignment.getAst()).isIsNotify()) {
			js.append(QVTiGlobalContext.OBJECT_MANAGER_NAME);
			js.append(".assigned(");
			if (isIncremental) {
				appendThis(cgPropertyAssignment);
				js.append(", ");
			}
			js.appendValueName(cgInit);
			js.append(", ");
			appendQualifiedLiteralName(eStructuralFeature);
			js.append(", ");
			js.appendValueName(cgSlot);
			js.append(", false);\n");
		}
	}

	protected void doAssigned(@NonNull CGEcorePropertyAssignment cgPropertyAssignment, boolean isPartial) {
		EStructuralFeature eStructuralFeature = QVTiCGUtil.getEStructuralFeature(cgPropertyAssignment);
		CGValuedElement cgSlot = getExpression(QVTiCGUtil.getOwnedSlotValue(cgPropertyAssignment));
		CGValuedElement cgInit = getExpression(QVTiCGUtil.getOwnedInitValue(cgPropertyAssignment));
		if (isIncremental || ((SetStatement)cgPropertyAssignment.getAst()).isIsNotify()) {
			js.append(QVTiGlobalContext.OBJECT_MANAGER_NAME);
			js.append(".assigned(");
			if (isIncremental) {
				appendThis(cgPropertyAssignment);
				js.append(", ");
			}
			js.appendValueName(cgSlot);
			js.append(", ");
			appendQualifiedLiteralName(eStructuralFeature);
			js.append(", ");
			js.appendValueName(cgInit);
			js.append(", ");
			js.appendBooleanString(eStructuralFeature.isMany() && isPartial);
			js.append(");\n");
		}
	}

	private void doAssigned(@NonNull CGGuardVariable cgGuardVariable, @NonNull EStructuralFeature eStructuralFeature, CGValuedElement cgInit) {
		CGValuedElement cgSlot = cgGuardVariable;
		//		CGValuedElement cgInit = getExpression(QVTiCGUtil.getOwnedInitValue(cgPropertyAssignment));
		//		if (isIncremental || ((SetStatement)cgGuardVariable.getAst()).isIsNotify()) {
		js.append(QVTiGlobalContext.OBJECT_MANAGER_NAME);
		js.append(".assigned(");
		if (isIncremental) {
			appendThis(cgGuardVariable);
			js.append(", ");
		}
		js.appendValueName(cgSlot);
		js.append(", ");
		appendQualifiedLiteralName(eStructuralFeature);
		js.append(", ");
		js.appendValueName(cgInit);
		js.append(", false);\n");
		//		}
	}

	protected void doConstructor(@NonNull CGTransformation cgTransformation, @Nullable String oppositeName, @Nullable List<@Nullable AllInstancesAnalysis> allInstancesAnalyses) {
		//		String evaluatorName = ((QVTiGlobalContext)globalContext).getEvaluatorParameter().getName();
		String evaluatorName = globalContext.getExecutorName();
		String className = cgTransformation.getName();
		String transformationName = ((QVTiGlobalContext)globalContext).getTransformationName();
		Iterable<@NonNull CGTypedModel> cgTypedModels = QVTiCGUtil.getOwnedTypedModels(cgTransformation);
		//
		js.append("protected final ");
		js.appendIsRequired(true);
		js.append(" " +  className + " " + transformationName + " = this;\n");
		js.append("\n");
		//
		js.append("public " + className + "(final ");
		js.appendClassReference(true, TransformationExecutor.class);
		js.append(" " + evaluatorName + ") {\n");
		js.pushIndentation(null);
		js.append("super(" + evaluatorName + ", ");
		js.appendIntegerString(Iterables.size(cgTypedModels));
		js.append(");\n");
		if (oppositeName != null) {
			js.append("initOpposites(");
			js.append(oppositeName);
			js.append(");\n");
		}
		int modelNumber = 0;
		for (@NonNull CGTypedModel cgTypedModel : cgTypedModels) {
			js.append("initModel(");
			js.appendIntegerString(modelNumber);
			js.append(", ");
			String name = cgTypedModel.getName();
			js.appendString(name != null ? name : "");
			js.append(")");
			if (allInstancesAnalyses != null) {
				AllInstancesAnalysis allInstancesAnalysis = allInstancesAnalyses.get(modelNumber);
				if (allInstancesAnalysis != null) {
					js.append(".initClassIds(");
					js.append(allInstancesAnalysis.getNames()[0]);
					js.append(", ");
					js.append(allInstancesAnalysis.getNames()[1]);
					js.append(")");
					int extentClassIndex = allInstancesAnalysis.getExtentClassIndex();
					if (extentClassIndex >= 0) {
						js.append(".initExtent(");
						js.appendIntegerString(extentClassIndex);
						js.append(", ");
						String extentOppositesName = allInstancesAnalysis.getExtentOppositesName();
						js.append(extentOppositesName != null ? extentOppositesName : "null");
						js.append(")");
					}
				}
			}
			js.append(";\n");
			modelNumber++;
		}
		js.append("initConnections();\n");
		/*		ImperativeTransformation transformation = QVTiCGUtil.getAST(cgTransformation);
		EntryPointsAnalysis entryPointsAnalysis = context.getEntryPointsAnalysis(transformation);
		for (@NonNull EntryPointAnalysis entryPointAnalysis : entryPointsAnalysis.getEntryPointAnalyses()) {
			Iterable<@NonNull EAttribute> eAttributes = entryPointAnalysis.getSpeculatedEAttributes();
			if ((eAttributes != null) && !Iterables.isEmpty(eAttributes)) {
				js.append("initSpeculatedEAttributes(");
				js.appendString(entryPointAnalysis.getEntryPoint().getName());
				for (@NonNull EAttribute eAttribute : eAttributes) {
					js.append(", ");
					appendQualifiedLiteralName(eAttribute);
				}
				js.append(");\n");
			}
		} */
		//		doMappingConstructorInitializers(cgTransformation);
		//		doFunctionConstructorInitializers(cgTransformation);
		js.popIndentation();
		js.append("}\n");
	}

	/*	protected void doCreateInterval(@NonNull CGTransformation cgTransformation) {
		js.append("@Override\n");
		js.append("protected ");
		js.appendClassReference(true, Interval.class);
		js.append(" createInterval(int intervalIndex) {\n");
		js.pushIndentation(null);
		js.append("switch (intervalIndex) {\n");
		js.append("}\n");
		js.append("return new ");
		js.appendClassReference(null, DefaultInterval.class);
		js.append("(invocationManager, intervalIndex);\n");
		js.popIndentation();
		js.append("}\n");
	} */

	/*	protected void doCreateIncrementalManagers() {
		js.append("@Override\n");
		js.append("protected ");
		js.appendClassReference(true, InvocationManager.class);
		js.append(" createInvocationManager() {\n");
		js.pushIndentation(null);
		js.append("return new ");
		js.appendClassReference(null, IncrementalInvocationManager.class);
		js.append("(");
		js.append(globalContext.getExecutorName());
		js.append(");\n");
		js.popIndentation();
		js.append("}\n");
		js.append("\n");
		js.append("@Override\n");
		js.append("protected ");
		js.appendClassReference(true, ObjectManager.class);
		js.append(" createObjectManager() {\n");
		js.pushIndentation(null);
		js.append("return new ");
		js.appendClassReference(null, IncrementalObjectManager.class);
		js.append("((");
		js.appendClassReference(null, IncrementalInvocationManager.class);
		js.append(")invocationManager);\n");
		js.popIndentation();
		js.append("}\n");
	} */

	protected boolean doCreateRealizedVariable(@NonNull CGRealizedVariable cgRealizedVariable) {
		if (isIncremental) {
			js.appendClassReference(null, cgRealizedVariable);
			js.append(" ");
			js.appendValueName(cgRealizedVariable);
			js.append(" = this.");
			js.appendValueName(cgRealizedVariable);
			js.append(";\n");
			js.append("if (");
			js.appendValueName(cgRealizedVariable);
			js.append(" == null) {\n");
			js.pushIndentation(null);
		}
		boolean flowContinues = cgRealizedVariable.accept(this).booleanValue();
		if (flowContinues) {
			doAddRealization(cgRealizedVariable);
			//
			if (isIncremental) {
				js.append("assert ");
				js.appendValueName(cgRealizedVariable);
				js.append(" != null;\n");
				js.append("this.");
				js.appendValueName(cgRealizedVariable);
				js.append(" = ");
				js.appendValueName(cgRealizedVariable);
				js.append(";\n");
			}
		}
		if (isIncremental) {
			js.popIndentation();
			js.append("}\n");
		}
		return flowContinues;
	}

	/**
	 * Create a Ecore Class, returning
	 * false if an exception thrown for an abstract class
	 * null
	 * @param cgElement
	 * @param eClass
	 * @return
	 */
	protected boolean doEcoreCreateClass(@NonNull CGValuedElement cgElement, @NonNull EClass eClass, boolean setClassNonNull) {
		if (eClass.isAbstract()) {
			CGMapping cgMapping = QVTiCGUtil.getContainingCGMapping(cgElement);
			js.append("throw new ");
			js.appendClassReference(null, InvalidEvaluationException.class);
			js.append("(\"");
			js.append("Cannot create an instance of the abstract EClass ");
			js.append(LabelUtil.getLabel(eClass));
			js.append(" in ");
			js.append(LabelUtil.getLabel(cgMapping));
			js.append("\");\n");
			return false;
		}
		String createMethodName = "create" + eClass.getName();
		boolean canSetNonNull = false;
		EPackage ePackage = eClass.getEPackage();
		String javaClass;
		if (ePackage != null) {
			Class<?> factoryClass = genModelHelper.getEcoreFactoryClass(ePackage);
			if (factoryClass != null) {
				javaClass = factoryClass.getName();
				Method factoryMethod = context.getLeastDerivedMethod(factoryClass, createMethodName);
				if (factoryMethod != null) {
					if (context.getIsNonNull(factoryMethod) == Boolean.TRUE) {
						canSetNonNull = true;
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
		CGMapping cgMapping = QVTiCGUtil.basicGetContainingCGMapping(cgElement);
		if ((cgMapping == null) || !useClass(cgMapping) || !isIncremental) {
			js.append("final ");
			if (!canSetNonNull) {
				js.appendSuppressWarningsNull(false);
			}
			js.appendClassReference(true, cgElement);
			js.append(" ");
		}
		js.appendValueName(cgElement);
		js.append(" = ");
		boolean hasParts = false;
		if (cgElement instanceof CGRealizedVariable) {
			CGRealizedVariable cgRealizedVariable = (CGRealizedVariable)cgElement;
			NewStatement iNewStatement = QVTiCGUtil.getAST(cgRealizedVariable);
			List<NewStatementPart> ownedParts = iNewStatement.getOwnedParts();
			if (ownedParts.size() > 0) {
				hasParts = true;
				assert cgMapping != null;
				js.append(getNativeInstanceInstanceName(cgRealizedVariable.getExecutorType()));
				js.append(".evaluate(");
				boolean isFirst = true;
				for (@NonNull CGRealizedVariablePart cgPart : cgRealizedVariable.getOwnedParts()) {
					if (!isFirst) {
						js.append(", ");
					}
					js.appendValueName(cgPart.getInit());
					isFirst = false;
				}
				js.append(")");
				js.append(";\n");
			}
		}
		if (!hasParts) {
			js.appendClassReference(null, javaClass);
			js.append(".eINSTANCE.");
			js.append(createMethodName);
			js.append("();\n");
		}
		//		js.append("assert ");
		//		js.appendValueName(cgElement);
		//		js.append(" != null;\n");
		//
		if (setClassNonNull) {
			((CGVariable)cgElement).setNonNull();
		}
		return true;
	}

	protected boolean doEcoreCreateDataType(@NonNull CGValuedElement cgElement, @NonNull EDataType eDataType, @NonNull CGValuedElement cgInit) {
		//
		//	Availability of a GenPackage is mandatory since we must have an EFactory.createFromString method to do the construction.
		//
		final Class<?> javaClass = eDataType.getInstanceClass();
		if (javaClass == null) {
			throw new IllegalStateException("No Java class for " + cgElement + " in QVTiCG2JavaVisitor.doEcoreCreateDataType()");
		}
		final EPackage ePackage = eDataType.getEPackage();
		String nsURI = ePackage.getNsURI();
		if (nsURI == null) {
			throw new IllegalStateException("No EPackage NsURI for " + cgElement + " in QVTiCG2JavaVisitor.doEcoreCreateDataType()");
		}
		GenPackage genPackage = environmentFactory.getMetamodelManager().getGenPackage(nsURI);
		if (genPackage == null) {
			throw new IllegalStateException("No GenPackage for " + cgElement + " in QVTiCG2JavaVisitor.doEcoreCreateDataType()");
		}
		final String eFactoryName = genPackage.getQualifiedFactoryInterfaceName();
		final String ePackageName = genPackage.getQualifiedPackageInterfaceName();
		final String dataTypeName = CodeGenUtil.upperName(eDataType.getName());
		ClassLoader classLoader = eDataType.getClass().getClassLoader();
		Class<?> factoryClass;
		Class<?> packageClass;
		try {
			factoryClass = classLoader.loadClass(eFactoryName);
			packageClass = classLoader.loadClass(ePackageName);
		}
		catch (ClassNotFoundException e) {
			throw new IllegalStateException("Load class failure for " + cgElement + " in QVTiCG2JavaVisitor.doEcoreCreateDataType()", e);
		}
		//



		String createMethodName = QVTiGlobalContext.CREATE_FROM_STRING_NAME;
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
		js.appendClassReference(null, javaClass);
		js.append(")");
		js.appendClassReference(null, factoryClass);
		js.append(".eINSTANCE.");
		js.append(createMethodName);
		js.append("(");
		js.appendClassReference(null, packageClass);
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
		//		if (isIncremental) {
		//			js.append("super(\"");
		//			js.append(getFunctionName(cgFunction));
		//			js.append("\");\n");
		//		}
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
					js.appendSuppressWarningsNull(false);
					js.appendIsRequired(true);
					js.append(" ");
				}
				if (elementId != null) {
					TypeDescriptor javaTypeDescriptor = context.getUnboxedDescriptor(elementId);
					js.appendClassReference(null, javaTypeDescriptor);
				}
				js.append(" " + QVTiGlobalContext.EMPTY_LIST_NAME + " = ");
				js.appendClassReference(null, Collections.class);
				js.append("." + QVTiGlobalContext.EMPTY_LIST_NAME + "();\n");
				js.append("return " + QVTiGlobalContext.EMPTY_LIST_NAME + ";\n");
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
		CGValuedElement cgBody = cgFunction.getBody();
		ElementId elementId = cgFunction.getTypeId().getElementId();
		// FIXME merge locals into AST as LetExps.
		if (cgBody != null) {
			CGValuedElement body = getExpression(cgBody);
			if (!js.appendLocalStatements(body)) {
				return false;
			}
			js.appendThis(functionName);
			js.append("." + instanceName + " = ");
			js.appendValueName(body);
			js.append(";\n");
		}
		/*	else if (QVTiCGUtil.getAST(cgFunction).getImplementationClass() != null) { -- Java Class has synthesized CGLibraryOperationCallExp
			final CGTypeId resultType = cgFunction.getTypeId();
			Function asFunction = QVTiCGUtil.getAST(cgFunction);
			TypeDescriptor functionTypeDescriptor = context.getTypeDescriptor(cgFunction).getEcoreDescriptor(context, null);
			//	js.append("/* " + localContext.getIdResolverVariable(cgFunction) + "* /");

			functionTypeDescriptor.appendBox(js, localContext, cgFunction, cgFunction);
			/*	js.appendClassReference(null, ValueUtil.class);
			js.append(".createSetValue(");
			js.appendValueName(resultType);
			js.append(", "); * /
			js.append(asFunction.getImplementationClass());
			js.append(".INSTANCE.evaluate(");
			js.append(globalContext.getExecutorName());
			js.append(", ");
			js.appendValueName(resultType);
			for (@NonNull CGParameter cgParameter : QVTiCGUtil.getParameters(cgFunction)) {
				js.append(", ");
				js.appendValueName(cgParameter);
			}
			js.append(");\n");
			js.appendThis(functionName);
			js.append("." + instanceName + " = ");
			js.appendValueName(cgFunction);
			js.append(";\n");
		} */
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
					js.appendSuppressWarningsNull(false);
					js.appendIsRequired(true);
					js.append(" ");
				}
				if (elementId != null) {
					TypeDescriptor javaTypeDescriptor = context.getUnboxedDescriptor(elementId);
					js.appendClassReference(null, javaTypeDescriptor);
				}
				js.append(" " + QVTiGlobalContext.EMPTY_LIST_NAME + " = ");
				js.appendClassReference(null, Collections.class);
				js.append("." + QVTiGlobalContext.EMPTY_LIST_NAME + "();\n");
				js.appendThis(functionName);
				js.append("." + instanceName + " = " + QVTiGlobalContext.EMPTY_LIST_NAME + ";\n");
			}
			else {			// FIXME Fudge for body-less functions
				js.appendThis(functionName);
				js.append("." + instanceName + " = \"\";\n");
			}
		}
		return true;
	}

	protected boolean doFunctionBody2(@NonNull CGFunction cgFunction, @NonNull CGShadowExp cgShadowExp, @NonNull String instanceName) {
		Function function = QVTiCGUtil.getAST(cgFunction);
		ImperativeTransformation transformation = QVTimperativeUtil.getContainingTransformation(function);
		EntryPointsAnalysis entryPointsAnalysis = context.getEntryPointsAnalysis(transformation);
		String functionName = getFunctionName(cgFunction);
		js.append(" {\n");
		js.pushIndentation(null);
		if (isIncremental) {
			js.append("super(\"");
			js.append(functionName);
			js.append("\");\n");
		}
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
			if (!doEcoreCreateClass(cgShadowExp, (EClass)eClassifier, false)) {
				return false;
			}
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
				int finalI = index++;
				SubStream castBody = new SubStream() {
					@Override
					public void append() {
						js.append("boundValues[" + finalI + "]");
					}
				};
				js.appendClassCast(cgShadowPart, castBody);
				js.append(");\n");
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
		TypedModel bestOutputTypedModel = null;
		TypedModel bestMiddleTypedModel = null;
		TypedModel bestInputTypedModel = null;
		for (@NonNull TypedModel typedModel : QVTimperativeUtil.getModelParameters(entryPointsAnalysis.getTransformation())) {
			TypedModel imperativeTypedModel = null;
			for (org.eclipse.ocl.pivot.Package usedPackage : typedModel.getUsedPackage()) {
				if (usedPackage.getESObject() == ePackage) {
					imperativeTypedModel = typedModel;
				}
			}
			if (imperativeTypedModel != null) {
				if (QVTimperativeUtil.isOutput(imperativeTypedModel)) {
					bestOutputTypedModel = imperativeTypedModel;
				}
				else if (!QVTimperativeUtil.isInput(imperativeTypedModel)) {
					bestMiddleTypedModel = imperativeTypedModel;
				}
				else {
					bestInputTypedModel = imperativeTypedModel;
				}
			}
		}
		TypedModel asTypedModel = null;
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
		if (js.isUseNullAnnotations()) {
			js.append("@SuppressWarnings(\"null\")\n");		// Accurate casts are too hard
		}
		js.append("public ");
		js.append(functionName);
		js.append("(/*Nullable*/ Object ");
		js.appendIsRequired(true);
		js.append(" [] boundValues) {\n");
		js.pushIndentation(null);
		if (isIncremental) {
			js.append("super(\"");
			js.append(functionName);
			js.append("\");\n");
		}
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
			int finalI = i++;
			SubStream castBody = new SubStream() {
				@Override
				public void append() {
					js.append("boundValues[" + finalI + "]");
				}
			};
			js.appendClassCast(cgParameter, castBody);
			js.append(";\n");
		}
		doFunctionBody(cgFunction, instanceName);
		js.popIndentation();
		js.append("}\n");
	}

	protected void doFunctionConstructor(@NonNull CGFunction cgFunction, @NonNull CGShadowExp cgShadowExp, @NonNull String instanceName) {
		//		List<@NonNull CGParameter> cgParameters = ClassUtil.nullFree(cgFunction.getParameters());
		//		if (js.isUseNullAnnotations()) {
		//			js.append("@SuppressWarnings(\"null\")\n");		// Accurate casts are too hard
		//		}
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
					js.appendClassReference(true, AbstractComputationConstructor.class);
					js.append(" " + getFunctionCtorName(cgFunction) + " = new ");
					js.appendClassReference(null, AbstractComputationConstructor.class);
					js.append("(idResolver)\n");
					js.append("{\n");
					js.pushIndentation(null);
					js.append("@Override\n");
					js.append("public ");
					js.appendIsRequired(true);
					js.append(" " + functionName + " newInstance(");
					js.appendClassReference(false, Object.class);
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
		js.appendClassReference(true, IdResolver.class);
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
		js.appendClassReference(true, IdResolver.class);
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
			//
			js.append(QVTiGlobalContext.OBJECT_MANAGER_NAME);
			js.append(".getting(");
			js.appendValueName(source);
			js.append(", ");
			appendQualifiedLiteralName(eStructuralFeature);
			js.append(", ");
			js.appendBooleanString(isOpposite);
			js.append(");\n");
		}
	}

	protected void doGot(@NonNull CGNavigationCallExp cgPropertyCallExp, @NonNull CGValuedElement source, @NonNull EStructuralFeature eStructuralFeature) {
		if (useGot) {
			//
			js.append(QVTiGlobalContext.OBJECT_MANAGER_NAME);
			js.append(".got(");
			//			if (localPrefix != null) {
			//				js.append(localPrefix);
			//				js.append(".");
			//			}
			appendThis(cgPropertyCallExp);
			js.append(", ");
			js.appendValueName(source);
			js.append(", ");
			if (!(cgPropertyCallExp instanceof CGOppositePropertyCallExp)) {
				appendQualifiedLiteralName(eStructuralFeature);
			}
			else {
				EReference eOpposite = ((EReference)eStructuralFeature).getEOpposite();
				if (eOpposite != null) {
					appendQualifiedLiteralName(eOpposite);
				}
				else {
					js.append(QVTiGlobalContext.OBJECT_MANAGER_NAME);
					js.append(".getEOppositeReference(");
					appendQualifiedLiteralName(eStructuralFeature);
					js.append(")");
				}
			}
			js.append(", ");
			js.appendValueName(cgPropertyCallExp);
			js.append(");\n");
		}
	}

	private void doInstanceCaches(@NonNull CGTransformation cgTransformation) {
		Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull CachedInstance> cachedInstances = new HashMap<>();
		for (@NonNull EObject element : new TreeIterable(cgTransformation, false)) {
			if (element instanceof CGRealizedVariable) {
				CGRealizedVariable cgRealizedVariable = (CGRealizedVariable)element;
				List<CGRealizedVariablePart> ownedParts = cgRealizedVariable.getOwnedParts();
				if (ownedParts.size() > 0) {
					CGExecutorType cgExecutorType = cgRealizedVariable.getExecutorType();
					org.eclipse.ocl.pivot.@NonNull Class asClass = (org.eclipse.ocl.pivot.Class) cgExecutorType.getAst();
					List<@NonNull CGExecutorProperty> cgProperties = new ArrayList<>();
					for (CGRealizedVariablePart ownedPart : ownedParts) {
						cgProperties.add(ownedPart.getExecutorProperty());
					}
					Collections.sort(cgProperties, NameUtil.NAMEABLE_COMPARATOR);
					NewStatement iNewStatement = QVTiCGUtil.getAST(cgRealizedVariable);
					TypedModel asTypedModel = ClassUtil.nonNullState(iNewStatement.getReferredTypedModel());
					CGTypedModel cgTypedModel = ClassUtil.nonNullState(analyzer.getTypedModel(asTypedModel));
					int modelIndex = cgTypedModel.getModelIndex();
					CachedInstance cachedInstance = cachedInstances.get(asClass);
					if (cachedInstance == null) {
						cachedInstance = new CachedInstance(asClass, cgExecutorType, cgProperties, modelIndex);
						cachedInstances.put(asClass, cachedInstance);
					}
					else {
						cachedInstance.check(cgProperties, modelIndex);
					}
				}
			}
		}
		List<org.eclipse.ocl.pivot.@NonNull Class> asClasses = new ArrayList<>(cachedInstances.keySet());
		Collections.sort(asClasses, NameUtil.NAMEABLE_COMPARATOR);
		for (org.eclipse.ocl.pivot.@NonNull Class asClass : asClasses) {
			CachedInstance cachedInstance = cachedInstances.get(asClass);
			assert cachedInstance != null;
			cachedInstance.doCachedInstance();
		}
	}

	protected void doInvocationWrapperPrefix(@NonNull Mapping invocationWrapper) {
		Integer firstPass = invocationWrapper.getFirstPass();
		if (firstPass == null) {
			js.append("invocationManager.flush();\n");	// Legacy support for auto-allocated pass numbers.
		}
		js.append("new ");
		js.appendClassReference(null, AbstractSimpleInvocation.class);
		js.append("(lazyCreateInterval(");
		//	js.appendIntegerString(firstPass != null ? firstPass : -1);
		js.append(Integer.toString(firstPass != null ? firstPass : -1));
		js.append("/*.." + invocationWrapper.getLastPass() + "*/");
		js.append("), ");
		js.appendString(PivotUtil.getName(invocationWrapper));
		js.append(") {\n");
		js.pushIndentation(null);
		js.append("@Override\n");
		js.append("public boolean execute() {\n");
		js.pushIndentation(null);
	}

	protected void doInvocationWrapperSuffix(@NonNull Mapping invocationWrapper) {
		js.append("return true;\n");
		js.popIndentation();
		js.append("}\n");
		js.popIndentation();
		js.append("};\n");
		Integer firstPass = invocationWrapper.getFirstPass();
		if (firstPass == null) {
			js.append("invocationManager.flush();\n");	// Legacy support for auto-allocated pass numbers.
		}
	}

	protected void doIsEqual(@NonNull List<@NonNull ? extends CGParameter> cgFreeVariables) {
		js.append("@Override\n");
		js.append("public boolean isEqual(");
		js.appendClassReference(true, IdResolver.class);
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

	protected void doMappingBody(@NonNull CGMapping cgMapping, @Nullable Iterable<@NonNull CGGuardVariable> cgGuardVariables) {
		CGValuedElement cgBody = cgMapping.getOwnedBody();
		js.append(" {\n");
		js.pushIndentation(null);
		if ((cgGuardVariables != null) && isGeneratedDebug) {
			js.append("if (debugInvocations) {\n");
			js.pushIndentation(null);
			js.appendClassReference(null, AbstractTransformer.class);
			js.append(".INVOCATIONS.println(\"invoke " + getMappingName(cgMapping) + "\"");
			for (@NonNull CGGuardVariable cgGuardVariable : cgGuardVariables) {
				if (!(cgGuardVariable instanceof CGConnectionVariable)) {
					js.append(" +\n\t\"\\n\\t");
					//	js.append(cgGuardVariable.getClass().getSimpleName());
					//	js.append(", ");
					js.append("\\\"" + cgGuardVariable.getName() + "\\\":\"");
					js.append(" + toDebugString(");
					js.append(getValueName(cgGuardVariable));
					js.append(")");
					Element ast = cgGuardVariable.getAst();
					if (ast instanceof TypedElement) {
						org.eclipse.ocl.pivot.Class type = PivotUtil.getClass((TypedElement)ast);
						Property trace2dispatcherProperty = NameUtil.getNameable(PivotUtil.getOwnedProperties(type), "dispatcher");
						if (trace2dispatcherProperty != null) {
							js.append(" +\n\t\"\\n\\t");
							js.append("\\\"dispatcher\\\":\"");
							js.append(" + toDebugString(");
							js.append(getValueName(cgGuardVariable));
							js.append(".getDispatcher())");
							for (Property dispatcherProperty : PivotUtil.getOwnedProperties(PivotUtil.getClass(trace2dispatcherProperty))) {
								String name = PivotUtil.getName(dispatcherProperty);
								if ((name.length() >= 2) && (name.charAt(0) == 'd') && Character.isDigit(name.charAt(1))) {
									js.append(" +\n\t\"\\n\\t");
									js.append("\\\"dispatcher." + name + "\\\":\"");
									js.append(" + toDebugString(");
									js.append(getValueName(cgGuardVariable));
									String prefix = dispatcherProperty.getTypeId() == TypeId.BOOLEAN ? "is" : "get";		// FIXME Use GenModel
									js.append(".getDispatcher()." + prefix + Character.toUpperCase(name.charAt(0)) + name.substring(1) + "())");

								}
							}
						}
					}
				}
				//				}
			}
			js.append(");\n");
			js.popIndentation();
			js.append("}\n");
		}
		//		if (cgBody.isInvalid()) {
		//			js.append("return handleExecutionFailure(\"" + getMappingName(cgMapping) + "\", ");
		//			js.appendValueName(cgBody);
		//			js.append(");\n");
		//		}
		//		else {
		//			js.append("try {\n");
		//			js.pushIndentation(null);
		if (!cgBody.isInlined()) {
			cgBody.accept(this);
		}
		//		if (cgGuardVariables != null)  {
		for (@NonNull CGGuardVariable cgGuardVariable : QVTiCGUtil.getOwnedGuardVariables(cgMapping)) {
			VariableDeclaration asGuardVariable = QVTiCGUtil.getAST(cgGuardVariable);
			if (asGuardVariable instanceof GuardParameter) {
				GuardParameter asGuardParameter = (GuardParameter)asGuardVariable;
				Property successProperty = asGuardParameter.getSuccessProperty();
				if (successProperty != null) {
					EStructuralFeature eStructuralFeature = ClassUtil.nonNullState((EStructuralFeature) successProperty.getESObject());
					String setAccessor = genModelHelper.getSetAccessor(eStructuralFeature);
					//
					js.appendValueName(cgGuardVariable);
					js.append(".");
					js.append(setAccessor);
					js.append("(");
					js.appendValueName(cgBody);
					js.append(");\n");
					//	js.append("if (");
					//	js.appendValueName(cgBody);
					//	js.append(") {\n");
					//	js.pushIndentation(null);
					doAssigned(cgGuardVariable, eStructuralFeature, cgBody);
					//	js.popIndentation();
					//	js.append("}\n");
				}
			}
		}
		//		}
		if (cgGuardVariables != null)  {
			if (isGeneratedDebug) {
				js.append("if (debugInvocations) {\n");
				js.pushIndentation(null);
				js.appendClassReference(null, AbstractTransformer.class);
				js.append(".INVOCATIONS.println((");
				js.appendValueName(cgBody);
				js.append(" ? \"done \"  : \"fail \") + \"" + getMappingName(cgMapping) + "\");\n");
				js.popIndentation();
				js.append("}\n");
			}
		}
		js.append("return ");
		js.appendValueName(cgBody);
		js.append(";\n");
		//			js.popIndentation();
		//			js.append("} catch (Throwable e) {\n");
		//			js.pushIndentation(null);
		//			js.append("return handleExecutionFailure(\"" + getMappingName(cgMapping) + "\", e);\n");
		//			js.popIndentation();
		//			js.append("}\n");
		//		}
		js.popIndentation();
		js.append("}\n");
	}

	public @NonNull Boolean doMappingCall_Class(@NonNull CGMappingCall cgMappingCall) {
		MappingCall pMappingCall = QVTiCGUtil.getAST(cgMappingCall);
		Mapping pReferredMapping = QVTimperativeUtil.getReferredMapping(pMappingCall);
		CGMapping cgReferredMapping = analyzer.getMapping(pReferredMapping);
		assert cgReferredMapping != null;
		Iterable<@NonNull CGMappingCallBinding> cgMappingCallBindings = QVTiCGUtil.getOwnedMappingCallBindings(cgMappingCall);
		//
		//	Set loopVariable non-null if it needs to be type-checked and cast to a narrower type.
		//
		for (@NonNull CGMappingCallBinding cgMappingCallBinding : cgMappingCallBindings) {
			CGValuedElement ownedValue = cgMappingCallBinding.getOwnedValue();
			TypeDescriptor checkedType = needsTypeCheck(cgMappingCallBinding);
			if (checkedType != null) {
				js.append("if (");
				js.appendValueName(ownedValue);
				js.append(" instanceof ");
				js.appendClassReference(null, checkedType);
				js.append(") {\n");
				js.pushIndentation(null);
			}
			else if (!ownedValue.isNonNull()) {
				Element asMappingParameterBinding = cgMappingCallBinding.getAst();
				if (!(asMappingParameterBinding instanceof GuardParameterBinding)) {		// FIXME this should be part of isNonNull
					js.append("if (");
					js.appendValueName(ownedValue);
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
					js.appendClassReference(null, checkedType);
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
			else if (!cgMappingCallBinding.getOwnedValue().isNonNull()) {
				Element asMappingParameterBinding = cgMappingCallBinding.getAst();
				if (!(asMappingParameterBinding instanceof GuardParameterBinding)) {		// FIXME this should be part of isNonNull
					js.popIndentation();
					js.append("}\n");
				}
			}
		}
		return true;
	}

	public @NonNull Boolean doMappingCall_Function(@NonNull CGMappingCall cgMappingCall) {
		MappingCall pMappingCall = QVTiCGUtil.getAST(cgMappingCall);
		Mapping pReferredMapping = QVTimperativeUtil.getReferredMapping(pMappingCall);
		if (invocationWrapper == null) {
			doInvocationWrapperPrefix(pReferredMapping);
		}
		CGMapping cgReferredMapping = analyzer.getMapping(pReferredMapping);
		assert cgReferredMapping != null;
		Iterable<@NonNull CGMappingCallBinding> cgMappingCallBindings = QVTiCGUtil.getOwnedMappingCallBindings(cgMappingCall);
		//
		//	Set loopVariable non-null if it needs to be type-checked and cast to a narrower type.
		//
		for (@NonNull CGMappingCallBinding cgMappingCallBinding : cgMappingCallBindings) {
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
					js.appendClassReference(null, checkedType);
					js.append(") {\n");
					js.pushIndentation(null);
				}
				else if (!cgMappingCallBinding.getOwnedValue().isNonNull()) {
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
		for (@NonNull CGMappingCallBinding cgMappingCallBinding : cgMappingCallBindings) {
			if (!isFirst) {
				js.append(", ");
			}
			TypeDescriptor checkedType = needsTypeCheck(cgMappingCallBinding);
			if (checkedType != null) {
				js.append("(");
				js.appendClassReference(null, checkedType);
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
		for (@NonNull CGMappingCallBinding cgMappingCallBinding : cgMappingCallBindings) {
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
			else if (!cgMappingCallBinding.getOwnedValue().isNonNull()) {
				js.popIndentation();
				js.append("}\n");
			}
			}
		}
		if (invocationWrapper == null) {
			doInvocationWrapperSuffix(pReferredMapping);
		}
		return true;
	}

	protected void doMappingConnectionVariable(@NonNull CGGuardVariable cgFreeVariable) {
		if (cgFreeVariable instanceof CGConnectionVariable) {
			js.append("final ");
			js.appendClassReference(true, isIncremental ? Connection.Incremental.class : Connection.class);
			js.append(" ");
			js.append(getValueName(cgFreeVariable));
		}
		else{
			js.getBoxedTypeRepresentation().appendDeclaration(cgFreeVariable);
		}
	}

	protected void doMappingConstructor(@NonNull CGMapping cgMapping) {
		Iterable<@NonNull CGGuardVariable> cgGuardVariables = QVTiCGUtil.getOwnedGuardVariables(cgMapping);
		//		if (js.isUseNullAnnotations()) {
		//			js.append("@SuppressWarnings(\"null\")\n");		// Accurate casts are too hard
		//		}
		js.append("public ");
		js.append(getMappingName(cgMapping));
		js.append("(");
		js.appendClassReference(true, isIncremental ? InvocationConstructor.Incremental.class : InvocationConstructor.class);
		js.append(" ");
		js.append(QVTiGlobalContext.CONSTRUCTOR_NAME);
		if (isIncremental) {
			js.append(", int ");
			js.append(QVTiGlobalContext.INVOCATION_HASH_CODE_NAME);
		}
		js.append(", ");
		js.appendIsRequired(true);
		js.append(" Object ");
		js.appendIsRequired(true);
		js.append(" [] boundValues) {\n");
		js.pushIndentation(null);
		//		if (isIncremental) {
		js.append("super(");
		js.append(QVTiGlobalContext.CONSTRUCTOR_NAME);
		if (isIncremental) {
			js.append(", ");
			js.append(QVTiGlobalContext.INVOCATION_HASH_CODE_NAME);
		}
		js.append(");\n");
		//
		int i = 0;
		for (@NonNull CGGuardVariable cgGuardVariable : cgGuardVariables) {
			String valueName = getValueName(cgGuardVariable);
			js.append(valueName);
			js.append(" = ");
			//							js.appendClassCast(cgFreeVariable);
			int finalI = i++;
			SubStream castBody = new SubStream() {
				@Override
				public void append() {
					js.append("boundValues[" + finalI + "]");
				}
			};
			if (cgGuardVariable instanceof CGConnectionVariable) {
				js.append("(");
				//				js.appendClassReference(null, cgFreeVariable);
				//				js.append(".Accumulator)");						// FIXME Embed properly as a nested typeid
				js.appendClassReference(null, isIncremental ? Connection.Incremental.class : Connection.class);
				js.append(")");						// FIXME Embed properly as a nested typeid
				castBody.append();
			}
			else{
				js.appendClassCast(cgGuardVariable, castBody);
			}
			js.append(";\n");
		}
		js.popIndentation();
		js.append("}\n");
	}

	protected void doMappingConstructorConstants(/*@NonNull*/ List<@NonNull CGMapping> cgMappings) {
		for (@NonNull CGMapping cgMapping : cgMappings) {
			if (useClass(cgMapping)) {// && (isIncremental || (cgMapping.getFreeVariables().size() > 0))) {
				Mapping asMapping = QVTiCGUtil.getAST(cgMapping);
				Class<?> constructorClass = isIncremental ? AbstractInvocationConstructor.Incremental.class : AbstractInvocationConstructor.class;
				js.append("protected final ");
				js.appendClassReference(true, constructorClass);
				js.append(" " + getMappingCtorName(cgMapping) + " = new ");
				js.appendClassReference(null, constructorClass);
				js.append("(invocationManager, ");
				js.appendString(QVTiCGUtil.getName(cgMapping));
				if (!isIncremental) {
					js.append(", ");
					js.appendBooleanString(QVTiCGUtil.getAST(cgMapping).isIsStrict());
				}
				js.append(", lazyCreateInterval(");
				Integer firstPass = asMapping.getFirstPass();
				//	js.appendIntegerString(firstPass != null ? firstPass : -1);
				js.append(Integer.toString(firstPass != null ? firstPass : -1));
				js.append("))\n");
				js.append("{\n");
				js.pushIndentation(null);
				js.append("@Override\n");
				js.append("public ");
				js.appendIsRequired(true);
				js.append(" " + getMappingName(cgMapping) + " newInstance(");
				if (isIncremental) {
					js.append("int ");
					js.append(QVTiGlobalContext.INVOCATION_HASH_CODE_NAME);
					js.append(", ");
				}
				js.appendClassReference(true, Object.class);
				js.append(" ");
				js.appendIsRequired(true);
				js.append(" [] values) {\n");
				js.pushIndentation(null);
				js.append("return new " + getMappingName(cgMapping) + "(");
				js.append("this");
				if (isIncremental) {
					js.append(", ");
					js.append(QVTiGlobalContext.INVOCATION_HASH_CODE_NAME);
				}
				js.append(", ");
				js.append("values);\n");
				js.popIndentation();
				js.append("}\n");
				js.popIndentation();
				js.append("};\n\n");
			}
		}
	}

	protected void doMappingDestroy(@NonNull CGMapping cgMapping) {
		js.append("/*\n");
		js.append(" * Eliminate all trace of the construction and execution of this invocation.\n");
		js.append(" */\n");
		js.append("@Override\n");
		js.append("public synchronized void destroy() {\n");
		js.pushIndentation(null);
		js.append("/*\n");
		js.append(" * Remove this invocation from the invocation cache.\n");
		js.append(" * Revoke all object property assignments.\n");
		js.append(" * Revoke all consumed input objects.\n");
		js.append(" */\n");
		js.append("super.destroy();\n");
		/*		Iterable<@NonNull CGGuardVariable> ownedGuardVariables = QVTiCGUtil.getOwnedGuardVariables(cgMapping);
		if (!Iterables.isEmpty(ownedGuardVariables)) {
			boolean firstConsume = true;
			int i = 0;
			for (@NonNull CGGuardVariable cgGuardVariable : ownedGuardVariables) {
				if (!(cgGuardVariable instanceof CGConnectionVariable)) {
					if (firstConsume) {
						js.append("/*\n");
						js.append(" * Revoke all consumed input objects.\n");
						js.append(" * /\n");
						js.appendClassReference(List.class, Connection.Incremental.class);
						js.append(" consumedConnections = ");
						js.append(QVTiGlobalContext.CONSTRUCTOR_NAME);
						js.append(".getConsumedConnections();\n");
						firstConsume = false;
					}
					js.append("consumedConnections.get(" + i++ + ").revokeConsumer(");
					js.appendValueName(cgGuardVariable);
					js.append(", this);\n");
				}
			}
		} */
		boolean firstAppend = true;
		for (@NonNull EObject eObject : new TreeIterable(cgMapping, false)) {
			if (eObject instanceof CGConnectionAssignment) {
				if (firstAppend) {
					js.append("/*\n");
					js.append(" * Revoke all appended output objects.\n");
					js.append(" */\n");
					firstAppend = false;
				}
				CGConnectionAssignment cgConnectionAssignment = (CGConnectionAssignment)eObject;
				js.append("if (this.");
				js.appendValueName(cgConnectionAssignment);
				js.append(" != null) {\n");
				js.pushIndentation(null);
				js.append("this.");
				js.appendValueName(cgConnectionAssignment.getConnectionVariable());
				js.append(".revoke(");
				js.appendValueName(cgConnectionAssignment);
				js.append(");\n");
				js.append("this.");
				js.appendValueName(cgConnectionAssignment);
				js.append(" = null;\n");
				js.popIndentation();
				js.append("}\n");
			}
		}
		Iterable<@NonNull CGRealizedVariable> ownedRealizedVariables = QVTiCGUtil.getOwnedRealizedVariables(cgMapping);
		if (!Iterables.isEmpty(ownedRealizedVariables)) {
			js.append("/*\n");
			js.append(" * Destroy all created objects.\n");
			js.append(" */\n");
			for (@NonNull CGRealizedVariable cgRealizedVariable : ownedRealizedVariables) {
				CGTypedModel cgTypedModel = cgRealizedVariable.getTypedModel();
				//
				js.appendClassReference(null, cgRealizedVariable);
				js.append(" ");
				js.appendValueName(cgRealizedVariable);
				js.append(" = this.");
				js.appendValueName(cgRealizedVariable);
				js.append(";\n");
				js.append("if (");
				js.appendValueName(cgRealizedVariable);
				js.append(" != null) {\n");
				js.pushIndentation(null);
				js.append("((");
				js.appendClassReference(null, RuntimeModelsManager.Model.Incremental.class);
				js.append(")");
				js.append(QVTiGlobalContext.MODELS_NAME);
				js.append("[");
				appendModelIndex(cgTypedModel);
				js.append("]).remove(");
				js.appendValueName(cgRealizedVariable);
				js.append(");\n");
				js.append(QVTiGlobalContext.OBJECT_MANAGER_NAME);
				js.append(".destroyed(");
				js.appendValueName(cgRealizedVariable);
				js.append(");\n");
				js.append("this.");
				js.appendValueName(cgRealizedVariable);
				js.append(" = null;\n");
				js.popIndentation();
				js.append("}\n");
			}
		}
		js.popIndentation();
		js.append("}\n");
	}

	protected boolean doMappingFields(@NonNull CGMapping cgMapping) {
		boolean needsNewLine = false;
		for (@NonNull CGGuardVariable cgVariable : ClassUtil.nullFree(cgMapping.getOwnedGuardVariables())) {
			js.append("protected ");
			doMappingConnectionVariable(cgVariable);
			js.append(";\n");
			needsNewLine = true;
		}
		if (isIncremental) {
			for (@NonNull CGRealizedVariable cgVariable : QVTiCGUtil.getOwnedRealizedVariables(cgMapping)) {
				js.append("protected ");
				js.appendClassReference(false, cgVariable);
				js.append(" ");
				js.appendValueName(cgVariable);
				if (isIncremental) {
					js.append(" = null");
				}
				js.append(";\n");
				needsNewLine = true;
			}
			for (@NonNull EObject eObject : new TreeIterable(cgMapping, false)) {
				if (eObject instanceof CGConnectionAssignment) {
					CGConnectionAssignment cgConnectionAssignment = (CGConnectionAssignment)eObject;
					js.append("protected ");
					js.appendClassReference(false, Object.class);
					js.append(" ");
					js.appendValueName(cgConnectionAssignment);
					js.append(" = null;\n");
					needsNewLine = true;
				}
			}
		}
		return needsNewLine;
	}

	protected void doMappingGetBoundValue(@NonNull CGMapping cgMapping) {
		Iterable<@NonNull CGGuardVariable> cgGuardVariables = QVTiCGUtil.getOwnedGuardVariables(cgMapping);
		js.append("/*\n");
		js.append(" * Return the index'th bound value.\n");
		js.append(" */\n");
		js.append("@Override\n");
		js.append("public ");
		js.appendClassReference(true, Object.class);
		js.append(" getBoundValue(int index) {\n");
		js.pushIndentation(null);
		js.append("switch(index) {\n");
		js.pushIndentation(null);
		int i = 0;
		for (@NonNull CGGuardVariable cgGuardVariable : cgGuardVariables) {
			String valueName = getValueName(cgGuardVariable);
			js.append("case " + i++ + ": return ");
			js.append(valueName);
			js.append(";\n");
		}
		js.popIndentation();
		js.append("}\n");
		js.append("throw new ");
		js.appendClassReference(null, IllegalArgumentException.class);
		js.append("();\n");
		js.popIndentation();
		js.append("}\n");
	}

	protected void doMappingGetBoundValues(@NonNull CGMapping cgMapping) {
		Iterable<@NonNull CGGuardVariable> cgGuardVariables = QVTiCGUtil.getOwnedGuardVariables(cgMapping);
		js.append("/*\n");
		js.append(" * Return the number of bound values.\n");
		js.append(" */\n");
		js.append("@Override\n");
		js.append("public int getBoundValues() {\n");
		js.pushIndentation(null);
		js.append("return " + Iterables.size(cgGuardVariables) + ";\n");
		js.popIndentation();
		js.append("}\n");
	}

	protected void doMappingSuccess(@NonNull CGMappingExp cgMappingExp) {
		//		CGMapping cgMapping = QVTiCGUtil.getContainingCGMapping(cgMappingExp);
		//		CGValuedElement cgBody = cgMapping.getOwnedBody();
		//		CGGuardVariable cgTraceParameter = QVTiCGUtil.getTraceParameter(cgMapping);
		//		if (cgTraceParameter == null) {
		js.appendDeclaration(cgMappingExp);
		js.append(" = ");
		js.appendClassReference(null, ValueUtil.class);
		js.append(".TRUE_VALUE;\n");
		//		}
		//		else {
		//			js.appendDeclaration(cgMappingExp);
		//			js.append(" = ");
		//			//			js.appendValueName(cgBody);
		//			//			js.append(" && ");
		//			js.append(QVTiGlobalContext.OBJECT_MANAGER_NAME);
		//			js.append(".addSpeculation(");
		//			js.appendValueName(cgTraceParameter);
		//			for (@NonNull CGGuardVariable cgGuardVariable : QVTiCGUtil.getOwnedGuardVariables(cgMapping)) {
		//				js.append(", ");
		//				js.appendValueName(cgGuardVariable);
		//			}
		//			js.append(");\n");
		/*			js.append("if (");
			js.appendValueName(cgMappingExp);
			js.append(") {\n");
			js.pushIndentation(null);
			if (isGeneratedDebug) {
				js.append("if (debugInvocations) {\n");
				js.pushIndentation(null);
				js.appendClassReference(null, AbstractTransformer.class);
				js.append(".INVOCATIONS.println(\"done " + getMappingName(cgMapping) + "\");\n");
				js.popIndentation();
				js.append("}\n");
			}
			js.popIndentation();
			js.append("}\n");
			js.append("else {\n");
			js.pushIndentation(null);
			if (isGeneratedDebug) {
				js.append("if (debugInvocations) {\n");
				js.pushIndentation(null);
				js.appendClassReference(null, AbstractTransformer.class);
				js.append(".INVOCATIONS.println(\"speculating " + getMappingName(cgMapping) + "\");\n");
				js.popIndentation();
				js.append("}\n");
			}
			js.popIndentation();
			js.append("}\n"); */
		/*			js.append("if (debugInvocations) {\n");
			js.pushIndentation(null);
			js.appendClassReference(null, AbstractTransformer.class);
			js.append(".INVOCATIONS.println((");
			js.appendValueName(cgMappingExp);
			js.append(" ? \"done \"  : \"speculating \") + \"" + getMappingName(cgMapping) + "\");\n");
			js.popIndentation();
			js.append("}\n"); */
		//		}
	}

	protected void doOppositeCaches(@NonNull EntryPointsAnalysis entryPointsAnalysis) {
		Map<@NonNull Property, @NonNull Integer> opposites = entryPointsAnalysis.getCaches();
		if (opposites.size() <= 0) {
			return;
		}
		js.append("\n/*\n * Property-source to Property-target unnavigable navigation caches\n */\n");
		Map<@NonNull String, @NonNull Property> key2property = new HashMap<>();
		for (Map.Entry<@NonNull Property, @NonNull Integer> entry : opposites.entrySet()) {
			Property property = entry.getKey();
			String name = getGlobalContext().addOppositeProperty(property);

			key2property.put(name, property);
		}
		List<String> sortedKeys = new ArrayList<>(key2property.keySet());
		Collections.sort(sortedKeys);
		for (String key : sortedKeys) {
			Property property = key2property.get(key);
			assert property != null;
			TypeDescriptor outerTypeDescriptor = context.getBoxedDescriptor(property.getOwningClass().getTypeId());
			TypeDescriptor middleTypeDescriptor = context.getBoxedDescriptor(PivotUtil.getElementalType(PivotUtil.getType(property)).getTypeId());
			js.append("protected final ");
			js.appendIsRequired(true);
			js.append(" ");
			js.appendClassReference(null, Map.class, false, middleTypeDescriptor, outerTypeDescriptor);
			js.append(" ");
			js.append(key);
			js.append(" = new ");
			js.appendClassReference(null, HashMap.class, false, new @NonNull TypeDescriptor[] {});
			js.append("();\n");
		}
	}

	protected @Nullable String doOppositePropertyIds(@NonNull EntryPointsAnalysis entryPointsAnalysis) {
		// This code is no longer used, and since it is not used it generates undefined references
		// It appears to have 'worked' only because a duplicate incomplete TransformationAnalysis was in use.
		Map<@NonNull Property, @NonNull Integer> opposites = entryPointsAnalysis.getCaches();
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
		String oppositeIndex2propertyIdName = getGlobalContext().getOppositeIndex2propertyIdName();
		js.append("private static final ");
		js.appendClassReference(true, PropertyId.class);
		js.append(" ");
		js.appendIsRequired(true);
		js.append(" [] ");
		js.append(oppositeIndex2propertyIdName);
		js.append(" = new ");
		js.appendClassReference(true, PropertyId.class);
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

	protected void doRun(@NonNull CGTransformation cgTransformation, @Nullable List<@Nullable AllInstancesAnalysis> allInstancesAnalyses) {
		CompleteModelInternal completeModel = environmentFactory.getCompleteModel();
		Map<@NonNull TypedModel, @NonNull CGTypedModel> asTypedModel2cgTypedModel = new HashMap<>();
		ImperativeTransformation asTransformation = QVTiCGUtil.getAST(cgTransformation);
		List<@NonNull TypedModel> asTypedModels = QVTimperativeUtil.Internal.getModelParameterList(asTransformation);
		for (@NonNull CGTypedModel cgTypedModel : QVTiCGUtil.getOwnedTypedModels(cgTransformation)) {
			TypedModel asTypedModel = QVTiCGUtil.getAST(cgTypedModel);
			asTypedModel2cgTypedModel.put(asTypedModel, cgTypedModel);
		}
		List<@NonNull CGMapping> cgRootMappings = new ArrayList<>();
		//		CGMapping cgRootMapping = NameUtil.getNameable(cgTransformation.getOwnedMappings(), QVTscheduleConstants.ROOT_MAPPING_NAME);	// Obsolete relic
		for (@NonNull CGMapping cgMapping : QVTiCGUtil.getOwnedMappings(cgTransformation)) {
			Mapping asMapping = QVTiCGUtil.getAST(cgMapping);
			if (asMapping instanceof EntryPoint) {
				cgRootMappings.add(cgMapping);
			}
		}
		Collections.sort(cgRootMappings, new Comparator<@NonNull CGMapping>() {

			@Override
			public int compare(@NonNull CGMapping o1, @NonNull CGMapping o2) {
				EntryPoint asEntryPoint1 = (EntryPoint) QVTiCGUtil.getAST(o1);
				EntryPoint asEntryPoint2 = (EntryPoint) QVTiCGUtil.getAST(o2);
				List<TypedModel> asOutputTypedModels1 = asEntryPoint1.getOutputTypedModels();
				List<TypedModel> asOutputTypedModels2 = asEntryPoint2.getOutputTypedModels();
				TypedModel asTypedModel1 = asOutputTypedModels1.size() > 0 ? asOutputTypedModels1.get(0) : null;
				TypedModel asTypedModel2 = asOutputTypedModels2.size() > 0 ? asOutputTypedModels2.get(0) : null;
				int index1 = asTypedModels.indexOf(asTypedModel1);
				int index2 = asTypedModels.indexOf(asTypedModel2);
				return index1 - index2;
			}});
		boolean isMultiDirectional = cgRootMappings.size() > 1;
		js.append("@Override\n");
		js.append("public boolean run(");
		js.appendClassReference(true, String.class);
		js.append(" targetName");
		js.append(") {\n");
		js.pushIndentation(null);
		if (!isMultiDirectional) {
			js.append("return run();\n");
			js.popIndentation();
			js.append("}\n");
			js.append("\n");
			js.append("@Override\n");
			js.append("public boolean run() {\n");
			js.pushIndentation(null);
		}
		if (isMultiDirectional) {
			js.append("switch (targetName) {\n");
			js.pushIndentation(null);
		}
		for (@NonNull CGMapping cgRootMapping : cgRootMappings) {
			EntryPoint asEntryPoint = (EntryPoint) QVTiCGUtil.getAST(cgRootMapping);
			if (isMultiDirectional) {
				List<TypedModel> asOutputTypedModels = asEntryPoint.getOutputTypedModels();
				if (asOutputTypedModels.size() > 0) {
					js.append("case \"");
					js.append(asEntryPoint.getTargetName());
					js.append("\": {\n");
					js.pushIndentation(null);
				}
				else {
					continue;		// Avoid generating code for not-enforceable TypedModel
				}
			}
			ImperativeTransformation transformation = QVTiCGUtil.getAST(cgTransformation);
			EntryPointsAnalysis entryPointsAnalysis = context.getEntryPointsAnalysis(transformation);
			EntryPointAnalysis entryPointAnalysis = entryPointsAnalysis.getEntryPointAnalysis(asEntryPoint);
			Iterable<@NonNull EAttribute> eAttributes = entryPointAnalysis.getSpeculatedEAttributes();
			if ((eAttributes != null) && !Iterables.isEmpty(eAttributes)) {
				js.append("initSpeculatedEAttributes(");
				boolean isFirst = true;
				for (@NonNull EAttribute eAttribute : eAttributes) {
					if (!isFirst) {
						js.append(",\n\t\t\t\t\t\t");
					}
					else {
						isFirst = false;
					}
					appendQualifiedLiteralName(eAttribute);
				}
				js.append(");\n");
			}
			for (@NonNull CGGuardVariable cgGuardVariable : QVTiCGUtil.getOwnedGuardVariables(cgRootMapping)) {
				//			js.appendDeclaration(cgGuardVariable);
				js.append("final ");
				js.appendClassReference(true, Connection.class);
				js.append(" ");
				js.appendValueName(cgGuardVariable);
				js.append(" = ");
				js.append(QVTiGlobalContext.MODELS_NAME);
				js.append("[");
				VariableDeclaration asGuardVariable = QVTiCGUtil.getAST(cgGuardVariable);
				Type type = QVTimperativeUtil.getType(asGuardVariable);
				org.eclipse.ocl.pivot.Package asPackage = PivotUtil.getContainingPackage(type);
				assert asPackage != null;
				AllInstancesAnalysis allInstancesAnalysis = null;
				CGTypedModel cgTypedModel = null;
				for (@NonNull TypedModel asTypedModel : QVTimperativeUtil.getInputTypedModels(asEntryPoint)) {
					if (asTypedModel.getUsedPackage().contains(asPackage)) {
						assert cgTypedModel == null;
						cgTypedModel = asTypedModel2cgTypedModel.get(asTypedModel);
						assert cgTypedModel != null;
					}
				}
				if (cgTypedModel != null) {
					appendModelIndex(cgTypedModel);
					assert allInstancesAnalyses != null;
					allInstancesAnalysis = allInstancesAnalyses.get(cgTypedModel.getModelIndex());
				}
				js.append("].getConnection(");
				assert allInstancesAnalysis != null;
				CompleteClass completeType = completeModel.getCompleteClass(type);
				Integer classIndex = allInstancesAnalysis.getInstancesCompleteClass2index().get(completeType);
				js.append(classIndex + "/*" + type + "*/");
				js.append(");\n");
			}
			if (isIncremental || useClass(cgRootMapping)) {
				js.append(getMappingCtorName(cgRootMapping) + ".invoke(");
			}
			else {
				js.append("return ");
				js.append(getMappingName(cgRootMapping));
				js.append("(");
			}
			boolean isFirst = true;
			for (@NonNull CGGuardVariable cgGuardVariable : QVTiCGUtil.getOwnedGuardVariables(cgRootMapping)) {
				if (!isFirst) {
					js.append(", ");
				}
				js.appendValueName(cgGuardVariable);
				isFirst = false;
			}
			js.append(")");
			if (isIncremental || useClass(cgRootMapping)) {
				js.append(";\n");
				js.append("return invocationManager.flush();\n");
			}
			else {
				js.append(" && invocationManager.flush();\n");
			}
			if (isMultiDirectional) {
				js.popIndentation();
				js.append("}\n");
			}
		}
		if (isMultiDirectional) {
			js.append("default: {\n");
			js.pushIndentation(null);
			js.append("throwInvalidEvaluationException(\"Unsupported target name \'\'{0}\'\'\", targetName);\n");
			js.append("return false;\n");
			js.popIndentation();
			js.append("}\n");
			js.popIndentation();
			js.append("}\n");
		}
		js.popIndentation();
		js.append("}\n");
	}

	protected void doTransformationExecution(@NonNull CGTransformation cgTransformation) {
		ImperativeTransformation iTransformation = QVTiCGUtil.getAST(cgTransformation);
		Type contextType = iTransformation.getContextType();
		if (contextType != null) {
			EClass eClass = (EClass) contextType.getESObject();
			if (eClass != null) {										// QVTc / manual QVTi has no trace EClass
				String createMethodName = "create" + eClass.getName();
				EPackage ePackage = eClass.getEPackage();
				assert ePackage != null;
				String javaFactory = genModelHelper.getQualifiedFactoryInterfaceName(ePackage);
				String javaClass = genModelHelper.getEcoreInterfaceClassifierName(eClass);
				js.append("private ");
				js.appendClassReference(false, javaClass);
				js.append(" " + QVTiGlobalContext.TRANSFORMATION_EXECUTION_NAME + " = null;\n");
				js.append("\n");
				js.append("public ");
				js.appendClassReference(true, javaClass);
				js.append(" " + QVTiGlobalContext.GET_TRANSFORMATION_EXECUTION_NAME + "() {\n");
				js.pushIndentation(null);
				js.append("if (" + QVTiGlobalContext.TRANSFORMATION_EXECUTION_NAME + " == null) {\n");
				js.pushIndentation(null);
				js.append(QVTiGlobalContext.TRANSFORMATION_EXECUTION_NAME + " = ");
				js.appendClassReference(null, javaFactory);
				js.append(".eINSTANCE.");
				js.append(createMethodName);
				js.append("();\n");
				js.popIndentation();
				js.append("}\n");
				js.append("return " + QVTiGlobalContext.TRANSFORMATION_EXECUTION_NAME + ";\n");
				js.popIndentation();
				js.append("}\n");
				js.append("\n");
			}
		}
	}

	protected @NonNull Class<? extends Transformer> getAbstractTransformationExecutorClass() {
		return isIncremental ? AbstractTransformer.Incremental.class : AbstractTransformer.class;
	}

	@Override
	public @NonNull QVTiAnalyzer getAnalyzer() {
		return (QVTiAnalyzer) super.getAnalyzer();
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

	protected @NonNull String getFunctionCtorName(@NonNull CGFunction cgFunction) {
		return JavaStream.convertToJavaIdentifier("FTOR_" + cgFunction.getName());
	}

	protected @NonNull String getFunctionInstanceName(@NonNull CGFunction cgFunction) {
		JavaLocalContext<@NonNull ?> functionContext = ClassUtil.nonNullState(globalContext.getLocalContext(cgFunction));
		Object instanceKey = cgFunction.getBody();
		if (instanceKey == null) {
			instanceKey = QVTiCGUtil.getAST(cgFunction).getImplementationClass();
		}
		return functionContext.getNameManager().getValueName(instanceKey, "instance");
	}

	protected @NonNull String getFunctionName(@NonNull CGFunction cgFunction) {
		return JavaStream.convertToJavaIdentifier("FUN_" + cgFunction.getName());
	}

	protected @NonNull QVTiGlobalContext getGlobalContext() {
		return (QVTiGlobalContext) globalContext;
	}

	private @Nullable Mapping getInvocationWrapper(@NonNull CGValuedElement cgValue) {
		Mapping mapping = null;
		if (cgValue instanceof CGSequence) {
			for (@NonNull CGValuedElement cgStatement : QVTiCGUtil.getOwnedStatements((CGSequence) cgValue)) {
				mapping = getInvocationWrapper(cgStatement);
				if (mapping != null) {
					return mapping;
				}
			}
		}
		else if (cgValue instanceof CGMappingLoop) {
			return getInvocationWrapper(QVTiCGUtil.getBody((CGMappingLoop)cgValue));
		}
		else if (cgValue instanceof CGLetExp) {
			return getInvocationWrapper(QVTiCGUtil.getIn((CGLetExp)cgValue));
		}
		else if (cgValue instanceof CGMappingCall) {
			MappingCall pMappingCall = QVTiCGUtil.getAST((CGMappingCall)cgValue);
			Mapping pReferredMapping = QVTimperativeUtil.getReferredMapping(pMappingCall);
			CGMapping cgReferredMapping = analyzer.getMapping(pReferredMapping);
			assert cgReferredMapping != null;
			if (!useClass(cgReferredMapping)) {
				return pReferredMapping;
			}
		}
		return null;
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

	protected @NonNull String getMappingCtorName(@NonNull CGMapping cgMapping) {
		return JavaStream.convertToJavaIdentifier("CTOR_" + cgMapping.getName());
	}

	protected @NonNull String getMappingName(@NonNull CGMapping cgMapping) {
		return JavaStream.convertToJavaIdentifier("MAP_" + cgMapping.getName());
	}

	protected @NonNull String getNativeInstanceClassName(@NonNull CGExecutorType cgType) {
		Element ast = cgType.getAst();
		return JavaStream.convertToJavaIdentifier("ICACHE_" + ((NamedElement)ast).getName());
	}

	protected @NonNull String getNativeInstanceInstanceName(@NonNull CGExecutorType cgType) {
		return "INSTANCE_" + getNativeInstanceClassName(cgType);
	}

	@Deprecated
	protected @NonNull String getThisName(@NonNull CGElement cgElement) {
		for (EObject eObject = cgElement; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof CGMapping) {
				return getMappingName((CGMapping)eObject);		// + ".this"
			}
			if (eObject instanceof CGFunction) {
				return getFunctionName((CGFunction)eObject);		// + ".this"
			}
			if (eObject instanceof CGClass) {
				return ClassUtil.nonNullState(((CGClass)eObject).getName());		// + ".this"
			}
		}
		assert false;
		return "";		// "this" */
	}

	private boolean isConnection(CGValuedElement source) {
		return (source.getAst() instanceof VariableExp) && (((VariableExp)source.getAst()).getReferredVariable() instanceof ConnectionVariable);
	}

	private boolean isHazardous2(@NonNull NavigationCallExp asNavigationCallExp) {
		for (EObject eObject = asNavigationCallExp; eObject != null; eObject = getContainer(eObject)) {
			if (eObject instanceof ObservableStatement) {
				List<Property> observedProperties = ((ObservableStatement)eObject).getObservedProperties();
				Property navigatedProperty = PivotUtil.getReferredProperty(asNavigationCallExp);
				if (observedProperties.contains(navigatedProperty)) {
					return true;
				}
				Property navigatedOppositeProperty = navigatedProperty.getOpposite();
				if (observedProperties.contains(navigatedOppositeProperty)) {
					return true;
				}
				break;
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
		CGValuedElement initValue = QVTiCGUtil.getOwnedInitValue(cgConnectionAssignment);
		if (!js.appendLocalStatements(initValue)) {
			return false;
		}
		final String iteratorName = getSymbolName(null, "iterator");
		TypeId concreteElementTypeId = cgConnectionAssignment.getConnectionVariable().getASTypeId();
		assert concreteElementTypeId != null;
		BoxedDescriptor concreteBoxedDescriptor = context.getBoxedDescriptor(concreteElementTypeId);
		BoxedDescriptor abstractBoxedDescriptor = concreteBoxedDescriptor;
		if (!(initValue.getASTypeId() instanceof CollectionTypeId)) {
			if (isIncremental) {
				js.appendValueName(cgConnectionAssignment);
				js.append(" = ");
			}
			js.appendReferenceTo(cgConnectionAssignment.getConnectionVariable());
			js.append(".appendElement(");
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
				js.appendClassReference(null, ValueUtil.class);
				js.append(".typedIterable(");
				js.appendClassReference(null, abstractBoxedDescriptor);
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
				js.appendClassReference(null, concreteBoxedDescriptor);
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
		EStructuralFeature eStructuralFeature = QVTiCGUtil.getEStructuralFeature(cgPropertyAssignment);
		CGValuedElement cgSlot = getExpression(QVTiCGUtil.getOwnedSlotValue(cgPropertyAssignment));
		CGValuedElement cgInit = getExpression(QVTiCGUtil.getOwnedInitValue(cgPropertyAssignment));
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
		SetStatement asSetStatement = QVTiCGUtil.getAST(cgPropertyAssignment);
		EStructuralFeature eStructuralFeature = QVTiCGUtil.getEStructuralFeature(cgPropertyAssignment);
		CGValuedElement cgSlot = getExpression(QVTiCGUtil.getOwnedSlotValue(cgPropertyAssignment));
		CGValuedElement cgInit = getExpression(QVTiCGUtil.getOwnedInitValue(cgPropertyAssignment));
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
		boolean isPartial = asSetStatement.isIsPartial();
		appendEcoreSet(cgSlot, eStructuralFeature, cgInit, isPartial);
		doAssigned(cgPropertyAssignment, isPartial);
		return true;
	}

	@Override
	public @NonNull Boolean visitCGEcorePropertyCallExp(@NonNull CGEcorePropertyCallExp cgPropertyCallExp) {
		CGValuedElement cgSource = getExpression(cgPropertyCallExp.getSource());
		if (!js.appendLocalStatements(cgSource)) {
			return false;
		}
		ElementId sourceTypeId = cgSource.getTypeId().getElementId();
		ImperativeTransformation iTransformation = getAnalyzer().getCodeGenerator().getTransformation();
		org.eclipse.ocl.pivot.Class runtimeContextClass = QVTimperativeUtil.getRuntimeContextClass(iTransformation);
		TypeId runtimeContextTypeId = runtimeContextClass.getTypeId();
		if (sourceTypeId == runtimeContextTypeId) {		// FIXME make transformationInstance regular - cloned from appendCGEcorePropertyCallExp
			Property asProperty = ClassUtil.nonNullState(cgPropertyCallExp.getReferredProperty());
			EStructuralFeature eStructuralFeature = ClassUtil.nonNullState(getESObject(asProperty));
			String getAccessor = genModelHelper.getGetAccessor(eStructuralFeature);
			js.appendDeclaration(cgPropertyCallExp);
			js.append(" = " + QVTiGlobalContext.GET_TRANSFORMATION_EXECUTION_NAME + "().");
			js.append(getAccessor);
			js.append("();\n");
			return true;
		}
		EStructuralFeature eStructuralFeature = QVTiCGUtil.getEStructuralFeature(cgPropertyCallExp);
		doGetting(cgPropertyCallExp, eStructuralFeature, false);
		Boolean status = appendCGEcorePropertyCallExp(cgPropertyCallExp, cgSource);
		if (status != ValueUtil.TRUE_VALUE) {
			return status;
		}
		doGot(cgPropertyCallExp, cgSource, eStructuralFeature);
		return status;
	}

	@Override
	public @NonNull Boolean visitCGEcoreRealizedVariable(@NonNull CGEcoreRealizedVariable cgRealizedVariable) {
		EClassifier eClassifier = ClassUtil.nonNullState(cgRealizedVariable.getEClassifier());
		return doEcoreCreateClass(cgRealizedVariable, (EClass)eClassifier, true);
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
					String instanceName = getFunctionInstanceName(cgFunction);
					//					Type
					js.append("protected class ");
					js.append(functionName);
					js.append(" extends ");
					js.appendClassReference(null, isIncremental ? AbstractComputation.Incremental.class : AbstractComputation.class);
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
					String instanceName = getFunctionInstanceName(cgFunction);
					CGClass cgClass = ClassUtil.nonNullState(CGUtil.getContainingClass(cgFunction));
					js.append("protected class ");
					js.append(functionName);
					js.append(" extends ");
					js.appendClassReference(null, isIncremental ? AbstractComputation.Incremental.class : AbstractComputation.class);
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
						js.appendClassReference(null, javaTypeDescriptor);
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
				appendThis(cgClass);
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
			String instanceName = getFunctionInstanceName(cgFunction);
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
					js.appendClassReference(null, isIncremental ? AbstractInvocation.Incremental.class : AbstractInvocation.class);
					js.pushClassBody(mappingName);
					boolean needsNewLine = doMappingFields(cgMapping);
					if (needsNewLine) {
						js.append("\n");
					}
					doMappingConstructor(cgMapping);
					if (isIncremental) {
						js.append("\n");
						doMappingDestroy(cgMapping);
					}
					js.append("\n");
					js.append("@Override\n");
					js.append("public boolean execute() ");
					doMappingBody(cgMapping, null);
					if (isIncremental) {
						js.append("\n");
						doMappingGetBoundValue(cgMapping);
						js.append("\n");
						doMappingGetBoundValues(cgMapping);
					}
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

					doMappingBody(cgMapping, cgFreeVariables);
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
		MappingCall pMappingCall = QVTiCGUtil.getAST(cgMappingCall);
		Mapping pReferredMapping = QVTimperativeUtil.getReferredMapping(pMappingCall);
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
		CGMapping cgMapping = QVTiCGUtil.getContainingCGMapping(cgMappingExp);
		Iterable<@NonNull CGAccumulator> cgAccumulators = QVTiCGUtil.getOwnedAccumulators(cgMappingExp);
		if (!Iterables.isEmpty(cgAccumulators)) {
			js.append("// interval variables\n");
			String modeFactoryName = "modeFactory";
			String rootIntervalName = "rootInterval";
			js.append("final ");
			js.appendClassReference(true, ModeFactory.class);
			js.append(" " + modeFactoryName + " = getModeFactory();\n");
			js.append("final ");
			js.appendClassReference(true, Interval.class);
			js.append(" " + rootIntervalName + " = lazyCreateInterval(0);\n");
			js.append("// connection variables\n");
			for (@NonNull CGAccumulator cgAccumulator : cgAccumulators) {
				Element ast = cgAccumulator.getAst();
				js.append("final ");
				//	js.appendClassReference(true, isIncremental ? Connection.Incremental.class : Connection.class);
				js.appendClassReference(true, Connection.class);
				js.append(" ");
				js.appendValueName(cgAccumulator);
				js.append(" = ");
				if ((ast instanceof BufferStatement) && (((BufferStatement)ast).getFirstPass() != null)) {
					js.append("lazyCreateInterval(");
					js.appendIntegerString(((BufferStatement)ast).getFirstPass());
					js.append(")");
				}
				else {
					js.append(rootIntervalName);
				}
				js.append(".createConnection(");
				js.appendString(QVTiCGUtil.getName(cgAccumulator));
				js.append(", ");
				js.appendValueName(cgAccumulator.getTypeId());
				js.append(", ");
				js.appendBooleanString((ast instanceof BufferStatement) && ((BufferStatement)ast).isIsStrict());
				js.append(", ");
				js.append(modeFactoryName);
				js.append(");\n");
				/*
				if ((ast instanceof ConnectionVariable) && (((ConnectionVariable)ast).getType() instanceof SetType)) {
					js.append("createUnenforcedSetAccumulatorValue(");
				}
				else {
					js.append("(");
					js.appendClassReference(null, cgAccumulator);
					js.append(".Accumulator)");
					js.appendClassReference(null, ValueUtil.class);
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
					js.appendClassReference(null, ValueUtil.class);
					js.append(".typedIterable(");
					js.appendClassReference(null, boxedDescriptor);
					js.append(".class, ");
					js.appendValueName(cgInit);
					js.append(")");
					//				js.appendReferenceTo(cgAccumulator.getInit());
					js.append(") {\n");
					js.pushIndentation(null);
					js.appendReferenceTo(cgAccumulator);
					js.append(".appendElement(");
					js.append(iteratorName);
					js.append(");\n");
					js.popIndentation();
					js.append("}\n");
				}
			}
		}
		Iterable<@NonNull CGRealizedVariable> cgRealizedVariables = QVTiCGUtil.getOwnedRealizedVariables(cgMapping);
		if (!Iterables.isEmpty(cgRealizedVariables)) {
			js.append("// creations\n");
			for (@NonNull CGRealizedVariable cgRealizedVariable : cgRealizedVariables) {
				if (!doCreateRealizedVariable(cgRealizedVariable)) {
					return false;
				}
			}
		}
		Iterable<@NonNull CGPropertyAssignment> cgPropertyAssignments = QVTiCGUtil.getOwnedAssignments(cgMapping);
		if (!Iterables.isEmpty(cgPropertyAssignments)) {
			js.append("// property assignments\n");
			for (@NonNull CGPropertyAssignment cgAssignment : cgPropertyAssignments) {
				if (!cgAssignment.accept(this)) {
					return false;
				}
			}
		}
		Iterable<@NonNull CGConnectionAssignment> cgConnectionAssignments = QVTiCGUtil.getOwnedConnectionAssignments(cgMapping);
		if (!Iterables.isEmpty(cgConnectionAssignments)) {
			js.append("// connection assignments\n");
			for (@NonNull CGConnectionAssignment cgConnectionAssignment : cgConnectionAssignments) {
				if (!cgConnectionAssignment.accept(this)) {
					return false;
				}
			}
		}
		CGValuedElement body = cgMappingExp.getOwnedBody();
		if (body != null) {
			js.append("// mapping statements\n");
			if (!body.accept(this)) {
				return false;
			}
		}
		doMappingSuccess(cgMappingExp);
		return true;
	}

	@Override
	public @NonNull Boolean visitCGMappingLoop(@NonNull CGMappingLoop cgMappingLoop) {
		CGValuedElement source = getExpression(cgMappingLoop.getSource());
		CGIterator iterator = cgMappingLoop.getIterators().get(0);
		CGValuedElement body = QVTiCGUtil.getBody(cgMappingLoop);
		if (!js.appendLocalStatements(source)) {
			return false;
		}
		Mapping thisInvocationWrapper = null;
		if (invocationWrapper == null) {
			invocationWrapper = thisInvocationWrapper = getInvocationWrapper(body);
			if (thisInvocationWrapper != null) {
				doInvocationWrapperPrefix(thisInvocationWrapper);
			}
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
			js.appendClassReference(null, ValueUtil.class);
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
				MappingCall asMappingCall = QVTiCGUtil.getAST(cgMappingCall);
				Mapping pReferredMapping = QVTimperativeUtil.getReferredMapping(asMappingCall);
				CGMapping cgReferredMapping = analyzer.getMapping(pReferredMapping);
				if ((cgReferredMapping != null) && useClass(cgReferredMapping)) {
					needsFlush = true;
					break;
				}
			}
		}
		if (thisInvocationWrapper != null) {
			doInvocationWrapperSuffix(thisInvocationWrapper);
			invocationWrapper = null;
		}
		if (needsFlush) {
			js.append("//invocationManager.flush();\n");
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGMiddlePropertyAssignment(@NonNull CGMiddlePropertyAssignment cgMiddlePropertyAssignment) {
		Property pReferredProperty = QVTiCGUtil.getReferredProperty(cgMiddlePropertyAssignment);
		assert !pReferredProperty.isIsImplicit();
		CGValuedElement slotValue = QVTiCGUtil.getOwnedSlotValue(cgMiddlePropertyAssignment);
		CGValuedElement initValue = QVTiCGUtil.getOwnedInitValue(cgMiddlePropertyAssignment);
		Map<@NonNull Property, @NonNull String> oppositeProperties = getGlobalContext().getOppositeProperties();
		if (oppositeProperties != null) {
			String cacheName = oppositeProperties.get(pReferredProperty);
			if (cacheName != null) {
				TypeDescriptor outerTypeDescriptor = context.getBoxedDescriptor(pReferredProperty.getOwningClass().getTypeId());
				TypeDescriptor middleTypeDescriptor = context.getBoxedDescriptor(PivotUtil.getElementalType(PivotUtil.getType(pReferredProperty)).getTypeId());
				js.append(cacheName);
				js.append(".put(");
				js.appendReferenceTo(middleTypeDescriptor, initValue);
				js.append(", ");
				js.appendReferenceTo(outerTypeDescriptor, slotValue);
				js.append(");\n");
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
				SubStream castBody = new SubStream() {
					@Override
					public void append() {
						if (isRequired) {
							js.appendClassReference(null, ClassUtil.class);
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
				};
				if (asOppositeProperty.isIsMany()) {
					js.appendClassCast(cgPropertyCallExp, castBody);
				}
				else {
					castBody.append();
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
		CGValuedElement slotValue = QVTiCGUtil.getOwnedSlotValue(cgPropertyAssignment);
		CGValuedElement initValue = QVTiCGUtil.getOwnedInitValue(cgPropertyAssignment);
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
		return true;
	}

	@Override
	public @NonNull Boolean visitCGRealizedVariable(@NonNull CGRealizedVariable cgRealizedVariable) {
		TypeId typeId = cgRealizedVariable.getASTypeId();
		if (typeId != null) {
			CGMapping cgMapping = QVTiCGUtil.getOwningMapping(cgRealizedVariable);
			if (useClass(cgMapping)) {
				js.appendValueName(cgRealizedVariable);
			}
			else {
				js.appendDeclaration(cgRealizedVariable);
			}
			js.append(" = ");
			js.appendReferenceTo(cgRealizedVariable.getExecutorType());
			js.append(".createInstance();\n");
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGRealizedVariablePart(@NonNull CGRealizedVariablePart cgRealizedVariablePart) {
		CGValuedElement init = getExpression(cgRealizedVariablePart.getInit());
		if (!js.appendLocalStatements(init)) {
			return false;
		}
		//
		js.append(".initValue(");
		js.appendValueName(cgRealizedVariablePart.getOwningRealizedVariable());
		js.append(", ");
		js.appendValueName(init);
		js.append(");\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGSequence(@NonNull CGSequence cgSequence) {
		for (@NonNull CGValuedElement cgStatement : ClassUtil.nullFree(cgSequence.getOwnedStatements())) {
			cgStatement.accept(this);
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGSpeculateExp(@NonNull CGSpeculateExp cgSpeculateExp) {
		CGMapping cgMapping = QVTiCGUtil.getContainingCGMapping(cgSpeculateExp);
		for (@NonNull CGGuardVariable cgGuardVariable : QVTiCGUtil.getOwnedGuardVariables(cgMapping)) {
			VariableDeclaration asGuardVariable = QVTiCGUtil.getAST(cgGuardVariable);
			if (asGuardVariable instanceof GuardParameter) {
				GuardParameter asGuardParameter = (GuardParameter)asGuardVariable;
				Property successProperty = asGuardParameter.getSuccessProperty();
				if (successProperty != null) {
					EStructuralFeature eStructuralFeature = ClassUtil.nonNullState((EStructuralFeature) successProperty.getESObject());
					String setAccessor = genModelHelper.getSetAccessor(eStructuralFeature);
					//
					js.appendClassReference(true, SlotState.Speculating.class);
					js.append(" " + QVTiGlobalContext.OUTPUT_SPECULATION_SLOT_STATE_NAME + " = ");
					js.append(QVTiGlobalContext.OBJECT_MANAGER_NAME + "." + QVTiGlobalContext.GET_SPECULATION_SLOT_STATE_NAME + "(");
					js.appendValueName(cgGuardVariable);
					js.append(", ");
					appendQualifiedLiteralName(eStructuralFeature);
					js.append(");\n");
					//
					js.appendClassReference(null, Boolean.class);
					js.append(" " + QVTiGlobalContext.OUTPUT_SPECULATION_SLOT_STATUS_NAME + " = " + QVTiGlobalContext.OUTPUT_SPECULATION_SLOT_STATE_NAME + "." + QVTiGlobalContext.GET_SPECULATION_STATUS_NAME + "();\n");
					//
					js.append("if (" + QVTiGlobalContext.OUTPUT_SPECULATION_SLOT_STATUS_NAME + " != ");
					js.appendClassReference(null, ValueUtil.class);
					js.append(".TRUE_VALUE) {\n");
					js.pushIndentation(null);
					js.append("if (" + QVTiGlobalContext.OUTPUT_SPECULATION_SLOT_STATUS_NAME + " == ");
					js.appendClassReference(null, ValueUtil.class);
					js.append(".FALSE_VALUE) {\n");
					js.pushIndentation(null);
					js.appendValueName(cgGuardVariable);
					js.append(".");
					js.append(setAccessor);
					js.append("(");
					js.appendClassReference(null, ValueUtil.class);
					js.append(".FALSE_VALUE);\n");
					//	doAssigned(cgGuardVariable, eStructuralFeature, outputSpeculatingSlotStatus);
					js.append("return ");
					js.appendClassReference(null, ValueUtil.class);
					js.append(".FALSE_VALUE;\n");
					js.popIndentation();
					js.append("}\n");
					//
					js.appendClassReference(true, SlotState.Speculating.class);
					js.append(" " + QVTiGlobalContext.INPUT_SPECULATION_SLOT_STATE_NAME + ";\n");
					js.appendClassReference(null, Boolean.class);
					js.append(" " + QVTiGlobalContext.INPUT_SPECULATION_SLOT_STATUS_NAME + ";\n");
					js.append("boolean " + QVTiGlobalContext.NEEDS_SPECULATION_NAME + " = false;\n");
					for (CGSpeculatePart cgSpeculatePart : cgSpeculateExp.getParts()) {
						//	if (cgInput instanceof CGEcorePropertyCallExp) {cgInput;
						CGValuedElement cgInputObject = cgSpeculatePart.getObjectExp();
						//	boolean isRequired = cgInputObject.isRequired();
						boolean isNonNull = cgInputObject.isNonNull();
						if (isNonNull) {
							js.append("if (");
							js.appendValueName(cgInputObject);
							js.append(" == null) {\n");
							js.pushIndentation(null);
							js.append("throw new ");
							js.appendClassReference(null, InvalidEvaluationException.class);
							js.append("(");
							js.appendString("Null " + cgInputObject/*.getMessage()*/ + " speculation source");
							js.append(");\n");
							js.popIndentation();
							js.append("}\n");
						}
						else {
							js.append("if (");
							js.appendValueName(cgInputObject);
							js.append(" != null) {\n");
							js.pushIndentation(null);
						}
						EStructuralFeature inputAttribute = cgSpeculatePart.getEStructuralFeature();
						String inputSetAccessor = genModelHelper.getSetAccessor(eStructuralFeature);
						//
						js.append(QVTiGlobalContext.INPUT_SPECULATION_SLOT_STATE_NAME + " = ");
						js.append(QVTiGlobalContext.OBJECT_MANAGER_NAME + "." + QVTiGlobalContext.GET_SPECULATION_SLOT_STATE_NAME + "(");
						js.appendValueName(cgInputObject);
						js.append(", ");
						appendQualifiedLiteralName(inputAttribute);
						js.append(");\n");
						js.append(QVTiGlobalContext.INPUT_SPECULATION_SLOT_STATUS_NAME + " = " + QVTiGlobalContext.INPUT_SPECULATION_SLOT_STATE_NAME + "." + QVTiGlobalContext.GET_SPECULATION_STATUS_NAME + "();\n");
						//
						js.append("if (" + QVTiGlobalContext.INPUT_SPECULATION_SLOT_STATUS_NAME + " != ");
						js.appendClassReference(null, ValueUtil.class);
						js.append(".TRUE_VALUE) {\n");
						js.pushIndentation(null);
						js.append("if (" + QVTiGlobalContext.INPUT_SPECULATION_SLOT_STATUS_NAME + " == ");
						js.appendClassReference(null, ValueUtil.class);
						js.append(".FALSE_VALUE) {\n");
						js.pushIndentation(null);
						js.appendValueName(cgInputObject);
						js.append(".");
						js.append(inputSetAccessor);
						js.append("(");
						js.appendClassReference(null, ValueUtil.class);
						js.append(".FALSE_VALUE);\n");
						//	doAssigned(cgInputObject, inputAttribute, outputSpeculatingSlotStatus);
						js.append("return ");
						js.appendClassReference(null, ValueUtil.class);
						js.append(".FALSE_VALUE;\n");
						js.popIndentation();
						js.append("}\n");

						js.append("if (" + QVTiGlobalContext.OUTPUT_SPECULATION_SLOT_STATE_NAME + " != " + QVTiGlobalContext.INPUT_SPECULATION_SLOT_STATE_NAME + ") {\n");
						js.pushIndentation(null);
						js.append(QVTiGlobalContext.OUTPUT_SPECULATION_SLOT_STATE_NAME + ".addInput(" + QVTiGlobalContext.INPUT_SPECULATION_SLOT_STATE_NAME + ");\n");
						js.append(QVTiGlobalContext.NEEDS_SPECULATION_NAME + " = true;\n");
						js.popIndentation();
						js.append("}\n");
						//
						js.popIndentation();
						js.append("}\n");
						//
						if (!isNonNull) {
							js.popIndentation();
							js.append("}\n");
						}
						//	if (Telement2element != null) {
						//		SlotState.Speculating inputSpeculatingSlotState = objectManager.getSpeculatingSlotState(Telement2element, trace_Forward2ReversePackage.Literals.TELEMENT2ELEMENT__S0GLOBAL, outputSpeculatingSlotState);
						//		if (inputSpeculatingSlotState != outputSpeculatingSlotState) {			// Bypass the depends-on-self unit cycle
						//			needsSpeculation = true;
						//		}
						//	}
					}
					js.append("if (" + QVTiGlobalContext.NEEDS_SPECULATION_NAME + ") {\n");
					js.pushIndentation(null);
					js.append("throw new ");
					js.appendClassReference(null, InvocationFailedException.class);
					js.append("(" + QVTiGlobalContext.OUTPUT_SPECULATION_SLOT_STATE_NAME + ", true);\n");
					js.popIndentation();
					js.append("}\n");
					js.popIndentation();
					js.append("}\n");
					break;		// Only one trace
				}
			}
		}

		js.append("boolean ");
		js.appendValueName(cgSpeculateExp);
		js.append(" = true;\n");

		CGValuedElement cgSpeculated = cgSpeculateExp.getSpeculated();
		if (cgSpeculated != null) {
			if (!js.appendLocalStatements(cgSpeculated)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGSpeculatePart(@NonNull CGSpeculatePart object) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public @NonNull Boolean visitCGTransformation(@NonNull CGTransformation cgTransformation) {
		js.appendClassHeader(cgTransformation.getContainingPackage());
		ImperativeTransformation transformation = QVTiCGUtil.getAST(cgTransformation);
		EntryPointsAnalysis entryPointsAnalysis = context.getEntryPointsAnalysis(transformation);
		//		this.entryPointsAnalysis = entryPointsAnalysis;
		String className = cgTransformation.getName();
		assert className != null;
		js.append("/**\n");
		js.append(" * The " + className + " transformation:\n");
		js.append(" * <p>\n");
		js.append(" * Construct with an evaluator\n");
		js.append(" * <br>\n");
		js.append(" * Populate each input model with {@link addRootEObjects(String,List)}\n");
		js.append(" * <br>\n");
		js.append(" * {@link run()}\n");
		js.append(" * <br>\n");
		js.append(" * Extract each output model with {@link getRootEObjects(String)}\n");
		js.append(" */\n");
		//		js.append("@SuppressWarnings({\"nls\",\"unused\"})\n");
		js.append("@SuppressWarnings(\"unused\")\n");
		js.append("public class " + className + " extends ");
		js.appendClassReference(null, getAbstractTransformationExecutorClass());
		js.pushClassBody(className);
		if (sortedGlobals != null) {
			for (CGValuedElement cgElement : sortedGlobals) {
				assert cgElement.isGlobal();
				cgElement.accept(this);
			}
		}
		doOppositeCaches(entryPointsAnalysis);
		js.append("\n");
		String oppositeIndex2propertyIdName = doOppositePropertyIds(entryPointsAnalysis);
		if (oppositeIndex2propertyIdName != null) {
			js.append("\n");
		}
		List<@NonNull CGMapping> cgMappings = ClassUtil.nullFree(cgTransformation.getOwnedMappings());
		List<CGOperation> cgOperations = cgTransformation.getOperations();
		doMappingConstructorConstants(cgMappings);
		doFunctionConstructorConstants(ClassUtil.nullFree(cgOperations));
		doInstanceCaches(cgTransformation);
		js.append("\n");
		List<@Nullable AllInstancesAnalysis> allInstancesAnalyses = doAllInstances(entryPointsAnalysis);
		js.append("\n");
		doConstructor(cgTransformation, oppositeIndex2propertyIdName, allInstancesAnalyses);
		js.append("\n");
		/*		if (isIncremental) {
				doCreateIncrementalManagers();
				js.append("\n");
			} */
		/*	doCreateInterval(cgTransformation);
			js.append("\n"); */
		doTransformationExecution(cgTransformation);
		doRun(cgTransformation, allInstancesAnalyses);
		//			break;
		//		}
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
