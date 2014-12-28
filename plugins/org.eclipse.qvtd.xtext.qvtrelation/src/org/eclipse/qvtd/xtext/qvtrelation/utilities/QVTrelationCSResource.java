/*******************************************************************************
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.utilities;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.xtext.qvtrelation.cs2as.QVTrelationCS2AS;

public class QVTrelationCSResource extends EssentialOCLCSResource
{
	@Override
	public @NonNull CS2AS createCS2AS(@NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap,
			@NonNull MetamodelManager metamodelManager) {
		return new QVTrelationCS2AS(cs2asResourceMap, metamodelManager);
	}

	@Override
	public @NonNull String getASContentType() {
		return QVTrelationPackage.eCONTENT_TYPE;
	}

	@Override
	@SuppressWarnings("null")
	public @NonNull URI getASURI(@NonNull URI csURI) {
		return URI.createURI(csURI.toString() + "as");
	}

	@Override
	public @NonNull String getEditorName() {
		return "QVT Relation";
	}
}
