/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvttemplate.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.manager.FlowAnalysis;
import org.eclipse.qvtd.pivot.qvttemplate.util.AbstractQVTtemplateFlowAnalysisDeducerFromNullVisitor;

public class QVTtemplateFlowAnalysisDeducerFromNullVisitor extends AbstractQVTtemplateFlowAnalysisDeducerFromNullVisitor
{
	public QVTtemplateFlowAnalysisDeducerFromNullVisitor(@NonNull FlowAnalysis flowAnalysis, boolean isNull) {
		super(flowAnalysis, isNull);
	}
}
