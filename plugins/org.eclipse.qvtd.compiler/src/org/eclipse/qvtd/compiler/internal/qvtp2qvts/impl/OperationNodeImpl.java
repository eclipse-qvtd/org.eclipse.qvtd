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
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ClassDatumAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.NodeRole;

public class OperationNodeImpl extends NodeImpl
{
	public static @NonNull OperationNodeImpl create(@NonNull NodeRole nodeRole, @NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis, boolean isMatched) {
		OperationNodeImpl node = new OperationNodeImpl();
		node.initialize(nodeRole, region, name, classDatumAnalysis);
		node.isMatched = isMatched;
		return node;
	}

	private boolean isMatched;

	@Override
	public @NonNull Node createNode(@NonNull NodeRole nodeRole, @NonNull Region region) {
		return create(nodeRole, region, getName(), getClassDatumAnalysis(), isMatched);
	}

	@Override
	public @NonNull String getShape() {
		return "ellipse";
	}

	@Override
	public boolean isExpression() {
		return true;
	}

	@Override
	public boolean isMatched() {
		return isMatched;
	}

	@Override
	public boolean isOperation() {
		return true;
	}
}