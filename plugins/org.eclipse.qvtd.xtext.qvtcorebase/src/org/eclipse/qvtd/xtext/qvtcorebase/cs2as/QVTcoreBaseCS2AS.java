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
package org.eclipse.qvtd.xtext.qvtcorebase.cs2as;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.manager.MetaModelManager;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.essentialocl.cs2as.EssentialOCLCS2AS;

public class QVTcoreBaseCS2AS extends EssentialOCLCS2AS
{	
	public QVTcoreBaseCS2AS(@NonNull Map<? extends BaseCSResource, ? extends ASResource> cs2asResourceMap, @NonNull MetaModelManager metaModelManager) {
		super(cs2asResourceMap, metaModelManager);
	}

	@Override
	protected @NonNull QVTcoreBaseCSContainmentVisitor createContainmentVisitor(@NonNull CS2ASConversion converter) {
		return new QVTcoreBaseCSContainmentVisitor(converter);
	}

	@Override
	protected @NonNull QVTcoreBaseCSLeft2RightVisitor createLeft2RightVisitor(@NonNull CS2ASConversion converter) {
		return new QVTcoreBaseCSLeft2RightVisitor(converter);
	}

	@Override
	protected @NonNull QVTcoreBaseCSPostOrderVisitor createPostOrderVisitor(@NonNull CS2ASConversion converter) {
		return new QVTcoreBaseCSPostOrderVisitor(converter);
	}

	@Override
	protected @NonNull QVTcoreBaseCSPreOrderVisitor createPreOrderVisitor(@NonNull CS2ASConversion converter) {
		return new QVTcoreBaseCSPreOrderVisitor(converter);
	}
}
