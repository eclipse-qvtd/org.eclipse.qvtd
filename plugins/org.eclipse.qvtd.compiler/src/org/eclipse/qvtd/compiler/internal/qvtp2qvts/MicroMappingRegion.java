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
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import org.eclipse.jdt.annotation.NonNull;

/**
 * A MicroMappingRegion provides the partitioned QVTs node-edge graph representation of a QVTp mapping.
 * A MicroMappingRegion is created by the Partitioner to break a mapping into deadlock-free parts.
 */
public class MicroMappingRegion extends AbstractMappingRegion
{
	protected final @NonNull MappingRegion mappingRegion;
	private final @NonNull String namePrefix;
	private final @NonNull String symbolSuffix;

	public MicroMappingRegion(@NonNull MappingRegion mappingRegion, @NonNull String namePrefix, @NonNull String symbolSuffix) {
		super(mappingRegion.getMultiRegion());
		assert !(mappingRegion instanceof MicroMappingRegion);
		this.mappingRegion = mappingRegion;
		this.namePrefix = namePrefix;
		this.symbolSuffix = symbolSuffix;
	}

	@Override
	public @NonNull String getName() {
		return namePrefix + " " + mappingRegion.getName();
	}

	@Override
	protected @NonNull String getSymbolNameSuffix() {
		return symbolSuffix;
	}
}