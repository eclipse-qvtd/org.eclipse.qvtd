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
package org.eclipse.qvtd.pivot.qvtcore.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.internal.manager.FlowAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;

public class QVTcoreFlowAnalysis extends FlowAnalysis
{
	public QVTcoreFlowAnalysis(@NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull OCLExpression contextExpression) {
		super(environmentFactory, contextExpression);
	}

	@Override
	protected @NonNull AbstractDeducer createDeducerFromFalse() {
		return new QVTcoreFlowAnalysisDeducerFromFalseVisitor(this);
	}

	@Override
	protected @NonNull AbstractDeducer createDeducerFromNull(boolean isNull) {
		return new QVTcoreFlowAnalysisDeducerFromNullVisitor(this, isNull);
	}

	@Override
	protected @NonNull AbstractDeducer createDeducerFromTrue() {
		return new QVTcoreFlowAnalysisDeducerFromTrueVisitor(this);
	}
}
