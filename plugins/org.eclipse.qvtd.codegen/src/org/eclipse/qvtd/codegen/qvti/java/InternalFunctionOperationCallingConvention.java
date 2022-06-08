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
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.library.LibraryOperation;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAS2CGVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;

/**
 *  InternalFunctionOperationCallingConvention defines the support for the call of a QVTi function implemented by an OCL expression.
 *
 *  The implementation uses a class whose instance caches a result to ensure unique shared execution.
 */
public class InternalFunctionOperationCallingConvention extends FunctionOperationCallingConvention // cg Cached/Constrained
{
	public static final @NonNull InternalFunctionOperationCallingConvention INSTANCE = new InternalFunctionOperationCallingConvention();

	@Override
	public void createCGBody(@NonNull AS2CGVisitor as2cgVisitor, @NonNull CGOperation cgOperation) {
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
		super.createCGBody(as2cgVisitor, cgFunction);
		//			} catch (ParserException e) {
		// TODO Auto-generated catch block
		//				e.printStackTrace();
		//			}
		//	analyzer.addFunction(asFunction, cgFunction); */
	}

	@Override
	public @NonNull CGFunction createCGOperation(@NonNull CodeGenAnalyzer analyzer, @Nullable Type asSourceType, @NonNull Operation asOperation) {
		//	assert asOperation.getImplementation() == null;		-- maybe ConstrainedOperation
		assert asOperation.getImplementationClass() == null;
		CGFunction cgFunction = QVTiCGModelFactory.eINSTANCE.createCGFunction();
		analyzer.installOperation(asOperation, cgFunction, this);
		return cgFunction;
	}

	@Override
	public @NonNull CGOperation createCGOperation(
			@NonNull AS2CGVisitor as2cgVisitor, @Nullable Type asSourceType,
			@NonNull Operation asOperation) {
		// TODO Auto-generated method stub
		return super.createCGOperation(as2cgVisitor, asSourceType, asOperation);
	}

	@Override
	public @NonNull CGValuedElement createCGOperationCallExp(@NonNull AS2CGVisitor as2cgVisitor, @NonNull CGOperation cgOperation, @NonNull LibraryOperation libraryOperation,
			@Nullable CGValuedElement cgSource, @NonNull OperationCallExp asOperationCallExp) {
		QVTiAS2CGVisitor qvtias2cgVisitor = (QVTiAS2CGVisitor)as2cgVisitor;
		QVTiCodeGenerator codeGenerator = qvtias2cgVisitor.getCodeGenerator();
		CGFunction cgFunction = (CGFunction)cgOperation;
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		boolean useClassToCreateObject = codeGenerator.getShadowExp(asFunction) != null;
		CGFunctionCallExp cgFunctionCallExp = QVTiCGModelFactory.eINSTANCE.createCGFunctionCallExp();
		initCallExp(as2cgVisitor, cgFunctionCallExp, asOperationCallExp, cgOperation, asFunction.isIsRequired());
		assert !useClassToCreateObject;
		assert cgSource != null;
		cgFunctionCallExp.getArguments().add(cgSource);
		initCallArguments(as2cgVisitor, cgFunctionCallExp);
		return cgFunctionCallExp;
	}

	@Override
	public void createCGParameters(@NonNull AS2CGVisitor as2cgVisitor, @NonNull CGOperation cgOperation, @Nullable ExpressionInOCL bodyExpression) {
		QVTiAS2CGVisitor qvtias2cgVisitor = (QVTiAS2CGVisitor)as2cgVisitor;
		QVTiCodeGenerator codeGenerator = qvtias2cgVisitor.getCodeGenerator();
		CGFunction cgFunction = (CGFunction)cgOperation;
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		assert codeGenerator.getShadowExp(asFunction) == null;
		QVTiNestedNameManager nameManager = (QVTiNestedNameManager)qvtias2cgVisitor.getNameManager();
		List<@NonNull CGParameter> cgParameters = CGUtil.getParametersList(cgFunction);
		cgParameters.add(nameManager.getThisTransformerParameter());			// Include "this" as part of the uniqueness Tuple.
		for (@NonNull Parameter asParameter : PivotUtil.getOwnedParameters(asFunction)) {
			CGParameter cgParameter = as2cgVisitor.doVisit(CGParameter.class, asParameter);
			cgParameters.add(cgParameter);
		}
	}

	@Override
	public boolean generateJavaCall(@NonNull CG2JavaVisitor cg2javaVisitor,
			@NonNull JavaStream js,
			@NonNull CGOperationCallExp cgOperationCallExp) {
		// TODO Auto-generated method stub
		return super.generateJavaCall(cg2javaVisitor, js, cgOperationCallExp);
	}

	@Override
	public boolean generateJavaDeclaration(
			@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js,
			@NonNull CGOperation cgOperation) {
		// TODO Auto-generated method stub
		return super.generateJavaDeclaration(cg2javaVisitor, js, cgOperation);
	}

	@Override
	public void rewriteWithBoxingAndGuards(
			@NonNull BoxingAnalyzer boxingAnalyzer,
			@NonNull CGOperation cgOperation) {
		// TODO Auto-generated method stub
		super.rewriteWithBoxingAndGuards(boxingAnalyzer, cgOperation);
	}

	@Override
	public void rewriteWithBoxingAndGuards(@NonNull BoxingAnalyzer boxingAnalyzer,@NonNull CGOperationCallExp cgOperationCallExp) {
		for (CGValuedElement cgArgument : cgOperationCallExp.getArguments()) {
			boxingAnalyzer.rewriteAsBoxed(cgArgument);
		}
	}
}
