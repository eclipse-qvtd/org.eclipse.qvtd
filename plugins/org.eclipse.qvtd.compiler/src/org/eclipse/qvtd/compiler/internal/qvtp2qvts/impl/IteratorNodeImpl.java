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
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NodeRole;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.VariableNode;

public class IteratorNodeImpl extends VariableNode
{
	/*	public static @NonNull PatternNodeImpl create(@NonNull NodeRole nodeRole, @NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis, boolean isMatched) {
		PatternNodeImpl node = new PatternNodeImpl();
		node.initialize(nodeRole, region, name, classDatumAnalysis);
		node.isMatched = isMatched;
		return node;
	} */

	public static @NonNull VariableNode create(@NonNull NodeRole nodeRole, @NonNull Region region, @NonNull VariableDeclaration variable) {
		IteratorNodeImpl node = new IteratorNodeImpl();
		node.initialize(nodeRole, region, variable);
		return node;
	}

	@Override
	public @NonNull VariableNode createNode(@NonNull NodeRole nodeRole, @NonNull Region region) {
		return create(nodeRole, region, getVariable());
	}

	@Override
	public boolean isExpression() {
		return true;
	}

	@Override
	public boolean isInternal() {
		return true;
	}

	@Override
	public boolean isIterator() {
		return true;
	}
}