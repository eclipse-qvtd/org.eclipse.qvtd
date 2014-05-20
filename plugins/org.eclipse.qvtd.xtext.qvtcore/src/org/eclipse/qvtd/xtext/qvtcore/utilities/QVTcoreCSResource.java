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
package org.eclipse.qvtd.xtext.qvtcore.utilities;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2Pivot;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.xtext.qvtcore.cs2as.QVTcoreCS2Pivot;

public class QVTcoreCSResource extends EssentialOCLCSResource
{
	@Override
	public @NonNull CS2Pivot createCS2Pivot(
			@NonNull Map<? extends Resource, ? extends ASResource> cs2asResourceMap,
			@NonNull MetaModelManager metaModelManager) {
		return new QVTcoreCS2Pivot(cs2asResourceMap, metaModelManager);
	}

	@Override
	public @NonNull String getASContentType() {
		return QVTcorePackage.eCONTENT_TYPE;
	}

	@Override
	@SuppressWarnings("null")
	public @NonNull URI getASURI(@NonNull URI csURI) {
		return URI.createURI(csURI.toString() + "as");
	}

	@Override
	public @NonNull String getEditorName() {
		return "QVT Core";
	}
}
