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
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NodeRole;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.RegionUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Role;

public class NodeRoleImpl extends AbstractRoleImpl implements NodeRole
{
	private static final @NonNull NodeRole CONSTANT_NODE = new NodeRoleImpl(Role.Phase.CONSTANT);
	private static final @NonNull NodeRole LOADED_NODE = new NodeRoleImpl(Role.Phase.LOADED);
	private static final @NonNull NodeRole PREDICATED_NODE = new NodeRoleImpl(Role.Phase.PREDICATED);
	private static final @NonNull NodeRole REALIZED_NODE = new NodeRoleImpl(Role.Phase.REALIZED);
	private static final @NonNull NodeRole SPECULATED_NODE = new NodeRoleImpl(Role.Phase.SPECULATED);
	private static final @NonNull NodeRole SPECULATION_NODE = new NodeRoleImpl(Role.Phase.SPECULATION);
	private static final @NonNull NodeRole OTHER_NODE = new NodeRoleImpl(Role.Phase.OTHER);

	public static @NonNull NodeRole getNodeRole(Role.@NonNull Phase phase) {
		switch (phase) {
			case CONSTANT: return CONSTANT_NODE;
			case LOADED: return LOADED_NODE;
			case PREDICATED: return PREDICATED_NODE;
			case REALIZED: return REALIZED_NODE;
			case SPECULATED: return SPECULATED_NODE;
			case SPECULATION: return SPECULATION_NODE;
			case OTHER: return OTHER_NODE;
		}
		throw new UnsupportedOperationException();
	}

	protected NodeRoleImpl(@NonNull Phase phase) {
		super(phase);
	}

	@Override
	public @NonNull NodeRole asPhase(@NonNull Phase phase) {
		return getNodeRole(phase);
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
	public @NonNull NodeRole merge(@NonNull NodeRole nodeRole) {
		Phase mergedPhase = RegionUtil.mergeToMoreKnownPhase(this, nodeRole).getPhase();
		return getNodeRole(mergedPhase);
	}
}