/*******************************************************************************
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcore.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.PivotHelper;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.essentialocl.cs2as.EssentialOCLCS2AS;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreHelper;

public class QVTcoreCS2AS extends EssentialOCLCS2AS
{
	public QVTcoreCS2AS(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull BaseCSResource csResource, @NonNull ASResource asResource) {
		super(environmentFactory, csResource, asResource);
	}

	@Override
	protected @NonNull QVTcoreCSContainmentVisitor createContainmentVisitor(@NonNull CS2ASConversion converter) {
		return new QVTcoreCSContainmentVisitor(converter);
	}

	@Override
	protected @NonNull PivotHelper createHelper() {
		return new QVTcoreHelper(environmentFactory);
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
