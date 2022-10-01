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
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGShadowExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.naming.ExecutableNameManager;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.library.LibraryOperation;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;
import org.eclipse.qvtd.codegen.qvticgmodel.utilities.QVTiCGModelCG2JavaVisitor;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractComputation;

/**
 *  ShadowFunctionOperationCallingConvention defines the support for the call of a QVTi function to create a keyed shaow object.
 */
public abstract class ShadowFunctionOperationCallingConvention extends FunctionOperationCallingConvention // cg Cached/Constrained
{
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
	public @NonNull CGFunction createCGOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull Operation asOperation) {
		assert asOperation.getImplementationClass() == null;
		return QVTiCGModelFactory.eINSTANCE.createCGFunction();
	}

	@Override
	public @NonNull CGValuedElement createCGOperationCallExp(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgOperation, @NonNull LibraryOperation libraryOperation,
			@Nullable CGValuedElement cgSource, @NonNull OperationCallExp asOperationCallExp) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		CGFunction cgFunction = (CGFunction)cgOperation;
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		boolean useClassToCreateObject = QVTimperativeUtil.basicGetShadowExp(asFunction) != null;
		assert useClassToCreateObject;
		CGFunctionCallExp cgFunctionCallExp = QVTiCGModelFactory.eINSTANCE.createCGFunctionCallExp();
		initCallExp(qvtiAnalyzer, cgFunctionCallExp, asOperationCallExp, cgOperation, asFunction.isIsRequired());
		assert cgSource instanceof CGVariableExp;
		assert CGUtil.getReferredVariable((CGVariableExp)cgSource).basicGetNameResolution() == codeGenerator.getGlobalNameManager().getTransformationNameResolution();
		initCallArguments(qvtiAnalyzer, cgFunctionCallExp);
		return cgFunctionCallExp;
	}

	@Override
	public void createCGParameters(@NonNull ExecutableNameManager operationNameManager, @Nullable ExpressionInOCL bodyExpression) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)operationNameManager.getAnalyzer();
		CGOperation cgOperation = (CGOperation)operationNameManager.getCGScope();
		CGFunction cgFunction = (CGFunction)cgOperation;
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		boolean useClassToCreateObject = QVTimperativeUtil.basicGetShadowExp(asFunction) != null;
		List<CGParameter> cgParameters = cgFunction.getParameters();
		assert useClassToCreateObject;
		for (Parameter asParameter : asFunction.getOwnedParameters()) {
			CGParameter cgParameter = qvtiAnalyzer.createCGElement(CGParameter.class, asParameter);
			cgParameters.add(cgParameter);
		}
	}

	@Override
	public boolean generateJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperation cgOperation) {
		QVTiCGModelCG2JavaVisitor qvticg2javaVisitor = (QVTiCGModelCG2JavaVisitor)cg2javaVisitor;
		QVTiCodeGenerator codeGenerator = qvticg2javaVisitor.getCodeGenerator();
		CGFunction cgFunction = (CGFunction)cgOperation;
		boolean isIncremental = codeGenerator.getOptions().isIncremental();
		//
		js.appendCommentWithOCL(null, cgFunction.getAst());
		CGShadowExp cgShadowExp = QVTiCGUtil.basicGetCGShadowExp(cgFunction);
		assert cgShadowExp != null;
		String functionName = cgFunction.getResolvedName();
		String cachedResultName = codeGenerator.getGlobalNameManager().getCachedResultName();
		js.append("protected class ");
		js.append(functionName);
		js.append(" extends ");
		js.appendClassReference(null, isIncremental ? AbstractComputation.Incremental.class : AbstractComputation.class);
		js.pushClassBody(functionName);
		js.append("protected final ");
		js.appendTypeDeclaration(cgFunction);
		js.append(" " + cachedResultName + ";\n");
		js.append("\n");
		doFunctionConstructor(qvticg2javaVisitor, js, cgFunction, cgShadowExp);
		js.append("\n");
		doFunctionGetInstance(qvticg2javaVisitor, js, cgFunction);
		js.append("\n");
		doFunctionIsEqual(qvticg2javaVisitor, js, cgShadowExp, cachedResultName);
		js.popClassBody(false);
		return true;
	}
}
