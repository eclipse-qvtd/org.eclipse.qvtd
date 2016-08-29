/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
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
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.ClassDatumAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NodeRole;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Role;

public class UnknownNodeImpl extends NodeImpl
{
	public static @NonNull UnknownNodeImpl create(@NonNull NodeRole nodeRole, @NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		UnknownNodeImpl node = new UnknownNodeImpl();
		node.initialize(nodeRole, region, name, classDatumAnalysis);
		return node;
	}

	@Override
	public @NonNull Node createNode(@NonNull NodeRole nodeRole, @NonNull Region region) {
		return create(nodeRole, region, getName(), getClassDatumAnalysis());
	}

	@Override
	public @NonNull String getColor() {
		return Role.ERROR_COLOR;
	}
}