/**
 * This file was copied and re-packaged automatically by
 *     org.eclipse.qvtd.doc.miniocl.build.MiniOCLBuildEverything
 * from 
 *     ..\..\plugins\org.eclipse.qvtd.runtime\src\org\eclipse\qvtd\runtime\evaluation\AbstractSimpleInvocation.java
 *
 * Do not edit this file. 
 */
/*******************************************************************************
 * Copyright (c) 2018, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.doc.minioclcs.xtext.tx;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.qvtd.doc.minioclcs.xtext.internal.tx.AbstractInvocationInternal;

/**
 * Derivced AbstractSimpleInvocation instnaces support the non-failing pass functionality for mappings implemented by
 * a stateless function rather than a stateful object.
 */
public abstract class AbstractSimpleInvocation extends AbstractInvocationInternal
{
	protected final @NonNull String name;

	protected AbstractSimpleInvocation(@NonNull Interval interval, @NonNull String name) {
		super(interval);
		this.name = name;
		interval.queue(this);
	}

	@Override
	public <R> R accept(@NonNull ExecutionVisitor<R> visitor) {
		return visitor.visitInvocation(this);
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	@Override
	public boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues) {
		throw new IllegalStateException();			// SimpleInvocation should alwaysbe a simgleton
	}

	@Override
	public String toString() {
		return "«install»@" + interval.getIndex() + " " + name;
	}
}