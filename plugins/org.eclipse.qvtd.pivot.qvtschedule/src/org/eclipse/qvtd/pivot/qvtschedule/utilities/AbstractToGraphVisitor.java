/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToGraphHelper;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphEdge;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphElement;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.util.AbstractExtendingQVTscheduleVisitor;

/** This code is rescued but has never worked properly */
public abstract class AbstractToGraphVisitor extends AbstractExtendingQVTscheduleVisitor<@Nullable String, @NonNull GraphStringBuilder> implements ToGraphHelper
{
	protected AbstractToGraphVisitor(@NonNull GraphStringBuilder context) {
		super(context);
	}

	protected void appendEdge(@NonNull GraphNode source, @NonNull GraphEdge edge, @NonNull GraphNode target) {
		context.appendEdge(this, source, edge, target);
	}

	protected @NonNull String appendNode(@NonNull GraphNode node) {
		return context.appendNode(this, node);
	}

	@Override
	public @NonNull GraphStringBuilder getGraphStringBuilder() {
		return context;
	}

	@Override
	public void setColor(@NonNull GraphElement element) {
		context.setColor(element.getColor());
	}

	public @NonNull String visit(@NonNull ScheduledRegion region) {
		region.accept(this);
		return context.toString();
	}

	@Override
	public @Nullable String visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
	}
}