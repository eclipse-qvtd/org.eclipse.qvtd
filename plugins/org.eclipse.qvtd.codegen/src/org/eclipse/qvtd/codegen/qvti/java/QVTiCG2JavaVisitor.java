/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.java;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.cgmodel.CGAccumulator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCollectionExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaConstants;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.java.types.BoxedDescriptor;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.tx.AbstractInvocation;
import org.eclipse.ocl.pivot.evaluation.tx.AbstractTransformer;
import org.eclipse.ocl.pivot.evaluation.tx.Transformer;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionVariable;
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
import org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.CGVariablePredicate;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeArea;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

import com.google.common.collect.Iterables;

/**
 * A QVTiCG2JavaVisitor supports generation of Java code from an optimized QVTi CG transformation tree.
 */
public class QVTiCG2JavaVisitor extends CG2JavaVisitor<@NonNull QVTiCodeGenerator> implements QVTiCGModelVisitor<Boolean>
{
	/**
	 * The run-time API version.
	 * 
	 * @noreference this is solely for development usage.
	 */
	public static int RUN_TIME_EVALUATOR_API_VERSION = Transformer.RUN_TIME_EVALUATOR_API_VERSION_1_1_0_1;
	
	protected final @NonNull QVTiAnalyzer analyzer;
	protected final @NonNull CGPackage cgPackage;
	protected final @Nullable List<CGValuedElement> sortedGlobals;
	protected boolean alwaysUseClasses = false;
	protected QVTiTransformationAnalysis transformationAnalysis;
	
	public QVTiCG2JavaVisitor(@NonNull QVTiCodeGenerator codeGenerator, @NonNull CGPackage cgPackage,
			@Nullable List<CGValuedElement> sortedGlobals) {
		super(codeGenerator);
		this.analyzer = codeGenerator.getAnalyzer();
		this.cgPackage = cgPackage;
		this.sortedGlobals = sortedGlobals;
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
		RealizedVariable pRealizedVariable = (RealizedVariable)cgRealizedVariable.getAst();
		Area pArea = QVTcoreBaseUtil.getContainingArea(pRealizedVariable);
		if (pArea != null) {
			BottomPattern pBottomPattern = pArea.getBottomPattern();
			if (pBottomPattern != null) {
				for (Assignment pAssignment : pBottomPattern.getAssignment()) {
					if (pAssignment instanceof PropertyAssignment) {
						Property pProperty = ((PropertyAssignment)pAssignment).getTargetProperty();
						if (pProperty != null) {
							Property pOppositeProperty = pProperty.getOpposite();
							if ((pOppositeProperty != null) && pOppositeProperty.isIsComposite()) {
// FIXME must check for null asssignment and correct target								return;
							}
						}
					}
				}
			}
		}
		CGTypedModel cgTypedModel = cgRealizedVariable.getTypedModel();
		//
		js.append(QVTiGlobalContext.MODELS_NAME);
		js.append("[");
		appendModelIndex(cgTypedModel);
		js.append("].add(");
		js.appendValueName(cgRealizedVariable);
		js.append(");\n");
	}

	protected @NonNull String @Nullable [] doAllInstances(@NonNull QVTiTransformationAnalysis transformationAnalysis) {
		Set<org.eclipse.ocl.pivot.Class> allInstancesClasses = transformationAnalysis.getAllInstancesClasses();
		if (allInstancesClasses.size() > 0) {
			NameManager nameManager = getGlobalContext().getNameManager();
			Map<org.eclipse.ocl.pivot.Class, List<org.eclipse.ocl.pivot.Class>> instancesClassAnalysis = transformationAnalysis.getInstancesClassAnalysis(allInstancesClasses);
			//
			// Populate a mapping from instancesClass to linear index.
			//
			Map<org.eclipse.ocl.pivot.Class, Integer> instancesClass2index = new HashMap<org.eclipse.ocl.pivot.Class, Integer>(instancesClassAnalysis.size());
			List<org.eclipse.ocl.pivot.Class> sortedList = new ArrayList<org.eclipse.ocl.pivot.Class>(instancesClassAnalysis.keySet());
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
			js.append("[] ");
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
				List<org.eclipse.ocl.pivot.Class> superInstancesClasses = ClassUtil.nonNullState(instancesClassAnalysis.get(instancesClass));
				int startLength = js.length();
				js.append("{");
				boolean isFirst = true;
				for (org.eclipse.ocl.pivot.Class superInstancesClass : superInstancesClasses) {
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
				for (org.eclipse.ocl.pivot.Class superInstancesClass : superInstancesClasses) {
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

	protected void doConstructor(@NonNull CGTransformation cgTransformation, @Nullable String oppositeName, @NonNull String @Nullable [] allInstancesNames) {
//		String evaluatorName = ((QVTiGlobalContext)globalContext).getEvaluatorParameter().getName();
		String evaluatorName = JavaConstants.EXECUTOR_NAME;
		String className = cgTransformation.getName();
		//
		js.append("public " + className + "(final ");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(Executor.class);
		js.append(" " + evaluatorName + ") throws ");
		js.appendClassReference(ReflectiveOperationException.class);
		js.append(" {\n");
		js.pushIndentation(null);		
		js.append("super(" + evaluatorName + ", new ");
		js.appendIsRequired(true);
		js.append(" String[] {");
		boolean isFirst = true;
		for (CGTypedModel cgTypedModel : cgTransformation.getTypedModels()) {
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
		for (@SuppressWarnings("null")@NonNull CGMapping cgMapping : cgTransformation.getMappings()) {
			if (useClass(cgMapping) && (cgMapping.getFreeVariables().size() > 0)) {
//				js.append("protected final ");
//				js.appendIsRequired(true);
//				js.append(" ");
//				js.appendClassReference(Constructor.class, false, cgMapping.getName());
				js.append(getMappingCtorName(cgMapping) + " = ");
				js.appendClassReference(ClassUtil.class);
				js.append(".nonNullState(" + getMappingName(cgMapping) + ".class.getConstructor(" + className + ".class, Object[].class));\n");
			}
		}
		js.popIndentation();
		js.append("}\n");
	}

	protected void doConstructorConstants(/*@NonNull*/ List<CGMapping> cgMappings) {
		for (@SuppressWarnings("null")@NonNull CGMapping cgMapping : cgMappings) {
			if (useClass(cgMapping) && (cgMapping.getFreeVariables().size() > 0)) {
				js.append("protected final ");
				js.appendIsRequired(true);
				js.append(" ");
				js.appendClassReference(Constructor.class, false, getMappingName(cgMapping));
				js.append(" " + getMappingCtorName(cgMapping) + ";\n");
			}
		}
	}
   
	protected void doOppositeCaches(@NonNull QVTiTransformationAnalysis transformationAnalysis) {
		Map<@NonNull Property, Integer> opposites = transformationAnalysis.getCaches();
		if (opposites.size() <= 0) {
			return;
		}
		js.append("\n/*\n * Property-source to Property-target unnavigable navigation caches\n */\n");
		Map<String, @NonNull Property> key2property = new HashMap<String, @NonNull Property>();
		for (Map.Entry<@NonNull Property, Integer> entry : opposites.entrySet()) {
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
		return null;
		// This code is no longer used, and since it is not used it generates undefined references
		// It appears to have 'worked' only because a duplicate incomplete TransformationAnalysis was in use.
/*		Map<Property, Integer> opposites = transformationAnalysis.getSourceCaches();
		if (opposites.size() <= 0) {
			return null;
		}
		NameManager nameManager = getGlobalContext().getNameManager();
		List<Property> sortedList = new ArrayList<Property>();
		for (int i = 0; i < opposites.size();i++) {
			sortedList.add(null);
		}
		for (Map.Entry<Property, Integer> entry : opposites.entrySet()) {
			sortedList.set(entry.getValue().intValue(), entry.getKey());
		}
		//
		//	Emit the ClassId array
		//
		js.append("/*\n");
		js.append(" * Array of the source PropertyIds of each Property for which unnavigable opposite property navigation may occur.\n");
		js.append(" * /\n");
		String oppositeIndex2propertyIdName = nameManager.getGlobalSymbolName(null, "oppositeIndex2propertyId");
		js.append("private static final ");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(PropertyId.class);
		js.append("[] ");
		js.append(oppositeIndex2propertyIdName);
		js.append(" = new ");
		js.appendClassReference(PropertyId.class);
		js.append("[]{\n");
		js.pushIndentation(null);
		for (int i = 0; i < sortedList.size(); i++) {
			Property property = sortedList.get(i);
			CGElementId cgPropertyId = getCodeGenerator().getAnalyzer().getElementId(property.getPropertyId());
			js.appendValueName(cgPropertyId);
			if ((i+1) < sortedList.size()) {
				js.append(",");
			}
			js.append("\t\t// " + i + " => " + property.getName() + "\n");
		}
		js.popIndentation();
		js.append("};\n");
		return oppositeIndex2propertyIdName; */
    }

	protected void doRun(@NonNull CGTransformation cgTransformation) {
		CGMapping cgRootMapping = NameUtil.getNameable(cgTransformation.getMappings(), QVTimperativeUtil.ROOT_MAPPING_NAME);
		if (cgRootMapping == null) {
        	throw new IllegalStateException("Transformation " + cgTransformation.getName() + " has no root mapping");
		}
		js.append("public boolean run() throws ");
		js.appendClassReference(ReflectiveOperationException.class);
		js.append(" {\n");
		js.pushIndentation(null);
		js.append("return ");
		js.append(getMappingName(cgRootMapping));
		js.append("() && invocationManager.flush();\n");
		js.popIndentation();		
		js.append("}\n");
	}

	protected @NonNull Class<? extends AbstractTransformer> getAbstractTransformationExecutorClass() {
		return AbstractTransformer.class;
	}

	@Override
	public @NonNull Set<String> getAllImports() {
		Set<String> allImports = new HashSet<String>();
		for (String anImport : super.getAllImports()) {
			allImports.add(anImport);
			if (anImport.endsWith(".Model")) {
				allImports.add(org.eclipse.ocl.pivot.evaluation.tx.AbstractTransformer.class.getName() + ".Model");
			}
		}
		return allImports;
	}

	protected @NonNull QVTiGlobalContext getGlobalContext() {
		return (QVTiGlobalContext) globalContext;
	}

	protected String getMappingCtorName(@NonNull CGMapping cgMapping) {
		return JavaStream.convertToJavaIdentifier("CTOR_" + cgMapping.getName());
	}

	protected @NonNull String getMappingName(@NonNull CGMapping cgMapping) {
		return JavaStream.convertToJavaIdentifier("MAP_" + cgMapping.getName());
	}

	protected @Nullable TypeDescriptor needsTypeCheck(@NonNull CGMappingCallBinding cgMappingCallBinding) {
		MappingCallBinding mappingCallBinding = (MappingCallBinding)cgMappingCallBinding.getAst();
		Variable boundVariable = mappingCallBinding.getBoundVariable();
		assert boundVariable != null;
		if (QVTimperativeUtil.isConnectionVariable(boundVariable)) {
			return null;
		}
		CGValuedElement value = cgMappingCallBinding.getValue();
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

	private boolean useClass(@NonNull CGMapping cgMapping) {
		if (alwaysUseClasses) {
			return true;
		}
		Mapping asMapping = ClassUtil.nonNullState((Mapping) cgMapping.getAst());
		if (transformationAnalysis.hasPropertyAccessDeclarations()) {
			boolean isHazardous = false;
			if (asMapping.getCheckedProperties().size() > 0) {
				isHazardous = true;
			}
			for (Domain domain : asMapping.getDomain()) {
				if ((domain instanceof ImperativeArea) && (((ImperativeArea)domain).getCheckedProperties().size() > 0)) {
					isHazardous = true;
					break;
				}
			}
			assert isHazardous == transformationAnalysis.isHazardous(asMapping);
			return isHazardous;
		}
		else {
			return transformationAnalysis.isHazardous(asMapping);
		}
	}

	@Override
	public @NonNull Boolean visitCGConnectionAssignment(@NonNull CGConnectionAssignment cgConnectionAssignment) {
		CGValuedElement initValue = cgConnectionAssignment.getInitValue();
		assert initValue != null;
		if (!js.appendLocalStatements(initValue)) {
			return false;
		}
		final String iteratorName = getSymbolName(null, "iterator");
//		CollectionTypeId abstractCollectionTypeId = (CollectionTypeId)initValue.getASTypeId();
//		assert abstractCollectionTypeId != null;
//		TypeId abstractElementTypeId = abstractCollectionTypeId.getElementTypeId();
//		BoxedDescriptor abstractBoxedDescriptor = context.getBoxedDescriptor(abstractElementTypeId);
		CollectionTypeId concreteCollectionTypeId = (CollectionTypeId)cgConnectionAssignment.getConnectionVariable().getASTypeId();
		assert concreteCollectionTypeId != null;
		TypeId concreteElementTypeId = concreteCollectionTypeId.getElementTypeId();
		BoxedDescriptor concreteBoxedDescriptor = context.getBoxedDescriptor(concreteElementTypeId);
		BoxedDescriptor abstractBoxedDescriptor = concreteBoxedDescriptor;
		if (!(initValue.getASTypeId() instanceof CollectionTypeId)) {
			js.appendReferenceTo(cgConnectionAssignment.getConnectionVariable());
			js.append(".add(");
			js.appendValueName(initValue);
			js.append(");\n");
		}
		else {
			js.append("for (");
			js.appendClassReference(abstractBoxedDescriptor);
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
				js.append("if (");
				js.append(iteratorName);
				js.append(" instanceof ");
				js.appendClassReference(concreteBoxedDescriptor);
				js.append(") {\n");
					js.pushIndentation(null);
					js.appendReferenceTo(cgConnectionAssignment.getConnectionVariable());
					js.append(".add(");
					js.append(iteratorName);
					js.append(");\n");
					js.popIndentation();
				js.append("}\n");
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
	public @NonNull Boolean visitCGEcorePropertyAssignment(@NonNull CGEcorePropertyAssignment cgPropertyAssignment) {
//		Property referredProperty = cgPropertyAssignment.getReferredProperty();
//		Property pivotProperty = cgPropertyCallExp.getReferredProperty();
//		CGTypeId cgTypeId = analyzer.getTypeId(pivotProperty.getOwningType().getTypeId());
//		JavaTypeDescriptor requiredTypeDescriptor = context.getJavaTypeDescriptor(cgTypeId, false);
		EStructuralFeature eStructuralFeature = ClassUtil.nonNullModel(cgPropertyAssignment.getEStructuralFeature());
		EPackage ePackage = ClassUtil.nonNullModel(eStructuralFeature.getEContainingClass().getEPackage());
		CGValuedElement cgSlot = getExpression(cgPropertyAssignment.getSlotValue());
		CGValuedElement cgInit = getExpression(cgPropertyAssignment.getInitValue());
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
			js.appendValueName(cgSlot);
			js.append(".");
			js.append(getAccessor);
			js.append("().addAll(");
			js.appendValueName(cgInit);
			js.append(");\n");
		}
		else {
			String setAccessor = genModelHelper.getSetAccessor(eStructuralFeature);
			//
			js.appendValueName(cgSlot);
			js.append(".");
			js.append(setAccessor);
			js.append("(");
			js.appendValueName(cgInit);
			js.append(");\n");
		}
		boolean isHazardous = false;
		Element asPropertyAssignment = cgPropertyAssignment.getAst();
		Mapping asMapping = QVTimperativeUtil.getContainingMapping(asPropertyAssignment);
		if ((asMapping != null) && (asPropertyAssignment instanceof PropertyAssignment)) {
			isHazardous = transformationAnalysis.isHazardousWrite(asMapping, (PropertyAssignment)asPropertyAssignment);
		}
		if (isHazardous) {
			js.append("objectManager.assigned(");
			js.appendValueName(cgSlot);
			js.append(", ");
			js.appendClassReference(genModelHelper.getQualifiedPackageInterfaceName(ePackage));
			js.append(".Literals.");
			js.append(genModelHelper.getEcoreLiteralName(eStructuralFeature));
			js.append(", ");
			js.appendValueName(cgInit);
			js.append(");\n");
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGEcorePropertyCallExp(@NonNull CGEcorePropertyCallExp cgPropertyCallExp) {
		boolean isHazardous = false;
		Element asPropertyCallExp = cgPropertyCallExp.getAst();
		CGMapping cgMapping = QVTiCGUtil.getContainingCGMapping(cgPropertyCallExp);
		Mapping asMapping = cgMapping != null ? (Mapping) cgMapping.getAst() : null;
		if ((asMapping != null) && "uPropertyCallExp_referredProperty".equals(asMapping.getName())) {
			asMapping.getName();
		}
		if ((asMapping != null) && (asPropertyCallExp instanceof PropertyCallExp)) {
			isHazardous = transformationAnalysis.isHazardousRead(asMapping, (PropertyCallExp)asPropertyCallExp);
		}
		CGValuedElement source = getExpression(cgPropertyCallExp.getSource());
		//
		if (!js.appendLocalStatements(source)) {
			return false;
		}
		if (isHazardous) {
			EStructuralFeature eStructuralFeature = ClassUtil.nonNullState(cgPropertyCallExp.getEStructuralFeature());
			EPackage ePackage = ClassUtil.nonNullModel(eStructuralFeature.getEContainingClass().getEPackage());
			//
			js.append("objectManager.getting(");
			js.appendValueName(source);
			js.append(", ");
			js.appendClassReference(genModelHelper.getQualifiedPackageInterfaceName(ePackage));
			js.append(".Literals.");
			js.append(genModelHelper.getEcoreLiteralName(eStructuralFeature));
			js.append(");\n");
		}
		return appendCGEcorePropertyCallExp(cgPropertyCallExp, source);
	}

	@Override
	public @NonNull Boolean visitCGEcoreRealizedVariable(@NonNull CGEcoreRealizedVariable cgRealizedVariable) {
		EClassifier eClassifier = cgRealizedVariable.getEClassifier();
		EPackage ePackage = eClassifier.getEPackage();			
		String createMethodName = "create" + eClassifier.getName();
		String javaClass;
		if (ePackage != null) {
			Class<?> factoryClass = genModelHelper.getEcoreFactoryClass(ePackage);
			if (factoryClass != null) {
				javaClass = factoryClass.getName();
				Method factoryMethod = context.getLeastDerivedMethod(factoryClass, createMethodName);
				if (factoryMethod != null) {
					if (context.getIsNonNull(factoryMethod) == Boolean.TRUE) {
						cgRealizedVariable.setNonNull();
					};
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
		js.appendDeclaration(cgRealizedVariable);
		js.append(" = ");
		js.appendClassReference(javaClass);
//		js.appendReferenceTo(localContext.getExecutorType(cgRealizedVariable.getPivotTypeId()));
		js.append(".eINSTANCE.");
		js.append(createMethodName);
		js.append("();\n");
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
		JavaLocalContext<?> localContext2 = globalContext.getLocalContext(cgFunction);
		if (localContext2 != null) {
			localContext = localContext2;
			try {
				List<CGParameter> cgParameters = cgFunction.getParameters();
				CGValuedElement body = getExpression(cgFunction.getBody());
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
				js.append(") {\n");
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
		js.append(cgFunctionCallExp.getReferredOperation().getName());
		js.append("(");
		int iMax = Math.min(pParameters.size(), cgArguments.size());
		for (int i = 0; i < iMax; i++) {
			if (i > 0) {
				js.append(", ");
			}
			CGValuedElement cgArgument = cgArguments.get(i);
			CGValuedElement argument = getExpression(cgArgument);
			Parameter pParameter = pParameters.get(i);
//			CGTypeId cgParameterTypeId = analyzer.getTypeId(pParameter.getTypeId());
			TypeDescriptor parameterTypeDescriptor = context.getUnboxedDescriptor(pParameter.getTypeId());
			js.appendReferenceTo(parameterTypeDescriptor, argument);
		}
		js.append(");\n");
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
//		if ("associationToForeignKeyLM".equals(cgMapping.getName())) {
//			System.out.println("Got it");
//		}
		JavaLocalContext<?> localContext2 = globalContext.getLocalContext(cgMapping);
		if (localContext2 != null) {
			localContext = localContext2;
			try {
				CGValuedElement cgBody = cgMapping.getBody();
				List<CGGuardVariable> cgFreeVariables = cgMapping.getFreeVariables();
				//
				js.appendCommentWithOCL(null, cgMapping.getAst());
				if (useClass(cgMapping) && (cgFreeVariables.size() > 0)) {
					js.append("protected class ");
					js.append(getMappingName(cgMapping));
					js.append(" extends ");
					js.appendClassReference(AbstractInvocation.class);
					js.append("\n");
					js.append("{\n");
					js.pushIndentation(null);
						for (@SuppressWarnings("null")@NonNull CGGuardVariable cgFreeVariable : cgFreeVariables) {
							js.append("protected ");
							js.appendDeclaration(cgFreeVariable);
							js.append(";\n");
						}
						js.append("\n");
//						js.append("@SuppressWarnings(\"null\")\n");					
						js.append("public ");
						js.append(getMappingName(cgMapping));
						js.append("(");
						js.appendIsRequired(true);
						js.append(" Object ");
						js.appendIsRequired(true);
						js.append(" [] boundValues) {\n");
						js.pushIndentation(null);
						int i = 0;
						for (@SuppressWarnings("null")@NonNull CGGuardVariable cgFreeVariable : cgFreeVariables) {
							String valueName = getValueName(cgFreeVariable);
							js.append(valueName);
							js.append(" = ");
							js.appendClassCast(cgFreeVariable);
							js.append("boundValues[" + i++);
							js.append("];\n");
						}
						js.popIndentation();
						js.append("}\n");	
						js.append("\n");	
						js.append("public boolean execute() throws ");
						js.appendClassReference(ReflectiveOperationException.class);
						js.append(" {\n");
						js.pushIndentation(null);
							String savedLocalPrefix = localPrefix;
							try {
								localPrefix = cgMapping.getTransformation().getName();
								js.append("// predicates\n");
								cgBody.accept(this);
								js.append("return true;\n");
							}
							finally {
								localPrefix = savedLocalPrefix;
							}
						js.popIndentation();
						js.append("}\n");
						js.append("\n");	
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
								int index = 0;
								for (@SuppressWarnings("null")@NonNull CGGuardVariable cgFreeVariable : cgFreeVariables) {
									if (index > 0) {
										js.append("\n    && ");
									}
									js.append("idResolver.oclEquals(");
									js.append(cgFreeVariable.getValueName());
									js.append(", thoseValues[" + index++ + "])");
								}
								js.append(";\n");
						js.popIndentation();
						js.append("}\n");
					js.popIndentation();
					js.append("}\n");
				}
				else {
					js.append("protected boolean " + getMappingName(cgMapping) + "(");
					boolean isFirst = true;
					for (@SuppressWarnings("null")@NonNull CGGuardVariable cgFreeVariable : cgFreeVariables) {
						if (!isFirst) {
							js.append(", ");
						}
						if (cgFreeVariable instanceof CGConnectionVariable) {
							js.append("final ");
							js.appendClassReference(null, cgFreeVariable);
							js.append(".");
							js.appendIsRequired(true);
							js.append(" Accumulator ");						// FIXME Embed properly as a nested typeid
							js.append(getValueName(cgFreeVariable));
						}
						else{
							js.appendDeclaration(cgFreeVariable);
						}
						isFirst = false;
					}
					js.append(") throws ");
					js.appendClassReference(ReflectiveOperationException.class);
					js.append(" {\n");
					js.pushIndentation(null);
						js.append("// predicates\n");
						cgBody.accept(this);
						js.append("return true;\n");
					js.popIndentation();
					js.append("}\n");
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
		List<CGMappingCallBinding> cgMappingCallBindings = cgMappingCall.getMappingCallBindings();
		for (@SuppressWarnings("null")@NonNull CGMappingCallBinding cgMappingCallBinding : cgMappingCallBindings) {
			CGValuedElement value = cgMappingCallBinding.getValue();
			if (value != null) {
				if (!js.appendLocalStatements(value)) {
					return false;
				}
			}
		}
		//
		//	Set loopVariable non-null if it needs to be type-checked and cast to a narrower type.
		//
		for (@SuppressWarnings("null")@NonNull CGMappingCallBinding cgMappingCallBinding : cgMappingCallBindings) {
			TypeDescriptor checkedType = needsTypeCheck(cgMappingCallBinding);
			if (checkedType != null) {
				js.append("if (");
				js.appendValueName(cgMappingCallBinding.getValue());
				js.append(" instanceof ");
				js.appendClassReference(checkedType);
				js.append(") {\n");
				js.pushIndentation(null);
			}
			else if (!cgMappingCallBinding.isRequired()) {
				js.append("if (");
				js.appendValueName(cgMappingCallBinding.getValue());
				js.append(" != null) {\n");
				js.pushIndentation(null);
			}
		}
		//
		//	Emit the mapping call.
		//
		if (useClass(cgReferredMapping)) {
			if (pMappingCall.isIsInfinite()) {
				js.append("invokeOnce(" + getMappingCtorName(cgReferredMapping) + ", ");
			}
			else {
				js.append("invoke(" + getMappingCtorName(cgReferredMapping) + ", ");
			}
		}
		else {
			js.append(getMappingName(cgReferredMapping) + "(");
		}
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
			js.appendValueName(cgMappingCallBinding.getValue());
			isFirst = false;
		}
		js.append(");\n");
		//
		//	End the type check.
		//
		for (@SuppressWarnings("null")@NonNull CGMappingCallBinding cgMappingCallBinding : cgMappingCallBindings) {
			TypeDescriptor checkedType = needsTypeCheck(cgMappingCallBinding);
			if (checkedType != null) {
				js.popIndentation();
				js.append("}\n");
			}
			else if (!cgMappingCallBinding.isRequired()) {
				js.popIndentation();
				js.append("}\n");
			}
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGMappingCallBinding(@NonNull CGMappingCallBinding object) {
		return true;
	}

	@Override
	public @NonNull Boolean visitCGMappingExp(@NonNull CGMappingExp cgMappingExp) {
		assert cgMappingExp.getPredicates().isEmpty();		// Get rewritten during JavaPre pass
		List<CGFinalVariable> cgVariableAssignments = cgMappingExp.getVariableAssignments();
		if (cgVariableAssignments.size() > 0) {
			js.append("// variable assignments\n");
			for (CGVariable cgAssignment : cgVariableAssignments) {
				cgAssignment.accept(this);
			}
		}
		List<CGAccumulator> cgAccumulators = cgMappingExp.getOwnedAccumulators();
		if (cgAccumulators.size() > 0) {
			js.append("// connection variables\n");
			for (CGAccumulator cgAccumulator : cgAccumulators) {
				js.append("final ");
				js.appendClassReference(null, cgAccumulator);
				js.append(".");
				js.appendIsRequired(true);
				js.append(" Accumulator ");
				js.appendValueName(cgAccumulator);
				js.append(" = (");
				js.appendClassReference(null, cgAccumulator);
				js.append(".Accumulator)");
				js.appendClassReference(ValueUtil.class);
				js.append(".createCollectionAccumulatorValue(");
				js.appendValueName(cgAccumulator.getTypeId());
				js.append(");\n");
				//
				CGValuedElement cgInit = cgAccumulator.getInit();
				if (!(cgInit instanceof CGCollectionExp) || !Iterables.isEmpty(((CGCollectionExp)cgInit).getParts())) {
					final String iteratorName = getSymbolName(null, "iterator");
					CollectionTypeId collectionTypeId = (CollectionTypeId)cgInit.getASTypeId();
					assert collectionTypeId != null;
					TypeId elementTypeId = collectionTypeId.getElementTypeId();
					BoxedDescriptor boxedDescriptor = context.getBoxedDescriptor(elementTypeId);
					js.append("for (");
					js.appendClassReference(boxedDescriptor);
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
					js.append(".add(");
					js.append(iteratorName);
					js.append(");\n");
					js.popIndentation();
					js.append("}\n");
	//				js.appendClassReference(cgAccumulator);
	//				_m_join_m_PackageCS_m_0_0 = (SetValue.Accumulator)ValueUtil.createCollectionAccumulatorValue(SET_CLSSid_OclElement);
	//				cgAccumulator.accept(this);
				}
			}
		}
		List<CGValuedElement> cgRealizedVariables = cgMappingExp.getRealizedVariables();
		if (cgRealizedVariables.size() > 0) {
			js.append("// creations\n");
			for (CGValuedElement cgRealizedVariable : cgRealizedVariables) {
				cgRealizedVariable.accept(this);
			}
		}
		List<CGPropertyAssignment> cgPropertyAssignments = cgMappingExp.getAssignments();
		if (cgPropertyAssignments.size()> 0) {
			js.append("// property assignments\n");
			for (CGPropertyAssignment cgAssignment : cgPropertyAssignments) {
				cgAssignment.accept(this);
			}
		}
		List<CGConnectionAssignment> cgConnectionAssignments = cgMappingExp.getConnectionAssignments();
		if (cgConnectionAssignments.size() > 0) {
			js.append("// connection assignments\n");
			for (CGConnectionAssignment cgConnectionAssignment : cgConnectionAssignments) {
				cgConnectionAssignment.accept(this);
			}
		}
		CGValuedElement body = cgMappingExp.getBody();
		if (body != null) {
			js.append("// mapping statements\n");
			body.accept(this);
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGMappingLoop(@NonNull CGMappingLoop cgMappingLoop) {
		CGValuedElement source = getExpression(cgMappingLoop.getSource());
		CGIterator iterator = cgMappingLoop.getIterators().get(0);
//		accumulatorName = getSymbolName(null, init.getValueName());
		if (!js.appendLocalStatements(source)) {
			return false;
		}
//		js.appendLocalStatements(iterator);
//		js.appendDeclaration(iterator);
//		js.append(" = ");
//		js.appendValueName(iterator.getInit());
//		js.append(";\n");
		js.append("for (");
//		if (iterator.isNonNull()) {
//			js.append("@SuppressWarnings(\"null\")@NonNull ");
//		}
		js.appendClassReference(null, iterator);
		js.append(" ");
		js.appendValueName(iterator);
		js.append(" : ");
		if (source.isBoxed()) {
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
		js.append("if (");
		js.appendValueName(iterator);
		js.append(" != null) {\n");
		js.pushIndentation(null);
			cgMappingLoop.getBody().accept(this);
		js.popIndentation();
		js.append("}\n");
		js.popIndentation();
		js.append("}\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGMiddlePropertyAssignment(@NonNull CGMiddlePropertyAssignment cgMiddlePropertyAssignment) {
		visitCGEcorePropertyAssignment(cgMiddlePropertyAssignment);
		Property pReferredProperty = ClassUtil.nonNullModel(cgMiddlePropertyAssignment.getReferredProperty());
		assert !pReferredProperty.isIsImplicit();
		CGValuedElement slotValue = cgMiddlePropertyAssignment.getSlotValue();
		CGValuedElement initValue = cgMiddlePropertyAssignment.getInitValue();
		if ((slotValue != null) && (initValue != null)) {
			Map<Property, String> oppositeProperties = getGlobalContext().getOppositeProperties();
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
		return true;
	}

	@Override
	public @NonNull Boolean visitCGMiddlePropertyCallExp(@NonNull CGMiddlePropertyCallExp cgPropertyCallExp) {
		Property pivotProperty = cgPropertyCallExp.getReferredProperty();
		assert !pivotProperty.isIsImplicit();
		CGValuedElement source = getExpression(cgPropertyCallExp.getSource());
		//
		if (!js.appendLocalStatements(source)) {
			return false;
		}
		//
		js.appendDeclaration(cgPropertyCallExp);
		js.append(" = ");
		Map<Property, String> oppositeProperties = getGlobalContext().getOppositeProperties();
		if (oppositeProperties != null) {
			String cacheName = oppositeProperties.get(pivotProperty);
			if (cacheName != null) {
				js.appendClassReference(ClassUtil.class);
				js.append(".nonNullState (");
				js.append(cacheName);
				js.append(".get(");
				js.appendValueName(source);
				js.append("))");
			}
			js.append(";\n");
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGPredicate(@NonNull CGPredicate cgPredicate) {
		boolean booleanCondition = false;
		CGValuedElement cgConditionExpression = cgPredicate.getConditionExpression();
		if (cgConditionExpression != null) {
			if (!js.appendLocalStatements(cgConditionExpression)) {
				return false;
			}
		}
		js.append("if (");
		if (booleanCondition) {
			js.append("!");
			js.appendValueName(cgConditionExpression);
		}
		else {
			js.appendValueName(cgConditionExpression);
			js.append(" != ");
			js.appendClassReference(ValueUtil.class);
			js.append(".TRUE_VALUE");
		}
		js.append(") {\n");
		js.pushIndentation(null);
		js.append("return false;\n");
		js.popIndentation();
		js.append("}\n");
		cgPredicate.getThenExpression().accept(this);
		return true;
	}

	@Override
	public @NonNull Boolean visitCGPropertyAssignment(@NonNull CGPropertyAssignment cgPropertyAssignment) {
		CGExecutorProperty cgExecutorProperty = cgPropertyAssignment.getExecutorProperty();
		CGValuedElement slotValue = cgPropertyAssignment.getSlotValue();
		CGValuedElement initValue = cgPropertyAssignment.getInitValue();
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
	public @Nullable Boolean visitCGSequence(@NonNull CGSequence cgSequence) {
		for (CGValuedElement cgStatement : cgSequence.getStatements()) {
			cgStatement.accept(this);
		}
		return true;
	}

	@Override
	public @NonNull Boolean visitCGTransformation(@NonNull CGTransformation cgTransformation) {
		js.appendClassHeader(cgTransformation.getContainingPackage());
		@SuppressWarnings("null")@NonNull Transformation transformation = (Transformation) cgTransformation.getAst();
		QVTiTransformationAnalysis transformationAnalysis = context.getTransformationAnalysis(transformation);
		this.transformationAnalysis = transformationAnalysis;
		String className = cgTransformation.getName();
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
		js.append("\n");
		js.append("{\n");
		js.pushIndentation(null);
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
		doConstructorConstants(cgTransformation.getMappings());
		js.append("\n");
		doConstructor(cgTransformation, oppositeIndex2propertyIdName, allInstancesNames);
		js.append("\n");
		doRun(cgTransformation);
		for (CGOperation cgOperation : cgTransformation.getOperations()) {
			js.append("\n");
			cgOperation.accept(this);
		}
		for (CGMapping cgMapping : cgTransformation.getMappings()) {
			js.append("\n");
			cgMapping.accept(this);
		}
		js.popIndentation();
		js.append("}\n");
		return true;
	}

	@Override
	public @NonNull Boolean visitCGTypedModel(@NonNull CGTypedModel object) {
		return true;
	}

	@Override
	public @NonNull Boolean visitCGVariablePredicate(@NonNull CGVariablePredicate cgVariablePredicate) {
		CGValuedElement cgConditionExpression = ClassUtil.nonNullState(cgVariablePredicate.getConditionExpression());
		CGVariable cgPredicateVariable = ClassUtil.nonNullState(cgVariablePredicate.getPredicateVariable());
		TypeDescriptor sourceTypeDescriptor = context.getTypeDescriptor(cgConditionExpression);
		TypeDescriptor targetTypeDescriptor = context.getTypeDescriptor(cgPredicateVariable);
		if (!js.appendLocalStatements(cgConditionExpression)) {
			return false;
		}
		if (targetTypeDescriptor.isAssignableFrom(sourceTypeDescriptor)) {
			js.appendDeclaration(cgPredicateVariable);
			js.append(" = ");
			js.appendReferenceTo(cgConditionExpression);
			js.append(";\n");
		}
		else {
			js.append("if (!(");
			js.appendValueName(cgConditionExpression);
			js.append(" instanceof ");
			js.appendClassReference(targetTypeDescriptor);
			js.append(")) {\n");
			js.pushIndentation(null);
			js.append("return false;\n");
			js.popIndentation();
			js.append("}\n");
			js.appendDeclaration(cgPredicateVariable);
			js.append(" = ");
			js.appendReferenceTo(targetTypeDescriptor, cgConditionExpression);
			js.append(";\n");
		}
		cgVariablePredicate.getThenExpression().accept(this);
		return true;
	}
}
