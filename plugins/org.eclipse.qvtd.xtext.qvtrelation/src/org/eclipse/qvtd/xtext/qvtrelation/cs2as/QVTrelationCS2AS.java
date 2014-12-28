/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.cs2as;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.internal.resource.ASResource;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.essentialocl.cs2as.EssentialOCLCS2AS;

public class QVTrelationCS2AS extends EssentialOCLCS2AS
{	
	public QVTrelationCS2AS(@NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap, @NonNull MetamodelManager metamodelManager) {
		super(cs2asResourceMap, metamodelManager);
	}

	@Override
	protected @NonNull QVTrelationCSContainmentVisitor createContainmentVisitor(@NonNull CS2ASConversion converter) {
		return new QVTrelationCSContainmentVisitor(converter);
	}

	@Override
	protected @NonNull QVTrelationCSLeft2RightVisitor createLeft2RightVisitor(@NonNull CS2ASConversion converter) {
		return new QVTrelationCSLeft2RightVisitor(converter);
	}

	@Override
	protected @NonNull QVTrelationCSPostOrderVisitor createPostOrderVisitor(@NonNull CS2ASConversion converter) {
		return new QVTrelationCSPostOrderVisitor(converter);
	}

	@Override
	protected @NonNull QVTrelationCSPreOrderVisitor createPreOrderVisitor(@NonNull CS2ASConversion converter) {
		return new QVTrelationCSPreOrderVisitor(converter);
	}
}
