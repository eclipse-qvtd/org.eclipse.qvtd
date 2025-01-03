/*******************************************************************************
 * Copyright (c) 2015, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.HeadNodeGroup;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * A TracedHeadNodeGroup identifies a set of mutually one to one navigable nodes from which many nodes can be navigated.
 *
 * At least TracedHeadNodeGroup is required per TypedModel while determining how to constrain the trace model.
 */
public class TracedHeadNodeGroup extends HeadNodeGroup
{
	protected final @NonNull TypedModel typedModel;

	public TracedHeadNodeGroup(@NonNull TracedHeadAnalysis tracedHeadAnalysis, @NonNull List<@NonNull Node> headGroupNodes) {
		super(tracedHeadAnalysis, headGroupNodes);
		typedModel = QVTscheduleUtil.getReferredTypedModel(QVTscheduleUtil.getClassDatum(headGroupNodes.get(0)));
		for (@NonNull Node headGroupNode : headGroupNodes) {
			assert typedModel == QVTscheduleUtil.getReferredTypedModel(QVTscheduleUtil.getClassDatum(headGroupNode));
		}
	}

	@Override
	public void appendTo(@NonNull StringBuilder s) {
		s.append(typedModel.getName());
		s.append(" ");
		super.appendTo(s);
	}

	@Override
	public String getName() {
		return typedModel.getName();
	}
}