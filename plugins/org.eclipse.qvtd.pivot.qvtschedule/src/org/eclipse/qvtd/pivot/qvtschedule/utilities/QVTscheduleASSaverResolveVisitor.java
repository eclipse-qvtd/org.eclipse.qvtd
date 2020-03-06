/*******************************************************************************
 * Copyright (c) 2017, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtschedule.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.util.AbstractQVTscheduleASSaverResolveVisitor;

public class QVTscheduleASSaverResolveVisitor extends AbstractQVTscheduleASSaverResolveVisitor
{
	public QVTscheduleASSaverResolveVisitor(@NonNull ASSaver context) {
		super(context);
	}

	@Override
	public @Nullable Object visitClassDatum(@NonNull ClassDatum object) {
		org.eclipse.ocl.pivot.Class referredClass = ClassUtil.nonNullState(object.getReferredClass());
		org.eclipse.ocl.pivot.Class resolvedClass = context.resolveType(referredClass);
		if (resolvedClass != referredClass) {
			object.setReferredClass(resolvedClass);
		}
		return null;
	}
}
