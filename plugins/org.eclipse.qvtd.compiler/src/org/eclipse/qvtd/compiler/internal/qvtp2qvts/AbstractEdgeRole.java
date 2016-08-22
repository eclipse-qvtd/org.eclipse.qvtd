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

public abstract class AbstractEdgeRole extends AbstractRole implements EdgeRole
{
	protected AbstractEdgeRole(@NonNull Phase phase) {
		super(phase);
	}

	@Override
	public @NonNull AbstractEdgeRole asPhase(@NonNull Phase phase) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull EdgeRole asPredicated() {
		return asPhase(Phase.PREDICATED);
	}

	@Override
	public @Nullable String getLabel() {
		return null;
	}

	@Override
	public boolean isCast() {
		return false;
	}

	@Override
	public boolean isComputation() {
		return false;
	}

	@Override
	public boolean isExpression() {
		return false;
	}

	@Override
	public boolean isMatched() {
		return false;
	}

	@Override
	public boolean isNavigation() {
		return false;
	}

	@Override
	public boolean isPredicate() {
		return false;
	}

	@Override
	public boolean isRecursion() {
		return false;
	}

	@Override
	public @NonNull EdgeRole merge(@NonNull EdgeRole edgeRole) {
		if (edgeRole == this) {
			return this;
		}
		throw new IllegalStateException(this + " cannot be merged with " + edgeRole);
	}
}