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
package org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Role;

public abstract class AbstractRoleImpl implements Role
{
	protected final Role.@NonNull Phase phase;

	protected AbstractRoleImpl(@NonNull Phase phase) {
		this.phase = phase;
	}

	@Override
	public int compareTo(Role o) {
		return phase.compareTo(o.getPhase());
	}

	@Override
	public final @NonNull String getColor() {
		switch (phase) {
			case CONSTANT: return CONSTANT_COLOR;
			case LOADED: return LOADED_COLOR;
			case PREDICATED: return PREDICATED_COLOR;
			case REALIZED: return REALIZED_COLOR;
			case SPECULATION: return SPECULATION_COLOR;
			case SPECULATED: return SPECULATED_COLOR;
			default: return OTHER_COLOR;
		}
	}

	@Override
	public @NonNull Phase getPhase() {
		return phase;
	}

	@Override
	public final boolean isConstant() {
		return phase == Phase.CONSTANT;
	}

	@Override
	public final boolean isLoaded() {
		return phase == Phase.LOADED;
	}

	@Override
	public final boolean isNew() {
		return (phase == Phase.SPECULATION) || (phase == Phase.REALIZED);
	}

	@Override
	public final boolean isOld() {
		return (phase == Phase.CONSTANT) || (phase == Phase.LOADED) || (phase == Phase.PREDICATED) || (phase == Phase.SPECULATED);
	}

	@Override
	public final boolean isPredicated() {
		return phase == Phase.PREDICATED;
	}

	@Override
	public final boolean isRealized() {
		return phase == Phase.REALIZED;
	}

	@Override
	public final boolean isSpeculated() {
		return phase == Phase.SPECULATED;
	}

	@Override
	public final boolean isSpeculation() {
		return phase == Phase.SPECULATION;
	}

	@Override
	public String toString() {
		return phase + "-" + getClass().getSimpleName();
	}
}