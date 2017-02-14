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
package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.AbstractCompilerProblem;
import org.eclipse.qvtd.pivot.qvtschedule.Region;

public class RegionProblem extends AbstractCompilerProblem
{
	protected final @NonNull Region region;
	protected final @NonNull String boundMessage;

	public RegionProblem(@NonNull Severity severity, @NonNull Region region, @NonNull String boundMessage) {
		super(severity);
		this.region = region;
		this.boundMessage = boundMessage;
	}

	@Override
	public @NonNull String toString() {
		return "RegionProblem for " + region.toString() + "\n\t" + boundMessage;
	}
}
