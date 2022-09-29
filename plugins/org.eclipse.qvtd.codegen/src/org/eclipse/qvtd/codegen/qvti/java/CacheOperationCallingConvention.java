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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.calling.AbstractCachedOperationCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.library.LibraryOperation;

/**
 *  CachedOperationCallingConvention defines the support for the call of a Complete OCL-defined operation.
 *  If defined as part of an OCL stdlib, he operation is invoked when called. If defined as part of a
 *  Complete OCL document or OCLinEcore enrichment, the operations is invoked via a cache to avoid re-execution.
 *
 *  -- only used by QVTd
 */
public class CacheOperationCallingConvention extends AbstractCachedOperationCallingConvention
{
	public static final @NonNull CacheOperationCallingConvention INSTANCE = new CacheOperationCallingConvention();

	@Override
	public @NonNull CGOperation createCGOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull Operation asOperation) {
		PivotMetamodelManager metamodelManager = analyzer.getMetamodelManager();
		//	assert metamodelManager.getImplementation(asOperation) instanceof ConstrainedOperation;
		//	org.eclipse.ocl.pivot.Package asPackage = PivotUtil.getOwningPackage(PivotUtil.getOwningClass(asOperation));
		//	assert !(asPackage instanceof Library);
		//	return CGModelFactory.eINSTANCE.createCGCachedOperation();

		CGOperation cgOperation = CGModelFactory.eINSTANCE.createCGCachedOperation();
		//	analyzer.installOperation(asOperation, cgOperation, this);
		//	asNewOperations.add(asOperation);
		//	cgOperations.add((CGCachedOperation) cgOperation);
		//	analyzer.addExternalFeature(asOperation);




		//	generateDeclarationHierarchy(as2cgVisitor, asSourceType, asOperation);
		//	Iterable<@NonNull Operation> asOverrideOperations = null;
		//	CGClass currentClass = as2cgVisitor.getCurrentClass();
		//	generateDeclarationHierarchy(as2cgVisitor, currentClass, asOperation, asOverrideOperations);

		//	if (currentClass != null) {
		//		Iterable<@NonNull Operation> overrides = metamodelManager.getFinalAnalysis().getOverrides(asOperation);
		//		return cachedOperationCall(element, currentClass2, cgSource, asOperation, overrides);
		//	}

		//	CGOperation cgOperation2 = analyzer.basicGetFinalCGOperation(asOperation);
		//	assert cgOperation2 == cgOperation;
		return cgOperation;



		//	assert as2cgVisitor.getMetamodelManager().getImplementation(asOperation) instanceof ConstrainedOperation;
		//	org.eclipse.ocl.pivot.Package asPackage = PivotUtil.getOwningPackage(PivotUtil.getOwningClass(asOperation));
		//	assert !(asPackage instanceof Library);
		//	return CGModelFactory.eINSTANCE.createCGCachedOperation();
	}

	@Override
	public @NonNull CGValuedElement createCGOperationCallExp(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgOperation, @NonNull LibraryOperation libraryOperation,
			@Nullable CGValuedElement cgSource, @NonNull OperationCallExp asOperationCallExp) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean generateJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperation cgOperation) {
		CGValuedElement body = cg2javaVisitor.getExpression(cgOperation.getBody());
		//
		js.append("@Override\n");
		js.append("public ");
		js.appendTypeDeclaration(cgOperation);
		js.append(" ");
		js.appendValueName(cgOperation);
		appendParameterList(js, cgOperation);
		appendBody(cg2javaVisitor, js, body);
		return true;
	}

	@Override
	protected @NonNull String getNativeOperationClassName(@NonNull CGOperation cgOperation) {
		throw new UnsupportedOperationException();
	}
}
