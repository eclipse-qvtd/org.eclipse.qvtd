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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

public class MergedMappingRegion extends AbstractMappingRegion
{
	/**
	 * The merged analyzed mappings.
	 */
	private final @NonNull List<@NonNull Mapping> mappings = new ArrayList<>();

	public MergedMappingRegion(@NonNull MappingRegion primaryRegion, @NonNull MappingRegion secondaryRegion) {
		super(primaryRegion.getMultiRegion());
		Iterables.addAll(mappings, primaryRegion.getMappings());
		Iterables.addAll(mappings, secondaryRegion.getMappings());
		assert Sets.newHashSet(mappings).size() == mappings.size();
	}

	@Override
	public @NonNull Iterable<@NonNull Mapping> getMappings() {
		return mappings;
	}

	@Override
	public @NonNull String getName() {
		List<@NonNull String> names = new ArrayList<>();
		for (@NonNull Mapping mapping : mappings) {
			names.add(ClassUtil.nonNullState(mapping.getName()));
		}
		Collections.sort(names);
		StringBuilder s = new StringBuilder();
		//		s.append(getClass().getSimpleName());
		for (String name : names) {
			if (s.length() > 0) {
				s.append("\\n");
			}
			s.append(name);
		}
		return s.toString();
	}
}