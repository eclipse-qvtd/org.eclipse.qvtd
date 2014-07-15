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
package org.eclipse.qvtd.xtext.qvtcore.cs2as;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.resource.ASResource;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.qvtd.xtext.qvtcorebase.cs2as.QVTcoreBaseCS2Pivot;

public class QVTcoreCS2Pivot extends QVTcoreBaseCS2Pivot
{	
	public QVTcoreCS2Pivot(@NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap, @NonNull MetaModelManager metaModelManager) {
		super(cs2asResourceMap, metaModelManager);
	}

	@Override
	protected @NonNull QVTcoreCSContainmentVisitor createContainmentVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTcoreCSContainmentVisitor(converter);
	}

	@Override
	protected @NonNull QVTcoreCSLeft2RightVisitor createLeft2RightVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTcoreCSLeft2RightVisitor(converter);
	}

	@Override
	protected @NonNull QVTcoreCSPostOrderVisitor createPostOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTcoreCSPostOrderVisitor(converter);
	}

	@Override
	protected @NonNull QVTcoreCSPreOrderVisitor createPreOrderVisitor(@NonNull CS2PivotConversion converter) {
		return new QVTcoreCSPreOrderVisitor(converter);
	}
}
