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

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.calling.AbstractOperationCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGShadowExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGShadowPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGUnboxExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.java.JavaStream.SubStream;
import org.eclipse.ocl.examples.codegen.java.types.AbstractDescriptor;
import org.eclipse.ocl.examples.codegen.java.types.EObjectDescriptor;
import org.eclipse.ocl.examples.codegen.naming.NameResolution;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.utilities.QVTiCGModelCG2JavaVisitor;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EntryPointsAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractComputation;

/**
 *  FunctionOperationCallingConvention defines the support for the call of a QVTi function.
 */
public abstract class FunctionOperationCallingConvention extends AbstractOperationCallingConvention	// cf ConstrainedOperationCallingConvention
{
	protected boolean doFunctionBody(@NonNull QVTiCGModelCG2JavaVisitor qvticg2javaVisitor, @NonNull JavaStream js, @NonNull CGFunction cgFunction) {
		CGValuedElement body = qvticg2javaVisitor.getExpression(cgFunction.getBody());
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
					TypeDescriptor javaTypeDescriptor = qvticg2javaVisitor.getCodeGenerator().getUnboxedDescriptor(elementId);
					js.appendClassReference(null, javaTypeDescriptor);
				}
				String emptyListName = qvticg2javaVisitor.getCodeGenerator().getGlobalNameManager().getEmptyListName();
				js.append(" " + emptyListName + " = ");
				js.appendClassReference(null, Collections.class);
				js.append("." + emptyListName + "();\n");
				js.append("return " + emptyListName + ";\n");
			}
			else {			// FIXME Fudge for body-less functions
				js.append("return \"\";\n");
			}
		}
		js.popIndentation();
		js.append("}\n");
		return true;
	}

	protected boolean doFunctionBody2(@NonNull QVTiCGModelCG2JavaVisitor qvticg2javaVisitor, @NonNull JavaStream js, @NonNull CGFunction cgFunction, @NonNull CGShadowExp cgShadowExp) {
		QVTiCodeGenerator codeGenerator = qvticg2javaVisitor.getCodeGenerator();
		boolean isIncremental = codeGenerator.getOptions().isIncremental();
		Function function = QVTiCGUtil.getAST(cgFunction);
		ImperativeTransformation transformation = QVTimperativeUtil.getContainingTransformation(function);
		EntryPointsAnalysis entryPointsAnalysis = codeGenerator.getEntryPointsAnalysis(transformation);
		String functionName = cgFunction.getResolvedName();
		String cachedResultName = codeGenerator.getGlobalNameManager().getCachedResultName();
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
			qvticg2javaVisitor.doEcoreCreateDataType(cgShadowExp, (EDataType)eClassifier, cgInit);
		}
		else if (eClassifier instanceof EClass) {
			if (!qvticg2javaVisitor.doEcoreCreateClass(cgShadowExp, (EClass)eClassifier, false)) {
				return false;
			}
			GenModelHelper genModelHelper = qvticg2javaVisitor.getGenModelHelper();
			int index = 0;
			for (@NonNull CGShadowPart cgShadowPart : ClassUtil.nullFree(cgShadowExp.getParts())) {
				Property asProperty = ClassUtil.nonNullState(((ShadowPart)cgShadowPart.getAst()).getReferredProperty());
				EStructuralFeature eStructuralFeature = ClassUtil.nonNullState(qvticg2javaVisitor.getESObject(asProperty));
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
		js.append(cachedResultName);
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
			CGTypedModel cgTypedModel = qvticg2javaVisitor.getAnalyzer().getTypedModel(asTypedModel);
			qvticg2javaVisitor.appendModelReference(cgTypedModel);
			js.append(".add(");
			js.appendValueName(cgShadowExp);
			js.append(");\n");
		}
		//
		js.popIndentation();
		js.append("}\n");
		return true;
	}

	protected boolean doFunctionBody3(@NonNull QVTiCGModelCG2JavaVisitor qvticg2javaVisitor, @NonNull JavaStream js, @NonNull CGFunction cgFunction) {
		QVTiCodeGenerator codeGenerator = qvticg2javaVisitor.getCodeGenerator();
		QVTiGlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		String functionName = cgFunction.getResolvedName();
		String cachedResultName = globalNameManager.getCachedResultName();
		CGValuedElement cgBody = cgFunction.getBody();
		ElementId elementId = cgFunction.getTypeId().getElementId();
		// FIXME merge locals into AST as LetExps.
		if (cgBody != null) {
			CGValuedElement body = qvticg2javaVisitor.getExpression(cgBody);
			if (!js.appendLocalStatements(body)) {
				return false;
			}
			js.appendThis(functionName);
			js.append("." + cachedResultName + " = ");
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
			js.append(qvtiGlobalContext.getExecutorName());
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
				js.append("." + cachedResultName + " = \"\";\n");
			}
			else if (asTypeId == TypeId.REAL) {			// FIXME Fudge for body-less functions
				js.appendThis(functionName);
				js.append("." + cachedResultName + " = 0;\n");
			}
			else if (asTypeId == TypeId.INTEGER) {			// FIXME Fudge for body-less functions
				js.appendThis(functionName);
				js.append("." + cachedResultName + " = 0;\n");
			}
			else if (asTypeId instanceof CollectionTypeId) {			// FIXME Fudge for body-less functions
				if (js.isUseNullAnnotations()) {
					js.appendSuppressWarningsNull(false);
					js.appendIsRequired(true);
					js.append(" ");
				}
				if (elementId != null) {
					TypeDescriptor javaTypeDescriptor = codeGenerator.getUnboxedDescriptor(elementId);
					js.appendClassReference(null, javaTypeDescriptor);
				}
				String emptyListName = globalNameManager.getEmptyListName();
				js.append(" " + emptyListName + " = ");
				js.appendClassReference(null, Collections.class);
				js.append("." + emptyListName + "();\n");
				js.appendThis(functionName);
				js.append("." + cachedResultName + " = " + emptyListName + ";\n");
			}
			else {			// FIXME Fudge for body-less functions
				js.appendThis(functionName);
				js.append("." + cachedResultName + " = \"\";\n");
			}
		}
		return true;
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

	protected void doFunctionConstructor(@NonNull QVTiCGModelCG2JavaVisitor qvticg2javaVisitor, @NonNull JavaStream js, @NonNull CGFunction cgFunction) {
		QVTiCodeGenerator codeGenerator = qvticg2javaVisitor.getCodeGenerator();
		boolean isIncremental = codeGenerator.getOptions().isIncremental();
		String functionName = cgFunction.getResolvedName();
		NameResolution thisTransformerNameResolution = codeGenerator.getGlobalNameManager().getThisTransformerNameResolution();
		//	String thisTransformerName = globalContext.getThisTransformerName();
		//	String cachedResultName = globalContext.getCachedResultName();
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
		js.append("(/*@Nullable*/ Object ");
		js.appendIsRequired(true);
		js.append(" [] boundValues) {\n");
		js.pushIndentation(null);
		if (isIncremental) {
			js.append("super(\"");
			js.append(functionName);
			js.append("\");\n");
		}
		//	js.appendThis(functionName);
		//	js.append("." + thisTransformerName + " = (");
		//	js.appendClassReference(cgClass);
		//	js.append(")boundValues[0];\n");
		int i = 0;
		for (@NonNull CGParameter cgParameter : cgParameters) {
			int finalI = i++;
			if (cgParameter.getNameResolution() == thisTransformerNameResolution) {			// XXX Is this irregularity really necessary
				String valueName = qvticg2javaVisitor.getResolvedName(cgParameter);
				js.appendThis(functionName);
				js.append(".");
				js.append(valueName);
				js.append(" = ");
				js.append("(");
				js.appendIsRequired(true);
				js.append(" ");
				js.append(cgClass.getName());
				js.append(")boundValues[" + finalI + "]");
				js.append(";\n");
			}
			else {
				SubStream castBody1 = new SubStream() {
					@Override
					public void append() {
						js.append("boundValues[" + finalI + "]");
					}
				};
				String valueName = qvticg2javaVisitor.getResolvedName(cgParameter);
				///	js.appendTypeDeclaration(cgParameter);
				//	TypeRepresentation boxedTypeRepresentation = js.getBoxedTypeRepresentation();
				//	boxedTypeRepresentation.appendTypeDeclaration(cgParameter);			// FIXME this doesn't enforce boxed if cgElement is primitive
				Boolean isRequired = codeGenerator.isRequired(cgParameter);
				js.appendIsCaught(cgParameter.isNonInvalid(), cgParameter.isCaught());
				js.append(" ");
				//	boxedTypeRepresentation.appendClassReference(isRequired, cgParameter);
				assert cgParameter != null;
				assert !cgParameter.getNamedValue().isCaught();
				ElementId elementId = cgParameter.getTypeId().getElementId();
				TypeDescriptor boxedTypeDescriptor = codeGenerator.getBoxedDescriptor(elementId);
				if ((cgParameter instanceof CGParameter) && (cgParameter.eContainer() instanceof CGOperation) && (boxedTypeDescriptor instanceof EObjectDescriptor)) {		// FIXME eliminate reclassing
					Class<?> originalJavaClass = ((EObjectDescriptor)boxedTypeDescriptor).getOriginalJavaClass();
					js.appendClassReference(isRequired, originalJavaClass);
				}
				else {
					boxedTypeDescriptor.append(js, isRequired);
				}
				js.append(" ");
				js.append(valueName);
				js.append(" = ");
				//	js.appendClassCast(cgParameter, castBody1);
				boxedTypeDescriptor.appendCast(js, isRequired, null, castBody1);
				js.append(";\n");
				SubStream castBody2 = new SubStream() {
					@Override
					public void append() {
						js.append(valueName);
					}
				};
				js.appendThis(functionName);			//  XXX Not needed. This is precisely "this"
				js.append(".");
				js.append(valueName);
				js.append(" = ");
				//	js.appendClassCast(cgParameter, castBody2);
				assert cgParameter != null;
				AbstractDescriptor declaredTypeDescriptor = (AbstractDescriptor) codeGenerator.getTypeDescriptor(cgParameter);
				declaredTypeDescriptor.appendCast(js, isRequired, declaredTypeDescriptor.getNonPrimitiveJavaClass(), castBody2);
				js.append(";\n");
			}
		}
		doFunctionBody3(qvticg2javaVisitor, js, cgFunction);
		js.popIndentation();
		js.append("}\n");
	}

	protected void doFunctionConstructor(@NonNull QVTiCGModelCG2JavaVisitor qvticg2javaVisitor, @NonNull JavaStream js, @NonNull CGFunction cgFunction, @NonNull CGShadowExp cgShadowExp) {
		//		List<@NonNull CGParameter> cgParameters = ClassUtil.nullFree(cgFunction.getParameters());
		//		if (js.isUseNullAnnotations()) {
		//			js.append("@SuppressWarnings(\"null\")\n");		// Accurate casts are too hard
		//		}
		js.append("public ");
		js.appendValueName(cgFunction);
		js.append("(/*Nullable*/ Object ");
		js.appendIsRequired(true);
		js.append(" [] boundValues) ");
		/*		int i = 0;
			for (@NonNull CGParameter cgParameter : cgParameters) {
				String valueName = getResolvedName(cgParameter);
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
		doFunctionBody2(qvticg2javaVisitor, js, cgFunction, cgShadowExp);
	}

	protected void doFunctionGetInstance(@NonNull QVTiCGModelCG2JavaVisitor qvticg2javaVisitor, @NonNull JavaStream js, @NonNull CGFunction cgFunction) {
		String cachedResultName = qvticg2javaVisitor.getCodeGenerator().getGlobalNameManager().getCachedResultName();
		js.append("@Override\n");
		js.append("public ");
		js.appendIsRequired(false);
		js.append(" Object");
		//		js.appendTypeDeclaration(ClassUtil.nonNullState(cgFunction.getBody()));
		js.append(" getResult() {\n");
		js.pushIndentation(null);
		js.append("return " + cachedResultName + ";\n");
		js.popIndentation();
		js.append("}\n");
	}

	protected void doFunctionIsEqual(@NonNull QVTiCGModelCG2JavaVisitor qvticg2javaVisitor, @NonNull JavaStream js, @NonNull CGFunction cgFunction) {
		String functionName = cgFunction.getResolvedName();
		//	String thisTransformerName = qvticg2javaVisitor.getCodeGenerator().getGlobalNameManager().getThisTransformerName();
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
		//	js.appendThis(functionName);
		//	js.append("." + thisTransformerName + " == thoseValues[0]");
		int index = 0;
		for (@NonNull CGParameter cgParameter : ClassUtil.nullFree(cgFunction.getParameters())) {
			if (index > 0) {
				js.append("\n\t&& ");
			}
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

	protected void doFunctionIsEqual(@NonNull QVTiCGModelCG2JavaVisitor qvticg2javaVisitor, @NonNull JavaStream js, @NonNull CGShadowExp cgShadowExp, @NonNull String instanceName) {
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
			EStructuralFeature eStructuralFeature = ClassUtil.nonNullState(qvticg2javaVisitor.getESObject(asProperty));
			String getAccessor;
			if (eStructuralFeature == OCLstdlibPackage.Literals.OCL_ELEMENT__OCL_CONTAINER) {
				getAccessor = "eContainer";
			}
			else {
				getAccessor = qvticg2javaVisitor.getGenModelHelper().getGetAccessor(eStructuralFeature);
			}
			js.append(getAccessor);
			js.append("(), thoseValues[" + index++ + "])");
		}
		js.append(";\n");
		js.popIndentation();
		js.append("}\n");
	}

	@Override
	public boolean generateJavaCall(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperationCallExp cgOperationCallExp) {
		QVTiCGModelCG2JavaVisitor qvticg2javaVisitor = (QVTiCGModelCG2JavaVisitor)cg2javaVisitor;
		QVTiCodeGenerator codeGenerator = qvticg2javaVisitor.getCodeGenerator();
		CGFunctionCallExp cgFunctionCallExp = (CGFunctionCallExp)cgOperationCallExp;
		CGFunction cgFunction = (CGFunction)QVTiCGUtil.getOperation(cgFunctionCallExp);
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		//	Operation pOperation = cgFunctionCallExp.getReferredOperation();
		//	CGFunction cgFunction = ClassUtil.nonNullState(cgFunctionCallExp.getFunction());
		boolean useClassToCreateObject = codeGenerator.getShadowExp(asFunction) != null;
		boolean useCache = !asFunction.isIsTransient();
		boolean isIdentifiedInstance = useCache;
		List<CGValuedElement> cgArguments = cgFunctionCallExp.getArguments();
		List<Parameter> asParameters = asFunction.getOwnedParameters();
		List<CGParameter> cgParameters = cgFunction.getParameters();
		//
		for (@SuppressWarnings("null")@NonNull CGValuedElement cgArgument : cgArguments) {
			CGValuedElement argument = qvticg2javaVisitor.getExpression(cgArgument);
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
			js.appendValueName(cgFunction);
			js.append(")");
			js.append(qvticg2javaVisitor.getFunctionCtorName(cgFunction));
			js.append(".getUniqueComputation(");
			//			if (useCache && !useClassToCreateObject) {
			//				CGClass cgClass = ClassUtil.nonNullState(cgFunction.getContainingClass());
			//				//				js.appendClassReference(cgClass);
			//				//				js.append(".this");
			//				qvticg2javaVisitor.appendThis(cgClass);
			//				needComma = true;
			//			}
		}
		else {
			//	js.append(asFunction.getName());
			js.appendValueName(cgFunction);
			js.append("(");
		}
		int iMax = cgParameters.size();
		assert iMax == cgArguments.size();
		for (int i = 0; i < iMax; i++) {
			if (needComma) {
				js.append(", ");
			}
			//	CGParameter cgParameter = cgParameters.get(i);
			CGValuedElement cgArgument = cgArguments.get(i);
			CGValuedElement argument = qvticg2javaVisitor.getExpression(cgArgument);
			//	TypeId asTypeId = cgParameter.getTypeId().getASTypeId();
			//	assert asTypeId != null;
			//	TypeDescriptor parameterTypeDescriptor = codeGenerator.getUnboxedDescriptor(asTypeId);
			//	js.appendReferenceTo(parameterTypeDescriptor, argument);
			js.appendValueName(argument);
			needComma = true;
		}
		js.append(")");
		if (isIdentifiedInstance) {
			js.append(")");
			//	String cachedResultName = qvticg2javaVisitor.getVariantResolvedName(cgFunction, codeGenerator.getCACHED_RESULT_NameVariant());
			String cachedResultName = qvticg2javaVisitor.getCodeGenerator().getGlobalNameManager().getCachedResultName();
			js.append(".");
			js.append(cachedResultName);
		}
		js.append(";\n");
		return true;
	}

	@Override
	public boolean generateJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperation cgOperation) {
		QVTiCGModelCG2JavaVisitor qvticg2javaVisitor = (QVTiCGModelCG2JavaVisitor)cg2javaVisitor;
		QVTiCodeGenerator codeGenerator = qvticg2javaVisitor.getCodeGenerator();
		CGFunction cgFunction = (CGFunction)cgOperation;
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		List<CGParameter> cgParameters = cgFunction.getParameters();
		boolean isIncremental = codeGenerator.getOptions().isIncremental();
		//
		js.appendCommentWithOCL(null, cgFunction.getAst());
		ShadowExp asShadowExp = codeGenerator.getShadowExp(asFunction);
		String functionName = cgFunction.getResolvedName();
		String cachedResultName = codeGenerator.getGlobalNameManager().getCachedResultName();
		assert asShadowExp == null;		// ShadowFunctionOperationCallingConvention overload
		if (!asFunction.isIsTransient()) {
			NameResolution thisTransformerNameResolution = codeGenerator.getGlobalNameManager().getThisTransformerNameResolution();
			//	String thisTransformerName = thisTransformerNameResolution.getResolvedName();
			CGClass cgClass = ClassUtil.nonNullState(CGUtil.getContainingClass(cgFunction));
			js.append("protected class ");
			js.append(functionName);
			js.append(" extends ");
			js.appendClassReference(null, isIncremental ? AbstractComputation.Incremental.class : AbstractComputation.class);
			js.pushClassBody(functionName);
			//	js.append("protected final ");
			//	js.appendIsRequired(true);
			//	js.append(" ");
			//	js.appendClassReference(cgClass);
			//	js.append(" " + thisTransformerName + ";\n");
			for (@NonNull CGParameter cgParameter : ClassUtil.nullFree(cgFunction.getParameters())) {
				js.append("protected final ");
				//						js.appendDeclaration(cgParameter);
				//						js.appendTypeDeclaration(cgParameter);
				boolean isPrimitive = js.isPrimitive(cgParameter);
				boolean isRequired = !isPrimitive && !cgParameter.isAssertedNonNull() && cgParameter.isNonNull() && !(cgParameter instanceof CGUnboxExp)/*|| cgElement.isRequired()*/;	// FIXME Ugh!
				js.appendIsCaught(cgParameter.isNonInvalid(), cgParameter.isCaught());
				js.append(" ");
				if (cgParameter.getNameResolution() == thisTransformerNameResolution) {				// XXX why can't we use a correct CGTypeId albeit with a Future ...
					// js.appendClassReference(cgClass);			-- qualification not needed
					js.appendIsRequired(true);
					js.append(" ");
					js.append(cgClass.getName());
				}
				else {
					js.appendClassReference(isPrimitive ? null : isRequired ? true : null, cgParameter);
				}
				js.append(" ");
				js.appendValueName(cgParameter);
				js.append(";\n");
			}
			//		CGValuedElement body = getExpression(cgFunction.getBody());
			//ElementId elementId = cgFunction.getTypeId().getElementId();

			js.append("protected final ");
			CGValuedElement cgBody = cgFunction.getBody();
			js.appendTypeDeclaration(cgBody != null ? cgBody : cgFunction);
			js.append(" " + cachedResultName + ";\n");
			js.append("\n");
			doFunctionConstructor(qvticg2javaVisitor, js, cgFunction);
			js.append("\n");
			doFunctionGetInstance(qvticg2javaVisitor, js, cgFunction);
			js.append("\n");
			doFunctionIsEqual(qvticg2javaVisitor, js, cgFunction);
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
				TypeDescriptor javaTypeDescriptor = codeGenerator.getUnboxedDescriptor(elementId);
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
			return doFunctionBody(qvticg2javaVisitor, js, cgFunction);
		}
		return true;
	}
}
