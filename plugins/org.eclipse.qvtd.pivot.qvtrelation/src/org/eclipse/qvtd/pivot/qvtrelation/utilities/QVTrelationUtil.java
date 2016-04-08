/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;

public class QVTrelationUtil extends QVTbaseUtil
{
	public static final @NonNull String DUMMY_VARIABLE_NAME = "_";
	
	public static @NonNull List<Variable> getRootVariables(@NonNull Relation relation) {
		List<Variable> rootVariables = new ArrayList<Variable>();
		for (Domain domain : relation.getDomain()) {
			if (domain instanceof RelationDomain) {
				rootVariables.addAll(((RelationDomain)domain).getRootVariable());
			}
		}
		return rootVariables;
	}

	public static @NonNull Transformation loadTransformation(@NonNull EnvironmentFactory environmentFactory, @NonNull URI transformationURI, boolean keepDebug) throws IOException {
		return loadTransformation(RelationModel.class, environmentFactory, transformationURI, keepDebug);
	}

	public static @NonNull Resource loadTransformations(@NonNull EnvironmentFactory environmentFactory, @NonNull URI transformationURI, boolean keepDebug) throws IOException {
		return loadTransformations(RelationModel.class, environmentFactory, transformationURI, keepDebug);
	}
}