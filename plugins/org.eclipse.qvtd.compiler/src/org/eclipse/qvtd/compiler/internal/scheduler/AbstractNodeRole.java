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

public abstract class AbstractNodeRole extends AbstractRole implements NodeRole
{
	protected AbstractNodeRole(@NonNull Phase phase) {
		super(phase);
	}

	@Override
	public @NonNull Integer getPenwidth() {
		return isHead() /*&& !isResult()*/ ? HEAD_WIDTH : isGuardVariable() ? GUARD_WIDTH : LINE_WIDTH;
	}

	@Override
	public @Nullable String getShape() {
		return null;
	}

	@Override
	public @Nullable String getStyle() {
		return isNavigable() || isRealized() || isHead() ? null : "dashed";
	}

	@Override
	public boolean isAttributeNode() {
		return false;
	}

	@Override
	public boolean isClassNode() {
		return false;
	}

	@Override
	public boolean isComposed() {
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
	public boolean isGuardVariable() {
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
	public boolean isMatchable() {
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
	public boolean isRealizedVariable() {
		return false;
	}

	@Override
	public boolean isResult() {
		return false;
	}

	@Override
	public boolean isTrue() {
		return false;
	}
	
	@Override
	public @NonNull NodeRole merge(@NonNull NodeRole nodeRole) {
		throw new IllegalStateException(this + " cannot be merged with " + nodeRole);
	}

	@Override
	public @NonNull NodeRole setHead() {
		if (isHead()) {
			return this;
		}
		throw new IllegalStateException(this + " cannot be set as a head");
	}
}