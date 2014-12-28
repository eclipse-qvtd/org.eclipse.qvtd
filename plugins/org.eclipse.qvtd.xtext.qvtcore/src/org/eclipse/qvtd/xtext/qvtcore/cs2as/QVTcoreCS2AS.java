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
import org.eclipse.ocl.pivot.internal.manager.MetaModelManager;
import org.eclipse.ocl.pivot.internal.resource.ASResource;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.qvtd.xtext.qvtcorebase.cs2as.QVTcoreBaseCS2AS;

public class QVTcoreCS2AS extends QVTcoreBaseCS2AS
{	
	public QVTcoreCS2AS(@NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap, @NonNull MetaModelManager metaModelManager) {
		super(cs2asResourceMap, metaModelManager);
	}

	@Override
	protected @NonNull QVTcoreCSContainmentVisitor createContainmentVisitor(@NonNull CS2ASConversion converter) {
		return new QVTcoreCSContainmentVisitor(converter);
	}

	@Override
	protected @NonNull QVTcoreCSLeft2RightVisitor createLeft2RightVisitor(@NonNull CS2ASConversion converter) {
		return new QVTcoreCSLeft2RightVisitor(converter);
	}

	@Override
	protected @NonNull QVTcoreCSPostOrderVisitor createPostOrderVisitor(@NonNull CS2ASConversion converter) {
		return new QVTcoreCSPostOrderVisitor(converter);
	}

	@Override
	protected @NonNull QVTcoreCSPreOrderVisitor createPreOrderVisitor(@NonNull CS2ASConversion converter) {
		return new QVTcoreCSPreOrderVisitor(converter);
	}
}
