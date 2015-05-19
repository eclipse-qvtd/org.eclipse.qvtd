/*******************************************************************************
 * Copyright (c) 2013 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcore.utilities;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;

public class QVTcoreUtil extends QVTcoreBaseUtil
{
	public static @NonNull Set<Mapping> getAllRefinedMappings(@NonNull Mapping mapping) {
		return getAllRefinedMappings(new HashSet<Mapping>(), mapping);
	}

	private static @NonNull Set<Mapping> getAllRefinedMappings(@NonNull Set<Mapping> allMappings, @NonNull Mapping mapping) {
		if (allMappings.add(mapping)) {
			for (@SuppressWarnings("null")@NonNull Mapping refinedMapping : mapping.getRefinement()) {
				getAllRefinedMappings(allMappings, refinedMapping);
			}
		}
		return allMappings;
	}
	public static @Nullable Mapping getContainingMapping(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Mapping) {
				return (Mapping) eObject;
			}
		}
		return null;
	}
}