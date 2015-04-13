/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcorebase.analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;

/**
 * A DomainUsageVariable identifies a constrained domain result from the DomainUsageAnalysis of an OCL AST node.
 */
public class DomainUsageVariable extends AbstractDomainUsage
{
	protected final @NonNull List<Element> usedBy = new ArrayList<Element>();
	
	public DomainUsageVariable(@NonNull RootDomainUsageAnalysis rootAnalysis, long mask) {
		super(rootAnalysis, mask);
		assert mask != 0;
	}

	@Override
	public void addUsedBy(@NonNull Element element) {
		usedBy.add(element);
	}

	@Override
	public @Nullable Iterable<Element> getElements() {
		return usedBy;
	}

	@Override
	public String toString() {
		return "Variable " + rootAnalysis.toString(bitMask);
	}
}
