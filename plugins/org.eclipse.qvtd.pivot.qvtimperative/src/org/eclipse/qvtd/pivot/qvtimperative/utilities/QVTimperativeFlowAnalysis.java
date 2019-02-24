/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.internal.manager.FlowAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;

public class QVTimperativeFlowAnalysis extends FlowAnalysis
{
	public QVTimperativeFlowAnalysis(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull OCLExpression contextExpression) {
		super(environmentFactory, contextExpression);
	}

	@Override
	protected @NonNull AbstractDeducer createDeducerFromFalse() {
		return new QVTimperativeFlowAnalysisDeducerFromFalseVisitor(this);
	}

	@Override
	protected @NonNull AbstractDeducer createDeducerFromNull(boolean isNull) {
		return new QVTimperativeFlowAnalysisDeducerFromNullVisitor(this, isNull);
	}

	@Override
	protected @NonNull AbstractDeducer createDeducerFromTrue() {
		return new QVTimperativeFlowAnalysisDeducerFromTrueVisitor(this);
	}
}
