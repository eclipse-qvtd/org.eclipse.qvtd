/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcore.utilities;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory.CreateStrategy;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;

public class QVTcoreUtil extends QVTcoreBaseUtil
{
	public static @NonNull Set<Mapping> getAllRefinedMappings(@NonNull Mapping mapping) {
		return getAllRefinedMappings(new HashSet<Mapping>(), mapping);
	}

	private static @NonNull Set<Mapping> getAllRefinedMappings(@NonNull Set<Mapping> allMappings, @NonNull Mapping mapping) {
		if (allMappings.add(mapping)) {
			for (@SuppressWarnings("null")@NonNull Mapping refinedMapping : mapping.getSpecification()) {
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

	public static @NonNull Transformation loadTransformation(@NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull URI transformationURI, boolean keepDebug) throws IOException {
		CreateStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTcEnvironmentFactory.CREATE_STRATEGY);
		try {
			return loadTransformation(CoreModel.class, environmentFactory, transformationURI, keepDebug);
		}
		finally {
			environmentFactory.setCreateStrategy(savedStrategy);
		}
	}

	public static @NonNull Resource loadTransformations(@NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull URI transformationURI, boolean keepDebug) throws IOException {
		CreateStrategy savedStrategy = environmentFactory.setCreateStrategy(QVTcEnvironmentFactory.CREATE_STRATEGY);
		try {
			return loadTransformations(CoreModel.class, environmentFactory, transformationURI, keepDebug);
		}
		finally {
			environmentFactory.setCreateStrategy(savedStrategy);
		}
	}
}