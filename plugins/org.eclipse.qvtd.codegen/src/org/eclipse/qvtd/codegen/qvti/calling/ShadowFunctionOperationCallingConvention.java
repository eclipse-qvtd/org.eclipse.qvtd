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

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.calling.AbstractCachedOperationCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGShadowExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGShadowPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.java.JavaStream.SubStream;
import org.eclipse.ocl.examples.codegen.naming.ExecutableNameManager;
import org.eclipse.ocl.examples.codegen.naming.GlobalNameManager;
import org.eclipse.ocl.examples.codegen.naming.NameResolution;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.LibraryOperation;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCG2JavaVisitor;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.codegen.qvti.naming.QVTiGlobalNameManager;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EntryPointsAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractComputation;

/**
 *  ShadowFunctionOperationCallingConvention defines the support for the call of a QVTi function to create a keyed shaow object.
 */
public abstract class ShadowFunctionOperationCallingConvention extends AbstractCachedOperationCallingConvention // cg Cached/Constrained
{
	public static class FunctionEvaluateOperationCallingConvention extends AbstractEvaluateOperationCallingConvention
	{
		private static final @NonNull FunctionEvaluateOperationCallingConvention INSTANCE = new FunctionEvaluateOperationCallingConvention();

		public static @NonNull FunctionEvaluateOperationCallingConvention getInstance(org.eclipse.ocl.pivot.@NonNull Class asClass) {
			INSTANCE.logInstance(asClass);
			return INSTANCE;
		}

		@Override
		protected void generateUniqueComputationArguments(@NonNull CG2JavaVisitor cg2javaVisitor, boolean isFirst, @NonNull GlobalNameManager globalNameManager, @NonNull CGOperation cgOperation) {
			cg2javaVisitor.getJavaStream().appendName(globalNameManager.getRootThisName());
			super.generateUniqueComputationArguments(cg2javaVisitor, false, globalNameManager, cgOperation);
		}

		@Override
		protected @NonNull ASParameterStyle @NonNull [] getASParameterStyles(@NonNull TypedElement asOrigin) {
			return AS_PARAMETER_STYLES_PARAMETERS;
		}
	}

	@Override
	public void createCGBody(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgOperation) {
		CGFunction cgFunction = (CGFunction)cgOperation;
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		OCLExpression query = asFunction.getQueryExpression(); //getBodyExpression();
		//	callingConvention.createCGParameters(this, cgFunction, null);
		assert asFunction.getImplementationClass() == null;
		assert query != null;
		//			try {
		//				ExpressionInOCL query = metamodelManager.parseSpecification(specification);
		//				Variable contextVariable = query.getOwnedContext();
		//				if (contextVariable != null) {
		//					getParameter(contextVariable);
		//				}
		//				for (@SuppressWarnings("null")@NonNull Variable parameterVariable : query.getOwnedParameters()) {
		//					getParameter(parameterVariable);
		//				}
		//	cgFunction.setBody(doVisit(CGValuedElement.class, query)); //.getOwnedBody()));
		super.createCGBody(analyzer, cgFunction);
		//			} catch (ParserException e) {
		// TODO Auto-generated catch block
		//				e.printStackTrace();
		//			}
		//	analyzer.addFunction(asFunction, cgFunction); */
	}

	@Override
	public @NonNull CGOperation createCGOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull Operation asOperation) {
		assert asOperation.getImplementationClass() == null;
		return QVTiCGModelFactory.eINSTANCE.createCGFunction();
	}

	@Override
	public @NonNull CGValuedElement createCGOperationCallExp(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgOperation, @NonNull LibraryOperation libraryOperation,
			@Nullable CGValuedElement cgSource, @NonNull OperationCallExp asOperationCallExp) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		Operation asOperation = CGUtil.getAST(cgOperation);
		boolean useClassToCreateObject = PivotUtil.basicGetShadowExp(asOperation) != null;
		assert useClassToCreateObject;
		CGOperationCallExp cgOperationCallExp = CGModelFactory.eINSTANCE.createCGLibraryOperationCallExp();
		initCallExp(qvtiAnalyzer, cgOperationCallExp, asOperationCallExp, cgOperation, asOperation.isIsRequired());
		assert cgSource instanceof CGVariableExp;
		assert CGUtil.getReferredVariable((CGVariableExp)cgSource).basicGetNameResolution() == codeGenerator.getGlobalNameManager().getRootThisName();
		initCallArguments(qvtiAnalyzer, cgOperationCallExp);
		return cgOperationCallExp;
	}

	protected boolean doFunctionBody(@NonNull QVTiCG2JavaVisitor qvticg2javaVisitor, @NonNull JavaStream js, @NonNull CGFunction cgFunction) {
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
				String emptyListName = qvticg2javaVisitor.getCodeGenerator().getGlobalNameManager().getEmptyListName().getResolvedName();
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

	protected boolean doFunctionBody2(@NonNull QVTiCG2JavaVisitor qvticg2javaVisitor, @NonNull CGFunction cgFunction, @NonNull CGShadowExp cgShadowExp) {
		JavaStream js = qvticg2javaVisitor.getJavaStream();
		QVTiCodeGenerator codeGenerator = qvticg2javaVisitor.getCodeGenerator();
		boolean isIncremental = codeGenerator.getOptions().isIncremental();
		Function function = QVTiCGUtil.getAST(cgFunction);
		ImperativeTransformation transformation = QVTimperativeUtil.getContainingTransformation(function);
		EntryPointsAnalysis entryPointsAnalysis = codeGenerator.getEntryPointsAnalysis(transformation);
		String functionName = cgFunction.getResolvedName();
		QVTiGlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
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

			List<CGParameter> cgParameters = cgFunction.getParameters();
			assert cgParameters.size() == 1;
			for (@NonNull CGParameter cgParameter : cgParameters) {
				js.appendDeclaration(cgParameter);
				js.append(" = ");
				assert !(cgParameter instanceof CGConnectionVariable);
				SubStream castBody = new SubStream() {
					@Override
					public void append() {
						js.append("boundValues[" + 0 + "]");
					}
				};
				js.appendClassCast(cgParameter, castBody);
				js.append(";\n");
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
		js.appendName(globalNameManager.getCachedResultName());
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

	protected void doFunctionConstructor(@NonNull QVTiCG2JavaVisitor qvticg2javaVisitor, @NonNull CGFunction cgFunction, @NonNull CGShadowExp cgShadowExp) {
		JavaStream js = qvticg2javaVisitor.getJavaStream();
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
		doFunctionBody2(qvticg2javaVisitor, cgFunction, cgShadowExp);
	}

	protected void doFunctionGetInstance(@NonNull QVTiCG2JavaVisitor qvticg2javaVisitor, @NonNull CGFunction cgFunction) {
		JavaStream js = qvticg2javaVisitor.getJavaStream();
		QVTiGlobalNameManager globalNameManager = qvticg2javaVisitor.getCodeGenerator().getGlobalNameManager();
		js.append("@Override\n");
		js.append("public ");
		//	js.appendIsRequired(false);
		//	js.append(" Object");
		//	js.appendTypeDeclaration(ClassUtil.nonNullState(cgFunction.getBody()));
		CGValuedElement body = cgFunction.getBody();
		if (body != null) {				// XXX null while developing
			js.appendTypeDeclaration(ClassUtil.nonNullState(body));
		}
		js.append(" getResult() {\n");
		js.pushIndentation(null);
		js.append("return ");
		js.appendName( globalNameManager.getCachedResultName());
		js.append(";\n");
		js.popIndentation();
		js.append("}\n");
	}

	protected void doFunctionIsEqual(@NonNull QVTiCG2JavaVisitor qvticg2javaVisitor, @NonNull CGShadowExp cgShadowExp, @NonNull String instanceName) {
		JavaStream js = qvticg2javaVisitor.getJavaStream();
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
			Type type = ((TypedElement)cgShadowExp.getAst()).getType();
			if (type instanceof DataType) {
				js.append(instanceName);
			}
			else {
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
				js.append("()");
			}
			js.append(", thoseValues[" + index++ + "])");
		}
		js.append(";\n");
		js.popIndentation();
		js.append("}\n");
	}

	@Override
	public boolean generateJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull CGOperation cgOperation) {
		JavaStream js = cg2javaVisitor.getJavaStream();
		QVTiCG2JavaVisitor qvticg2javaVisitor = (QVTiCG2JavaVisitor)cg2javaVisitor;
		JavaCodeGenerator codeGenerator = cg2javaVisitor.getCodeGenerator();
		CGFunction cgFunction = (CGFunction)cgOperation;
		boolean isIncremental = codeGenerator.getOptions().isIncremental();
		//
		js.appendCommentWithOCL(null, cgFunction.getAst());
		CGShadowExp cgShadowExp = QVTiCGUtil.basicGetCGShadowExp(cgFunction);
		assert cgShadowExp != null;
		String functionName = cgFunction.getResolvedName();
		NameResolution cachedResultName = codeGenerator.getGlobalNameManager().getCachedResultName();
		js.append("protected class ");
		js.append(functionName);
		js.append(" extends ");
		js.appendClassReference(null, isIncremental ? AbstractComputation.Incremental.class : AbstractComputation.class);
		js.pushClassBody(functionName);
		js.appendOptionalBlankLine();
		js.append("protected final ");
		js.appendTypeDeclaration(cgFunction);
		js.append(" ");
		js.appendName(cachedResultName);
		js.append(";\n");
		js.appendOptionalBlankLine();
		doFunctionConstructor(qvticg2javaVisitor, cgFunction, cgShadowExp);
		js.appendOptionalBlankLine();
		doFunctionGetInstance(qvticg2javaVisitor, cgFunction);
		js.appendOptionalBlankLine();
		doFunctionIsEqual(qvticg2javaVisitor, cgShadowExp, cachedResultName.getResolvedName());
		js.popClassBody(false);
		return true;
	}

	@Override
	protected final @NonNull CGParameterStyle @NonNull [] getCGParameterStyles(@NonNull ExecutableNameManager operationNameManager) {
		Operation asOperation = (Operation)operationNameManager.getASScope();
		assert PivotUtil.basicGetShadowExp(asOperation) != null;
		return CG_PARAMETER_STYLES_PARAMETERS;
	}

	@Override
	public void installEvaluateOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass, org.eclipse.ocl.pivot.@NonNull Class asEntryClass, @NonNull Operation asOperation) {
		org.eclipse.ocl.pivot.Class asCacheClass = CGUtil.getAST(cgCacheClass);
		FunctionEvaluateOperationCallingConvention callingConvention = FunctionEvaluateOperationCallingConvention.getInstance(asCacheClass);
		callingConvention.createOperation(analyzer, cgCacheClass, asOperation, asEntryClass);
	}
}
