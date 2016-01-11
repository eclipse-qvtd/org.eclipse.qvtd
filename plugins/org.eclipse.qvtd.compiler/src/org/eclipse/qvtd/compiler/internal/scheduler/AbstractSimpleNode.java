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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TypedElement;

import com.google.common.collect.Iterables;

public abstract class AbstractSimpleNode extends AbstractNode implements SimpleNode
{
	private final @NonNull List<TypedElement> typedElements = new ArrayList<TypedElement>();

	protected AbstractSimpleNode(@NonNull NodeRole nodeRole, @NonNull SimpleRegion region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		super(nodeRole, region, name, classDatumAnalysis);
	}

	@Override
	public void addTypedElement(@NonNull TypedElement typedElement) {
		boolean wasAdded = typedElements.add(typedElement);
		assert wasAdded;
	}

	@Override
	public final @NonNull Iterable<SimpleNavigationEdge> getCastEdges() {
		@SuppressWarnings({"null", "unchecked"})
		@NonNull Iterable<SimpleNavigationEdge> filter = (Iterable<SimpleNavigationEdge>)(Object)Iterables.filter(getOutgoingEdges(), AbstractRegion.IsCastEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @Nullable SimpleNavigationEdge getNavigationEdge(@NonNull Property source2targetProperty) {
		return (SimpleNavigationEdge) super.getNavigationEdge(source2targetProperty);
	}

	@Override
	public @Nullable SimpleNode getNavigationTarget(@NonNull Property source2targetProperty) {
		return (SimpleNode) super.getNavigationTarget(source2targetProperty);
	}

	@Override
	public final @Nullable SimpleEdge getPredicateEdge(@NonNull Property source2targetProperty) {
		for (Edge edge : getOutgoingEdges()) {
			if (edge.isPredicated() && (edge instanceof NavigationEdge) && (edge instanceof SimpleEdge)) {
				if (((NavigationEdge)edge).getProperty() == source2targetProperty) {
					return (SimpleEdge) edge;
				}
			}
		}
		return null;
	}

	@Override
	public @NonNull SimpleRegion getRegion() {
		return (SimpleRegion) region;
	}

	@Override
	public final @NonNull Iterable<? extends SimpleEdge> getResultEdges() {
		@SuppressWarnings({"null", "unchecked"})
		@NonNull Iterable<SimpleEdge> filter = (Iterable<SimpleEdge>)(Object)Iterables.filter(getOutgoingEdges(), AbstractRegion.IsExpressionEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @NonNull Iterable<SimpleNode> getSimpleNodes() {
		return this;
	}

	@Override
	public Iterator<SimpleNode> iterator() {
		return new SingletonIterator<SimpleNode>(this);
	}

	@Override
	public @NonNull Iterable<TypedElement> getTypedElements() {
		return typedElements;
	}
}