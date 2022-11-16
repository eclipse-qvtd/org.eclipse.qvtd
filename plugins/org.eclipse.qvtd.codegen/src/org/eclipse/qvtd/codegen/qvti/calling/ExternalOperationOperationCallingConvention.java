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
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.naming.ExecutableNameManager;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.library.LibraryOperation;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvti.naming.QVTiExecutableNameManager;
import org.eclipse.qvtd.codegen.qvticgmodel.utilities.QVTiCGModelCG2JavaVisitor;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;

/**
 *  ExternalFunctionOperationCallingConvention defines the support for the call of a Complete OCL operation implemented by a Java class.
 */
public class ExternalOperationOperationCallingConvention extends ExternalFunctionOperationCallingConvention
{
	public static final @NonNull ExternalOperationOperationCallingConvention INSTANCE = new ExternalOperationOperationCallingConvention();

	@Override
	public @NonNull CGOperation createCGOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull Operation asOperation) {
		assert asOperation.getImplementationClass() == null;
		return CGModelFactory.eINSTANCE.createCGCachedOperation();
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
		QVTiExecutableNameManager qvtiOperationNameManager = (QVTiExecutableNameManager)operationNameManager;
		QVTiAnalyzer qvtiAnalyzer = qvtiOperationNameManager.getAnalyzer();
		CGOperation cgOperation = (CGOperation)operationNameManager.getCGScope();
		Operation asOperation = CGUtil.getAST(cgOperation);
		//	boolean useClassToCreateObject = true; //QVTimperativeUtil.basicGetShadowExp(asFunction) != null;
		List<CGParameter> cgParameters = cgOperation.getParameters();
		//	assert !useClassToCreateObject;
		cgParameters.add(qvtiOperationNameManager.getThisTransformerParameter());
		for (Parameter asParameter : asOperation.getOwnedParameters()) {
			CGParameter cgParameter = qvtiAnalyzer.createCGElement(CGParameter.class, asParameter);
			cgParameters.add(cgParameter);
		}
	}

	@Override	@Deprecated /* @deprecated use generateJavaEvaluateCall always */
	public boolean generateJavaCall(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperationCallExp cgOperationCallExp) {
		QVTiCGModelCG2JavaVisitor qvticg2javaVisitor = (QVTiCGModelCG2JavaVisitor)cg2javaVisitor;
		CGOperation cgOperation = CGUtil.getOperation(cgOperationCallExp);
		Operation asOperation = QVTiCGUtil.getAST(cgOperation);
		//	Operation pOperation = cgFunctionCallExp.getReferredOperation();
		//	CGFunction cgFunction = ClassUtil.nonNullState(cgFunctionCallExp.getFunction());
		//	boolean useClassToCreateObject = QVTimperativeUtil.basicGetShadowExp(asFunction) != null;
		boolean useCache = !asOperation.isIsTransient();
		boolean isIdentifiedInstance = useCache;
		List<CGValuedElement> cgArguments = cgOperationCallExp.getArguments();
		List<Parameter> asParameters = asOperation.getOwnedParameters();
		List<CGParameter> cgParameters = cgOperation.getParameters();
		//
		for (@SuppressWarnings("null")@NonNull CGValuedElement cgArgument : cgArguments) {
			CGValuedElement argument = qvticg2javaVisitor.getExpression(cgArgument);
			if (!js.appendLocalStatements(argument)) {
				return false;
			}
		}
		//
		js.appendDeclaration(cgOperationCallExp);
		js.append(" = ");
		boolean needComma = false;
		if (isIdentifiedInstance) {
			js.append("((");
			js.appendValueName(cgOperation);
			js.append(")");
			js.append(getFunctionCtorName(cgOperation));
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
			js.appendValueName(cgOperation);
			js.append("(");
		}
		//	int iMax = cgParameters.size();
		//	assert iMax == cgArguments.size();
		for (int i = 0; i < cgArguments.size(); i++) {
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

	@Deprecated
	private @NonNull String getFunctionCtorName(@NonNull CGOperation cgOperation) {
		return JavaStream.convertToJavaIdentifier("OTOR_" + cgOperation.getName());
	}
}
