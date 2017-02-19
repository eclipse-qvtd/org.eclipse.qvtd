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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.impl.MultiRegionImpl;

/**
 * The MultiRegion supervises the many Region instances that realize a transformation.
 */
public class MultiRegion2 extends MultiRegionImpl
{
	protected final @NonNull QVTp2QVTs qvtp2qvts;

	public MultiRegion2(@NonNull QVTp2QVTs qvtp2qvts) {
		this.qvtp2qvts = qvtp2qvts;
	}

	//	@Override
	public @NonNull OperationRegion analyzeOperation(@NonNull OperationCallExp operationCallExp) {
		return qvtp2qvts.analyzeOperation(this, operationCallExp);
	}

	//	@Override
	public @NonNull MappingRegion getMappingRegion(@NonNull Mapping mapping) {
		return qvtp2qvts.getMappingRegion(mapping);
	}

	@Override
	public @NonNull QVTp2QVTs getSchedulerConstants() {
		return qvtp2qvts;
	}

	public @NonNull StandardLibrary getStandardLibrary() {
		return qvtp2qvts.getStandardLibrary();
	}
}
