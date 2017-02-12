/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;

abstract class AbstractConnectionRole implements ConnectionRole
{
	protected final boolean isNode;

	protected AbstractConnectionRole(boolean isNode) {
		this.isNode = isNode;
	}

	@Override
	public void appendEdgeAttributes(@NonNull GraphStringBuilder s, @NonNull GraphNode source, @NonNull GraphNode target) {
		s.setColor(getColor());
		String style = getStyle();
		if (style != null) {
			s.setStyle(style);
		}
		String arrowhead = getArrowhead();
		if (arrowhead != null) {
			s.setArrowhead(arrowhead);
		}
		s.setPenwidth(getPenwidth());
		s.appendAttributedEdge(source, this, target);
	}

	@Override
	public @Nullable String getArrowhead() {
		return null;
	}

	@Override
	public @NonNull String getColor() {
		return isNode ? QVTscheduleConstants.BINDING_COLOR : QVTscheduleConstants.ORDERING_COLOR;
	}

	@Override
	public @Nullable String getLabel() {
		return null;
	}

	@Override
	public @NonNull Integer getPenwidth() {
		return QVTscheduleConstants.LINE_WIDTH;
	}

	@Override
	public @NonNull GraphNode getSource() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable String getStyle() {
		return null;
	}

	@Override
	public @NonNull GraphNode getTarget() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isMandatory() {
		return false;
	}

	@Override
	public boolean isPassed() {
		return false;
	}

	@Override
	public boolean isPreferred() {
		return false;
	}

	@Override
	public @NonNull ConnectionRole merge(@NonNull ConnectionRole connectionRole) {
		throw new IllegalStateException(this + " cannot be merged with " + connectionRole);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}