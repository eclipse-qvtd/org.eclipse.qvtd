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
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.calling.AbstractClassCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.ClassCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;

/**
 *  TransformationCallingConvention defines a Transformation declaration.
 */
public class TransformationCallingConvention extends AbstractClassCallingConvention
{
	private static final @NonNull TransformationCallingConvention INSTANCE = new TransformationCallingConvention();

	public static @NonNull ClassCallingConvention getInstance(org.eclipse.ocl.pivot.@NonNull Class asClass) {
		INSTANCE.logInstance(asClass);
		return INSTANCE;
	}

	@Override
	public @NonNull CGClass createCGClass(@NonNull CodeGenAnalyzer analyzer, org.eclipse.ocl.pivot.@NonNull Class asClass) {
		CGTransformation cgTransformation = createCGClass();
		installCGDefaultClassParent(analyzer, cgTransformation, asClass);
		JavaCodeGenerator codeGenerator = analyzer.getCodeGenerator();
		boolean isIncremental = codeGenerator.getOptions().isIncremental();
		Class<?> jSuperClass = isIncremental ? AbstractTransformer.Incremental.class : AbstractTransformer.class;
		org.eclipse.ocl.pivot.@NonNull Class asSuperClass = codeGenerator.getLanguageSupport().getNativeClass(jSuperClass);
		CGClass cgSuperClass = analyzer.generateClassDeclaration(asSuperClass, null);
		cgTransformation.getSuperTypes().add(cgSuperClass);
		return cgTransformation;
	}

	@Override
	public @NonNull CGTransformation createCGClass() {
		return QVTiCGModelFactory.eINSTANCE.createCGTransformation();
	}

	@Override
	public boolean generateJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull CGClass cgClass) {
		return false;
	}
}
