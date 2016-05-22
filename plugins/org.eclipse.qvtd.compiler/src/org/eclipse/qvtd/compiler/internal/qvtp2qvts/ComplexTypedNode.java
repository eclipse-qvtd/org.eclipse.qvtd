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
import org.eclipse.ocl.pivot.TypedElement;

public class ComplexTypedNode extends AbstractNode
{
	public ComplexTypedNode(@NonNull NodeRole nodeRole, @NonNull Region region, @NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		super(nodeRole, region, name, classDatumAnalysis);
	}

	@Override
	public @NonNull Iterable<@NonNull SimpleNode> getSimpleNodes() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Iterable<@NonNull TypedElement> getTypedElements() {
		return Collections.emptyList();
	}
	
//	public ComplexTypedNode(@NonNull NodeRole nodeRole, @NonNull SimpleRegion region, @NonNull String name, @NonNull TypedElement typedElement) {
//		super(nodeRole, region, name, region.getClassDatumAnalysis(typedElement));
//		addTypedElement(typedElement);
//	}

//	@Override
//	public void cloneIn(@NonNull Region region, @NonNull Map<Node, Node> node2clone) {
//		node2clone.put(this, new SimpleTypedNode(getNodeRole(), (SimpleRegion) region, name, getClassDatumAnalysis()));
//	}
}