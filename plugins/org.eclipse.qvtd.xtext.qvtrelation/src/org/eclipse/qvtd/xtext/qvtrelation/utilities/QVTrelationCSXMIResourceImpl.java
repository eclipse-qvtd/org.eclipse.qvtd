/*******************************************************************************
 * Copyright (c) 2024 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.utilities;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.utilities.BaseCSXMIResourceImpl;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationASResourceFactory;
import org.eclipse.qvtd.xtext.qvtrelation.cs2as.QVTrelationCS2AS;

/**
 * The QVTrelationCSXMIResourceImpl implementation of BaseCSResource that ensures that loading resolves references to CS/ES elements
 * to equivalent AS references and conversely ensures that saving replaces AS references by CS/ES references.
 */
public class QVTrelationCSXMIResourceImpl extends BaseCSXMIResourceImpl
{
	/**
	 * Creates an instance of the resource.
	 */
	protected QVTrelationCSXMIResourceImpl(@NonNull URI uri) {
		super(uri, QVTrelationASResourceFactory.getInstance());
	}

	@Override
	public @NonNull CS2AS createCS2AS(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull ASResource asResource) {
		return new QVTrelationCS2AS(environmentFactory, this, asResource);
	}
}
