/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.umlx.labels;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.labels.AbstractLabelGenerator;
import org.eclipse.qvtd.umlx.UMLXModel;

public final class UMLXModelLabelGenerator extends AbstractLabelGenerator<@NonNull UMLXModel>
{
	public static void initialize(@NonNull Registry registry) {
		registry.install(UMLXModel.class, new UMLXModelLabelGenerator());
	}

	public UMLXModelLabelGenerator() {
		super(UMLXModel.class);
	}

	@Override
	public void buildLabelFor(@NonNull Builder labelBuilder, @NonNull UMLXModel object) {
		Resource eResource = object.eResource();
		labelBuilder.appendString(eResource != null ? String.valueOf(eResource.getURI()) : null);
	}
}