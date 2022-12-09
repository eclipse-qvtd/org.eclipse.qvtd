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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.calling.ExecutorOppositePropertyCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.PropertyCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOppositeProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorOppositePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNavigationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.library.LibraryProperty;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;

/**
 *  ForeignPropertyCallingConvention defines the support for the call of a property realized by an
 *  implementation in the *Tables class.
 *   *  </br>
 *  e.g. as XXXTables.FOREIGN_qualified_class.FC_class.INSTANCE.evaluate(executor, arguments)
 */
public class MiddlePropertyCallingConvention extends ExecutorOppositePropertyCallingConvention
{
	private static final @NonNull MiddlePropertyCallingConvention INSTANCE = new MiddlePropertyCallingConvention();

	public static @NonNull PropertyCallingConvention getInstance(@NonNull Property asProperty) {
		INSTANCE.logInstance(asProperty);
		return INSTANCE;
	}

	@Override
	public @NonNull CGValuedElement createCGNavigationCallExp(@NonNull CodeGenAnalyzer analyzer, @NonNull CGProperty cgProperty,
			@NonNull LibraryProperty libraryProperty, @Nullable CGValuedElement cgSource, @NonNull NavigationCallExp asNavigationCallExp) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		/*		CodeGenerator codeGenerator = as2cgVisitor.getCodeGenerator();
		OppositePropertyCallExp asOppositePropertyCallExp = (OppositePropertyCallExp)asNavigationCallExp;
		Property asOppositeProperty = ClassUtil.nonNullModel(asOppositePropertyCallExp.getReferredProperty());
		Property asProperty = ClassUtil.nonNullModel(asOppositeProperty.getOpposite());
		boolean isRequired = asProperty.isIsRequired();
		LibraryProperty libraryProperty2 = codeGenerator.getEnvironmentFactory().getMetamodelManager().getImplementation(asOppositePropertyCallExp, null, asProperty);
		assert libraryProperty2 == libraryProperty;				// XXX
		assert /*(libraryProperty instanceof CompositionProperty) ||* / (libraryProperty instanceof ImplicitNonCompositionProperty) || (libraryProperty instanceof ExtensionProperty);
		CGExecutorOppositePropertyCallExp cgPropertyCallExp = CGModelFactory.eINSTANCE.createCGExecutorOppositePropertyCallExp();
		CGExecutorProperty cgExecutorProperty = as2cgVisitor.getAnalyzer().createExecutorOppositeProperty(asProperty);
		cgExecutorProperty.setCallingConvention(this);
		cgPropertyCallExp.setExecutorProperty(cgExecutorProperty);
		cgPropertyCallExp.getOwns().add(cgExecutorProperty);
		cgPropertyCallExp.setReferredProperty(asProperty);
		as2cgVisitor.initAst(cgPropertyCallExp, asOppositePropertyCallExp);
		cgPropertyCallExp.setRequired(isRequired);
		cgPropertyCallExp.setSource(cgSource);
		cgPropertyCallExp.setReferredProperty(cgProperty);
		return cgPropertyCallExp; */
		//		LibraryProperty libraryProperty = metamodelManager.getImplementation(asProperty);
		OppositePropertyCallExp asOppositePropertyCallExp = (OppositePropertyCallExp)asNavigationCallExp;
		Property asOppositeProperty = ClassUtil.nonNullModel(asOppositePropertyCallExp.getReferredProperty());
		Property asProperty = ClassUtil.nonNullModel(asOppositeProperty.getOpposite());
		CGMiddlePropertyCallExp cgPropertyCallExp = QVTiCGModelFactory.eINSTANCE.createCGMiddlePropertyCallExp();
		cgPropertyCallExp.setAst(asOppositePropertyCallExp);
		//		CGExecutorProperty cgExecutorProperty = analyzer.getExecutorProperty(asProperty);
		//		cgExecutorPropertyCallExp.setExecutorProperty(cgExecutorProperty);
		//		cgPropertyCallExp = cgExecutorPropertyCallExp;
		//		cgPropertyCallExp.getDependsOn().add(cgExecutorProperty);
		cgPropertyCallExp.setReferredProperty(cgProperty);
		cgPropertyCallExp.setAsProperty(asProperty);
		analyzer.initAst(cgPropertyCallExp, asOppositePropertyCallExp, true);
		cgPropertyCallExp.setSource(cgSource);
		return cgPropertyCallExp;
	}

	@Override
	public @NonNull CGProperty createCGProperty(@NonNull CodeGenAnalyzer analyzer, @NonNull TypedElement asTypedElement) {
		// TODO Auto-generated method stub
		return super.createCGProperty(analyzer, asTypedElement);		// XXX
	}

	@Override
	protected boolean generateForwardJavaCall(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGExecutorPropertyCallExp cgPropertyCallExp) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean generateJavaDeclaration(	@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGProperty cgProperty) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean generateJavaCall(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGNavigationCallExp cgPropertyCallExp) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected boolean generateOppositeJavaCall(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGExecutorOppositePropertyCallExp cgPropertyCallExp) {
		throw new UnsupportedOperationException();
	}

	private boolean generateOppositeJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGExecutorOppositeProperty cgProperty) {
		throw new UnsupportedOperationException();
	}
}
