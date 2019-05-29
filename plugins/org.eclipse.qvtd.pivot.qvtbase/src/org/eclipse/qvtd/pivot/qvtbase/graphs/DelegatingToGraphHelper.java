/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.graphs;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphElement;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;

public class DelegatingToGraphHelper implements ToGraphHelper
{
	protected final @NonNull ToGraphHelper delegate;

	public DelegatingToGraphHelper(@NonNull ToGraphHelper delegate) {
		this.delegate = delegate;
	}

	@Override
	public @NonNull GraphStringBuilder getGraphStringBuilder() {
		return delegate.getGraphStringBuilder();
	}

	@Override
	public void setColor(@NonNull GraphElement element) {
		delegate.setColor(element);
	}

	@Override
	public void setHead(@NonNull GraphNode node) {
		delegate.setHead(node);
	}

	@Override
	public void setLabel(@NonNull GraphNode node) {
		delegate.setLabel(node);
	}

	@Override
	public void setPenwidth(@NonNull GraphNode node) {
		delegate.setPenwidth(node);
	}

	@Override
	public void setShapeAndStyle(@NonNull GraphNode node) {
		delegate.setShapeAndStyle(node);
	}
}