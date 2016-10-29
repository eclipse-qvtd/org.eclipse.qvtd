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
import org.eclipse.qvtd.compiler.internal.utilities.SymbolNameBuilder;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;

/**
 * A MicroMappingRegion provides the partitioned QVTs node-edge graph representation of a QVTp mapping.
 * A MicroMappingRegion is created by the Partitioner to break a mapping into deadlock-free parts.
 */
public class MicroMappingRegion extends AbstractMappingRegion
{
	protected final @NonNull MappingRegion basicMappingRegion;
	private final @NonNull String prefix;
	private final @NonNull String suffix;

	public MicroMappingRegion(@NonNull MappingRegion basicMappingRegion, @NonNull String prefix, @NonNull String suffix) {
		super(basicMappingRegion.getMultiRegion());
		this.basicMappingRegion = basicMappingRegion;
		this.prefix = prefix;
		this.suffix = suffix;
	}

	@Override
	protected @NonNull SymbolNameBuilder computeSymbolName() {
		SymbolNameBuilder s = new SymbolNameBuilder(basicMappingRegion.getSymbolName());
		s.setSuffix(suffix);
		return s;
	}

	@Override
	public @NonNull Iterable<@NonNull Mapping> getMappings() {
		return basicMappingRegion.getMappings();
	}

	@Override
	public @NonNull String getName() {
		return prefix + "\\n" + basicMappingRegion.getName();
	}
}