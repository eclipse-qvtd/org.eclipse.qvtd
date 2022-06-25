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
import org.eclipse.ocl.examples.codegen.calling.AbstractClassCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;

/**
 *  TransformationCallingConvention defines a Transformation declaration.
 */
public class TransformationCallingConvention extends AbstractClassCallingConvention
{
	public static final @NonNull TransformationCallingConvention INSTANCE = new TransformationCallingConvention();

	@Override
	public @NonNull CGClass createCGClass(@NonNull NamedElement asNamedElement) {
		return QVTiCGModelFactory.eINSTANCE.createCGTransformation();
	}

	@Override
	public boolean generateJavaDeclaration(
			@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js,
			@NonNull CGClass cgClass) {
		// TODO Auto-generated method stub
		return false;
	}
}
