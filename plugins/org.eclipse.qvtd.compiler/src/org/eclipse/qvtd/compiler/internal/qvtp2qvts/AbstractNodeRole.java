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

public abstract class AbstractNodeRole extends AbstractRole implements NodeRole
{
	protected AbstractNodeRole(@NonNull Phase phase) {
		super(phase);
	}

	@Override
	public @NonNull NodeRole asNavigable() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull AbstractNodeRole asPhase(@NonNull Phase phase) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull NodeRole asPredicated() {
		return asPhase(Phase.PREDICATED);
	}

	@Override
	public @NonNull NodeRole asSpeculated() {
		return asPhase(Phase.SPECULATED);
	}

	@Override
	public @NonNull NodeRole asSpeculation() {
		return asPhase(Phase.SPECULATION);
	}

	@Override
	public @NonNull Integer getPenwidth() {
		return isHead() /*&& !isResult()*/ ? HEAD_WIDTH : isGuard() ? GUARD_WIDTH : LINE_WIDTH;
	}

	@Override
	public @Nullable String getShape() {
		return null;
	}

	@Override
	public @Nullable String getStyle() {
		boolean isDashed = !isNavigable() && (isExpression() || !isRealized());
		if (isDataType()) {
			return isDashed ? "\"rounded,dashed\"" : "rounded";
		}
		else {
			return isDashed ? "dashed" : null;
			//		return isNavigable() || isSpeculated() || isSpeculation() || isRealized() || isHead() ? null : "dashed";
		}
	}

	@Override
	public boolean isClass() {
		return false;
	}

	@Override
	public boolean isComposed() {
		return false;
	}

	@Override
	public boolean isDataType() {
		return false;
	}

	@Override
	public boolean isExpression() {
		return false;
	}

	@Override
	public boolean isExtraGuardVariable() {
		return false;
	}

	@Override
	public boolean isGuard() {
		return false;
	}

	@Override
	public boolean isHead() {
		return false;
	}

	@Override
	public boolean isInternal() {
		return false;
	}

	@Override
	public boolean isIterator() {
		return false;
	}

	@Override
	public boolean isLet() {
		return false;
	}

	@Override
	public boolean isNavigable() {
		return false;
	}

	@Override
	public boolean isNull() {
		return false;
	}

	@Override
	public boolean isOperation() {
		return false;
	}

	@Override
	public boolean isPattern() {
		return false;
	}

	@Override
	public boolean isTrue() {
		return false;
	}

	@Override
	public @NonNull NodeRole merge(@NonNull NodeRole nodeRole) {
		if (nodeRole == this) {
			return this;
		}
		throw new IllegalStateException(this + " cannot be merged with " + nodeRole);
	}

	@Override
	public @NonNull NodeRole resetHead() {
		if (!isHead()) {
			return this;
		}
		throw new IllegalStateException(this + " cannot be reset as a non-head");
	}

	@Override
	public @NonNull NodeRole setHead() {
		if (isHead()) {
			return this;
		}
		throw new IllegalStateException(this + " cannot be set as a head");
	}
}