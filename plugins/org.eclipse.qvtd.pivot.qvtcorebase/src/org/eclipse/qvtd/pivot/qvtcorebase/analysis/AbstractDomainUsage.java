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
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

public abstract class AbstractDomainUsage implements DomainUsage
{
	protected final @NonNull RootDomainUsageAnalysis rootAnalysis;
	protected final long bitMask;
	
	protected AbstractDomainUsage(@NonNull RootDomainUsageAnalysis rootAnalysis, long bitMask) {
		this.rootAnalysis = rootAnalysis;
		this.bitMask = bitMask;
	}

	@Override
	public void addUsedBy(@NonNull Element element) {}


	@Override
	public int compareTo(DomainUsage o) {
		return Long.compare(getMask(), o.getMask());
	}

	@Override
	public @Nullable Iterable<Element> getElements() {
		return null;
	}

	@Override
	public long getMask() {
		return bitMask;
	}

	@Override
	public @Nullable TypedModel getTypedModel() throws IllegalStateException {
		long residue = bitMask;
		for (int i = 0; residue != 0; i++) {
			long bit = 1L << i;
			if ((residue & bit) != 0) {
				residue &= ~bit;
				if (residue == 0) {
					return rootAnalysis.getTypedModel(i);
				}
				throw new IllegalStateException("Amiguous TypedModel: " + this);
			}
		}
		return null;
	}

	@Override
	public @NonNull Iterable<TypedModel> getTypedModels() {
		List<TypedModel> typedModels = new ArrayList<TypedModel>();
		long residue = bitMask;
		for (int i = 0; residue != 0; i++) {
			long bit = 1L << i;
			if ((residue & bit) != 0) {
				residue &= ~bit;
				typedModels.add(rootAnalysis.getTypedModel(i));
			}
		}
		return typedModels;
	}
}
