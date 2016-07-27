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

import java.util.Collections;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphStringBuilder;
import org.eclipse.qvtd.pivot.schedule.MappingAction;

public abstract class AbstractSimpleMappingRegion extends AbstractMappingRegion implements SimpleRegion
{
	protected AbstractSimpleMappingRegion(@NonNull MultiRegion multiRegion) {
		super(multiRegion);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitSimpleMappingRegion(this);
	}

	@Override
	public void addEdge(@NonNull Edge edge) {
		assert (basicGetSymbolName() == null) || !edge.isNavigation();
		super.addEdge(edge);
	}

	@Override
	protected void addHeadNode(@NonNull Node headNode) {
		assert basicGetSymbolName() == null;
		super.addHeadNode(headNode);
	}

	@Override
	public void addNode(@NonNull Node node) {
		assert basicGetSymbolName() == null;
		super.addNode(node);
	}

	@Override
	public @NonNull Iterable<@NonNull AbstractSimpleMappingRegion> getAllMappingRegions() {
		return Collections.singleton(this);
	}

	@Override
	public @NonNull String getColor() {
		return "green";
	}

	public abstract @NonNull Iterable<@NonNull MappingAction> getMappingActions();

	@Override
	public @NonNull Iterable<@NonNull AbstractMappingRegion> getMergeableRegions() {
		return Collections.singletonList(this);
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		s.setColor("palegreen");
		s.setPenwidth(Role.LINE_WIDTH);
		super.toGraph(s);
	}
}