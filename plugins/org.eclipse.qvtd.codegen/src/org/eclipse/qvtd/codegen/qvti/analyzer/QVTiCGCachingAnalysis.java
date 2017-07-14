/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.analyzer;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.CGCachingAnalysis;
import org.eclipse.ocl.examples.codegen.cgmodel.CGConstraint;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;

public class QVTiCGCachingAnalysis extends CGCachingAnalysis
{
	public QVTiCGCachingAnalysis(@NonNull CGPackage cgPackage) {
		super(cgPackage);
	}

	@Override
	public void analyze() {
		for (@NonNull Object object : new TreeIterable(cgPackage, true)) {
			if (object instanceof CGConstraint) {
				analyzeElement((CGConstraint)object);
			}
			else if (object instanceof CGMapping) {
				analyzeElement((CGMapping)object);
			}
			else if (object instanceof CGOperation) {
				analyzeElement((CGOperation)object);
			}
		}
	}
}