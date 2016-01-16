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

public abstract class AbstractEdgeRole extends AbstractRole implements EdgeRole
{
	protected AbstractEdgeRole(@NonNull Phase phase) {
		super(phase);
	}

	@Override
	public @Nullable String getArrowhead() {
		return null;
	}

	@Override
	public @Nullable String getLabel() {
		return null;
	}

	@Override
	public @NonNull Integer getPenwidth() {
		return LINE_WIDTH;
	}

	@Override
	public @Nullable String getStyle() {
		return isNavigable() ? null : "dashed";
	}

	@Override
	public boolean isArgument() {
		return false;
	}

	@Override
	public boolean isCast() {
		return false;
	}

	@Override
	public boolean isComposition() {
		return false;
	}

	@Override
	public boolean isComputation() {
		return false;
	}

	@Override
	public boolean isMergeable() {
		return false;
	}

	@Override
	public boolean isNavigable() {
		return false;
	}

	@Override
	public boolean isNavigation() {
		return false;
	}

	@Override
	public boolean isRecursion() {
		return false;
	}

	@Override
	public boolean isResult() {
		return false;
	}
	
	@Override
	public @NonNull EdgeRole merge(@NonNull EdgeRole edgeRole) {
		throw new IllegalStateException(this + " cannot be merged with " + edgeRole);
	}
}