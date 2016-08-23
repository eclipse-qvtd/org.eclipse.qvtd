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
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.AbstractRole;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.EdgeRole;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Role;

public class EdgeRoleImpl extends AbstractRole implements EdgeRole
{
	private static final @NonNull EdgeRole CONSTANT_EDGE = new EdgeRoleImpl(Role.Phase.CONSTANT);
	private static final @NonNull EdgeRole LOADED_EDGE = new EdgeRoleImpl(Role.Phase.LOADED);
	private static final @NonNull EdgeRole PREDICATED_EDGE = new EdgeRoleImpl(Role.Phase.PREDICATED);
	private static final @NonNull EdgeRole REALIZED_EDGE = new EdgeRoleImpl(Role.Phase.REALIZED);
	private static final @NonNull EdgeRole OTHER_EDGE = new EdgeRoleImpl(Role.Phase.OTHER);

	public static @NonNull EdgeRole getEdgeRole(Role.@NonNull Phase phase) {
		switch (phase) {
			case CONSTANT: return CONSTANT_EDGE;
			case LOADED: return LOADED_EDGE;
			case PREDICATED: return PREDICATED_EDGE;
			case REALIZED: return REALIZED_EDGE;
			case OTHER: return OTHER_EDGE;
		}
		throw new UnsupportedOperationException();
	}

	protected EdgeRoleImpl(@NonNull Phase phase) {
		super(phase);
	}
}