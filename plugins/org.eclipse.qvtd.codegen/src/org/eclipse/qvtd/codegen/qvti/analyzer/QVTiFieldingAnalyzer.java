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
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalysisVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;

public class QVTiFieldingAnalyzer extends FieldingAnalyzer
{
	public QVTiFieldingAnalyzer(@NonNull QVTiAnalyzer analyzer) {
		super(analyzer);
	}

	@Override
	protected @NonNull FieldingAnalysisVisitor createAnalysisVisitor(@NonNull ReturnState requiredReturn) {
		return new QVTiFieldingAnalysisVisitor(this, requiredReturn);
	}

	@Override
	public @NonNull FieldingAnalysisVisitor getMayBeThrownVisitor() {
		return super.getMayBeThrownVisitor();
	}

	@Override
	public @NonNull FieldingAnalysisVisitor getMustBeCaughtVisitor() {
		return super.getMustBeCaughtVisitor();
	}

	@Override
	public @NonNull QVTiFieldingAnalysisVisitor getMustBeThrownVisitor() {
		return (QVTiFieldingAnalysisVisitor)super.getMustBeThrownVisitor();
	}
}
