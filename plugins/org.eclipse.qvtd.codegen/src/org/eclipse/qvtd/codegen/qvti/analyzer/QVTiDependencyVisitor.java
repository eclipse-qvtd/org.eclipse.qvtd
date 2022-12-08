/*******************************************************************************
 * Copyright (c) 2013, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.analyzer;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cse.GlobalPlace;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart;
import org.eclipse.qvtd.codegen.qvticgmodel.util.AbstractQVTiDependencyVisitor;

public class QVTiDependencyVisitor extends AbstractQVTiDependencyVisitor
{
	public QVTiDependencyVisitor(@NonNull JavaCodeGenerator codeGenerator, @NonNull GlobalPlace globalPlace) {
		super(codeGenerator, globalPlace);
	}

	@Override
	public @Nullable Object visitCGRealizedVariablePart(@NonNull CGRealizedVariablePart cgRealizedVariablePart) {
		addDependency(cgRealizedVariablePart, cgRealizedVariablePart.getInit());
		return super.visitCGRealizedVariablePart(cgRealizedVariablePart);
	}
}
