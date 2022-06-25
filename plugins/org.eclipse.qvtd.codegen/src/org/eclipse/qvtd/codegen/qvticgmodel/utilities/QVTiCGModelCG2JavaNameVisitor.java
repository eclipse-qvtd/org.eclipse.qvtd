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
package org.eclipse.qvtd.codegen.qvticgmodel.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.naming.NestedNameManager;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.util.AbstractQVTiCGModelCG2JavaNameVisitor;

public class QVTiCGModelCG2JavaNameVisitor extends AbstractQVTiCGModelCG2JavaNameVisitor
{
	public QVTiCGModelCG2JavaNameVisitor(@NonNull JavaCodeGenerator codeGenerator) {
		super(codeGenerator);
	}

	protected @NonNull QVTiCodeGenerator getCodeGenerator() {
		return (QVTiCodeGenerator)context;
	}

	@Override
	public Object visitCGConnectionAssignment(@NonNull CGConnectionAssignment cgConnectionAssignment) {
		NestedNameManager nameManager = globalNameManager.useSelfExecutableNameManager(cgConnectionAssignment);
		nameManager.addNameVariant(cgConnectionAssignment, context.getITER_NameVariant());
		return super.visitCGConnectionAssignment(cgConnectionAssignment);
	}
}
