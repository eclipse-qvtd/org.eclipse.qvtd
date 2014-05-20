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

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLCS2Pivot;

public class QVTrelationCS2Pivot extends EssentialOCLCS2Pivot
{	
	public QVTrelationCS2Pivot(@NonNull Map<? extends Resource, ? extends ASResource> cs2asResourceMap, @NonNull MetaModelManager metaModelManager) {
		super(cs2asResourceMap, metaModelManager);
	}

	@Override
	protected @NonNull QVTrelationCSContainmentVisitor createContainmentVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTrelationCSContainmentVisitor(converter);
	}

	@Override
	protected @NonNull QVTrelationCSLeft2RightVisitor createLeft2RightVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTrelationCSLeft2RightVisitor(converter);
	}

	@Override
	protected @NonNull QVTrelationCSPostOrderVisitor createPostOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTrelationCSPostOrderVisitor(converter);
	}

	@Override
	protected @NonNull QVTrelationCSPreOrderVisitor createPreOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTrelationCSPreOrderVisitor(converter);
	}
}
