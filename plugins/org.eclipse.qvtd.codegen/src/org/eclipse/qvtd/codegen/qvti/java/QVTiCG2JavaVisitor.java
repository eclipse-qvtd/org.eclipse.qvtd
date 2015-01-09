/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
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
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty;
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
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
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
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.evaluation.AbstractTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

/**
 * A QVTiCG2JavaVisitor supports generation of Java code from an optimized QVTi CG transformation tree.
 */
public class QVTiCG2JavaVisitor extends CG2JavaVisitor<QVTiCodeGenerator> implements QVTiCGModelVisitor<Boolean>
{
	protected final @NonNull QVTiAnalyzer analyzer;
	protected final @NonNull CGPackage cgPackage;
	protected final @Nullable List<CGValuedElement> sortedGlobals;
	
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
							if ((pOppositeProperty != null) && pOppositeProperty.isComposite()) {
// FIXME must check for null asssignment and correct target								return;
							}
						}
					}
				}
			}
		}
		CGTypedModel cgTypedModel = cgRealizedVariable.getTypedModel();
		//
		js.append("modelObjects[");
		appendModelIndex(cgTypedModel);
		js.append("].add(");
		js.appendValueName(cgRealizedVariable);
		js.append(");\n");
	}

	protected String[] doAllInstances(@NonNull QVTiTransformationAnalysis transformationAnalysis) {
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
			js.appendClassReference(ClassId.class);
			js.append("[]{\n");
			js.pushIndentation(null);
			for (int i = 0; i < sortedList.size(); i++) {
				org.eclipse.ocl.pivot.Class instancesClass = sortedList.get(i);
				CGTypeId cgTypeId = getCodeGenerator().getAnalyzer().getTypeId(instancesClass.getTypeId());
				js.appendValueName(cgTypeId);
				if ((i+1) < sortedList.size()) {
					js.append(",");
				}
				js.append("\t\t// " + i + " => " + instancesClass.getName() + "\n");
			}
			js.popIndentation();
			js.append("};\n");
			//
			//	Emit the classIndex2allClassIndexes array of arrays
			//
			String classIndex2allClassIndexes = nameManager.getGlobalSymbolName(null, "classIndex2allClassIndexes");
			js.append("/*\n");
			js.append(" * Mapping from each ClassIndex to all the ClassIndexes to which an object of the outer index\n");
			js.append(" * may contribute results to an allInstances() invocation.\n");
			js.append(" * Non trivial inner arrays arise when one ClassId is a derivation of another and so an\n");
			js.append(" * instance of the derived classId contributes to derived and inherited ClassIndexes.\n");
			js.append(" */\n");
			js.append("private final static ");
			js.appendIsRequired(true);
			js.append(" ");
			js.appendClassReference(int.class);
			js.append("[][] ");
			js.append(classIndex2allClassIndexes);
			js.append(" = new ");
			js.appendClassReference(int.class);
			js.append("[][] {\n");
			js.pushIndentation(null);
			for (int i = 0; i < sortedList.size(); i++) {
				org.eclipse.ocl.pivot.Class instancesClass = sortedList.get(i);
				List<org.eclipse.ocl.pivot.Class> superInstancesClasses = instancesClassAnalysis.get(instancesClass);
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
				js.append("\t\t// " + i + " : ");
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
			return new String[]{ classIndex2classIdName, classIndex2allClassIndexes};
		}
		return null;
    }

	protected void doConstructor(@NonNull CGTransformation cgTransformation, @Nullable String[] allInstancesNames) {
//		String evaluatorName = ((QVTiGlobalContext)globalContext).getEvaluatorParameter().getName();
		String evaluatorName = JavaConstants.EVALUATOR_NAME;
		String className = cgTransformation.getName();
		//
		js.append("public " + className + "(final ");
		js.appendIsRequired(true);
		js.append(" ");
		js.appendClassReference(Evaluator.class);
		js.append(" " + evaluatorName + ") {\n");
		js.pushIndentation(null);		
		js.append("super(" + evaluatorName + ", new String[] {");
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
		js.popIndentation();
		js.append("}\n");
	}
    
	protected void doMiddleOppositeCaches() {
		Map<Property, String> toMiddleProperties = getGlobalContext().getToMiddleProperties();
		if (toMiddleProperties != null) {
			js.append("\n/* Outer-to-Middle Property navigation caches */\n");
			Map<String, Property> key2property = new HashMap<String, Property>();
			for (Map.Entry<Property, String> entry : toMiddleProperties.entrySet()) {
				key2property.put(entry.getValue(), entry.getKey());
			}
			List<String> sortedKeys = new ArrayList<String>(key2property.keySet());
			Collections.sort(sortedKeys);
			for (String key : sortedKeys) {
				Property property = key2property.get(key);
				TypeDescriptor outerTypeDescriptor = context.getBoxedDescriptor(property.getOwningClass().getTypeId());
				TypeDescriptor middleTypeDescriptor = context.getBoxedDescriptor(property.getType().getTypeId());
				js.append("protected final ");
				js.appendIsRequired(true);
				js.append(" ");
				js.appendClassReference(Map.class, false, middleTypeDescriptor, outerTypeDescriptor);
				js.append(" ");
				js.append(key);
				js.append(" = new ");
				js.appendClassReference(HashMap.class, false, middleTypeDescriptor, outerTypeDescriptor);
				js.append("();\n");
			}
		}
    }

	@SuppressWarnings("null")
	protected void doRun(@NonNull CGTransformation cgTransformation) {
		CGMapping cgRootMapping = NameUtil.getNameable(cgTransformation.getMappings(), QVTimperativeUtil.ROOT_MAPPING_NAME);
		if (cgRootMapping == null) {
        	throw new IllegalStateException("Transformation " + cgTransformation.getName() + " has no root mapping");
		}
		List<CGGuardVariable> cgFreeVariables = cgRootMapping.getFreeVariables();
		NameManager nameManager = globalContext.getNameManager();
		Map<CGParameter, String> listNames = new HashMap<CGParameter, String>();
		for (CGGuardVariable cgFreeVariable : cgFreeVariables) {
			String nameHint = "LIST_" + cgFreeVariable.getValueName();
			String listName = nameManager.getGlobalSymbolName(null, nameHint);
			listNames.put(cgFreeVariable, listName);
		}
		//
		js.append("public boolean run() {\n");
		js.pushIndentation(null);
		for (@NonNull CGGuardVariable cgFreeVariable : cgFreeVariables) {
			TypeDescriptor typeDescriptor = context.getTypeDescriptor(cgFreeVariable);
			EClassifier eClassifier = ClassUtil.nonNullState(typeDescriptor.getEClassifier());
			String qualifiedPackageInterfaceName = genModelHelper.getQualifiedPackageInterfaceName(eClassifier.getEPackage());
			String classifierLiteralName = genModelHelper.getLiteralName(eClassifier);
			String nameHint = "ECLASS_" + cgFreeVariable.getValueName();
			String eClassName = nameManager.getGlobalSymbolName(null, nameHint);
			//
			js.append("final ");
			js.appendClassReference(EClass.class);
			js.append(" ");
			js.append(eClassName);
			js.append(" = ");
			js.appendClassReference(qualifiedPackageInterfaceName);
			js.append(".Literals." + classifierLiteralName);
			js.append(";\n");
			//
			js.append("assert ");
			js.append(eClassName);
			js.append(" != null;\n");
			//
			js.appendClassReference(List.class, true, typeDescriptor);
			js.append(" ");
			js.append(listNames.get(cgFreeVariable));
			js.append(" = getObjectsByType(");
			js.appendClassReference(typeDescriptor);
			js.append(".class, ");
			appendModelIndex(cgFreeVariable.getTypedModel());
			js.append(", ");
			js.append(eClassName);
			js.append(");\n");
		}
		for (CGGuardVariable cgFreeVariable : cgFreeVariables) {
			js.append("for (");
//			if (cgFreeVariable.isNonNull()) {
//				js.append("@SuppressWarnings(\"null\")@NonNull ");
//			}
			js.appendClassReference(cgFreeVariable);
			js.append(" ");
			js.appendValueName(cgFreeVariable);
			js.append(" : ");
			js.append(listNames.get(cgFreeVariable));
			js.append(") {\n");
			js.pushIndentation(null);
			js.append("if (");
			js.appendValueName(cgFreeVariable);
			js.append(" != null) {\n");
			js.pushIndentation(null);
		}
		js.append(cgRootMapping.getName());
		js.append("(");
		boolean isFirst = true;
		for (CGGuardVariable cgFreeVariable : cgFreeVariables) {
			if (!isFirst) {
				js.append(", ");
			}
			js.appendValueName(cgFreeVariable);
			isFirst = false;
		}
		js.append(");\n");
		for (@SuppressWarnings("unused") CGGuardVariable cgFreeVariable : cgFreeVariables) {
			js.popIndentation();
			js.append("}\n");
			js.popIndentation();
			js.append("}\n");
		}
		js.append("return true;\n");
		js.popIndentation();		
		js.append("}\n");
	}

	protected @NonNull QVTiGlobalContext getGlobalContext() {
		return (QVTiGlobalContext) globalContext;
	}

	protected @Nullable TypeDescriptor needsTypeCheck(@NonNull CGMappingCallBinding cgMappingCallBinding) {
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

	@Override
	public @NonNull Boolean visitCGEcorePropertyAssignment(@NonNull CGEcorePropertyAssignment cgPropertyAssignment) {
//		Property pivotProperty = cgPropertyCallExp.getReferredProperty();
//		CGTypeId cgTypeId = analyzer.getTypeId(pivotProperty.getOwningType().getTypeId());
//		JavaTypeDescriptor requiredTypeDescriptor = context.getJavaTypeDescriptor(cgTypeId, false);
		EStructuralFeature eStructuralFeature = ClassUtil.nonNullModel(cgPropertyAssignment.getEStructuralFeature());
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
		//
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
		return true;
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
		js.append(cgFunctionCallExp.getFunction().getName());
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
				String eName = globalContext.getEName();
				CGValuedElement cgBody = cgMapping.getBody();
				List<CGGuardVariable> cgFreeVariables = cgMapping.getFreeVariables();
				//
				js.appendCommentWithOCL(null, cgMapping.getAst());
				js.append("protected boolean " + cgMapping.getName() + "(");
				boolean isFirst = true;
				for (@SuppressWarnings("null")@NonNull CGGuardVariable cgFreeVariable : cgFreeVariables) {
					if (!isFirst) {
						js.append(", ");
					}
					js.appendDeclaration(cgFreeVariable);
					isFirst = false;
				}
				js.append(") {\n");
				js.pushIndentation(null);
					if (cgBody.isNonInvalid()) {
						js.append("// predicates\n");
						cgBody.accept(this);
						js.append("return true;\n");
					}
					else {
						js.append("try {\n");
						js.pushIndentation(null);
							js.append("// predicates\n");
							cgBody.accept(this);
							js.append("return true;\n");
						js.popIndentation();
						js.append("}\n");
						js.append("catch (");
						js.appendClassReference(Exception.class);
						js.append(" " + eName + ") {\n");
						js.pushIndentation(null);
							js.append("return false;\n");
						js.popIndentation();
						js.append("}\n");
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
		}
		//
		//	Emit the mapping call.
		//
		js.append(cgReferredMapping.getName() + "(");
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
		js.append("// creations\n");
		for (CGValuedElement cgRealizedVariable : cgMappingExp.getRealizedVariables()) {
			cgRealizedVariable.accept(this);
		}
		js.append("// assignments\n");
		for (CGPropertyAssignment cgAssignment : cgMappingExp.getAssignments()) {
			cgAssignment.accept(this);
		}
		js.append("// mapping statements\n");
		CGValuedElement body = cgMappingExp.getBody();
		if (body != null) {
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
		js.append(";\n");
		js.append("for (");
//		if (iterator.isNonNull()) {
//			js.append("@SuppressWarnings(\"null\")@NonNull ");
//		}
		js.appendClassReference(iterator);
		js.append(" ");
		js.appendValueName(iterator);
		js.append(" : ");
		js.appendValueName(source);
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
		assert !pReferredProperty.isImplicit();
		CGValuedElement slotValue = cgMiddlePropertyAssignment.getSlotValue();
		CGValuedElement initValue = cgMiddlePropertyAssignment.getInitValue();
		if ((slotValue != null) && (initValue != null)) {
			Map<Property, String> toMiddleProperties = getGlobalContext().getToMiddleProperties();
			if (toMiddleProperties != null) {
				String cacheName = toMiddleProperties.get(pReferredProperty);
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
		assert !pivotProperty.isImplicit();
		CGValuedElement source = getExpression(cgPropertyCallExp.getSource());
		//
		if (!js.appendLocalStatements(source)) {
			return false;
		}
		//
		js.appendDeclaration(cgPropertyCallExp);
		js.append(" = ");
		Map<Property, String> toMiddleProperties = getGlobalContext().getToMiddleProperties();
		if (toMiddleProperties != null) {
			String cacheName = toMiddleProperties.get(pivotProperty);
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
			booleanCondition = js.is_boolean(cgConditionExpression);
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
		QVTiTransformationAnalysis transformationAnalysis = new QVTiTransformationAnalysis(getMetamodelManager());
		@SuppressWarnings("null")@NonNull Transformation transformation = (Transformation) cgTransformation.getAst();
		transformationAnalysis.analyzeTransformation(transformation);
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
		js.appendClassReference(AbstractTransformationExecutor.class);
		js.append("\n");
		js.append("{\n");
		js.pushIndentation(null);
		if (sortedGlobals != null) {
			for (CGValuedElement cgElement : sortedGlobals) {
				assert cgElement.isGlobal();
				cgElement.accept(this);
			}
		}
		doMiddleOppositeCaches();
		js.append("\n");
		String[] allInstancesNames = doAllInstances(transformationAnalysis);
		js.append("\n");
		doConstructor(cgTransformation, allInstancesNames);
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
