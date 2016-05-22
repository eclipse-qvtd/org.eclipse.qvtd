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
	private final @NonNull List<@NonNull TypedElement> typedElements = new ArrayList<@NonNull TypedElement>();

	protected AbstractSimpleNode(@NonNull NodeRole nodeRole, @NonNull SimpleRegion region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		super(nodeRole, region, name, classDatumAnalysis);
	}

	@Override
	public void addTypedElement(@NonNull TypedElement typedElement) {
		boolean wasAdded = typedElements.add(typedElement);
		assert wasAdded;
	}

	@Override
	public final @NonNull Iterable<@NonNull SimpleNavigationEdge> getCastEdges() {
		@SuppressWarnings("unchecked")
		@NonNull Iterable<@NonNull SimpleNavigationEdge> filter = (Iterable<@NonNull SimpleNavigationEdge>)(Object)Iterables.filter(getOutgoingEdges(), AbstractRegion.IsCastEdgePredicate.INSTANCE);
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
	public final @NonNull Iterable<@NonNull ? extends SimpleEdge> getResultEdges() {
		@SuppressWarnings("unchecked")
		@NonNull Iterable<@NonNull SimpleEdge> filter = (Iterable<@NonNull SimpleEdge>)(Object)Iterables.filter(getOutgoingEdges(), AbstractRegion.IsExpressionEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @NonNull Iterable<@NonNull SimpleNode> getSimpleNodes() {
		return this;
	}

	@Override
	public @NonNull Iterator<@NonNull SimpleNode> iterator() {
		return new SingletonIterator<@NonNull SimpleNode>(this);
	}

	@Override
	public @NonNull Iterable<@NonNull TypedElement> getTypedElements() {
		return typedElements;
	}
}