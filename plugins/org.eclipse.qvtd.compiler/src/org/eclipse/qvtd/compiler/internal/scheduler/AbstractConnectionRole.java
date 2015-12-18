/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.scheduler;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.schedule.utilities.GraphStringBuilder;
import org.eclipse.qvtd.pivot.schedule.utilities.GraphStringBuilder.GraphNode;

abstract class AbstractConnectionRole implements ConnectionRole
{
	@Override
	public void appendEdgeAttributes(@NonNull GraphStringBuilder s) {
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
		s.appendAttributedEdge(this);
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
		return Role.BINDING_COLOR;
	}

	@Override
	public @Nullable String getLabel() {
		return null;
	}

	@Override
	public @NonNull Integer getPenwidth() {
		return Role.LINE_WIDTH;
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