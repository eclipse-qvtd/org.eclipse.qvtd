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
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.library.LibraryOperation;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAS2CGVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;

/**
 *  InternalFunctionOperationCallingConvention defines the uncached support for the call of a transient QVTi function implemented by an OCL expression.
 */
public class TransientFunctionOperationCallingConvention extends FunctionOperationCallingConvention // cg Cached/Constrained
{
	public static final @NonNull TransientFunctionOperationCallingConvention INSTANCE = new TransientFunctionOperationCallingConvention();

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
	public @NonNull CGFunction createCGOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull Operation asOperation) {
		assert asOperation.getImplementationClass() == null;
		CGFunction cgFunction = QVTiCGModelFactory.eINSTANCE.createCGFunction();
		initOperation(analyzer, cgFunction, asOperation);
		analyzer.addCGOperation(cgFunction);
		return cgFunction;
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
		boolean useClassToCreateObject = codeGenerator.getShadowExp(asFunction) != null;
		assert !useClassToCreateObject;
		List<CGParameter> cgParameters = cgFunction.getParameters();
		cgParameters.add(qvtias2cgVisitor.getNameManager().getThisTransformerParameter());
		for (Parameter asParameter : asFunction.getOwnedParameters()) {
			CGParameter cgParameter = as2cgVisitor.doVisit(CGParameter.class, asParameter);
			cgParameters.add(cgParameter);
		}
	}
}
