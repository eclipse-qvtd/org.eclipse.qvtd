/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
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
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractQVTimperativeFlowAnalysisDeducerFromNullVisitor;

public class QVTimperativeFlowAnalysisDeducerFromNullVisitor extends AbstractQVTimperativeFlowAnalysisDeducerFromNullVisitor
{
	public QVTimperativeFlowAnalysisDeducerFromNullVisitor(@NonNull QVTimperativeFlowAnalysis flowAnalysis, boolean isNull) {
		super(flowAnalysis, isNull);
	}
}